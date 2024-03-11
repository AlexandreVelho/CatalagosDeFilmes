<%@page import="br.com.fmp.modelo.Filme"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de FilmesNatagbody</title>
</head>
<body>
	<h2>Lista de Filmes</h2>
	<ol>
		<%
		Object obj = request.getAttribute("listaFiltrada");
		if (obj != null && obj instanceof ArrayList) {
			ArrayList<?> rawList = (ArrayList<?>) obj;
			for (Object item : rawList) {
				if (item instanceof Filme) {
			Filme filme = (Filme) item;
		%>
		<li>Nome: <%=filme.getNome()%></li>
		<li>Gênero: <%=filme.getGenero()%></li>
		<li>Ano: <%=filme.getAno()%></li>
		<%
		}
		}
		}
		%>
	</ol>
</body>
</html>
