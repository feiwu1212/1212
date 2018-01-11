SET SESSION FOREIGN_KEY_CHECKS=0;

/* Drop Indexes */

DROP INDEX inx_bindcard_flowinfo ON lm_bind_card_flowinfo;



/* Drop Tables */

DROP TABLE bank_info;
DROP TABLE lm_bind_card_flowinfo;
DROP TABLE lm_bind_card_list;
DROP TABLE lm_change_cardmobile_flowinfo;
DROP TABLE lm_project_auth_list;
DROP TABLE lm_project_flowinfo;
DROP TABLE lm_project_list;
DROP TABLE lm_user_operation_flowinfo;
DROP TABLE lm_vaccount_notify_txtp;
DROP TABLE lm_vaccount_transfer_batch;
DROP TABLE lm_vaccount_transfer_detail;
DROP TABLE lm_vaccount_transfer_info;
DROP TABLE system_config;
DROP TABLE system_status_code;
DROP TABLE system_status_code_metadata;




/* Create Tables */

CREATE TABLE bank_info
(
	id bigint(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
	bank_code varchar(20) COMMENT '银行编码',
	bank_name varchar(50) COMMENT '银行名称',
	lm_bank_code varchar(20) COMMENT '懒猫存管银行code',
	fuiou_bank_code varchar(20) COMMENT '富友银行编码',
	logo_url varchar(100) COMMENT '银行LogoUrl',
	create_time datetime COMMENT '创建时间',
	update_time datetime COMMENT '更新时间',
	PRIMARY KEY (id)
) COMMENT = '银行编码配置表';


CREATE TABLE lm_bind_card_flowinfo
(
	id bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
	fcp_trx_no varchar(50) COMMENT '对外交易流水号',
	request_ref_no varchar(50) COMMENT '请求参考号',
	request_time datetime COMMENT '请求时间',
	system_no varchar(20) COMMENT '系统编号',
	platform_user_id varchar(50) COMMENT '平台用户ID',
	user_real_name varchar(50) COMMENT '用户姓名',
	bankcard_no varchar(30) COMMENT '银行卡号',
	-- 统一银行编码； 如：农行 ABC,建行ICBC
	bank_code varchar(20) COMMENT '银行编码 : 统一银行编码； 如：农行 ABC,建行ICBC',
	mobile varchar(20) COMMENT '银行预留手机号',
	id_no varchar(20) COMMENT '证件号',
	-- [1 身份证 2 护照 3 港澳台通行证 4 外国人永久居住证 9其他]
	id_type tinyint(2) COMMENT '证件类型 : [1 身份证 2 护照 3 港澳台通行证 4 外国人永久居住证 9其他]',
	bindcard_time datetime COMMENT '绑卡时间',
	-- [
	-- GUARANTEECORP 担保机构INVESTOR 投资人BORROWERS 借款人COLLABORATOR 合作机构SUPPLIER 供应商PLATFORM_MARKETING 平台营销款账户PLATFORM_PROFIT 平台分润账户PLATFORM_INCOME 平台收入账户PLATFORM_INTEREST 平台派息账户PLATFORM_ALTERNATIVE_RECHARGE 平台代充值账户PLATFORM_FUNDS_TRANSFER 平台总账户 PLATFORM_URGENT 垫资账户
	-- ]
	user_role varchar(30) COMMENT '用户角色 : [
GUARANTEECORP 担保机构INVESTOR 投资人BORROWERS 借款人COLLABORATOR 合作机构SUPPLIER 供应商PLATFORM_MARKETING 平台营销款账户PLATFORM_PROFIT 平台分润账户PLATFORM_INCOME 平台收入账户PLATFORM_INTEREST 平台派息账户PLATFORM_ALTERNATIVE_RECHARGE 平台代充值账户PLATFORM_FUNDS_TRANSFER 平台总账户 PL',
	-- 多个以,分割
	-- TENDER 自动投标REPAYMENT 自动还款CREDIT_ASSIGNMENT 自动债权认购COMPENSATORY 自动代偿WITHDRAW 自动提现RECHARGE  自动充值
	auth_list varchar(100) COMMENT '用户授权组 : 多个以,分割
TENDER 自动投标REPAYMENT 自动还款CREDIT_ASSIGNMENT 自动债权认购COMPENSATORY 自动代偿WITHDRAW 自动提现RECHARGE  自动充值',
	-- 1：四要素鉴权（对外：LIMIT）
	-- 2：三要素鉴权
	check_type tinyint(1) DEFAULT 1 COMMENT '鉴权类型 : 1：四要素鉴权（对外：LIMIT）
2：三要素鉴权',
	-- 对外默认填： ID_CARD_NO_UNIQUE
	user_limit_type tinyint(1) DEFAULT 1 COMMENT '验证身份证唯一性 : 对外默认填： ID_CARD_NO_UNIQUE',
	-- 1: 四要素验证通过2: 未鉴权3: 特殊用户认证4: 企业用户认证
	access_type tinyint(1) COMMENT '鉴权通过类型 : 1: 四要素验证通过2: 未鉴权3: 特殊用户认证4: 企业用户认证',
	-- 1: 审核中2:审核通过3: 审核回退4:审核拒绝
	audit_status tinyint(1) COMMENT '审核状态 : 1: 审核中2:审核通过3: 审核回退4:审核拒绝',
	callback_url varchar(200) COMMENT '回调地址',
	notify_url varchar(200) COMMENT '异步通知地址',
	-- SUCCESS为确认成功，FAIL为确认失败, UNKNOW未知, ACCEPTED受理成功
	result varchar(30) COMMENT '开户结果 : SUCCESS为确认成功，FAIL为确认失败, UNKNOW未知, ACCEPTED受理成功',
	fail_code varchar(30) COMMENT '错误码',
	fail_reason varchar(100) COMMENT '失败原因',
	finish_time datetime COMMENT '开户完成时间',
	create_time datetime COMMENT '创建时间',
	update_time datetime COMMENT '更新时间',
	partition_date int(6) NOT NULL COMMENT '分区信息列，request time的年*100+月',
	PRIMARY KEY (id)
) COMMENT = '懒猫绑卡流水表';


CREATE TABLE lm_bind_card_list
(
	id bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
	platform_user_id varchar(50) COMMENT '平台用户ID',
	user_real_name varchar(50) COMMENT '用户姓名',
	bankcard_no varchar(30) COMMENT '银行卡号',
	-- 统一银行编码； 如：农行 ABC,建行ICBC
	bank_code varchar(20) COMMENT '银行编码 : 统一银行编码； 如：农行 ABC,建行ICBC',
	mobile varchar(20) COMMENT '银行预留手机号',
	id_no varchar(20) COMMENT '证件号',
	-- [1 身份证 2 护照 3 港澳台通行证 4 外国人永久居住证 9其他]
	id_type tinyint(2) COMMENT '证件类型 : [1 身份证 2 护照 3 港澳台通行证 4 外国人永久居住证 9其他]',
	bindcard_time datetime COMMENT '绑卡时间',
	-- [
	-- GUARANTEECORP 担保机构INVESTOR 投资人BORROWERS 借款人COLLABORATOR 合作机构SUPPLIER 供应商PLATFORM_MARKETING 平台营销款账户PLATFORM_PROFIT 平台分润账户PLATFORM_INCOME 平台收入账户PLATFORM_INTEREST 平台派息账户PLATFORM_ALTERNATIVE_RECHARGE 平台代充值账户PLATFORM_FUNDS_TRANSFER 平台总账户 PLATFORM_URGENT 垫资账户
	-- ]
	user_role varchar(30) COMMENT '用户角色 : [
GUARANTEECORP 担保机构INVESTOR 投资人BORROWERS 借款人COLLABORATOR 合作机构SUPPLIER 供应商PLATFORM_MARKETING 平台营销款账户PLATFORM_PROFIT 平台分润账户PLATFORM_INCOME 平台收入账户PLATFORM_INTEREST 平台派息账户PLATFORM_ALTERNATIVE_RECHARGE 平台代充值账户PLATFORM_FUNDS_TRANSFER 平台总账户 PL',
	-- 多个以,分割
	-- TENDER 自动投标REPAYMENT 自动还款CREDIT_ASSIGNMENT 自动债权认购COMPENSATORY 自动代偿WITHDRAW 自动提现RECHARGE  自动充值
	auth_list varchar(100) COMMENT '用户授权组 : 多个以,分割
TENDER 自动投标REPAYMENT 自动还款CREDIT_ASSIGNMENT 自动债权认购COMPENSATORY 自动代偿WITHDRAW 自动提现RECHARGE  自动充值',
	-- 1：四要素鉴权（对外：LIMIT）
	-- 2：三要素鉴权
	check_type tinyint(1) DEFAULT 1 COMMENT '鉴权类型 : 1：四要素鉴权（对外：LIMIT）
2：三要素鉴权',
	-- 对外默认填： ID_CARD_NO_UNIQUE
	user_limit_type tinyint(1) DEFAULT 1 COMMENT '验证身份证唯一性 : 对外默认填： ID_CARD_NO_UNIQUE',
	-- 1: 四要素验证通过2: 未鉴权3: 特殊用户认证4: 企业用户认证
	access_type tinyint(1) COMMENT '鉴权通过类型 : 1: 四要素验证通过2: 未鉴权3: 特殊用户认证4: 企业用户认证',
	-- 1: 审核中2:审核通过3: 审核回退4:审核拒绝
	audit_status tinyint(1) COMMENT '审核状态 : 1: 审核中2:审核通过3: 审核回退4:审核拒绝',
	-- [0 失效 1生效]
	status tinyint(1) DEFAULT 1 COMMENT '状态 : [0 失效 1生效]',
	create_time datetime COMMENT '创建时间',
	update_time datetime COMMENT '更新时间',
	partition_date int(6) NOT NULL COMMENT '分区信息列，request time的年*100+月',
	PRIMARY KEY (id)
) COMMENT = '懒猫绑卡记录表';


CREATE TABLE lm_change_cardmobile_flowinfo
(
	id bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
	fcp_trx_no varchar(50) COMMENT '交易流水号',
	request_ref_no varchar(50) COMMENT '请求流水号',
	request_time datetime COMMENT '请求时间',
	system_no varchar(20) COMMENT '系统编号',
	platform_user_id varchar(50) COMMENT '平台用户ID',
	real_name varchar(50) COMMENT '用户姓名',
	id_no varchar(20) COMMENT '证件号',
	mobile varchar(20) COMMENT '新银行预留手机号',
	bank_card_no varchar(20) COMMENT '新银行卡号',
	bank_code varchar(10) COMMENT '银行代码',
	remark varchar(50) COMMENT '备注',
	-- 1：四要素鉴权（对外：LIMIT）
	-- 2：三要素鉴权
	check_type tinyint(1) DEFAULT 1 COMMENT '鉴权类型 : 1：四要素鉴权（对外：LIMIT）
2：三要素鉴权',
	-- 1 ：更改银行卡；对外：【固定值】UPDATE_BANKCARD
	bind_type tinyint(1) DEFAULT 1 COMMENT '绑卡类型 : 1 ：更改银行卡；对外：【固定值】UPDATE_BANKCARD',
	-- 1: 四要素验证通过2: 未鉴权3: 特殊用户认证4: 企业用户认证
	access_type tinyint(1) COMMENT '鉴权通过类型 : 1: 四要素验证通过2: 未鉴权3: 特殊用户认证4: 企业用户认证',
	-- 1: 审核中2:审核通过3: 审核回退4:审核拒绝
	audit_status tinyint(1) COMMENT '审核状态 : 1: 审核中2:审核通过3: 审核回退4:审核拒绝',
	callback_url varchar(200) COMMENT '回调地址',
	notify_url varchar(200) COMMENT '通知地址',
	-- SUCCESS为确认成功，FAIL为确认失败, UNKNOW未知, ACCEPTED受理成功
	result varchar(20) COMMENT '结果 : SUCCESS为确认成功，FAIL为确认失败, UNKNOW未知, ACCEPTED受理成功',
	fail_code varchar(20) COMMENT '失败Code',
	fail_reason varchar(100) COMMENT '失败原因',
	create_time datetime COMMENT '创建时间',
	update_time datetime COMMENT '更新时间',
	-- 1:变更银行卡
	-- 2:变更预留手机号
	change_type tinyint(1) COMMENT '变更信息字段 : 1:变更银行卡
2:变更预留手机号',
	partition_date int(6) NOT NULL COMMENT '分区信息列，request time的年*100+月',
	PRIMARY KEY (id)
) COMMENT = '懒猫存管-换卡/手机号流水表';


CREATE TABLE lm_project_auth_list
(
	id bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
	request_ref_no varchar(50) COMMENT '请求参考号',
	request_time datetime COMMENT '请求时间',
	fcp_trx_no varchar(50) COMMENT '交易流水号',
	project_no varchar(50) COMMENT '标的号',
	-- 1：四要素鉴权（对外：LIMIT）
	-- 2：三要素鉴权
	check_type tinyint(1) COMMENT '鉴权类型 : 1：四要素鉴权（对外：LIMIT）
2：三要素鉴权',
	-- 1：个人，懒猫：PERSONAL
	-- 2：企业,   懒猫：ENTERPRISE
	entrusted_type tinyint(1) COMMENT '受托方类型 : 1：个人，懒猫：PERSONAL
2：企业,   懒猫：ENTERPRISE',
	platform_user_id varchar(50) COMMENT '平台用户ID',
	-- SUCCESS为确认成功，FAIL为确认失败, UNKNOW未知, ACCEPTED受理成功
	result varchar(20) COMMENT '结果 : SUCCESS为确认成功，FAIL为确认失败, UNKNOW未知, ACCEPTED受理成功',
	fail_code varchar(20) COMMENT '失败Code',
	fail_reason varchar(100) COMMENT '失败原因',
	create_time datetime COMMENT '创建时间',
	update_time datetime COMMENT '更新时间',
	PRIMARY KEY (id)
) COMMENT = '懒猫标的-委托支付授权清单';


CREATE TABLE lm_project_flowinfo
(
	id bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
	fcp_trx_no varchar(50) COMMENT '交易流水号',
	request_ref_no varchar(50) COMMENT '请求流水号',
	request_time datetime COMMENT '请求时间',
	system_no varchar(20) COMMENT '系统编号',
	platform_user_id varchar(50) COMMENT '平台用户ID',
	project_no varchar(50) COMMENT '标的编号',
	project_amount varchar(20) COMMENT '标的金额',
	project_name varchar(50) COMMENT '标的名称',
	project_desc varchar(200) COMMENT '标的描述',
	-- 1: 散标 2:委托支付标的
	project_type tinyint(1) COMMENT '标的类型 : 1: 散标 2:委托支付标的',
	project_period int(5) COMMENT '标的期限(天)',
	interest_rate varchar(10) COMMENT '标的年化利率',
	-- [1:一次性还本付息,2:先息后本,3:等额本息,4:等额本金]
	repayment_way tinyint(1) COMMENT '还款方式 : [1:一次性还本付息,2:先息后本,3:等额本息,4:等额本金]',
	extend varchar(100) COMMENT '拓展字段',
	-- 1:募集中,2:还款中,3:已截标,4:流标
	project_status tinyint(2) COMMENT '标的状态 : 1:募集中,2:还款中,3:已截标,4:流标',
	create_time datetime COMMENT '创建时间',
	update_time datetime COMMENT '更新时间',
	-- SUCCESS为确认成功，FAIL为确认失败, UNKNOW未知, ACCEPTED受理成功
	result varchar(20) COMMENT '结果 : SUCCESS为确认成功，FAIL为确认失败, UNKNOW未知, ACCEPTED受理成功',
	fail_code varchar(20) COMMENT '失败code',
	fail_reason varchar(100) COMMENT '失败原因',
	partition_date int(6) NOT NULL COMMENT '分区信息列，request time的年*100+月',
	PRIMARY KEY (id)
) COMMENT = '懒猫-标的流水记录表';


CREATE TABLE lm_project_list
(
	id bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
	platform_user_id varchar(50) COMMENT '平台用户ID',
	project_no varchar(50) COMMENT '标的编号',
	project_amount varchar(20) COMMENT '标的金额',
	project_name varchar(50) COMMENT '标的名称',
	project_desc varchar(200) COMMENT '标的描述',
	-- 1: 散标 2:委托支付标的
	project_type tinyint(1) COMMENT '标的类型 : 1: 散标 2:委托支付标的',
	project_period int(5) COMMENT '标的期限(天)',
	interest_rate varchar(10) COMMENT '标的年化利率',
	-- [1:一次性还本付息,2:先息后本,3:等额本息,4:等额本金]
	repayment_way tinyint(1) COMMENT '还款方式 : [1:一次性还本付息,2:先息后本,3:等额本息,4:等额本金]',
	extend varchar(100) COMMENT '拓展字段',
	-- 1:募集中,2:还款中,3:已截标,4:流标
	project_status tinyint(2) COMMENT '标的状态 : 1:募集中,2:还款中,3:已截标,4:流标',
	create_time datetime COMMENT '创建时间',
	update_time datetime COMMENT '更新时间',
	PRIMARY KEY (id)
) COMMENT = '懒猫-标的信息表';


CREATE TABLE lm_user_operation_flowinfo
(
	id tinyint(1) NOT NULL AUTO_INCREMENT COMMENT '主键',
	fcp_trx_no varchar(50) COMMENT '交易流水号',
	request_ref_no varchar(50) COMMENT '请求参考号',
	request_time datetime COMMENT '请求时间',
	system_no varchar(20) COMMENT '系统编号',
	-- 1:会员激活
	-- 2:修改交易密码
	-- 3:验证交易密码
	-- 4:交易密码解冻
	-- 5:用户授权
	-- 6:取消用户授权
	oper_type tinyint(2) COMMENT '操作类型 : 1:会员激活
2:修改交易密码
3:验证交易密码
4:交易密码解冻
5:用户授权
6:取消用户授权',
	platform_user_id varchar(50) COMMENT '平台用户ID/出款方ID',
	-- [1:主动修改密码,对外:Remember] 
	-- [2:忘记密码,对外:Forget]
	is_skip tinyint(1) COMMENT '变更类型 : [1:主动修改密码,对外:Remember] 
[2:忘记密码,对外:Forget]',
	-- 仅限验证交易密码场景的描述文字
	-- oper_type=3
	biz_type_desc varchar(500) COMMENT '平台业务类型描述 : 仅限验证交易密码场景的描述文字
oper_type=3',
	-- 多个以,分割
	-- TENDER 自动投标REPAYMENT 自动还款CREDIT_ASSIGNMENT 自动债权认购COMPENSATORY 自动代偿WITHDRAW 自动提现RECHARGE  自动充值
	auth_list varchar(100) COMMENT '用户授权集合 : 多个以,分割
TENDER 自动投标REPAYMENT 自动还款CREDIT_ASSIGNMENT 自动债权认购COMPENSATORY 自动代偿WITHDRAW 自动提现RECHARGE  自动充值',
	-- 1：四要素鉴权（对外：LIMIT）
	-- 2：三要素鉴权
	check_type tinyint(1) COMMENT '鉴权类型 : 1：四要素鉴权（对外：LIMIT）
2：三要素鉴权',
	callback_url varchar(200) COMMENT '回调地址URL',
	notify_url varchar(200) COMMENT '异步通知地址',
	-- SUCCESS为确认成功，FAIL为确认失败, UNKNOW未知, ACCEPTED受理成功
	result varchar(20) COMMENT '结果 : SUCCESS为确认成功，FAIL为确认失败, UNKNOW未知, ACCEPTED受理成功',
	fail_code varchar(20) COMMENT '失败编码',
	fail_reason varchar(100) COMMENT '失败原因',
	create_time datetime COMMENT '创建时间',
	update_time datetime COMMENT '更新时间',
	partition_date int(6) NOT NULL COMMENT '分区信息列，request time的年*100+月',
	PRIMARY KEY (id)
) COMMENT = '懒猫存管-个人操作流水表';


CREATE TABLE lm_vaccount_notify_txtp
(
	id bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
	lm_return_trx_no varchar(50) COMMENT '懒猫回退充值流水号',
	fcp_trx_no varchar(50) COMMENT '源提现交易流水号',
	rollback_amount varchar(20) COMMENT '提现到账金额',
	rollback_comm_amount varchar(20) COMMENT '提现回退佣金',
	completed_time datetime COMMENT '资金回退完成时间',
	rollback_status varchar(10) COMMENT '回退充值状态',
	-- INTERCEPT  提现拦截以后系统发起的回充；REMITFAIL：系统提现失败回充
	rollback_type varchar(50) COMMENT '回退类型 : INTERCEPT  提现拦截以后系统发起的回充；REMITFAIL：系统提现失败回充',
	-- 1:待处理 2处理中 3:已处理
	status tinyint(1) COMMENT '处理状态 : 1:待处理 2处理中 3:已处理',
	done_time datetime COMMENT '处理完成时间',
	create_time datetime COMMENT '创建时间',
	update_time datetime COMMENT '更新时间',
	PRIMARY KEY (id)
) COMMENT = '懒猫存管-提现退票通知接收表';


CREATE TABLE lm_vaccount_transfer_batch
(
	id bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
	batch_no varchar(50) COMMENT '批次号',
	create_time datetime COMMENT '创建时间',
	update_time datetime COMMENT '更新时间',
	PRIMARY KEY (id)
) COMMENT = '批量交易主表';


CREATE TABLE lm_vaccount_transfer_detail
(
	id bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
	request_ref_no varchar(50) COMMENT '请求参考号',
	fcp_trx_no varchar(50) COMMENT '交易流水号',
	transfer_info_id varchar(50) COMMENT '交易表主键',
	transfer_amount varchar(20) COMMENT '交易金额(分)',
	out_real_name varchar(50) COMMENT '出款方用户名',
	out_external_account varchar(50) COMMENT '出款方账号ID',
	in_real_name varchar(50) COMMENT '入款方姓名',
	in_external_account varchar(50) COMMENT '入账方账户ID',
	account_date datetime COMMENT '财务记账日期',
	settle_amount varchar(20) COMMENT '结算金额(分)',
	finish_date datetime COMMENT '交易完成时间',
	-- 清算时间,如果有account_date有值则保持一致,否则new一个时间
	settle_date datetime COMMENT '清算时间 : 清算时间,如果有account_date有值则保持一致,否则new一个时间',
	lm_biz_type varchar(50) COMMENT '懒猫业务类型',
	crf_biz_type varchar(50) COMMENT 'CRF 业务类型',
	right_share varchar(20) COMMENT '债权份额',
	origin_fcp_trxno varchar(50) COMMENT '关联的原始交易流水号',
	custom_define varchar(50) COMMENT '自定义',
	remark varchar(50) COMMENT '交易备注',
	-- SUCCESS为确认成功，FAIL为确认失败, UNKNOW未知, ACCEPTED受理成功
	result varchar(20) COMMENT '结果 : SUCCESS为确认成功，FAIL为确认失败, UNKNOW未知, ACCEPTED受理成功',
	fail_code varchar(20) COMMENT '失败错误码',
	fail_reason varchar(100) COMMENT '失败原因',
	create_time datetime COMMENT '创建时间',
	update_time datetime COMMENT '更新时间',
	partition_date int(6) NOT NULL COMMENT '分区信息列，request_time*100+月',
	PRIMARY KEY (id)
) COMMENT = '懒猫存管-交易明细表';


CREATE TABLE lm_vaccount_transfer_info
(
	id bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
	batch_no varchar(50) COMMENT '批次号',
	request_ref_no varchar(50) COMMENT '请求参考号',
	request_time datetime COMMENT '请求时间',
	system_no varchar(20) COMMENT '系统编号',
	fcp_trx_no varchar(50) COMMENT '交易流水号',
	transfer_amount varchar(20) COMMENT '交易金额(分)',
	channel_fee_amount varchar(20) COMMENT '手续费(分)',
	currency tinyint(1) COMMENT '币种(默认人民币1)',
	out_real_name varchar(50) COMMENT '出款方用户名',
	out_external_account varchar(50) COMMENT '出款方账号ID',
	in_real_name varchar(50) COMMENT '入款方姓名',
	in_external_account varchar(50) COMMENT '入账方账户ID',
	-- [FKHB放款、HKHB还款划拨、ZQRGHB债权认购、JJDCHB间接代偿划拨、ZJDCHB间接代偿划拨、DLFR独立分润、PTYXK平台营销款、SFHB收费划拨、PTZJHB平台资金划拨、ZJDJ追加冻结、DJYCL冻结预处理、YHYCL用户预处理、ZQZR债权转让、QXZQ取消债权、ZDCZ自动充值、CZ充值、ZDTX自动提现、TX提现]
	transfer_type varchar(10) COMMENT '交易类型 : [FKHB放款、HKHB还款划拨、ZQRGHB债权认购、JJDCHB间接代偿划拨、ZJDCHB间接代偿划拨、DLFR独立分润、PTYXK平台营销款、SFHB收费划拨、PTZJHB平台资金划拨、ZJDJ追加冻结、DJYCL冻结预处理、YHYCL用户预处理、ZQZR债权转让、QXZQ取消债权、ZDCZ自动充值、CZ充值、ZDTX自动提现、TX提现]',
	account_date datetime COMMENT '财务记账日期',
	settle_amount varchar(20) COMMENT '结算金额(分)',
	finish_date datetime COMMENT '交易完成时间',
	-- 清算时间,如果有account_date有值则保持一致,否则new一个时间
	settle_date datetime COMMENT '清算时间 : 清算时间,如果有account_date有值则保持一致,否则new一个时间',
	lm_biz_type varchar(50) COMMENT '懒猫业务类型',
	crf_biz_type varchar(50) COMMENT 'CRF 业务类型',
	expired_time datetime COMMENT '交易过期时间',
	right_share varchar(10) COMMENT '债权份额',
	origin_fcp_trxno varchar(50) COMMENT '关联的原始交易流水号',
	remark varchar(50) COMMENT '交易备注',
	callback_url varchar(200) COMMENT '回调地址',
	notify_url varchar(200) COMMENT '异步通知地址',
	-- SUCCESS为确认成功，FAIL为确认失败, UNKNOW未知, ACCEPTED受理成功
	result varchar(20) COMMENT '结果 : SUCCESS为确认成功，FAIL为确认失败, UNKNOW未知, ACCEPTED受理成功',
	fail_code varchar(20) COMMENT '失败错误码',
	fail_reason varchar(100) COMMENT '失败原因',
	create_time datetime COMMENT '创建时间',
	update_time datetime COMMENT '更新时间',
	partition_date int(6) NOT NULL COMMENT '分区信息列，request_time*100+月',
	PRIMARY KEY (id)
) COMMENT = '懒猫存管-交易流水表[与业务系统间]';


CREATE TABLE system_config
(
	id bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
	param_key varchar(20) COMMENT '参数key',
	param_value varchar(200) COMMENT '参数值',
	param_desc varchar(100) COMMENT '配置描述',
	create_time datetime COMMENT '创建时间',
	update_time datetime COMMENT '更新时间',
	PRIMARY KEY (id)
) COMMENT = '系统配置表';


CREATE TABLE system_status_code
(
	id bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
	-- 以“CDG_开头”
	code_no varchar(50) COMMENT '代码编号 : 以“CDG_开头”',
	status_code varchar(50) COMMENT '状态代码',
	code_explain varchar(100) COMMENT '代码解释翻译',
	create_time datetime COMMENT '创建时间',
	update_time datetime COMMENT '更新时间',
	PRIMARY KEY (id)
) COMMENT = 'CDG系统内部状态码表';


CREATE TABLE system_status_code_metadata
(
	id bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
	code_no varchar(50) COMMENT 'CDG通道Code',
	-- 1：懒猫存管
	channel_info_no varchar(20) DEFAULT '1' COMMENT '通道编号 : 1：懒猫存管',
	status_report varchar(20) COMMENT '第三方状态Code',
	status_report_explain varchar(100) COMMENT '第3方状态解释',
	create_time datetime COMMENT '创建时间',
	update_time datetime COMMENT '更新时间',
	PRIMARY KEY (id)
) COMMENT = '各第三方通道状态代码表';



/* Create Indexes */

CREATE INDEX inx_bindcard_flowinfo USING BTREE ON lm_bind_card_flowinfo (fcp_trx_no ASC, request_ref_no ASC, partition_date ASC);



