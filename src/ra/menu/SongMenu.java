package ra.menu;

import ra.handle.SongHandle;
import ra.validate.InputMethod;

public class SongMenu {
    SongHandle songHandle=new SongHandle();
    public void openSongMenu(){
        while(true){
            System.out.println("====SONG MANAGEMENT=====");
            System.out.println("1. ADD NEW SONGS");
            System.out.println("2. SHOW LIST SONG");
            System.out.println("3. EDIT SONG");
            System.out.println("4. DELETE SONG");
            System.out.println("5. BACK");
            System.out.println("YOUR OPTION: ");
            byte choice= InputMethod.getByte();
            switch (choice){
                case 1:
                    songHandle.addSong();
                    break;
                case 2:
                    songHandle.showSongs();
                    break;
                case 3:
                    songHandle.editSong();
                    break;
                case 4:
                    songHandle.deleteSong();
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
