<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
        <title>Mostra Modelos</title>
    </head>
<body>
    <center>
        <table border=1>
            <thead>
                <tr>
                    <th>Cod Modelo</th>
                    <th>Capacidade</th>
                    <th>Peso</th>
                    <th colspan=2>Action</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${modelos}" var="modelo">
                    <tr>
                        <td><c:out value="${modelo.codmodelo}" /></td>
                        <td><c:out value="${modelo.capacidade}" /></td>
                        <td><c:out value="${modelo.peso}" /></td>
                        <td><a href="ModeloController?action=edit&codmodelo=<c:out value="${modelo.codmodelo}"/>">Update</a></td>
                        <td><a href="ModeloController?action=delete&codmodelo=<c:out value="${modelo.codmodelo}"/>">Delete</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <p><a href="ModeloController?action=insert">Add Modelo</a></p>
    </center>
</body>
</html>