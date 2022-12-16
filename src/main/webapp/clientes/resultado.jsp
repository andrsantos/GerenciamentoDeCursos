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
     <title>Página de sucesso!</title>
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
            <a class="text-center"> ${mensagem} </a>
            <c:if test="${cliente != null }">
            <h3 class="text-center">Cpf:${cliente.cpf}</h3>
            <h3 class="text-center">Cpf:${cliente.nome}</h3>
            <h3 class="text-center">Cpf:${cliente.email}</h3>
            </c:if>
          </div>
        </div>
      </div>
    </div>
    
    
    <div class="section">
      <div class="container">
        <div class="row">
          <div class="col-md-12 text-center">
            <div class="col-md-12  btn-group btn-group-lg btn-group-vertical">
             
              <a href="../index.jsp" class="btn btn-default">CURSOS</a>
              
            </div>
          </div>
        </div>
      </div>
    </div>
   
    <footer>
      <div class="navbar navbar-fixed-bottom bgred">
        <div class="container">
          <div class="row">
            <div class="col-sm-12 text-center" style="top:13px;color:#fff;">Â© ABCTreinamentos - Curso de Java 8 para Web</div>
          </div>
        </div>
      </div>
    </footer>
  

</body></html>