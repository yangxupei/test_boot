package com.yangxupei.boot.security.db.mapper;

import com.yangxupei.boot.security.db.model.User;

/**
 * @author : Yang xp
 * Date: 2018/2/2
 * Time: 下午4:36
 * Desc：
 */
public interface UserMapper {

    User findByUsername(String username);

}
