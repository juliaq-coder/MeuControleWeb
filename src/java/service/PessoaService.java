/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import dao.PessoaDAO;
import java.util.List;
import model.Pessoa;


/**
 *
 * @author julia
 */
public class PessoaService {
    
    private final PessoaDAO pessoaDAO;

    public PessoaService() {
        this.pessoaDAO = new PessoaDAO();
    }

    public void cadastrar(String nome) {

        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "O nome da pessoa é obrigatório.");
        }

        Pessoa pessoa =
                new Pessoa(nome.trim());

        pessoaDAO.inserir(pessoa);
    }

    public List<Pessoa> listar() {
        return pessoaDAO.listar();
    }
}
