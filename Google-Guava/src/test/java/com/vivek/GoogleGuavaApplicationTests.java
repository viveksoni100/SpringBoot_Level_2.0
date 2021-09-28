package com.vivek;

import com.google.common.base.Joiner;
import com.google.common.collect.Maps;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

@SpringBootTest
class GoogleGuavaApplicationTests {

	//https://www.youtube.com/playlist?list=PLzxIPRxNnT3rCyVDJazvgOK-qMVuvWHzA

	@Test
	void linkedHashMapDemo() {
		/*we have easily converted a map to string*/
		Map<String, String> myMap = Maps.newLinkedHashMap();
		myMap.put("name", "abc");
		myMap.put("rollno", "123");
		String delimiter = "&";
		String separator = "=";
		String result = Joiner.on(delimiter).withKeyValueSeparator(separator).join(myMap);
		String expected ="name=abc&rollno=123";

		System.out.println(result);
	}

}
