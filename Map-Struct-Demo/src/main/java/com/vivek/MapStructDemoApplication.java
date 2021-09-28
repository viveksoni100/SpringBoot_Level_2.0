package com.vivek;

import com.vivek.dto.StudentDTO;
import com.vivek.entity.Student;
import com.vivek.mapper.StudentMapper;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MapStructDemoApplication implements ApplicationRunner {

    public static void main(String[] args) {
        SpringApplication.run(MapStructDemoApplication.class, args);
    }

	@Override
	public void run(ApplicationArguments args) throws Exception {
		Student student = new Student(10L, "Vivek");
		StudentDTO studentDTO = StudentMapper.INSTANCE.map(student);
		System.out.println(studentDTO);
	}
}
