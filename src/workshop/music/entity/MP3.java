package workshop.music.entity;

public class MP3 extends DigitalMedia implements Playable {
    private int fileSize; //���� ũ��
    private int volume; //����

    public MP3(String title, String artist, String format, int fileSize) {
        super(title, artist, format);
        this.fileSize = fileSize;
        this.volume = 5;
    }

    public MP3(String title, String artist) {
        this(title, artist, "MP3", 5);
    }

    //���
    @Override
    public void play() {
        System.out.println("MP3 ������ '" + title + "'��(��) �����з� ����˴ϴ�.");
        System.out.println("���� ����: " + volume);
    }

    //���� ���
    @Override
    public void displayInfo() {
        System.out.println("����: " + title + ", ��Ƽ��Ʈ: " + artist);
        System.out.println("����: " + format);
        System.out.println("���� ũ��: " + fileSize + "MB");
    }

    //���� ����
    @Override
    public void setVolume(int level) {
        this.volume = level;
        System.out.println("������ " + volume + "�� �����Ǿ����ϴ�.");
    }

    //��� ����
    @Override
    public void stop() {
        System.out.println("MP3 ����� �����Ǿ����ϴ�.");
    }
}