<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="../util/topo.jsp"></jsp:include>
<!DOCTYPE html><head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script type="text/javascript" src="lib/js/jquery.min.js"></script>
    <script type="text/javascript" src="lib/js/bootstrap.min.js"></script>
    <link href="lib/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="lib/css/bootstrap.css" rel="stylesheet" type="text/css">
     <link href="lib/css/padrao.css" rel="stylesheet" type="text/css">
     <title>P?gina de consulta a todos os clientes!</title>
  </head><body>
    <div class="section section-danger text-justify">
      <div class="container">
        <div class="row text-center">
          <div class="col-md-12 text-center">
            <a class="text-center">Sistema de Gerenciamento de Cursos</h1>
          </div>
        </div>
      </div>
    </div>
    
     <div class="section section-danger text-justify">
      <div class="container">
        <div class="row text-center">
          <div class="col-md-12 text-center">
            <h3 class="tt_menu">&gt;&gt; CLIENTES - CONSULTAR CLIENTES</h3>
          </div>
        </div>
      </div>
    </div>
    
    
    
    
     <div class="section section-danger text-justify">
      <div class="container">
        <div class="row text-center">
          <div class="col-md-12 text-center">
            <a class="text-center"> ${mensagem} </a>
           
            <table align="center" border="1">
            <tr>
             <th>CPF</th>
             <th>NOME</th>
             <th>EMAIL</th>
            
            </tr>
            <c:forEach var="row" items="${clientes}">
            <tr>
            <td><c:out value="${row.cpf}"/></td>
            <td><c:out value="${row.nome}"/></td>
            <td><c:out value="${row.email}"/></td>
            
            </tr>
            </c:forEach>
            
            </table>
          </div>
        </div>
      </div>
    </div>
    
    
    <div class="section">
      <div class="container">
        <div class="row">
          <div class="col-md-12 text-center">
            <div class="col-md-12  btn-group btn-group-lg btn-group-vertical">
             
              <a href="javascript:window.history.go(-1)" class="btn btn-default">VOLTAR</a>
              
            </div>
          </div>
        </div>
      </div>
    </div>
   
    <footer>
      <div class="navbar navbar-fixed-bottom bgred">
        <div class="container">
          <div class="row">
            <div class="col-sm-12 text-center" style="top:13px;color:#fff;">© ABCTreinamentos - Curso de Java 8 para Web</div>
          </div>
        </div>
      </div>
    </footer>
  

</body></html>