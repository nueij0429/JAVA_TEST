package workshop.music.entity;

public class Vinyl extends MusicMedia {
    private int rpm; //ȸ�� �ӵ�

    public Vinyl(String title, String artist, int rpm) {
        super(title, artist);
        this.rpm = rpm;
    }

    //���
    @Override
    public void play() {
        System.out.println("���̴� ���ڵ� '" + title + "'��(��) " + rpm + "rpm���� ����˴ϴ�.");
    }

    //���� ���
    @Override
    public void displayInfo() {
        System.out.println("����: " + title + ", ��Ƽ��Ʈ: " + artist);
        System.out.println("ȸ�� �ӵ�: " + rpm + " rpm");
    }
    
    public void clean() {
        System.out.println("���̴� ���ڵ带 û���մϴ�.");
    }
}