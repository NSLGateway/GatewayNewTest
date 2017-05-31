package com.nsl.gateway.util;

import com.nsl.gateway.util.testcase.TestCaseObj;

/**
 * Ū���qGateway client�ץX��xml, ���ରObject
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
