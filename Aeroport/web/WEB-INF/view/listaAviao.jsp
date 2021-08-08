<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
        <title>Mostrar Avi?es</title>
    </head>
<body>
    <center>
        <table border=1>
            <thead>
                <tr>
                    <th>Registro</th>
                    <th>Nome do aeroporto</th>
                    <th>Codmodelo</th>
                    <th colspan=2>Action</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${avioes}" var="aviao">
                    <tr>
                        <td><c:out value="${aviao.registro}" /></td>
                        <td><c:out value="${aviao.nome}" /></td>
                        <td><c:out value="${aviao.codmodelo}" /></td>
                        <td><a href="AviaoController?action=edit&registro=<c:out value="${aviao.registro}"/>">Update</a></td>
                        <td><a href="AviaoController?action=delete&registro=<c:out value="${aviao.registro}"/>">Delete</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <p><a href="AviaoController?action=insert">Add Avi?o</a></p>
    </center>
</body>
</html>