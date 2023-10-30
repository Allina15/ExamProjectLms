package org.example.entity;

import jakarta.persistence.*;
import lombok.*;
import org.example.enums.Gender;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Table(name = "authors")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String first_name;
    private String last_name;
    private String email;
    private LocalDate date_ofBirth;
    private String country;
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @ManyToMany(mappedBy = "authors",cascade = CascadeType.REMOVE)
    @ToString.Exclude
    private List<Publisher>publishers;

    @OneToMany(mappedBy = "author",cascade = CascadeType.PERSIST)
    @ToString.Exclude
    private List<Book>books;

    public Author(String first_name, String last_name, String email, LocalDate date_ofBirth, String country, Gender gender) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.date_ofBirth = date_ofBirth;
        this.country = country;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Author{" +
                "first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", email='" + email + '\'' +
                ", date_ofBirth=" + date_ofBirth +
                ", country='" + country + '\'' +
                ", gender=" + gender +
                '}';
    }
}
