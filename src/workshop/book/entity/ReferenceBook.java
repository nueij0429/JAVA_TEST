package workshop.book.entity;

public class ReferenceBook extends Publication {
	private String field;

	public ReferenceBook() {
		
	}

	public ReferenceBook(String title, String publishingDate, int page, int price, String field) {
		super(title, publishingDate, page, price);
		this.field = field;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}
	
	//추가-참고서 정보를 상세히 표시
	@Override
	public String toString() {
		return "[참고서] 분야:" + field + ", " 
		     + getPage() + "쪽, " 
		     + getPrice() + "원, " 
		     + "출판일:" + getPublishingDate();
	}
}
