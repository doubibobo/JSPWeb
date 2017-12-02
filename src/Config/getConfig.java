package Config;

import java.io.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by zhuch on 2017/12/2.
 */
public class getConfig {
    /**
     * 读取配置文件txt
     * @param file  文件流
     * @return 字符串
     */
    public String configTxt(File file){
        StringBuilder result = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String str = null;
            while((str = bufferedReader.readLine()) != null) {
                result = result.append(System.lineSeparator()+str);
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result.toString();
    }

    /**
     * 清除字符串中的回车空格字符等
     * @param waitToString 待处理字符串
     * @return 处理之后的字符串
     */
    public String toArray(String waitToString) {
        Pattern pattern = Pattern.compile("\\s*|\t|\r|\n");
        Matcher matcher = pattern.matcher(waitToString);
        waitToString = matcher.replaceAll("");
        waitToString = waitToString.substring(2);
        waitToString = waitToString.substring(0,waitToString.length()-2);
        return waitToString;
    }

    /**
     * 划分字符串
     * @param waitToString
     * @param param
     * @return
     */
    public String[] doSplit(String waitToString, String param) {
        String[] split = waitToString.split(param);
        return split;
    }

    public ArrayList<keyValuePair> getKeyValue() {
        ArrayList<keyValuePair> list = new ArrayList<keyValuePair>();
        File file = new File("F:/JSPWeb/src/config.txt");
        System.out.println(file.getAbsolutePath());
        String configResult = configTxt(file);
        configResult = toArray(configResult);
        String[] string = doSplit(configResult, "},");

        for (int i =0; i < string.length; i++) {
            String theMiddle = string[i];
            String[] theMiddleArray = doSplit(theMiddle, ":");
            list.add(new keyValuePair(theMiddleArray[0], theMiddleArray[1]));
        }

        for (keyValuePair pair:list) {
            System.out.println(pair.key + "=>" + pair.value);
        }
        return list;
    }
}
