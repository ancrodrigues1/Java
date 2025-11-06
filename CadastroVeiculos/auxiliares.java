package aula05;

/**
 * @author Antonio
 */

import java.util.Scanner;

public class auxiliares {
    public static String opcaoMenuIncorreta = "\n\n *Valor digitado deve coindicir com as opções do menu.*\"";
    public static String registogravado = "\n\n Registo Gravado com sucesso!!";
    public static String registocnacelado= "\n\n Registo cancelado!!";
    public static String registoExcluido = "\n\n Registo excluido!!";
    public static String registoNaoEncontrado = "\n\n Registo não foi encotrado!!";
    
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
    
    public static String entradaString(String mensagem){
        Scanner scn = new Scanner(System.in);
        String nomeTemp="";
        while(true){
            System.out.print(mensagem);
            nomeTemp = scn.nextLine();
            if (nomeTemp.trim().isEmpty() || !nomeTemp.matches(".*[a-zA-Z].*")){
                System.out.println(" *Erro: Campo nome não pode ficar em branco e/ou deve ter letras!!");
            } else {
                break;
            }
        }
        return nomeTemp.toUpperCase();
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
