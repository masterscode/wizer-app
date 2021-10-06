package com.library.services;

import com.library.models.BorrowedBooks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BorrowBookService extends JpaRepository<BorrowedBooks, Long> {
}
