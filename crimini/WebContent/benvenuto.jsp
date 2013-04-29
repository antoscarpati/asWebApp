
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" 
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %> 
<%@ page import="it.geek.crimini.model.Utente"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Benvenuto</title>
</head>
<% List<Utente> lista = (List<Utente>)request.getAttribute("Utente");%>
<body>
<P ALIGN="CENTER">
Se vuoi aggiungere un bell' utente nuovo nuovo clicca su questo bel bottone.
<center>
<form name="InserisciForm" method="GET" action="inserisciUtente">
		<input type="submit" name="vai" value="inserisci un bell' utente"/>	
		</center>
		<P ALIGN="CENTER">
		questi invece sono gli utenti presenti.
	<table border=6 table align=center>
		<tr>
			<td>Nome</td>
			<td>Cognome</td>
			<td>Id_ruolo</td>
		</tr>
 <%if(lista!=null){
	 for(int i=0; i<lista.size();i++){%>
 
		<tr>
			<td><%=((Utente)lista.get(i)).getNome() %></td>
			<td><%=((Utente)lista.get(i)).getCognome() %></td>
			<td><%=((Utente)lista.get(i)).getId_ruolo() %></td>
			<td><a href = "visualizzaArtisti?id=<%=((Utente)lista.get(i)).getNome() %>"> Visualizza</a>
			<td><a href = "visualizzaArtisti?id=<%=((Utente)lista.get(i)).getNome() %>"> Modifica</a>
			<td><a href = "visualizzaArtisti?id=<%=((Utente)lista.get(i)).getNome() %>"> Elimina</a>
			
		</tr>
	<%} %>
<%} %>
      </table>
			

</body>
</html>