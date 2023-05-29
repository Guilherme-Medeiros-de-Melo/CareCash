/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acg.model.bean;

import java.sql.Date;

/**
 *
 * @author Gui
 */
public class Relatorio {
    int idusuario, gasto_inicio, gasto_fim;
    Date data_fechamento;
    float salario, gasto_total;

    public Relatorio(int idusuario, int gasto_inicio, int gasto_fim, Date data_fechamento, float salario, float gasto_total) {
        this.idusuario = idusuario;
        this.gasto_inicio = gasto_inicio;
        this.gasto_fim = gasto_fim;
        this.data_fechamento = data_fechamento;
        this.salario = salario;
        this.gasto_total = gasto_total;
    }

    public Relatorio() {
        
    }

    public int getIdusuario() {
        return idusuario;
    }

    public int getGasto_inicio() {
        return gasto_inicio;
    }

    public int getGasto_fim() {
        return gasto_fim;
    }

    public Date getData_fechamento() {
        return data_fechamento;
    }

    public float getSalario() {
        return salario;
    }

    public float getGasto_total() {
        return gasto_total;
    }

    @Override
    public String toString() {
        return "Relatorio{" + "idusuario=" + idusuario + ", gasto_inicio=" + gasto_inicio + ", gasto_fim=" + gasto_fim + ", data_fechamento=" + data_fechamento + ", salario=" + salario + ", gasto_total=" + gasto_total + '}';
    }
    
    
}
