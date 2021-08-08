<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
        <title>Mostra Tecnicos</title>
    </head>
<body>
    <center>
        <table border=1>
            <thead>
                <tr>
                    <th>Matricula</th>
                    <th>Telefone</th>
                    <th>Salario</th>
                    <th>Endere?o</th>
                    <th>N_Sindicato</th>
                    <th>Aeroporto</th>
                    <th>Especialia??o</th>
                    <th colspan=2>Action</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${tecnicos}" var="tecnico">
                    <tr>
                        <td><c:out value="${tecnico.nmatricula}" /></td>
                        <td><c:out value="${tecnico.telefone}" /></td>
                        <td><c:out value="${tecnico.salario}" /></td>
                        <td><c:out value="${tecnico.endereco}" /></td>
                        <td><c:out value="${tecnico.nmembro}" /></td>
                        <td><c:out value="${tecnico.nome}" /></td>
                        <td><c:out value="${tecnico.codmodelo}" /></td>
                        <td><a href="TecnicoController?action=edit&nmatricula=<c:out value="${tecnico.nmatricula}"/>">Update</a></td>
                        <td><a href="TecnicoController?action=delete&nmatricula=<c:out value="${tecnico.nmatricula}"/>">Delete</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <p><a href="TecnicoController?action=insert">Add Tecnico</a></p>
    </center>
</body>
</html>