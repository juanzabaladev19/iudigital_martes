package co.edu.iudigital;

public class Estudiante extends Person{

    private String identification;

    @Override
    public void setName(String name) {
        super.setName("est" + name);
    }
}
