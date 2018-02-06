package com.yangxupei.boot.security.config;

import com.yangxupei.boot.security.db.mapper.RoleMapper;
import com.yangxupei.boot.security.db.mapper.UserMapper;
import com.yangxupei.boot.security.db.model.Role;
import com.yangxupei.boot.security.db.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : Yang xp
 * Date: 2018/2/2
 * Time: 下午4:20
 * Desc：
 */
@Component
public class DataUserDetailsService implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userMapper.findByUsername(username);
        if (user == null){
            throw new UsernameNotFoundException("Username {"+username+"} not found");
        }
        List<GrantedAuthority> grantedAuthorityList = buildGranted(user.getId());
        return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),true,true,true,true,grantedAuthorityList);
    }

    private List<GrantedAuthority> buildGranted(String username){
        List<Role> roleList = roleMapper.findByUsername(username);
        List<GrantedAuthority> grantedAuthorityList = new ArrayList<>();
        roleList.forEach(item -> grantedAuthorityList.add(new SimpleGrantedAuthority(item.getRole())));
        return grantedAuthorityList;
    }

}
