package servlet;

import Config.getEveryConfig;
import bean.CourseListBeans;
import bean.UserListBeans;
import bean.userBeans;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhuch on 2017/12/4.
 */
@WebServlet(name = "CourseServlet")
public class CourseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置HTTP响应的文档类型，此处为Text/html
        response.setContentType("text/html");
        // 设置响应的编码方式
        response.setCharacterEncoding("GB18030");
        // 取得用户名和密码的值
        String userid = request.getParameter("userid");
        String database = request.getParameter("database");

        getEveryConfig everyConfig = new getEveryConfig();
        // 所有数据库的名称信息
        String[] allDbConfiger = everyConfig.getAllDbConfiger();
        // 所有数据库的学生表信息
        String[][] allStudentConfig = everyConfig.getAllCol();

        // 初始实例化对象
        userBeans theUser = new userBeans(allStudentConfig, allDbConfiger);

        int whileDatabase;
        whileDatabase = database.equals("0") ? 0 : 1;
        ResultSet resultSet = theUser.selectAllCourse(whileDatabase);
        String forward = "course.jsp";
        List<CourseListBeans> courseListBeans = new ArrayList<CourseListBeans>();
        CourseListBeans every = null;

        if (resultSet != null) {
            try {
                while (resultSet.next()) {
                    every = new CourseListBeans();
                    if (whileDatabase == 0) {
                        every.setCouseid(resultSet.getString("eid"));
                        every.setCousename(resultSet.getString("cname"));
                        every.setCouseday(resultSet.getString("day"));
                    } else {
                        every.setCouseid(resultSet.getString("id"));
                        every.setCousename(resultSet.getString("name"));
                        every.setCouseday("未知");
                    }
                    courseListBeans.add(every);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        request.setAttribute("allCourse", courseListBeans);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(forward);
        requestDispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
