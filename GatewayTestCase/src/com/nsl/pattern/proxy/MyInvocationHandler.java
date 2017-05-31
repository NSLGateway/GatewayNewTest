package com.nsl.pattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.List;

import com.nsl.pattern.util.AuthorityCheck;
import com.nsl.pattern.util.Encoder;
import com.nsl.pattern.util.Logger;

/**
 * Dynamic proxy
 * 
 * @author WSNPI05
 *
 */
public class MyInvocationHandler implements InvocationHandler {
	private Object subject;
	private List<String> resource;

	public MyInvocationHandler(Object subject) {
		this.subject = subject;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// pre processer, 例如權限檢核, log...
		new AuthorityCheck(this).check();

		Object result = null;
		if (method.getName().equals("doA")) {
			Logger.debug("before real doA, a=" + (String) args[0]);
			String a2 = new Encoder().encode((String) args[0]);
			result = method.invoke(subject, a2);
			Logger.debug("after real doA, result=" + result);
		} else if (method.getName().equals("doB")) {
			if (this.resource != null) {
				Logger.info("get resource from cache, skip real doB");
				result = resource;
			} else {
				Logger.info("before real doB");
				result = method.invoke(subject, args);
				resource = (List<String>) result;
				Logger.info("after real doB, result=" + resource);
			}
			result = resource;
		} else {
			Logger.warning("before real " + method.getName());
			result = method.invoke(subject, args);
			Logger.warning("after real " + method.getName() + ", result=" + result);
		}

		// post processor
		return result;
	}

}
