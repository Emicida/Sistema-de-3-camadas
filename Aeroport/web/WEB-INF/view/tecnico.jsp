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
<title>Add new Tecnico</title>
</head>
<body>
    <center>
        <h1>Registro Técnico</h1>
        <form method="POST" action='TecnicoController' name="frmAddTecnico">
            Matrícula: <input type="number" name="nmatricula" value="<c:out value="${tecnico.nmatricula}" />" /> <br />
            Telefone: <input type="text" name="telefone" value="<c:out value="${tecnico.telefone}" />" /> <br /> 
            Salário R$: <input type="text" name="salario" placeholeder="Valor em reais" value="<c:out value="${tecnico.salario}" />" /> <br /> 
            Endereço: <input type="text" name="endereco" value="<c:out value="${tecnico.endereco}" />" /> <br /> 
            Numero de membro do sindicato : <input type="number" name="nmembro" value="<c:out value="${tecnico.nmembro}" />" /> <br /> 
            Nome do aeroporto onde trabalha: <input type="text" name="nome" value="<c:out value="${tecnico.nome}" />" /> <br />
            Especialização (Modelo): <input type="text" name="codmodelo" value="<c:out value="${tecnico.codmodelo}" />" /> <br /> 
             <input type="submit" value="Submit" />
        </form>
    </center>
</body>
</html>