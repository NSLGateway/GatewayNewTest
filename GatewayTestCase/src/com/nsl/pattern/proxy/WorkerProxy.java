package com.nsl.pattern.proxy;

import java.util.List;

import com.nsl.pattern.IWorker;
import com.nsl.pattern.Worker;
import com.nsl.pattern.util.AuthorityCheck;
import com.nsl.pattern.util.Encoder;
import com.nsl.pattern.util.Logger;

/**
 * Static proxy
 * 
 * @author WSNPI05
 *
 */
public class WorkerProxy implements IWorker {
	private IWorker w;

	// cache resource
	private List<String> resource;

	public WorkerProxy() {
		w = new Worker();
	}

	public WorkerProxy(IWorker w) {
		this.w = w;
	}

	@Override
	public String doA(String a) {
		// pre processer, 例如權限檢核, log debug, 多語系編碼...
		new AuthorityCheck(w).check();
		Logger.debug("before real doA, a=" + a);
		String a2 = new Encoder().encode(a);

		String result = w.doA(a2);

		// post processor
		Logger.debug("after real doA, result=" + result);
		return result;
	}

	@Override
	public List<String> doB() {
		// pre processer, 例如權限檢核, log info...
		new AuthorityCheck(w).check();

		List<String> result = null;
		if (this.resource != null) {
			Logger.info("get resource from cache, skip real doB");
			result = resource;
		} else {
			Logger.info("before real doB");
			result = w.doB();
			resource = result;
			Logger.info("after real doB, result=" + result);
		}

		// post processor
		return result;
	}

	@Override
	public int doC() {
		// pre processer, 例如權限檢核, log warning...
		new AuthorityCheck(w).check();
		Logger.warning("before real doC");

		int result = w.doC();

		// post processor
		Logger.warning("after real doC, result=" + result);
		return result;
	}

}
