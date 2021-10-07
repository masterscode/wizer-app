package com.library.services.implementations;

import com.library.models.BookCategory;
import com.library.payloads.requests.CategoryRequest;
import com.library.repositories.BookCategoryRepository;
import com.library.services.BookCategoryService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookCategoryServiceImpl implements BookCategoryService {
    private final BookCategoryRepository categoryRepository;
    private final ModelMapper modelMapper;
    @Override
    public BookCategory addCategory(CategoryRequest request) {
        return categoryRepository.save(
                modelMapper.map(request, BookCategory.class)
        );

    }

    @Override
    public List<BookCategory> getAllCategory() {
        return categoryRepository.findAll();
    }

    @Override
    public BookCategory editCategory(Long id, CategoryRequest editRequest) {
        var categoryToEdit = categoryRepository.findById(id).orElseThrow();
        categoryToEdit.setName(editRequest.getName());
        return  categoryRepository.save(categoryToEdit);
    }
}
