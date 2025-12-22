package com.library.book;

public class Book {
	String bookId;
	String title;
	String author;
	int totalCopies;
	int availableCopies;

	public Book(String bookId, String title, String author, int copies) {
		this.bookId = bookId;
		this.title = title;
		this.author = author;
		this.totalCopies = copies;
		this.availableCopies = copies;
	}

	@Override
	public String toString() {
		return bookId + " - " + title + " by " + author + " (Available: " + availableCopies + ")";
	}
}
