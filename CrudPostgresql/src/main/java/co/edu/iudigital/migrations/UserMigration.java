package co.edu.iudigital.migrations;

import co.edu.iudigital.db.DbConfig;
import com.github.javafaker.Faker;

import java.sql.Connection;
import java.sql.Statement;

public class UserMigration {

    private DbConfig dbConfig;
    private Connection connection;

    public UserMigration(){
        dbConfig = new DbConfig("localhost", "5432", "enfasis2_martes");
        connection = dbConfig.connect();
        creteTablePersons();
    }
    public void creteTablePersons(){
        String query = String.format(
                "CREATE TABLE users" +
                        "(id INT PRIMARY KEY," +
                        "name varchar(30), lastname varchar(30))");
        try{
            Statement statement = connection.createStatement();
            statement.execute(query);
            statement.close();
            connection.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void userSeed(){
        Faker faker = new Faker();
        for(int i=1; i<100; i++) {
            String query = String.format(
                    "INSERT INTO users (id, name, lastname) VALUES(%d,'%s', '%s')",
                    i, faker.name().fullName(), faker.name().lastName());
            try {
                Statement statement = connection.createStatement();
                statement.execute(query);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
