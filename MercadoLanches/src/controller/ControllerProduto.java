package controller;

import model.Produto;

import java.util.ArrayList;
import java.util.Scanner;

public class ControllerProduto implements InterfaceProduto {

    Scanner leia = new Scanner(System.in);

    private String nome;
    private float preco;

    private int id;//----=+

    protected ArrayList<Produto> produtoArrayList = new ArrayList<>();

    @Override
    public void salvarProduto() {
        leia.skip("\\R?");
        System.out.println("Nome do produto: ");
        this.nome = leia.nextLine();
        System.out.println("Valor: R$ ");
        this.preco = leia.nextFloat();
        this.id = gerarNumero();

        Produto produto = new Produto(this.nome, this.preco, this.id) {
        };
        produtoArrayList.add(produto);
    }

    @Override
    public void atualizarProduto(Produto produto) {
        var buscarProduto = buscarNumeroProduto(produto.getId());

        if (buscarProduto != null) {
            produtoArrayList.set(produtoArrayList.indexOf(buscarProduto), produto);
            System.out.println("Produto atualizado com sucesso!");
        } else
            System.out.println("Produto não encontrado!");

    }

    @Override
    public void listarProdutos() {

        for (Produto produto : produtoArrayList) {
            System.out.println(produto);
        }
    }

    @Override
    public Produto buscarNumeroProduto(int id) {
        for (Produto produto : produtoArrayList) {
            if (produto.getId() == id) {
                return produto;
            }
        }
        return null;
    }

    @Override
    public void excluirProduto(int id) {
        var produto = buscarNumeroProduto(id);
        if (produto != null) {
            if (produtoArrayList.remove(produto) == true) {
                System.out.println("\nO Produto foi removido!");
            } else
                System.out.println("O item não foi encotrado!");
        }
    }

    @Override
    public int gerarNumero() {
        return produtoArrayList.size() + 1;
    }

    public int retornaId(int id) {
        for (Produto produto : produtoArrayList) {
            if (produto.getId() == id) {
                return produto.getId();
            }
        }
        return 0;
    }
}
