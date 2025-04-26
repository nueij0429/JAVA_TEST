package workshop.book.control;

import workshop.book.entity.Magazine;
import workshop.book.entity.Novel;
import workshop.book.entity.Publication;
import workshop.book.entity.ReferenceBook;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShoppingCart {
    private List<Publication> items;
    
    public ShoppingCart() {
        items = new ArrayList<>();
    }

    //��ٱ��� ���� �޼���
    //���ǹ� �߰�
    public void addItem(Publication item) {
        items.add(item);
        System.out.println("��ٱ��Ͽ� �߰���: " + item.getTitle());
    }

    //���ǹ� ����
    public boolean removeItem(String title) {
        for (Publication p : items) {
            if (p.getTitle().equals(title)) {
                items.remove(p);
                System.out.println("��ٱ��Ͽ��� ���ŵ�: " + title);
                return true;
            }
        }
        System.out.println("��ٱ��Ͽ� �ش� �׸� ����: " + title);
        return false;
    }

    //��ٱ��� ���� ���
    public void displayCart() {
        DecimalFormat df = new DecimalFormat("#,###��");
        System.out.println("");
        System.out.println("==== ��ٱ��� ��� ====");
        if (items.isEmpty()) {
            System.out.println("��ٱ��ϰ� ��� �ֽ��ϴ�.");
            return;
        }

        for (Publication p : items) {
            System.out.println("- " + p.getTitle() + " " + p.toString());
        }

        int total = calculateTotalPrice();
        int discounted = calculateDiscountedPrice();

        System.out.println("");
        System.out.println("�� ����: " + df.format(total));
        System.out.println("���� ���� ����: " + df.format(discounted));
    }

    //���� ��� �޼���
    //�� ���� ���
    public int calculateTotalPrice() {
        int total = 0;
        for (Publication p : items) {
            total += p.getPrice();
        }
        return total;
    }

    //���� ���� �� ���� ���
    public int calculateDiscountedPrice() {
        int total = 0;
        for (Publication p : items) {
            int price = p.getPrice();
            if (p instanceof Magazine) {
                price *= 0.9;  //10% ����
            } else if (p instanceof Novel) {
                price *= 0.85; //15% ����
            } else if (p instanceof ReferenceBook) {
                price *= 0.8;  //20% ����
            }
            total += price;
        }
        return total;
    }

    //��� ��� �޼���
    public void printStatistics() {
        Map<String, Integer> countByType = new HashMap<>();

        for (Publication p : items) {
            String type = getPublicationType(p);
            countByType.put(type, countByType.getOrDefault(type, 0) + 1);
        }

        System.out.println("");
        System.out.println("==== ��ٱ��� ��� ====");
        for (String type : countByType.keySet()) {
            System.out.println(type + ": " + countByType.get(type) + "��");
        }
    }

    private String getPublicationType(Publication p) {
        if (p instanceof Magazine) {
            return "����";
        } else if (p instanceof Novel) {
            return "�Ҽ�";
        } else if (p instanceof ReferenceBook) {
            return "����";
        } else {
            return "��Ÿ";
        }
    }

    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        cart.addItem(new Magazine("����ũ�μ���Ʈ", "2007-10-01", 328, 9900, "�ſ�"));
        cart.addItem(new Novel("���߿�", "2007-07-01", 396, 9800, "����������������", "����Ҽ�"));
        cart.addItem(new ReferenceBook("�ǿ��������α׷���", "2007-01-14", 496, 25000, "����Ʈ�������"));
        cart.addItem(new Novel("�ҳ��̿´�", "2014-05-01", 216, 15000, "�Ѱ�", "����Ҽ�"));

        cart.displayCart();
        cart.printStatistics();

        cart.removeItem("���߿�");

        cart.displayCart();
        cart.printStatistics();
    }
}