package com.yangxupei.boot.security.db.mapper;

import com.yangxupei.boot.security.db.model.Role;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author : Yang xp
 * Date: 2018/2/2
 * Time: 下午4:45
 * Desc：
 */
public interface RoleMapper {

    List<Role> findByUsername(String username);

}
