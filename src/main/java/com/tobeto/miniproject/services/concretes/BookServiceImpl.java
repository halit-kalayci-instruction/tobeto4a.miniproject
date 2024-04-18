package com.tobeto.miniproject.services.concretes;

import com.tobeto.miniproject.entities.Book;
import com.tobeto.miniproject.repositories.BookRepository;
import com.tobeto.miniproject.services.abstracts.BookService;
import com.tobeto.miniproject.services.dtos.requests.CreateBookRequest;
import com.tobeto.miniproject.services.dtos.responses.ListBookResponse;
import com.tobeto.miniproject.services.mappers.BookMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService
{
    private BookRepository bookRepository;
    // Dependency Injection
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void add(CreateBookRequest createBookRequest) {
        Book book = BookMapper.INSTANCE.bookFromCreateRequest(createBookRequest);

        bookRepository.save(book);
    }

    @Override
    public void update() {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<ListBookResponse> getAll() {
        List<Book> books = bookRepository.findAll();
        // Book -> ListBookResponse

        List<ListBookResponse> list =
                books
                        .stream()
                        .map((book) -> BookMapper.INSTANCE.listResponseFromBook(book))
                        .toList();

        return list;
    }

    @Override
    public Book getById(int id) {
        return null;
    }
}
