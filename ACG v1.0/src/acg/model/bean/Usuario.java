/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acg.model.bean;

/**
 *
 * @author lab02aluno
 */
public class Usuario {
    int id;
    String nome, senha, email;
    float salario;

    public Usuario(String nome, String senha) {
        this.nome = nome;
        this.senha = senha;
    }

    public Usuario(int id, String nome, String senha, String email, float salario) {
        this.id = id;
        this.nome = nome;
        this.senha = senha;
        this.email = email;
        this.salario = salario;
    }
    
    public Usuario(String nome, String senha, String email, float salario) {
        this.nome = nome;
        this.senha = senha;
        this.email = email;
        this.salario = salario;
    }

    public Usuario(String nome) {
        this.nome = nome;
    }

    public Usuario(int id) {
        this.id = id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getSenha() {
        return senha;
    }

    public String getEmail() {
        return email;
    }

    public float getSalario() {
        return salario;
    }

    public Usuario() {
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", nome=" + nome + ", senha=" + senha + ", email=" + email + ", salario=" + salario + '}';
    }

   

   }

   

