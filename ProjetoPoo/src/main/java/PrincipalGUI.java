/*
 * RA: 2779730
 * Nome: Gabriel Mohamad
*/

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class PrincipalGUI extends JFrame {
    private List<Componente> inventario;
    private JPanel mainPanel;
    private CardLayout cardLayout;
    
    // Cores para o tema moderno
    
    public PrincipalGUI() {
        inventario = new ArrayList<>();
        initComponents();
        setupFrame();
    }
    
    private void initComponents() {
        setTitle("Sistema de Gerenciamento de Componentes - RA: 2779730");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);
        
        // Painel principal com CardLayout
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);
        
        
        // Criar os diferentes painéis
        mainPanel.add(createMenuPanel(), "MENU");
        mainPanel.add(createAddInternalPanel(), "ADD_INTERNAL");
        mainPanel.add(createAddPeripheralPanel(), "ADD_PERIPHERAL");
        mainPanel.add(createListPanel(), "LIST");
        mainPanel.add(createDetailsPanel(), "DETAILS");
        mainPanel.add(createPricePanel(), "PRICE");
        mainPanel.add(createCompatibilityPanel(), "COMPATIBILITY");
        mainPanel.add(createRemovePanel(), "REMOVE");
        
        add(mainPanel);
    }
    
    private void setupFrame() {
        setSize(900, 700);
        setLocationRelativeTo(null);
    }
    
    private JPanel createMenuPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        
        panel.setBorder(BorderFactory.createEmptyBorder(40, 40, 40, 40));
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 0, 10, 0);
        
        // Título
        JLabel titleLabel = new JLabel("Sistema de Gerenciamento de Componentes", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        
        gbc.insets = new Insets(0, 0, 30, 0);
        panel.add(titleLabel, gbc);
        
        // Subtítulo
        JLabel subtitleLabel = new JLabel("RA: 2779730 - Gabriel Mohamad", JLabel.CENTER);
        subtitleLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        
        gbc.insets = new Insets(0, 0, 40, 0);
        panel.add(subtitleLabel, gbc);
        
        gbc.insets = new Insets(10, 0, 10, 0);
        
        // Botões do menu
        String[] buttons = {
            "Adicionar Componente Interno",
            "Adicionar Periférico", 
            "Listar Todos os Componentes",
            "Exibir Detalhes de um Componente",
            "Calcular Preço Total com Impostos",
            "Verificar Compatibilidade",
            "Remover Componente"
        };
        
        String[] cards = {
            "ADD_INTERNAL", "ADD_PERIPHERAL", "LIST", "DETAILS", 
            "PRICE", "COMPATIBILITY", "REMOVE"
        };
        
        for (int i = 0; i < buttons.length; i++) {
            JButton button = createStyledButton(buttons[i]);
            final String card = cards[i];
            button.addActionListener(e -> cardLayout.show(mainPanel, card));
            panel.add(button, gbc);
        }
        
        // Botão Sair
        JButton exitButton = createStyledButton("Sair");
        exitButton.setBackground(new Color(231, 76, 60));
        exitButton.addActionListener(e -> System.exit(0));
        gbc.insets = new Insets(30, 0, 0, 0);
        panel.add(exitButton, gbc);
        
        return panel;
    }
    
    private JPanel createAddInternalPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        
        
        // Cabeçalho
        JPanel headerPanel = createHeaderPanel("Adicionar Componente Interno", "MENU");
        panel.add(headerPanel, BorderLayout.NORTH);
        
        // Painel de conteúdo
        JPanel contentPanel = new JPanel(new GridLayout(0, 2, 15, 10));
        
        contentPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        // Componentes do formulário
        String[] fields = {
            "Tipo (1-RAM, 2-CPU, 3-GPU, 4-PSU, 5-Placa Mãe, 6-Armazenamento):",
            "Nome:", "Fabricante:", "Preço:", "Consumo de Energia (W):"
        };
        
        List<JTextField> textFields = new ArrayList<>();
        
        for (String field : fields) {
            JLabel label = new JLabel(field);
            label.setFont(new Font("Arial", Font.PLAIN, 14));
            JTextField textField = new JTextField();
            textFields.add(textField);
            
            contentPanel.add(label);
            contentPanel.add(textField);
        }
        
        // Área para campos específicos
        JTextArea specificFieldsArea = new JTextArea(8, 30);
        specificFieldsArea.setFont(new Font("Arial", Font.PLAIN, 12));
        specificFieldsArea.setBorder(BorderFactory.createTitledBorder("Campos Específicos (um por linha, formato: campo=valor)"));
        specificFieldsArea.setText("exemplo:\ncapacidade=16\nvelocidade=3200\ntipo=DDR4");
        
        JScrollPane scrollPane = new JScrollPane(specificFieldsArea);
        contentPanel.add(new JLabel("Campos Específicos:"));
        contentPanel.add(scrollPane);
        
        // Painel de botões
        JPanel buttonPanel = new JPanel(new FlowLayout());
        
        
        JButton addButton = createStyledButton("Adicionar Componente");
        addButton.addActionListener(e -> {
            try {
                addInternalComponent(textFields, specificFieldsArea.getText());
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Erro: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });
        
        buttonPanel.add(addButton);
        
        panel.add(contentPanel, BorderLayout.CENTER);
        panel.add(buttonPanel, BorderLayout.SOUTH);
        
        return panel;
    }
    
    private JPanel createAddPeripheralPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        
        
        JPanel headerPanel = createHeaderPanel("Adicionar Periférico", "MENU");
        panel.add(headerPanel, BorderLayout.NORTH);
        
        JPanel contentPanel = new JPanel(new GridLayout(0, 2, 15, 10));
        
        contentPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        String[] fields = {
            "Tipo (1-Monitor, 2-Gabinete, 3-Teclado, 4-Mouse):",
            "Nome:", "Fabricante:", "Preço:", "Tipo de Conexão:"
        };
        
        List<JTextField> textFields = new ArrayList<>();
        
        for (String field : fields) {
            JLabel label = new JLabel(field);
            label.setFont(new Font("Arial", Font.PLAIN, 14));
            JTextField textField = new JTextField();
            textFields.add(textField);
            
            contentPanel.add(label);
            contentPanel.add(textField);
        }
        
        JTextArea specificFieldsArea = new JTextArea(8, 30);
        specificFieldsArea.setFont(new Font("Arial", Font.PLAIN, 12));
        specificFieldsArea.setBorder(BorderFactory.createTitledBorder("Campos Específicos (um por linha, formato: campo=valor)"));
        specificFieldsArea.setText("exemplo:\ntamanhoTela=27.0\nresolucao=1920x1080\ntaxaAtualizacao=144");
        
        JScrollPane scrollPane = new JScrollPane(specificFieldsArea);
        contentPanel.add(new JLabel("Campos Específicos:"));
        contentPanel.add(scrollPane);
        
        JPanel buttonPanel = new JPanel(new FlowLayout());
        
        
        JButton addButton = createStyledButton("Adicionar Periférico");
        addButton.addActionListener(e -> {
            try {
                addPeripheralComponent(textFields, specificFieldsArea.getText());
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Erro: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });
        
        buttonPanel.add(addButton);
        
        panel.add(contentPanel, BorderLayout.CENTER);
        panel.add(buttonPanel, BorderLayout.SOUTH);
        
        return panel;
    }
    
    private JPanel createListPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        
        
        JPanel headerPanel = createHeaderPanel("Lista de Componentes", "MENU");
        panel.add(headerPanel, BorderLayout.NORTH);
        
        DefaultListModel<String> listModel = new DefaultListModel<>();
        JList<String> componentList = new JList<>(listModel);
        componentList.setFont(new Font("Arial", Font.PLAIN, 14));
        componentList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        JScrollPane scrollPane = new JScrollPane(componentList);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        // Atualizar lista
        updateComponentList(listModel);
        
        // Botão para atualizar
        JButton refreshButton = createStyledButton("Atualizar Lista");
        refreshButton.addActionListener(e -> updateComponentList(listModel));
        
        JPanel buttonPanel = new JPanel(new FlowLayout());
        
        buttonPanel.add(refreshButton);
        
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(buttonPanel, BorderLayout.SOUTH);
        
        return panel;
    }
    
    private JPanel createDetailsPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        
        
        JPanel headerPanel = createHeaderPanel("Detalhes do Componente", "MENU");
        panel.add(headerPanel, BorderLayout.NORTH);
        
        JTextArea detailsArea = new JTextArea(20, 50);
        detailsArea.setFont(new Font("Arial", Font.PLAIN, 14));
        detailsArea.setEditable(false);
        detailsArea.setBackground(Color.WHITE);
        
        JScrollPane scrollPane = new JScrollPane(detailsArea);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        JPanel controlPanel = new JPanel(new FlowLayout());
        
        
        JComboBox<String> componentCombo = new JComboBox<>();
        updateComponentCombo(componentCombo);
        
        JButton showButton = createStyledButton("Exibir Detalhes");
        showButton.addActionListener(e -> {
            int selectedIndex = componentCombo.getSelectedIndex();
            if (selectedIndex >= 0 && selectedIndex < inventario.size()) {
                Componente comp = inventario.get(selectedIndex);
                detailsArea.setText(getComponentDetails(comp));
            }
        });
        
        controlPanel.add(new JLabel("Selecione o componente:"));
        controlPanel.add(componentCombo);
        controlPanel.add(showButton);
        
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(controlPanel, BorderLayout.SOUTH);
        
        return panel;
    }
    
    private JPanel createPricePanel() {
        JPanel panel = new JPanel(new BorderLayout());
        
        
        JPanel headerPanel = createHeaderPanel("Cálculo de Preços", "MENU");
        panel.add(headerPanel, BorderLayout.NORTH);
        
        JTextArea priceArea = new JTextArea(15, 50);
        priceArea.setFont(new Font("Arial", Font.PLAIN, 14));
        priceArea.setEditable(false);
        priceArea.setBackground(Color.WHITE);
        
        JScrollPane scrollPane = new JScrollPane(priceArea);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        JPanel buttonPanel = new JPanel(new FlowLayout());
        
        
        JButton calculateButton = createStyledButton("Calcular Preços");
        calculateButton.addActionListener(e -> {
            priceArea.setText(calculatePrices());
        });
        
        buttonPanel.add(calculateButton);
        
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(buttonPanel, BorderLayout.SOUTH);
        
        return panel;
    }
    
    private JPanel createCompatibilityPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        
        
        JPanel headerPanel = createHeaderPanel("Verificação de Compatibilidade", "MENU");
        panel.add(headerPanel, BorderLayout.NORTH);
        
        JTextArea compatArea = new JTextArea(20, 50);
        compatArea.setFont(new Font("Arial", Font.PLAIN, 14));
        compatArea.setEditable(false);
        compatArea.setBackground(Color.WHITE);
        
        JScrollPane scrollPane = new JScrollPane(compatArea);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        JPanel buttonPanel = new JPanel(new FlowLayout());
        
        
        JButton checkButton = createStyledButton("Verificar Compatibilidade");
        checkButton.addActionListener(e -> {
            compatArea.setText(checkCompatibility());
        });
        
        buttonPanel.add(checkButton);
        
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(buttonPanel, BorderLayout.SOUTH);
        
        return panel;
    }
    
    private JPanel createRemovePanel() {
        JPanel panel = new JPanel(new BorderLayout());
        
        
        JPanel headerPanel = createHeaderPanel("Remover Componente", "MENU");
        panel.add(headerPanel, BorderLayout.NORTH);
        
        DefaultListModel<String> listModel = new DefaultListModel<>();
        JList<String> componentList = new JList<>(listModel);
        componentList.setFont(new Font("Arial", Font.PLAIN, 14));
        
        JScrollPane scrollPane = new JScrollPane(componentList);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        updateComponentList(listModel);
        
        JPanel buttonPanel = new JPanel(new FlowLayout());
        
        
        JButton removeButton = createStyledButton("Remover Selecionado");
        removeButton.addActionListener(e -> {
            int selectedIndex = componentList.getSelectedIndex();
            if (selectedIndex != -1) {
                inventario.remove(selectedIndex);
                updateComponentList(listModel);
                JOptionPane.showMessageDialog(this, "Componente removido com sucesso!");
            } else {
                JOptionPane.showMessageDialog(this, "Selecione um componente para remover.", "Aviso", JOptionPane.WARNING_MESSAGE);
            }
        });
        
        JButton refreshButton = createStyledButton("Atualizar Lista");
        refreshButton.addActionListener(e -> updateComponentList(listModel));
        
        buttonPanel.add(removeButton);
        buttonPanel.add(refreshButton);
        
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(buttonPanel, BorderLayout.SOUTH);
        
        return panel;
    }
    
    private JPanel createHeaderPanel(String title, String backCard) {
        JPanel headerPanel = new JPanel(new BorderLayout());
        
        headerPanel.setBorder(BorderFactory.createEmptyBorder(15, 20, 15, 20));
        
        JLabel titleLabel = new JLabel(title);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setForeground(Color.WHITE);
        
        JButton backButton = createStyledButton("Voltar ao Menu");
        backButton.setBackground(new Color(149, 165, 166));
        backButton.addActionListener(e -> cardLayout.show(mainPanel, backCard));
        
        headerPanel.add(titleLabel, BorderLayout.WEST);
        headerPanel.add(backButton, BorderLayout.EAST);
        
        return headerPanel;
    }
    
    private JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 14));
        
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        
        
        return button;
    }
    
    // Métodos auxiliares para funcionalidades
    private void addInternalComponent(List<JTextField> fields, String specificFields) throws Exception {
        if (fields.get(0).getText().isEmpty()) {
            throw new Exception("Tipo é obrigatório!");
        }
        
        String tipo = fields.get(0).getText();
        String nome = fields.get(1).getText();
        String fabricante = fields.get(2).getText();
        double preco = Double.parseDouble(fields.get(3).getText());
        double consumo = Double.parseDouble(fields.get(4).getText());
        
        ComponenteInterno componente = null;
        
        switch (tipo) {
            case "1":
                RAM ram = new RAM();
                ram.setNome(nome);
                ram.setFabricante(fabricante);
                ram.setPreco(preco);
                ram.setConsumoEnergia(consumo);
                // Processar campos específicos
                processSpecificFields(specificFields, ram);
                componente = ram;
                break;
                
            case "2":
                CPU cpu = new CPU();
                cpu.setNome(nome);
                cpu.setFabricante(fabricante);
                cpu.setPreco(preco);
                cpu.setConsumoEnergia(consumo);
                processSpecificFields(specificFields, cpu);
                componente = cpu;
                break;
                
            // Implementar outros casos similares...
                
            default:
                throw new Exception("Tipo inválido!");
        }
        
        if (componente != null) {
            inventario.add(componente);
            JOptionPane.showMessageDialog(this, "Componente interno adicionado com sucesso!");
            // Limpar campos
            for (JTextField field : fields) {
                field.setText("");
            }
        }
    }
    
    private void addPeripheralComponent(List<JTextField> fields, String specificFields) throws Exception {
        // Implementação similar à addInternalComponent
        // ... (código para adicionar periféricos)
    }
    
    private void processSpecificFields(String specificFields, Object component) {
        // Processar campos específicos baseado no tipo de componente
        String[] lines = specificFields.split("\n");
        for (String line : lines) {
            if (line.contains("=")) {
                String[] parts = line.split("=");
                if (parts.length == 2) {
                    String field = parts[0].trim();
                    String value = parts[1].trim();
                    setFieldValue(component, field, value);
                }
            }
        }
    }
    
    private void setFieldValue(Object obj, String fieldName, String value) {
        try {
            // Usar reflection para setar os valores
            // Esta é uma implementação simplificada
            if (obj instanceof RAM) {
                RAM ram = (RAM) obj;
                switch (fieldName) {
                    case "capacidade": ram.setCapacidade(Integer.parseInt(value)); break;
                    case "velocidade": ram.setVelocidade(Integer.parseInt(value)); break;
                    case "tipo": ram.setTipo(value); break;
                }
            }
            // Adicionar outros casos para diferentes componentes...
        } catch (Exception e) {
            System.err.println("Erro ao setar campo: " + fieldName);
        }
    }
    
    private void updateComponentList(DefaultListModel<String> listModel) {
        listModel.clear();
        for (int i = 0; i < inventario.size(); i++) {
            Componente comp = inventario.get(i);
            String tipo = comp.getClass().getSimpleName();
            listModel.addElement((i + 1) + ". " + tipo + " - " + comp.getNome() + " (" + comp.getFabricante() + ")");
        }
    }
    
    private void updateComponentCombo(JComboBox<String> combo) {
        combo.removeAllItems();
        for (Componente comp : inventario) {
            String tipo = comp.getClass().getSimpleName();
            combo.addItem(tipo + " - " + comp.getNome());
        }
    }
    
    private String getComponentDetails(Componente comp) {
        StringBuilder sb = new StringBuilder();
        sb.append("=== DETALHES DO COMPONENTE ===\n\n");
        sb.append("Tipo: ").append(comp.getClass().getSimpleName()).append("\n");
        sb.append("Nome: ").append(comp.getNome()).append("\n");
        sb.append("Fabricante: ").append(comp.getFabricante()).append("\n");
        sb.append("Preço: R$ ").append(String.format("%.2f", comp.getPreco())).append("\n");
        
        if (comp instanceof ComponenteInterno) {
            ComponenteInterno interno = (ComponenteInterno) comp;
            sb.append("Consumo de Energia: ").append(interno.getConsumoEnergia()).append("W\n");
        }
        
        if (comp instanceof Periferico) {
            Periferico periferico = (Periferico) comp;
            sb.append("Tipo de Conexão: ").append(periferico.getTipoConexao()).append("\n");
        }
        
        // Detalhes específicos baseados no tipo
        if (comp instanceof RAM) {
            RAM ram = (RAM) comp;
            sb.append("Capacidade: ").append(ram.getCapacidade()).append("GB\n");
            sb.append("Velocidade: ").append(ram.getVelocidade()).append("MHz\n");
            sb.append("Tipo: ").append(ram.getTipo()).append("\n");
        }
        
        // Adicionar outros tipos específicos...
        
        return sb.toString();
    }
    
    private String calculatePrices() {
        if (inventario.isEmpty()) {
            return "Inventário vazio!";
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append("=== CÁLCULO DE PREÇOS ===\n\n");
        
        double totalSemImposto = 0.0;
        double totalComImposto = 0.0;
        
        for (Componente comp : inventario) {
            double precoComponente = comp.getPreco();
            double precoComImposto = precoComponente + (precoComponente * 0.15); // 15% de imposto
            
            totalSemImposto += precoComponente;
            totalComImposto += precoComImposto;
            
            sb.append("- ").append(comp.getNome())
              .append(": R$ ").append(String.format("%.2f", precoComponente))
              .append(" → R$ ").append(String.format("%.2f", precoComImposto))
              .append(" (com impostos)\n");
        }
        
        sb.append("\n--- RESUMO FINAL ---\n");
        sb.append("Total sem impostos: R$ ").append(String.format("%.2f", totalSemImposto)).append("\n");
        sb.append("Total com impostos (15%): R$ ").append(String.format("%.2f", totalComImposto)).append("\n");
        
        return sb.toString();
    }
    
    private String checkCompatibility() {
        if (inventario.isEmpty()) {
            return "📭 Inventário vazio!";
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append("=== VERIFICAÇÃO DE COMPATIBILIDADE ===\n\n");
        
        // Implementação básica de verificação de compatibilidade
        // Esta é uma versão simplificada da lógica original
        
        boolean placaMaeEncontrada = false;
        boolean fonteEncontrada = false;
        
        for (Componente comp : inventario) {
            if (comp instanceof PlacaMae) {
                placaMaeEncontrada = true;
                PlacaMae placa = (PlacaMae) comp;
                sb.append("🔍 Placa Mãe encontrada: ").append(placa.getNome()).append("\n");
                sb.append("   Socket: ").append(placa.getSocket()).append("\n");
                sb.append("   Slots RAM: ").append(placa.getSlotsRAM()).append("\n");
                sb.append("   Chipset: ").append(placa.getChipset()).append("\n\n");
            }
            
            if (comp instanceof PSU) {
                fonteEncontrada = true;
                PSU fonte = (PSU) comp;
                sb.append("⚡ Fonte encontrada: ").append(fonte.getNome()).append("\n");
                sb.append("   Potência: ").append(fonte.getPotencia()).append("W\n\n");
            }
        }
        
        if (!placaMaeEncontrada) {
            sb.append("⚠️  Nenhuma Placa Mãe encontrada no inventário!\n");
        }
        
        if (!fonteEncontrada) {
            sb.append("⚠️  Nenhuma Fonte de Alimentação encontrada!\n");
        }
        
        sb.append("\n✅ Verificação básica concluída.\n");
        sb.append("💡 Adicione mais componentes para uma análise mais detalhada.");
        
        return sb.toString();
    }
    
    public static void main(String[] args) {
        try {
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        SwingUtilities.invokeLater(() -> {
            new PrincipalGUI().setVisible(true);
        });
    }
}