package Config;

import java.util.ArrayList;

/**
 * Created by zhuch on 2017/12/2.
 */
public class getEveryConfig {
    private getConfig doGetConfig;
    private ArrayList<keyValuePair> list;
    private String[] allDbConfiger;
    public getEveryConfig(){
        // 实例化配置文件类
        this.doGetConfig = new getConfig();
        // 读取数组化的配置文件
        this.list = doGetConfig.getKeyValue();
        this.allDbConfiger = null;
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
                this.allDbConfiger = doGetConfig.doSplit(pair.value, ",");
            }
        }
        return this.allDbConfiger;
    }
}
