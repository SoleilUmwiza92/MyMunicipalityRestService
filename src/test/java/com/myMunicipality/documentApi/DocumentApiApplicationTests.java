package com.myMunicipality.documentApi;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class DocumentApiApplicationTests {

	@SpyBean
	DocumentApiApplication application;
	@Test
	void contextLoads() {
		assertNotNull(application);
	}


}
