package run;

import ra.menu.SearchMenu;
import ra.menu.SingerMenu;
import ra.menu.SongMenu;
import ra.validate.InputMethod;


public class MusicManagement {
    public static void main(String[] args) {

//        SingerHandle singerHandle = new SingerHandle();
//        SongHandle songHandle = new SongHandle();
        SingerMenu singerMenu = new SingerMenu();
        SongMenu songMenu = new SongMenu();
        SearchMenu searchMenu=new SearchMenu();

//        ======================================

        while (true) {
            System.out.println("=========MUSIC MANAGEMENT=========");
            System.out.println("1. OPEN SINGER MANAGEMENT");
            System.out.println("2. OPEN SONG MANAGEMENT");
            System.out.println("3. SEARCH THE SONG ");
            System.out.println("4. EXIT PROGRAM ");
            System.out.println("YOUR OPTION: ");
            byte choice = InputMethod.getByte();
            switch (choice) {
                case 1:
                    singerMenu.openSingerManagement();
                    break;
                case 2:
                    songMenu.openSongMenu();
                    break;
                case 3:
                    searchMenu.openSongMenu();
                    break;
                case 4:
                    System.out.println("GOODBYE");
                    return;
                default:
                    System.err.println("INVALID OPTION");
                    break;

            }
        }


    }
}
