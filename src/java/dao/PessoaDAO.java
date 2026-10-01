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
import model.Pessoa;
import util.Conexao;


/**
 *
 * @author julia
 */
public class PessoaDAO {
    
    public void inserir(Pessoa pessoa) {

        String sql = "INSERT INTO Pessoa (nome) VALUES (?)";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, pessoa.getNome());
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(
                    "Erro ao cadastrar pessoa.", e);
        }
    }

    public List<Pessoa> listar() {

        List<Pessoa> pessoas = new ArrayList<>();

        String sql = "SELECT * FROM Pessoa";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {

                Pessoa pessoa = new Pessoa();

                pessoa.setIdPessoa(
                        rs.getInt("id_pessoa"));

                pessoa.setNome(
                        rs.getString("nome"));

                pessoas.add(pessoa);
            }

        } catch (SQLException e) {
            throw new RuntimeException(
                    "Erro ao listar pessoas.", e);
        }

        return pessoas;
    }
}
