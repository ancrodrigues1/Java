package ExercRevisaoFl01;

/**
 *
 * @author Antonio
 */

import java.util.Scanner;

public class Exercicio01 {
    public static void main (String[] args){
        Scanner scn = new Scanner(System.in);
        int opc, num1,num2;
        System.out.println("\n   CALCULADORA");
        while(true){
            System.out.print("\n Informe Primeiro Operando: ");
            if (scn.hasNextInt()){
                num1 = scn.nextInt();
                if (num1>=0){
                    break;
                } else {
                    System.out.println("  *Numero informado deve ser nulo ou positivo*");
                }
            } else {
                System.out.println("  *Numero informado deve um numero inteiro válido*");
                scn.nextLine();
            }    
        }
        scn.nextLine();
        System.out.println("\n\n Informe a operação a ser Executada:");
        System.out.println(" 1 - Soma");
        System.out.println(" 2 - Subtração");
        System.out.println(" 3 - Divisão");
        System.out.println(" 4 - Multiplicação");
        while(true){
            System.out.print("   Digite a opção(1-4): ");
            if (scn.hasNextInt()){
                opc = scn.nextInt();
                if (opc>0 && opc<5){
                    break;
                } else {
                    System.out.println("  *Numero informado não corresponde a opção válida*");
                }
            } else {
                System.out.println("  *Numero informado fora dos parametros!*");
                scn.nextLine();
            }
        }
        scn.nextLine();
        while(true){
            System.out.print("\n Informe Segundo Operando: ");
            if (scn.hasNextInt()){
                num2 = scn.nextInt();
                if (num2>=0){
                    break;
                } else {
                    System.out.println("  *Numero informado deve ser nulo ou positivo*");
                }
            } else {
                System.out.println("  *Numero informado deve um numero inteiro válido*");
                scn.nextLine();
            }    
        }        
        switch (opc){
            case 1:
                System.out.println("\n\n »» Resultado da Soma e: "+(num1+num2));
                break;
                
            case 2:
                if (num1>=num2){
                    System.out.println("\n\n »» Resultado da Subtração e: "+(num1-num2));
                    break;
                } else {
                    System.out.println("\n\n ERRO: Para realizar a subtração o primeiro operando"
                            + " deve ser maior ou igual ao segundo operando");
                    break;
                }
                
            case 3:
                 if (num2!=0){
                    //double Result = num1/num2;
                    System.out.println("\n\n »» Resultado da Divisão Inteira e: "+(num1/num2));
                    if (num1%num2!=0){
                        System.out.println("   » Resto da Divisão e: "+(num1%num2));
                        System.out.printf("\n »» Resultado da Divisão: %.4f\n",(double)num1/num2);
                    }

                    break;
                } else {
                    System.out.println("\n\n ERRO: Para realizar a divisão o segundo operando"
                            + " deve ser diferente de zero ");
                    break;
                }
                 
            case 4:
                System.out.println("\n\n »» Resultado da Multiplicação e: "+(num1*num2));
                break;
        }   
    }    
}
