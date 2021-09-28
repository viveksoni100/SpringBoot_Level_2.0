package com.vivek;

import com.vivek.dto.StudentDTO;
import com.vivek.entity.Student;
import com.vivek.mapper.StudentMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MapStructDemoApplicationTests {

	@Test
	void contextLoads() {
		Student student = new Student(10L, "Vivek");
		StudentDTO studentDTO = StudentMapper.INSTANCE.map(student);
		System.out.println(studentDTO);
	}

}
