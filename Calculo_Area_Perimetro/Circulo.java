package Exercicio1_Proj5;

/**
 * @author Antonio
 */

public class Circulo extends Forma{
    private double raio;
    
    public Circulo(double Raio){
        raio = Raio;
    }

    public double getRaio() {
        return raio;
    }
    
    public void setRaio(double raio) {
        this.raio = raio;
    }
    
    @Override
    public double calcArea(){
        return (3.14*(raio*raio));
    }
    
    @Override
    public double calcPerimetro(){
        return (2*3.14*raio);
    }
    
    @Override
    public void print(){
        super.print();
        System.out.println(String.format(" A Area do Circulo e: %.2f",+calcArea()));
        System.out.println(String.format(" O Perimetro do Circulo e: %.2f",+calcPerimetro()));
    }
}
