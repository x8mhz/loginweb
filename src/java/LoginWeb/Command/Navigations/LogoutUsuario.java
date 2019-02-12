/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LoginWeb.Command.Navigations;

import LoginWeb.Domain.Interfaces.IUsuarioRepository;
import LoginWeb.Infra.infra.Repositorios.UsuarioRepository;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import LoginWeb.Presentation.Interfaces.ICommand;

/**
 *
 * @author Fabricio Ramos
 */
public class LogoutUsuario implements ICommand {

    private IUsuarioRepository usuarioRepositorio;

    public LogoutUsuario() {
        if (usuarioRepositorio == null) {
            this.usuarioRepositorio = new UsuarioRepository();
        }
    }

    @Override
    public void execute(HttpServletRequest request, HttpServlet response) {
        try {
            request.getSession().setAttribute("usuarioLogado", null);
            request.getRequestDispatcher("/index.jsp").forward(request, (ServletResponse) response);

        } catch (IOException | ServletException e) {
            e.printStackTrace();
        }
    }

}
