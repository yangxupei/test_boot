package com.yangxupei.springboot.mybatis.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Author: Yang xp
 * Date: 2016/9/30
 * Time: 14:09
 * Desc：账户机构规则
 */
@Setter
@Getter
@ToString(callSuper = true)
public class AccountOrgCodePo extends BaseModelPo {

    /**
     * 账号
     */
    private String accountNo;

    /**
     * 交易系统的支付机构号
     */
    private String orgCode;

    /**
     * 清算标题
     */
    private String settleTitle;

    /**
     * 机构类型
     */
    private String orgType;

    /**
     * 对方账号
     */
    private String otherAccountNo;

    /**
     * 结算类型
     *
     */
    private String clearType;

    /**
     * 退款结算类型
     * @see com.oriental.reserve.enums.RefundClearType
     */
    private String refundType;

    /**
     * 是否为代付
     * @see com.oriental.reserve.commons.enums.YesOrNo
     */
    private String payForAnother;

    /**
     * 金融机构代码
     */
    private String financialOrgCode;

    /**
     * 外部交易类型，针对网联
     */
    private String extTransType;

    /**
     * 是否为网联
     */
    private String epcc;


    public AccountOrgCodePo(){
    }
}
