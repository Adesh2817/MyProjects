package com.mp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
    
    private static ArrayList<album> Albums = new ArrayList<>();

    public static void main(String[] args) {

    	album Album = new album("Album1","Queens");
		Album.addasong("We Will Rock You", 4.5);
		Album.addasong("Bohemian Rhapsody", 5.5);
		Album.addasong("Love of My Life", 3.5);
		Album.addasong("You’re My Best Friend", 4.1);
		Albums.add(Album);
		
        Album = new album("Album2","Eminem");
		Album.addasong("rapgod", 4.0);
		Album.addasong("Sing for the moment", 5.5);
		Album.addasong("Beautiful", 3.5);
		Album.addasong("Monster", 4.1);
		Albums.add(Album);

		LinkedList<song> playlist_1 = new LinkedList<>();
		
		Albums.get(0).addToPlaylist(1, playlist_1);
		Albums.get(0).addToPlaylist(3, playlist_1);
		Albums.get(1).addToPlaylist(4, playlist_1);
		Albums.get(1).addToPlaylist(2, playlist_1);

        play(playlist_1);

    }

    private static void play(LinkedList<song> playlist) {
        Scanner sc = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true; // Declaring the 'forward' variable
        ListIterator<song> listiterator = playlist.listIterator();

        if (playlist.size() == 0) {
            System.out.println("This playlist has no songs");
        } else {
            System.out.println("Now playing " + listiterator.next().toString());
            printMenu();

            while (!quit) {
                int action = sc.nextInt();
                sc.nextLine();

                switch (action) {

                    case 0:
                        System.out.println("Playlist is Complete");
                        quit = true;
                        break;

                    case 1:
                        if (!forward) {
                            if (listiterator.hasNext()) {
                                listiterator.next();
                            }
                            forward = true;
                        }

                        if (listiterator.hasNext()) {
                            System.out.println("Now Playing " + listiterator.next().toString());
                        } else {
                            System.out.println("There is no next song. We have reached the end of the list");
                            forward = false;
                        }
                        break;

                    case 2:
                        if (forward) {
                            if (listiterator.hasPrevious()) {
                                listiterator.previous();
                            }
                            forward = false;
                        }
                        if (listiterator.hasPrevious()) {
                            System.out.println("Now playing " + listiterator.previous().toString());
                        } else {
                            System.out.println("We are at the first song");
                            forward = false;
                        }
                        break;
                    case 3:
                        if (forward) {
                            if (listiterator.hasPrevious()) {
                                System.out.println("Now playing " + listiterator.previous().toString());
                            } else {
                                System.out.println("We are at the start of the list");
                            }
                        } else {
                            if (listiterator.hasNext()) {
                                System.out.println("Now playing " + listiterator.next().toString());
                                forward = true;
                            } else {
                                System.out.println("We have reached the end of the list");
                            }
                        }
                        break;

                    case 4:
                        printList(playlist);
                        break;

                    case 5:
                        printMenu();
                        break;
                    case 6:
                        if (playlist.size() > 0) {
                            listiterator.remove();
                            if (listiterator.hasNext()) {
                                System.out.println("Now playing " + listiterator.next().toString());
                            } else {
                                if (listiterator.hasPrevious())
                                    System.out.println("now playing " + listiterator.previous().toString());
                            }
                        }
                        break;
                }
            }
        }
    }

    private static void printMenu() {
        System.out.println("Available options \n press");
        System.out.println("0 - to quit \n" +
                "1 - to play next song\n" +
                "2 - to play previous song\n" +
                "3 - replay the current song\n" +
                "4 - list of all songs\n" +
                "5 - print all available options\n" +
                "6 - delete current song");
    }

    private static void printList(LinkedList<song> playlist) {
        Iterator<song> iterator = playlist.iterator();
        System.out.println("-------------------------");

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("-------------------------");
    }
}
