package com.tobeto.miniproject.controllers;

import com.tobeto.miniproject.entities.Book;
import com.tobeto.miniproject.services.abstracts.BookService;
import com.tobeto.miniproject.services.dtos.requests.CreateBookRequest;
import com.tobeto.miniproject.services.dtos.responses.CreateBookResponse;
import com.tobeto.miniproject.services.dtos.responses.ListBookResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
public class BooksController {
    private BookService bookService;

    public BooksController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public CreateBookResponse add(@RequestBody CreateBookRequest request)
    {
        return bookService.add(request);
    }

    @GetMapping
    public List<ListBookResponse> getAll()
    {
        return bookService.getAll();
    }

    @GetMapping("{id}")
    public Book getById(@RequestParam int id)
    {
        return bookService.getById(id);
    }
}
