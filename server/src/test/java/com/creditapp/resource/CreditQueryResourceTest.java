package com.creditapp.resource;
/*
public class CreditQueryResourceTest extends AbstractTest {

	@Before
	public void setUp() {
		super.setUp();

	}



	@Test
	public void saveUsers_test() throws Exception {

		ServiceRequest serviceRequest = ServiceRequest.builder().tcno("12345678901").username("Donald")
				.lastname("Trump").salary(600.4).tel("0541-655-49-09").build();

		ServiceResponse serviceResponse = ServiceResponse.builder().name("Donald").credit(null).creditLimit(null)
				.status(CreditApprovalType.REJECTED).build();

		String inputJson = super.mapToJson(serviceRequest);

		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post("/api/credit/score")
				.contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();

		
		  int status = mvcResult.getResponse().getStatus(); assertEquals(200, status);
		 
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals(content, "{\"name\":\"Donald\",\"status\":\"REJECTED\",\"credit\":null,\"creditLimit\":null}");
	}

}
*/