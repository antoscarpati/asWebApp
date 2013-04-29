<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
function controllaCampi(){
		var userVal = document.InsertForm.username.value;
		if(userVal.length==0){
			alert("hai lasciato il campo username vuoto!!!");
			return false;
		}
		//controllo solo sull username, ripetere l'"IF" pure per gli altri campi per il controllo degli altri campi della form
	document.InsertForm.submit();
}
</script>
</head>
<body>
Qui potrai aggiungere un bell'utente, mi raccomando è fondamentale che sia bello!

	<form name="InsertForm" method="POST" action="AggiuntoUtente">
			username&nbsp;<input type="text" name="username" value="" /></br>
			password&nbsp;<input type="password" name="password" /></br>
		    nome&nbsp;<input type="text" name="nome" /></br>
		   	cognome&nbsp;<input type="text" name="cognome" /></br>
		   	id ruolo&nbsp;<input type="text" name="id_ruolo" /></br>
			<input type="button" name="AddButton" value="Aggiungi" onclick="controllaCampi();"/>
		
	</form>
</body>
</html>