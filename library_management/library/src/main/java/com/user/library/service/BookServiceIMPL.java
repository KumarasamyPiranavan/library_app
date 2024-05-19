package com.user.library.service;

import com.user.library.DTO.BookDTO;
import com.user.library.DTO.BookSaveDTO;
import com.user.library.entity.Book;
import com.user.library.entity.User;
import com.user.library.repository.BookRepository;
import com.user.library.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceIMPL implements BookService{

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public String addBook(BookSaveDTO bookSaveDTO) {

        //fetch the user entity by id
        User client = userRepository.findById(bookSaveDTO.getClient().getId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid user ID" + bookSaveDTO.getClient()));

        // create a new book entity
       Book book = new Book(

               bookSaveDTO.getTitle(),
               bookSaveDTO.getAuthor(),
               bookSaveDTO.getStatus(),
               client
       );
       bookRepository.save(book);

       return book.getTitle();
    }

    @Override
    public List<BookDTO> getAllBook() {
        List<Book> getBooks = bookRepository.findAll();
        List<BookDTO> bookDTOList = new ArrayList<>();
        for(Book a:getBooks)
        {
            BookDTO bookDTO = new BookDTO(
                    a.getId(),
                    a.getTitle(),
                    a.getAuthor(),
                    a.getStatus(),
                    a.getClient()
            );
            bookDTOList.add(bookDTO);
        }
        return bookDTOList;
    }

    @Override
    public BookDTO getBookById(int id) {
        Optional<Book> book = bookRepository.findById((long) id);

        if (book.isPresent()){
            Book a = book.get();
            return new BookDTO(
                    a.getId(),
                    a.getTitle(),
                    a.getAuthor(),
                    a.getStatus(),
                    a.getClient()
            );
        }
        else {
            return null;
        }
    }
}
