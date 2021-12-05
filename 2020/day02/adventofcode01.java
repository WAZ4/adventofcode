import java.util.Scanner;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors

public class adventofcode01 {
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
        //Testes -> System.out.println(isValid("1-3 b: cdefg"));
    }

    public static int isValid(String s) {
        char[] password;
        int min, max;
        char letra;
        
        //encontrar o numero minimo de ocorrencias do caracter
        min = Integer.parseInt(s.substring(0, s.indexOf('-', 0)));
        System.out.println("Min: " + min);
        //encontrar o numero maximo de ocorrencias do caracter
        max = Integer.parseInt(s.substring(s.indexOf('-')+1, s.indexOf(' ')));
        System.out.println("Max: " + max);
        //encontrar a letra de repeticao
        letra = s.charAt(s.indexOf(' ')+1);
        System.out.println("Letra: " + letra);
        //encontrar o conjunto de chars que constituem a password
        password = new char[(s.length()) - (s.indexOf(':') + 1)];
        s.getChars(s.indexOf(':')+2, s.length(), password, 0);
        System.out.println("Password: " + String.valueOf(password) + ".");

        
        int nrDeAparecimentos = 0; //variavel usada para contar o numero de aparecimentos da letra dentro da password
        //contar o numero de aparecimentos da letra dentro da password
        for (int i = 0; i < password.length; i++) {
            if (password[i] == letra) nrDeAparecimentos++;
        }
        //fazer output e devolver o resultado quando positivo
        if (nrDeAparecimentos >= min && nrDeAparecimentos <= max) {
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