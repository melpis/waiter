package com.waiter.core.application;

import com.waiter.core.domain.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CategoryService {
    private CategoryRepository categoryRepository;
}
