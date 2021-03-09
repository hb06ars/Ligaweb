<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>


<!--  AUTOR -->
<script>
function modalRegulamento(){
	$("#modalRegulamento").modal().show();
}
</script>

<div class="modal fade" id="modalRegulamento" tabindex="-1" role="dialog" aria-labelledby="exampleModalScrollableTitle" aria-hidden="true">
        <div class="modal-dialog modal-dialog-scrollable" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalScrollableTitle">REGULAMENTO</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">×</span>
                    </button>
                </div>
                <div class="modal-body">
                    <p>
						1. Só será pontuado até dois jogos jogos contra o mesmo adversário (IDA e VOLTA), ou seja, você só poderá marcar um jogo de IDA e um jogo de VOLTA contra o mesmo Adversário até o final da liga.
						<br>2. Cada vitória equivale a 3 pontos, o Empate equivale a 1 ponto e a derrota não acumula pontos.
						<br>3. Até o final da Liga é consagrado o time campeão o que obtiver o maior número de pontos.
						<br>4. Novos jogadores podem ser adicionados durante o andamento da LIGA.
					</p>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Fechar</button>
                </div>
            </div>
        </div>
    </div>
<!--  FINAL AUTOR -->



