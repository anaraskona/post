package Server;

import API.ApiUsServ;
import com.caucho.hessian.server.HessianServlet;

import java.sql.*;

public class Server extends HessianServlet implements ApiUsServ {

    @Override
    public String flag(String id, String pas) {
        String flags = "false";
        final String driver = "org.postgresql.Driver";
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Not" + driver);
            e.printStackTrace();
        }
        final String url = "jdbc:postgresql://localhost:5432/post";
        final String login = "postgres";
        final String password = "1234";
        try {
            Connection connection = DriverManager.getConnection(url, login, password);
            Statement statement = connection.createStatement();
            String sql = "select id, passwords from users where id = '" + id + "' and passwords = '" + pas + "'";
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()){
                flags = "true";
            } else {
                flags = "false";
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("Can't create connection");
            e.printStackTrace();
        }
       return flags;
    }


}

