package com.companyex1;

import java.util.Random;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.text.DecimalFormat;
import java.text.NumberFormat;



public class Cartela {

    private static Random rnd = new Random();

    private static List<Integer> minhaListaItems = new ArrayList<Integer>();
    private static List<Integer> colunaB = new ArrayList<Integer>();
    private static List<Integer> colunaI = new ArrayList<Integer>();
    private static List<Integer> colunaN = new ArrayList<Integer>();
    private static List<Integer> colunaG = new ArrayList<Integer>();
    private static List<Integer> colunaO = new ArrayList<Integer>();

    private static int MTotalItens = 75;
    private static int MTotalItensColunas = 5;

    private static NumberFormat nf = new DecimalFormat("00");

    public static void inicializaItens() {
        for ( int i = 0; i < MTotalItens; i++){
            minhaListaItems.add(0);
        }

        for ( int j =0; j < MTotalItensColunas; j++) {
             colunaB.add(0);
             colunaI.add(0);
             colunaN.add(0);
             colunaG.add(0);
             colunaO.add(0);
        }
    }

    public static void criarColunas() {
        int numeroAleatorios = rnd.nextInt(15); // vai de 0 até 14
        int minimo = 1;
        int maximo = 15;
        for(int linha = 0; linha < 5; linha++){
            for(int coluna = 0; coluna < 5; coluna++){
                while (!checarNumeros(numeroAleatorios)){
                    numeroAleatorios =rnd.nextInt(maximo - minimo +1) + minimo;
                }
                minhaListaItems.set(numeroAleatorios, 1);
                switch (coluna) {
                    case 0 -> colunaB.set(linha, numeroAleatorios + 1);
                    case 1 -> colunaI.set(linha, numeroAleatorios + 1);
                    case 2 -> colunaN.set(linha, numeroAleatorios + 1);
                    case 3 -> colunaG.set(linha, numeroAleatorios + 1);
                    case 4 -> colunaO.set(linha, numeroAleatorios + 1);
                }
            }
            minimo = maximo +1; // 16 31 46 61
            maximo = minimo +14; // 30  45 60 75

        }
    }

    public static boolean checarNumeros(int numero) {
        boolean resultado = true;
        if(minhaListaItems.get(numero).equals(1) ){
            resultado = false;
        }
        return resultado;
    }

    public static void mostrarCartela() {

        int numero = 0;
        for(int linha = 0; linha < 5; linha++){
            for(int coluna = 0; coluna < 5; coluna++){
                switch (linha){
                    case 0: numero = colunaB.get(coluna).intValue(); break;
                    case 1: numero = colunaI.get(coluna).intValue(); break;
                    case 2: numero = colunaN.get(coluna).intValue(); break;
                    case 3: numero = colunaG.get(coluna).intValue(); break;
                    case 4: numero = colunaO.get(coluna).intValue(); break;
                }
                if (linha == 2 && coluna == 2){
                    System.out.print("** |  ");
                } else {
                    formatarNumero(numero);
                }
            }
            System.out.println("");
        }

    }

    public static void formatarNumero(int numero) {
        if (numero < 10){
            System.out.print(nf.format(numero) + " |  ");
        }else{
            System.out.print(numero + " |  ");

        }

    }

    public static void main(String[] args) {
        inicializaItens();
        criarColunas();
        Scanner teclado = new Scanner(System.in);
        System.out.println("Pressione qualquer tecla");
        String resposta =  teclado.next();
        System.out.println("B  |  I  |  N  |  G  |  O  |");
        mostrarCartela();
    }

}