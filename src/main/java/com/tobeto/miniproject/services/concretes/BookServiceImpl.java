package com.tobeto.miniproject.services.concretes;

import com.tobeto.miniproject.entities.Book;
import com.tobeto.miniproject.entities.Category;
import com.tobeto.miniproject.repositories.BookRepository;
import com.tobeto.miniproject.repositories.CategoryRepository;
import com.tobeto.miniproject.services.abstracts.BookService;
import com.tobeto.miniproject.services.dtos.requests.CreateBookRequest;
import com.tobeto.miniproject.services.dtos.responses.ListBookResponse;
import com.tobeto.miniproject.services.mappers.BookMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService
{
    // Dependency Injection
    private BookRepository bookRepository;
    private CategoryRepository categoryRepository;
    public BookServiceImpl(BookRepository bookRepository, CategoryRepository categoryRepository) {
        this.bookRepository = bookRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void add(CreateBookRequest createBookRequest) {
        // Run-Time Error
        //
        Category category = categoryRepository
                .findById(createBookRequest.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Böyle bir kategori bilgisi yok."));
        // Breakpoint
        Book book = BookMapper.INSTANCE.bookFromCreateRequest(createBookRequest);
        // FK ile bağlı entityler => Mapping ile set etmek istenmez.
        book.setCategory(category);
        //
        // 10.25
        // Compile-Time Error
        // No Error => BUG => DEBUGGING
        book = bookRepository.save(book);
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
