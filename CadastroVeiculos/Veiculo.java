package aula05;

/**
 * @author Antonio
 */

public class Veiculo {
    private static int cont = 0;
    private int idVeiculo;
    private String fabricante;
    private String modelo;
    private int ano;
    private Motorizacao motorizacao;
  
    public Veiculo() {
        this("", "", 0 , null);
    }
    public Veiculo(String Fabricante, String Modelo, int Ano, Motorizacao Motorizacao) {
        this.fabricante = Fabricante;
        this.modelo = Modelo;
        this.ano = Ano;
        this.motorizacao = Motorizacao;
        cont++;
        this.idVeiculo = cont;
    }

    public int getIdVeiculo() {
        return idVeiculo;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public Motorizacao getMotorizacao() {
        return motorizacao;
    }

    public void setMotorizacao(Motorizacao motorizacao) {
        this.motorizacao = motorizacao;
    }
    
    @Override
    public String toString(){
        return "ID: "+idVeiculo+", FABRICANTE: "+fabricante+", MODELO: "+modelo+", ANO: "+ano;
    } 
    
    public void print(){
        System.out.println("Fabricante: " + fabricante );
        System.out.println("modelo: " + modelo );
        System.out.println("Ano: " + ano );
        if(motorizacao != null) {
            System.out.println("Motorização: ");
            motorizacao.print();
        }
    }
}
