package co.edu.iudigital.models;

import co.edu.iudigital.db.DbConfig;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Connection;
import java.sql.Statement;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    private int id;
    private String name;
    private String lastname;

    public void insertPerson(){
        DbConfig dbConfig = new DbConfig("localhost", "5432", "enfasis2_martes");
        Connection connection = dbConfig.connect();
        String query = String.format("INSERT INTO persons (id, name, lastname) VALUES(%d, '%s','%s')", id, name, lastname);
        try{
            Statement statement = connection.createStatement();
            statement.execute(query);
            statement.close();
            connection.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
