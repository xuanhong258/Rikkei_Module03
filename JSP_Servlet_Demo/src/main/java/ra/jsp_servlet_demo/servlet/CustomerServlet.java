package ra.jsp_servlet_demo.servlet;

import ra.jsp_servlet_demo.entity.Customer;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CustomerServlet", value = "/CustomerServlet")
public class CustomerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> listCustomers = new ArrayList<>();
        Customer cus1 = new Customer("Khách hàng 1", "1984-04-23", "Hà Nội", "images/Avatar1.jpeg");
        Customer cus2 = new Customer("Khách hàng 2", "1984-04-23", "Hồ Chí Minh", "images/Avatar2.jpeg");
        listCustomers.add(cus1);
        listCustomers.add(cus2);

        request.setAttribute("listCustomers",listCustomers);
        request.getRequestDispatcher("views/customer.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}