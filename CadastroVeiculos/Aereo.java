package aula05;

/**
 * @author Antonio
 */

public class Aereo extends Veiculo {
     private String tipo;
  
    public Aereo() {
        this( "", "", 0, null, "");
    }
    public Aereo(String Fabricante, String Modelo, int Ano, Motorizacao Motorizacao, String Tipo) {
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
        return "AEREO("+tipo+") --> "+super.toString();
    }  
    
    @Override
    public void print(){
        System.out.println(" »VEICULO AEREO");
        System.out.println("Tipo: " + tipo );
        super.print();
    }
}
