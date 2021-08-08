<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
        <title>Mostra Controladores</title>
    </head>
<body>
    <center>
        <table border=1>
            <thead>
                <tr>
                    <th>N_Membro</th>
                    <th>Data exame</th>
                    <th colspan=2>Action</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${controladores}" var="controlado_aereo">
                    <tr>
                        <td><c:out value="${controlado_aereo.nmembro}" /></td>
                        <td><fmt:formatDate pattern="dd/MM/yyyy" value="${controlado_aereo.exame}" /></td>
                        <td><a href="Controlador_AereoController?action=edit&nmembro=<c:out value="${controlado_aereo.nmembro}"/>">Update</a></td>
                        <td><a href="Controlador_AereoController?action=delete&nmembro=<c:out value="${controlado_aereo.nmembro}"/>">Delete</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <p><a href="Controlador_AereoController?action=insert">Add Controlador Aereo</a></p>
    </center>
</body>
</html>