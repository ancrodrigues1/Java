package Controlo_Estoque;

/**
 * @author Antonio
 */

public class MovimentosEstoque {
    private int idInternoProduto;
    private double quantidade;
    private String tipoMovimento;
    
    public MovimentosEstoque(int IdInternoProduto, double Quantidade, String TipoMovimento){
        this.idInternoProduto = IdInternoProduto;
        this.quantidade = Quantidade;
        this.tipoMovimento = TipoMovimento;
    }

    public int getIdInternoProduto() {
        return idInternoProduto;
    }

    public void setIdInternoProduto(int idInternoProduto) {
        this.idInternoProduto = idInternoProduto;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }

    public String getTipoMovimento() {
        return tipoMovimento;
    }

    public void setTipoMovimento(String tipoMovimento) {
        this.tipoMovimento = tipoMovimento;
    }
    
    @Override
    public String toString(){
        return " Id produto: "+idInternoProduto+", Quantidade Movimentada: "+quantidade+
                ", Motivo Movimento: "+tipoMovimento;
    }
}
