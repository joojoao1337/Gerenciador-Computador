/*
 * RA: 2779730
 * Nome: Gabriel Mohamad
*/

public class CapacidadeInvalidaException extends Exception {
    
    //mensagem personalizada
    public CapacidadeInvalidaException(String message) {
        super(message);
    }
    
    // Construtor sobrecarregado que recebe a capacidade inválida
    public CapacidadeInvalidaException(int capacidadeInvalida) {
        super("A capacidade informada (" + capacidadeInvalida + "GB) é inválida!");
    }
    
    // Construtor padrão
    public CapacidadeInvalidaException() {
        super("Capacidade informada é inválida!");
    }
}