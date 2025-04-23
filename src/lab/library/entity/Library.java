package lab.library.entity;

import java.util.ArrayList;
import java.util.List;

public class Library {
	private List<Book> books;
	private String name;
	
	public Library(String name) {
		this.name = name;
		this.books = new ArrayList<>();
	}
	
	//���� �߰� �޼���
	public void addBook(Book book) {
		books.add(book);
	}
	
	//�������� ���� �˻�
	public Book findBookByTitle(String title) {
		for(Book book : books) {
			if(book.getTitle().equals(title)) {
				return book;
			}
		}
		return null;
	}
	
	//���ڸ����� ���� �˻�
	public List<Book> findBooksByAuthor(String author) {
		List<Book> result = new ArrayList<>();
		for(Book book : books) {
			if(book.getAuthor().contentEquals(author)) {
				result.add(book);
			}
		}
		return result;
	}
	
	//ISBN���� ���� �˻�
	public Book findBookByISBN(String isbn) {
		for(Book book : books) {
			if(book.getIsbn().equals(isbn)) {
				return book;
			}
		}
		return null;
	}
	
    // ���� ����
    public boolean checkOutBook(String isbn) {
        Book book = findBookByISBN(isbn);
        if (book != null && book.isAvailable()) {
            return book.checkOut();
        }
        return false;
    }
    
    // ���� �ݳ�
	public boolean returnBook(String isbn) {
		for(Book book : books) {
			if(book != null && !book.isAvailable()) {
				book.returnBook();
				return true;
			}
		}
		return false;
	}
	
    // ���� ������ ���� ���
	public List<Book> getAvailableBooks() {
		List<Book> availableBooks = new ArrayList<>();
		for(Book book : books) {
			if(book.isAvailable()) {
				availableBooks.add(book);
			}
		}
		return availableBooks;
	}
	
	// ��ü ���� ���
    public List<Book> getAllBooks() {
        return new ArrayList<>(books);
    }
    
    //���� �� ����
    public int getTotalBooks() {
    	return books.size();
    }
    
    //���� ������ ���� ��
    public int getAvailableBooksCount() {
    	int count = 0;
    	for(Book book : books) {
    		if(book.isAvailable()) {
    			count++;
    		}
    	}
    	return count;
    }
    
    //���� ���� ���� ��
    public int getBorrowedBooksCount() {
    	return getTotalBooks() - getAvailableBooksCount();
    }
    
    public String getName() {
        return name;
    }
}
