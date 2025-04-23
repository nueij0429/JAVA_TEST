package lab.library.entity;

import java.util.List;

public class Book {
	private String title;
	private String author;
	private String isbn;
	private int publishYear;
	private boolean isAvailable;
	
	public Book() {
		this.isAvailable = true; //대출 가능 상태
	}

	public Book(String title, String author, String isbn, int publishYear) {
		super();
		this.title = title;
		this.author = author;
		this.isbn = isbn;
		this.publishYear = publishYear;
		this.isAvailable = true; //대출 가능 상태는 true
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public int getPublishYear() {
		return publishYear;
	}

	public void setPublishYear(int publishYear) {
		this.publishYear = publishYear;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	//도서 대출 메서드
	public boolean checkOut() {
		if(isAvailable) {
			isAvailable = false;
			return true;
		}
		return false;
	}
	
	//도서 반납 메서드
    public void returnBook() {
    	isAvailable = true;
    }

	@Override
	public String toString() {
		return "Book [title=" + title + ", author=" + author + ", isbn=" + isbn + ", publishYear=" + publishYear
				+ ", isAvailable=" + isAvailable + "]";
	}
    
    
	
}
