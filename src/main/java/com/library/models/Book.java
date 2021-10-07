package com.library.models;


import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Book extends BaseEntity{
    private String title;

    @Column(unique = true)
    private String isbn;

    private Boolean isDeleted = false;
    private Boolean isBorrowed = false;
    private String author;
    private String language;
    private Double price;

    @ManyToOne(targetEntity = BookCategory.class)
    BookCategory category;
}
