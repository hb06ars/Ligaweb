<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>



<!--  DELETAR PERFIL -->
<script>
function modalNovoTorneio(){
	$("#modalNovoTorneio").modal().show();
	
}

function confirmaNovo(){
	document.getElementById('novoTorneio').value = "1";
	document.getElementById('novo').submit();
}

</script>
<div class="modal fade" id="modalNovoTorneio" tabindex="-1" role="dialog" aria-labelledby="TituloModalCentralizado" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="TituloModalCentralizado"><span id="tituloVenc">Parabéns!</span></h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Fechar">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body" id="msg">
      	Tem certeza que deseja criar um novo torneio?
      </div>
		<br>
      <div class="modal-footer">
      	<form action="/mata-mata" id="novo" method="post" accept-charset="utf-8">
	      	 <input type="hidden" id="novoTorneio" name="novoTorneio" value="0">
      	 </form>
        <button type="button" class="btn btn-danger" id="ok" onclick="confirmaNovo()" data-dismiss="modal">Sim</button>
        <button type="button" class="btn btn-primary" id="deletar" data-dismiss="modal">Não</button>
      </div>
    </div>
  </div>
</div>
<!--  DELETAR PERFIL -->
