/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import dao.CategoriaDAO;
import java.util.List;
import model.Categoria;


/**
 *
 * @author julia
 */
public class CategoriaService {
    
    private final CategoriaDAO categoriaDAO;

    public CategoriaService() {
        this.categoriaDAO = new CategoriaDAO();
    }

    public void cadastrar(String nome) {

        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "O nome da categoria é obrigatório.");
        }

        Categoria categoria =
                new Categoria(nome.trim());

        categoriaDAO.inserir(categoria);
    }

    public List<Categoria> listar() {
        return categoriaDAO.listar();
    }
}
