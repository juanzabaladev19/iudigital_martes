package co.edu.iudigital;
import co.edu.iudigital.migrations.ConfigMigration;
import co.edu.iudigital.migrations.UserMigration;


public class Main {
    public static void main(String[] args) {

        ConfigMigration configMigration = new ConfigMigration();
        configMigration.init();
        UserMigration userMigration = new UserMigration();
        userMigration.userSeed();
    }
}