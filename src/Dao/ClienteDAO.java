/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

//import java.awt.List;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet ;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;



public class ClienteDAO {
    
        public void adicionar(Cliente obj ) throws Exception{
        String  sql = "INSERT INTO clientes(nome, sobrenome, email, telefone, cpf, endereço, bairro, senha, confirmasenha)VALUES(?,?,?,?,?,?,?,?,?)";
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

    public ArrayList<Cliente> PesquisarClientes(String cpf) throws SQLException, ClassNotFoundException {
    String sql = "SELECT * FROM clientes WHERE cpf = ?";
    Connection conn = null;
    PreparedStatement pstm = null;
    ResultSet rs = null;
    conn = (Connection) Conexao.getConnection();
    ArrayList<Cliente> lista = new ArrayList<>();

    try {
        pstm = conn.prepareStatement(sql);
        pstm.setString(1, cpf); 
        rs = pstm.executeQuery();
        while (rs.next()) {
            Cliente objCl = new Cliente();
            objCl.setNome(rs.getString("nome"));
            objCl.setSobrenome(rs.getString("sobrenome"));
            objCl.setEmail(rs.getString("email"));
            objCl.setTelefone(rs.getString("telefone"));
            objCl.setCpf(rs.getString("cpf"));
            objCl.setEndereço(rs.getString("endereço"));
            objCl.setBairro(rs.getString("bairro"));
            lista.add(objCl);
        }
    } catch (SQLException e) {
        JOptionPane.showConfirmDialog(null, "Erro cliente não encontrado " + e.toString());
    }
    return lista;
}

    
   public void AlterarDados(Cliente obj) throws Exception {
    String sql = "UPDATE clientes SET  nome=?, sobrenome=?, email=?, telefone=?, endereço=?, bairro=? WHERE cpf=?";
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
}
   
}

   public void excluir(Cliente obj) throws Exception{
   
       String  sql = "DELETE FROM clientes WHERE cpf = ?";
        Connection conn = null;
        PreparedStatement pstm = null;
        try{
            conn = (Connection) Conexao.getConnection();
            pstm = (PreparedStatement) conn.prepareStatement(sql);
            pstm.setString(1, obj.getCpf());
          
            pstm.execute();
   }catch (SQLException e) {
        JOptionPane.showConfirmDialog(null, "Erro cliente não encontrado " + e.toString());
   }
   }

  

   
}
