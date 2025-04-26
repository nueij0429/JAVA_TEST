package workshop.music.entity;

public abstract class MusicMedia {
    protected String title; //����
    protected String artist; //��Ƽ��Ʈ

    public MusicMedia(String title, String artist) {
        this.title = title;
        this.artist = artist;
    }
    
    public abstract void play();

    //���� ���� ���
    public void displayInfo() {
        System.out.println("����: " + title + ", ��Ƽ��Ʈ: " + artist);
    }
}