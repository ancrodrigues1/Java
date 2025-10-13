package Exercicio02;

/**
 * @author Antonio
 */

import java.util.Scanner;
import java.util.List;
import java.util.Arrays;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

//classe para armazenar dados e criar um clone 
class Data implements Cloneable { 
    int dia, mes, ano;

    public Data(int Dia, int Mes, int Ano){
        this.dia = Dia;
        this.mes = Mes;
        this.ano = Ano;
    }

    public int getDia() {
        return dia;
    }

    public int getMes() {
        return mes;
    }

    public int getAno() {
        return ano;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }
    
    //metodo toString para saida de dados
    @Override
    public String toString(){
        return String.format("%04d-%02d-%02d", ano, mes,dia);
    }
    
    //metodo para saida formatada
    public String formatada() {
        return String.format("%02d/%02d/%04d", dia, mes, ano);
    }

    //metodo clone
    @Override
    public Data clone() {
        try {
            return (Data) super.clone();
        } catch (CloneNotSupportedException e) {
            return new Data(this.dia, this.mes, this.ano);
        }
    }
}

public class exercicio_n2 {
    //variaveis estaticas que seram utilizadas por todo o sistema
    public static int dia, mes, ano;
    public static String dataEscolhida, mensagem, mensagemData;
    public static long qtDias;
    public static List<String> meses = Arrays.asList ( 
            "janeiro", "fevereiro", "marco", "abril", "maio", "junho",
            "julho", "agosto", "setembro", "outubro", "novembro", "dezembro");
    
    //funcao para encontrar o mes, quando digitado por extenso
    public static boolean encontraMes(String dat){
        int tamanhoString = dat.length();
        for (int i = 0; i<meses.size(); i++){
            if (dat.substring(4,(tamanhoString-5)).replaceAll("ç","c").contains(meses.get(i))){
                mes = i+1;
                return true;
            }
        }
        return false;
    }   
    
    //funcao que verifica se a data e valida ou não
    public static boolean formatoData(String dat){
        if(dat.length()== 8){
            try{
                dia = Integer.parseInt(dat.substring(0, 2));
                mes = Integer.parseInt(dat.substring(2, 4));
                ano = Integer.parseInt(dat.substring(4, 8));
                return true;
            } catch (NumberFormatException e) {
                return false;
            }
        } else {    
            if(encontraMes(dat)){
                try{
                    dia = Integer.parseInt(dat.substring(0, 2));
                    ano = Integer.parseInt(dat.substring((dat.length()-4),(dat.length())));
                    return true;
                } catch (NumberFormatException e) {
                    return false;
                }
            } else {
                return false;
            }
        }
    }
    
    //funcao verifica qual a data maxima para um determinado mes
    public static int verificaDiaMaximo(int ano, int mes){
        if (mes == 1 || mes == 3 || mes == 5 || mes == 7 
                    || mes == 8 || mes == 10 || mes == 12){
            return 31;
        } else {
            if (mes ==2){
                if ((ano % 4 == 0 && ano % 100 != 0) || (ano % 400 == 0)){//condição ano  bisexto
                    return 29;
                } else {
                    return 28;
                }
            } else {
                return 30;
            }
        }
    }
    
    //funcao validacao de data de acordo especificações do exercicio e logica 
    public static boolean validaData(String dat){
        if (formatoData(dat)){
            if (ano>=1900 && ano<=2100){
                if (mes>=1 && mes<=12){
                    int diaMaximo = verificaDiaMaximo(ano, mes);
                    if (dia>=1 && dia<=diaMaximo){
                        return true;
                    } else {
                        mensagem = "dia Inválido, para a data escolhida!!";
                        return false;
                    }
                } else {
                    mensagem = "Mes Inválido, para a data escolhida!!!!";
                    return false;
                }
            } else {
                mensagem = "Ano fora dos Paramentros do Sistema!";
                return false;
            }
        } else {
            mensagem = "Formato de data não reconhecido, favor utilizar um formato válido!!";
            return false;
        }
    }
    
    //funcao que formata a data a ser apresentada para saida ao utilizador
    public static String formatadarSaidaData(LocalDate d, int tipo){
        Locale localePortugal = new Locale("pt","PT");
        if (tipo==1 || tipo ==0){
            DateTimeFormatter formatoPT = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String formatado = d.format(formatoPT);
            return formatado;
        } else {
            DateTimeFormatter formatoPTExtenso = DateTimeFormatter.ofPattern("dd 'de' MMMM 'de' yyyy", localePortugal);
            String formatado = d.format(formatoPTExtenso);
            return formatado;
        }
    }
    
    //funcao comparar datas e determinar a quantidade de dias de diferença
    public static void compararDatas(LocalDate data1, LocalDate data2){
        if (data1.equals(data2)){
            mensagemData = "As datas são iguais!!!";
            qtDias = 0;
        } else {
            qtDias = ChronoUnit.DAYS.between(data1, data2);
            if (qtDias>0){
                mensagemData = "Passaram "+qtDias+" dias.";
            } else {
                mensagemData = "Faltam "+(qtDias*-1)+" dias.";
            }
        }
    }
    
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        System.out.print("\n\n Informe Data: ");
        String dataUtilizador = scn.nextLine();
        //limpa os campos em branco e tira as barras
        dataEscolhida = dataUtilizador.replaceAll(" ", "").replaceAll("/", "").toLowerCase();
        if (validaData(dataEscolhida)){
            Data d1 = new Data(dia,mes,ano);//apos validar data, atribui na classe devida
            Data d2 = d1.clone(); // metodo clone
            LocalDate dataBase = LocalDate.of(1900, 01, 01);//atrbuir data base descrita no exercicio
            LocalDate dataAtual = LocalDate.now();//busca data atual
            DateTimeFormatter formatoPadraoData = DateTimeFormatter.ISO_LOCAL_DATE;//formato data padrao para calculo
            //busca os dados do clone e formata para calculos e utilização
            LocalDate dataEspecifica = LocalDate.parse(d2.toString(), formatoPadraoData);
            //crio variavel para identificar a opção do utilizador e cria foram do mesmo selecionar sua opção
            int tipoInformacao = 0;
            while(tipoInformacao==0){
                System.out.println("\n >> Selecione o formato deseja que a data seja aprepresentada");
                System.out.println("     1 - Formato Numerico");
                System.out.println("     2 - Formato por Extenso");
                System.out.print(" Digite a opção: ");
                if(scn.hasNextInt()){
                    int opc = scn.nextInt();
                    switch (opc){
                        case 1:
                            tipoInformacao=1;
                            break;
                        case 2:
                            tipoInformacao=2;
                            break;
                        default:
                            System.out.println(" **Opção Inválida, tente novamente!!!**");
                            break;
                    }
                } else {
                    System.out.println(" **Opção Inválida, tente novamente!!!**");
                    scn.nextLine();
                }
            }
            //demonstra os resultados
            System.out.println("\n\n RESULTADO:");
            System.out.println("  Data de Base: "+formatadarSaidaData(dataBase, tipoInformacao));
            System.out.println("  Data de Atual: "+formatadarSaidaData(dataAtual, tipoInformacao));
            System.out.println("  Data Escolhida pelo Utilizador: "+formatadarSaidaData(dataEspecifica,tipoInformacao));
            System.out.println("\n **ANALISE DATAS**");
            System.out.println("   Data Escolhida pelo Utilizador: "+formatadarSaidaData(dataEspecifica,tipoInformacao)+
                    " »» Data Base: "+formatadarSaidaData(dataBase,tipoInformacao));
            compararDatas(dataBase,dataEspecifica);
            System.out.println("     "+mensagemData);
            System.out.println("   Data Escolhida pelo Utilizador: "+formatadarSaidaData(dataEspecifica,tipoInformacao)+
                    " »» Data Atual: "+formatadarSaidaData(dataAtual,tipoInformacao));
            compararDatas(dataEspecifica,dataAtual);
            System.out.println("     "+mensagemData);
        } else {
            System.out.println("\n "+mensagem);
        }
        System.out.println("\n       **** PROGRAMA FINALIZADO ****");
    }
}
