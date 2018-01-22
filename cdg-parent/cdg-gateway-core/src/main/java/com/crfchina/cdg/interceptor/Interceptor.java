package com.crfchina.cdg.interceptor;

import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import rsautil.RSAUtils;

import com.alibaba.fastjson.JSONObject;
import com.crfchina.cdg.common.exception.CdgException;
import com.crfchina.cdg.common.exception.CdgExceptionCode;
import com.crfchina.cdg.core.controller.AccountController;
import com.crfchina.cdg.core.service.LmCacheService;


/**
 * AOP全局拦截器
 * 拦截所有进入controller方法的请求
 * @author Administrator
 *
 */


@Aspect
@Component
public class Interceptor {

	public static final Logger logger = LoggerFactory
			.getLogger(Interceptor.class);

	@Autowired
	LmCacheService cachesrv;
	
	
	 @Value("${noSign.list}")  
	  private String noSignList;    
	
	/**
	 * 配置拦截方法的包名
	 */
	@Pointcut("execution(public * com.crfchina.cdg.core.controller.*.*(..))")
	public void cgdMethod() {
	}

	@Before("cgdMethod()")
	public void before(JoinPoint jp) {
	}

	@After(value="cgdMethod()" ,argNames = "jp")
	public void after(JoinPoint jp) {
	}

	@AfterReturning(value="cgdMethod()" , returning = "result")
	public void afterRt(JoinPoint jp, String result) {
		//记录返回日志
		RequestAttributes ra = RequestContextHolder.getRequestAttributes();
		ServletRequestAttributes sra = (ServletRequestAttributes) ra;
		HttpServletRequest request = sra.getRequest();
		String url = request.getRequestURL().toString();
		String requestMethod = request.getMethod();
		logger.info("结果返回,参数信息: url:{}, method:{}, params:{}", url, requestMethod,result );
	}
	
	
	@AfterThrowing(value="cgdMethod()", throwing = "result"  )
	public void afterThrowing(JoinPoint jp, String result) {
		//记录返回日志
		RequestAttributes ra = RequestContextHolder.getRequestAttributes();
	    ServletRequestAttributes sra = (ServletRequestAttributes) ra;
	    HttpServletRequest request = sra.getRequest();
	    String url = request.getRequestURL().toString();
	    String requestMethod = request.getMethod();
		logger.info("结果返回,参数信息: url:{}, method:{}, params:{}", url, requestMethod,result );

	}
	
	
	@Around("cgdMethod()")
	public Object interceptor(ProceedingJoinPoint pjp) throws Throwable {
		MethodSignature signature = (MethodSignature) pjp.getSignature();
		Method method = signature.getMethod(); // 获取被拦截的方法
		String methodName = method.getName(); // 获取被拦截的方法名
		
        Object[] args =pjp.getArgs(); // 所拦截到的方法的所有参数

        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) ra;
        HttpServletRequest request = sra.getRequest();

        String url = request.getRequestURL().toString();
        String requestMethod = request.getMethod();
//        String uri = request.getRequestURI();
        String queryString = request.getQueryString();
    	//如果是页面回调请求，直接通过
        if(noSignList.contains(methodName)){
			logger.info("接口请求,参数信息: url:{}, method:{}", url, requestMethod);
        	return pjp.proceed();
        }
        //获取参数
        Enumeration<String> parameterNames = request.getParameterNames();
		HashMap<String,String> paramObj = new HashMap<String,String>();
		while (parameterNames.hasMoreElements()) {
			String key = parameterNames.nextElement();
			String value = request.getParameter(key);
			if (!StringUtils.isBlank(value)) {
				paramObj.put(key, value);
				queryString=key+"="+value+","+queryString;
			}
		}
		if(StringUtils.isEmpty(paramObj.get("systemNo"))
				||StringUtils.isEmpty(paramObj.get("reqData"))
				||StringUtils.isEmpty(paramObj.get("sign"))){
			throw new CdgException(CdgExceptionCode.CDG10002);
		}
		String sysNo = paramObj.get("systemNo"); //系统编号
		String reqData = paramObj.get("reqData");//请求报文
		String sign = paramObj.get("sign"); //签名
		//验签名
		//get SysKey and Sand by SystemNo
		String sand = cachesrv.getSysSand(sysNo);
		String privatekey = cachesrv.getSysPriKey(sysNo);
		//验证签名
		String checkSign = RSAUtils.getSHA256StrJava(sysNo+reqData+sand);
		if(sign.equals(checkSign)){
			byte []jiemistr = RSAUtils.decryptByPrivateKey(reqData, privatekey);
			args[0] = new String(jiemistr,"UTF-8");
			//TODO 打印日志
			logger.info("接口请求,参数信息: url:{}, method:{}, params:{}", url, requestMethod,new String(jiemistr,"UTF-8") );
		}else {
			throw new CdgException(CdgExceptionCode.CDG10021);
		}
		try {
			Object obj = pjp.proceed(args);
			return obj;
		} catch (CdgException e) {
			 throw e;
		}
	}
	
}
