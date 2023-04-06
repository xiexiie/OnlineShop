package com.yuanlrc.campus_market.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.yuanlrc.campus_market.constant.SessionConstant;
import com.yuanlrc.campus_market.entity.admin.User;

/**
 * session统一操作工具类
 */
public class SessionUtil {

	/**
	 * 获取请求request
	 */
	public static HttpServletRequest getRequest(){
		ServletRequestAttributes attributes =(ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
		return attributes == null ? null : attributes.getRequest();
	}
	
	/**
	 * 获取session
	 */
	public static HttpSession getSession(){
		HttpServletRequest request = getRequest();
		if(request != null){
			return request.getSession();
		}
		return null;
	}
	
	/**
	 * 获取指定键的值
	 */
	public static Object get(String key){
		HttpSession session = getSession();
		if(session != null){
			return session.getAttribute(key);
		}
		return null;
	}
	
	/**
	 * 设置session值
	 */
	public static void set(String key,Object object){
		HttpSession session = getSession();
		if(session != null){
			session.setAttribute(key,object);
		}
	}
	
	/**
	 * 获取当前登录的用户
	 */
	public static User getLoginedUser(){
		HttpSession session = getSession();
		if(session != null){
			Object attribute = session.getAttribute(SessionConstant.SESSION_USER_LOGIN_KEY);
			return attribute == null ? null : (User)attribute;
		}
		return null;
	}
}
