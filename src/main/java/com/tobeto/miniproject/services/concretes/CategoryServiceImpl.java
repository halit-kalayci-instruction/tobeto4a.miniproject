package com.tobeto.miniproject.services.concretes;

import com.tobeto.miniproject.core.utils.exceptionhandling.types.BusinessException;
import com.tobeto.miniproject.entities.Category;
import com.tobeto.miniproject.repositories.CategoryRepository;
import com.tobeto.miniproject.services.abstracts.CategoryService;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {
    private CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category findById(int id) {
        return categoryRepository.findById(id).orElseThrow(() -> new BusinessException("Böyle bir kategori bulunamadı."));
    }
}
