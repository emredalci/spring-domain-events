package org.example.springdomainevents.entity;

import jakarta.persistence.*;
import org.example.springdomainevents.messaging.event.BookChangedInfoEvent;
import org.example.springdomainevents.messaging.event.BookSoldEvent;
import org.springframework.data.domain.AbstractAggregateRoot;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.CascadeType.ALL;
import static jakarta.persistence.FetchType.LAZY;
import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table
public class Book extends AbstractAggregateRoot<Book> {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String name;

    private String description;

    private OffsetDateTime dateCreated;

    private OffsetDateTime lastDateUpdated;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "author_id")
    private Author author;

    private int price;

    @OneToMany(fetch = LAZY, mappedBy = "book", cascade = ALL)
    private List<BookSale> bookSales = new ArrayList<>();

    public Book() {
    }

    public Book(String name, String description, OffsetDateTime dateCreated, OffsetDateTime lastDateUpdated, Author author, int price) {
        this.name = name;
        this.description = description;
        this.dateCreated = dateCreated;
        this.lastDateUpdated = lastDateUpdated;
        this.author = author;
        this.price = price;
    }

    public void sell() {
        var bookSale = new BookSale();
        bookSale.setBook(this);
        bookSale.setDateSold(OffsetDateTime.now());
        bookSale.setPriceSold(price);
        bookSales.add(bookSale);
        var bookUpdated = new BookSoldEvent(bookSale);
        registerEvent(bookUpdated);
    }

    public void changeInfo(String name, String description) {
        this.name = name;
        this.description = description;
        this.lastDateUpdated = OffsetDateTime.now();
        BookChangedInfoEvent bookChangedInfoEvent = new BookChangedInfoEvent(this);
        registerEvent(bookChangedInfoEvent);
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public OffsetDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(OffsetDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    public OffsetDateTime getLastDateUpdated() {
        return lastDateUpdated;
    }

    public void setLastDateUpdated(OffsetDateTime lastDateUpdated) {
        this.lastDateUpdated = lastDateUpdated;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public List<BookSale> getBookSales() {
        return bookSales;
    }

    public void setBookSales(List<BookSale> bookSales) {
        this.bookSales = bookSales;
    }
}
