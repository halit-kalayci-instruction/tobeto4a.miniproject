package com.tobeto.miniproject.services.abstracts;

import com.tobeto.miniproject.entities.Category;

import java.util.Optional;

public interface CategoryService
{
    Category findById(int id);
}
