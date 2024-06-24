package ra.jsp_servlet_demo.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "Dictionary", value = "/Dictionary")
public class Dictionary extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String input = request.getParameter("input");
        Map<String,String> dictionary = new HashMap<String,String>();

        dictionary.put("hello","xin chào");

        for (String i : dictionary.keySet()) {
            if (input.equals(i)) {
                request.setAttribute("input", i);
                request.setAttribute("output", dictionary.get(i));
                request.getRequestDispatcher("views/dictionary_result.jsp").forward(request, response);
            } else {
                String error = "Không tìm thấy";
                request.setAttribute("error", error);
                request.getRequestDispatcher("views/dictionary_result.jsp").forward(request, response);
            }
        }


    }
}