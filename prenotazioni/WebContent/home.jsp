<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import ="it.geek.prenotazioni.model.Studente" %>

<%Studente s=(Studente)session.getAttribute("studente"); %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
</head>
<body>
Benvenuto&nbsp;carissimo&nbsp;<%=s.getNome() %>&nbsp;<%=s.getCognome()%> 

	<form name="LogoutForm" method="POST" action="logout">
		<input type="submit" name="Logout" value="logout"/>	
	</form>
	

	<form name="homeForm" method="GET" action="sceltaCorso">
		<input type="submit" name="vai" value="scegli un corso"/>	
	</form>
	
</body>
</html>