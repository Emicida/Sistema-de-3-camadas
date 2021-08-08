<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link type="text/css"
    href="css/ui-lightness/jquery-ui-1.8.18.custom.css" rel="stylesheet" />
<script type="text/javascript" src="http://code.jquery.com/jquery-1.7.1.js"></script>
<script type="text/javascript" src="http://www.godtur.no/godtur/js/jquery-ui-1.8.18.custom.min.js"></script>
<title>Add new Modelo</title>
</head>
<body>
    <center>
        <h1>Registro Modelo</h1>
        <form method="POST" action='ModeloController' name="frmAddModelo">
            Codigo do modelo: <input type="text" name="codmodelo" value="<c:out value="${modelo.codmodelo}" />" /> <br /> 
            Capacidade de pessoas : <input type="number" name="capacidade" value="<c:out value="${modelo.capacidade}" />" /> <br /> 
            Peso do avião: <input type="text" name="peso" value="<c:out value="${modelo.peso}" />" /> <br /> 
             <input type="submit" value="Submit" />
        </form>
    </center>
</body>
</html>