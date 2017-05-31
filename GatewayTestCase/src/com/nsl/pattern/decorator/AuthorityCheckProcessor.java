package com.nsl.pattern.decorator;

import java.util.List;

import com.nsl.pattern.IWorker;
import com.nsl.pattern.util.AuthorityCheck;

public class AuthorityCheckProcessor implements IWorker {
	private IWorker next;
	public AuthorityCheckProcessor(IWorker next) {
		this.next = next;
	}
	@Override
	public String doA(String a) {
		new AuthorityCheck(next).check();
		return next.doA(a);
	}

	@Override
	public List<String> doB() {
		new AuthorityCheck(next).check();
		return next.doB();
	}

	@Override
	public int doC() {
		new AuthorityCheck(next).check();
		return next.doC();
	}

}
