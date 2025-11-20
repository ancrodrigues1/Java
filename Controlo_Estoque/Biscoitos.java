package Controlo_Estoque;

/**
 * @author Antonio
 */

public class Biscoitos extends Produtos{
    private int quantidade;
    private String unidade;
    private String tipo;
    
    public Biscoitos(long CodigoBarras, String Descricao, InfoExtras InfoExtras, Financeiro Financeiro, int Quantidade, String Tipo){
        super(CodigoBarras, Descricao, InfoExtras, Financeiro);
        this.quantidade = Quantidade;
        this.unidade = "PACOTES";
        this.tipo = Tipo;
    } 

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
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
            Biscoitos other = (Biscoitos) obj;
            return this.quantidade == other.quantidade;
        }
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(quantidade);
    }
}
