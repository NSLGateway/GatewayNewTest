package com.nsl.gateway.util;

import com.nsl.gateway.util.testcase.TestCaseObj;

/**
 * 讀取從Gateway client匯出的xml, 並轉為Object
 * 
 * @author WSNPI05
 *
 */
public class TestCaseReader {
	public TestCaseObj readFromFile(String abstractFileName) throws Exception {
		return (TestCaseObj) new XmlReader().parseFromFile(abstractFileName, TestCaseObj.class);
	}

	public static void main(String[] args) throws Exception {
		System.out.println(new TestCaseReader().readFromFile("./testData/GW_CLIENT_Test_Cases.xml"));
	}
}
