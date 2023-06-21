package com.myMunicipality.documentApi;

import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringApplication;

import static org.mockito.Mockito.mockStatic;

public class MyApplicationClassTest {
        @Test
        public void myMain() {
            mockStatic(SpringApplication.class);
            DocumentApiApplication.main(new String[] {});
        }
}
