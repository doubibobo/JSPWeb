package servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

import Config.getConfig;
import Config.getEveryConfig;
import Config.keyValuePair;
import bean.userBeans;

/**
 * Created by zhuch on 2017/11/20.
 */
@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置HTTP响应的文档类型，此处为Text/html
        response.setContentType("text/html");
        // 设置响应的编码方式
        response.setCharacterEncoding("GB18030");
        // 取得用户名和密码的值
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        String forward = "";

        getEveryConfig everyConfig = new getEveryConfig();
        // 所有数据库的名称信息
        String[] allDbConfiger = everyConfig.getAllDbConfiger();
        // 所有数据库的学生表信息
        String[][] allStudentConfig = everyConfig.getAllCol();

        userBeans theUser = new userBeans(allStudentConfig, allDbConfiger);
        theUser.setUsername(username);
        theUser.setPassword(password);
        log(username);
        log(password);

        // 数据库配置信息
        int connectConfig = theUser.checkUser();
        if(connectConfig >= 0){
            forward = "main.jsp";
        } else {
            forward = "doubibobo.jsp";
        }
        // 设置用户名专属的session值
        request.getSession().setAttribute("userid", username);
        request.getSession().setAttribute("database", connectConfig);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(forward);
        requestDispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
