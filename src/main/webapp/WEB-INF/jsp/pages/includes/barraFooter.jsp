<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="footer">
        <div class="row no-gutters justify-content-center">
            <div class="col-auto">
                <a href="/home" <c:if test="${itemMenuSelecionado == 'home' || itemMenuSelecionado == 'pages/home'}">class="active" </c:if> >
                    <i class="material-icons">home</i>
                    <p>Home</p>
                </a>
            </div>
            <div class="col-auto">
                <a href="/classificacao" <c:if test="${itemMenuSelecionado == 'pages/classificacao'}">class="active" </c:if> >
                    <i class="material-icons">emoji_events</i>
                    <p>Classificação</p>
                </a>
            </div>
            <div class="col-auto">
                <a href="/adversario" <c:if test="${itemMenuSelecionado == 'pages/adversario'}">class="active" </c:if> >
                    <i class="material-icons">account_circle</i>
                    <p>Adversário</p>
                </a>
            </div>
            <div class="col-auto">
                <a href="/meusJogos" <c:if test="${itemMenuSelecionado == 'pages/meusJogos'}">class="active" </c:if> >
                    <i class="material-icons">sports_soccer</i>
                    <p>Meus Jogos</p>
                </a>
            </div>
           	<div class="col-auto">
                <a href="/resultados" <c:if test="${itemMenuSelecionado == 'pages/resultados'}">class="active" </c:if> >
                    <i class="material-icons">text_snippet</i>
                    <p>Resultados</p>
                </a>
            </div>
            
        </div>
    </div>