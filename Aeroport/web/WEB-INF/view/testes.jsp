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
<title>Add new Teste</title>
</head>
<body>
    <center>
        <h1>Registro Testes</h1>
        <form method="POST" action='TestesController' name="frmAddTeste">
            Numero ANAC: <input type="number" name="n_ANAC" value="<c:out value="${testes.n_ANAC}" />" /> <br />
            Nome do aeroporto: <input type="text" name="nome" value="<c:out value="${testes.nome}" />" /> <br /> 
            Data do teste : <input type="text" placeholder="dd/MM/yyyy" name="datateste" data-date-format="dd/MM/yyyy" value="<fmt:formatDate pattern="dd/MM/yyyy" value="${testes.datateste}" />" /> <br /> 
            Quantidade de horas do teste: <input type="text" name="nhoras" value="<c:out value="${testes.nhoras}" />" /> <br /> 
            Nota tirada do teste: <input type="text" name="pontua??o" value="<c:out value="${testes.pontuacao}" />" /> <br /> 
            Matricula do t?cnico que realizou o teste: <input type="number" name="nmatricula" value="<c:out value="${testes.nmatricula}" />" /> <br /> 
             <input type="submit" value="Submit" />
        </form>
    </center>
</body>
</html>