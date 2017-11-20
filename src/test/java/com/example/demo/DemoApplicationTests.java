package com.example.demo;

import com.example.demo.utils.AesUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Test
	public void run(){
		//String a="{\"username\":\"赵六\",\"password\":123345}";
		String b="36B7732CAE9653E2F048EC72BBB2AB2DB8E8785EC39217FF6CC125F70EC0E88B";
		//String enString = AesUtils.encrypt(a, "youllikefollower", "likethisverymuch");
		//System.out.println("AES:" + enString);
		System.out.println("AES:" + AesUtils.decrypt(b, "youllikefollower", "likethisverymuch"));
	}

}
