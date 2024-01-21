package org.example.springdomainevents.entity;

import jakarta.persistence.*;

import java.time.OffsetDateTime;

import static jakarta.persistence.FetchType.LAZY;

@Entity
@Table
public class BookSale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int priceSold;

    private OffsetDateTime dateSold;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "book_id")
    private Book book;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getPriceSold() {
        return priceSold;
    }

    public void setPriceSold(int priceSold) {
        this.priceSold = priceSold;
    }

    public OffsetDateTime getDateSold() {
        return dateSold;
    }

    public void setDateSold(OffsetDateTime dateSold) {
        this.dateSold = dateSold;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
