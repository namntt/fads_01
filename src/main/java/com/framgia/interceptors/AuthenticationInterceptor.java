package com.framgia.interceptors;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.framgia.model.User;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class AuthenticationInterceptor implements Interceptor {

	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationInterceptor.class);

	@Override
	public void destroy() {}

	@Override
	public void init() {}

	@Override
	public String intercept(ActionInvocation actionInvocation) throws Exception {

		LOGGER.info("check auth interceptor");
		Map<String, Object> sessionAttributes = actionInvocation.getInvocationContext().getSession();
		User user = (User) sessionAttributes.get("USER");

		if (user == null) {
			return Action.LOGIN;
		} else {
			Action action = (Action) actionInvocation.getAction();
			if (action instanceof UserAware) {
				((UserAware) action).setUser(user);
			}
			return actionInvocation.invoke();
		}
	}
}
