<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menu</title>
    </head>
    <body>
    <center>
        <p><a href="/AeroportoController?action=listaAeroportos" />Aeroporto</a></p>
        <p><a href="/AviaoController?action=listaAviao" />Avião</a></p>
        <p><a href="/Controlador_AereoController?action=listaControlador" />Controlador Aéreo</a></p>
        <p><a href="/ModeloController?action=listaModelos" />Modelo</a></p>
        <p><a href="/SindicatoController?action=listaSindicatos" />Sindicato</a></p>
        <p><a href="/TecnicoController?action=listaTecnicos" />Técnico</a></p>
        <p><a href="/TestesController?action=listaTestes" />Testes</a></p>
    </center>
        
</body>
</html>