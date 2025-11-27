/*
 * RA: 2779730
 * Nome: Gabriel Mohamad
*/

public class ComponenteInvalidoException extends Exception {
    
    //mensagem personalizada
    public ComponenteInvalidoException(String message) {
        super(message);
    }
    
    //mensagem padrão
    public ComponenteInvalidoException() {
        super("Componente inválido selecionado!");
    }
}