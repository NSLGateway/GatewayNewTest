package com.nsl.pattern.decorator;

import java.util.List;

import com.nsl.pattern.IWorker;
import com.nsl.pattern.util.Encoder;
import com.nsl.pattern.util.Logger;

public class LoggerProcessor implements IWorker {
	private IWorker next;

	// cache resource
	private List<String> resource;

	public LoggerProcessor(IWorker next) {
		this.next = next;
	}

	@Override
	public String doA(String a) {
		Logger.debug("before real doA, a=" + a);

		String result = next.doA(a);

		// post processor
		Logger.debug("after real doA, result=" + result);
		// TODO Auto-generated method stub
		return result;
	}

	@Override
	public List<String> doB() {
		List<String> result = null;
		if (this.resource != null) {
			Logger.info("get resource from cache, skip real doB");
			result = resource;
		} else {
			Logger.info("before real doB");
			result = next.doB();
			resource = result;
			Logger.info("after real doB, result=" + result);
		}

		// post processor
		return result;
	}

	@Override
	public int doC() {
		Logger.warning("before real doC");

		int result = next.doC();

		// post processor
		Logger.warning("after real doC, result=" + result);
		return result;
	}

}
