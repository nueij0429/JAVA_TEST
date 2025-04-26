package workshop.book.entity;

public class Magazine extends Publication {
	private String publishingPeriod;
	
	public Magazine() {
		
	}

	public Magazine(String title, String publishingDate, int page, int price, String publishingPeriod) {
		super(title, publishingDate, page, price);
		this.publishingPeriod = publishingPeriod;
	
	}
	public String getPublishingPeriod() {
		return publishingPeriod;
	}
	
//	public void setpublishingPeriod(String publishingPeriod) {
//		this.publishingPeriod = publishingPeriod;
//	}
	
	//추가-잡지 정보를 상세히 표시
	@Override
	public String toString() {
		return "[잡지] 발행주기:" + publishingPeriod + ", " 
		     + getPage() + "쪽, " 
		     + getPrice() + "원, " 
		     + "출판일:" + getPublishingDate();
	}
}
