package workshop.music.entity;

public class DigitalMedia extends MusicMedia {
    protected String format; //����

    public DigitalMedia(String title, String artist, String format) {
        super(title, artist);
        this.format = format;
    }

    //���
    @Override
    public void play() {
        System.out.println(format + " ������ '" + title + "'��(��) �����з� ����˴ϴ�.");
    }

    //���� ���
    @Override
    public void displayInfo() {
        System.out.println("����: " + title + ", ��Ƽ��Ʈ: " + artist);
        System.out.println("����: " + format);
    }
}