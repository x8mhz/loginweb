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
public class RemoveUsuario implements ICommand {

    private IUsuarioRepository usuarioRepositorio;

    public RemoveUsuario() {
        if (usuarioRepositorio == null) {
            this.usuarioRepositorio = new UsuarioRepository();
        }
    }

    @Override
    public void execute(HttpServletRequest request, HttpServlet response) {
        try {
            Usuario usuario = new Usuario("", "");
            usuario.setIdUsuario(request.getParameter("id"));

            this.usuarioRepositorio.Remove(usuario);

            RequestDispatcher d = request.getRequestDispatcher("Controller?command=ListarUsuario");
            d.forward(request, (ServletResponse) response);

        } catch (IOException | ServletException | SQLException e) {
            e.printStackTrace();
        }
    }

}
