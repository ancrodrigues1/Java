package Controlo_Estoque;

/**
 * @author Antonio
 */

public class InfoExtras implements Cloneable{
    private int idProduto;
    private String fabricante;
    private String fornecedorPreferencial;
    private String observacao;
    
    public InfoExtras(int IdProduto, String Fabricante, String FornecedorPreferencial, String Observacao){
        this.idProduto = IdProduto;
        this.fabricante = Fabricante;
        this.fornecedorPreferencial = FornecedorPreferencial;
        this.observacao = Observacao;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getFornecedorPreferencial() {
        return fornecedorPreferencial;
    }

    public void setFornecedorPreferencial(String fornecedorPreferencial) {
        this.fornecedorPreferencial = fornecedorPreferencial;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
    
    @Override
    public String toString(){
        return ", Fabricante: "+fabricante+", Fornecedor Preferencial: "+fornecedorPreferencial+
                ", Observação: "+observacao;
    }
    
    public void print(){
        System.out.println("Fabricante: "+fabricante);
        System.out.println("Fornecedor Preferencial: "+fornecedorPreferencial);
        System.out.println("Observação: "+observacao);
    }
    
    @Override
    public InfoExtras clone()throws CloneNotSupportedException{
        return (InfoExtras) super.clone();
    }
}
