<%
if(session.getAttribute("login") != "true"){
	session.setAttribute("mensagem","Acesso Proibido: favor se autenticar");


%>

<jsp:forward page="/login.jsp"></jsp:forward>

<% } %>