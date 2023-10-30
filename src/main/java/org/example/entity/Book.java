package org.example.entity;

import jakarta.persistence.*;
import lombok.*;
import org.example.enums.Genre;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   private String name;
   private String country;
   private int published_year;
   private int price;
   @Enumerated(EnumType.STRING)
   private Genre genre;

   @ManyToOne(cascade = CascadeType.PERSIST)
   private Publisher publisher;

   @ManyToOne(cascade = CascadeType.PERSIST)
   private Author author;

   @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
   private List<Reader> readers;

   public Book(String name, String country, int published_year, int price, Genre genre) {
      this.name = name;
      this.country = country;
      this.published_year = published_year;
      this.price = price;
      this.genre = genre;
   }

   @Override
   public String toString() {
      return "Book{" +
              "name='" + name + '\'' +
              ", country='" + country + '\'' +
              ", published_year=" + published_year +
              ", price=" + price +
              ", genre=" + genre +
              ", publisher=" + publisher +
              ", author=" + author +
              ", readers=" + readers +
              '}';
   }
}
