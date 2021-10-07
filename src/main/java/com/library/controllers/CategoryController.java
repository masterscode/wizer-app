package com.library.controllers;

import com.library.models.BookCategory;
import com.library.payloads.requests.CategoryRequest;
import com.library.services.BookCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/category")
public class CategoryController {
    private final BookCategoryService categoryService;

    @PostMapping
    public @ResponseBody BookCategory addCategory(CategoryRequest request){
        return categoryService.addCategory(request);
    }
}
