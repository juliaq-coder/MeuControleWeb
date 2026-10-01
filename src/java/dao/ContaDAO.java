/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Conta;
import util.Conexao;


/**
 *
 * @author julia
 */
public class ContaDAO {
    
    public void inserir(Conta conta) {

        String sql =
                "INSERT INTO Conta "
                + "(nome, valor, data_vencimento, status, "
                + "comprovante, pessoa, categoria) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, conta.getNome());
            stmt.setDouble(2, conta.getValor());
            stmt.setString(3, conta.getDataVencimento());
            stmt.setString(4, conta.getStatus());
            stmt.setString(5, conta.getComprovante());
            stmt.setString(6, conta.getPessoa());
            stmt.setString(7, conta.getCategoria());

            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(
                    "Erro ao cadastrar conta.", e);
        }
    }

    public List<Conta> listar() {

        List<Conta> contas = new ArrayList<>();

        String sql =
                "SELECT id_conta, nome, valor, "
                + "DATE_FORMAT(data_vencimento,'%d/%m/%Y') "
                + "AS data_vencimento, status, comprovante, "
                + "pessoa, categoria FROM Conta";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {

                Conta conta = new Conta();

                conta.setIdConta(rs.getInt("id_conta"));
                conta.setNome(rs.getString("nome"));
                conta.setValor(rs.getDouble("valor"));
                conta.setDataVencimento(
                        rs.getString("data_vencimento"));
                conta.setStatus(rs.getString("status"));
                conta.setComprovante(
                        rs.getString("comprovante"));
                conta.setPessoa(rs.getString("pessoa"));
                conta.setCategoria(
                        rs.getString("categoria"));

                contas.add(conta);
            }

        } catch (SQLException e) {
            throw new RuntimeException(
                    "Erro ao listar contas.", e);
        }

        return contas;
    }

    public Conta buscarPorId(int id) {

        String sql =
                "SELECT * FROM Conta WHERE id_conta = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {

                if (rs.next()) {

                    Conta conta = new Conta();

                    conta.setIdConta(rs.getInt("id_conta"));
                    conta.setNome(rs.getString("nome"));
                    conta.setValor(rs.getDouble("valor"));
                    conta.setDataVencimento(
                            rs.getString("data_vencimento"));
                    conta.setStatus(rs.getString("status"));
                    conta.setComprovante(
                            rs.getString("comprovante"));
                    conta.setPessoa(rs.getString("pessoa"));
                    conta.setCategoria(
                            rs.getString("categoria"));

                    return conta;
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(
                    "Erro ao buscar conta.", e);
        }

        return null;
    }

    public void atualizar(Conta conta) {

        String sql =
                "UPDATE Conta SET nome=?, valor=?, "
                + "data_vencimento=?, status=?, pessoa=?, "
                + "categoria=? WHERE id_conta=?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, conta.getNome());
            stmt.setDouble(2, conta.getValor());
            stmt.setString(3, conta.getDataVencimento());
            stmt.setString(4, conta.getStatus());
            stmt.setString(5, conta.getPessoa());
            stmt.setString(6, conta.getCategoria());
            stmt.setInt(7, conta.getIdConta());

            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(
                    "Erro ao atualizar conta.", e);
        }
    }

    public void excluir(int id) {

        String sql =
                "DELETE FROM Conta WHERE id_conta = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(
                    "Erro ao excluir conta.", e);
        }
    }

    public void atualizarComprovante(
            int idConta, String caminho) {

        String sql =
                "UPDATE Conta SET comprovante=? "
                + "WHERE id_conta=?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, caminho);
            stmt.setInt(2, idConta);

            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(
                    "Erro ao atualizar comprovante.", e);
        }
    }

}
