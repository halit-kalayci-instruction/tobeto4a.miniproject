package com.tobeto.miniproject.services.mappers;

import com.tobeto.miniproject.entities.Book;
import com.tobeto.miniproject.services.dtos.requests.CreateBookRequest;
import com.tobeto.miniproject.services.dtos.responses.ListBookResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BookMapper {
    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class); // kalıp

    @Mapping(target="isbn", source = "serialNumber")
    Book bookFromCreateRequest(CreateBookRequest createBookRequest);

    ListBookResponse listResponseFromBook(Book book);
}
