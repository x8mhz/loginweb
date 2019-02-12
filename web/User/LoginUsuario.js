function onLoginUsuario(){
	var valores = $('#LoginFormulario').serialize();
	var command = "/LoginWeb/Controller?command=LoginUsuario&" + valores;
	$("body").load(command);
}

function registerUsuario(){
	executarCommand("/LoginWeb/Controller?command=EditarUsuario");
}


