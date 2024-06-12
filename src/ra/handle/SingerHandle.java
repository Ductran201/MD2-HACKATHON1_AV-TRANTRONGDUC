package ra.handle;

import ra.modal.Singer;
import ra.modal.Song;
import ra.validate.InputMethod;

import java.util.ArrayList;
import java.util.List;

public class SingerHandle {


    public static int newId = 3;

    public static List<Singer> singers = new ArrayList<>();

    static {
        singers.add(new Singer(1, 23, "na", "VN", "vang", true));
        singers.add(new Singer(2, 22, "linh", "VN", "pop", false));
    }

    ;


    public Singer findById(int id) {
        for (Singer s : singers) {
            if (s.getSingerId() == id) {
                return s;
            }
        }
        return null;
    }

//  CRUD

    public void addSinger() {
        System.out.println("Enter number singers want to add");
        int n = InputMethod.getInteger();

        for (int i = 1; i <= n; i++) {
            System.out.println("Enter the information of singer " + i);
            Singer newSinger = new Singer();
            newSinger.setSingerId(newId++);
            newSinger.inputData();
            singers.add(newSinger);
        }
        System.out.println("Add successfully");
    }

    public void showSingers() {
        if (singers.isEmpty()) {
            System.err.println("No have any singers, please add new one");

        } else {
            System.out.println("---------------------List singer---------------------- ");
            System.out.printf("%-3s |%-15s |%-3s |%-6s |%-10s |%-10s\n"
                    , "ID", "Name", "Age", "Gender", "Genre", "Nationality");

            for (Singer s : singers) {
                s.displayData();
            }
        }

    }

    public void editSinger() {

        System.out.println("Enter the id of singer need to edit: ");
        int id = InputMethod.getInteger();

        if (findById(id) == null) {
            System.err.println("No have singer with id " + id);
        } else {
            System.out.println("The information of this singer: ");
            findById(id).displayData();
            findById(id).inputData();
            System.out.println("Edit successfully");
        }
    }

    public void deleteSinger() {
        System.out.println("Enter the id of singer need to delete: ");
        int id = InputMethod.getInteger();

        if (findById(id) == null) {
            System.err.println("no have singer with id " + id);
        } else {
            boolean isExist = false;
            for (Song s : SongHandle.songs) {
                if (s.getSinger() != null) {
                    isExist = true;
                    break;
                }
            }

            if (isExist) {
                singers.remove(findById(id));
                System.out.println("Delete successfully");

            } else {
                System.out.println("Can not delete because there is a song performed by this singer");
            }

        }
    }


}
