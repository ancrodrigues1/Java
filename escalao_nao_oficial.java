package ExercRevisaoFl01;

/**
 * @author Antonio
 */

// Dados de IRS não oficiais, dados para simples estudo e conhecimento de programação

import java.util.Scanner;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Exercicio03 {
    public static BigDecimal rendimento;
    public static boolean rendaPreenchida;
    
    public static void informeRendimento(){
        Scanner scn = new Scanner(System.in);
        while(true){
            System.out.print("\n\n  »Informe rendimento: ");
            if (scn.hasNextDouble()){
                rendimento = scn.nextBigDecimal();
                rendimento = rendimento.setScale(2,RoundingMode.HALF_UP);
                if (rendimento.compareTo(BigDecimal.ZERO) > 0){
                    rendaPreenchida = true;
                    break;
                } else {
                    System.out.println("\n **Erro: Renda dever ser um numero positivo!**");
                }
            } else {
                System.out.println("\n **Erro: Renda deve ser um valor numerico!!**");
                scn.nextLine();
            }
        }
    }
    
    public static void escalao(int escalao){
        BigDecimal margemSuperior = BigDecimal.ZERO;
        BigDecimal margemInferior = BigDecimal.ZERO;
        BigDecimal taxa = BigDecimal.ZERO;
        BigDecimal adicional = BigDecimal.ZERO;
        String porcentagem="";
        switch (escalao){
            case 1:
                margemInferior = new BigDecimal ("0");
                margemSuperior = new BigDecimal ("7000");
                taxa = new BigDecimal("0.145");
                porcentagem="14,5%";
                break;
            case 2:
                margemInferior = new BigDecimal ("7000");
                margemSuperior = new BigDecimal ("20000");
                taxa = new BigDecimal("0.285");
                porcentagem="28,5%";
                break;
            case 3:
                margemInferior = new BigDecimal ("20000");
                margemSuperior = new BigDecimal ("40000");
                taxa = new BigDecimal("0.37");
                porcentagem="37%";
                break;
            case 4:
                margemInferior = new BigDecimal ("40000");
                margemSuperior = new BigDecimal ("80000");
                taxa = new BigDecimal("0.45");
                porcentagem="45%";
                break;
            case 5:
                margemInferior = new BigDecimal ("80000");
                margemSuperior = new BigDecimal ("9999999999999999999999999999999999999999999999");
                taxa = new BigDecimal("0.48");
                porcentagem="48%";
                break;
        }
        if(rendimento.compareTo(margemInferior) >= 0 && rendimento.compareTo(margemSuperior) < 0){
            System.out.println("\n **Escalão Correto**");
            System.out.println("»Calculo Imposto a Pagar:");
            System.out.println("  Rendimento Informado: "+rendimento+"€");
            BigDecimal txImposto = rendimento.multiply(taxa).setScale(2, RoundingMode.HALF_UP);
            System.out.println("  Taxa de Imposto "+porcentagem+" : "+txImposto+"€");
            BigDecimal sobretaxa = rendimento.multiply(new BigDecimal("0.035")).setScale(2, RoundingMode.HALF_UP);
            System.out.println("  Sobretaxa 3,5%: "+sobretaxa+"€");
            if (escalao == 5){
                adicional = rendimento.multiply(new BigDecimal("0.025")).setScale(2, RoundingMode.HALF_UP);
                System.out.println("  Taxa Adicional 2,5%: "+adicional);
            }
            System.out.println("    »»TOTAL A SER PAGO: "+(rendimento.add(sobretaxa).add(txImposto).add(adicional))+"€");
        } else {
            System.out.println("\n **Escalão Incorreto**");
        }
        System.out.println("\n\n  **FIM DO PROGRAMA**");
    }
    
    public static void main (String[] args){
        Scanner scn = new Scanner(System.in);
        int opc;
        boolean finalizado = false;
        System.out.println("\n\n");
        while(!finalizado){
            System.out.println("\n\n     **IRS**");
            if(!rendaPreenchida){
                System.out.println(" [1] Inserir Rendimento");
            } else {
                System.out.println(" [1] Alterar Rendimento          »»Rendimento informado: "+rendimento+"€");
            }
            System.out.println(" [2] Taxa de 14,5% - Escalão 01");
            System.out.println(" [3] Taxa de 28,5% - Escalão 02");
            System.out.println(" [4] Taxa de 37% - Escalão 03");
            System.out.println(" [5] Taxa de 45% - Escalão 04");
            System.out.println(" [6] Taxa de 48% - Escalão 05");
            System.out.println(" [7] Sair");
            while(true){
                System.out.print("  »» Selecione a opção: ");
                if(scn.hasNextInt()){
                    opc=scn.nextInt();
                    if(opc>=1 && opc<=7){
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
                    informeRendimento();
                    break;
                case 2:
                    if (rendaPreenchida){
                        escalao(1);
                        finalizado=true;
                    } else {
                        System.out.println("\n **Erro: Essa opção depende do rendimento ter sido preenchida!!**");
                    }
                    break;
                case 3:
                    if (rendaPreenchida){
                        escalao(2);
                        finalizado=true;
                    } else {
                        System.out.println("\n **Erro: Essa opção depende do rendimento ter sido preenchida!!**");
                    }
                    break;
                case 4:
                    if (rendaPreenchida){
                        escalao(3);
                        finalizado=true;
                    } else {
                        System.out.println("\n **Erro: Essa opção depende do rendimento ter sido preenchida!!**");
                    }
                    break;
                case 5:
                    if (rendaPreenchida){
                        escalao(4);
                        finalizado=true;
                    } else {
                        System.out.println("\n **Erro: Essa opção depende do rendimento ter sido preenchida!!**");
                    }
                    break; 
                case 6:
                    if (rendaPreenchida){
                        escalao(5);
                        finalizado=true;
                    } else {
                        System.out.println("\n **Erro: Essa opção depende do rendimento ter sido preenchida!!**");
                    }
                    break;  
                case 7:
                    System.out.println("\n\n  **Programa Finalizado**");
                    finalizado=true;
            }
        }    
    }
}
