package ra.menu;

import ra.handle.SearchHandle;
import ra.handle.SongHandle;
import ra.validate.InputMethod;

public class SearchMenu {
    public void openSongMenu(){
        while(true){
            System.out.println("====SEARCH MANAGEMENT=====");
            System.out.println("1. SEARCH SONG WITH SINGER NAME");
            System.out.println("2. SEARCH SINGER WITH GENRE");
            System.out.println("3. DISPLAY SONG LIST ORDER BY NAME A-Z");
            System.out.println("4. SHOW 5 NEWEST SONGS");
            System.out.println("5. BACK");
            System.out.println("YOUR OPTION: ");
            byte choice= InputMethod.getByte();
            switch (choice){
                case 1:
                    SearchHandle.searchSongBySinger();
                    break;
                case 2:
                    SearchHandle.searchSingerByGenre();
                    break;
                case 3:
                    SearchHandle.sortSongByName();
                    break;
                case 4:
                    SearchHandle.show5Songs();
                    break;
                case 5:
                    return;
                default:
                    System.err.println("INVALID OPTION");
                    break;
            }
        }

    }
}
