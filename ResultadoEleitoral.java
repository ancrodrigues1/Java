package Exercicio03;

/**
 * @author Antonio
 */

import java.util.Scanner;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.List;

class Partidos<C extends Number,S, N, V extends Number>
implements Comparable<Partidos<C, S, N, V>>{
    private C codigo;
    private S sigla;
    private N nome;
    private V votos;
    
    public Partidos(C Codigo,S Sigla, N Nome, V Votos){
        this.codigo = Codigo;
        this.sigla = Sigla;
        this.nome = Nome;
        this.votos = Votos;
    }
    
    @Override
    public int compareTo(Partidos<C, S, N, V> outro) {
        return Double.compare(this.votos.doubleValue(), outro.votos.doubleValue());
    }

    public C getCodigo() {
        return codigo;
    }
    
    public S getSigla() {
        return sigla;
    }

    public N getNome() {
        return nome;
    }

    public V getVotos() {
        return votos;
    }
    
    public void setCodigo(C codigo) {
        this.codigo = codigo;
    }

    public void setSigla(S sigla) {
        this.sigla = sigla;
    }

    public void setNome(N nome) {
        this.nome = nome;
    }

    public void setVotos(V votos) {
        this.votos = votos;
    }            
}

public class exercicion02 {
    
    public static int numeroVagas;
    public static ArrayList <Partidos> partidos = new ArrayList<>();
    public static double divisoes[][];
    
    public class dezMaiores{
        static class Votos implements Comparable<Votos>{
            int indice;
            double valor;
            
            Votos(int Indice, double Valor){
            this.indice = Indice;
            this.valor = Valor;
            }

            public int getIndice() {
                return indice;
            }

            public double getValor() {
                return valor;
            }
            
            @Override
            public int compareTo(Votos outro){
                int comparador = Double.compare(this.valor, outro.valor);
                if (comparador == 0){
                    return Integer.compare(this.indice, outro.indice);
                }
                return comparador;
            }
        }    
    }
    
    public class resultadoFinal{
        static class ResultadoFinal implements Comparable<ResultadoFinal>{
            private int indiceVagas;
            private int quantidadeVagas;
            
            ResultadoFinal(int Indice, int QuantidadeVagas){
                this.indiceVagas = Indice;
                this.quantidadeVagas = QuantidadeVagas;
            }

            public int getIndice() {
                return indiceVagas;
            }

            public int getQuantidadeVagas() {
                return quantidadeVagas;
            }
            
            @Override
            public int compareTo(ResultadoFinal outro){
                return Integer.compare(outro.quantidadeVagas, this.quantidadeVagas);
            }
        }
    }
    
    public static int entradaInt(String mensagem){
        Scanner scn = new Scanner(System.in);
        int valorTemp = 0;
        while(true){
            System.out.print(mensagem);
            if(scn.hasNextInt()){
                valorTemp = scn.nextInt();
                if (valorTemp>0){
                    break;
                } else {
                    System.out.println("\n *Erro: Valor deve ser maior que zero.");
                }
            } else {
                System.out.println("\n *Erro: Entrada inválida!!.");
                scn.nextLine();
            }
        }
        return valorTemp;
    }
    
    public static String entradaString(String mensagem){
        Scanner scn = new Scanner(System.in);
        String nomeTemp="";
        while(true){
            System.out.print(mensagem);
            nomeTemp = scn.nextLine();
            if (nomeTemp.trim().isEmpty() || !nomeTemp.matches(".*[a-zA-Z].*")){
                System.out.println(" *Erro: Campo nome não pode ficar em branco e/ou deve ter letras!!");
            } else {
                break;
            }
        }
        return nomeTemp;
    }
    
    public static double entradaDouble(String mensagem){
        Scanner scn = new Scanner(System.in);
        double valorTemp = 0.0;
        while(true){
            System.out.print(mensagem);
            if(scn.hasNextDouble()){
                valorTemp = scn.nextDouble();
                if (valorTemp>0){
                    break;
                } else {
                    System.out.println("\n *Erro: Valor deve ser maior que zero.");
                }
            } else {
                System.out.println("\n *Erro: Entrada inválida!!.");
                scn.nextLine();
            }
        }
        return valorTemp;
    }
    
    public static void divisaoVotos(int tamanhoLista){
        divisoes = new double[tamanhoLista][numeroVagas+1];
        for(int i=0 ; i<tamanhoLista ; i++){
            for(int j=1 ; j<=numeroVagas ; j++){
                divisoes[i][j] = ((partidos.get(i).getVotos().doubleValue())/(j));
            }
        }
    }
    
    public static void main (String[] args){
        Scanner scn = new Scanner(System.in);
        PriorityQueue<dezMaiores.Votos> resultado = new PriorityQueue<>();
        ArrayList<resultadoFinal.ResultadoFinal> resultFinal = new ArrayList<>();
        List<Integer> lista = new ArrayList<>();
        String siglaTemp, nomeTemp;
        double votosTemp;
        int codigoTemp;
        System.out.println("\n\n  Sistema Apuração Eleitoral");
        System.out.println(" *Segundo metodo de Hondt (alterado por especificações internas)*\n");
        numeroVagas = entradaInt(" »Informe numero de vagas concorridas: ");
        System.out.println("\n\n   **Partidos e Votos**");
        boolean novoPartido = true;
        while(novoPartido){
            codigoTemp = entradaInt(" >>Digite Código do Partido: ");
            siglaTemp = entradaString(" >>Digite a Sigla do Partido: ");
            nomeTemp = entradaString(" >>Digite o Nome do Partido: ");
            votosTemp = entradaDouble(" >> Informe a Quantidade de Votos do Partido: ");
            partidos.add(new Partidos(codigoTemp,siglaTemp,nomeTemp,votosTemp));
            while(true){
                System.out.print("\n\n Deseja incluir novo partido(s/n)?");
                String resposta = scn.nextLine();
                if (resposta.equalsIgnoreCase("n")){
                    novoPartido=false;
                    break;
                } else if(resposta.equalsIgnoreCase("s")){
                    System.out.println("\n");
                    break;
                } else {
                    System.out.println("  **Resposta Inválida!!");
                }
            }
        }
        divisaoVotos(partidos.size());
        for (int i=0; i<divisoes.length; i++){
            for (int j=1; j<divisoes[i].length; j++){
                resultado.add(new dezMaiores.Votos(i, divisoes[i][j]));
                if (resultado.size() > numeroVagas){
                    resultado.poll();
                }
            }
        }
        while (!resultado.isEmpty()){
            lista.add(resultado.poll().indice);
        }
        long totalVotos=0;
        for(int i=0; i<partidos.size();i++){
            int contagemTemp = 0;
            for (int j=0; j<lista.size();j++){
                if (i==lista.get(j)){
                    contagemTemp++;
                }
            }
            resultFinal.add(new resultadoFinal.ResultadoFinal(i, contagemTemp));
            totalVotos=totalVotos+partidos.get(i).getVotos().longValue();
        }
        System.out.println("\n\n\n  **Apuração resultados**");
        System.out.println(" »» Total de Votos Apurados: "+totalVotos);
        System.out.println(" »» Quantidade de Vagas Concorridas: "+numeroVagas);
        System.out.println(" »» Total de Partidos Participantes: "+(partidos.size()));
        System.out.println("\n ***Lista de Partidos e vagas conquistadas*** ");
        for (int i=0; i<resultFinal.size(); i++){
            System.out.println("   >> Partido: "+partidos.get(resultFinal.get(i).indiceVagas).getNome()+
                    " - Sigla: "+partidos.get(resultFinal.get(i).indiceVagas).getSigla()+
                    " - Quantidade de Vagas Conquistadas: "+resultFinal.get(i).quantidadeVagas);
        }
    }
}
