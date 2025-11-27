package Exercicio1_Proj5;

/**
 * @author Antonio
 */

abstract class Triangulo extends Forma {
    private double lado1;
    private double lado2;
    private double lado3;
    
    public Triangulo(double Lado1, double Lado2, double Lado3){
        lado1 = Lado1;
        lado2 = Lado2;
        lado3 = Lado3;
    }

    public double getLado1() {
        return lado1;
    }

    public void setLado1(double lado1) {
        this.lado1 = lado1;
    }

    public double getLado2() {
        return lado2;
    }

    public void setLado2(double lado2) {
        this.lado2 = lado2;
    }

    public double getLado3() {
        return lado3;
    }

    public void setLado3(double lado3) {
        this.lado3 = lado3;
    }
    
    public String getTipoTriangulo() {
        return TpTriangulo();
    }
    
    public String TpTriangulo(){
        if (lado1==lado2 && lado2==lado3 && lado1==lado3){
            return "Equilatero";
        } else if ((lado1==lado2 && lado2!=lado3) || (lado1!=lado2 && lado2==lado3)){
            return "Isosceles";
        } else {
            return "Escaleno";
        }
    }
    
    @Override
    abstract double calcArea();
    
    @Override
    public double calcPerimetro(){
        return (lado1+lado2+lado3);
    }
    
    @Override
    public void print(){
        super.print();
        System.out.println(" Este e um Triangulo: "+TpTriangulo());
        System.out.println(String.format(" O Perimetro do Triangulo e: %.2f",+calcPerimetro()));
    }
}
