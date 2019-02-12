<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome to Spring Web MVC project</title>
    </head>

    <body>
        <div class="main container">
		<jsp:include page="Shared/MenuUsuario.jsp" />

		<div id="com-pos-pioo-div-principal">
			<%
				if (request.getSession().getAttribute("usuarioLogado") == null) {
			%>
			<script>
				executarCommand("/LoginWeb/Controller?command=SalvarUsuario");
			</script>
			<%
				} else {
			%>
			<jsp:include page="Shared/Principal.jsp" />
			<%
				}
			%>
		</div>
	</div>

</html>
