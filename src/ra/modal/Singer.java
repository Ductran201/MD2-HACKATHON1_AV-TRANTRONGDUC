package ra.modal;

import ra.validate.InputMethod;

public class Singer {

    private int singerId, age;
    private String singerName, nationality, genre;
    private boolean gender;

    public Singer() {
    }

    public Singer(int singerId, int age, String singerName, String nationality, String genre, boolean gender) {
        this.singerId = singerId;
        this.age = age;
        this.singerName = singerName;
        this.nationality = nationality;
        this.genre = genre;
        this.gender = gender;
    }

    public int getSingerId() {
        return singerId;
    }

    public void setSingerId(int singerId) {
        this.singerId = singerId;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSingerName() {
        return singerName;
    }

    public void setSingerName(String singerName) {
        this.singerName = singerName;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }


    public void inputData(){
        System.out.println("---ENTER INFORMATION OF SINGER---");
        System.out.println("Enter name: ");
        singerName= InputMethod.getString();

        while (true){
        System.out.println("Enter age: ");
        age= InputMethod.getInteger();
        if (age>18 && age<70){
            break;
        }else {
            System.err.println("Singer must be older than 18 years old");
        }
        }

        System.out.println("Enter nationality: ");
        nationality=InputMethod.getString();
        System.out.println("Enter gender: ");
        gender= Boolean.parseBoolean(InputMethod.getString());
        System.out.println("Enter genre: ");
        genre=InputMethod.getString();
    }

    public void displayData(){
        System.out.println("---------------------------------------------------------");
        System.out.printf("%-3s |%-15s |%-3s |%-6s |%-10s |%-10s\n"
                ,singerId,singerName,age,gender ? "Male" : "Female",genre,nationality);
    }

    @Override
    public String toString(){
        return String.format("%-3s |%-15s\n"
                ,singerId,singerName);
    }

}
