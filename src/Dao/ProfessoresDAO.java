/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class ProfessoresDAO {
    
     public void adicionar(Professores obj ) throws Exception{
        String  sql = "INSERT INTO professores(nome, sobrenome, email, telefone, cpf, endereço, bairro, senha, confirmasenha)VALUES(?,?,?,?,?,?,?,?,?)";
        Connection conn = null;
        PreparedStatement pstm = null;
        try{
            conn = (Connection) Conexao.getConnection();
            pstm = (PreparedStatement) conn.prepareStatement(sql);
            pstm.setString(1, obj.getNome());
            pstm.setString(2, obj.getSobrenome());
            pstm.setString(3, obj.getEmail());
            pstm.setString(4, obj.getTelefone());
            pstm.setString(5, obj.getCpf());
            pstm.setString(6, obj.getEndereço());
            pstm.setString(7, obj.getBairro());
            pstm.setString(8, obj.getSenha());
            pstm.setString(9, obj.getConfirmasenha());
            
            pstm.execute();
        }catch(SQLException e) {
            JOptionPane.showConfirmDialog(null, "Erro ao salvar dados "+ e.toString());
            //System.out.println("Erro ao salvar dados "+ e.getMessage().toLowerCase());
        }finally {
            try {
                if(pstm!=null) {
                    JOptionPane.showMessageDialog(null, "Registro gravado com sucesso!!!");
                    pstm.close();
                }
                if(conn!=null) {
                    conn.close();
                }
            }catch (Exception e) {
                System.out.println("Erro ao salvar dados "+ e.getMessage().toLowerCase());           
            }
        }
    }

    

    public ArrayList<Professores> PesquisarClientes(String cpf) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM professores WHERE cpf = ?";
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList<Professores> lista = new ArrayList<>();

        try {
            conn = Conexao.getConnection();
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, cpf);
            System.out.println("Executando consulta para o CPF: " + cpf);
            rs = pstm.executeQuery();
            while (rs.next()) {
                Professores objPr = new Professores();
                objPr.setNome(rs.getString("nome"));
                objPr.setSobrenome(rs.getString("sobrenome"));
                objPr.setEmail(rs.getString("email"));
                objPr.setTelefone(rs.getString("telefone"));
                objPr.setCpf(rs.getString("cpf"));
                objPr.setEndereço(rs.getString("endereço"));
                objPr.setBairro(rs.getString("bairro"));
                lista.add(objPr);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: professores não encontrados. " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstm != null) pstm.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar recursos: " + e.getMessage());
            }
        }
        return lista;
    }
     public void AlterarDados(Professores obj) throws Exception {
    String sql = "UPDATE professores SET  nome=?, sobrenome=?, email=?, telefone=?, endereço=?, bairro=? WHERE cpf=?";
    Connection conn = null;
    PreparedStatement pstm = null;
    

    try {
        conn = (Connection) Conexao.getConnection();
        pstm = (PreparedStatement) conn.prepareStatement(sql);
        pstm.setString(1, obj.getNome());
        pstm.setString(2, obj.getSobrenome());
        pstm.setString(3, obj.getEmail());
        pstm.setString(4, obj.getTelefone());
        pstm.setString(5, obj.getEndereço());
        pstm.setString(6, obj.getBairro());
        pstm.setString(7, obj.getCpf()); 
        pstm.executeUpdate();
        JOptionPane.showMessageDialog(null, "Dados atualizados com sucesso!");
    } catch (SQLException e) {
    if (e.getErrorCode() == 1062) {
        JOptionPane.showMessageDialog(null, "Erro ao atualizar dados: registro duplicado");
    } else {
        JOptionPane.showMessageDialog(null, "Erro ao atualizar dados: " + e.getMessage());
    }
}}
  public void excluir(Professores obj) throws Exception{
   
       String  sql = "DELETE FROM professores WHERE cpf = ?";
        Connection conn = null;
        PreparedStatement pstm = null;
        try{
            conn = (Connection) Conexao.getConnection();
            pstm = (PreparedStatement) conn.prepareStatement(sql);
            pstm.setString(1, obj.getCpf());
          
            pstm.execute();
   }catch (SQLException e) {
        JOptionPane.showConfirmDialog(null, "Erro professores não encontrado " + e.toString());
   }
   }   
    
}
