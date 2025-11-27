/*
 * RA: 2779730
 * Nome: Gabriel Mohamad
*/

public abstract class Periferico extends Componente implements Gerenciavel {
    
    // Atributo específico de periféricos
    private String tipoConexao;
    
    // Construtor padrão
    public Periferico() {
        super();
        
        tipoConexao = "";
    }
    
    // Getter e Setter para tipo de conexão
    public String getTipoConexao() {
        return tipoConexao;
    }
    
    public void setTipoConexao(String tipoConexao) {
        this.tipoConexao = tipoConexao;
    }
    
    //Sobrescrita
    // Implementação da interface Gerenciavel
    public void adicionarAoInventario() {
        System.out.println("Periférico " + nome + " adicionado ao inventário");
    }
    
    //Sobrescrita
    public void removerDoInventario() {
        System.out.println("Periférico " + nome + " removido do inventário");
    }
    
    //Sobrescrita
    // Sobrescrita do método exibirInfo da classe pai
    public void exibirInfo() {
        super.exibirInfo();
        System.out.println("Tipo de Conexão: " + tipoConexao);
    }
}