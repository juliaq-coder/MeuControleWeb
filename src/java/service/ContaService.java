/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import dao.ContaDAO;
import java.util.List;
import model.Conta;

/**
 *
 * @author julia
 */
public class ContaService {
    
    private final ContaDAO contaDAO;

    public ContaService() {
        this.contaDAO = new ContaDAO();
    }

    public void cadastrar(Conta conta) {

        validar(conta);

        contaDAO.inserir(conta);
    }

    public void atualizar(Conta conta) {

        if (conta.getIdConta() <= 0) {
            throw new IllegalArgumentException(
                    "Conta inválida para atualização.");
        }

        validar(conta);

        contaDAO.atualizar(conta);
    }

    public void excluir(int id) {

        if (id <= 0) {
            throw new IllegalArgumentException(
                    "ID da conta inválido.");
        }

        contaDAO.excluir(id);
    }

    public Conta buscarPorId(int id) {

        if (id <= 0) {
            throw new IllegalArgumentException(
                    "ID da conta inválido.");
        }

        return contaDAO.buscarPorId(id);
    }

    public List<Conta> listar() {
        return contaDAO.listar();
    }

    public void atualizarComprovante(
            int idConta, String caminho) {

        if (idConta <= 0) {
            throw new IllegalArgumentException(
                    "ID da conta inválido.");
        }

        if (caminho == null || caminho.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "O comprovante é obrigatório.");
        }

        contaDAO.atualizarComprovante(
                idConta, caminho.trim());
    }

    private void validar(Conta conta) {

        if (conta == null) {
            throw new IllegalArgumentException(
                    "A conta não pode ser nula.");
        }

        if (conta.getNome() == null
                || conta.getNome().trim().isEmpty()) {

            throw new IllegalArgumentException(
                    "O nome da conta é obrigatório.");
        }

        if (conta.getValor() <= 0) {
            throw new IllegalArgumentException(
                    "O valor da conta deve ser maior que zero.");
        }

        if (conta.getDataVencimento() == null
                || conta.getDataVencimento().trim().isEmpty()) {

            throw new IllegalArgumentException(
                    "A data de vencimento é obrigatória.");
        }

        if (conta.getStatus() == null
                || conta.getStatus().trim().isEmpty()) {

            throw new IllegalArgumentException(
                    "O status da conta é obrigatório.");
        }

        if (conta.getPessoa() == null
                || conta.getPessoa().trim().isEmpty()) {

            throw new IllegalArgumentException(
                    "A pessoa é obrigatória.");
        }

        if (conta.getCategoria() == null
                || conta.getCategoria().trim().isEmpty()) {

            throw new IllegalArgumentException(
                    "A categoria é obrigatória.");
        }
    }
}
