import java.util.Scanner;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors

public class adventofcode02 {
    public static void main(String[] args) {
        
        System.out.println("Inicio");
        int perguntasRespondidas = 0;
        int qntdDePessoas = 0;
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
                    qntdDePessoas++;
                    dados = dados.concat(newLine);
                } while (!newLine.equals("") && sc.hasNext());
                if (newLine.equals("")) qntdDePessoas--;
                System.out.println(dados);
                perguntasRespondidas += getRespostasRespondidas(dados, qntdDePessoas);
                dados = new String();
                qntdDePessoas = 0;
            }
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("Verificar Ficheiro");
        }
        System.out.println("Respondidas: " + perguntasRespondidas);
    }

    public static int getRespostasRespondidas(String s, int totalDePessoas) {
        int qntdDeRespostas = 0;
        int flagLetra = 0;
        s = s.trim();
        char[] respostas = s.toCharArray();
        char[] possibilidades = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        
        System.out.println(s);
        for (int i  = 0; i < possibilidades.length; i++) {
            for (int j = 0; j < respostas.length; j++ ) {
                if (possibilidades[i] == respostas[j]) {
                    System.out.println("Letra Analizada: " + possibilidades[i]);
                    flagLetra++;
                    System.out.println("Ocorrencia nr: " + flagLetra);
                    System.out.println("Pessoas no grupO: " + totalDePessoas);
                }
            }
            if (flagLetra == totalDePessoas) qntdDeRespostas++;
            flagLetra = 0;
        }
        System.out.println(qntdDeRespostas);
        return qntdDeRespostas;
    }
}
// 6768 to low