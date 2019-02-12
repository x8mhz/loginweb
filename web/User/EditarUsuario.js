function onVoltarUsuario(){
	executarCommand("/LoginWeb/Controller?command=ListarUsuario");
}

function onVoltarLogin(){
	executarCommand("/LoginWeb/Controller?command=LoginUsuario");
}

function onSalvarUsuario(){
	var valores = $('#UsuarioFormulario').serialize();
	var command = "/LoginWeb/Controller?command=SalvarUsuario&" + valores;
	executarCommand(command);
}


