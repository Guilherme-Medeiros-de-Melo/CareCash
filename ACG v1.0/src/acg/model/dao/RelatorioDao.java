/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acg.model.dao;

/**
 *
 * @author Gui
 */

import acg.model.bean.Gasto;
import acg.model.bean.Usuario;
import acg.util.Conexão;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RelatorioDao {
    private final Connection c;
    
    public RelatorioDao() throws SQLException, ClassNotFoundException{
        this.c = new Conexão ().getConnection();
    }
    
    public void novoRel(Usuario usu) throws SQLException{
        String sql = "SELECT MAX(id), DATE_ADD(MAX(data), INTERVAL 1 WEEK) FROM gasto";
        
        PreparedStatement stmt = this.c.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        int proximo_id = 0;
        Date data_fechamento;
        while (rs.next()) {      
            proximo_id = rs.getInt(1) + 1;
            data_fechamento = rs.getDate(2);
            }
            stmt.close();
        
        sql = "insert into relatorio" + "(idusuario, gasto_inicio, gasto_fim, data_fechamento, salario, gasto_total)"
                + " values (?,?,?,?,?,?)";
        
        stmt = this.c.prepareStatement(sql);
        
        stmt.setInt(1, usu.getId());
        stmt.setInt(2, proximo_id);
        stmt.setInt(3, Integer.parseInt(null));
        stmt.setInt(4, Integer.parseInt(null));
        stmt.setFloat(5, usu.getSalario());
        stmt.setFloat(6, 0);
        
        stmt.executeQuery();
        
    }
    //"insert into usuario" + " (Nome, Senha, Email, Salario)" + " values (?,?,?,?)";
    public Usuario buscar(Usuario usu) throws SQLException{
        String sql = "select * from usuario WHERE id = ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
            // seta os valores
            stmt.setInt(1,usu.getId());
            // executa
            ResultSet rs = stmt.executeQuery();
            Usuario retorno = null;
            while (rs.next()) {      
            // criando o objeto Usuario
                retorno = new Usuario(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getFloat(5)
                        
                   );
            }
            stmt.close();
        return retorno;
   }
}