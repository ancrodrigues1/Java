package Controlo_Estoque;

/**
 * @author Antonio
 */
import java.util.Scanner;
import java.util.ArrayList;

public class Controlo_Estoque_Main {
    
    public static ArrayList<Produtos> produto = new ArrayList(); 
    public static ArrayList<InfoExtras> infoextras = new ArrayList(); 
    public static ArrayList<Financeiro> financeiro = new ArrayList();
    public static ArrayList<Produtos> backupProdutos = new ArrayList();
    
    public static int buscaIdProdutoBinaria(int idProduto){
        int inicioLista = 0;
        int finalLista = produto.size() - 1;
        while(inicioLista <= finalLista){
            int meioLista = (inicioLista + finalLista)/2;
            int idMeioLista = produto.get(meioLista).getIdInterno();
            if (idMeioLista == idProduto){
                return meioLista;
            } else { 
                if (idMeioLista < idProduto){
                    inicioLista = meioLista + 1;
                } else {
                    finalLista = meioLista - 1;
                }
            }
        }
        return -1;
    }
    
    public static int menuTipoProduto(){
        int tipoProduto = 0;
        System.out.println(" Selecione o tipo do Produto");
        System.out.println("  » 1 - Bebidas");
        System.out.println("  » 2 - Biscoitos");
        System.out.println("  » 3 - Carnes");
        System.out.println("  » 4 - Cereais");
        System.out.println("  » 5 - Frutas e Legumes");
        while(true){
            tipoProduto = Auxiliares.entradaIntPositivo("Digite a opção: ");
            if (tipoProduto >=1 && tipoProduto <=5){
                break;
            } else {
                System.out.println(Auxiliares.opcaoMenuIncorreta);
            }
        }
        return tipoProduto;
    }
    
    public static void incluifinanceiro(){
        financeiro.add(new Financeiro(1, Auxiliares.entradaDoublePositivo("\nInforme valor de Compra do Produto: "),
                                        Auxiliares.entradaIVA("\nInforme IVA Produto: "),
                                        Auxiliares.entradaDoublePositivo("\nInforme valor de Venda do Produto: ")));
    }
    
    public static void cadastroProduto(){
        Scanner scn = new Scanner(System.in);
        System.out.println("\n  **CADASTRAR PRODUTO**\n");
        int tipoProduto = menuTipoProduto();
        long tempCodigoBarras;
        String tempDescricao;
        boolean incluiExtras;
        tempCodigoBarras = Auxiliares.entradaLongPositivo("\nInforme o Codigo de Barras: ");
        tempDescricao = Auxiliares.entradaString("\nInforme a Descrição: ");
        switch(tipoProduto){
            case 1:
                double tempQuantidadeBebida = Auxiliares.entradaDoubleNuloPositivo("\nInforme saldo Inicial: ");
                String tempTipoBebida = Auxiliares.entradaString("\nInforme tipo de Bebida: ");
                boolean tempProbido18 = Auxiliares.respostaSN("\nProibida a venda a Menores de 18 anos(S/N): ");
                incluifinanceiro();
                incluiExtras = Auxiliares.respostaSN("\n >Deseja incluir informações Extras(S/N)? ");
                if (incluiExtras){
                    String tempFabricante = Auxiliares.entradaString("\nInforme Fabricante do Produto: ");
                    String tempFornecedor = Auxiliares.entradaString("\nInforme Fornecedor Preferencial: ");
                    System.out.print("\nInforme Observação: ");
                    String tempObservacao = scn.nextLine().trim().toUpperCase();
                    infoextras.add(new InfoExtras(1, tempFabricante, tempFornecedor, tempObservacao));
                }
                if(Auxiliares.respostaSN("\n\n >Confirma Inclusao dos dados(S/N)? ")){
                    if (incluiExtras){
                        if (!produto.isEmpty()){
                            infoextras.getLast().setIdProduto(produto.getLast().getIdInterno()+1);
                            financeiro.getLast().setIdProduto(produto.getLast().getIdInterno()+1);
                        }
                        produto.add(new Bebidas(tempCodigoBarras,tempDescricao,infoextras.getLast(),
                                                financeiro.getLast(),tempQuantidadeBebida,tempTipoBebida,tempProbido18));
                    } else {
                        if (!produto.isEmpty()){
                            financeiro.getLast().setIdProduto(produto.getLast().getIdInterno()+1);
                        }
                        produto.add(new Bebidas(tempCodigoBarras,tempDescricao,null,
                                                financeiro.getLast(),tempQuantidadeBebida,tempTipoBebida,tempProbido18));
                    }
                    System.out.println(Auxiliares.registogravado);
                } else {
                    financeiro.removeLast();
                    if (incluiExtras){
                        infoextras.removeLast();
                    }
                    System.out.println(Auxiliares.registocnacelado);
                }
                break;
            case 2:
                int tempQuantidadeBiscoito = Auxiliares.entradaIntPositivo("\nInforme saldo Inicial: ");
                String tempTipoBiscoito = Auxiliares.entradaString("\nInforme tipo de Biscoito: ");
                incluifinanceiro();
                incluiExtras = Auxiliares.respostaSN("\n >Deseja incluir informações Extras(S/N)? ");
                if (incluiExtras){
                    String tempFabricante = Auxiliares.entradaString("\nInforme Fabricante do Produto: ");
                    String tempFornecedor = Auxiliares.entradaString("\nInforme Fornecedor Preferencial: ");
                    System.out.print("\nInforme Observação: ");
                    String tempObservacao = scn.nextLine().trim().toUpperCase();
                    infoextras.add(new InfoExtras(1, tempFabricante, tempFornecedor, tempObservacao));
                }
                if(Auxiliares.respostaSN("\n\n >Confirma Inclusao dos dados(S/N)? ")){
                    if (incluiExtras){
                        if (!produto.isEmpty()){
                            infoextras.getLast().setIdProduto(produto.getLast().getIdInterno()+1);
                            financeiro.getLast().setIdProduto(produto.getLast().getIdInterno()+1);
                        }
                        produto.add(new Biscoitos(tempCodigoBarras,tempDescricao,infoextras.getLast(),
                                                financeiro.getLast(),tempQuantidadeBiscoito,tempTipoBiscoito));
                    } else {
                        if (!produto.isEmpty()){
                            financeiro.getLast().setIdProduto(produto.getLast().getIdInterno()+1);
                        }
                        produto.add(new Biscoitos(tempCodigoBarras,tempDescricao,null,
                                                financeiro.getLast(),tempQuantidadeBiscoito,tempTipoBiscoito));
                    }
                    System.out.println(Auxiliares.registogravado);
                } else {
                    financeiro.removeLast();
                    if (incluiExtras){
                        infoextras.removeLast();
                    }
                    System.out.println(Auxiliares.registocnacelado);
                }
                break;
            case 3:
                double tempQuantidadeCarnes = Auxiliares.entradaDoublePositivo("\nInforme saldo Inicial: ");
                String tempAnimalCarnes = Auxiliares.entradaString("\nInforme Animal: ");
                incluifinanceiro();
                incluiExtras = Auxiliares.respostaSN("\n >Deseja incluir informações Extras(S/N)? ");
                if (incluiExtras){
                    String tempFabricante = Auxiliares.entradaString("\nInforme Fabricante do Produto: ");
                    String tempFornecedor = Auxiliares.entradaString("\nInforme Fornecedor Preferencial: ");
                    System.out.print("\nInforme Observação: ");
                    String tempObservacao = scn.nextLine().trim().toUpperCase();
                    infoextras.add(new InfoExtras(1, tempFabricante, tempFornecedor, tempObservacao));
                }
                if(Auxiliares.respostaSN("\n\n >Confirma Inclusao dos dados(S/N)? ")){
                    if (incluiExtras){
                        if (!produto.isEmpty()){
                            infoextras.getLast().setIdProduto(produto.getLast().getIdInterno()+1);
                            financeiro.getLast().setIdProduto(produto.getLast().getIdInterno()+1);
                        }
                        produto.add(new Carnes(tempCodigoBarras,tempDescricao,infoextras.getLast(),
                                                financeiro.getLast(),tempQuantidadeCarnes,tempAnimalCarnes));
                    } else {
                        if (!produto.isEmpty()){
                            financeiro.getLast().setIdProduto(produto.getLast().getIdInterno()+1);
                        }
                        produto.add(new Carnes(tempCodigoBarras,tempDescricao,null,
                                                financeiro.getLast(),tempQuantidadeCarnes,tempAnimalCarnes));
                    }
                    System.out.println(Auxiliares.registogravado);
                } else {
                    financeiro.removeLast();
                    if (incluiExtras){
                        infoextras.removeLast();
                    }
                    System.out.println(Auxiliares.registocnacelado);
                }
                break;
            case 4:
                double tempQuantidadeCereais = Auxiliares.entradaDoublePositivo("\nInforme saldo Inicial: ");
                String tempTipoCereais = Auxiliares.entradaString("\nInforme tipo de Cereal: ");
                incluifinanceiro();
                incluiExtras = Auxiliares.respostaSN("\n >Deseja incluir informações Extras(S/N)? ");
                if (incluiExtras){
                    String tempFabricante = Auxiliares.entradaString("\nInforme Fabricante do Produto: ");
                    String tempFornecedor = Auxiliares.entradaString("\nInforme Fornecedor Preferencial: ");
                    System.out.print("\nInforme Observação: ");
                    String tempObservacao = scn.nextLine().trim().toUpperCase();
                    infoextras.add(new InfoExtras(1, tempFabricante, tempFornecedor, tempObservacao));
                }
                if(Auxiliares.respostaSN("\n\n >Confirma Inclusao dos dados(S/N)? ")){
                    if (incluiExtras){
                        if (!produto.isEmpty()){
                            infoextras.getLast().setIdProduto(produto.getLast().getIdInterno()+1);
                            financeiro.getLast().setIdProduto(produto.getLast().getIdInterno()+1);
                        }
                        produto.add(new Cereais(tempCodigoBarras,tempDescricao,infoextras.getLast(),
                                                financeiro.getLast(),tempQuantidadeCereais,tempTipoCereais));
                    } else {
                        if (!produto.isEmpty()){
                            financeiro.getLast().setIdProduto(produto.getLast().getIdInterno()+1);
                        }
                        produto.add(new Cereais(tempCodigoBarras,tempDescricao,null,
                                                financeiro.getLast(),tempQuantidadeCereais,tempTipoCereais));
                    }
                    System.out.println(Auxiliares.registogravado);
                } else {
                    financeiro.removeLast();
                    if (incluiExtras){
                        infoextras.removeLast();
                    }
                    System.out.println(Auxiliares.registocnacelado);
                }
                break; 
            case 5:
                double tempQuantidadeFrLegumes = Auxiliares.entradaDoublePositivo("\nInforme saldo Inicial: ");
                incluifinanceiro();
                incluiExtras = Auxiliares.respostaSN("\n >Deseja incluir informações Extras(S/N)? ");
                if (incluiExtras){
                    String tempFabricante = Auxiliares.entradaString("\nInforme Fabricante do Produto: ");
                    String tempFornecedor = Auxiliares.entradaString("\nInforme Fornecedor Preferencial: ");
                    System.out.print("\nInforme Observação: ");
                    String tempObservacao = scn.nextLine().trim().toUpperCase();
                    infoextras.add(new InfoExtras(1, tempFabricante, tempFornecedor, tempObservacao));
                }
                if(Auxiliares.respostaSN("\n\n >Confirma Inclusao dos dados(S/N)? ")){
                    if (incluiExtras){
                        if (!produto.isEmpty()){
                            infoextras.getLast().setIdProduto(produto.getLast().getIdInterno()+1);
                            financeiro.getLast().setIdProduto(produto.getLast().getIdInterno()+1);
                        }
                        produto.add(new FrutasLegumes(tempCodigoBarras,tempDescricao,infoextras.getLast(),
                                                financeiro.getLast(),tempQuantidadeFrLegumes));
                    } else {
                        if (!produto.isEmpty()){
                            financeiro.getLast().setIdProduto(produto.getLast().getIdInterno()+1);
                        }    
                        produto.add(new FrutasLegumes(tempCodigoBarras,tempDescricao,null,
                                                financeiro.getLast(),tempQuantidadeFrLegumes));
                    }
                    System.out.println(Auxiliares.registogravado);
                } else {
                    financeiro.removeLast();
                    if (incluiExtras){
                        infoextras.removeLast();
                    }
                    System.out.println(Auxiliares.registocnacelado);
                }
                break;    
        }
    }
    
    public static void entradaSaidaProduto(String tipoMovimento){
        if (tipoMovimento.equalsIgnoreCase("Saida")){
            System.out.println("\n  **SAIDA PRODUTO**\n");
        } else {
            System.out.println("\n  **ENTRADA PRODUTO**\n");
        }
        int tempIdProduto = Auxiliares.entradaIntPositivo("\nInforme Id Produto: ");
        int indexProdutoEncontrado = buscaIdProdutoBinaria(tempIdProduto);
        if (indexProdutoEncontrado==-1){
            System.out.println(Auxiliares.registoNaoEncontrado);
        } else {
            Produtos p = produto.get(indexProdutoEncontrado);
            System.out.println("\nProduto: "+p.getDescricao());
            if(p instanceof Bebidas bebida){
                System.out.println("Quantidade Atual: "+bebida.getQuantidade());
                double tempQuantidade = Auxiliares.entradaDoublePositivo(
                                "\nInforme a quantidade de "+tipoMovimento+": ");
                if (tipoMovimento.equalsIgnoreCase("Saida")){
                    tempQuantidade = tempQuantidade*(-1);
                }
                tempQuantidade = bebida.getQuantidade() + tempQuantidade;
                if (tempQuantidade >=0){
                    bebida.setQuantidade(tempQuantidade);
                    System.out.println(Auxiliares.registogravado);
                } else {
                    System.out.println(Auxiliares.opCanceladaSaldoNegativo);
                }
            } else if (p instanceof Biscoitos biscoito){
                System.out.println("Quantidade Atual: "+biscoito.getQuantidade());
                int tempQuantidade = Auxiliares.entradaIntPositivo(
                                "\nInforme a quantidade de "+tipoMovimento+": ");
                if (tipoMovimento.equalsIgnoreCase("Saida")){
                    tempQuantidade = tempQuantidade*(-1);
                }
                tempQuantidade = biscoito.getQuantidade() + tempQuantidade;
                if (tempQuantidade >=0){
                    biscoito.setQuantidade(tempQuantidade);
                    System.out.println(Auxiliares.registogravado);
                } else {
                    System.out.println(Auxiliares.opCanceladaSaldoNegativo);
                }
            } else if (p instanceof Carnes carne){
                System.out.println("Quantidade Atual: "+carne.getQuantidade());
                double tempQuantidade = Auxiliares.entradaDoublePositivo(
                                "\nInforme a quantidade de "+tipoMovimento+": ");
                if (tipoMovimento.equalsIgnoreCase("Saida")){
                    tempQuantidade = tempQuantidade*(-1);
                }
                tempQuantidade = carne.getQuantidade() + tempQuantidade;
                if (tempQuantidade >=0){
                    carne.setQuantidade(tempQuantidade);
                    System.out.println(Auxiliares.registogravado);
                } else {
                    System.out.println(Auxiliares.opCanceladaSaldoNegativo);
                }
            } else if (p instanceof Cereais cereal){
                System.out.println("Quantidade Atual: "+cereal.getQuantidade());
                double tempQuantidade = Auxiliares.entradaDoublePositivo(
                                "\nInforme a quantidade de "+tipoMovimento+": ");
                if (tipoMovimento.equalsIgnoreCase("Saida")){
                    tempQuantidade = tempQuantidade*(-1);
                }
                tempQuantidade = cereal.getQuantidade() + tempQuantidade;
                if (tempQuantidade >=0){
                    cereal.setQuantidade(tempQuantidade);
                    System.out.println(Auxiliares.registogravado);
                } else {
                    System.out.println(Auxiliares.opCanceladaSaldoNegativo);
                }
            } else if (p instanceof FrutasLegumes frlegumes){
                System.out.println("Quantidade Atual: "+frlegumes.getQuantidade());
                double tempQuantidade = Auxiliares.entradaDoublePositivo(
                                "\nInforme a quantidade de "+tipoMovimento+": ");
                if (tipoMovimento.equalsIgnoreCase("Saida")){
                    tempQuantidade = tempQuantidade*(-1);
                }
                tempQuantidade = frlegumes.getQuantidade() + tempQuantidade;
                if (tempQuantidade >=0){
                    frlegumes.setQuantidade(tempQuantidade);
                    System.out.println(Auxiliares.registogravado);
                } else {
                    System.out.println(Auxiliares.opCanceladaSaldoNegativo);
                }
            }
        }
    }
    
    public static void consultaProduto(){
        System.out.println("\n  **CONSULTA PRODUTO**\n");
        int tempIdProduto = Auxiliares.entradaIntPositivo("\nInforme Id Produto: ");
        int indexProdutoEncontrado = buscaIdProdutoBinaria(tempIdProduto);
        if (indexProdutoEncontrado==-1){
            System.out.println(Auxiliares.registoNaoEncontrado);
        } else {
            produto.get(indexProdutoEncontrado).print();
        }
    }
    
    public static void listarProdutos(){
        System.out.println("\n  **LISTAGEM PRODUTOS**\n");
        for (int i = 0; i < produto.size(); i++){
            System.out.println(produto.get(i).toString());
        }
    }
    
    public static void backupProdutos(){
        boolean precisaBackup = false;
        if (produto.size() != backupProdutos.size()){
            precisaBackup = true;
        } else {
            for(int i = 0; i < produto.size(); i++){
                Produtos p = produto.get(i);
                Produtos backup = backupProdutos.get(i);
                if (!p.equals(backup)){
                    precisaBackup = true;
                    break;
                }
            }
        }
        if (precisaBackup){
            backupProdutos.clear();
            int contadorErros = 0;
            for (Produtos p : produto){
                try{
                    backupProdutos.add(p.clone());
                } catch (CloneNotSupportedException e) {
                    contadorErros++;
                    System.out.println("\n **Erro no backup do Produto: "+p.getDescricao()+"**");
                }
            }
            System.out.println("\n *Backup reallizado com "+contadorErros+" erros!");
        } else {
            System.out.println("\n **Backup já atualizado!!!**");
        }
    }
    
    public static void main(String args[]){
        int opcao=0;
        while(opcao != 7){
            System.out.println("\n\n");
            System.out.println("***************************************");
            System.out.println("           CONTROLO ESTOQUE           *");
            System.out.println(" 1 - ENTRADA ESTOQUE                  *");
            System.out.println(" 2 - SAIDA ESTOQUE                    *");
            System.out.println(" 3 - CONSULTA PRODUTO                 *");
            System.out.println(" 4 - LISTAR PRODUTOS                  *");
            System.out.println(" 5 - CADASTRO PRODUTO                 *");
            System.out.println(" 6 - BACKUP                           *");
            System.out.println(" 7 - SAIR                             *");
            System.out.println("***************************************");
            opcao = Auxiliares.entradaIntPositivo(" »Digite sua Opção: ");
            if (opcao >= 1 && opcao <= 7){
                switch(opcao){
                    case 1:
                        entradaSaidaProduto("Entrada");
                        break;
                    case 2:
                        entradaSaidaProduto("Saida");
                        break;
                    case 3:
                        consultaProduto();
                        break;
                    case 4:
                        listarProdutos();
                        break;
                    case 5:
                        cadastroProduto();
                        break;
                    case 6:
                        backupProdutos();
                        break;
                    case 7:
                        System.out.println("\n\n ***PROGRAMA FINALIZADO COM SUCESSO***");
                        break;    
                }
                Auxiliares.pausa();
            } else {
                System.out.println(Auxiliares.opcaoMenuIncorreta);
            }
        }
    }
        
}
