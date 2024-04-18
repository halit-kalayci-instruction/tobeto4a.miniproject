package com.tobeto.miniproject.services.abstracts;

import com.tobeto.miniproject.entities.Book;
import com.tobeto.miniproject.services.dtos.requests.CreateBookRequest;
import com.tobeto.miniproject.services.dtos.responses.ListBookResponse;

import java.util.List;

public interface BookService
{
    void add(CreateBookRequest createBookRequest);
    void update();
    void delete(int id);
    List<ListBookResponse> getAll();
    Book getById(int id);
}
