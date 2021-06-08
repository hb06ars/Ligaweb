<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>



<!--  DELETAR PERFIL -->
<script>
function modalVencedor(id,escudoVencedor, nomeVencedor, escudoPerdedor, nomePerdedor){
	document.getElementById("idDisputa").value = id;
	document.getElementById("timeVencedor").value = nomeVencedor;
	document.getElementById("escudoVencedor").value = escudoVencedor;
	document.getElementById("timePerdedor").value = nomePerdedor;
	document.getElementById("escudoPerdedor").value = escudoPerdedor;
	document.getElementById("esc").src = escudoVencedor;
	document.getElementById("tituloVenc").innerHTML = nomeVencedor+" venceu!!!";
	document.getElementById("msg").innerHTML = "Tem certeza que o <b>"+nomeVencedor+"</b> foi o vencedor?";
	$("#modalVencedor").modal().show();
	
}

function confirmaVencedor(){
	document.getElementById('formProx').submit();
}

</script>
<div class="modal fade" id="modalVencedor" tabindex="-1" role="dialog" aria-labelledby="TituloModalCentralizado" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="TituloModalCentralizado"><span id="tituloVenc">Vencedor</span></h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Fechar">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body" id="msg">
      	Tem certeza que deseja excluir?
      </div>
      	<div>
      		&nbsp&nbsp&nbsp&nbsp<img style="max-width:100px;max-height:100px" id="esc" src="" alt="" style="display: block;">
      	</div>
		<br>
      <div class="modal-footer">
      	<form action="/iniciarMataMata" id="formProx" method="post" accept-charset="utf-8">
	      	 <input type="hidden" id="timeVencedor" name="timeVencedor">
	      	 <input type="hidden" id="escudoVencedor" name="escudoVencedor">
	      	 <input type="hidden" id="timePerdedor" name="timePerdedor">
	      	 <input type="hidden" id="escudoPerdedor" name="escudoPerdedor">
	      	 <input type="hidden" id="idDisputa" name="idDisputa">
      	 </form>
        <button type="button" class="btn btn-danger" id="ok" onclick="confirmaVencedor()" data-dismiss="modal">Sim</button>
        <button type="button" class="btn btn-primary" id="deletar" data-dismiss="modal">Não</button>
      </div>
    </div>
  </div>
</div>
<!--  DELETAR PERFIL -->
