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
import model.Categoria;
import util.Conexao;

/**
 *
 * @author julia
 */
public class CategoriaDAO {
    
    public void inserir(Categoria categoria) {

        String sql = "INSERT INTO Categoria (nome) VALUES (?)";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, categoria.getNome());
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(
                    "Erro ao cadastrar categoria.", e);
        }
    }

    public List<Categoria> listar() {

        List<Categoria> categorias = new ArrayList<>();

        String sql = "SELECT * FROM Categoria";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {

                Categoria categoria = new Categoria();

                categoria.setIdCategoria(
                        rs.getInt("id_categoria"));

                categoria.setNome(
                        rs.getString("nome"));

                categorias.add(categoria);
            }

        } catch (SQLException e) {
            throw new RuntimeException(
                    "Erro ao listar categorias.", e);
        }

        return categorias;
    }
}
