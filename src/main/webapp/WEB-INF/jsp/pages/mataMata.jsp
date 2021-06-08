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
<script type="text/javascript" src="https://code.jquery.com/jquery-1.7.2.min.js"></script> 
<script type="text/javascript" src="includes/jquery/script.js"></script>
<link href="script.js" rel="stylesheet" id="style">
<!-- TABELAS COM FILTRO -->
<!-- DOWNLOAD EXCEL -->
<jsp:include page="includes/jquery/excel/downloadExcel.jsp" />
<!-- DOWNLOAD EXCEL -->





<script>
function verEscudo(){
	var link = document.getElementById("selectTime").value;
	document.getElementById("escudoValor").src = link;
	document.getElementById("escudo").value = document.getElementById("escudoValor").src;

}
function remover(id){
	document.getElementById("remove").value = id;
	document.getElementById("form").submit();

}
function iniciar(){
	document.getElementById("inicioMataMata").submit();
}
</script>

        <div class="main-container">
            <div class="container">
            	<c:if test="${preenchidos.size() == 0 }">
                <div class="card mb-4">
                    <div class="card-header align-self-center">
                        <h6 class="mb-0">Cadastrar Equipe</h6>
                    </div>
                    <div class="card-body">
                        <form action="/mata-mata" id="form" method="post" accept-charset="utf-8">
                            <div class="form-group">
                                <label for="exampleFormControlInput1">Jogador</label>
                                <input type="text" name="jogador" class="form-control is-valid" id="exampleFormControlInput1" placeholder="Seu nome" required>
                            </div>
							<br>
							<div class="form-group">
                                <label for="exampleFormControlInput1">Escudo do Time:</label>
                                <select onchange="verEscudo()" class="form-control" id="selectTime">
                                    <option selected value="/img/clubes/padrao.jpg">
                                    	Escudo Padrão
                                    </option>
                                    
                                    <option  value="/img/clubes/arsenal.png">
									Arsenal
									</option>
									
									<option  value="/img/clubes/atleticoMadrid.png">
									Atlético de Madrid
									</option>
									
									<option  value="/img/clubes/borussia.png">
									Borussia Dortmund
									</option>
									
									<option  value="/img/clubes/chelsea.png">
									Chelsea
									</option>
									
									<option  value="/img/clubes/barcelona.png">
									FC Barcelona
									</option>
									
									<option  value="/img/clubes/bayern.png">
									FC Bayern
									</option>
									
									<option  value="/img/clubes/inter.png">
									Inter
									</option>
									
									<option  value="/img/clubes/leicester.png">
									Leicester City
									</option>
									
									<option  value="/img/clubes/liverpool.png">
									Liverpool
									</option>
									
									<option  value="/img/clubes/lyon.png">
									Lyon
									</option>
									
									<option  value="/img/clubes/city.png">
									Manchester City
									</option>
									
									<option  value="/img/clubes/manchesterUnited.jpg">
									Manchester Utd
									</option>
									
									<option  value="/img/clubes/milan.png">
									Milan
									</option>
									
									<option  value="/img/clubes/psg.png">
									Paris SG
									</option>
									
									<option  value="/img/clubes/realMadrid.png">
									Real Madrid
									</option>
									
									<option  value="/img/clubes/totenham.png">
									Totenham
									</option>
									
																		
                                </select>
                                <br>
								<img id="escudoValor" name="escudoValor" style="max-height:150px;max-width:150px" src="https://st3.depositphotos.com/1030956/15217/v/600/depositphotos_152177936-stock-illustration-blank-heraldic-coat-of-arms.jpg" alt="" style="display: block;">
								<input type="hidden" id="escudo" name="escudo"  value="https://st3.depositphotos.com/1030956/15217/v/600/depositphotos_152177936-stock-illustration-blank-heraldic-coat-of-arms.jpg">
							
							</div>
                            <div class="form-group">
								<button type="submit" class="mb-2 btn btn-lg btn-primary">Inserir time</button>
                            </div>
							<br>
							<input type="hidden" name="remove" id="remove" value="0">
                        </form>
                    </div>
                </div>
				</c:if>
				
				<div class="card mb-4">
                    <div class="card-header">
                    	 <c:if test="${preenchidos.size() == 0 }">
                    		<h6 class="mb-0">Equipes cadastradas até agora ${mataMata.size()}</h6>
                    	 </c:if>
                        <c:if test="${preenchidos.size() > 0 }">
                        	<h6 class="mb-0">Equipes cadastradas no torneio ${mataMata.size()}</h6>
                        </c:if>
                    </div>
                    <div class="card-body">
                        <form>
							<div class="form-group">
                                <c:forEach items="${mataMata }" var="m">
                                <c:if test="${preenchidos.size() == 0 }">
                                	<span onclick="remover(${m.id })" style="color:red;cursor:pointer" class="material-icons icon">remove_circle</span>
                                </c:if>
	                                <figure class="avatar avatar-50 m-1 rounded-circle">
										<div class="background" style="background-image: url(&quot;img/user1.png&quot;);">
											<img src="${m.escudo }" alt="" style="display: none;">
										</div>
									</figure>
									<label for="exampleFormControlInput1">${m.jogador }</label>
									<br>
								</c:forEach>
								
							</div>
                            <div class="form-group">
                            	<c:if test="${ preenchidos.size() == 0 && (mataMata.size() == 4 || mataMata.size() == 8 || mataMata.size() == 16) }">
                                	<button onclick="iniciar()" type="button" class="mb-2 btn btn-lg btn-primary">Finalizar</button>
                                </c:if>
                                <c:if test="${mataMata.size() != 4 && mataMata.size() != 8 && mataMata.size() != 16 }">
                                	<p style="color:red">Precisam ter 4 (semi-final),8 (quartas-de-final) ou 16(oitavas-de-final) participantes.</p>
                                </c:if>
                                <c:if test="${preenchidos.size() > 0 }">
                                	<p style="color:red">Torneio já está em andamento</p>
                                </c:if>
                            </div>
							<br>
                        </form>
                    </div>
                </div>
				
            </div>
        </div>
    

 <form action="/iniciarMataMata" id="inicioMataMata" method="post" accept-charset="utf-8">
 </form>



<!-- FOOTER -->
<jsp:include page="includes/barraFooter.jsp" />
<!-- FOOTER -->
<!-- FOOTER -->
<jsp:include page="includes/footer.jsp" />
<!-- FOOTER -->

