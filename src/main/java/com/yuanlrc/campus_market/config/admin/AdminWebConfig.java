package com.yuanlrc.campus_market.config.admin;

/**
 * 用来配置拦截器的配置类
 * Spring MVC拦截器的开发步骤如下：
 * 1、开发拦截器：AdminLoginInterceptor,拦截器的具体操作
 * 实现handlerInterceptor接口，从三个方法中选择合适的方法，
 * 实现拦截时要执行的具体业务逻辑，重写PreHandle方法
 * 2、注册拦截器：
 * 定义配置类，并让它实现WebMvcConfigurer接口，在接口的addInterceptors方法中，
 * 注册拦截器，并定义该拦截器匹配哪些请求路径。
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.yuanlrc.campus_market.constant.RuntimeConstant;
import com.yuanlrc.campus_market.interceptor.admin.AuthorityInterceptor;
import com.yuanlrc.campus_market.interceptor.admin.AdminLoginInterceptor;

@Configuration
public class AdminWebConfig implements WebMvcConfigurer {
	
	@Autowired
	private AdminLoginInterceptor loginInterceptor;
	
	@Autowired
	private AuthorityInterceptor authorityInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
	    registry.addInterceptor(loginInterceptor).addPathPatterns("/**").excludePathPatterns(RuntimeConstant.loginExcludePathPatterns);
	    registry.addInterceptor(authorityInterceptor).addPathPatterns("/**").excludePathPatterns(RuntimeConstant.authorityExcludePathPatterns);
	}

}
