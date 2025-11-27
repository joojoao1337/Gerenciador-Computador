/*
 * RA: 2779730
 * Nome: Gabriel Mohamad
*/

public class Teclado extends Periferico implements Calculavel {
    
    // Atributos específicos do Teclado
    private String layout;
    private String tipoSwitch;
    private boolean retroiluminado;
    private boolean semFio;
    
    // Construtor padrão
    public Teclado() {
        super();
        
        layout = "";
        tipoSwitch = "";
        retroiluminado = false;
        semFio = false;
    }
    
    // Getters
    public String getLayout() {
        return layout;
    }
    
    public String getTipoSwitch() {
        return tipoSwitch;
    }
    
    public boolean isRetroiluminado() {
        return retroiluminado;
    }
    
    public boolean isSemFio() {
        return semFio;
    }
    
    // Setters
    public void setLayout(String layout) {
        this.layout = layout;
    }
    
    public void setTipoSwitch(String tipoSwitch) {
        this.tipoSwitch = tipoSwitch;
    }
    
    public void setRetroiluminado(boolean retroiluminado) {
        this.retroiluminado = retroiluminado;
    }
    
    public void setSemFio(boolean semFio) {
        this.semFio = semFio;
    }
    
    //Sobrescrita
    // Implementação do método abstrato da classe pai
    public void exibirDetalhes() {
        System.out.println("\n=== DETALHES DO TECLADO ===");
        exibirInfo();
        System.out.println("Layout: " + layout);
        System.out.println("Tipo de Switch: " + tipoSwitch);
        System.out.println("Retroiluminado: " + (retroiluminado ? "Sim" : "Não"));
        System.out.println("Sem Fio: " + (semFio ? "Sim" : "Não"));
    }
    
    //Sobrescrita
    // Implementação da interface Calculavel
    public void calcularPrecoTotal() {
        double precoComImposto = preco + (preco * TAXA_IMPOSTO);
        System.out.println("Preço do Teclado com impostos: R$ " + precoComImposto);
    }
    
    //Sobrescrita
    public void calcularCompatibilidade() {
        System.out.println("Verificando compatibilidade do Teclado " + layout + " " + tipoSwitch + " via " + getTipoConexao());
    }
}