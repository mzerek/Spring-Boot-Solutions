package com.mzerek.springbootsolutions.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
public class PersonDto {

    private Long id;
    private String username;
}
