<%-- 
    Document   : Menu
    Created on : 12/02/2019, 11:13:13
    Author     : Fabricio Ramos
--%>

<div>
    <nav class="navbar navbar-default">
        <div class="container-fluid">
            <div class="navbar-header">
                <a class="navbar-brand loginweb-menu-home" href="#">Listar Cadastrados</a>
            </div>
            <ul class="nav navbar-nav">
                <%
                    if (request.getSession().getAttribute("usuarioLogado") != null) {
                %>				
                <li><a class="loginweb-menu-usuarios" href="#">Usuários</a></li>
                <li class="danger"><a class="loginweb-menu-logout" href="#">Sair</a></li>
                    <%
                    } else {
                    %>
                <li><a class="loginweb-menu-login" href="User/LoginUsuario.jsp">Mostrar Cadastrar</a></li>
                    <%
                        }
                    %>
            </ul>
        </div>
    </nav>

    <script type="text/javascript">
        <jsp:include page="/Shared/menuUsuario.js" />
    </script>
</div>