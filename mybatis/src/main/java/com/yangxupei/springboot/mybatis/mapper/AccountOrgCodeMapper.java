package com.yangxupei.springboot.mybatis.mapper;


import com.yangxupei.springboot.mybatis.model.AccountOrgCodePo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Author: Yang xp
 * Date: 2016/10/18
 * Time: 13:15
 * Desc：
 */
@Repository
public interface AccountOrgCodeMapper extends BaseMapper<AccountOrgCodePo> {

    List<AccountOrgCodePo> selectByModelPage(AccountOrgCodePo accountOrgCodePo);

}
