package co.edu.iudigital;

public class Person {

    private String name;
    private String lastname;
    private int age;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPersonData(String name){
        this.name = name;
    }
    public void setPersonData(String name, String lastname){
        this.name = name;
        this.lastname = lastname;
    }

    public void setPersonData(String name, String lastname, int age){
        this.name = name;
        this.lastname = lastname;
        this.age = age;
    }
    public void setPersonData(String name, String lastname, String age){
        this.name = name;
        this.lastname = lastname;
        this.age = Integer.parseInt(age);
    }
}
