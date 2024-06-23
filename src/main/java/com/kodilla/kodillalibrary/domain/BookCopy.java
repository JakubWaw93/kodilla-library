package com.kodilla.kodillalibrary.domain;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity(name = "bookCopies")
public class BookCopy {

    @Id
    @GeneratedValue
    @Column(name = "bookCopy_Id", unique = true)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "title_id", referencedColumnName = "title_id", nullable = false)
    private Title title;

    @Column(name = "status")
    private BookStatus status = BookStatus.AVAILABLE;

    @OneToMany(
            targetEntity = Rental.class,
            mappedBy = "bookCopy",
            fetch = FetchType.EAGER,
            cascade = CascadeType.PERSIST)
    private List<Rental> rentals = new ArrayList<>();


}
