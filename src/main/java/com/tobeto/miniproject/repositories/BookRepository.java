package com.tobeto.miniproject.repositories;

import com.tobeto.miniproject.entities.Book;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

// Repository => Depo
public interface BookRepository extends JpaRepository<Book, Integer>
{
    // ÖZEL SORGULAR

    // Derived Query Methods
    List<Book> findByAuthor(String author, Pageable pageable);
    // Select * from books where author=author

    // Custom Queries
    @Query(value="Select * from books where author=:authorName", nativeQuery = true)
    List<Book> searchByAuthorName(String authorName, Pageable pageable);

    // JPA + SQL => JPQL
    @Query(value="Select b from Book b Where b.author=:authorName ORDER BY b.pageCount DESC" ,  nativeQuery = false)
    List<Book> searchByAuthorTop3(String authorName, Pageable pageable);
}
