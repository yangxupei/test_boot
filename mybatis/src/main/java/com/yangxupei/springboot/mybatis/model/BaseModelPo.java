package com.yangxupei.springboot.mybatis.model;

import lombok.Data;

import java.util.Date;

/**
 * Author: Yang xp
 * Date: 2016/10/18
 * Time: 13:07
 * Desc：
 */
@Data
public class BaseModelPo {

    /**
     * 主键
     */
    private String id;
    /**
     * 删除标识
     */
    private String deleteFlag;
    /**
     * 备注
     */
    private String remarkDesc;

    /**
     * 创建时间
     */
    private Date createAt;

    /**
     * 创建人
     */
    private String createBy;

    /**
     * 修改时间
     */
    private Date updateAt;

    /**
     * 修改人
     */
    private String updateBy;

    /**
     * 当前页
     */
    private int pageNum=1;

    /**
     * 页条数
     */
    private int pageSize=10;

    /**
     * 总条数
     */
    private int rowCount;

    /**
     * 开始行
     */
    private int startRow;

    /**
     * 总金额
     */
    private long allAmt;

    public int getStartRow() {
        return pageSize * (pageNum - 1);
    }

    private Date queryStartDate;

    private Date queryEndDate;

    private String queryStartKey;
    private String queryEndKey;

}
