<jsp:include page="../util/topo.jsp"></jsp:include>
<html><head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script type="text/javascript" src="../lib/js/jquery.min.js"></script>
    <script type="text/javascript" src="../lib/js/bootstrap.min.js"></script>
    <link href="../lib/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="../lib/css/bootstrap.css" rel="stylesheet" type="text/css">
    <link href="../lib/css/padrao.css" rel="stylesheet" type="text/css">
  </head><body>
    <div class="section section-danger text-justify">
      <div class="container">
        <div class="row text-center">
          <div class="col-md-12 text-center">
            <h1 class="text-center">Sistema de Gerenciamento de Cursos</h1>
          </div>
        </div>
      </div>
    </div>
    <div class="section">
      <div class="container">
        <div class="row">
          <div class="col-md-12 text-center">
            <h3 class="tt_menu">&gt;&gt; PAGAMENTOS - CONSULTAR UM NOVO PAGAMENTO &lt;&lt;</h3>
          </div>
        </div>
        <div class="row">
          <div class="col-md-12">
            <form class="form-horizontal" role="form" action="http://localhost:8006/LojaVirtual/ServletControlador" method="post">
              <div class="form-group">
                <div class="col-sm-2">
                  <label for="inputCPF" class="control-label">Informar o CPF:</label>
                </div>
                <div class="col-sm-10">
                  <input type="text" class="form-control" id="inputCPF" placeholder="CPF" pattern="\d{3}\.\d{3}\.\d{3}-\d{2}" title="Digite um CPF no formato: xxx.xxx.xxx-xx" required="" name="cpf">
                </div>
              </div>
              <div class="form-group">
                <div class="col-sm-2">
                  <label for="inputCURSO" class="control-label">Informar o CURSO:</label>
                </div>
                <div class="col-sm-10">
                  <input type="text" class="form-control" id="inputCURSO" placeholder="CURSO" name="curso">
                </div>
              </div>
              <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                 <input type="hidden" name="idformulario" value="3">
                 <input type="hidden" name="tipoformulario" value="32">
                  <button type="submit" class="btn btn-danger">Consultar</button>
                </div>
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>
    <footer>
      <div class="navbar navbar-fixed-bottom bgred">
        <div class="container">
          <div class="row">
            <div class="col-sm-12 text-center" style="top:13px;color:#fff;">?? ABCTreinamentos - Curso de Java 8 para Web</div>
          </div>
        </div>
      </div>
    </footer>
    <div class="section">
      <div class="container">
        <div class="row">
          <div class="col-md-12 text-center corrigir">
            <a class="btn btn-default" href="javascript:window.history.go(-1)">Voltar</a>
          </div>
        </div>
      </div>
    </div>
  

</body></html>