package com.kodilla.kodillalibrary.domain;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "readers")
public class Reader {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reader_id", unique = true)
    private Long id;

    @Column(name = "first_name" , nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "joining_date", nullable = false)
    private LocalDate joined;

    @OneToMany(targetEntity = Rental.class,
            mappedBy = "reader",
            cascade = CascadeType.PERSIST,
            fetch = FetchType.EAGER)
    private List<Rental> rentals = new ArrayList<>();

}
