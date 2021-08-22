package com.bookapp.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.bookapp.exception.BookNotFoundException;
import com.bookapp.model.Book;

public class BookServiceImpl implements BookService {

	public BookServiceImpl() {

	}

	@Override
	public Book getBookById(int bookid) throws BookNotFoundException {
		boolean flag = false;
		Book b = null;
		for (Book book : showBooks()) {
			if (bookid == book.getBookid()) {
				flag = true;
				b = book;

			}
		}

		if (!flag) {
			throw new BookNotFoundException("Invalid id");
		}

		return b;
	}

	@Override
	public List<Book> getBookByAuthor(String author) throws BookNotFoundException {
		boolean flag = false;
		List<Book> booksByAuthor = new ArrayList<>();
		for (Book book : showBooks()) {
			if (author.equalsIgnoreCase(book.getAuthor())) {
				flag = true;
				booksByAuthor.add(book);
			}
		}

		if (!flag) {
			throw new BookNotFoundException("Author is  not found ");
		}

		return booksByAuthor;
	}

	@Override
	public List<Book> getBooksByCategory(String category) throws BookNotFoundException {
		boolean flag = false;
		List<Book> booksByCategory = new ArrayList<>();
		for (Book book : showBooks()) {
			if (category.equalsIgnoreCase(book.getCategory())) {
				flag = true;
				booksByCategory.add(book);

			}
		}

		if (!flag) {
			throw new BookNotFoundException("catogory is  not found ");
		}

		return booksByCategory;
	}

	@Override
	public List<Book> getBooksByTitle(String title) throws BookNotFoundException {
		boolean flag = false;
		List<Book> booksByTitle = new ArrayList<>();
		for (Book book : showBooks()) {
			if (title.equalsIgnoreCase(book.getTitle())) {
				flag = true;
				booksByTitle.add(book);

			}
		}

		if (!flag) {
			throw new BookNotFoundException("Title  is  not found ");
		}

		return booksByTitle;

	}

	@Override
	public List<Book> getAllBooks() throws BookNotFoundException {

		return showBooks();
	}

	@Override
	public List<Book> getBooksByLessPrice(double price) throws BookNotFoundException {
		boolean flag = false;
		List<Book> bookPrice = new ArrayList<>();
		for (Book book : showBooks()) {
			if (price >= book.getPrice()) {
				flag = true;
				bookPrice.add(book);

			}
		}

		if (!flag) {
			throw new BookNotFoundException("Sorry book is not found at the given price range ");
		}

		return bookPrice;
	}

	private List<Book> showBooks() {

		return Arrays.asList(new Book("Java", "kathy", "Tech", 1900, 1), new Book("Sam club", "robin", "Self", 900, 2),
				new Book("Captain", "jp", "children", 100, 3), new Book("Mansion", "robin", "self", 700, 4),
				new Book("Leadership", "apj", "novel", 180, 5));

	}

}
