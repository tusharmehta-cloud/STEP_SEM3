package WEEK_07.HOME_PROBLEM;

import java.util.Arrays;

public class ThePlaylist {

    static class Playlist {

        private String[] songs;
        private int songCount;

        Playlist(int maxSongs) {
            songs = new String[maxSongs];
            songCount = 0;
        }

        void addSong(String song) {

            if (songCount < songs.length) {
                songs[songCount] = song;
                songCount++;
            }
        }

        String[] getSongs() {
            return Arrays.copyOf(songs, songCount);
        }

        int getSongCount() {
            return songCount;
        }
    }

    public static void main(String[] args) {

        Playlist p = new Playlist(10);

        p.addSong("Song A");
        p.addSong("Song B");

        String[] copy = p.getSongs();

        copy[0] = "Hacked";

        System.out.println(
                "Songs: " + Arrays.toString(p.getSongs())
        );

        System.out.println(
                "Song count: " + p.getSongCount()
        );
    }
}