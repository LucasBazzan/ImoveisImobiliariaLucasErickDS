package Model;

import java.net.InetAddress;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private int PORT = 3306;
    private final String USER = "root";
    private String PASSWORD = "root";

    private static String getHostName() throws Exception {
        return InetAddress.getLocalHost().getHostName();
    }
    public DatabaseConnection() {
        try {
            if (getHostName().equals("DESKTOP-R2NKPHM")) {
                this.PORT = 3307;
                this.PASSWORD = "1234";
            }
        } catch (Exception e) {
            e.printStackTrace();
        };
    }

    public Connection Connect() throws SQLException {
        String url = "jdbc:mysql://127.0.0.1:" + PORT
                + "/imobiliariasimoveislucaserickds";
        
        Connection conn = DriverManager.getConnection(url, USER, PASSWORD);
        return conn;
    }
}
