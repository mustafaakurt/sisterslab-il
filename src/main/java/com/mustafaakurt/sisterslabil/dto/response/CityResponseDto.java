package com.mustafaakurt.sisterslabil.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class CityResponseDto {
    private String name;
    private String plateNumber;
    private Date createdDate;
}
