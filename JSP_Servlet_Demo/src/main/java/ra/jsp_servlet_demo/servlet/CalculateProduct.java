package ra.jsp_servlet_demo.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CalculateProduct", value = "/CalculateProduct")
public class CalculateProduct extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        String productName = request.getParameter("productName");
        String description = request.getParameter("description");
        float price = Float.parseFloat(request.getParameter("price"));
        float discountPercent = Float.parseFloat(request.getParameter("discountPercent"));

        float discountAmount = price * discountPercent / 100;
        float discountPrice = price - discountAmount;

        request.setAttribute("productName", productName);
        request.setAttribute("discountAmount", discountAmount);

        request.getRequestDispatcher("views/display_discount.jsp").forward(request, response);
    }
}