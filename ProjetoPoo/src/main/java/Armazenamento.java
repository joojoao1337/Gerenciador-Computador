/*
 * RA: 2779730
 * Nome: Gabriel Mohamad
*/

public class Armazenamento extends ComponenteInterno implements Calculavel {
    
    // Atributos específicos do Armazenamento
    private int capacidade; 
    private String tipo; 
    private String interfaceConexao; 
    private int velocidadeLeitura; 
    
    // Construtor padrão
    public Armazenamento() {
        super();
        
        capacidade = 0;
        tipo = "";
        interfaceConexao = "";
        velocidadeLeitura = 0;
    }
    
    // Getters
    public int getCapacidade() {
        return capacidade;
    }
    
    public String getTipo() {
        return tipo;
    }
    
    public String getInterfaceConexao() {
        return interfaceConexao;
    }
    
    public int getVelocidadeLeitura() {
        return velocidadeLeitura;
    }
    
    // Setters
    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }
    
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public void setInterfaceConexao(String interfaceConexao) {
        this.interfaceConexao = interfaceConexao;
    }
    
    public void setVelocidadeLeitura(int velocidadeLeitura) {
        this.velocidadeLeitura = velocidadeLeitura;
    }
    
    //Sobrescrita
    public void exibirDetalhes() {
        System.out.println("\n=== DETALHES DO ARMAZENAMENTO ===");
        exibirInfo();
        System.out.println("Capacidade: " + capacidade + "GB");
        System.out.println("Tipo: " + tipo);
        System.out.println("Interface: " + interfaceConexao);
        System.out.println("Velocidade de Leitura: " + velocidadeLeitura + "MB/s");
    }
    
    //Sobrescrita
    public void calcularPrecoTotal() {
        double precoComImposto = preco + (preco * TAXA_IMPOSTO);
        System.out.println("Preço do Armazenamento com impostos: R$ " + precoComImposto);
    }
    
    //Sobrescrita
    public void calcularCompatibilidade() {
        System.out.println("Verificando compatibilidade do " + tipo + " " + interfaceConexao + " de " + capacidade + "GB");
    }
}