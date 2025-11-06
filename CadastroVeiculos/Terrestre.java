package aula05;

/**
 * @author Antonio
 */

public class Terrestre extends Veiculo {
    private String tipo;
  
    public Terrestre() {
        this( "", "", 0, null, "");
    }
    public Terrestre(String Fabricante, String Modelo, int Ano, Motorizacao Motorizacao, String Tipo) {
        super(Fabricante, Modelo, Ano , Motorizacao);
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
        return "TERRESTRE("+tipo+") --> "+super.toString();
    }
    
    @Override
    public void print(){
        System.out.println(" »VEICULO TERRESTRE");
        System.out.println("Tipo  : " + tipo );
        super.print();
    }
}
