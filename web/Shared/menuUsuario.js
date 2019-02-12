function executarCommand(url){
	$("#loginweb-div-principal").load(url);
}

function executarCommandBody(url, dados)
{
	$.ajax({
		type: "POST",
		url: url,
		data: dados
	}).then(function(resultado){

		$("#loginweb-div-principal").html(resultado);
	});
}

$(document).ready(function(){
	$(".loginweb-menuusuario-homes").on("click",  function(){ 
		$("#loginweb-div-principal").html("uma tela de boas vindas qualquer!");
	});
	
	$(".loginweb-menuusuario-usuarios").on("click",  function(){ 
		executarCommand("/LoginWeb/Controller?command=ListarUsuario");
	});

	$(".loginweb-menuusuario-login").on("click",  function(){ 
		executarCommand("/LoginWeb/Presentation/Controller?command=LoginUsuario");
	});


	$(".loginweb-menuusuario-logout").on("click", function(){
		$("body").load("/LoginWeb/Controller?command=LogoutUsuario");
	});
});
