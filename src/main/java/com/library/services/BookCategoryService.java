package com.library.services;

import com.library.models.BookCategory;
import com.library.payloads.requests.CategoryRequest;

import java.util.List;

public interface BookCategoryService {
    BookCategory addCategory(CategoryRequest request);
    List<BookCategory> getAllCategory();
    BookCategory editCategory(Long id, CategoryRequest editRequest);
}
