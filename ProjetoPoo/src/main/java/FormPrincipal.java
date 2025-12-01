import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

// Simulação das classes do projeto original
// Para simplificar a implementação da GUI, vamos usar uma estrutura de dados mais moderna (ArrayList)
// e simular as classes de exceção e componentes, pois não temos acesso a todos os arquivos.

class Componente {
    private String nome;
    private String fabricante;
    private double preco;

    public Componente(String nome, String fabricante, double preco) {
        this.nome = nome;
        this.fabricante = fabricante;
        this.preco = preco;
    }

    public String getNome() { return nome; }
    public String getFabricante() { return fabricante; }
    public double getPreco() { return preco; }
    public String getTipo() { return "Componente"; }

    @Override
    public String toString() {
        return nome + " (" + getTipo() + ") - R$" + String.format("%.2f", preco);
    }
}

class ComponenteInterno extends Componente {
    private int capacidade;

    public ComponenteInterno(String nome, String fabricante, double preco, int capacidade) {
        super(nome, fabricante, preco); // 3 argumentos para Componente
        this.capacidade = capacidade;
    }

    public int getCapacidade() { return capacidade; }
    @Override
    public String getTipo() { return "Interno"; }
}

class Periferico extends Componente {
    public Periferico(String nome, String fabricante, double preco) {
        super(nome, fabricante, preco); // 3 argumentos para Componente
    }
    @Override
    public String getTipo() { return "Periférico"; }
}

class CPU extends ComponenteInterno {
    public CPU(String nome, String fabricante, double preco, int capacidade) {
        super(nome, fabricante, preco, capacidade); // 4 argumentos para ComponenteInterno
    }
    @Override
    public String getTipo() { return "CPU"; }
}

class RAM extends ComponenteInterno {
    public RAM(String nome, String fabricante, double preco, int capacidade) {
        super(nome, fabricante, preco, capacidade); // 4 argumentos para ComponenteInterno
    }
    @Override
    public String getTipo() { return "RAM"; }
}

class Monitor extends Periferico {
    public Monitor(String nome, String fabricante, double preco) {
        super(nome, fabricante, preco); // 3 argumentos para Periferico
    }
    @Override
    public String getTipo() { return "Monitor"; }
}

class ComponenteInvalidoException extends Exception {
    public ComponenteInvalidoException(String message) { super(message); }
}

class CapacidadeInvalidaException extends Exception {
    public CapacidadeInvalidaException(String message) { super(message); }
}

// Classe principal da GUI
public class FormPrincipal extends JFrame {

    private List<Componente> inventario;
    private JTextArea outputArea;
    private JButton btnAddInterno;
    private JButton btnAddPeriferico;
    private JButton btnListar;
    private JButton btnDetalhes;
    private JButton btnPrecoTotal;
    private JButton btnCompatibilidade;
    private JButton btnRemover;
    private JButton btnSair;

    public FormPrincipal() {
        inventario = new ArrayList<>();
        initComponents();
        setTitle("Gerenciador de Computador - GUI");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null); // Centraliza a janela
    }

    private void initComponents() {
        // Configuração do layout principal (simulando o estilo NetBeans Form)
        setLayout(new BorderLayout(10, 10));
        
        // Painel de Botões (Lateral)
        JPanel panelBotoes = new JPanel();
        panelBotoes.setLayout(new GridLayout(8, 1, 5, 5));
        panelBotoes.setBorder(BorderFactory.createTitledBorder("Opções"));

        btnAddInterno = new JButton("1. Adicionar Componente Interno");
        btnAddPeriferico = new JButton("2. Adicionar Periférico");
        btnListar = new JButton("3. Listar Todos os Componentes");
        btnDetalhes = new JButton("4. Exibir Detalhes de um Componente");
        btnPrecoTotal = new JButton("5. Calcular Preço Total c/ Impostos");
        btnCompatibilidade = new JButton("6. Verificar Compatibilidade");
        btnRemover = new JButton("7. Remover Componente Interno");
        btnSair = new JButton("0. Sair");

        panelBotoes.add(btnAddInterno);
        panelBotoes.add(btnAddPeriferico);
        panelBotoes.add(btnListar);
        panelBotoes.add(btnDetalhes);
        panelBotoes.add(btnPrecoTotal);
        panelBotoes.add(btnCompatibilidade);
        panelBotoes.add(btnRemover);
        panelBotoes.add(btnSair);

        // Área de Saída (Central)
        outputArea = new JTextArea(20, 50);
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Saída do Sistema"));

        // Adiciona os painéis ao JFrame
        add(panelBotoes, BorderLayout.WEST);
        add(scrollPane, BorderLayout.CENTER);

        // Adiciona Listeners
        btnAddInterno.addActionListener(e -> adicionarComponenteInterno());
        btnAddPeriferico.addActionListener(e -> adicionarPeriferico());
        btnListar.addActionListener(e -> listarComponentes());
        btnDetalhes.addActionListener(e -> exibirDetalhesComponente());
        btnPrecoTotal.addActionListener(e -> calcularPrecoTotal());
        btnCompatibilidade.addActionListener(e -> verificarCompatibilidade());
        btnRemover.addActionListener(e -> removerComponenteInterno());
        btnSair.addActionListener(e -> System.exit(0));
    }

    // Métodos de Ação (Simulando a lógica de Opcoes.java)

    private void adicionarComponenteInterno() {
        // Tipos de Componentes Internos (RAM, CPU, etc.)
        String[] tipos = {"RAM", "CPU"}; 
        String tipoSelecionado = (String) JOptionPane.showInputDialog(
                this,
                "Escolha o tipo de Componente Interno:",
                "Adicionar Componente Interno",
                JOptionPane.QUESTION_MESSAGE,
                null,
                tipos,
                tipos[0]);

        if (tipoSelecionado != null) {
            try {
                String nome = JOptionPane.showInputDialog(this, "Nome do componente:");
                String fabricante = JOptionPane.showInputDialog(this, "Fabricante:");
                double preco = Double.parseDouble(JOptionPane.showInputDialog(this, "Preço:"));
                int capacidade = Integer.parseInt(JOptionPane.showInputDialog(this, "Capacidade (em GB ou Watts):"));

                if (capacidade <= 0) {
                    throw new CapacidadeInvalidaException("Capacidade inválida: " + capacidade + ". Deve ser maior que zero.");
                }

                ComponenteInterno novoComp = null;
                switch (tipoSelecionado) {
                    case "RAM":
                        novoComp = new RAM(nome, fabricante, preco, capacidade);
                        break;
                    case "CPU":
                        novoComp = new CPU(nome, fabricante, preco, capacidade);
                        break;
                }

                if (novoComp != null) {
                    inventario.add(novoComp);
                    outputArea.append("Componente interno adicionado com sucesso: " + novoComp.getNome() + "\n");
                }

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "ERRO: Por favor, digite números válidos para Preço e Capacidade.", "Erro de Entrada", JOptionPane.ERROR_MESSAGE);
            } catch (CapacidadeInvalidaException ex) {
                JOptionPane.showMessageDialog(this, "ERRO DE CAPACIDADE: " + ex.getMessage(), "Erro de Capacidade", JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "ERRO INESPERADO: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void adicionarPeriferico() {
        // Tipos de Periféricos (Monitor, Mouse, Teclado)
        String[] tipos = {"Monitor", "Mouse", "Teclado"};
        String tipoSelecionado = (String) JOptionPane.showInputDialog(
                this,
                "Escolha o tipo de Periférico:",
                "Adicionar Periférico",
                JOptionPane.QUESTION_MESSAGE,
                null,
                tipos,
                tipos[0]);

        if (tipoSelecionado != null) {
            try {
                String nome = JOptionPane.showInputDialog(this, "Nome do periférico:");
                String fabricante = JOptionPane.showInputDialog(this, "Fabricante:");
                double preco = Double.parseDouble(JOptionPane.showInputDialog(this, "Preço:"));

                Periferico novoPerif = null;
                switch (tipoSelecionado) {
                    case "Monitor":
                        novoPerif = new Monitor(nome, fabricante, preco);
                        break;
                    case "Mouse":
                        novoPerif = new Periferico(nome, fabricante, preco); // Simulação de Mouse
                        break;
                    case "Teclado":
                        novoPerif = new Periferico(nome, fabricante, preco); // Simulação de Teclado
                        break;
                }

                if (novoPerif != null) {
                    inventario.add(novoPerif);
                    outputArea.append("Periférico adicionado com sucesso: " + novoPerif.getNome() + "\n");
                }

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "ERRO: Por favor, digite um número válido para Preço.", "Erro de Entrada", JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "ERRO INESPERADO: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void listarComponentes() {
        outputArea.append("\n=== LISTA DE COMPONENTES ===\n");
        if (inventario.isEmpty()) {
            outputArea.append("Nenhum componente no inventário.\n");
            return;
        }
        for (int i = 0; i < inventario.size(); i++) {
            Componente c = inventario.get(i);
            outputArea.append((i + 1) + ". " + c.getNome() + " (" + c.getTipo() + ") - R$" + String.format("%.2f", c.getPreco()) + "\n");
        }
    }

    private void exibirDetalhesComponente() {
        if (inventario.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nenhum componente no inventário.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String input = JOptionPane.showInputDialog(this, "Digite o número do componente para ver detalhes (1 a " + inventario.size() + "):");
        if (input == null || input.trim().isEmpty()) return;

        try {
            int indice = Integer.parseInt(input);
            if (indice > 0 && indice <= inventario.size()) {
                Componente c = inventario.get(indice - 1);
                StringBuilder detalhes = new StringBuilder();
                detalhes.append("\n=== DETALHES DO COMPONENTE ===\n");
                detalhes.append("Nome: ").append(c.getNome()).append("\n");
                detalhes.append("Fabricante: ").append(c.getFabricante()).append("\n");
                detalhes.append("Preço: R$").append(String.format("%.2f", c.getPreco())).append("\n");
                detalhes.append("Tipo: ").append(c.getTipo()).append("\n");

                if (c instanceof ComponenteInterno) {
                    ComponenteInterno ci = (ComponenteInterno) c;
                    // Simplificação: assume GB para RAM/Armazenamento e W para CPU/PSU
                    String unidade = (c.getTipo().equals("CPU") || c.getTipo().equals("PSU")) ? "W" : "GB";
                    detalhes.append("Capacidade: ").append(ci.getCapacidade()).append(unidade).append("\n");
                }
                outputArea.append(detalhes.toString());
            } else {
                JOptionPane.showMessageDialog(this, "Índice inválido.", "Erro de Entrada", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "ERRO: Por favor, digite um número válido.", "Erro de Entrada", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void calcularPrecoTotal() {
        double totalPreco = inventario.stream().mapToDouble(Componente::getPreco).sum();
        double totalComImpostos = totalPreco * 1.10; // 10% de imposto

        outputArea.append("\n=== CÁLCULO DE PREÇO TOTAL ===\n");
        outputArea.append("Preço Total (sem impostos): R$" + String.format("%.2f", totalPreco) + "\n");
        outputArea.append("Preço Total (com 10% de impostos): R$" + String.format("%.2f", totalComImpostos) + "\n");
    }

    private void verificarCompatibilidade() {
        outputArea.append("\n=== VERIFICAÇÃO DE COMPATIBILIDADE ===\n");
        if (inventario.isEmpty()) {
            outputArea.append("Nenhum componente para verificar.\n");
            return;
        }

        // Simulação simplificada da lógica de compatibilidade
        long cpuCount = inventario.stream().filter(c -> c.getTipo().equals("CPU")).count();
        long ramCount = inventario.stream().filter(c -> c.getTipo().equals("RAM")).count();
        
        boolean compativel = true;

        if (cpuCount > 1) {
            outputArea.append("ERRO: Mais de uma CPU encontrada. Apenas uma é suportada.\n");
            compativel = false;
        }
        if (cpuCount > 0 && ramCount == 0) {
            outputArea.append("AVISO: CPU presente, mas nenhuma RAM encontrada.\n");
        }
        
        if (compativel) {
            outputArea.append("O sistema é compatível (verificação simplificada).\n");
        } else {
            outputArea.append("O sistema NÃO é compatível.\n");
        }
    }

    private void removerComponenteInterno() {
        List<ComponenteInterno> internos = new ArrayList<>();
        for (Componente c : inventario) {
            if (c instanceof ComponenteInterno) {
                internos.add((ComponenteInterno) c);
            }
        }

        if (internos.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nenhum componente interno para remover.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        StringBuilder lista = new StringBuilder("Componentes Internos para Remoção:\n");
        for (int i = 0; i < internos.size(); i++) {
            lista.append((i + 1)).append(". ").append(internos.get(i).getNome()).append(" (").append(internos.get(i).getTipo()).append(")\n");
        }

        String input = JOptionPane.showInputDialog(this, lista.toString() + "\nDigite o número do componente interno a ser removido (1 a " + internos.size() + "):");
        if (input == null || input.trim().isEmpty()) return;

        try {
            int escolha = Integer.parseInt(input);
            if (escolha > 0 && escolha <= internos.size()) {
                ComponenteInterno componenteRemover = internos.get(escolha - 1);
                inventario.remove(componenteRemover);
                outputArea.append("Componente interno removido com sucesso: " + componenteRemover.getNome() + "\n");
            } else {
                JOptionPane.showMessageDialog(this, "Escolha inválida.", "Erro de Entrada", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "ERRO: Por favor, digite um número válido.", "Erro de Entrada", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new FormPrincipal().setVisible(true);
        });
    }
}
