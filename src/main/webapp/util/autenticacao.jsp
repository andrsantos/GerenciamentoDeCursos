<jsp:directive.page import="java.sql.*" />
<jsp:declaration>
 static String url = "jdbc:mysql://localhost:3306/curso5";
 static String usuario = "root";
 static String senha = "andrey12";
 static Connection conexao;

 public void init() throws ServletException {
	 try{
		 
		 conexao = DriverManager.getConnection(url,usuario,senha);
		 conexao.setAutoCommit(false);
		 
	 } catch(SQLException e){
		 e.printStackTrace();
	 }
 }




</jsp:declaration>
<jsp:scriptlet>
String cpfMascara = request.getParameter("cpf");
cpfMascara = cpfMascara.replaceAll("[.-]","");
String senha = request.getParameter("senha");
String consulta = "SELECT * FROM LOGIN WHERE CPF='"+cpfMascara+"' AND SENHA='"+senha+"'";
Statement statement;

try{
	statement = conexao.createStatement();
	ResultSet rs = statement.executeQuery(consulta);
	if(rs.next()){
		session.setAttribute("mensagem", "Usuário Autenticado!");
		session.setAttribute("login","true");
		response.sendRedirect("../index.jsp");
	} else{
		session.setAttribute("mensagem", "Usuário Não Autenticado! Informar outro CPF e Senha!");
		session.setAttribute("login", "false");
		response.sendRedirect("../login.jsp");
	
	} 
    }catch(SQLException e){
		e.printStackTrace();
	}


</jsp:scriptlet>