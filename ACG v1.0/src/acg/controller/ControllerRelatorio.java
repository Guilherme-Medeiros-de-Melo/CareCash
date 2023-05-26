/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acg.controller;

/**
 *
 * @author Gui
 */
import acg.model.bean.Gasto;
import acg.model.bean.Usuario;
import acg.model.dao.RelatorioDao;
import java.sql.SQLException;
import java.sql.Date;
import java.util.List;

public class ControllerRelatorio {

     RelatorioDao daoRel = null;
    
    public void novoRel(Usuario usu)throws SQLException, ClassNotFoundException  {
        daoRel = new RelatorioDao();
        daoRel.novoRel(usu);
    }

    public boolean isDiaDepoisFechamento(Date data, Usuario usu) throws SQLException, ClassNotFoundException {
        daoRel = new RelatorioDao();
        return daoRel.isDiaDepoisFechamento(data, usu);
    }
    
    public List<Gasto> buscarGastoRelatorio(Gasto gas) throws SQLException, ClassNotFoundException {
        daoRel = new RelatorioDao();
        return daoRel.buscarGastoRelatorio(gas);
    }
}
