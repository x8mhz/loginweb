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
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import LoginWeb.Presentation.Interfaces.ICommand;

/**
 *
 * @author Fabricio Ramos
 */
public class ListarUsuario implements ICommand {

    private IUsuarioRepository usuarioRepositorio;

    public ListarUsuario() {
        if (usuarioRepositorio == null) {
            this.usuarioRepositorio = new UsuarioRepository();
        }
    }

    @Override
    public void execute(HttpServletRequest request, HttpServlet response) {

        try {

            List<Usuario> usuarios = this.usuarioRepositorio.GetALL("");

            request.setAttribute("usuarios", usuarios);

            RequestDispatcher d = request.getRequestDispatcher("/Usuario/ListarUsuario.jsp");
            d.forward(request, (ServletResponse) response);

        } catch (IOException | ServletException | SQLException e) {
			e.printStackTrace();
		}
    }

}
