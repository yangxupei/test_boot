package com.yangxupei.boot.security.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author : Yang xp
 * Date: 2018/2/2
 * Time: 下午1:31
 * Desc：
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/css/**", "/index").permitAll()
                .antMatchers("/user/**").hasRole("USER")
                .and()
                .formLogin()
                .loginPage("/login")
                .successForwardUrl("/index")
                .failureUrl("/login-error")
                .and()
                .logout()
                .logoutSuccessUrl("/index")
                .and()
                .sessionManagement()
                .maximumSessions(1)

        ;

    }
    // @formatter:on

    // @formatter:off
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth
//                .inMemoryAuthentication()
//                .withUser("user").password("password").roles("USER");
//    }
    // @formatter:on

//    @Bean
//    public UserDataAuthenticationProvider authenticationProvider(){
//        return new UserDataAuthenticationProvider();
//    }


//    public DataUserDetailsService detailsService(){
//
//    }

}
