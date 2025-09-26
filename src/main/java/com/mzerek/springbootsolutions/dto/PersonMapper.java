package com.mzerek.springbootsolutions.dto;

import com.mzerek.springbootsolutions.model.Person;
import org.mapstruct.Mapper;

//https://blog.nashtechglobal.com/mapstruct-and-spring-boot-integration-a-quick-guide/
@Mapper(componentModel = "spring")
public abstract class PersonMapper {

    public abstract PersonDto personToPersonDto(Person person);
}
