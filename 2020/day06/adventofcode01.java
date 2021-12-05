import java.util.Scanner;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors

public class adventofcode01 {
    public static void main(String[] args) {
        
        System.out.println("Inicio");
        int perguntasRespondidas = 0;
        try {
            System.out.println("Inicio");
            File myObj = new File("/Users/goncaloantunes/Documents/adventofcode2020/day06/pzlInput.txt");
            Scanner sc = new Scanner(myObj);
            
            String dados = new String();
            String newLine = new String();
            while (sc.hasNextLine()) {
                System.out.println("Reading");
                do {
                    newLine = sc.nextLine();
                    dados = dados.concat(newLine);
                } while (!newLine.equals("") && sc.hasNext());
                System.out.println(dados);
                perguntasRespondidas += getRespostasRespondidas(dados);
                dados = new String();
            }
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("Verificar Ficheiro");
        }
        System.out.println("Respondidas: " + perguntasRespondidas);
    }

    public static int getRespostasRespondidas(String s) {
        int qntdDeRespostas = 0;
        int flagLetra = 0;
        s = s.trim();
        char[] respostas = s.toCharArray();
        char[] possibilidades = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        
        System.out.println(s);
        for (int i  = 0; i < possibilidades.length; i++) {
            for (int j = 0; j < respostas.length; j++ ) {
                if (possibilidades[i] == respostas[j] && flagLetra == 0) {
                    qntdDeRespostas++;
                    System.out.println("Letra Analizada: " + possibilidades[i]);
                    flagLetra = 1;
                }
            }
            flagLetra = 0;
        }
        System.out.println(qntdDeRespostas);
        return qntdDeRespostas;
    }
}
// 6768 to low