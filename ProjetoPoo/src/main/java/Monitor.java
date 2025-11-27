/*
 * RA: 2779730
 * Nome: Gabriel Mohamad
*/

public class Monitor extends Periferico implements Calculavel {
    
    // Atributos específicos do Monitor
    private double tamanhoTela; // em polegadas
    private String resolucao;
    private int taxaAtualizacao; // em Hz
    private String tipoPanel; // IPS, TN, VA
    
    // Construtor padrão
    public Monitor() {
        super();
        
        tamanhoTela = 0.0;
        resolucao = "";
        taxaAtualizacao = 0;
        tipoPanel = "";
    }
    
    // Getters
    public double getTamanhoTela() {
        return tamanhoTela;
    }
    
    public String getResolucao() {
        return resolucao;
    }
    
    public int getTaxaAtualizacao() {
        return taxaAtualizacao;
    }
    
    public String getTipoPanel() {
        return tipoPanel;
    }
    
    // Setters
    public void setTamanhoTela(double tamanhoTela) {
        this.tamanhoTela = tamanhoTela;
    }
    
    public void setResolucao(String resolucao) {
        this.resolucao = resolucao;
    }
    
    public void setTaxaAtualizacao(int taxaAtualizacao) {
        this.taxaAtualizacao = taxaAtualizacao;
    }
    
    public void setTipoPanel(String tipoPanel) {
        this.tipoPanel = tipoPanel;
    }
    
    //Sobrescrita
    // Implementação do método abstrato da classe pai
    public void exibirDetalhes() {
        System.out.println("\n=== DETALHES DO MONITOR ===");
        exibirInfo();
        System.out.println("Tamanho da Tela: " + tamanhoTela + "\"");
        System.out.println("Resolução: " + resolucao);
        System.out.println("Taxa de Atualização: " + taxaAtualizacao + "Hz");
        System.out.println("Tipo de Panel: " + tipoPanel);
    }
    
    //Sobrescrita
    // Implementação da interface Calculavel
    public void calcularPrecoTotal() {
        double precoComImposto = preco + (preco * TAXA_IMPOSTO);
        System.out.println("Preço do Monitor com impostos: R$ " + precoComImposto);
    }
    
    //Sobrescrita
    public void calcularCompatibilidade() {
        System.out.println("Verificando compatibilidade do Monitor " + resolucao + " " + taxaAtualizacao + "Hz via " + getTipoConexao());
    }
}