package Controlo_Estoque;

/**
 * @author Antonio
 */

public class Produtos implements Cloneable{
    private static int cont = 1;
    private int idInterno;
    private long codigoBarras;
    private String descricao;
    private InfoExtras infoExtras;
    private Financeiro financeiro;
    
    public Produtos(long CodigoBarras, String Descricao, InfoExtras InfoExtras, Financeiro Financeiro){
        this.idInterno = cont;
        this.codigoBarras = CodigoBarras;
        this.descricao = Descricao;
        this.infoExtras = InfoExtras;
        this.financeiro = Financeiro;
        cont++;
    }

    public int getIdInterno() {
        return idInterno;
    }

    public long getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(long codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    @Override
    public String toString(){
        return "Id: "+idInterno+", Codigo de Barras: "+codigoBarras+", Descrição: "+descricao+financeiro.toString();
    }
    
    public String toStringExtra(){
        if(infoExtras != null){
            return infoExtras.toString();
        } else {
            return null;
        }
        
    }
    
    public void print(){
        System.out.println("Id: "+idInterno);
        System.out.println("Codigo de Barras: "+codigoBarras);
        System.out.println("Descrição: "+descricao);
        financeiro.print();
    }
    
    public void printExtra(){
        if (infoExtras != null){
            infoExtras.print();
        }
    }
   
    @Override
    public Produtos clone()throws CloneNotSupportedException{
        Produtos copia = (Produtos) super.clone();
        if(this.infoExtras != null){
            copia.infoExtras = this.infoExtras.clone();
        }
        copia.financeiro = this.financeiro.clone();
        return copia;
    }
}
