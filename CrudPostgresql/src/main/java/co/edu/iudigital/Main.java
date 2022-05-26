package co.edu.iudigital;
import co.edu.iudigital.dtos.UserDto;
import co.edu.iudigital.models.UserModel;

import java.util.List;


public class Main {
    public static void main(String[] args) {

        //ConfigMigration configMigration = new ConfigMigration();
        //configMigration.init();
        //UserMigration userMigration = new UserMigration();
        //userMigration.userSeed();
        UserModel userModel = new UserModel();
        List<UserDto> users = userModel.getUsers();
        for(UserDto user: users){
            System.out.println(user.getName());
        }
    }
}