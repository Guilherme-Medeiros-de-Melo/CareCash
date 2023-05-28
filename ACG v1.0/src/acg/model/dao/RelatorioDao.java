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
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

public class RelatorioDao {
    private final Connection c;
    
    public RelatorioDao() throws SQLException, ClassNotFoundException{
        this.c = new Conexão ().getConnection();
    }
    
    public void novoRel(Usuario usu) throws SQLException{
        String sql = "SELECT MAX(id), DATE_ADD(MAX(data), INTERVAL 6 DAY) FROM gasto";
        
        PreparedStatement stmt = this.c.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        int proximo_id = 0;
        Date data_fechamento = null;
        while (rs.next()) {      
            proximo_id = rs.getInt(1) + 1;
            data_fechamento = rs.getDate(2);
            }
            stmt.close();
        
        sql = "Update relatorio set gasto_fim = ? where data_fechamento = (Select MAX(data_fechamento) from relatorio) and idusuario = ?;";    
            
        stmt = this.c.prepareStatement(sql);
        stmt.setInt(1, proximo_id - 1);
        stmt.setInt(2, usu.getId());
        
        stmt.executeUpdate();
            
        sql = "insert into relatorio(idusuario, gasto_inicio, gasto_fim, data_fechamento, salario, gasto_total)"
                + " values (?,?,?,?,?,?)";
        
        stmt = this.c.prepareStatement(sql);
        
        stmt.setInt(1, usu.getId());
        stmt.setInt(2, proximo_id);
        stmt.setObject(3, null, Types.INTEGER);
        stmt.setDate(4, data_fechamento);
        stmt.setFloat(5, usu.getSalario());
        stmt.setFloat(6, 0);
        
        stmt.executeUpdate();
        
    }
    
    public boolean isDiaDepoisFechamento(Date data, Usuario usu) throws SQLException{
        String sql = "Select data_fechamento from relatorio where data_fechamento = (Select MAX(data_fechamento) from relatorio) and idusuario = ?";
        
        PreparedStatement stmt = this.c.prepareStatement(sql);
        
        stmt.setInt(1, usu.getId());
        ResultSet rs = stmt.executeQuery();
        Date data2 = null;
        while (rs.next()) {      
            data2 = rs.getDate(1);
        }
        
        System.out.println((data2 == data) + "\n" + data + "    " + data2);
        
        try{
        if (data.compareTo(data2) > 0){
            return true;
        }
        else{
            return false;   
        }
        }
        catch (NullPointerException ex){
            primeiroRelatorio(data, usu);
            return false;
        }
    }
    
    public void primeiroRelatorio(Date data, Usuario usu) throws SQLException{
        String sql = "SELECT MAX(id), DATE_ADD(MAX(data), INTERVAL 6 DAY) FROM gasto";
        
        PreparedStatement stmt = this.c.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        int proximo_id = 0;
        Date data_fechamento = null;
        while (rs.next()) {      
            proximo_id = rs.getInt(1);
            data_fechamento = rs.getDate(2);
            }
            stmt.close();
            
        sql = "insert into relatorio(idusuario, gasto_inicio, gasto_fim, data_fechamento, salario, gasto_total)"
                + " values (?,?,?,?,?,?)";
        
        stmt = this.c.prepareStatement(sql);
        
        stmt.setInt(1, usu.getId());
        stmt.setInt(2, proximo_id);
        stmt.setObject(3, null, Types.INTEGER);
        stmt.setDate(4, data_fechamento);
        stmt.setFloat(5, usu.getSalario());
        stmt.setFloat(6, 0);
        
        stmt.executeUpdate();
    }
    
    public List<Gasto> buscarGastoRelatorio(Gasto gas) throws SQLException{
        
        List<Gasto> gass = new ArrayList<>();
        
        String sql = "Select * from gasto where idusuario = ? and id BETWEEN ? and ?;";
        PreparedStatement stmt = this.c.prepareStatement(sql);
            // seta os valores
            stmt.setInt(1,gas.getIdusu());
            stmt.setString(2,gas.getTipo());
            // executa
            ResultSet rs = stmt.executeQuery();
           while (rs.next()) {      
            // criando o objeto Usuario
            Gasto gast = new Gasto(
                rs.getInt(1),
                rs.getInt(6),
                rs.getString(2),
                rs.getString(3),
                rs.getFloat(4),
                rs.getDate(5)
            );
            
            gass.add(gast);
        }
            stmt.close();
        return gass;
   }
    
    public void calcularGastoTotal(Usuario usu) throws SQLException {
        List<Gasto> gass = new ArrayList<>();
        int gasto_inicio = 0;
        String sql = "select gasto_inicio from relatorio where data_fechamento = (Select MAX(data_fechamento) from relatorio) and idusuario = ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        stmt.setInt(1, usu.getId());
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {      
            gasto_inicio = rs.getInt(1);
        }
        
        int gasto_final = 0;
        sql = "select Max(id) from gasto";
        stmt = this.c.prepareStatement(sql);
        rs = stmt.executeQuery();
        while (rs.next()) {      
            gasto_final = rs.getInt(1);
        }
        
        int soma_total = 0;
        sql = "select Sum(valor) from gasto where idusuario = ? and id between ? and ?";
        stmt = this.c.prepareStatement(sql);
            
            stmt.setInt(1, usu.getId());
            stmt.setInt(2, gasto_inicio);
            stmt.setInt(3,gasto_final);
            // executa
            rs = stmt.executeQuery();
            while (rs.next()) {      
            soma_total = rs.getInt(1);
        }
            
        sql = "update relatorio set gasto_total = ? where data_fechamento = (Select MAX(data_fechamento) from relatorio) and idusuario = ?;";
        stmt = this.c.prepareStatement(sql);
            
            stmt.setInt(1, soma_total);
            stmt.setInt(2, usu.getId());
            
            stmt.executeUpdate();
            System.out.println(soma_total + " " + usu.getId());
            stmt.close();
    }
    
    public Gasto alterarGastoRelatorio(Gasto gas) throws SQLException{
        
        List<Gasto> gass = new ArrayList<>();
        
        String sql = "";
        return gas;
    }
    /*
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
*/
}
