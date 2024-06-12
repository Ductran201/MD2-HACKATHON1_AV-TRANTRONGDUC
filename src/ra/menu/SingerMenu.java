package ra.menu;

import ra.handle.SingerHandle;
import ra.validate.InputMethod;

public class SingerMenu {
    SingerHandle singerHandle=new SingerHandle();
    public void openSingerManagement(){
    while(true){
        System.out.println("====SINGER MANAGEMENT=====");
        System.out.println("1. ADD NEW SINGERS");
        System.out.println("2. SHOW LIST SINGER");
        System.out.println("3. EDIT SINGER");
        System.out.println("4. DELETE SINGER");
//        new code
        System.out.println("5. BACK");
        System.out.println("YOUR OPTION: ");
        byte choice= InputMethod.getByte();
        switch (choice){
            case 1:
                singerHandle.addSinger();
                break;
            case 2:
                singerHandle.showSingers();
                break;
            case 3:
                singerHandle.editSinger();
                break;
            case 4:
                singerHandle.deleteSinger();
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
