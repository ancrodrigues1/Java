package Exercicio1_Proj5;

import java.util.Scanner;

/**
 * @author Antonio
 */

public class Auxiliares {
    public static String opcaoMenuIncorreta = "\n\n *Valor digitado deve coindicir com as opções do menu.*";
    public static String trianguloInvalido = "\n\n *Os lados informados não correspondem a um triangulo válido.*";
    
    public static void pausa(){
        Scanner scn = new Scanner(System.in);
        System.out.println("\n ***Clique em Enter para continuar...***\n");
        scn.nextLine();
    }
    
    public static int entradaInt(String mensagem){
        Scanner scn = new Scanner(System.in);
        int valorTemp = 0;
        while(true){
            System.out.print(mensagem);
            if(scn.hasNextInt()){
                valorTemp = scn.nextInt();
                if (valorTemp>0){
                    break;
                } else {
                    System.out.println("\n *Erro: Valor deve ser maior que zero.");
                }
            } else {
                System.out.println("\n *Erro: Entrada inválida!!.");
                scn.nextLine();
            }
        }
        return valorTemp;
    }
    
    public static double entradaDouble(String mensagem){
        Scanner scn = new Scanner(System.in);
        double valorTemp = 0.0;
        while(true){
            System.out.print(mensagem);
            if(scn.hasNextDouble()){
                valorTemp = scn.nextDouble();
                if (valorTemp>0.0){
                    break;
                } else {
                    System.out.println("\n *Erro: Valor deve ser maior que zero.");
                }
            } else {
                System.out.println("\n *Erro: Entrada inválida!!.");
                scn.nextLine();
            }
        }
        return valorTemp;
    }
    
    public static boolean respostaSN(String mensagem){
        Scanner scn = new Scanner(System.in);
        String respostaTemp="";
        boolean resultado;
        while(true){
            System.out.print(mensagem);
            respostaTemp = scn.nextLine();
            respostaTemp = respostaTemp.trim().toUpperCase();
            if (respostaTemp.equalsIgnoreCase("S")){
                resultado=true;
                break;
            } else if (respostaTemp.equalsIgnoreCase("N")) {
                resultado=false;
                break;
            } else {
                System.out.println(" *Erro: resposta deve ser S ou N, tente novamente.");
            }
        }
        return resultado;
    }
}
