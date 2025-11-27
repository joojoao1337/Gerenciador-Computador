/*
 * RA: 2779730
 * Nome: Gabriel Mohamad
*/

public class CPU extends ComponenteInterno implements Calculavel {
    
    // Atributos específicos da CPU
    private int nucleos;
    private double clock; //ghz
    private String socket;
    
    // Construtor padrão
    public CPU() {
        super();
        
        nucleos = 0;
        clock = 0.0;
        socket = "";
    }
    
    // Getters
    public int getNucleos() {
        return nucleos;
    }
    
    public double getClock() {
        return clock;
    }
    
    public String getSocket() {
        return socket;
    }
    
    // Setters
    public void setNucleos(int nucleos) {
        this.nucleos = nucleos;
    }
    
    public void setClock(double clock) {
        this.clock = clock;
    }
    
    public void setSocket(String socket) {
        this.socket = socket;
    }
    
    //Sobrescrita
    // Implementação do método abstrato da classe pai
    public void exibirDetalhes() {
        System.out.println("\n=== DETALHES DA CPU ===");
        exibirInfo();
        System.out.println("Núcleos: " + nucleos);
        System.out.println("Clock: " + clock + "GHz");
        System.out.println("Socket: " + socket);
    }
    
    //Sobrescrita
    // Implementação da interface Calculavel
    public void calcularPrecoTotal() {
        double precoComImposto = preco + (preco * TAXA_IMPOSTO);
        System.out.println("Preço da CPU com impostos: R$ " + precoComImposto);
    }
    
    //Sobrescrita
    public void calcularCompatibilidade() {
        System.out.println("Verificando compatibilidade da CPU socket " + socket + " com " + nucleos + " núcleos");
    }
}