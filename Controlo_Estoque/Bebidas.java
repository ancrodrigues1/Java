package Controlo_Estoque;

/**
 * @author Antonio
 */

public class Bebidas extends Produtos{
    private double quantidade;
    private String unidade;
    private String tipo;
    private boolean vendaProibida18;
    
    public Bebidas(){
        this(0, "", null, null, 0.0, "", false);
    }
    
    public Bebidas (long CodigoBarras, String Descricao, InfoExtras InfoExtras, Financeiro Financeiro, double Quantidade, String Tipo, 
            boolean VendaProibida18){
        super(CodigoBarras, Descricao, InfoExtras, Financeiro);
        this.quantidade = Quantidade;
        this.unidade = "LITROS";
        this.tipo = Tipo;
        this.vendaProibida18 = VendaProibida18;
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

    public boolean isVendaProibida18() {
        return vendaProibida18;
    }

    public void setVendaProibida18(boolean vendaProibida18) {
        this.vendaProibida18 = vendaProibida18;
    }
    
    @Override
    public String toString(){
        String resposta = "NÃO";
        if (vendaProibida18 == true){
            resposta = "SIM";
        }
        return super.toString()+", Quantidade: "+quantidade+", Unidade: "+unidade+
                ", Tipo: "+tipo+", Venda Proibida menores 18: "+resposta+", "+super.toStringExtra();
    }
    
    @Override
    public void print(){
        String resposta = "NÃO";
        if (vendaProibida18 == true){
            resposta = "SIM";
        }
        super.print();
        System.out.println("Quantidade: "+quantidade);
        System.out.println("Unidade: "+unidade);
        System.out.println("Tipo: "+tipo);
        System.out.println("Venda Proibida Menor 18 anos: "+resposta);
        super.printExtra();
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this.getClass() != obj.getClass()){
            return false;
        } else {
            Bebidas other = (Bebidas) obj;
            return this.quantidade == other.quantidade;
        }
    }

    @Override
    public int hashCode() {
        return Double.hashCode(quantidade);
    }
}
