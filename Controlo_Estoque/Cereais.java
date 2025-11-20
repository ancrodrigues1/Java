package Controlo_Estoque;

/**
 * @author Antonio
 */

public class Cereais extends Produtos{
    private double quantidade;
    private String unidade;
    private String tipo;
    
    public Cereais(long CodigoBarras, String Descricao, InfoExtras InfoExtras, Financeiro Financeiro, double Quantidade, String Tipo){
        super(CodigoBarras, Descricao, InfoExtras, Financeiro);
        this.quantidade = Quantidade;
        this.unidade = "LITROS";
        this.tipo = Tipo;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }

    public String getUnidade() {
        return unidade;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    @Override
    public String toString(){
        return super.toString()+", Quantidade: "+quantidade+", Unidade: "+unidade+
                ", Tipo: "+tipo+", "+super.toStringExtra();
    }
    
    @Override
    public void print(){
        super.print();
        System.out.println("Quantidade: "+quantidade);
        System.out.println("Unidade: "+unidade);
        System.out.println("Tipo: "+tipo);
        super.printExtra();
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this.getClass() != obj.getClass()){
            return false;
        } else {
            Cereais other = (Cereais) obj;
            return this.quantidade == other.quantidade;
        }
    }

    @Override
    public int hashCode() {
        return Double.hashCode(quantidade);
    }
}
