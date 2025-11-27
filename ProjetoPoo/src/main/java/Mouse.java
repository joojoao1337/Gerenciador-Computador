/*
 * RA: 2779730
 * Nome: Gabriel Mohamad
*/

public class Mouse extends Periferico implements Calculavel {
    
    // Atributos específicos do Mouse
    private int dpi;
    private String tipoSensor;
    private int numeroBotoes;
    private boolean semFio;
    
    // Construtor padrão
    public Mouse() {
        super();
        
        dpi = 0;
        tipoSensor = "";
        numeroBotoes = 0;
        semFio = false;
    }
    
    // Getters
    public int getDpi() {
        return dpi;
    }
    
    public String getTipoSensor() {
        return tipoSensor;
    }
    
    public int getNumeroBotoes() {
        return numeroBotoes;
    }
    
    public boolean isSemFio() {
        return semFio;
    }
    
    // Setters
    public void setDpi(int dpi) {
        this.dpi = dpi;
    }
    
    public void setTipoSensor(String tipoSensor) {
        this.tipoSensor = tipoSensor;
    }
    
    public void setNumeroBotoes(int numeroBotoes) {
        this.numeroBotoes = numeroBotoes;
    }
    
    public void setSemFio(boolean semFio) {
        this.semFio = semFio;
    }
    
    //Sobrescrita
    // Implementação do método abstrato da classe pai
    public void exibirDetalhes() {
        System.out.println("\n=== DETALHES DO MOUSE ===");
        exibirInfo();
        System.out.println("DPI: " + dpi);
        System.out.println("Tipo de Sensor: " + tipoSensor);
        System.out.println("Número de Botões: " + numeroBotoes);
        System.out.println("Sem Fio: " + (semFio ? "Sim" : "Não"));
    }
    
    //Sobrescrita
    // Implementação da interface Calculavel
    public void calcularPrecoTotal() {
        double precoComImposto = preco + (preco * TAXA_IMPOSTO);
        System.out.println("Preço do Mouse com impostos: R$ " + precoComImposto);
    }
    
    //Sobrescrita
    public void calcularCompatibilidade() {
        System.out.println("Verificando compatibilidade do Mouse " + tipoSensor + " " + dpi + "DPI via " + getTipoConexao());
    }
}