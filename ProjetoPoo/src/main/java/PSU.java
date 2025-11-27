/*
 * RA: 2779730
 * Nome: Gabriel Mohamad
*/

public class PSU extends ComponenteInterno implements Calculavel {
    
    // Atributos específicos da PSU (Fonte de Alimentação)
    private int potencia; // em Watts
    private String certificacao; // 80+ Bronze, Gold, etc.
    private boolean modular;
    
    // Construtor padrão
    public PSU() {
        super();
        
        potencia = 0;
        certificacao = "";
        modular = false;
    }
    
    // Getters
    public int getPotencia() {
        return potencia;
    }
    
    public String getCertificacao() {
        return certificacao;
    }
    
    public boolean isModular() {
        return modular;
    }
    
    // Setters
    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }
    
    public void setCertificacao(String certificacao) {
        this.certificacao = certificacao;
    }
    
    public void setModular(boolean modular) {
        this.modular = modular;
    }
    
    //Sobrescrita
    // Implementação do método abstrato da classe pai
    public void exibirDetalhes() {
        System.out.println("\n=== DETALHES DA PSU ===");
        exibirInfo();
        System.out.println("Potência: " + potencia + "W");
        System.out.println("Certificação: " + certificacao);
        System.out.println("Modular: " + (modular ? "Sim" : "Não"));
    }
    
    //Sobrescrita
    // Implementação da interface Calculavel
    public void calcularPrecoTotal() {
        double precoComImposto = preco + (preco * TAXA_IMPOSTO);
        System.out.println("Preço da PSU com impostos: R$ " + precoComImposto);
    }
    
    //Sobrescrita
    public void calcularCompatibilidade() {
        System.out.println("Verificando se PSU de " + potencia + "W é suficiente para o sistema");
    }
}