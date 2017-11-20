package Database;

import java.sql.*;

/**
 * Created by zhuch on 2017/11/20.
 */
public class Conn {
    public static Connection connection;
    public static Statement statement;
    public static String driver;
    public static String url;
    public static String username;
    public static String password;
    public ResultSet resultSet;
    static {
        driver = "com.mysql.jdbc.Driver";
        url = "jdbc:mysql://localhost:3306/test";
        username = "doubibobo";
        password = "12151618";
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, username, password);
            statement = connection.createStatement();
            System.out.println("成功连接到数据库！");
        } catch (ClassNotFoundException e) {
            System.out.println("无法加载jdbc驱动！");
            e.printStackTrace();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // 得到连接对象并且返回connection，static对象确保只进行一次初始化
    public Connection getConnection() {
        return connection;
    }

    // 构造函数
    public Conn() {
        this.connection = this.getConnection();
    }

    // 查询数据库中的所有条目
    public void doSelect(String sql) {
        try {
            connection = DriverManager.getConnection(url, username, password);
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
