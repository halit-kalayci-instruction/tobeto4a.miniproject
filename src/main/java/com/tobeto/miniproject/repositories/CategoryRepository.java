package com.tobeto.miniproject.repositories;

import com.tobeto.miniproject.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer>
{

}
