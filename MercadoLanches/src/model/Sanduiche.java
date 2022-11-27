package model;

public class Sanduiche extends Produto {

    public Sanduiche(String nome, float preco, int id) {
        super(nome, preco, id);
    }

    public void visualizar() {
        super.visualizar();
        System.out.println("================================");
        System.out.println("Nome: " + getNome());
        System.out.println("Preco: " + getPreco());
    }

}
