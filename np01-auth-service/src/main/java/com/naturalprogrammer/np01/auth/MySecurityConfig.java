package com.naturalprogrammer.np01.auth;

import com.naturalprogrammer.spring.lemon.security.LemonJpaSecurityConfig;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.stereotype.Component;

@Component
public class MySecurityConfig extends LemonJpaSecurityConfig {

    private static final Log log = LogFactory.getLog(MySecurityConfig.class);

    public MySecurityConfig() {
        log.info("Created");
    }

    @Override
    protected void authorizeRequests(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .mvcMatchers("/h2-console**").permitAll();
        http.headers().frameOptions().sameOrigin();
        super.authorizeRequests(http);
    }
}