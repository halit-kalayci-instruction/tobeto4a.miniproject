package com.tobeto.miniproject.services.mappers;

import com.tobeto.miniproject.entities.Book;
import com.tobeto.miniproject.services.dtos.requests.CreateBookRequest;
import com.tobeto.miniproject.services.dtos.responses.CreateBookResponse;
import com.tobeto.miniproject.services.dtos.responses.ListBookResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BookMapper {
    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class); // kalıp

    @Mapping(target="isbn", source = "serialNumber")
    //@Mapping(target = "category.id", source = "categoryId")
    Book bookFromCreateRequest(CreateBookRequest createBookRequest);

    ListBookResponse listResponseFromBook(Book book);

    @Mapping(target = "categoryName", source = "category.name")
    CreateBookResponse createResponseFromBook(Book book);
}
