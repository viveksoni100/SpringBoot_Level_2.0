package com.vivek.mapper;

import com.vivek.dto.StudentDTO;
import com.vivek.entity.Student;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-09-28T19:03:27+0530",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_241 (Oracle Corporation)"
)
public class StudentMapperImpl implements StudentMapper {

    @Override
    public StudentDTO map(Student student) {
        if ( student == null ) {
            return null;
        }

        StudentDTO studentDTO = new StudentDTO();

        studentDTO.setRollNumber( student.getRollNumber() );
        studentDTO.setName( student.getName() );

        return studentDTO;
    }
}
