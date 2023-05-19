/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acg.controller;

/**
 *
 * @author lab02aluno
 */
import acg.model.bean.Usuario;
import acg.model.dao.UsuarioDao;
import java.sql.SQLException;
import java.util.List;

public class ControllerUsuario {
     UsuarioDao daoUsu = null;
    
    public Usuario excluir(Usuario usu)throws SQLException, ClassNotFoundException  {
        daoUsu = new UsuarioDao();
        return daoUsu.excluir(usu);
    }

    public Usuario alterar(Usuario usu) throws SQLException, ClassNotFoundException {
        daoUsu = new UsuarioDao();
        return daoUsu.alterar(usu);
    }

    public List<Usuario> listar(Usuario usu) throws SQLException, ClassNotFoundException {
        daoUsu = new UsuarioDao();
        return daoUsu.listar(usu);
    }

    public Usuario buscar(Usuario usu) throws SQLException, ClassNotFoundException {
        daoUsu = new UsuarioDao();
        return daoUsu.buscar(usu);
    }
    
    public Usuario buscarUsu(Usuario usu) throws SQLException, ClassNotFoundException {
        daoUsu = new UsuarioDao();
        return daoUsu.buscarUsu(usu);
    }

    public Usuario inserir(Usuario usu) throws SQLException, ClassNotFoundException {
        daoUsu = new UsuarioDao();
        return daoUsu.inserir(usu);
    }

    public int validar(Usuario usuEntrada) throws SQLException, ClassNotFoundException {
        int validado = 0;
        daoUsu = new UsuarioDao();
        Usuario usuSaida = daoUsu.validar(usuEntrada);
        if(usuEntrada.getNome().equals(usuSaida.getNome())) {
           if(usuEntrada.getSenha().equals(usuSaida.getSenha())) {
                validado = usuSaida.getId();
           }
        }
        return validado;
    }
   
}
