import java.util.Scanner;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors

public class adventofcode02 {
    public static void main(String[] args) {
        /*          j
            |----------------
            |
            |
         i  |
            |
            |
            |
         */
        char[][] mapaOriginal = new char[323][32];
        char[][] mapa = new char[323][32];
        int altura = 0, comprimento = 0;
        try {
            System.out.println("Inicio");
            File myObj = new File("/Users/goncaloantunes/Documents/adventofcode2020/day03/pzlInput.txt");
            Scanner sc = new Scanner(myObj);
            
            while (sc.hasNextLine()) {
                System.out.println("Reading");
                String dados = sc.nextLine();
                for (int i = 0; i < dados.length(); i++) {
                    mapaOriginal[altura][i]  = dados.charAt(i);    
                    
                }
                altura++;
                comprimento = dados.length();
            }
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("Verificar Ficheiro");
        }
        long rotaA, rotaB, rotaC, rotaD, rotaE;
        rotaA = testarRota(mapaOriginal, mapa, altura, comprimento, 1, 1);
        rotaB = testarRota(mapaOriginal, mapa, altura, comprimento, 3, 1);
        rotaC = testarRota(mapaOriginal, mapa, altura, comprimento, 5, 1);
        rotaD = testarRota(mapaOriginal, mapa, altura, comprimento, 7, 1);
        rotaE = testarRota(mapaOriginal, mapa, altura, comprimento, 1, 2);
        System.out.println(rotaA);
        System.out.println(rotaB);
        System.out.println(rotaC);
        System.out.println(rotaD);
        System.out.println(rotaE);
        long res = rotaA * rotaB * rotaC * rotaD * rotaE;
        System.out.println(res);
    }

    public static long testarRota(char[][] mapaOriginal, char[][] mapa, int altura, int comprimento, int posShifterX, int posShifterY) {
        duplicarMapa(mapaOriginal, mapa, comprimento, altura);
        exibirMapa(mapa, altura, comprimento);

        int posX = 0; // J
        int posY = 0; // I

        int vazio = 0, preenchido = 0;
        while (posY != altura) {
            if (mapa[posY][posX] == '.') {
                vazio++;
                mapa[posY][posX] = 'O';
            }
            else {
                preenchido++;
                mapa[posY][posX] = 'X';
            }

            posX += posShifterX;

            if (posX >= comprimento) {
                posX = posX - 31;
            }
            
            posY += posShifterY;
            
            if (posY > altura) {
                posY--;
                System.out.println("WAZA");
                //if((mapa[posY - posShifterY])
            }
        }

        exibirMapa(mapa, altura, comprimento);
        System.out.println("Numero de Arvores Encontradas: " + preenchido + " Numero de posicoes vazias: " + vazio);

        return preenchido;
    }

    public static void exibirMapa(char[][] mapa, int altura, int comprimento) {
        for(int i = 0; i < altura; i++) {
            for (int j = 0; j < comprimento; j++) {
                System.out.print(mapa[i][j]);
            }
            System.out.print("\n");
        }
    }

    public static void duplicarMapa(char[][] mapaOriginal, char[][] mapaFinal, int x, int y) {
        //char[][] ar = new char[y][x];
        System.out.println("ALtura: " + y);
        for(int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                mapaFinal[i][j] = mapaOriginal[i][j];
            }
        }
    }
}