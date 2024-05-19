package com.user.library.entity;

import com.user.library.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String author;
    private Status status;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User client;

    public Book(String title, String author, Status status, User client) {
        this.title = title;
        this.author = author;
        this.status = status;
        this.client = client;
    }
}
