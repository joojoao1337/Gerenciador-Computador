/*
 * RA: 2779730
 * Nome: Gabriel Mohamad
*/

public class Principal{
    public static void main(String args[]) {

        // Reflexividade: Exemplo de uso da classe Class para obter informações sobre a classe Principal
        System.out.println("\n=== DEMONSTRAÇÃO DE REFLEXIVIDADE ===");
        try {
            Class<?> classePrincipal = Class.forName("Principal");
            System.out.println("Nome da Classe: " + classePrincipal.getName());
            System.out.println("Superclasse: " + classePrincipal.getSuperclass().getName());
            System.out.println("Interfaces Implementadas:");
            for (Class<?> interfaceClass : classePrincipal.getInterfaces()) {
                System.out.println(" - " + interfaceClass.getName());
            }
            System.out.println("Métodos Declarados:");
            for (java.lang.reflect.Method method : classePrincipal.getDeclaredMethods()) {
                System.out.println(" - " + method.getName());
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Erro ao usar Reflexividade: Classe não encontrada.");
        }
        System.out.println("===================================\n\n");

        Leitura leitura = new Leitura();
        Opcoes opt = new Opcoes();
        Componente[] inventario = new Componente[50];
        int totalComponentes = 0;
        
        String opcao;
        
        do {
            System.out.println("\n=== MENU PRINCIPAL ===");
            System.out.println("1. Adicionar Componente Interno");
            System.out.println("2. Adicionar Periférico");
            System.out.println("3. Listar Todos os Componentes");
            System.out.println("4. Exibir Detalhes de um Componente");
            System.out.println("5. Calcular Preço Total com Impostos");
            System.out.println("6. Verificar Compatibilidade");
            System.out.println("7. Remover Componente Interno");
            System.out.println("0. Sair");
            opcao = leitura.entDados("Digite sua opção:");
            
            switch (opcao) {
                case "1":
                    try {
                        totalComponentes = opt.adicionarComponenteInterno(leitura, inventario, totalComponentes);
                    } catch (ComponenteInvalidoException e) {
                        System.out.println("ERRO DE COMPONENTE: " + e.getMessage());
                    } catch (CapacidadeInvalidaException e) {
                        System.out.println("ERRO DE CAPACIDADE: " + e.getMessage());
                    } catch (NumberFormatException e) {
                        System.out.println("ERRO: Por favor, digite números válidos!");
                    } catch (Exception e) {
                        System.out.println("ERRO INESPERADO: " + e.getMessage());
                    }
                    break;
                    
                case "2":                    
                    try {
                        totalComponentes = opt.adicionarPeriferico(leitura, inventario, totalComponentes);
                    } catch (ComponenteInvalidoException e) {
                        System.out.println("ERRO DE COMPONENTE: " + e.getMessage());
                    } catch (NumberFormatException e) {
                        System.out.println("ERRO: Por favor, digite números válidos!");
                    } catch (Exception e) {
                        System.out.println("ERRO INESPERADO: " + e.getMessage());
                    }
                    break;
                    
                case "3":
                    opt.listarComponentes(inventario, totalComponentes);
                    break;
                    
                case "4":
                    opt.exibirDetalhesComponente(leitura, inventario, totalComponentes);
                    break;
                    
                case "5":
                    opt.calcularPrecoTotal(inventario, totalComponentes);
                    break;
                    
                case "6":
                    opt.verificarCompatibilidade(inventario, totalComponentes);
                    break;
                    
                case "7":
                    totalComponentes = opt.removerComponenteInterno(leitura, inventario, totalComponentes);
                    break;
                    
                case "0":
                    System.out.println("Saindo do sistema...");
                    break;
                    
                default:
                    System.out.println("Opção inválida!");
            }
            
        } while (!opcao.equals("0"));
    }
}