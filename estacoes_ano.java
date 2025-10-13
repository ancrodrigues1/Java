package ExercRevisaoFl01;

/**
 * @author Antonio
 */

import java.util.Scanner;

public class Exercicio02 {
    
    public static int mes =-1;
    public static int data= -1;
    public static boolean dtEscolhida = false;
    
    public static void escolherData(){
        Scanner scn = new Scanner(System.in);
        while(true){
            System.out.println("\n\n *********************** ");
            System.out.println(" *  SELECIONE O MES    * ");
            System.out.println(" *  1 - Janeiro        * ");
            System.out.println(" *  2 - Fevereiro      * ");
            System.out.println(" *  3 - Março          * ");
            System.out.println(" *  4 - Abril          * ");
            System.out.println(" *  5 - Maio           * ");
            System.out.println(" *  6 - Junho          * ");
            System.out.println(" *  7 - Julho          * ");
            System.out.println(" *  8 - Agosto         * ");
            System.out.println(" *  9 - Setembro       * ");
            System.out.println(" *  10 - Outubro       * ");
            System.out.println(" *  11 - Novembro      * ");
            System.out.println(" *  12 - Dezembro      * ");
            System.out.println(" *********************** ");
            System.out.print(" Digite a opção: ");
            if (scn.hasNextInt()){
                mes = scn.nextInt();
                if (mes>=1 && mes<=12){
                    break;
                } else {
                    System.out.println(" *Valor digitado inválido!*");
                }
            } else {
                System.out.println(" *Valor digitado inválido!*");
                scn.nextLine();
            }
        }
        while(true){
            System.out.print("\n Informe a data: ");
            if (scn.hasNextInt()){
                data = scn.nextInt();
                if(mes==1 || mes==3 || mes==5 || mes==7 || mes==8 || 
                        mes==10 || mes==12){
                    if (data>=1 && data<=31){
                        dtEscolhida = true;
                        break;
                    }
                }    
                if(mes==4 || mes==6 || mes==9 || mes==11){
                    if (data>=1 && data<=30){
                        dtEscolhida = true;
                        break;
                    }
                }
                if(mes==2 && (data>=1 && data<=29)){
                    dtEscolhida = true;
                    break;
                } 
                if (dtEscolhida == false) {
                    System.out.println(" *Esta data não existe!*");
                    break;
                }                
            } else {
                System.out.println(" *Data Inválida*");
                scn.nextLine();
            }
        }
    }
    
    public static void main(String[] args){
        int opc;
        boolean finalizado = false;
        Scanner scn = new Scanner(System.in);
        System.out.println("\n\n");
        while(!finalizado){
            System.out.println("\n\n     **Estações do Ano**");
            if(!dtEscolhida){
                System.out.println(" [1] Escolher Data");
            } else {
                System.out.println(" [1] Alterar Data          »»Data Selecionada: "+data+
                        "/"+mes);
            }
            System.out.println(" [2] Primavera");
            System.out.println(" [3] Verão");
            System.out.println(" [4] Outono");
            System.out.println(" [5] Inverno");
            System.out.println(" [6] Sair");
            while(true){
                System.out.print("  »» Selecione a opção: ");
                if(scn.hasNextInt()){
                    opc=scn.nextInt();
                    if(opc>=1 && opc<=6){
                        break;
                    } else {
                        System.out.println("  **Opção Inválida**");
                    }
                } else {
                    System.out.println("  **Opção Inválida**");
                    scn.nextLine();
                }
            }
            switch (opc){
                case 1:
                    escolherData();
                    break;
                case 2:
                    if(dtEscolhida==true){
                        if ((mes==3 && data>=20) || mes==4 || mes==5 || 
                                (mes==6 && data<=19)){
                            System.out.println(" **Estação Correta**");
                        } else {
                            System.out.println(" **Estação Incorreta**");
                        }
                        finalizado = true;
                    } else {
                        System.out.println(" **Esta opção so pode ser usada,"
                                + " apos escolher a data!!");
                    }
                    break;
                case 3:
                    if(dtEscolhida==true){
                        if ((mes==6 && data>=20) || mes==7 || mes==8 || 
                                (mes==9 && data<=21)){
                            System.out.println(" **Estação Correta**");
                        } else {
                            System.out.println(" **Estação Incorreta**");
                        }
                        finalizado = true;
                    } else {
                        System.out.println(" **Esta opção so pode ser usada,"
                                + " apos escolher a data!!");
                    }
                    break;
                case 4:
                    if(dtEscolhida==true){
                        if ((mes==9 && data>=22) || mes==10 || mes==11 || 
                                (mes==12 && data<=20)){
                            System.out.println(" **Estação Correta**");
                        } else {
                            System.out.println(" **Estação Incorreta**");
                        }
                        finalizado = true;
                    } else {
                        System.out.println(" **Esta opção so pode ser usada,"
                                + " apos escolher a data!!");
                    }
                    break;
                case 5:
                    if(dtEscolhida==true){
                        if ((mes==12 && data>=21) || mes==1 || mes==2 || 
                                (mes==3 && data<=19)){
                            System.out.println(" **Estação Correta**");
                        } else {
                            System.out.println(" **Estação Incorreta**");
                        }
                        finalizado = true;
                    } else {
                        System.out.println(" **Esta opção so pode ser usada,"
                                + " apos escolher a data!!");
                    }
                    break;
                case 6:
                    System.out.println(" ** Programa Finalizado!!**");
                    finalizado = true;
                    break;
            }
        }
    }
}
