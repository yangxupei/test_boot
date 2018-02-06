package com.yangxupei.springboot.mybatis.controller;

import com.yangxupei.springboot.mybatis.config.datasource.DatasourcePropertiesConfig;
import com.yangxupei.springboot.mybatis.mapper.AccountOrgCodeMapper;
import com.yangxupei.springboot.mybatis.model.AccountOrgCodePo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author : Yang xp
 * Date: 2018/1/25
 * Time: 下午3:12
 * Desc：
 */
@RestController
@RequestMapping("/account/org/code")
@Slf4j
public class AccountOrgCodeController {

    @Autowired
    private AccountOrgCodeMapper accountOrgCodeMapper;

    @Autowired
    private DatasourcePropertiesConfig datasourcePropertiesConfig;

    @Value("${app.datasource.reserve.url}")
    private String url;

    @RequestMapping("/list")
    public List<AccountOrgCodePo> query(){
        AccountOrgCodePo accountOrgCodePo = new AccountOrgCodePo();
        accountOrgCodePo.setDeleteFlag("0");
        log.info("config:{}",url);
        return accountOrgCodeMapper.selectByModel(accountOrgCodePo);
    }

}
