/*
 * RA: 2779730
 * Nome: Gabriel Mohamad
*/

public class PlacaMae extends ComponenteInterno implements Calculavel {
    
    // Atributos específicos da Placa Mãe
    private String socket;
    private String chipset;
    private int slotsRAM;
    private String formato; // ATX, Micro-ATX, Mini-ITX
    
    // Construtor padrão
    public PlacaMae() {
        super();
        
        socket = "";
        chipset = "";
        slotsRAM = 0;
        formato = "";
    }
    
    // Getters
    public String getSocket() {
        return socket;
    }
    
    public String getChipset() {
        return chipset;
    }
    
    public int getSlotsRAM() {
        return slotsRAM;
    }
    
    public String getFormato() {
        return formato;
    }
    
    // Setters
    public void setSocket(String socket) {
        this.socket = socket;
    }
    
    public void setChipset(String chipset) {
        this.chipset = chipset;
    }
    
    public void setSlotsRAM(int slotsRAM) {
        this.slotsRAM = slotsRAM;
    }
    
    public void setFormato(String formato) {
        this.formato = formato;
    }
    
    //Sobrescrita
    // Implementação do método abstrato da classe pai
    public void exibirDetalhes() {
        System.out.println("\n=== DETALHES DA PLACA MÃE ===");
        exibirInfo();
        System.out.println("Socket: " + socket);
        System.out.println("Chipset: " + chipset);
        System.out.println("Slots RAM: " + slotsRAM);
        System.out.println("Formato: " + formato);
    }
    
    //Sobrescrita
    // Implementação da interface Calculavel
    public void calcularPrecoTotal() {
        double precoComImposto = preco + (preco * TAXA_IMPOSTO);
        System.out.println("Preço da Placa Mãe com impostos: R$ " + precoComImposto);
    }
    
    //Sobrescrita
    public void calcularCompatibilidade() {
        System.out.println("Verificando compatibilidade da Placa Mãe socket " + socket + " chipset " + chipset);
    }
}