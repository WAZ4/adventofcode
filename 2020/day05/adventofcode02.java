import java.util.ArrayList;
import java.util.Scanner;

import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors

public class adventofcode02 {
    public static void main(String[] args) {
        System.out.println("Inicio");
        int[] realidade = new int[770];
        int cntd = 0;
        int num = 0;
        try {
            System.out.println("Inicio");
            File myObj = new File("/Users/goncaloantunes/Documents/adventofcode2020/day05/pzlInput.txt");
            Scanner sc = new Scanner(myObj);
            
            String dados = new String();
            int buffer;
            while(sc.hasNext()) {
                System.out.println("");
                System.out.println("Reading");
                dados = sc.nextLine();   

                System.out.println("A avaliar: " + dados); 
                buffer = getId(dados);

                realidade[cntd] = buffer;
                cntd++;
                System.out.println("Num: " + num);
                System.out.println("Buffer: " + buffer);

                if(num < buffer) num = buffer;

            }
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("Verificar Ficheiro");
        }
        System.out.println(num);
        getAssentoEmFalta(compararRealidade(realidade));

        for (int i = 1; i < realidade.length; i++) {
            if(realidade[i] == 0) System.out.println("POG");
        }
    }

    public static int getId(String sOriginal) {
        int id;
        int fila, assento;
        int[] filaExtremos = {1, 128};
        int[] assentoExtremos = {1, 8};
        char[] s = sOriginal.trim().toCharArray();
        
        for (int i = 0; i < s.length; i++) {

            switch (s[i]) {
                case 'F': filaExtremos = getLowerHalf(filaExtremos); break;
                case 'B': filaExtremos = getUpperHalf(filaExtremos); break;
                case 'R': assentoExtremos = getUpperHalf(assentoExtremos); break;
                case 'L': assentoExtremos = getLowerHalf(assentoExtremos); break;
            }
            System.out.println("");
        }
        fila = filaExtremos[0];
        assento = assentoExtremos[0];

        id = (fila * 8) + assento; 
        System.out.println(id);

        return id;
    }

    public static int[] getUpperHalf(int[] extremos) {
        int[] resultado = new int[2];
        int meio, max;

        if(extremos[1] - extremos[0] == 2) {
            meio = extremos[1] - 1;
            max = extremos[1] - 1;
        }
        else {
            meio = extremos[0] + (extremos[1] - extremos[0])/2;
            max = extremos[1];
        }
        resultado[0] = meio;
        resultado[1] = max;
        System.out.println("Dados de Entrada: Min: " + extremos[0] + " Max: " + extremos[1]);
        System.out.println("Dados de Saida: Min: " + resultado[0] + " Max: " + resultado[1]);

        return resultado;
    }

    public static int[] getLowerHalf(int[] extremos) {
        int[] resultado = new int[2];
        int meio, min;

        if(extremos[1] - extremos[0] == 2) {
            meio = extremos[0];
            min = extremos[0];
        }
        else {
            meio = extremos[0] + (extremos[1] - extremos[0])/2;
            min = extremos[0];
        }
        
        
        resultado[0] = min;
        resultado[1] = meio;

        System.out.println("Dados de Entrada: Min: " + extremos[0] + " Max: " + extremos[1]);
        System.out.println("Dados de Saida: Min: " + resultado[0] + " Max: " + resultado[1]);

        return resultado;
    }
    
    public static int[][] compararRealidade(int [] realidade) {
            int[][] aviao = new int[128][8];
            int[][] novaRealidade = new int[128][8];
            for (int fila = 0; fila < 127; fila++) {
                for (int assento = 0; assento < 8; assento++) {
                    aviao[fila][assento] = ((fila) * 8) + (assento);
                }
            }
            for (int i = 0; i < realidade.length; i++) {

                for (int fila = 0; fila < 127; fila++) {
                    for (int assento = 0; assento < 8; assento++) {
                        if (aviao[fila][assento] == realidade[i]){ novaRealidade[fila][assento] = 1; System.out.println("Sucesso" + novaRealidade[fila][assento]);}
                    }
                }

            }
    
            return novaRealidade;
    }

    public static void getAssentoEmFalta(int[][] realidade) {

        for (int i = 0; i < 128; i ++) {
            for (int j = 1; j < 8; j++) {
                if (realidade[i][j] == 0) System.out.println("i : " + i + " j: " + j );
                else System.out.println("WAZAAAAAAAAAAAAAA");
            }
        }
    }
}
