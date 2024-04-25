package com.tobeto.miniproject.services.concretes;

import com.tobeto.miniproject.entities.Book;
import com.tobeto.miniproject.entities.Category;
import com.tobeto.miniproject.repositories.BookRepository;
import com.tobeto.miniproject.repositories.CategoryRepository;
import com.tobeto.miniproject.services.abstracts.BookService;
import com.tobeto.miniproject.services.abstracts.CategoryService;
import com.tobeto.miniproject.services.dtos.requests.CreateBookRequest;
import com.tobeto.miniproject.services.dtos.responses.CreateBookResponse;
import com.tobeto.miniproject.services.dtos.responses.ListBookResponse;
import com.tobeto.miniproject.services.mappers.BookMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;

@Service
public class BookServiceImpl implements BookService
{
    // Dependency Injection
    private BookRepository bookRepository;
    private CategoryService categoryService;
    public BookServiceImpl(BookRepository bookRepository, CategoryService categoryService) {
        this.bookRepository = bookRepository;
        this.categoryService = categoryService;
    }

    @Override
    public CreateBookResponse add(CreateBookRequest createBookRequest) {
        // Run-Time Error
        Category category = categoryService
                .findById(createBookRequest.getCategoryId());
        // Breakpoint
        Book book = BookMapper.INSTANCE.bookFromCreateRequest(createBookRequest);
        // FK ile bağlı entityler => Mapping ile set etmek istenmez.
        book.setCategory(category);
        // Compile-Time Error
        // No Error => BUG => DEBUGGING
        book = bookRepository.save(book);

        CreateBookResponse response = BookMapper.INSTANCE.createResponseFromBook(book);
        return response;
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
   // 2.15 - Spring Security
    @Override
    public Book getById(int id) {
        return null;
    }

    @Override
    public List<ListBookResponse> findByAuthorName(String authorName, int page, int pageSize) {
        List<Book> books = bookRepository.searchByAuthorTop3(authorName, PageRequest.of(page, pageSize));

        List<ListBookResponse> response = books.
                stream()
                .map((book) -> BookMapper.INSTANCE.listResponseFromBook(book))
                .toList();

        return response;
    }
}
