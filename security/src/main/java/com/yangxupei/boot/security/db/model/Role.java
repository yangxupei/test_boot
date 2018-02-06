package com.yangxupei.boot.security.db.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author : Yang xp
 * Date: 2018/2/2
 * Time: 下午4:38
 * Desc：
 */
@Getter
@Setter
@ToString
public class Role {

    private String id;

    private String role;

    private String userId;

}
