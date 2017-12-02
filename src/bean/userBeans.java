package bean;
import Database.Conn;

import java.sql.ResultSet;
import java.sql.SQLException

/**
 * Created by zhuch on 2017/11/20.
 */;
public class userBeans {
    public String username;
    public String password;

    public Conn thecontent;

    /**
     * 初始化构造函数
     */
    public userBeans() {
        super();
        thecontent = new Conn("student");
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 查询所有的班级成员
     * @return 所有班级成员的信息
     */
    public ResultSet selectAll() {
        return thecontent.selectAll();
    }

    /**
     * 查看个人信息
     * @return 返回个人信息
     */
    public ResultSet selectOne() {
        return thecontent.getOne(username, "id");
    }

    /**
     * 检查登录信息（用户名以及密码）
     * @return true或者false
     */
    public boolean checkUser() {
        ResultSet theResult = thecontent.getOne(username, "id");
        try {
            System.out.println(theResult != null);
            // 当查询到结果的时候
            if(theResult != null) {
                while (theResult.next()){
                    // 得到其密码字段
                    String pwd = theResult.getString("password");
                    if(password.equals(pwd)){
                        return true;
                    } else {
                        return false;
                    }
                }
            } else {
                return false;
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }
}
