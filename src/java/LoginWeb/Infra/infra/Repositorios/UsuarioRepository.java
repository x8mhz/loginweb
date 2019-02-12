/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LoginWeb.Infra.infra.Repositorios;

import LoginWeb.Domain.Entities.Usuario;
import LoginWeb.Domain.Interfaces.IUsuarioRepository;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Fabricio Ramos
 */
public class UsuarioRepository extends Repository implements IUsuarioRepository {

    @Override
    public List<Usuario> GetALL(String filtro) {
        ArrayList<Usuario> objetos = new ArrayList<Usuario>();

        try {

            String query = "select guid, nome, login from usuario ";

            if (!filtro.isEmpty()) {
                query += filtro;
            }

            con = getConnection();
            ps = con.prepareStatement(query);

            ResultSet resultado = ps.executeQuery();

            while (resultado.next()) {
                Usuario objeto = new Usuario(resultado.getString("nome"), resultado.getString("login"), "");
                objeto.setIdUsuario(resultado.getString("guid"));
                objetos.add(objeto);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao selecionar anunciante");
            System.out.println(e.toString());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        return objetos;
    }

    @Override
    public Usuario GetById(String idUsuario) {
        Usuario objeto = null;

        try {
            String query = "select guid, nome, login from usuario where guid = ?";
            con = getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, idUsuario);
            ResultSet resultado = ps.executeQuery();

            if (resultado.next()) {
                objeto = new Usuario(resultado.getString("nome"), resultado.getString("login"), "");
                objeto.setIdUsuario(resultado.getString("guid"));
            }

        } catch (SQLException e) {
            System.out.println("Erro ao selecionar categoria");
            System.out.println(e.toString());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        return objeto;
    }

    @Override
    public void Add(Usuario obj) {
        try {

            String query = "insert into Usuario(idUsario, nome, login, senha) values (?, ?, ?, ?)";

            con = getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, obj.getIdUsuario());
            ps.setString(2, obj.getNome());
            ps.setString(3, obj.getEmail());
            ps.setString(4, obj.getSenha());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao inserir categoria");
            System.out.println(e.toString());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

    }

    @Override
    public void Update(Usuario obj) {
        try {

            String query = "update usuario set nome = ?, login = ? where guid = ?";

            con = getConnection();
            ps = con.prepareStatement(query);

            ps.setString(1, obj.getNome());
            ps.setString(2, obj.getEmail());
            ps.setString(3, obj.getIdUsuario());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao alterar anunciante");
            System.out.println(e.toString());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void Remove(Usuario obj) {
        try {

            String query = "delete from usuario where guid = ?";

            con = getConnection();
            ps = con.prepareStatement(query);

            ps.setString(1, obj.getIdUsuario());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao excluir categoria");
            System.out.println(e.toString());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public Usuario Login(Usuario obj) {
        try {
            String query = "select guid, nome, login from usuario where login = ? and senha = ?";
            con = getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, obj.getEmail());
            ps.setString(2, obj.getSenha());
            ResultSet resultado = ps.executeQuery();

            if (resultado.next()) {
                obj = new Usuario(resultado.getString("nome"), resultado.getString("login"), "");
                obj.setIdUsuario(resultado.getString("guid"));
            }

        } catch (SQLException e) {
            System.out.println("Erro ao selecionar categoria");
            System.out.println(e.toString());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        return obj;
    }

}
