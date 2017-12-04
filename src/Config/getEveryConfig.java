package Config;

import Database.Conn;

import java.util.ArrayList;

/**
 * Created by zhuch on 2017/12/2.
 */
public class getEveryConfig {
    private getConfig doGetConfig;
    private ArrayList<keyValuePair> list;
    private String[] allDbConfiger;
    private String[] allStudentTable;
    private String[][] allCol;
    private String[] allCourseTable;
    private String[] allInterestTable;
    public getEveryConfig(){
        // 实例化配置文件类
        this.doGetConfig = new getConfig();
        // 读取数组化的配置文件
        this.list = doGetConfig.getKeyValue();
        this.allDbConfiger = null;
        this.allStudentTable = null;
    }

    /**
     * 获取所有的数据库名称，供连接使用
     * @return 所有的数据库名称
     */
    public String[] getAllDbConfiger() {
        for (keyValuePair pair:this.list) {
            if (pair.key.equals("\"dbConfiger\"")) {
                pair.value = pair.value.replace("{", "");
                pair.value = pair.value.replace("}", "");
                pair.value = pair.value.replace("\"", "");
                this.allDbConfiger = this.doGetConfig.doSplit(pair.value, ",");
            }
        }
        return this.allDbConfiger;
    }

    /**
     * 方法功能：获取所有学生表的列表信息
     */
    private void getAllStudentTable() {
        for (keyValuePair pair:this.list) {
            if (pair.key.equals("\"student\"")) {
                pair.value = pair.value.replace("{", "");
                this.allStudentTable = this.doGetConfig.doSplit(pair.value, "],");
            }
        }
    }

    /**
     * 得到一个表中的所有列信息
     * @return  列信息
     */
    public String[][] getAllCol() {
        this.getAllStudentTable();
        this.allCol = new String[this.allStudentTable.length][2];
        for (int i = 0; i < this.allStudentTable.length; i++) {
            this.allStudentTable[i] =  this.allStudentTable[i].replace("[", "");
            this.allStudentTable[i] =  this.allStudentTable[i].replace("]", "");
            this.allCol[i] = this.doGetConfig.doSplit(this.allStudentTable[i], "=>");
            System.out.println(this.allCol[i]);
        }
        return this.allCol;
    }
}
