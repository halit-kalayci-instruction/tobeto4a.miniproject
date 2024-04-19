package com.tobeto.miniproject.services.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateBookResponse
{
    private int id;
    private String name;
    private String author;
    private String categoryName;
}
