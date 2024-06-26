package com.tobeto.miniproject.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="books") // snake_case, lowercase, UPPERCASE, kebab-case, PascalCase
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    @Column(name="id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="name")
    private String name;

    private String author;

    @Column(name="page_count")
    private int pageCount; // camelCase

    private String isbn;

    @ManyToOne()
    @JoinColumn(name="category_id")
    private Category category;
}
// Cascade
    // REMOVE => Bir entity silinirse, ona bağlı entityler de silinir

// Fetch => İlişkili verinin ne zaman yükleneceğini belirtir.
    // LAZY => Veri başlangıçta değil ilk kullanıldığında yüklenir.
    // EAGER => Veri başlangıçta (ana sorguda) yüklenir.