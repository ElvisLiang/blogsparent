package com.blogs.auth.config;

import com.blogs.user.entity.User;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        Map<String,String> filterChainDefinitionMap = new LinkedHashMap<>();
/*        filterChainDefinitionMap.put("/images/**","anon");
        filterChainDefinitionMap.put("/styles/**","anon");
        filterChainDefinitionMap.put("/plugins/**","anon");
        filterChainDefinitionMap.put("/scripts/**","anon");
        filterChainDefinitionMap.put("/static/**","anon");
        filterChainDefinitionMap.put("/login/**","logout");
        filterChainDefinitionMap.put("/logout","logout");*/
        filterChainDefinitionMap.put("/**","anon");//authc
        shiroFilterFactoryBean.setLoginUrl("/index");
        shiroFilterFactoryBean.setSuccessUrl("/index");
        shiroFilterFactoryBean.setUnauthorizedUrl("/403");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }

    @Bean
    public ShiroRealm shiroRealm(){
        ShiroRealm shiroRealm = new ShiroRealm();
        return shiroRealm;
    }

    @Bean
    public FormAuthenticationFilter formAuthenticationFilter(){
        UserFormAuthenticationFilter userFormAuthenticationFilter = new UserFormAuthenticationFilter();
        return userFormAuthenticationFilter;
    }

    @Bean
    public SecurityManager securityManager(){
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
        defaultWebSecurityManager.setRealm(shiroRealm());
        return defaultWebSecurityManager;
    }


}
