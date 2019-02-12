/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LoginWeb.Domain.Interfaces;

import LoginWeb.Domain.Entities.Usuario;

/**
 *
 * @author Fabricio Ramos
 */
public interface IUsuarioRepository extends IRepository<Usuario> {

    Usuario Login(Usuario obj);
}
