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
public class LoginUsuario implements ICommand {

    private IUsuarioRepository usuarioRepositorio;

    public LoginUsuario() {
        if (usuarioRepositorio == null) {
            this.usuarioRepositorio = new UsuarioRepository();
        }
    }

    @Override
    public void execute(HttpServletRequest request, HttpServlet response) {
        try {

            if (request.getParameter("login") == null && request.getParameter("senha") == null) {
                request.getSession().setAttribute("usuarioLogado", null);
                RequestDispatcher d = request.getRequestDispatcher("/Usuario/LoginUsuario.jsp");
                d.forward(request, (ServletResponse) response);

            } else {

                Usuario usuario = new Usuario(request.getParameter("login").toString(), request.getParameter("senha").toString());

                if (usuario.EValido()) {
                    usuario = this.usuarioRepositorio.Login(usuario);
                    if (usuario != null) {
                        request.getSession().setAttribute("usuarioLogado", usuario);
                        RequestDispatcher d = request.getRequestDispatcher("/index.jsp");
                        d.forward(request, (ServletResponse) response);
                    } else {
                        request.getSession().setAttribute("usuarioLogado", null);
                        RequestDispatcher d = request.getRequestDispatcher("/Usuario/LoginUsuario.jsp");
                        d.forward(request, (ServletResponse) response);
                    }
                } else {
                    request.getSession().setAttribute("usuarioLogado", null);
                    RequestDispatcher d = request.getRequestDispatcher("/Usuario/LoginUsuario.jsp");
                    d.forward(request, (ServletResponse) response);

                }
            }

        } catch (IOException | ServletException e) {
            e.printStackTrace();
        }
    }
}
