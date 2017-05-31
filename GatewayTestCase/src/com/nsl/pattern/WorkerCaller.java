package com.nsl.pattern;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

import com.nsl.pattern.decorator.AuthorityCheckProcessor;
import com.nsl.pattern.decorator.EncoderProcessor;
import com.nsl.pattern.decorator.LoggerProcessor;
import com.nsl.pattern.proxy.MyInvocationHandler;
import com.nsl.pattern.proxy.WorkerProxy;

public class WorkerCaller {

	public static void main(String[] args) {
		// direct use concrete class
		IWorker worker = new Worker();
		worker.doA("a");
		System.out.println();
		worker.doB();
		System.out.println();
		worker.doB();
		System.out.println();
		worker.doC();
		System.out.println();

		// static proxy
		System.out.println("------------static proxy------------------------");
		IWorker sWorker = new WorkerProxy(new Worker());
		sWorker.doA("a");
		System.out.println();
		sWorker.doB();
		System.out.println();
		sWorker.doB();
		System.out.println();
		sWorker.doC();
		System.out.println();

		// dynamic proxy
		System.out.println("-------------dynamic proxy----------------------");
		InvocationHandler handler = new MyInvocationHandler(new Worker());
		IWorker dWorker = (IWorker) Proxy.newProxyInstance(IWorker.class.getClassLoader(),
				new Class[] { IWorker.class }, handler);
		dWorker.doA("a");
		System.out.println();
		dWorker.doB();
		System.out.println();
		dWorker.doB();
		System.out.println();
		dWorker.doC();

		// decorator
		System.out.println("------------decorator------------------------");
		IWorker rWorker = new AuthorityCheckProcessor(
				new EncoderProcessor(
						new LoggerProcessor(
								new Worker())));
		rWorker.doA("a");
		System.out.println();
		rWorker.doB();
		System.out.println();
		sWorker.doB();
		System.out.println();
		rWorker.doC();
		System.out.println();

	}
}
