package workshop.book.control;

import workshop.book.entity.Magazine;
import workshop.book.entity.Novel;
import workshop.book.entity.Publication;
import workshop.book.entity.ReferenceBook;

public class ManageBook {

	public static void main(String[] args) {
		//Publication Ÿ�� �迭�� ���� �� ����
		Publication[] pubs = new Publication[7];
		pubs[0] = new Magazine("����ũ�μ���Ʈ", "2007-10-01", 328, 9900, "�ſ�");
		pubs[1] = new Magazine("�濵����ǻ��", "2007-10-03", 316, 9000, "�ſ�");
        pubs[2] = new Novel("���߿�", "2007-07-01", 396, 9800, "����������������", "����Ҽ�");
        pubs[3] = new Novel("���ѻ꼺", "2007-04-14", 383, 11000, "����", "���ϼҼ�");
        pubs[4] = new ReferenceBook("�ǿ��������α׷���", "2007-01-14", 496, 25000, "����Ʈ�������");
        pubs[5] = new Novel("�ҳ��̿´�", "2014-05-01", 216, 15000, "�Ѱ�", "����Ҽ�");
        pubs[6] = new Novel("�ۺ������ʴ´�", "2021-09-09", 332, 15120, "�Ѱ�", "����Ҽ�");
        
        //����-�Ϸù�ȣ + ���� + �������� ���
        System.out.println("==== ���� ���� ��� ====");
        for (int i = 0; i < pubs.length; i++) {
            Publication p = pubs[i];
            System.out.println((i + 1) + ". " + p.getTitle() + " " + p.toString());
        }
        System.out.println("");
        
        //����-���� ����+���ε� ����
        Publication target = pubs[6];
        int originalPrice = target.getPrice();
        System.out.println("==== ���� ���� ====");
        System.out.println(target.getTitle() + " ���� �� ����:" + originalPrice + "��");
        modifyPrice(target);

        int discountedPrice = target.getPrice();
        System.out.println(target.getTitle() + " ���� �� ����:" + discountedPrice + "��");
        System.out.println("����: " + (originalPrice - discountedPrice) + "��");
        System.out.println("");
        //��� �м�
        StatisticsAnalyzer analyzer = new StatisticsAnalyzer();
    	analyzer.printStatistics(pubs);
    }
	
	public static void modifyPrice(Publication p) {
        if (p instanceof Magazine) {
            int newPrice = (int) (p.getPrice() * 0.6);  // 40% ����
            p.setPrice(newPrice);
        } else if (p instanceof Novel) {
            int newPrice = (int) (p.getPrice() * 0.8);  // 20% ����
            p.setPrice(newPrice);
        } else if (p instanceof ReferenceBook) {
            int newPrice = (int) (p.getPrice() * 0.9);  // 10% ����
            p.setPrice(newPrice);
        }
    }
}