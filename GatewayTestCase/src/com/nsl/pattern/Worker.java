package com.nsl.pattern;

import java.util.ArrayList;
import java.util.List;

public class Worker implements IWorker {
	public Worker() {
		// resource

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.nsl.gateway.example.IWorker#doA()
	 */
	@Override
	public String doA(String a) {
		System.out.println("real doA");
		return a;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.nsl.gateway.example.IWorker#doB()
	 */
	@Override
	public List<String> doB() {
		System.out.println("real doB");
		// heavy work, needed 10 second
		try {
			Thread.currentThread().sleep(1000);
		} catch (Exception e) {
			System.out.println(e);
		}
		return new ArrayList<String>();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.nsl.gateway.example.IWorker#doC()
	 */
	@Override
	public int doC() {
		System.out.println("real doC");
		return 3;
	}
}
