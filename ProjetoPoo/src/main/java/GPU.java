/*
 * RA: 2779730
 * Nome: Gabriel Mohamad
*/

public class GPU extends ComponenteInterno implements Calculavel {
    
    // Atributos específicos da GPU
    private int memoriaVRAM; //GB
    private String arquitetura;
    private int clockBase; //MHZ
    
    // Construtor padrão
    public GPU() {
        super();
        
        memoriaVRAM = 0;
        arquitetura = "";
        clockBase = 0;
    }
    
    // Getters
    public int getMemoriaVRAM() {
        return memoriaVRAM;
    }
    
    public String getArquitetura() {
        return arquitetura;
    }
    
    public int getClockBase() {
        return clockBase;
    }
    
    // Setters
    public void setMemoriaVRAM(int memoriaVRAM) {
        this.memoriaVRAM = memoriaVRAM;
    }
    
    public void setArquitetura(String arquitetura) {
        this.arquitetura = arquitetura;
    }
    
    public void setClockBase(int clockBase) {
        this.clockBase = clockBase;
    }
    
    //Sobrescrita
    // Implementação do método abstrato da classe pai
    public void exibirDetalhes() {
        System.out.println("\n=== DETALHES DA GPU ===");
        exibirInfo();
        System.out.println("Memória VRAM: " + memoriaVRAM + "GB");
        System.out.println("Arquitetura: " + arquitetura);
        System.out.println("Clock Base: " + clockBase + "MHz");
    }
    
    //Sobrescrita
    // Implementação da interface Calculavel
    public void calcularPrecoTotal() {
        double precoComImposto = preco + (preco * TAXA_IMPOSTO);
        System.out.println("Preço da GPU com impostos: R$ " + precoComImposto);
    }
    
    //Sobrescrita
    public void calcularCompatibilidade() {
        System.out.println("Verificando compatibilidade da GPU " + arquitetura + " com " + memoriaVRAM + "GB VRAM");
    }
}