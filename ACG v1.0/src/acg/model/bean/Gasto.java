/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acg.model.bean;

import java.sql.Date;

/**
 *
 * @author lab02aluno
 */
public class Gasto {
    int id, idusu;
    String nome, tipo;
    float valor;
    Date data;

    public Gasto(int id, int idusu, String nome, String tipo, float valor, Date data) {
        this.id = id;
        this.idusu = idusu;
        this.nome = nome;
        this.tipo = tipo;
        this.valor = valor;
        this.data = data;
    }

    public Gasto(int idusu, String nome, String tipo, float valor, Date data) {
        this.idusu = idusu;
        this.nome = nome;
        this.tipo = tipo;
        this.valor = valor;
        this.data = data;
    }

    public Gasto(int id, String nome, String tipo, float valor) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.valor = valor;
    }

    public Gasto() {
        
    }

    public Gasto(int idusu, String nome) {
        this.idusu = idusu;
        this.nome = nome;
    }

    public Gasto(String tipo, int idusu) {
        this.idusu = idusu;
        this.tipo = tipo;
    }

    public Gasto(int idusu, Date data) {
        this.idusu = idusu;
        this.data = data;
    }

    public Gasto(int id) {
        this.id = id;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdusu() {
        return idusu;
    }

    public void setIdusu(int idusu) {
        this.idusu = idusu;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Gasto{" + "id=" + id + ", idusu=" + idusu + ", nome=" + nome + ", tipo=" + tipo + ", valor=" + valor + ", data=" + data + '}';
    }
    
    
}
