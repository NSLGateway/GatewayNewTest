package com.nsl.pattern.util;

/**
 * 假裝權限檢核物件
 * 
 * @author WSNPI05
 *
 */
public class AuthorityCheck {
	private Object o;

	public AuthorityCheck(Object o) {
		this.o = o;
	}

	public void check() {
		System.out.println("Authority check " + o + " done!");
	}
}
