import java.util.Scanner;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors


public class adventofcode01 {
    public static void main(String[] args) {
        System.out.println("Inicio");
        
        int validos = 0;

        try {
            System.out.println("Inicio");
            File myObj = new File("/Users/goncaloantunes/Documents/adventofcode2020/day04/pzlInput.txt");
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
                validos += isValid(dados);
                dados = new String();
            }
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("Verificar Ficheiro");
        }
        System.out.println(validos);
    }

    public static int isValid(String s) {
        int byr, iyr, eyr, hgt, hcl, ecl, pid;//, cid;
        
        //procurar byr dentro da String s
        byr = s.indexOf("byr:");
        System.out.println("byr: " + byr);
        //procurar iyr dentro da String s
        iyr = s.indexOf("iyr:");
        System.out.println("iyr: " + iyr);
        //procurar eyr dentro da String s
        eyr = s.indexOf("eyr:");
        System.out.println("eyr: " + eyr);
        //procurar hgt dentro da String s
        hgt = s.indexOf("hgt:");
        System.out.println("hgt: " + hgt);
        //procurar hcl dentro da String s
        hcl = s.indexOf("hcl:");
        System.out.println("hcl: " + hcl);
        //procurar ecl dentro da String s
        ecl = s.indexOf("ecl:");
        System.out.println("ecl: " + ecl);
        //procurar pid dentro da String s
        pid = s.indexOf("pid:");
        System.out.println("pid: " + pid);

        if (byr == -1 || iyr == -1 || eyr == -1 || hgt == -1 || hcl == -1 || ecl == -1 || pid == -1) return 0;
        return 1;
    }
}
