<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
        <title>Mostra Testes</title>
    </head>
<body>
    <center>
        <table border=1>
            <thead>
                <tr>
                    <th>ANAC</th>
                    <th>Nome</th>
                    <th>Data</th>
                    <th>Horas</th>
                    <th>Pontua??o</th>
                    <th>Tecnico</th>
                    <th colspan=2>Action</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${testes}" var="teste">
                    <tr>
                        <td><c:out value="${teste.n_ANAC}" /></td>
                        <td><c:out value="${teste.nome}" /></td>
                        <td><fmt:formatDate pattern="dd/MM/yyyy" value="${teste.datateste}" /></td>
                        <td><c:out value="${teste.nhoras}" /></td>
                        <td><c:out value="${teste.pontuacao}" /></td>
                        <td><c:out value="${teste.nmatricula}" /></td>
                        <td><a href="TestesController?action=edit&n_ANAC=<c:out value="${teste.n_ANAC}"/>">Update</a></td>
                        <td><a href="TestesController?action=delete&n_ANAC=<c:out value="${teste.n_ANAC}"/>">Delete</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <p><a href="TestesController?action=insert">Add Teste</a></p>
    </center>
</body>
</html>