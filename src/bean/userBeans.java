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

    public String database;

    public Conn[] thecontent;

    /**
     * 初始化构造函数
     */
    public userBeans(String[][] dataTable, String[] dataBase) {
        super();
        thecontent = new Conn[dataBase.length];
        System.out.println(dataBase.length);
        for (int i1 = 0; i1 < dataBase.length; i1++) {
            dataTable[i1][0] =  dataTable[i1][0].replace("\"", "");
            thecontent[i1] = new Conn(dataTable[i1][0], dataBase[i1]);
        }
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
    public ResultSet selectAll(int which) {
        return thecontent[which].selectAll();
    }

    public ResultSet selectAllCourse(int which) {
        return thecontent[which].selectAllCourse(which);
    }

    /**
     * 查看个人信息
     * @return 返回个人信息
     */
    public ResultSet selectOne(int which, String theusername) {
        String what;
        what = (which == 0) ? "sid" : "id";
        return thecontent[which].getOne(theusername, what);
    }

    /**
     * 检查登录信息（用户名以及密码）
     * @return true或者false
     */
    public int checkUser() {
        ResultSet[] theResult = new ResultSet[thecontent.length];
        String theCols = null;
        for (int i = 0; i < thecontent.length; i++) {
            // 这里需要从中间件中读取相应的配置，但是……
            if (i == 0) {
                theCols = "sid";
            } else {
                theCols = "id";
            }
            System.out.println(theCols + theResult[i]);
            theResult[i] = thecontent[i].getOne(username, theCols);
        }
        try {
            for (int i = 0; i < theResult.length; i++) {
                System.out.println(theResult[i] != null);
                // 当查询到结果的时候
                if(theResult[i] != null) {
                    while (theResult[i].next()){
                        // 得到其密码字段
                        String pwd = theResult[i].getString("password");
                        if(password.equals(pwd)){
                            return i;
                        } else {
                            return -1;
                        }
                    }
                } else {
                    continue;
                }
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return -1;
    }

    public ResultSet getOneItems(int which) {
        return thecontent[which].getOne(username, "id");
    }
}
