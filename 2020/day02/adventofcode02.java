import java.util.Scanner;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors

public class adventofcode02 {
    public static void main(String[] args) {
        
        System.out.println("Inicio");
        
        int validos = 0;

        try {
            System.out.println("Inicio");
            File myObj = new File("/Users/goncaloantunes/Documents/adventofcode2020/day02/pzlInput.txt");
            Scanner sc = new Scanner(myObj);
            
            while (sc.hasNextLine()) {
                System.out.println("Reading");
                String dados = sc.nextLine();
                validos += isValid(dados);
            }
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("Verificar Ficheiro");
        }
        System.out.println(validos);
        
        //Testes -> System.out.println(isValid("2-9 c: ccccccccc"));
    }

    public static int isValid(String s) {
        char[] password;
        int pos1, pos2;
        char letra;
        
        //encontrar o numero pos1imo de ocorrencias do caracter
        pos1 = Integer.parseInt(s.substring(0, s.indexOf('-', 0))) - 1; // subtrair 1 para compensar nao usar o index 0 como referencia de comeco;
        System.out.println("pos1: " + pos1);
        //encontrar o numero pos2imo de ocorrencias do caracter
        pos2 = Integer.parseInt(s.substring(s.indexOf('-')+1, s.indexOf(' '))) - 1; // subtrair 1 para compensar nao usar o index 0 como referencia de comeco;
        System.out.println("pos2: " + pos2);
        //encontrar a letra de repeticao
        letra = s.charAt(s.indexOf(' ')+1);
        System.out.println("Letra: " + letra);
        //encontrar o conjunto de chars que constituem a password
        password = new char[(s.length()) - (s.indexOf(':') + 1)];
        s.getChars(s.indexOf(':')+2, s.length(), password, 0);
        System.out.println("Password: " + String.valueOf(password) + ".");

        //fazer output e devolver o resultado quando positivo
        if ((password[pos1] == letra && password[pos2] != letra) || (password[pos1] != letra && password[pos2] == letra)) {
            System.out.println("Valido!");
            return 1;
        }
        //fazer output e devolver o resultado quando negativo
        else{
            System.out.println("Invalido!");
            return 0;
        }
    }
}