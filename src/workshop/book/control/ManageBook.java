package workshop.book.control;

import workshop.book.entity.Magazine;
import workshop.book.entity.Novel;
import workshop.book.entity.Publication;
import workshop.book.entity.ReferenceBook;

public class ManageBook {

	public static void main(String[] args) {
		//Publication 타입 배열을 선언 및 생성
		Publication[] pubs = new Publication[7];
		pubs[0] = new Magazine("마이크로소프트", "2007-10-01", 328, 9900, "매월");
		pubs[1] = new Magazine("경영과컴퓨터", "2007-10-03", 316, 9000, "매월");
        pubs[2] = new Novel("빠삐용", "2007-07-01", 396, 9800, "베르나르베르베르", "현대소설");
        pubs[3] = new Novel("남한산성", "2007-04-14", 383, 11000, "김훈", "대하소설");
        pubs[4] = new ReferenceBook("실용주의프로그래머", "2007-01-14", 496, 25000, "소프트웨어공학");
        pubs[5] = new Novel("소년이온다", "2014-05-01", 216, 15000, "한강", "장편소설");
        pubs[6] = new Novel("작별하지않는다", "2021-09-09", 332, 15120, "한강", "장편소설");
        
        //수정-일련번호 + 제목 + 세부정보 출력
        System.out.println("==== 도서 정보 출력 ====");
        for (int i = 0; i < pubs.length; i++) {
            Publication p = pubs[i];
            System.out.println((i + 1) + ". " + p.getTitle() + " " + p.toString());
        }
        System.out.println("");
        
        //수정-원래 가격+할인된 가격
        Publication target = pubs[6];
        int originalPrice = target.getPrice();
        System.out.println("==== 가격 변경 ====");
        System.out.println(target.getTitle() + " 변경 전 가격:" + originalPrice + "원");
        modifyPrice(target);

        int discountedPrice = target.getPrice();
        System.out.println(target.getTitle() + " 변경 후 가격:" + discountedPrice + "원");
        System.out.println("차액: " + (originalPrice - discountedPrice) + "원");
        System.out.println("");
        //통계 분석
        StatisticsAnalyzer analyzer = new StatisticsAnalyzer();
    	analyzer.printStatistics(pubs);
    }
	
	public static void modifyPrice(Publication p) {
        if (p instanceof Magazine) {
            int newPrice = (int) (p.getPrice() * 0.6);  // 40% 할인
            p.setPrice(newPrice);
        } else if (p instanceof Novel) {
            int newPrice = (int) (p.getPrice() * 0.8);  // 20% 할인
            p.setPrice(newPrice);
        } else if (p instanceof ReferenceBook) {
            int newPrice = (int) (p.getPrice() * 0.9);  // 10% 할인
            p.setPrice(newPrice);
        }
    }
}