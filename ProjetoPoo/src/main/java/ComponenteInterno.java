/*
 * RA: 2779730
 * Nome: Gabriel Mohamad
*/

public abstract class ComponenteInterno extends Componente implements Gerenciavel {
    
    // Atributo específico de componentes internos
    protected double consumoEnergia;
    
    // Construtor padrão
    public ComponenteInterno() {
        super();
        
        consumoEnergia = 0.0;
    }
    
    // Getter e Setter para consumo de energia
    public double getConsumoEnergia() {
        return consumoEnergia;
    }
    
    public void setConsumoEnergia(double consumoEnergia) {
        this.consumoEnergia = consumoEnergia;
    }
    
    //Sobrescrita
    // Implementação da interface Gerenciavel
    public void adicionarAoInventario() {
        System.out.println("Componente interno " + nome + " adicionado ao inventário");
    }
    
    //Sobrescrita
    public void removerDoInventario() {
        System.out.println("Componente interno " + nome + " removido do inventário");
    }
    
    //Sobrescrita
    // Sobrescrita do método exibirInfo da classe pai
    public void exibirInfo() {
        super.exibirInfo();
        System.out.println("Consumo de Energia: " + consumoEnergia + "W");
    }
}