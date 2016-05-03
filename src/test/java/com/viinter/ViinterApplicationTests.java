package com.viinter;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.viinter.ViinterApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ViinterApplication.class)
@WebAppConfiguration
public class ViinterApplicationTests {

	@Test
	public void contextLoads() {
	}

}
