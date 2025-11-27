package Exercicio1_Proj5;

/**
 * @author Antonio
 */

public class AreaTriangulo extends Triangulo {
    
    public AreaTriangulo (double Lado1, double Lado2, double Lado3){
        super(Lado1, Lado2, Lado3);
    }
    
    public double calcIsosceles(){
        double lado1 = super.getLado1();
        double lado2 = super.getLado2();
        double lado3 = super.getLado3();
        double altura;
        if(lado1==lado2){
            altura = Math.sqrt((lado1*lado1)-((lado3*lado3)/4));
            return ((lado3*altura)/2);
        } else if (lado1==lado3){
            altura = Math.sqrt((lado1*lado1)-((lado2*lado2)/4));
            return ((lado2*altura)/2);
        } else {
            altura = Math.sqrt((lado2*lado2)-((lado1*lado1)/4));
            return ((lado1*altura)/2);
        }
    }
    
    public double calcEscaleno(){
        double lado1 = super.getLado1();
        double lado2 = super.getLado2();
        double lado3 = super.getLado3();
        double sp = super.calcPerimetro()/2;
        return (Math.sqrt(sp * (sp - lado1) * (sp - lado2) * (sp - lado3)));
    }
    
    public double calcEquilatero(){
        double altura = (Math.sqrt(3)/2)*super.getLado1();
        return ((altura*super.getLado1())/2);
    }
    
    public double resultado(String tipoTriangulo){
        if (tipoTriangulo.equals("Isosceles")){
            return calcIsosceles();
        } else if (tipoTriangulo.equals("Escaleno")){
            return calcEscaleno();
        } else {
            return calcEquilatero();
        }
    }
    
    @Override
    public double calcArea(){
        return resultado(super.getTipoTriangulo());
    }
    
    @Override
    public void print(){
        super.print();
        System.out.println(String.format(" A Area do Triangulo e: %.2f", calcArea()));
    }
}
