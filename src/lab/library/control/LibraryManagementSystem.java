package lab.library.control;

import lab.library.entity.Library;

import java.util.List;

import lab.library.entity.Book;

public class LibraryManagementSystem {
	public static void main(String[] args) {
		Library library = new Library("중앙 도서관");
		addSampleBooks(library);
		
        System.out.println();
		
		System.out.println("===== " + library.getName() + " =====");
		System.out.println("전체 도서 수: " + library.getTotalBooks());
		System.out.println("대출 가능 도서 수: " + library.getAvailableBooksCount());
        System.out.println("대출 중인 도서 수: " + library.getBorrowedBooksCount());
        System.out.println();
		
		testFindBook(library);
		testCheckOut(library);
		testReturn(library);
		displayAvailableBooks(library);
	}
	
	private static void addSampleBooks(Library library) {
	    library.addBook(new Book("자바 프로그래밍", "김자바", "978-89-01-12345-6", 2022));
	    System.out.println("도서가 추가되었습니다: 자바 프로그래밍");

	    library.addBook(new Book("객체지향의 사실과 오해", "조영호", "978-89-01-67890-1", 2015));
	    System.out.println("도서가 추가되었습니다: 객체지향의 사실과 오해");

	    library.addBook(new Book("Clean Code", "Robert C. Martin", "978-0-13-235088-4", 2008));
	    System.out.println("도서가 추가되었습니다: Clean Code");

	    library.addBook(new Book("Effective Java", "Joshua Bloch", "978-0-13-468599-1", 2018));
	    System.out.println("도서가 추가되었습니다: Effective Java");

	    library.addBook(new Book("Head First Java", "Kathy Sierra", "978-0-596-00920-5", 2005));
	    System.out.println("도서가 추가되었습니다: Head First Java");

	    library.addBook(new Book("자바의 정석", "남궁성", "978-89-01-14077-4", 2019));
	    System.out.println("도서가 추가되었습니다: 자바의 정석");
	}

	
	private static void testFindBook(Library library) {
        System.out.println("===== 도서 검색 테스트 =====");

        System.out.println("제목으로 검색 결과:");
        Book book = library.findBookByTitle("자바의 정석");
        printBookInfo(book);

        System.out.println("\n저자로 검색 결과:");
        List<Book> booksByAuthor = library.findBooksByAuthor("Robert C. Martin");
        for (Book b : booksByAuthor) {
            printBookInfo(b);
        }
        System.out.println();
    }
	
	private static void testCheckOut(Library library) {
        System.out.println("===== 도서 대출 테스트 =====");
        boolean success = library.checkOutBook("978-89-01-14077-4");  // 자바의 정석
        if (success) {
            System.out.println("도서 대출 성공!");
            System.out.println("대출된 도서 정보:");
            printBookInfo(library.findBookByISBN("978-89-01-14077-4"));
        } else {
            System.out.println("도서 대출 실패!");
        }
        System.out.println();

        System.out.println("도서관 현재 상태:");
        System.out.println("전체 도서 수: " + library.getTotalBooks());
        System.out.println("대출 가능 도서 수: " + library.getAvailableBooksCount());
        System.out.println("대출 중인 도서 수: " + library.getBorrowedBooksCount());
        System.out.println();
    }
	
	private static void testReturn(Library library) {
        System.out.println("===== 도서 반납 테스트 =====");
        boolean success = library.returnBook("978-89-01-14077-4");  // 자바의 정석
        if (success) {
            System.out.println("도서 반납 성공!");
            System.out.println("반납된 도서 정보:");
            printBookInfo(library.findBookByISBN("978-89-01-14077-4"));
        } else {
            System.out.println("도서 반납 실패!");
        }
        System.out.println();

        System.out.println("도서관 현재 상태:");
        System.out.println("전체 도서 수: " + library.getTotalBooks());
        System.out.println("대출 가능 도서 수: " + library.getAvailableBooksCount());
        System.out.println("대출 중인 도서 수: " + library.getBorrowedBooksCount());
        System.out.println();
    }

	private static void displayAvailableBooks(Library library) {
        System.out.println("===== 대출 가능한 도서 목록 =====");
        List<Book> availableBooks = library.getAvailableBooks();
        for (Book book : availableBooks) {
            printBookInfo(book);
            System.out.println("------------------------");
        }
    }

	private static void printBookInfo(Book book) {
        if (book == null) {
            System.out.println("도서 정보를 찾을 수 없습니다.");
            return;
        }
        System.out.println("책 제목: " + book.getTitle()
                + "\t저자: " + book.getAuthor()
                + "\tISBN: " + book.getIsbn()
                + "\t출판년도: " + book.getPublishYear()
                + "\t대출 가능 여부: " + (book.isAvailable() ? "가능" : "대출 중"));
    }

}
