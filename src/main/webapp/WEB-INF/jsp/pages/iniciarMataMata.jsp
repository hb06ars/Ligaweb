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




<div class="container mt-3 mb-4 text-center">
            <h2 class="text-white">TORNEIO</h2>
        </div>
		
		<c:if test="${preenchidos.size() == 0}">
			<div class="main-container">
		          <div class="container ">
		             
		                <div class="row">
		                    <div class="col text-center">
		                        <h5 class="subtitle">Nenhum torneio cadastrado no momento.</h5>
		                    </div>
		            	</div>
		    	</div>
			</div>
		</c:if>
		
		<c:if test="${preenchidos.size() > 0}">
        <div class="main-container">
          <div class="container ">
             <c:if test="${oitavas.size() > 0}">
					<div class="row">
	                    <div class="col text-center">
	                        <h5 class="subtitle">OITAVAS DE FINAL</h5>
	                    </div>
	                </div>
					<div class="row text-center mt-3">
						<c:forEach items="${oitavas }" var="q">
	                    <div class="col-12 col-sm-12 col-md-6 col-lg-6 col-xl-6">
		                        <div class="card border-0 mb-4">
		                            <div class="card-body">
		                               <figure <c:if test="${quartas.size() == 0 && semiFinal.size() == 0 && finais.size() == 0 }"> onclick="modalVencedor('${q.id }','${q.escudo1 }','${q.jogador1 }', '${q.escudo2 }','${q.jogador2 }')" </c:if> class="avatar avatar-50 m-1 rounded-circle">
											<div class="background" style="background-image: url(&quot;img/user1.png&quot;);">
												<img src="${q.escudo1 }" alt="" style="display: none;">
											</div>
										</figure>
										X
										<figure <c:if test="${quartas.size() == 0 && semiFinal.size() == 0 && finais.size() == 0 }"> onclick="modalVencedor('${q.id }','${q.escudo2 }','${q.jogador2 }','${q.escudo1 }','${q.jogador1 }')" </c:if> class="avatar avatar-50 m-1 rounded-circle">
											<div class="background" style="background-image: url(&quot;img/user1.png&quot;);">
												<img src="${q.escudo2 }" alt="" style="display: none;">
											</div>
										</figure>
		                                <h5 class="mt-3 mb-0 font-weight-normal">${q.jogador1 } x ${q.jogador2 }</h5>
		                            </div>
		                        </div>
	                    </div>
						</c:forEach>
	                </div>
				</c:if>
				
				<c:if test="${quartas.size() > 0}">
					<div class="row">
	                    <div class="col text-center">
	                        <h5 class="subtitle">QUARTAS DE FINAL</h5>
	                    </div>
	                </div>
					<div class="row text-center mt-3">
						<c:forEach items="${quartas }" var="q">
	                    <div class="col-12 col-sm-12 col-md-6 col-lg-6 col-xl-6">
		                        <div class="card border-0 mb-4">
		                            <div class="card-body">
		                               <figure <c:if test="${semiFinal.size() == 0 && finais.size() == 0 }"> onclick="modalVencedor('${q.id }','${q.escudo1 }','${q.jogador1 }', '${q.escudo2 }','${q.jogador2 }')" </c:if> class="avatar avatar-50 m-1 rounded-circle">
											<div class="background" style="background-image: url(&quot;img/user1.png&quot;);">
												<img src="${q.escudo1 }" alt="" style="display: none;">
											</div>
										</figure>
										X
										<figure <c:if test="${semiFinal.size() == 0 && finais.size() == 0 }"> onclick="modalVencedor('${q.id }','${q.escudo2 }','${q.jogador2 }','${q.escudo1 }','${q.jogador1 }')" </c:if> class="avatar avatar-50 m-1 rounded-circle">
											<div class="background" style="background-image: url(&quot;img/user1.png&quot;);">
												<img src="${q.escudo2 }" alt="" style="display: none;">
											</div>
										</figure>
		                                <h5 class="mt-3 mb-0 font-weight-normal">${q.jogador1 } x ${q.jogador2 }</h5>
		                            </div>
		                        </div>
	                    </div>
						</c:forEach>
	                </div>
				</c:if>
				
				
				
				<c:if test="${semiFinal.size() > 0}">
					<div class="row">
	                    <div class="col text-center">
	                        <h5 class="subtitle">SEMI FINAL</h5>
	                    </div>
	                </div>
					<div class="row text-center mt-3">
						<c:forEach items="${semiFinal }" var="q">
	                    <div class="col-12 col-sm-12 col-md-6 col-lg-6 col-xl-6">
		                        <div class="card border-0 mb-4">
		                            <div class="card-body">
		                                <figure <c:if test="${finais.size() == 0 }"> onclick="modalVencedor('${q.id }','${q.escudo1 }','${q.jogador1 }', '${q.escudo2 }','${q.jogador2 }')" </c:if> class="avatar avatar-50 m-1 rounded-circle">
											<div class="background" style="background-image: url(&quot;img/user1.png&quot;);">
												<img src="${q.escudo1 }" alt="" style="display: none;">
											</div>
										</figure>
										X
										<figure <c:if test="${finais.size() == 0 }"> onclick="modalVencedor('${q.id }','${q.escudo2 }','${q.jogador2 }','${q.escudo1 }','${q.jogador1 }')" </c:if> class="avatar avatar-50 m-1 rounded-circle">
											<div class="background" style="background-image: url(&quot;img/user1.png&quot;);">
												<img src="${q.escudo2 }" alt="" style="display: none;">
											</div>
										</figure>
		                                <h5 class="mt-3 mb-0 font-weight-normal">${q.jogador1 } x ${q.jogador2 }</h5>
		                            </div>
		                        </div>
	                    </div>
						</c:forEach>
	                </div>
				</c:if>
				
				
				<c:if test="${finais.size() > 0}">
					<div class="row">
	                    <div class="col text-center">
	                        <h5 class="subtitle">FINAL</h5>
	                    </div>
	                </div>
					<div class="row text-center mt-3">
						<c:forEach items="${finais }" var="q">
	                    <div class="col-12 col-sm-12 col-md-12 col-lg-12 col-xl-12">
		                        <div class="card border-0 mb-4">
		                            <div class="card-body">
		                                <figure onclick="modalVencedor('${q.id }','${q.escudo1 }','${q.jogador1 }', '${q.escudo2 }','${q.jogador2 }')" class="avatar avatar-50 m-1 rounded-circle">
											<div class="background" style="background-image: url(&quot;img/user1.png&quot;);">
												<img src="${q.escudo1 }" alt="" style="display: none;">
											</div>
										</figure>
										X
										<figure onclick="modalVencedor('${q.id }','${q.escudo2 }','${q.jogador2 }','${q.escudo1 }','${q.jogador1 }')" class="avatar avatar-50 m-1 rounded-circle">
											<div class="background" style="background-image: url(&quot;img/user1.png&quot;);">
												<img src="${q.escudo2 }" alt="" style="display: none;">
											</div>
										</figure>
		                                <h5 class="mt-3 mb-0 font-weight-normal">${q.jogador1 } x ${q.jogador2 }</h5>
		                            </div>
		                        </div>
	                    </div>
						</c:forEach>
	                </div>
				</c:if>
				
				
				<c:if test="${campeao != null}">
					<div class="row">
	                    <div class="col text-center">
	                        <h5 class="subtitle">CAMPEÃO</h5>
	                    </div>
	                </div>
					<div class="row text-center mt-3">
	                    <div class="col-12 col-sm-12 col-md-12 col-lg-12 col-xl-12">
		                        <div class="card border-0 mb-4">
		                            <div class="card-body">
		                                <figure class="avatar avatar-50 m-1 rounded-circle">
											<div class="background" style="background-image: url(&quot;img/user1.png&quot;);">
												<img src="${campeao.escudo }" alt="" style="display: none;">
											</div>
										</figure>
		                                <h5 class="mt-3 mb-0 font-weight-normal">${campeao.jogador }</h5>
		                            </div>
		                            <button type="button" class="btn btn-primary" id="ok" onclick="modalNovoTorneio()" data-dismiss="modal">NOVO TORNEIO</button>
		                        </div>
	                    </div>
	                </div>
				</c:if>
				
				
				<c:if test="${vencedores.size() > 0}">
					<div class="row">
	                    <div class="col text-center">
	                        <h5 class="subtitle">Classificados</h5>
	                    </div>
	                </div>
	                <div class="col-12 col-sm-12 col-md-12 col-lg-12 col-xl-12">
	                	 <div class="card border-0 mb-4">
			             	<div class="card-body">
								<c:forEach items="${vencedores }" var="q">
				                    <figure class="avatar avatar-50 m-1 rounded-circle">
										<div class="background" style="background-image: url(&quot;img/user1.png&quot;);">
											<img src="${q.escudo }" alt="" style="display: none;">
										</div>
									</figure>
					                ${q.jogador }
									<br>
								</c:forEach>
							</div>
						</div>
					</div>
				</c:if>
				
				
				
            </div>
            
        </div>
		</c:if>



<br>
<!-- FOOTER -->
<jsp:include page="includes/barraFooter.jsp" />
<!-- FOOTER -->
<!-- FOOTER -->
<jsp:include page="includes/footer.jsp" />
<!-- FOOTER -->

