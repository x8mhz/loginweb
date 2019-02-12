/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LoginWeb.Presentation.Interfaces;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Fabricio Ramos
 */
public interface ICommand {
    public void execute(HttpServletRequest request, HttpServlet response);
}
