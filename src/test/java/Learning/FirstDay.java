package Learning;

public class FirstDay {

    String name;
    String surname;


    public void introduce() {
        System.out.println("My name is: " + name + " " + surname);
    }

    public FirstDay(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

}
