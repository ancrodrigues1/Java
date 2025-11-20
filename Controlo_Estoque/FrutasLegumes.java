package Controlo_Estoque;

/**
 * @author Antonio
 */

public class FrutasLegumes extends Produtos{
    private double quantidade;
    private String unidade;
    
    public FrutasLegumes(long CodigoBarras, String Descricao, InfoExtras InfoExtras, Financeiro Financeiro, double Quantidade){
        super(CodigoBarras, Descricao, InfoExtras, Financeiro);
        this.quantidade = Quantidade;
        this.unidade = "KILOS";
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
    
    @Override
    public String toString(){
        return super.toString()+", Quantidade: "+quantidade+", Unidade: "+unidade+", "+super.toStringExtra();
    }
    
    @Override
    public void print(){
        super.print();
        System.out.println("Quantidade: "+quantidade);
        System.out.println("Unidade: "+unidade);
        super.printExtra();
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this.getClass() != obj.getClass()){
            return false;
        } else {
            FrutasLegumes other = (FrutasLegumes) obj;
            return this.quantidade == other.quantidade;
        }
    }

    @Override
    public int hashCode() {
        return Double.hashCode(quantidade);
    }
}
