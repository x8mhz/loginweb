/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LoginWeb.Command.Navigations;

import LoginWeb.Domain.Entities.Usuario;
import LoginWeb.Domain.Interfaces.IUsuarioRepository;
import LoginWeb.Infra.infra.Repositorios.UsuarioRepository;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import LoginWeb.Presentation.Interfaces.ICommand;

/**
 *
 * @author Fabricio Ramos
 */
public class SalvarUsuario implements ICommand {

    private IUsuarioRepository categoriaRepositorio;

    public SalvarUsuario() {
        if (categoriaRepositorio == null) {
            this.categoriaRepositorio = new UsuarioRepository();
        }
    }

    @Override
    public void execute(HttpServletRequest request, HttpServlet response) {
		try {
			boolean isNovo = true;
			Usuario usuariologado = (Usuario)request.getSession().getAttribute("usuarioLogado");
			Usuario usuario = new Usuario(request.getParameter("nome"), request.getParameter("login"), request.getParameter("senha"));

			if(!request.getParameter("isnew").equals("true"))
			{
				usuario.setIdUsuario(request.getParameter("id"));
				isNovo = false;
			}

			if(usuario.EValido())
			{
				if(isNovo)
				{
					this.categoriaRepositorio.Add(usuario);
				}
				else
				{
					this.categoriaRepositorio.Add(usuario);
				}
			}

			
			if(usuariologado == null)
			{
				request.getRequestDispatcher("Controller?command=LoginUsuario").forward(request, (ServletResponse) response);
			}
			else
			{
				request.getRequestDispatcher("Controller?command=ListarUsuario").forward(request, (ServletResponse) response);
			}
		

		} catch (IOException | ServletException | SQLException e) {
			e.printStackTrace();
		}
    }

}
