/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acg.controller;


import acg.model.bean.Gasto;
import acg.model.bean.Usuario;
import acg.model.dao.GastoDao;
import java.sql.SQLException;
import java.util.List;

public class ControllerGasto {
     GastoDao daoGas = null;
    
    public Gasto excluir(Gasto gas)throws SQLException, ClassNotFoundException  {
        daoGas = new GastoDao();
        return daoGas.excluir(gas);
    }

    public Gasto alterar(Gasto gas) throws SQLException, ClassNotFoundException {
        daoGas = new GastoDao();
        return daoGas.alterar(gas);
    }

    public List<Gasto> listar(Usuario usu) throws SQLException, ClassNotFoundException {
        daoGas = new GastoDao();
        return daoGas.listar(usu);
    }
    
    public List<Gasto> buscarNome(Gasto gas) throws SQLException, ClassNotFoundException {
        daoGas = new GastoDao();
        return daoGas.buscarNome(gas);
    }
    
    public List<Gasto> buscarTipo(Gasto gas) throws SQLException, ClassNotFoundException {
        daoGas = new GastoDao();
        return daoGas.buscarTipo(gas);
    }
    
    public List<Gasto> buscarData(Gasto gas) throws SQLException, ClassNotFoundException {
        daoGas = new GastoDao();
        return daoGas.buscarData(gas);
    }
    /*
    public Gasto buscar(Gasto gas) throws SQLException, ClassNotFoundException {
        daoGas = new GastoDao();
        return daoGas.buscar(gas);
    }
    */
    public Gasto inserir(Gasto gas) throws SQLException, ClassNotFoundException {
        daoGas = new GastoDao();
        return daoGas.inserir(gas);
    }

    //public boolean validar(Gasto gasEntrada) throws SQLException, ClassNotFoundException {
    //    boolean validado = false;
    //    daoGas = new GastoDao();
    //    Gasto gasSaida = daoGas.validar(gasEntrada);
    //    if(gasEntrada.getNome().equals(gasSaida.getNome())) {
    //       if(gasEntrada.getTipo().equals(gasSaida.getTipo())) {
    //            validado = true;
    //       }
    //    }
    //    return validado;
    //}
   
}
    
    

 
    
    

