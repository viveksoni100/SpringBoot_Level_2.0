package com.vivek.mapper;

import com.vivek.dto.StudentDTO;
import com.vivek.entity.Student;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StudentMapper {

    StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);

    StudentDTO map(Student student);

}
