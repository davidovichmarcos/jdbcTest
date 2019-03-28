
import java.sql.*;

public class Main {

    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_HOST = "//localhost/";
    static final String DB_NAME = "storedprocedures0";
    static final String DB_USER = "root";
    static final String DB_PASS = "";


    public static void main(String[] args) {


        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql:"+ DB_HOST + DB_NAME, DB_USER, DB_PASS);
            Statement st= connection.createStatement();

            String query = "Select * from equipos";
            ResultSet rs = st.executeQuery(query);

            while(rs.next())
            {
                System.out.println(
                        rs.getInt("id_equipo") +
                                " > " + rs.getString("nombre_equipo"));
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

}