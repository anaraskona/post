package Server;

import API.ApiUsServ;
import API.Objects.Order;
import API.Objects.User;
import com.caucho.hessian.server.HessianServlet;

import java.sql.*;

public class Server extends HessianServlet implements ApiUsServ {

    @Override
    public User flag(String id, String pas) {
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
        User flags = null;
        try {
            Connection connection = DriverManager.getConnection(url, login, password);
            Statement statement = connection.createStatement();
            String sql = "select id, passwords, fam, name, ot, tel, email, city, kart, summ from users where id = '" + id + "' and passwords = '" + pas + "'";
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()){
                flags = new User(resultSet.getString("id"));
                flags.setPassword(resultSet.getString("passwords"));
                flags.setFam(resultSet.getString("fam"));
                flags.setName(resultSet.getString("name"));
                flags.setOt(resultSet.getString("ot"));
                flags.setTel(resultSet.getString("tel"));
                flags.setEmail(resultSet.getString("email"));
                flags.setCity(resultSet.getString("city"));
                flags.setKart(resultSet.getString("kart"));
                flags.setSum(resultSet.getString("summ"));
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

    @Override
    public Order order(String id, String type, String status) {
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
        Order treck = null;
        try {
            Connection connection = DriverManager.getConnection(url, login, password);
            Statement statement = connection.createStatement();
            String sql = "select treck from orders where id = '" + id + "' and status = '" + status + "' and type = '" + type + "'";
            ResultSet resultSet = statement.executeQuery(sql);
            if(resultSet.next()){
                treck = new Order(resultSet.getString("treck")); }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("Can't create connection");
            e.printStackTrace();
        }
        return treck;
    }


    @Override
    public String pas(String id, String pasnew) {
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
        String pas = "not OK";
        try {
            Connection connection = DriverManager.getConnection(url, login, password);
            Statement statement = connection.createStatement();
            String sql = "update users set passwords = '" + pasnew + "' where id = '" + id + "'";
            statement.executeUpdate(sql);
            pas = "OK";
            statement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("Can't create connection");
            e.printStackTrace();
        }
        return pas;
    }


}

