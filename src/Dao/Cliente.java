/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;


public class Cliente {
    private String nome;
    private String sobrenome;
    private String email;
    private String telefone;
    private String cpf;
    private String endereço;
    private String bairro;
    private String senha;
    private String confirmasenha;

    public Cliente() {
    }

    public Cliente(String nome, String sobrenome, String email, String telefone, String cpf, String endereço, String bairro, String senha, String confirmasenha) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.telefone = telefone;
        this.cpf = cpf;
        this.endereço = endereço; 
        this.bairro = bairro;
        this.senha = senha;
        this.confirmasenha = confirmasenha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereço() {
        return endereço;
    }

    public void setEndereço(String endereço) {
        this.endereço = endereço;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getConfirmasenha() {
        return confirmasenha;
    }

    public void setConfirmasenha(String confirmasenha) {
        this.confirmasenha = confirmasenha;
    }
    
    public String toString() {
        return "nome" + nome + ", sobrenome = " + sobrenome +  ", email = " + email + ", telefone =" + telefone + ", cpf" + cpf + ", endereço" + endereço + ", bairro" + bairro + ", senha" + senha + ", confirmasenha" + confirmasenha;
    }
}
