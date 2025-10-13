
package Exercicio03;

/**
 * @author Antonio
 */

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

class Dados<N,A extends Number,P extends Number, I extends Number>{
    N nome;
    A altura;
    P peso;
    I idade;
    
    public Dados(N Nome, A Altura, P Peso, I Idade){
        this.nome = Nome;
        this.altura = Altura;
        this.peso = Peso;
        this.idade = Idade;
    }

    public N getNome() {
        return nome;
    }

    public A getAltura() {
        return altura;
    }

    public P getPeso() {
        return peso;
    }

    public I getIdade() {
        return idade;
    }

    public void setNome(N nome) {
        this.nome = nome;
    }

    public void setAltura(A altura) {
        this.altura = altura;
    }

    public void setPeso(P peso) {
        this.peso = peso;
    }

    public void setIdade(I idade) {
        this.idade = idade;
    }
    
    public double IMC(){
        return (peso.doubleValue()/(altura.doubleValue()*altura.doubleValue()));
    }
    
    @Override
    public String toString() { 
        return "\n Dados: Nome = " + nome + 
                "\n        Altura = " + altura + 
                "\n        Peso = " + peso +
                "\n        Idade = " + idade +
                String.format("\n        IMC (Indice Massa Corporal) = %.2f",
                        (peso.doubleValue()/(altura.doubleValue()*altura.doubleValue())));
    }
}

class tabelaIMC{
    static double[][] imcMenino={
        {5.0, 13.8, 17.4, 19.2}, //idade, peso normel, sobrepeso, obesidade
        {6.0, 13.9, 17.8, 19.8},
        {7.0, 14.0, 18.4, 20.4},
        {8.0, 14.1, 19.0, 21.0},
        {9.0, 14.2, 19.6, 21.8},
        {10.0, 14.3, 20.3, 22.7},
        {11.0, 14.5, 21.0, 23.5},
        {12.0, 14.8, 21.8, 24.3},
        {13.0, 15.2, 22.6, 25.1},
        {14.0, 15.6, 23.4, 25.9},
        {15.0, 16.0, 24.0, 26.6},
        {16.0, 16.4, 24.6, 27.2},
        {17.0, 16.8, 25.2, 27.8} 
    };
    
    static double[][] imcMenina = {
        {5.0, 13.6, 17.2, 19.0}, //idade, peso normel, sobrepeso, obesidade
        {6.0, 13.8, 17.6, 19.6},
        {7.0, 14.0, 18.2, 20.2},
        {8.0, 14.2, 18.8, 20.8},
        {9.0, 14.3, 19.4, 21.5},
        {10.0, 14.5, 20.1, 22.3},
        {11.0, 14.7, 20.9, 23.1},
        {12.0, 15.0, 21.8, 24.0},
        {13.0, 15.4, 22.6, 24.8},
        {14.0, 15.8, 23.3, 25.6},
        {15.0, 16.2, 23.9, 26.2},
        {16.0, 16.6, 24.5, 26.8},
        {17.0, 17.0, 25.0, 27.4}
    };
    
    static double[] imcAdulto = {18.5, 25.0, 30.0, 35.0, 40.0};
}

public class exercicion01 {
    
    public static double entradaDouble(String mensagem){
        Scanner scn = new Scanner(System.in);
        double valorTemp = 0.0;
        while(true){
            System.out.print(mensagem);
            if(scn.hasNextDouble()){
                valorTemp = scn.nextDouble();
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
        return nomeTemp;
    }
    
    public static String verificacaoObesidade(double imc, int idade){
        Scanner scn = new Scanner(System.in);
        if(idade<5){
            return "Crianças menores que 5 anos dependem de acompanhamento médico para indicar obesidade!";
        } else {
            if (idade < 18){
                System.out.println("         »Em crianças e necessário conhecer o sexo para identificar obesidade.");
                int idadeIndice=-1;
                String sexo="";
                while(true){
                    System.out.print("         Informe Sexo da criança(Masculino ou Feminino): ");
                    sexo = scn.nextLine().trim().toLowerCase();
                    if (sexo.equalsIgnoreCase("masculino") || sexo.equalsIgnoreCase("feminino")){
                        break;
                    } else {
                        System.out.println("          *Erro: Sexo não reconhecido, digite novamente!!");
                    }
                }    
                if (sexo.equalsIgnoreCase("masculino")){
                    for (int i=0; i<tabelaIMC.imcMenino.length;i++){
                        if (tabelaIMC.imcMenino[i][0] == idade){
                            idadeIndice=i;
                        }
                    }
                    if (idadeIndice==-1){
                        return "          **Erro idade criança, contacte administrador do sistema!";
                    } else {                        
                        if (imc < tabelaIMC.imcMenino[idadeIndice][1]){
                            return "IMC abaixo do esperado!!";
                        } else if (imc < tabelaIMC.imcMenino[idadeIndice][2]){
                            return "IMC dentro do esperado!!";
                        } else if (imc < tabelaIMC.imcMenino[idadeIndice][3]){
                            return "IMC indica Sobrepeso!";
                        } else {
                            return "IMC indica Obesidade!!!";
                        }
                    }    
                } else {
                    for (int i=0; i<tabelaIMC.imcMenina.length;i++){
                        if (tabelaIMC.imcMenina[i][0] == idade){
                            idadeIndice=i;
                        }
                    }
                    if (idadeIndice==-1){
                        return "          **Erro idade criança, contacte administrador do sistema!";
                    } else {
                        if (imc < tabelaIMC.imcMenina[idadeIndice][1]){
                            return "IMC abaixo do esperado!!";
                        } else if (imc < tabelaIMC.imcMenina[idadeIndice][2]){
                            return "IMC dentro do esperado!!";
                        } else if (imc < tabelaIMC.imcMenina[idadeIndice][3]){
                            return "IMC indica Sobrepeso!";
                        } else {
                            return "IMC indica Obesidade!!!";
                        }
                    }    
                }
            } else {
                if (imc<tabelaIMC.imcAdulto[0]){
                    return "IMC abaixo do esperado!!";
                } else if (imc<tabelaIMC.imcAdulto[1]){
                    return "IMC dentro do esperado!!";
                } else if (imc<tabelaIMC.imcAdulto[2]){
                    return "IMC indica excesso de Peso!";
                } else if (imc<tabelaIMC.imcAdulto[3]){
                    return "IMC indica obesidade Grau 1!";
                } else if (imc<tabelaIMC.imcAdulto[4]){
                    return "IMC indica obesidade Grau 2!";
                } else {
                    return "IMC indica obesidade Grau 3!";
                }
            }
        }
    }
    
    public static void main(String[] args){
        System.out.println("\n\n      »» Calculadora Indice Corporal (IMC)««\n");
        String nomeTmp = entradaString(" Informe seu nome: ");
        double pesoTmp = entradaDouble(" Informe seu peso: ");
        double alturaTmp = entradaDouble(" Informe sua altura: ");
        int idadeTmp = entradaInt(" Informe sua idade: ");
        
        List<Dados> calcIMC = new ArrayList<>();
        calcIMC.add(new Dados(nomeTmp,alturaTmp,pesoTmp,idadeTmp));
        System.out.println(calcIMC.get(0).toString());
        System.out.println("           »» "+verificacaoObesidade(calcIMC.get(0).IMC(),calcIMC.get(0).idade.intValue()));
        System.out.println("\n\n Os valores para determinar obesidade são estimativas da OMS, "
                + "para um diagnostico preciso, procure seu médico!!!");
        System.out.println("\n       **** FIM PROGRAMA****");
    }
}
