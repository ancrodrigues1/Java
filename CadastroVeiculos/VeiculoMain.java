package aula05;

/**
 * @author Antonio
 */

import java.util.Scanner;
import java.util.ArrayList;

public class VeiculoMain {
    public static ArrayList<Veiculo> veiculos = new ArrayList();
    public static ArrayList<Motorizacao> motor = new ArrayList();
    
    public static int tipoVeiculo(){
        int opcaoTipoVeiculo;
        while(true){
            System.out.println("\n\n***MENU TIPO TRANSPORTE***");
            System.out.println("* 1 - TERRESTRE          *");
            System.out.println("* 2 - MARITIMO           *");
            System.out.println("* 3 - AEREO              *");
            System.out.println("**************************");
            opcaoTipoVeiculo = auxiliares.entradaInt("Digite a opção: ");
            if (opcaoTipoVeiculo>=1 && opcaoTipoVeiculo<=3){
                break;
            } else {
                System.out.println(auxiliares.opcaoMenuIncorreta);
            }
            
        }
        return opcaoTipoVeiculo;
    }
    
    public static void incluir(int tipoVeiculo){
        Scanner scn = new Scanner(System.in);
        String tempTipo, tempFabricante, tempModelo, tempModeloMotor, tempNumeroSerieMotor;
        int tempAno, tempCilindradaMotor;
        boolean preencheMotor;
        System.out.print("\n Informe tipo de Veiculo ");
        switch (tipoVeiculo){
            case 1:
                System.out.print("(Exemplo: Carro, Onibus, Moto e etc): ");
                break;
            case 2: 
                System.out.print("(Exemplo: Iate, Navio, Canoa e etc): ");
                break;
            case 3:
                System.out.print("(Exemplo: Helicoptero, Planador, Comercial e etc): ");
                break;
        }
        tempTipo = auxiliares.entradaString("");
        tempFabricante = auxiliares.entradaString("\n Informe o Fabricante: ");
        tempModelo = auxiliares.entradaString("\n Informe o modelo do Veiculo: ");
        tempAno = auxiliares.entradaInt("\n Informe o ano do veiculo: ");
        if(auxiliares.respostaSN("\n Deseja incluir informações de motorização(s/n)? ")){
            tempModeloMotor = auxiliares.entradaString("\n Informe o modelo do Motor: ");
            tempCilindradaMotor = auxiliares.entradaInt("\n Informe a Cilindrada do Motor: ");
            tempNumeroSerieMotor = auxiliares.entradaString("\n Informe o numero de serie do Motor: ");
            motor.add(new Motorizacao(tempModeloMotor,tempNumeroSerieMotor,tempCilindradaMotor));
            preencheMotor = true;
        } else {
            preencheMotor = false;
        }
        if(auxiliares.respostaSN("\n\n Confirma a inclusão dos dados(s/n)?")){
            switch (tipoVeiculo){
                case 1:
                    if (preencheMotor){
                        veiculos.add(new Terrestre(tempFabricante, tempModelo, tempAno, motor.getLast(), tempTipo)); 
                    } else {
                        veiculos.add(new Terrestre(tempFabricante, tempModelo, tempAno, null,tempTipo));
                    }
                    break;
                case 2: 
                    if (preencheMotor){
                        veiculos.add(new Maritimo(tempFabricante, tempModelo, tempAno, motor.getLast(),tempTipo)); 
                    } else {
                        veiculos.add(new Maritimo(tempFabricante, tempModelo, tempAno, null, tempTipo));
                    }
                    break;
                case 3:
                    if (preencheMotor){
                        veiculos.add(new Aereo(tempFabricante, tempModelo, tempAno, motor.getLast(), tempTipo)); 
                    } else {
                        veiculos.add(new Aereo(tempFabricante, tempModelo, tempAno, null, tempTipo));
                    }
                    break;                    
            }
            System.out.println(auxiliares.registogravado);
            auxiliares.pausa();
        } else {
            motor.removeLast();
            System.out.println(auxiliares.registocnacelado);
            auxiliares.pausa();
        }
    }
    
    public static void excluir(){
        Scanner scn = new Scanner(System.in);
        boolean idencontrado = false;
        int idExcluir = auxiliares.entradaInt("\n\n Informe ID do veiculo a ser excluido: ");
        for (int i = 0; i < veiculos.size(); i++){
            if (veiculos.get(i).getIdVeiculo() == idExcluir){
                int idMotorizacaoExcluir = veiculos.get(i).getMotorizacao().getIdMotorizacao();
                veiculos.remove(i);
                for (int m = 0; m < motor.size(); m++){
                    if (motor.get(m).getIdMotorizacao() == idMotorizacaoExcluir){
                        motor.remove(m);
                        break;
                    }
                }
                System.out.println(auxiliares.registoExcluido);
                idencontrado = true;
                break;
            } else {
                idencontrado = false;
            }
        }
        if (!idencontrado){
            System.out.println(auxiliares.registoNaoEncontrado);
        }
        auxiliares.pausa();
    }
    
    public static void consultar(){
        Scanner scn = new Scanner(System.in);
        int indexObjetoConsulta=-1;
        int idConsultar = auxiliares.entradaInt("\n\n Informe ID do veiculo a ser Consultado: ");
        for (int i = 0; i < veiculos.size(); i++){
            if (veiculos.get(i).getIdVeiculo() == idConsultar){
                indexObjetoConsulta = i;
            }
        }
        if(indexObjetoConsulta>=0){
            veiculos.get(indexObjetoConsulta).print();
        } else {
            System.out.println(auxiliares.registoNaoEncontrado);
        }
        auxiliares.pausa();
    }
    
    public static void listar(){
        for(int i = 0; i<veiculos.size(); i++){
            System.out.println(veiculos.get(i).toString());
        }
        auxiliares.pausa();
    }
    
    public static void main(String[] args) {
        int opcaoPrincipal = 0;
        while(opcaoPrincipal!=5){
            System.out.println("******MENU PRINCIPAL******");
            System.out.println("* 1 - INCLUIR VEICULO    *");
            System.out.println("* 2 - EXCLUIR VEICULO    *");
            System.out.println("* 3 - CONSULTAR VEICULO  *");
            System.out.println("* 4 - LISTA VEICULOS     *");
            System.out.println("* 5 - SAIR               *");
            System.out.println("**************************");
            opcaoPrincipal = auxiliares.entradaInt("Digite a opção: ");
            if (opcaoPrincipal>=1 && opcaoPrincipal<=5){
                switch (opcaoPrincipal){
                    case 1:
                        incluir(tipoVeiculo());
                        break;

                    case 2:
                        excluir();
                        break;

                    case 3:
                        consultar();
                        break;

                    case 4:
                        listar();
                        break;

                    case 5:
                        System.out.println("\n *Programna Encerrado!!!!*");
                        break;
                }
            } else {
                System.out.println(auxiliares.opcaoMenuIncorreta);
                opcaoPrincipal = 0;
            }
        } 
    }
}
