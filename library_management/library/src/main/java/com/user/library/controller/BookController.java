package com.user.library.controller;

import com.user.library.DTO.BookDTO;
import com.user.library.DTO.BookSaveDTO;
import com.user.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("/save")
    public String addBook(@RequestBody BookSaveDTO bookSaveDTO){
        String id = bookService.addBook(bookSaveDTO);
        return id;
    }

    @GetMapping("/all")
    public List<BookDTO> getAllBook(){
        List<BookDTO> allBooks = bookService.getAllBook();
        return allBooks;
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookDTO> getBookById(@PathVariable(value = "id") int id){
        BookDTO bookDTO = bookService.getBookById(id);

        if (bookDTO != null){
            return ResponseEntity.ok(bookDTO); // 200 ok with data
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); //404 Not Found with no bodt
        }
    }

}
