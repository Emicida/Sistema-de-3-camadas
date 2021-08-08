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
<title>Add new Aviao</title>
</head>
<body>
    <center>
        <p><h1>Registro Avião</h1></p>
        <form method="POST" action='AviaoController' name="frmAddAviao">
            Registro: <input type="number" name="registro" value="<c:out value="${aviao.registro}" />" /> <br />
            Nome do aeroporto: <input type="text" name="nome" value="<c:out value="${aviao.nome}" />" /> <br /> 
            Modelo do avi?o: <input type="text" name="codmodelo" value="<c:out value="${aviao.codmodelo}" />" /> <br /> 
             <input type="submit" value="Submit" />
        </form>
    </center>
</body>
</html>