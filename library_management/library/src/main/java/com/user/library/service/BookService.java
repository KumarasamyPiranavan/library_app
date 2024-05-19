package com.user.library.service;

import com.user.library.DTO.BookDTO;
import com.user.library.DTO.BookSaveDTO;

import java.util.List;

public interface BookService {
    String addBook(BookSaveDTO bookSaveDTO);

    List<BookDTO> getAllBook();

    BookDTO getBookById(int id);
}
