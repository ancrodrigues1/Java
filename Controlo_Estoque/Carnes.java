package Controlo_Estoque;

/**
 * @author Antonio
 */

public class Carnes extends Produtos {
    private double quantidade;
    private String unidade;
    private String animal;
    
    public Carnes(long CodigoBarras, String Descricao, InfoExtras InfoExtras, Financeiro Financeiro, double Quantidade, String Animal){
        super(CodigoBarras, Descricao, InfoExtras, Financeiro);
        this.quantidade = Quantidade;
        this.unidade = "KILOS";
        this.animal = Animal;
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

    public String getAnimal() {
        return animal;
    }

    public void setAnimal(String animal) {
        this.animal = animal;
    }
    
    @Override
    public String toString(){
        return super.toString()+", Quantidade: "+quantidade+", Unidade: "+unidade+
                ", Animal: "+animal+", "+super.toStringExtra();
    }
    
    @Override
    public void print(){
        super.print();
        System.out.println("Quantidade: "+quantidade);
        System.out.println("Unidade: "+unidade);
        System.out.println("Animal: "+animal);
        super.printExtra();
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this.getClass() != obj.getClass()){
            return false;
        } else {
            Carnes other = (Carnes) obj;
            return this.quantidade == other.quantidade;
        }
    }

    @Override
    public int hashCode() {
        return Double.hashCode(quantidade);
    }
}
