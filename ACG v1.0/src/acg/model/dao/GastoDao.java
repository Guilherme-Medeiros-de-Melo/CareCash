/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acg.model.dao;

/**
 *
 * @author lab02aluno
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

public class GastoDao {
    private final Connection c;
    
    public GastoDao() throws SQLException, ClassNotFoundException{
        this.c = new Conexão ().getConnection();
    }
    /*
    public Gasto buscar(Gasto gas) throws SQLException{
        String sql = "select * from gasto WHERE id = ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
            // seta os valores
            stmt.setInt(1,gas.getId());
            // executa
            ResultSet rs = stmt.executeQuery();
            Gasto retorno = null;
            while (rs.next()) {      
            // criando o objeto Usuario
                retorno = new Gasto(
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
    
    public List<Gasto> buscarNome(Gasto gas) throws SQLException{
        
        List<Gasto> gass = new ArrayList<>();
        
        String sql = "select * from gasto WHERE idusuario = ? AND Nome = ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
            // seta os valores
            stmt.setInt(1,gas.getIdusu());
            stmt.setString(2,gas.getNome());
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
            // adiciona o usu à lista de usus
            gass.add(gast);
        }
            stmt.close();
        return gass;
   }
    
    public List<Gasto> buscarTipo(Gasto gas) throws SQLException{
        
        List<Gasto> gass = new ArrayList<>();
        
        String sql = "select * from gasto WHERE idusuario = ? AND Tipo = ?";
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
            // adiciona o usu à lista de usus
            gass.add(gast);
        }
            stmt.close();
        return gass;
   }
    
    public List<Gasto> buscarData(Gasto gas) throws SQLException{
        
        List<Gasto> gass = new ArrayList<>();
        
        String sql = "select * from gasto WHERE idusuario = ? AND Data = ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
            // seta os valores
            stmt.setInt(1,gas.getIdusu());
            stmt.setDate(2,gas.getData());
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
            // adiciona o usu à lista de usus
            gass.add(gast);
        }
            stmt.close();
        return gass;
   }
    
    public Gasto alterar(Gasto gas) throws SQLException{
        String sql = "UPDATE gasto SET Nome = ?, Tipo = ?, Valor = ? WHERE id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setString(1,gas.getNome());
        stmt.setString(2,gas.getTipo());
        stmt.setFloat(3,gas.getValor());
        stmt.setInt(4,gas.getId());

        System.out.println(gas.toString());
        // executa
        stmt.execute();
        stmt.close();
        return gas;
    }

    public Gasto excluir(Gasto gas) throws SQLException{
        String sql = "delete from gasto WHERE id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setInt(1,gas.getId());
        // executa
        stmt.execute();
        stmt.close();
        c.close();
        return gas;
    }

    public List<Gasto> listar(Usuario usu) throws SQLException{
        // usus: array armazena a lista de registros

        List<Gasto> gass = new ArrayList<>();
        
        String sql = "select * from gasto where idusuario like ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        // seta os valores
        stmt.setString(1,"%" + usu.getId() + "%");
        
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {      
            // criando o objeto Usuario
            Gasto gas = new Gasto(
                rs.getInt(1),
                rs.getInt(6),
                rs.getString(2),
                rs.getString(3),
                rs.getFloat(4),
                rs.getDate(5)
            );
            // adiciona o usu à lista de usus
            gass.add(gas);
        }
        
        rs.close();
        stmt.close();
        return gass;
    }

    //public Gasto validar(Gasto gas) throws SQLException {
    //    // cria o select para ser executado no banco de dados 
    //    String sql = "select * from gasto WHERE Nome = ? AND tipo = ?";
    //    // prepared statement para seleção
    //    PreparedStatement stmt = this.c.prepareStatement(sql);
    //    // seta os valores
    //    stmt.setString(1,gas.getNome());
    //    stmt.setString(2,gas.getTipo());
    //    // executa
    //    ResultSet rs = stmt.executeQuery();
    //    // percorrendo o rs
    //    Gasto retorno = null;
    //    while (rs.next()) {      
    //        // criando o objeto Usuario
    //        retorno = new Gasto(
    //                rs.getInt(1),
    //                rs.getString(2),
    //                rs.getString(3),
    //                rs.getString(4),
    //                rs.getFloat(5)
    //        );
    //        // adiciona o usu à lista de usus
    //    }
    //    stmt.close();
    //    System.out.println("Gasto: " + retorno.toString());
    //
    //    return retorno; 
    //}
    
    public Gasto inserir(Gasto gas) throws SQLException{
        String sql = "insert into gasto" + " (IdUsuario, Nome, Tipo, Valor, Data)" + " values (?,?,?,?,?)";
    
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);

        // seta os valores
        stmt.setInt(1, gas.getIdusu());
        stmt.setString(2,gas.getNome());
        stmt.setString(3,gas.getTipo());
        stmt.setFloat(4,gas.getValor());
        stmt.setDate(5, (Date) gas.getData());

        // executa
        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            int id = rs.getInt(1);
            gas.setId(id);
        }
        stmt.close();
        return gas;
    }

 
}
