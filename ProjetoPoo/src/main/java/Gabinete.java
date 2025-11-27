/*
 * RA: 2779730
 * Nome: Gabriel Mohamad
*/

public class Gabinete extends Periferico implements Calculavel {
    
    // Atributos específicos do Gabinete
    private String formato;
    private String material;
    private boolean janelaLateral;
    private int ventoinhasInclusas;
    
    // Construtor padrão
    public Gabinete() {
        super();
        
        formato = "";
        material = "";
        janelaLateral = false;
        ventoinhasInclusas = 0;
    }
    
    // Getters
    public String getFormato() {
        return formato;
    }
    
    public String getMaterial() {
        return material;
    }
    
    public boolean isJanelaLateral() {
        return janelaLateral;
    }
    
    public int getVentoinhasInclusas() {
        return ventoinhasInclusas;
    }
    
    // Setters
    public void setFormato(String formato) {
        this.formato = formato;
    }
    
    public void setMaterial(String material) {
        this.material = material;
    }
    
    public void setJanelaLateral(boolean janelaLateral) {
        this.janelaLateral = janelaLateral;
    }
    
    public void setVentoinhasInclusas(int ventoinhasInclusas) {
        this.ventoinhasInclusas = ventoinhasInclusas;
    }
    
    //Sobrescrita
    // Implementação do método abstrato da classe pai
    public void exibirDetalhes() {
        System.out.println("\n=== DETALHES DO GABINETE ===");
        exibirInfo();
        System.out.println("Formato: " + formato);
        System.out.println("Material: " + material);
        System.out.println("Janela Lateral: " + (janelaLateral ? "Sim" : "Não"));
        System.out.println("Ventoinhas Inclusas: " + ventoinhasInclusas);
    }
    
    //Sobrescrita
    // Implementação da interface Calculavel
    public void calcularPrecoTotal() {
        double precoComImposto = preco + (preco * TAXA_IMPOSTO);
        System.out.println("Preço do Gabinete com impostos: R$ " + precoComImposto);
    }
    
    //Sobrescrita
    public void calcularCompatibilidade() {
        System.out.println("Verificando compatibilidade do Gabinete " + formato + " de " + material);
    }
}