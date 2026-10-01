/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package teste;

import java.sql.Connection;
import java.util.List;
import model.Categoria;
import model.Conta;
import model.Pessoa;
import service.CategoriaService;
import service.ContaService;
import service.PessoaService;
import util.Conexao;

/**
 *
 * @author julia
 */
public class Main {
    
    public static void main(String[] args) {

        System.out.println("=== TESTES DO MEUCONTROLE ===");

        testarConexao();
        testarCategorias();
        testarPessoas();
        testarContas();
        testarValidacoes();

        System.out.println();
        System.out.println("=== FIM DOS TESTES ===");
    }

    private static void testarConexao() {

        System.out.println();
        System.out.println("1 - Testando conexão...");

        try (Connection conn = Conexao.conectar()) {

            if (conn != null && !conn.isClosed()) {
                System.out.println(
                        "Conexão realizada com sucesso.");
            }

        } catch (Exception e) {
            System.out.println(
                    "Erro na conexão: " + e.getMessage());
        }
    }

    private static void testarCategorias() {

        System.out.println();
        System.out.println("2 - Testando categorias...");

        try {

            CategoriaService service =
                    new CategoriaService();

            List<Categoria> categorias =
                    service.listar();

            System.out.println(
                    "Categorias cadastradas: "
                    + categorias.size());

            for (Categoria categoria : categorias) {

                System.out.println(
                        categoria.getIdCategoria()
                        + " - "
                        + categoria.getNome());
            }

        } catch (Exception e) {

            System.out.println(
                    "Erro no teste de categorias: "
                    + e.getMessage());
        }
    }

    private static void testarPessoas() {

        System.out.println();
        System.out.println("3 - Testando pessoas...");

        try {

            PessoaService service =
                    new PessoaService();

            List<Pessoa> pessoas =
                    service.listar();

            System.out.println(
                    "Pessoas cadastradas: "
                    + pessoas.size());

            for (Pessoa pessoa : pessoas) {

                System.out.println(
                        pessoa.getIdPessoa()
                        + " - "
                        + pessoa.getNome());
            }

        } catch (Exception e) {

            System.out.println(
                    "Erro no teste de pessoas: "
                    + e.getMessage());
        }
    }

    private static void testarContas() {

        System.out.println();
        System.out.println("4 - Testando contas...");

        try {

            ContaService service =
                    new ContaService();

            List<Conta> contas =
                    service.listar();

            System.out.println(
                    "Contas cadastradas: "
                    + contas.size());

            for (Conta conta : contas) {

                System.out.println(
                        conta.getIdConta()
                        + " - "
                        + conta.getNome()
                        + " - R$ "
                        + conta.getValor());
            }

        } catch (Exception e) {

            System.out.println(
                    "Erro no teste de contas: "
                    + e.getMessage());
        }
    }

    private static void testarValidacoes() {

        System.out.println();
        System.out.println(
                "5 - Testando regras de negócio...");

        CategoriaService categoriaService =
                new CategoriaService();

        PessoaService pessoaService =
                new PessoaService();

        ContaService contaService =
                new ContaService();

        try {

            categoriaService.cadastrar("");

            System.out.println(
                    "Falha: categoria vazia foi aceita.");

        } catch (IllegalArgumentException e) {

            System.out.println(
                    "Sucesso: categoria vazia foi rejeitada.");
        }

        try {

            pessoaService.cadastrar("");

            System.out.println(
                    "Falha: pessoa vazia foi aceita.");

        } catch (IllegalArgumentException e) {

            System.out.println(
                    "Sucesso: pessoa vazia foi rejeitada.");
        }

        try {

            Conta conta = new Conta();
            conta.setNome("");
            conta.setValor(0);

            contaService.cadastrar(conta);

            System.out.println(
                    "Falha: conta inválida foi aceita.");

        } catch (IllegalArgumentException e) {

            System.out.println(
                    "Sucesso: conta inválida foi rejeitada.");
        }
    }
    
}