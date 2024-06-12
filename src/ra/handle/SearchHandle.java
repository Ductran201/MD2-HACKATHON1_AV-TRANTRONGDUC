package ra.handle;

import ra.modal.Singer;
import ra.modal.Song;
import ra.validate.InputMethod;

public class SearchHandle {
    public static void searchSongBySinger(){
        System.out.println("-------------FIND SONG----------------");
        System.out.println("Enter the singer name:");
        String inputSingerName= InputMethod.getString();
        for (Song s: SongHandle.songs){
            if(s.getSinger().getSingerName().toLowerCase().contains(inputSingerName)){
                s.displayData();
            }
        }
    }

    public static void searchSingerByGenre(){
        System.out.println("-------------FIND SINGER----------------");
        System.out.println("Enter the genre of singer:");
        String inputGenre= InputMethod.getString();
        for (Singer s: SingerHandle.singers){
           if(s.getGenre().toLowerCase().contains(inputGenre)){
                s.displayData();
            }
        }
    }

    public static void sortSongByName(){
        SongHandle.songs.sort((a,b)->a.getSongName().compareTo(b.getSongName()));
        System.out.println("List song order by name a-z: ");
        SongHandle.findAll();
    }

    public static void show5Songs(){
        if (SongHandle.songs.size()<5){
            SongHandle.findAll();
        }else {
            for (int i=0;i<5;i++){
                SongHandle.songs.get(i).displayData();
            }
        }
    }
}
