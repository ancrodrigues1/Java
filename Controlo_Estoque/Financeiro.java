package Controlo_Estoque;

/**
 * @author Antonio
 */

public class Financeiro implements Cloneable{
    private int idProduto;
    private double vlCompra;
    private int iva;
    private double vlVenda;
    
    public Financeiro(int IdProduto, double VlCompra, int Iva, double VlVenda){
        this.idProduto = IdProduto;
        this.vlCompra = VlCompra;
        this.iva = Iva;
        this.vlVenda = VlVenda;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public double getVlCompra() {
        return vlCompra;
    }

    public void setVlCompra(double vlCompra) {
        this.vlCompra = vlCompra;
    }

    public int getIva() {
        return iva;
    }

    public void setIva(int iva) {
        this.iva = iva;
    }

    public double getVlVenda() {
        return vlVenda;
    }

    public void setVlVenda(double vlVenda) {
        this.vlVenda = vlVenda;
    }
    
    @Override
    public String toString(){
        return ", Valor Compra: "+vlCompra+", IVA: "+iva+", Valor Venda: "+vlVenda;
    }
    
    public void print(){
        System.out.println("Valor Compra: "+vlCompra);
        System.out.println("IVA: "+iva);
        System.out.println("Valor Venda: "+vlVenda);
    }
    
    @Override
    public Financeiro clone()throws CloneNotSupportedException{
        return (Financeiro) super.clone();
    }
}
