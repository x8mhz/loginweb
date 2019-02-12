<div class="panel panel-default">
	<div class="panel-heading">Login</div>
	<form id="LoginFormulario">
		<div class="form-group">
			<label class="control-label required">Login <abbr
				title="required">*</abbr>
			</label> <input type="text" class="form-control" name="login" required />
		</div>

		<div class="form-group">
			<label class="control-label required">Senha <abbr
				title="required">*</abbr>
			</label> <input type="password" class="form-control" name="senha" required />
		</div>
		<button class="btn btn-primary" type="button"
			onclick="onLoginUsuario()">Login</button>
			<button class="btn btn-primary" type="button"
			onclick="registerUsuario()">Cadastrar Usuário</button>
	</form>
</div>

<script type="text/javascript">
	<jsp:include page="/User/LoginUsuario.js" />
</script>