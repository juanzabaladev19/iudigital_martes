package co.edu.iudigital.db;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Connection;
import java.sql.DriverManager;

@Data
@AllArgsConstructor
public class DbConfig {
    private String host;
    private String port;
    private String db;

    public Connection connect(){
        Connection connection = null;
        try{
            String connectionString = "jdbc:postgresql://" +
                    host + ":" + port + "/" + db;
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(connectionString);
        } catch (Exception e){
            e.printStackTrace();
        }
        return connection;
    }
}
