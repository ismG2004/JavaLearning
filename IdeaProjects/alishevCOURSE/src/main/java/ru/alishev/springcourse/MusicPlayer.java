package ru.alishev.springcourse;

import java.util.ArrayList;
import java.util.List;

public class MusicPlayer {
//    private Music music;
    private List<Music> musicList = new ArrayList<>();

    public void setMusicList(List<Music> musicList) {
        this.musicList = musicList;
    }

    public MusicPlayer() {
    }

//    public MusicPlayer(Music music) {
//        this.music = music;
//    }


//    public void setMusic(Music music) {
//        this.music = music;
//    }

    public void playMusicList() {
        for (Music music : musicList) {
            System.out.println("Playing " + music.getSong());
        }
    }
}
