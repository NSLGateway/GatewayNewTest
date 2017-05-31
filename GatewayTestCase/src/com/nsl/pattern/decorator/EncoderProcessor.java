package com.nsl.pattern.decorator;

import java.util.List;

import com.nsl.pattern.IWorker;
import com.nsl.pattern.util.Encoder;

public class EncoderProcessor implements IWorker {
	private IWorker next;
	public EncoderProcessor(IWorker next) {
		this.next = next;
	}

	@Override
	public String doA(String a) {
		String a2 = new Encoder().encode(a);
		return next.doA(a2);
	}

	@Override
	public List<String> doB() {
		// TODO Auto-generated method stub
		return next.doB();
	}

	@Override
	public int doC() {
		// TODO Auto-generated method stub
		return next.doC();
	}

}
