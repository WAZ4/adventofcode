import java.util.Scanner;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors

public class adventofcode01 {
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
                    mapa[altura][i]  = dados.charAt(i);    
                    
                }
                altura++;
                comprimento = dados.length();
            }
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("Verificar Ficheiro");
        }

        exibirMapa(mapa, altura, comprimento);

        int posX = 0; // J
        int posY = 0; // I
        int posShifterX = 3;
        int posShifterY = 1;

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

            if (posX > comprimento) {
                posX = posX - 31;
            }
            
            posY += posShifterY;
        }

        exibirMapa(mapa, altura, comprimento);
        System.out.println("Numero de Arvores Encontradas: " + preenchido + " Numero de posicoes vazias: " + vazio);
    }

    public static void exibirMapa(char[][] mapa, int altura, int comprimento) {
        for(int i = 0; i < altura; i++) {
            for (int j = 0; j < comprimento; j++) {
                System.out.print(mapa[i][j]);
            }
            System.out.print("\n");
        }
    }
}
