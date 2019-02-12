/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LoginWeb.Domain.Entities;

import java.util.ArrayList;
import java.util.UUID;

/**
 *
 * @author Fabricio Ramos
 */
public class Usuario {

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getIdUsuario() {
        return idUsuario.toString();
    }

    public void setIdUsuario(UUID dUsuario) {
        this.novoRegistro = false;
        this.idUsuario = idUsuario;
        
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = UUID.fromString(idUsuario);
        this.novoRegistro = false;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    private UUID idUsuario;
    private String nome;
    private String email;
    private String senha;

    private boolean novoRegistro;
    
    private ArrayList<String> mensagens;

    public Usuario(String email, String senha) {
        this.email = email;
        this.senha = senha;
    }

    public Usuario(String nome, String email, String senha) {
        this.setIdUsuario(UUID.randomUUID());
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        
        this.novoRegistro = true;
    }

    public boolean EValido() {
        return this.mensagens.isEmpty();
    }
    
    public boolean isNovoRegistro()
    {
        return novoRegistro;
    }
}
