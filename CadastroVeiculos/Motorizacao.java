package aula05;

/**
 * @author Antonio
 */

public class Motorizacao {
    private static int cont = 0;
    private int idMotorizacao;
    private String modelo;
    private String numeroSerie;
    private int cilindrada;

    public Motorizacao(String Modelo, String NumeroSerie, int cilindrada) {
        this.modelo = Modelo;
        this.numeroSerie = NumeroSerie;
        this.cilindrada = cilindrada;
        cont++;
        this.idMotorizacao = cont;
    }

    public int getIdMotorizacao() {
        return idMotorizacao;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getNumeroSerie() {
        return numeroSerie;
    }

    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    public int getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(int cilindrada) {
        this.cilindrada = cilindrada;
    }

    @Override
    public String toString() {
        return "Motorização: " + modelo + ", " + cilindrada + ", Número de Serie: " + numeroSerie;
    }

    public void print() {
        System.out.println("Modelo: " + modelo);
        System.out.println("Cilindrada: " + cilindrada);
        System.out.println("Numero de Serie: " + numeroSerie);
    }   
}
