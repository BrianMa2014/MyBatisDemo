package main.com.mmj.jdbc;


import java.sql.*;

/**
 * Created by MaMingJiang on 2016/6/12.
 */
public class Util {
    public void test(){
        String url = "jdbc:mysql://localhost:3306/samp_db";
        String username ="root" ;
        String password ="";
        String sql = "select * from students";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                String name = resultSet.getString(2);
                int age = resultSet.getInt(4);
                System.out.println("name:"+name+",age:"+age);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
