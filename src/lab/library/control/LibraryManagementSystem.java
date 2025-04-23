package lab.library.control;

import lab.library.entity.Library;

import java.util.List;

import lab.library.entity.Book;

public class LibraryManagementSystem {
	public static void main(String[] args) {
		Library library = new Library("�߾� ������");
		addSampleBooks(library);
		
        System.out.println();
		
		System.out.println("===== " + library.getName() + " =====");
		System.out.println("��ü ���� ��: " + library.getTotalBooks());
		System.out.println("���� ���� ���� ��: " + library.getAvailableBooksCount());
        System.out.println("���� ���� ���� ��: " + library.getBorrowedBooksCount());
        System.out.println();
		
		testFindBook(library);
		testCheckOut(library);
		testReturn(library);
		displayAvailableBooks(library);
	}
	
	private static void addSampleBooks(Library library) {
	    library.addBook(new Book("�ڹ� ���α׷���", "���ڹ�", "978-89-01-12345-6", 2022));
	    System.out.println("������ �߰��Ǿ����ϴ�: �ڹ� ���α׷���");

	    library.addBook(new Book("��ü������ ��ǰ� ����", "����ȣ", "978-89-01-67890-1", 2015));
	    System.out.println("������ �߰��Ǿ����ϴ�: ��ü������ ��ǰ� ����");

	    library.addBook(new Book("Clean Code", "Robert C. Martin", "978-0-13-235088-4", 2008));
	    System.out.println("������ �߰��Ǿ����ϴ�: Clean Code");

	    library.addBook(new Book("Effective Java", "Joshua Bloch", "978-0-13-468599-1", 2018));
	    System.out.println("������ �߰��Ǿ����ϴ�: Effective Java");

	    library.addBook(new Book("Head First Java", "Kathy Sierra", "978-0-596-00920-5", 2005));
	    System.out.println("������ �߰��Ǿ����ϴ�: Head First Java");

	    library.addBook(new Book("�ڹ��� ����", "���ü�", "978-89-01-14077-4", 2019));
	    System.out.println("������ �߰��Ǿ����ϴ�: �ڹ��� ����");
	}

	
	private static void testFindBook(Library library) {
        System.out.println("===== ���� �˻� �׽�Ʈ =====");

        System.out.println("�������� �˻� ���:");
        Book book = library.findBookByTitle("�ڹ��� ����");
        printBookInfo(book);

        System.out.println("\n���ڷ� �˻� ���:");
        List<Book> booksByAuthor = library.findBooksByAuthor("Robert C. Martin");
        for (Book b : booksByAuthor) {
            printBookInfo(b);
        }
        System.out.println();
    }
	
	private static void testCheckOut(Library library) {
        System.out.println("===== ���� ���� �׽�Ʈ =====");
        boolean success = library.checkOutBook("978-89-01-14077-4");  // �ڹ��� ����
        if (success) {
            System.out.println("���� ���� ����!");
            System.out.println("����� ���� ����:");
            printBookInfo(library.findBookByISBN("978-89-01-14077-4"));
        } else {
            System.out.println("���� ���� ����!");
        }
        System.out.println();

        System.out.println("������ ���� ����:");
        System.out.println("��ü ���� ��: " + library.getTotalBooks());
        System.out.println("���� ���� ���� ��: " + library.getAvailableBooksCount());
        System.out.println("���� ���� ���� ��: " + library.getBorrowedBooksCount());
        System.out.println();
    }
	
	private static void testReturn(Library library) {
        System.out.println("===== ���� �ݳ� �׽�Ʈ =====");
        boolean success = library.returnBook("978-89-01-14077-4");  // �ڹ��� ����
        if (success) {
            System.out.println("���� �ݳ� ����!");
            System.out.println("�ݳ��� ���� ����:");
            printBookInfo(library.findBookByISBN("978-89-01-14077-4"));
        } else {
            System.out.println("���� �ݳ� ����!");
        }
        System.out.println();

        System.out.println("������ ���� ����:");
        System.out.println("��ü ���� ��: " + library.getTotalBooks());
        System.out.println("���� ���� ���� ��: " + library.getAvailableBooksCount());
        System.out.println("���� ���� ���� ��: " + library.getBorrowedBooksCount());
        System.out.println();
    }

	private static void displayAvailableBooks(Library library) {
        System.out.println("===== ���� ������ ���� ��� =====");
        List<Book> availableBooks = library.getAvailableBooks();
        for (Book book : availableBooks) {
            printBookInfo(book);
            System.out.println("------------------------");
        }
    }

	private static void printBookInfo(Book book) {
        if (book == null) {
            System.out.println("���� ������ ã�� �� �����ϴ�.");
            return;
        }
        System.out.println("å ����: " + book.getTitle()
                + "\t����: " + book.getAuthor()
                + "\tISBN: " + book.getIsbn()
                + "\t���ǳ⵵: " + book.getPublishYear()
                + "\t���� ���� ����: " + (book.isAvailable() ? "����" : "���� ��"));
    }

}
