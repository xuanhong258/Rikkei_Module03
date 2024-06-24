package ra.jsp_servlet_demo.servlet;

import ra.jsp_servlet_demo.entity.UserData;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UserServlet", value = "/UserServlet")
public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserData userData = new UserData(1,"Nguyễn Văn A","nva@gmail.com",20);
        request.setAttribute("userData",userData);
        request.getRequestDispatcher("views/userInformation.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}