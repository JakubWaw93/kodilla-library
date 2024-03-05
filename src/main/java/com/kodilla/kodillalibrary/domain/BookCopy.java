package com.kodilla.kodillalibrary.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity(name = "book_Copies")
public class BookCopy {

    @Id
    @GeneratedValue
    @NotNull
    private Long id;

    @Column(name = "title_Id")
    @NotNull
    private Long titleId;

    @Column(name = "status")
    @NotNull
    private BookStatus status;


}
