懒猫存管服务系统架构示意：


    cdg-parent懒猫存管父工程
        cdg-common:公共资源类
        cdg-service:Dubbo 对外暴露接口声明
        cdg-base-db:DB文件存放、以及Dao层定义
        cdg-api-core:懒猫存管直连交易-子服务
        cdg-gateway-core:懒猫存管网关交易-子服务
        cdg-notify:懒猫存管异步通知子服务
        cdg-recon-task:懒猫存管对账子服务
    



