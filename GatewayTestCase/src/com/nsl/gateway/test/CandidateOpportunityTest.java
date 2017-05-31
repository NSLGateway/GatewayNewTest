package com.nsl.gateway.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.nsl.gateway.util.http.ResponseObj;
import com.nsl.gateway.util.xmldiff.XmlDiffUtils;
import com.nsl.gateway.util.FileUtils;
import com.nsl.gateway.util.GatewayCaller;

/**
 * Candidate Opportunityªºtest case
 * 
 * @author WSNPI05
 *
 */
public class CandidateOpportunityTest {

	private GatewayCaller caller;
	private String testDataPath;

	@Before
	public void setUp() throws Exception {
		caller = new GatewayCaller("dp2wdp.nanshan.com.tw", 8888, "http", "W9006357", "Qwer1234");
		testDataPath = "./testData/CandidateOpportunity/";
	}

	@Test
	public void testBatchUpdateRECRUIT_LEVEL() throws Exception {
		ResponseObj response = caller.post("/sap/opu/odata/NSL/CANDIDATE_OPPORTUNITY_SRV/OpportunityDetailSet",
				FileUtils.readFileToString(testDataPath, "BatchUpdate_RECRUIT_LEVEL.txt"));
		assertEquals(response.getStatus(), 200);

		XmlDiffUtils diff = new XmlDiffUtils().ignoreAttribute("xml:base").ignoreTag("id").ignoreTag("updated")
				.printLog(false)
				.diff(response.getContent(), FileUtils.readFileToString(testDataPath, "SearchHelpSet.xml"));
		assertNull(diff.getDiff());
		System.out.println("\n");
	}

	@Test
	public void testCheckOpportunityByCandidate() throws Exception {
		ResponseObj response = caller.post(
				"/sap/opu/odata/NSL/CANDIDATE_OPPORTUNITY_SRV/CheckOpportunityByCandidate?CandidateId='7000000551'",
				null);
		assertEquals(response.getStatus(), 200);

		XmlDiffUtils diff = new XmlDiffUtils().diff(response.getContent(),
				FileUtils.readFileToString(testDataPath, "CheckOpportunityByCandidate.xml"));
		assertNull(diff.getDiff());
		System.out.println("\nb");
	}

}
