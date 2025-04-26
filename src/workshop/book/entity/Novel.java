package workshop.book.entity;

public class Novel extends Publication {
	private String author;
	private String genre;
	
	
	public Novel() {
	}

	public Novel(String title, String publishingDate, int page, int price, String author, String genre) {
		super(title, publishingDate, page, price);
		this.author = author;
		this.genre = genre;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	//추가-소설 정보를 상세히 표시
	@Override
	public String toString() {
		return "[소설] 저자:" + author + ", 장르:" + genre + ", " 
		     + getPage() + "쪽, " 
		     + getPrice() + "원, " 
		     + "출판일:" + getPublishingDate();
	}
}
