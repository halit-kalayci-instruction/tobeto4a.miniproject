package com.tobeto.miniproject.services.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateBookRequest
{
    private String name;
    private String author;
    private String serialNumber;
    private int pageCount;
}
