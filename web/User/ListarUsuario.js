function onEditarUsuario(id)
{
	if(id)
	{
		executarCommand("/LoginWeb/Controller?command=EditarUsuario&id=" + id);
	}
	else
	{
		executarCommand("/LoginWeb/Controller?command=EditarUsuario");
	}
}



function onExluirUsuario(id){
	if(confirm("Deseja deletar o usuario?"))
	{
		executarCommand("/LoginWeb/Controller?command=DeletarUsuario&id=" + id);
	}
}
