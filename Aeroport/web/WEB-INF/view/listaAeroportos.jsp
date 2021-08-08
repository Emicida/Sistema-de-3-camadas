<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
        <title>Mostrar Aeroportos</title>
    </head>
<body>
    <center>
        <table border=1>
            <thead>
                <tr>
                    <th>Nome</th>
                    <th>Endere?o</th>
                    <th>Numero de Avi?es</th>
                    <th colspan=2>Action</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${aeroportos}" var="aeroporto">
                    <tr>
                        <td><c:out value="${aeroporto.nome}" /></td>
                        <td><c:out value="${aeroporto.endereco}" /></td>
                        <td><c:out value="${aeroporto.naviões}" /></td>
                        <td><a href="AeroportoController?action=edit&nome=<c:out value="${aeroporto.nome}"/>">Update</a></td>
                        <td><a href="AeroportoController?action=delete&nome=<c:out value="${aeroporto.nome}"/>">Delete</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <p><a href="AeroportoController?action=insert">Add Aeroporto</a></p>
    </center>
</body>
</html>