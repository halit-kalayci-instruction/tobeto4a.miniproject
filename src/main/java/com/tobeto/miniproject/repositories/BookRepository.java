package com.tobeto.miniproject.repositories;

import com.tobeto.miniproject.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

// Repository => Depo
public interface BookRepository extends JpaRepository<Book, Integer>
{
}
