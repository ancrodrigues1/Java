package aula05;

/**
 * @author Antonio
 */

public class Maritimo extends Veiculo {
     private String tipo;
  
    public Maritimo() {
        this( "", "", 0, null, "");
    }
    public Maritimo(String Fabricante, String Modelo, int Ano, Motorizacao Motorizacao, String Tipo) {
        super(Fabricante, Modelo, Ano, Motorizacao);
        this.tipo = Tipo;
    }

    public String getTipo() {
        return tipo;
    }
    public void setTipo(String Tipo) {
        this.tipo = Tipo;
    }
    @Override
    public String toString(){
        return "MARITIMO("+tipo+") --> "+super.toString();
    }  
    
    @Override
    public void print(){
        System.out.println(" »VEICULO MARITIMO");
        System.out.println("Tipo: " + tipo );
        super.print(); 
    }
}
