package ra.jsp_servlet_demo.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Calculate", value = "/Calculate")
public class Calculate extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        float firstOperand = Float.parseFloat(request.getParameter("firstOperand"));
        float secondOperand = Float.parseFloat(request.getParameter("secondOperand"));
        String operator = request.getParameter("operator");
        float result;
        String operatorStr;
        switch (operator){
            case "add":
                result = firstOperand + secondOperand;
                operatorStr = "+";
                break;
            case "minus":
                result = firstOperand - secondOperand;
                operatorStr = "-";
                break;
            case "div":
                result = firstOperand / secondOperand;
                operatorStr = ":";
                break;
            case "multi":
                result = firstOperand * secondOperand;
                operatorStr = "x";
                break;
            default:
                result = firstOperand % secondOperand;
                operatorStr = "%";
                break;
        }
        request.setAttribute("result", result);
        request.setAttribute("firstOperand",firstOperand);
        request.setAttribute("secondOperand",secondOperand);
        request.setAttribute("operator",operatorStr);
        request.getRequestDispatcher("views/calculate.jsp").forward(request, response);
        }
}