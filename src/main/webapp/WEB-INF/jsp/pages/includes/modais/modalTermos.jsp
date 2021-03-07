<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>


<!--  AUTOR -->
<script>
function modalTermos(){
	$("#modalTermos").modal().show();
}
</script>

<div class="modal fade" id="modalTermos" tabindex="-1" role="dialog" aria-labelledby="exampleModalScrollableTitle" aria-hidden="true">
        <div class="modal-dialog modal-dialog-scrollable" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalScrollableTitle">Termos e Condi��es</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">�</span>
                    </button>
                </div>
                <div class="modal-body">
                    <p>
						1. N�o � necess�rio nenhuma informa��o da PSN a n�o ser o nome de usu�rio para o Jogador encontrar o oponente.
						<br>2. Qualquer tentativa de burlar, o jogador ser� exclu�do permanentemente.
						<br>3. O c�digo de acesso de cria��o � fornecido apenas pelo Admnistrador.
						<br>4. N�o � permitido apostas entre as partidas.
					</p>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Fechar</button>
                </div>
            </div>
        </div>
    </div>
<!--  FINAL AUTOR -->



