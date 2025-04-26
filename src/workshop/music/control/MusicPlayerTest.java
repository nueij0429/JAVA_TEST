package workshop.music.control;

import workshop.music.entity.*;

public class MusicPlayerTest {
    public static void main(String[] args) {
        System.out.println("===== ���� ��� �ý��� �׽�Ʈ =====");
        System.out.println("");
        System.out.println("--- MP3 �׽�Ʈ ---");
        MP3 mp3 = new MP3("Dynamite", "BTS");
        mp3.displayInfo();
        mp3.play();
        mp3.setVolume(8);
        mp3.play();
        mp3.stop();
        System.out.println("");

        System.out.println("--- Vinyl �׽�Ʈ ---");
        Vinyl vinyl = new Vinyl("Yesterday", "The Beatles", 33);
        vinyl.displayInfo();
        vinyl.play();
        vinyl.clean();
        System.out.println("");

        System.out.println("--- ������ �׽�Ʈ ---");
        MusicMedia media = new MP3("Butter", "BTS", "MP3", 4);
        media.displayInfo();
        media.play(); //MP3�� play()
        System.out.println("");
        
        System.out.println("--- ĳ���� �׽�Ʈ ---");
        if (media instanceof Playable) {
            Playable playable = (Playable) media;
            playable.setVolume(3);
            media.play();
            playable.setVolume(7);
            playable.stop();
        }
    }
}
