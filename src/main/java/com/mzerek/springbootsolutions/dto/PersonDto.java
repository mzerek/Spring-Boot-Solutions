package com.mzerek.springbootsolutions.dto;

import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class PersonDto implements Serializable {
    private Long id;
    private String username;
}
