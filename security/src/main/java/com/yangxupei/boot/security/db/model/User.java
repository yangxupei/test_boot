package com.yangxupei.boot.security.db.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author : Yang xp
 * Date: 2018/2/2
 * Time: 下午4:37
 * Desc：
 */
@Getter
@Setter
@ToString
public class User {

    private String id;

    private String username;

    private String password;

}
