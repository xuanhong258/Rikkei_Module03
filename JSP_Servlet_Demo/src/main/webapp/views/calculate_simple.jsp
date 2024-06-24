<%--
  Created by IntelliJ IDEA.
  User: flicker03
  Date: 6/24/2024
  Time: 11:22 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Simple Calculate</title>
</head>
<body>
    <form action="" method="post">
        <fieldset>
            <legend>Calculator</legend>
            <label for="firstOperand">First Operand</label>
            <input type="text" id="firstOperand" name="firstOperand"/><br>
            <label>Operator</label>
            <select>
                <option value="add" name="add">Addition</option>
                <option value="minus" name="minus">Minus</option>
                <option value="multi" name="multi">Multi</option>
                <option value="div" name="div">Division</option>
            </select>
            <br>
            <label for="secondOperand">Second Operand</label>
            <input type="text" id="secondOperand" name="secondOperand"/><br>
            <input type="submit" value="Calculate"/>
        </fieldset>
    </form>
</body>
</html>
