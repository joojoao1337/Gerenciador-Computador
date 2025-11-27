/*
 * RA: 2779730
 * Nome: Gabriel Mohamad
*/

public abstract class Componente {
    
    // Atributos
    protected String nome;
    protected String fabricante;
    protected double preco;
    
    //Sobrescrita
    public abstract void exibirDetalhes();
    
    // Construtor padrão
    public Componente() {
        
        nome = "";
        fabricante = "";
        preco = 0.0;
    }
    
    // Métodos Getters
    public String getNome() {
        return nome;
    }
    
    public String getFabricante() {
        return fabricante;
    }
    
    public double getPreco() {
        return preco;
    }
    
    // Métodos Setters
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }
    
    public void setPreco(double preco) {
        this.preco = preco;
    }
    
    // Método para exibir informações básicas
    public void exibirInfo() {
        System.out.println("Nome: " + nome);
        System.out.println("Fabricante: " + fabricante);
        System.out.println("Preço: R$ " + preco);
    }
}