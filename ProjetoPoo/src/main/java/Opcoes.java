/*
 * RA: 2779730
 * Nome: Gabriel Mohamad
 */

public class Opcoes {

    public int adicionarComponenteInterno(Leitura leitura, Componente[] inventario, int total) throws ComponenteInvalidoException, CapacidadeInvalidaException {

        System.out.println("\n=== ADICIONAR COMPONENTE INTERNO ===");
        System.out.println("1. RAM");
        System.out.println("2. CPU");
        System.out.println("3. GPU");
        System.out.println("4. PSU (Fonte)");
        System.out.println("5. Placa Mãe");
        System.out.println("6. Armazenamento");

        String tipo = leitura.entDados("Escolha o tipo:");

        //LANÇANDO ComponenteInvalidoException - PRIMEIRA EXCEÇÃO PERSONALIZADA
        if (!tipo.matches("[1-6]")) {
            throw new ComponenteInvalidoException("Tipo de componente inválido: " + tipo + ". Deve ser entre 1 e 6.");
        }

        // Dados comuns usando SETTERS (Reflexividade)
        String nome = leitura.entDados("Nome do componente:");
        String fabricante = leitura.entDados("Fabricante:");
        double preco = Double.parseDouble(leitura.entDados("Preço:"));
        double consumo = Double.parseDouble(leitura.entDados("Consumo de energia (W):"));

        switch (tipo) {
            case "1":
                RAM ram = new RAM(); //Reflexividade - criação do objeto
                ram.setNome(nome); //Reflexividade - uso de setter
                ram.setFabricante(fabricante); //Reflexividade
                ram.setPreco(preco); //Reflexividade
                ram.setConsumoEnergia(consumo); //Reflexividade

                int capacidadeRAM = Integer.parseInt(leitura.entDados("Capacidade (GB):"));

                //LANÇANDO CapacidadeInvalidaException - SEGUNDA EXCEÇÃO PERSONALIZADA
                if (capacidadeRAM <= 0) {
                    throw new CapacidadeInvalidaException("Capacidade de RAM deve ser positiva! Valor informado: " + capacidadeRAM + "GB");
                }
                if (capacidadeRAM > 128) {
                    throw new CapacidadeInvalidaException("Capacidade de RAM muito alta! Máximo 128GB. Valor informado: " + capacidadeRAM + "GB");
                }

                ram.setCapacidade(capacidadeRAM); //Reflexividade
                ram.setVelocidade(Integer.parseInt(leitura.entDados("Velocidade (MHz):"))); //Reflexividade
                ram.setTipo(leitura.entDados("Tipo (DDR4/DDR5):")); //Reflexividade
                inventario[total] = ram;
                break;

            case "2":
                CPU cpu = new CPU(); //Reflexividade
                cpu.setNome(nome); //Reflexividade
                cpu.setFabricante(fabricante); //Reflexividade
                cpu.setPreco(preco); //Reflexividade
                cpu.setConsumoEnergia(consumo); //Reflexividade

                int nucleos = Integer.parseInt(leitura.entDados("Número de núcleos:"));

                //LANÇANDO CapacidadeInvalidaException
                if (nucleos <= 0) {
                    throw new CapacidadeInvalidaException("Número de núcleos deve ser positivo! Valor informado: " + nucleos);
                }
                if (nucleos > 64) {
                    throw new CapacidadeInvalidaException("Número de núcleos muito alto! Máximo 64. Valor informado: " + nucleos);
                }

                cpu.setNucleos(nucleos); //Reflexividade
                cpu.setClock(Double.parseDouble(leitura.entDados("Clock (GHz):"))); //Reflexividade
                cpu.setSocket(leitura.entDados("Socket:")); //Reflexividade
                inventario[total] = cpu;
                break;

            case "3":
                GPU gpu = new GPU(); //Reflexividade
                gpu.setNome(nome); //Reflexividade
                gpu.setFabricante(fabricante); //Reflexividade
                gpu.setPreco(preco); //Reflexividade
                gpu.setConsumoEnergia(consumo); //Reflexividade

                int vram = Integer.parseInt(leitura.entDados("Memória VRAM (GB):"));

                //LANÇANDO CapacidadeInvalidaException
                if (vram <= 0) {
                    throw new CapacidadeInvalidaException("VRAM deve ser positiva! Valor informado: " + vram + "GB");
                }
                if (vram > 48) {
                    throw new CapacidadeInvalidaException("VRAM muito alta! Máximo 48GB. Valor informado: " + vram + "GB");
                }

                gpu.setMemoriaVRAM(vram); //Reflexividade
                gpu.setArquitetura(leitura.entDados("Arquitetura:")); //Reflexividade
                gpu.setClockBase(Integer.parseInt(leitura.entDados("Clock Base (MHz):"))); //Reflexividade
                inventario[total] = gpu;
                break;

            case "4":
                PSU psu = new PSU(); //Reflexividade
                psu.setNome(nome); //Reflexividade
                psu.setFabricante(fabricante); //Reflexividade
                psu.setPreco(preco); //Reflexividade
                psu.setConsumoEnergia(consumo); //Reflexividade

                int potencia = Integer.parseInt(leitura.entDados("Potência (W):"));

                //LANÇANDO CapacidadeInvalidaException
                if (potencia <= 0) {
                    throw new CapacidadeInvalidaException("Potência da fonte deve ser positiva! Valor informado: " + potencia + "W");
                }
                if (potencia > 2000) {
                    throw new CapacidadeInvalidaException("Potência muito alta! Máximo 2000W. Valor informado: " + potencia + "W");
                }

                psu.setPotencia(potencia); //Reflexividade
                psu.setCertificacao(leitura.entDados("Certificação:")); //Reflexividade
                psu.setModular(leitura.entDados("Modular (s/n):").equalsIgnoreCase("s")); //Reflexividade
                inventario[total] = psu;
                break;

            case "5":
                PlacaMae placaMae = new PlacaMae(); //Reflexividade
                placaMae.setNome(nome); //Reflexividade
                placaMae.setFabricante(fabricante); //Reflexividade
                placaMae.setPreco(preco); //Reflexividade
                placaMae.setConsumoEnergia(consumo); //Reflexividade

                int slotsRAM = Integer.parseInt(leitura.entDados("Slots RAM:"));

                //LANÇANDO CapacidadeInvalidaException
                if (slotsRAM <= 0) {
                    throw new CapacidadeInvalidaException("Número de slots RAM deve ser positivo! Valor informado: " + slotsRAM);
                }
                if (slotsRAM > 8) {
                    throw new CapacidadeInvalidaException("Número de slots RAM muito alto! Máximo 8. Valor informado: " + slotsRAM);
                }

                placaMae.setSocket(leitura.entDados("Socket:")); //Reflexividade
                placaMae.setChipset(leitura.entDados("Chipset:")); //Reflexividade
                placaMae.setSlotsRAM(slotsRAM); //Reflexividade
                placaMae.setFormato(leitura.entDados("Formato:")); //Reflexividade
                inventario[total] = placaMae;
                break;

            case "6":
                Armazenamento armazenamento = new Armazenamento(); //Reflexividade
                armazenamento.setNome(nome); //Reflexividade
                armazenamento.setFabricante(fabricante); //Reflexividade
                armazenamento.setPreco(preco); //Reflexividade
                armazenamento.setConsumoEnergia(consumo); //Reflexividade

                int capacidadeArm = Integer.parseInt(leitura.entDados("Capacidade (GB):"));

                //LANÇANDO CapacidadeInvalidaException
                if (capacidadeArm <= 0) {
                    throw new CapacidadeInvalidaException("Capacidade de armazenamento deve ser positiva! Valor informado: " + capacidadeArm + "GB");
                }
                if (capacidadeArm > 8192) {
                    throw new CapacidadeInvalidaException("Capacidade muito alta! Máximo 8TB (8192GB). Valor informado: " + capacidadeArm + "GB");
                }

                armazenamento.setCapacidade(capacidadeArm); //Reflexividade
                armazenamento.setTipo(leitura.entDados("Tipo (SSD/HDD/NVMe):")); //Reflexividade
                armazenamento.setInterfaceConexao(leitura.entDados("Interface:")); //Reflexividade
                armazenamento.setVelocidadeLeitura(Integer.parseInt(leitura.entDados("Velocidade de leitura (MB/s):"))); //Reflexividade
                inventario[total] = armazenamento;
                break;
        }

        System.out.println("Componente interno adicionado com sucesso!");
        return total + 1;
    }

    public int adicionarPeriferico(Leitura leitura, Componente[] inventario, int total) throws ComponenteInvalidoException {
        System.out.println("\n=== ADICIONAR PERIFÉRICO ===");
        System.out.println("1. Monitor");
        System.out.println("2. Gabinete");
        System.out.println("3. Teclado");
        System.out.println("4. Mouse");

        String tipo = leitura.entDados("Escolha o tipo:");

        //LANÇANDO ComponenteInvalidoException
        if (!tipo.matches("[1-4]")) {
            throw new ComponenteInvalidoException("Tipo de periférico inválido: " + tipo + ". Deve ser entre 1 e 4.");
        }

        String nome = leitura.entDados("Nome do periférico:");
        String fabricante = leitura.entDados("Fabricante:");
        double preco = Double.parseDouble(leitura.entDados("Preço:"));
        String tipoConexao = leitura.entDados("Tipo de conexão:");

        switch (tipo) {
            case "1":
                Monitor monitor = new Monitor(); //Reflexividade
                monitor.setNome(nome); //Reflexividade
                monitor.setFabricante(fabricante); //Reflexividade
                monitor.setPreco(preco); //Reflexividade
                monitor.setTipoConexao(tipoConexao); //Reflexividade

                double tamanhoTela = Double.parseDouble(leitura.entDados("Tamanho da tela (polegadas):"));
                if (tamanhoTela <= 0) {
                    throw new ComponenteInvalidoException("Tamanho da tela deve ser positivo!");
                }

                monitor.setTamanhoTela(tamanhoTela); //Reflexividade
                monitor.setResolucao(leitura.entDados("Resolução:")); //Reflexividade
                monitor.setTaxaAtualizacao(Integer.parseInt(leitura.entDados("Taxa de atualização (Hz):"))); //Reflexividade
                monitor.setTipoPanel(leitura.entDados("Tipo de panel:")); //Reflexividade
                inventario[total] = monitor;
                break;

            case "2":
                Gabinete gabinete = new Gabinete(); //Reflexividade
                gabinete.setNome(nome); //Reflexividade
                gabinete.setFabricante(fabricante); //Reflexividade
                gabinete.setPreco(preco); //Reflexividade
                gabinete.setTipoConexao(tipoConexao); //Reflexividade
                gabinete.setFormato(leitura.entDados("Formato:")); //Reflexividade
                gabinete.setMaterial(leitura.entDados("Material:")); //Reflexividade
                gabinete.setJanelaLateral(leitura.entDados("Janela lateral (s/n):").equalsIgnoreCase("s")); //Reflexividade

                int ventoinhas = Integer.parseInt(leitura.entDados("Ventoinhas inclusas:"));
                if (ventoinhas < 0) {
                    throw new ComponenteInvalidoException("Número de ventoinhas não pode ser negativo!");
                }

                gabinete.setVentoinhasInclusas(ventoinhas); //Reflexividade
                inventario[total] = gabinete;
                break;

            case "3":
                Teclado teclado = new Teclado(); //Reflexividade
                teclado.setNome(nome); //Reflexividade
                teclado.setFabricante(fabricante); //Reflexividade
                teclado.setPreco(preco); //Reflexividade
                teclado.setTipoConexao(tipoConexao); //Reflexividade
                teclado.setLayout(leitura.entDados("Layout:")); //Reflexividade
                teclado.setTipoSwitch(leitura.entDados("Tipo de switch:")); //Reflexividade
                teclado.setRetroiluminado(leitura.entDados("Retroiluminado (s/n):").equalsIgnoreCase("s")); //Reflexividade
                teclado.setSemFio(leitura.entDados("Sem fio (s/n):").equalsIgnoreCase("s")); //Reflexividade
                inventario[total] = teclado;
                break;

            case "4":
                Mouse mouse = new Mouse(); //Reflexividade
                mouse.setNome(nome); //Reflexividade
                mouse.setFabricante(fabricante); //Reflexividade
                mouse.setPreco(preco); //Reflexividade
                mouse.setTipoConexao(tipoConexao); //Reflexividade

                int dpi = Integer.parseInt(leitura.entDados("DPI:"));
                if (dpi <= 0) {
                    throw new ComponenteInvalidoException("DPI deve ser positivo!");
                }

                mouse.setDpi(dpi); //Reflexividade
                mouse.setTipoSensor(leitura.entDados("Tipo de sensor:")); //Reflexividade

                int botoes = Integer.parseInt(leitura.entDados("Número de botões:"));
                if (botoes <= 0) {
                    throw new ComponenteInvalidoException("Número de botões deve ser positivo!");
                }

                mouse.setNumeroBotoes(botoes); //Reflexividade
                mouse.setSemFio(leitura.entDados("Sem fio (s/n):").equalsIgnoreCase("s")); //Reflexividade
                inventario[total] = mouse;
                break;
        }

        System.out.println("Periférico adicionado com sucesso!");
        return total + 1;
    }

    public int removerComponenteInterno(Leitura leitura, Componente[] inventario, int total) {
        if (total >= 1) {
            System.out.println("\n=== REMOÇÃO DE COMPONENTES ===");
            listarComponentes(inventario, total);

            int indiceParaRemover = -1;
            try {
                indiceParaRemover = Integer.parseInt(leitura.entDados("Digite o número do componente a ser removido:")) - 1;
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, digite um número.");
                return total;
            }

            if (indiceParaRemover >= 0 && indiceParaRemover < total) {
                // Reflexividade - acesso aos métodos do objeto
                System.out.println("Removendo: " + inventario[indiceParaRemover].getNome() + " - " + inventario[indiceParaRemover].getFabricante()); //Reflexividade

                for (int i = indiceParaRemover; i < total - 1; i++) {
                    inventario[i] = inventario[i + 1];
                }
                inventario[total - 1] = null;
                System.out.println("Componente removido com sucesso!");
                return total - 1;
            } else {
                System.out.println("Índice inválido. Componente não encontrado.");
                return total;
            }

        } else {
            System.out.println("Inventário vazio");
            return total;
        }
    }

    public void listarComponentes(Componente[] inventario, int total) {
        if (total == 0) {
            System.out.println("Inventário vazio!");
            return;
        }

        System.out.println("\n=== LISTA DE COMPONENTES ===");
        for (int i = 0; i < total; i++) {
            // Reflexividade - acesso encadeado a métodos
            System.out.println((i + 1) + ". " + inventario[i].getNome() + " - " + inventario[i].getFabricante()); //Reflexividade
        }
    }

    public void exibirDetalhesComponente(Leitura leitura, Componente[] inventario, int total) {
        if (total == 0) {
            System.out.println("Inventário vazio!");
            return;
        }

        listarComponentes(inventario, total);
        try {
            int indice = Integer.parseInt(leitura.entDados("Digite o número do componente:")) - 1;

            if (indice >= 0 && indice < total) {
                inventario[indice].exibirDetalhes(); //Reflexividade - chamada polimórfica
            } else {
                System.out.println("Componente não encontrado!");
            }
        } catch (NumberFormatException e) {
            System.out.println("Digite um número válido.");
        }
    }

    public void calcularPrecoTotal(Componente[] inventario, int total) {
        if (total == 0) {
            System.out.println("Inventário vazio!");
            return;
        }

        System.out.println("\n=== CÁLCULO DE PREÇOS ===");
        double totalSemImposto = 0.0;
        double totalComImposto = 0.0;

        for (int i = 0; i < total; i++) {
            if (inventario[i] instanceof Calculavel) {
                double precoComponente = inventario[i].getPreco();
                double precoComImposto = precoComponente + (precoComponente * Calculavel.TAXA_IMPOSTO);

                totalSemImposto += precoComponente;
                totalComImposto += precoComImposto;

                // Mostra o preço individual de cada componente
                System.out.println("- " + inventario[i].getNome() + ": R$ " + precoComponente
                        + " R$ " + String.format("%.2f", precoComImposto) + " (com impostos)");
            }
        }

        // Mostra o total geral
        System.out.println("\n--- RESUMO FINAL ---");
        System.out.println("Total sem impostos: R$ " + String.format("%.2f", totalSemImposto));
        System.out.println("Total com impostos (" + (Calculavel.TAXA_IMPOSTO * 100) + "%): R$ "
                + String.format("%.2f", totalComImposto));
    }

    public void verificarCompatibilidade(Componente[] inventario, int total) {
        if (total == 0) {
            System.out.println("📭 Inventário vazio!");
            return;
        }
    
        System.out.println("\n=== VERIFICAÇÃO DE COMPATIBILIDADE ===");
    
        // Encontrar a Placa Mãe no inventário
        PlacaMae placaMae = null;
        for (int i = 0; i < total; i++) {
        if (inventario[i] instanceof PlacaMae) {
            placaMae = (PlacaMae) inventario[i];
            break;
        }
        }
        
        if (placaMae == null) {
            System.out.println("Nenhuma Placa Mãe encontrada no inventário!");
            return;
        }
    
        System.out.println("Placa Mãe encontrada: " + placaMae.getNome());
        System.out.println("Socket: " + placaMae.getSocket());
        System.out.println("Slots RAM: " + placaMae.getSlotsRAM());
        System.out.println("Chipset: " + placaMae.getChipset());
        System.out.println();
        
        // Verificar compatibilidade com outros componentes
        boolean algumIncompativel = false;
        
        for (int i = 0; i < total; i++) {
            if (inventario[i] instanceof CPU) {
                CPU cpu = (CPU) inventario[i];
                boolean socketCompativel = cpu.getSocket().equalsIgnoreCase(placaMae.getSocket());
                
                System.out.println("CPU: " + cpu.getNome());
                System.out.println("Socket: " + cpu.getSocket());
                System.out.println("Compatibilidade: " + (socketCompativel ? " COMPATÍVEL" : " INCOMPATÍVEL"));
                
                if (!socketCompativel) {
                    algumIncompativel = true;
                    System.out.println(" Socket da CPU não corresponde ao da Placa Mãe!");
                }
                System.out.println();
            }
            
            if (inventario[i] instanceof RAM) {
                RAM ram = (RAM) inventario[i];
                // Verifica se o tipo de RAM é compatível (DDR4, DDR5, etc)
                
                System.out.println("RAM: " + ram.getNome());
                System.out.println("Tipo: " + ram.getTipo());
                System.out.println("Capacidade: " + ram.getCapacidade() + "GB");
                System.out.println("Slots disponíveis na Placa Mãe: " + placaMae.getSlotsRAM());
                System.out.println("Status: COMPATÍVEL (verificação básica)");
                System.out.println();
            }
        }
        
        // Verificação de potência da fonte
        PSU fonte = null;
        for (int i = 0; i < total; i++) {
            if (inventario[i] instanceof PSU) {
                fonte = (PSU) inventario[i];
                break;
            }
        }
        
        if (fonte != null) {
            System.out.println("Fonte: " + fonte.getNome());
            System.out.println("Potência: " + fonte.getPotencia() + "W");
            
            // Cálculo básico de consumo estimado
            double consumoEstimado = calcularConsumoEstimado(inventario, total);
            System.out.println("Consumo estimado do sistema: " + String.format("%.0f", consumoEstimado) + "W");
            
            boolean potenciaSuficiente = fonte.getPotencia() >= consumoEstimado;
            System.out.println("Potência suficiente: " + (potenciaSuficiente ? " SIM" : " NÃO"));
            
            if (!potenciaSuficiente) {
                algumIncompativel = true;
                System.out.println("Fonte pode não ser suficiente para o sistema!");
            }
            System.out.println();
        }
        
        // Resumo final
        if (algumIncompativel) {
            System.out.println("RESUMO: Foram encontradas incompatibilidades no sistema!");
        } else {
            System.out.println("RESUMO: Sistema compatível!");
        }
        }

    private double calcularConsumoEstimado(Componente[] inventario, int total) {
        double consumoTotal = 0;
        
        for (int i = 0; i < total; i++) {
            if (inventario[i] instanceof ComponenteInterno) {
                ComponenteInterno componente = (ComponenteInterno) inventario[i];
                consumoTotal += componente.getConsumoEnergia();
            }
        }
        
        // Adiciona uma margem de segurança de 20%
        return consumoTotal * 1.2;
    }
}
