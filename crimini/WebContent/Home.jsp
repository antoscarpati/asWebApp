<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import ="it.geek.crimini.model.Utente" %>

<%Utente ut=(Utente)request.getAttribute("utente"); %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Benvenuto&nbsp;carissimo&nbsp;<%=ut.getNome() %>&nbsp;<%=ut.getCognome()%> 

	<form name="homeForm" action="listaCaseDiscografiche">
		<input type="submit" name="vai" value="Vai alla lista delle case discografiche"/>	
	</form>

</body>
</html>