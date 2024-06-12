package ra.modal;

import ra.handle.SingerHandle;
import ra.handle.SongHandle;
import ra.validate.CheckSongId;
import ra.validate.InputMethod;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Song {

    private String songId, songName, descriptions, songWriter;
    private Singer singer;
    private String createDate;

//    FORMAT DATE
    Date date = new Date();
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    String formattedDate = dateFormat.format(date);


    private boolean songStatus;

    public Song() {
    }

    public Song(String songId, String songName, String descriptions, String songWriter, Singer singer, String createDate, boolean songStatus) {
        this.songId = songId;
        this.songName = songName;
        this.descriptions = descriptions;
        this.songWriter = songWriter;
        this.singer = singer;
        this.createDate = createDate;
        this.songStatus = songStatus;
    }

    public String getSongId() {
        return songId;
    }

    public void setSongId(String songId) {
        this.songId = songId;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public String getSongWriter() {
        return songWriter;
    }

    public void setSongWriter(String songWriter) {
        this.songWriter = songWriter;
    }

    public Singer getSinger() {
        return singer;
    }

    public void setSinger(Singer singer) {
        this.singer = singer;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public boolean isSongStatus() {
        return songStatus;
    }

    public void setSongStatus(boolean songStatus) {
        this.songStatus = songStatus;
    }

    SingerHandle singerHandle = new SingerHandle();
    SongHandle songHandle = new SongHandle();

    public void inputData() {
        System.out.println("---ENTER INFORMATION OF SONG---");
//        CHECK DUPLICATE
        if (songHandle.findById(songId)==null) {
            System.out.println("Enter id song: ");
//        CHECK FORMAT SONG ID
            while (true) {
                songId = InputMethod.getString();
                if (CheckSongId.checkSongId(songId)) {
                    if (songHandle.findById(songId) == null) {
                        break;
                    }
                    System.err.println("Id "+ songId+ " has already have");

                } else {
                    System.err.println("ID of song must start with 'S' and only has 4 char");
                }
            }
        }
        System.out.println("Enter name");
        songName = InputMethod.getString();
        System.out.println("Enter description: ");
        descriptions = InputMethod.getString();
        System.out.println("Enter writer: ");
        songWriter = InputMethod.getString();
        System.out.println("Enter status: ");
        songStatus = Boolean.parseBoolean(InputMethod.getString());
        createDate = formattedDate;
//      CHOOSE SINGER FOR SONG
        for (Singer s : SingerHandle.singers) {
            System.out.println(s);
        }
//CHECK ID SINGER MATCH FOR SONG
        while (true) {
            System.out.println("Enter the id of singer to sing the song");
            int id = InputMethod.getInteger();
            Singer isSinger = singerHandle.findById(id);
            if (isSinger != null) {
                this.singer = isSinger;
                break;
            }
            System.err.println("No ID match");
        }
    }

    public void displayData() {
        System.out.println("--------------------------------------------------" +
                "-----------------------------------------------");
        System.out.printf(
                "%-6s |%-20s |%-15s |%-8s |%-12s |%-15s |%-10s\n"
                , songId, songName, singer.getSingerName(), songStatus ? "Active" : "Inactive",
                createDate, descriptions, songWriter);
    }


}
