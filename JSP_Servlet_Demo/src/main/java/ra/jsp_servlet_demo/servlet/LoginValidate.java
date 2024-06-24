package ra.jsp_servlet_demo.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LoginValidate", value = "/LoginValidate")
public class LoginValidate extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if(username.equals("xuanhong258") && password.equals("123456")){
            request.getRequestDispatcher("views/login_successfully.jsp").forward(request,response);
        }else {
            String errorMessage = "Tài khoản hoặc mật khẩu không chính xác";
            request.setAttribute("error", errorMessage);
            request.getRequestDispatcher("views/login.jsp").forward(request,response);
        }
    }
}