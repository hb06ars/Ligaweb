<!-- HEADER -->
<jsp:include page="includes/header.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<!-- HEADER -->
<!-- MODAL -->
<!-- TABELAS COM FILTRO -->
<jsp:include page="includes/jquery/filtro.jsp" />
<script type="text/javascript" src="http://code.jquery.com/jquery-1.7.2.min.js"></script> 
<script type="text/javascript" src="includes/jquery/script.js"></script>
<!-- TABELAS COM FILTRO -->
<!-- DOWNLOAD EXCEL -->
<jsp:include page="includes/jquery/excel/downloadExcel.jsp" />
<!-- DOWNLOAD EXCEL -->
<!-- UPLOAD EXCEL -->
<jsp:include page="includes/modais/modalUploadExcel.jsp" />
<!-- UPLOAD EXCEL -->

<style>
.zoom {
  transition: transform .2s;
}
.zoom:hover {
  -ms-transform: scale(1.1); /* IE 9 */
  -webkit-transform: scale(1.1); /* Safari 3-8 */
  transform: scale(1.1); 
}
</style>

<div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 ">


<script>
function redirecionar(pagina){
	window.location.href = "/"+pagina;
}
</script>


<div class="row zoom" align="center" style="margin: auto;cursor:pointer" onclick="redirecionar('classificacao')">
	<div class="card bg-default ml-3 mt-3" style="min-height: 18rem; min-width: 18rem ;filter: brightness(130%);  ">
	  <div class="card-header"><h5>Classificação</h5></div>
	  <div class="card-body ">
	  	<h5 class="card-title bg-light" style="width:100%; height:100%; filter: brightness(70%); background: no-repeat center; background-size: cover;background-image: url('/img/ranking.png')"></h5>
	  </div>
	</div>
</div>

<div class="row zoom" align="center" style="margin: auto;cursor:pointer" onclick="redirecionar('adversario')">
	<div class="card bg-default ml-3 mt-3" style="min-height: 18rem; filter: brightness(130%); min-width: 18rem; ">
	  <div class="card-header"><h5>Adversário</h5></div>
	  <div class="card-body">
	  	<h5 class="card-title bg-light" style="width:100%; height:100%; filter: brightness(70%); background: no-repeat center; background-size: cover;background-image: url('/img/adv.png')"></h5>
	  </div>
	</div>
</div>

<div class="row zoom" align="center" style="margin: auto;cursor:pointer" onclick="redirecionar('meusJogos')">
	<div class="card bg-default ml-3 mt-3" style="min-height: 18rem; filter: brightness(130%); min-width: 18rem; ">
	  <div class="card-header"><h5>Meus Jogos</h5></div>
	  <div class="card-body">
	  	<h5 class="card-title bg-light" style="width:100%; height:100%; filter: brightness(70%); background: no-repeat center; background-size: cover;background-image: url('/img/soccer.png')"></h5>
	  </div>
	</div>
</div>

<div class="row zoom" align="center" style="margin: auto;cursor:pointer" onclick="redirecionar('resultados')">
	<div class="card bg-default ml-3 mt-3" style="min-height: 18rem; filter: brightness(130%); min-width: 18rem; ">
	  <div class="card-header"><h5>Resultados</h5></div>
	  <div class="card-body">
	  	<h5 class="card-title bg-light" style="width:100%; height:100%; filter: brightness(70%); background: no-repeat center; background-size: cover;background-image: url('/img/lista.png')"></h5>
	  </div>
	</div>
</div>


</div>
<br>

<!-- FOOTER -->
<jsp:include page="includes/barraFooter.jsp" />
<!-- FOOTER -->

<!-- FOOTER -->
<jsp:include page="includes/footer.jsp" />
<!-- FOOTER -->

