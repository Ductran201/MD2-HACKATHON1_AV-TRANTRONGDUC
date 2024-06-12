package ra.handle;

import ra.modal.Song;
import ra.validate.InputMethod;

import java.util.ArrayList;
import java.util.List;

public class SongHandle {
    static SingerHandle singerHandle = new SingerHandle();
    public static List<Song> songs = new ArrayList<>();

    static {
        songs.add(new Song("S001", "nhac 1", "nothing"
                , "son tung", singerHandle.findById(2), "10/06/2024", true));
        songs.add(new Song("S002", "anh yeu em", "nothing"
                , "son dang", singerHandle.findById(1), "10/06/2024", false));

    };

    public Song findById(String id) {
        for (Song s : songs) {
            if (s.getSongId().equals(id)) {
                return s;
            }
        }
        return null;
    }

    public static void findAll(){
        for (Song s:songs){
            s.displayData();
        }
    }

    public void addSong() {
        if (SingerHandle.singers.isEmpty()) {
            System.err.println("No have any singers, please add new singer");
            return;
        }
        System.out.println("Enter number songs want to add");
        int n = InputMethod.getInteger();

        for (int i = 1; i <= n; i++) {
            System.out.println("Enter the information of song " + i);
            Song newSong = new Song();
            newSong.inputData();
            songs.add(newSong);
        }
        System.out.println("Add successfully");
    }

    public void showSongs() {
        if (songs.isEmpty()) {
            System.err.println("No have any songs, please add new one");

        } else {
            System.out.printf("%-6s |%-20s |%-15s |%-8s |%-12s |%-15s |%-10s\n"
                    , "ID", "Name", "Singer", "Status", "Create Date", "Description", "Writer");
            for (Song s : songs) {
                s.displayData();
            }
        }

    }

    public void editSong() {

        System.out.println("Enter the id of song need to edit: ");
        String id = InputMethod.getString();

        if (findById(id) == null) {
            System.err.println("no have song with id " + id);
        } else {
            System.out.println("The information of this song: ");
            findById(id).displayData();
            findById(id).inputData();
            System.out.println("Edit successfully");
        }
    }

    public void deleteSong() {
        System.out.println("Enter the id of song need to delete: ");
        String id = InputMethod.getString();

        if (findById(id) == null) {
            System.err.println("no have song with id " + id);
        } else {
            songs.remove(findById(id));
            System.out.println("Delete successfully");
        }
    }
}
