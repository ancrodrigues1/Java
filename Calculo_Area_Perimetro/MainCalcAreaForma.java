package Exercicio1_Proj5;

/**
 * @author Antonio
 */

import java.util.Scanner;

public class MainCalcAreaForma {
    
    public static boolean validaTriangulo(double lado1, double lado2, double lado3){
        if(lado1+lado2>lado3 && lado1+lado3>lado2 && lado2+lado3>lado1){
            return true;
        } else {
            return false;
        }
    }
    
    public static void main (String[] args){
        int opcao;
        System.out.println("\n\n    **Calculo Area e Perimetro**");
        while(true){
            System.out.println("****ESCCOLHA A FORMA****");
            System.out.println("* 1 - CIRCULO          *");
            System.out.println("* 2 - QUADRADO         *");
            System.out.println("* 3 - TRIANGULO        *");
            System.out.println("************************");
            opcao = Auxiliares.entradaInt("Informe a opção: ");
            if (opcao >=1 && opcao <=3){
                break;
            } else {
                System.out.println(Auxiliares.opcaoMenuIncorreta);
            }
        }
        switch(opcao){
            case 1:
                System.out.println("\n  »»Calculo Circulo");
                double raio = Auxiliares.entradaDouble("Informe o raio do Circulo: ");
                Forma circulo = new Circulo(raio);
                circulo.print();
                break;
            case 2:
                System.out.println("\n  »»Calculo Quadrado");
                double lado = Auxiliares.entradaDouble("Informe o lado do Quadrado: ");
                Forma quadrado = new Quadrado(lado);
                quadrado.print();
                break;
            case 3:
                System.out.println("\n  »»Calculo Triangulo");
                double lado1 = Auxiliares.entradaDouble("Informe o primeiro lado do Triangulo: ");
                double lado2 = Auxiliares.entradaDouble("Informe o segundo lado do Triangulo: ");
                double lado3 = Auxiliares.entradaDouble("Informe o terceiro lado do Triangulo: ");
                if (validaTriangulo(lado1, lado2, lado3)){
                    Forma triangulo = new AreaTriangulo(lado1, lado2, lado3);
                    triangulo.print();
                } else {
                    System.out.println(Auxiliares.trianguloInvalido);
                }
                
                break;
        }
        Auxiliares.pausa();
    }
}
