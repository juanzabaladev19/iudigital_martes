package co.edu.iudigital.models;

import co.edu.iudigital.db.DbConfig;
import co.edu.iudigital.dtos.UserDto;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class UserModel {
    private DbConfig dbConfig;
    private Connection connection;

    public UserModel(){
        dbConfig = new DbConfig("localhost", "5432", "enfasis2_martes");
        connection = dbConfig.connect();
    }
    public void insertPerson(int id, String name, String lastname){

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

    public List<UserDto> getUsers(){
        String query = "SELECT * FROM users";
        List<UserDto> users = new ArrayList<>();
        try{
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(query);

            while (result.next()){
                UserDto userDto = new UserDto();
                userDto.setId(Integer.parseInt(result.getString("id")));
                userDto.setName(result.getString("name"));
                userDto.setLastname(result.getString("lastname"));
                users.add(userDto);
            }
            statement.close();
            connection.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return users;
    }
    public List<UserDto> getUsers(int id){
        String query = "SELECT * FROM users WHERE id=" + id;
        List<UserDto> users = new ArrayList<>();
        try{
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(query);

            while (result.next()){
                UserDto userDto = new UserDto();
                userDto.setId(Integer.parseInt(result.getString("id")));
                userDto.setName(result.getString("name"));
                userDto.setLastname(result.getString("lastname"));
                users.add(userDto);
            }
            statement.close();
            connection.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return users;
    }
    public void updateUser(String lastname, int id){
        try{
            String query = String.format("UPDATE users SET lastname='%s' WHERE id=%d", lastname, id);
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(query);
            statement.close();
            connection.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
