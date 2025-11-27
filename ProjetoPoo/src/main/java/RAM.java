/*
 * RA: 2779730
 * Nome: Gabriel Mohamad
*/

public class RAM extends ComponenteInterno implements Calculavel {
    
    // Atributos específicos da RAM
    private int capacidade; //GB
    private int velocidade; //MHZ
    private String tipo; //DDR3, DDR4, DDR5
    
    // Construtor padrão
    public RAM() {
        super();
        
        capacidade = 0;
        velocidade = 0;
        tipo = "";
    }
    
    // Getters
    public int getCapacidade() {
        return capacidade;
    }
    
    public int getVelocidade() {
        return velocidade;
    }
    
    public String getTipo() {
        return tipo;
    }
    
    // Setters
    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }
    
    public void setVelocidade(int velocidade) {
        this.velocidade = velocidade;
    }
    
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    //Sobrescrita
    // Implementação do método abstrato da classe pai
    public void exibirDetalhes() {
        System.out.println("\n=== DETALHES DA RAM ===");
        exibirInfo();
        System.out.println("Capacidade: " + capacidade + "GB");
        System.out.println("Velocidade: " + velocidade + "MHz");
        System.out.println("Tipo: " + tipo);
    }
    
    //Sobrescrita
    // Implementação da interface Calculavel
    public void calcularPrecoTotal() {
        double precoComImposto = preco + (preco * TAXA_IMPOSTO);
        System.out.println("Preço da RAM com impostos: R$ " + precoComImposto);
    }
    
    //Sobrescrita
    public void calcularCompatibilidade() {
        System.out.println("Verificando compatibilidade da RAM " + tipo + " de " + capacidade + "GB");
    }
}