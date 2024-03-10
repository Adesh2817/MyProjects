package com.mp;
import java.util.ArrayList;
import java.util.LinkedList;
import com.mp.song;

public class album {

    private String name;
    private String artist;
    private ArrayList<song> songs;

    public album(String name, String artist) {
        super();
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<song>();
    }

    public album() {

    }

    public song findsong(String title) {
        for (song checkedsong : songs) {
            if (checkedsong.getTitle().equals(title)) {
                return checkedsong;
            }
        }
        return null;
    }

    public boolean addasong(String title, double duration) {
        if (findsong(title) == null) {
            songs.add(new song(title, duration));
            return true;
        } else {
            return false;
        }
    }
    
    public boolean addToPlaylist(int TrackNumber, LinkedList<song> Playlist) {
        int index = TrackNumber - 1;
        if (index >= 0 && index < this.songs.size()) {
            Playlist.add(this.songs.get(index));
            return true;
        }
        return false;
    }
    
    

//    public boolean addToPlaylist(String title, LinkedList<song> Playlist) {
//        for (song checkedsong : this.songs) {
//            if (checkedsong.getTitle().equals(title)) {
//                Playlist.add(checkedsong);
//                return true;
//            }
//        }
//        return false;
//    }

    public boolean addToPlaylist(String title, LinkedList<song> Playlist) {
        for (song checkedsong : this.songs) {
            if (checkedsong.getTitle().equals(title)) {
                Playlist.add(checkedsong);
                return true;
            }
        }
        return false;
    }
}
