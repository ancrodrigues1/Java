package Exercicio1_Proj5;

/**
 * @author Antonio
 */

public class Quadrado extends Forma {
    private double lado;
    
    public Quadrado(double Lado){
        lado = Lado;
    }

    public double getLado() {
        return lado;
    }

    public void setRaio(double Lado) {
        this.lado = Lado;
    }
    
    @Override
    public double calcArea(){
        return (lado*lado);
    }
    
    @Override
    public double calcPerimetro(){
        return (4*lado);
    }
    
    @Override
    public void print(){
        super.print();
        System.out.println(String.format(" A Area do Quadrado e: %.2f",+calcArea()));
        System.out.println(String.format(" O Perimetro do Quadrado e: %.2f",+calcPerimetro()));
    }
}
