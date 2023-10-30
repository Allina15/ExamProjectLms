package org.example.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Table(name = "publishers")
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;
    @ManyToMany(cascade = {CascadeType.PERSIST},fetch = FetchType.EAGER)
    @ToString.Exclude
    private List<Author> authors;

    @OneToMany(mappedBy = "publisher")
    @ToString.Exclude
    private List<Book>books;

    public Publisher(String name, String address) {
        this.name = name;
        this.address = address;
    }
}
