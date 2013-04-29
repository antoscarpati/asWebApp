<%@ page language="java" contentType="text/html; charset=ISO-8859-1" 
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %> 
<%@ page import="it.geek.prenotazioni.model.Corso"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Scegli il corso</title>
</head>
<% List<Corso> lista = (List<Corso>)request.getAttribute("Corso");%>
<body>
<P ALIGN="CENTER">
Sceli il corso da prenotare

	<table border=6 table align=center>
		<tr>
			<td>id corso</td>
			<td>Materia</td>
		</tr>
 <%if(lista!=null){
	 for(int i=0; i<lista.size();i++){%>
 
		<tr>
			<td><%=((Corso)lista.get(i)).getId() %></td>
			<td><%=((Corso)lista.get(i)).getMateria() %></td>
			<td><a href = "prenotazioneCorso?id=<%=((Corso)lista.get(i)).getId() %>"> PRENOTA!</a>
			
			
		</tr>
	<%} %>
<%} %>
      </table>
			

</body>
</html>