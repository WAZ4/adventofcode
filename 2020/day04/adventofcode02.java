import java.util.Scanner;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors


public class adventofcode02 {
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
        int byr, iyr, eyr, hgt, hcl, ecl, pid;//, cid; indexes do  primeiro algarismo da ocorrencia se nao houver = -1
        String valByr, valIyr, valEyr, valHgt, valHcl, valEcl, valPid; //valor do conteudo dos campos obrigatorios
        String unidadesDeMedida = ""; // unidades nas quais se mede a altura(hcl);
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

        if (byr == -1 || iyr == -1 || eyr == -1 || hgt == -1 || hcl == -1 || ecl == -1 || pid == -1) return 0; //Se faltar algum dos campos cruciais acaba aqui e da return de invalido
        
        try {
            //encontrar o valor de byr
            valByr = s.substring(byr + 4, byr + 4 + 4); // byr + 4 é index do primeiro algarismo, e bir + 4 + 4 é o valor do index ultimo
            //encontrar o valor de Iyr
            valIyr = s.substring(iyr + 4, iyr + 4 + 4); // iyr + 4 é index do primeiro algarismo, e bir + 4 + 4 é o valor do index ultimo
            //encontrar o valor de Eyr
            valEyr = s.substring(eyr + 4, eyr + 4 + 4); // eyr + 4 é index do primeiro algarismo, e bir + 4 + 4 é o valor do index ultimo
            
            //encontrar unidades de medida de altura(hgt)
            if(s.indexOf("cm") != -1) unidadesDeMedida = "cm";
            else if(s.indexOf("in") != -1) unidadesDeMedida = "in";
            else System.out.println("Erro nao encontrou unidades de medida");
            //encontrar o valor de Hgt
            valHgt = s.substring(hgt + 4, s.indexOf(unidadesDeMedida)); // hgt + 4 é index do primeiro algarismo, e indexOf(unidadesDeMedida) é o valor do primeiro index das unidades de medida
            //encontrar o valor de Hcl
            valHcl = s.substring(hcl + 5, hcl + 5 + 6); // hcl + 5 é index do primeiro algarismo, e hcl + 5 + 6 é o valor do index ultimo
            //encontrar o valor de ecl
            valEcl = s.substring(ecl + 4, ecl + 4 + 3); // ecl + 4 é index do primeiro algarismo, e bir + 4 + 3 é o valor do index ultimo
            //encontrar o valor de pid
            valPid = s.substring(pid + 4, pid + 4 + 9); // pid + 4 é index do primeiro algarismo, e pid + 4 + 9 é o valor do index ultimo
            
            System.out.println("Unidades De Medida: " + unidadesDeMedida);
            System.out.println("pid: " + valPid);
            System.out.println("ecl: " + valEcl);
            System.out.println("hcl: " + valHcl);
            System.out.println("hgt: " + valHgt);
            System.out.println("eyr: " + valEyr);
            System.out.println("iyr: " + valIyr);
            System.out.println("byr: " + valByr);
            
            //verificar os 3 primeiros parametros: valbyr, valiyr, valeyr       WAZA tentar compactar esta parte o codigo
            if ((Integer.parseInt(valByr) >= 1920 && Integer.parseInt(valByr) <= 2002) && (Integer.parseInt(valIyr) >= 2010 && Integer.parseInt(valIyr) <= 2020) && (Integer.parseInt(valEyr) >= 2020 && Integer.parseInt(valEyr) <= 2030) ) System.out.println("Certo");
            else return 0;
            //verificar o tamanho da pessoa conforme a unidade de medida
            if ((unidadesDeMedida == "cm" && (Integer.parseInt(valHgt) >= 150 && Integer.parseInt(valHgt) <= 193)) || (unidadesDeMedida == "in" && (Integer.parseInt(valHgt) >= 59 && Integer.parseInt(valHgt) <= 76))) System.out.println("Certo");
            else return 0;
            //verificar os valores de hcl
            if (verificarHcl(valHcl) == 1) System.out.println("Certo");
            else return 0;
            //verificar os valores de ecl
            String possibilidades = "amb blu brn gry grn hzl oth";
            if (possibilidades.indexOf(valEcl) != -1) System.out.println("Certo");
            else return 0;
            //verificar pid
            if (verificarPid(valPid) == 1) System.out.println("Certo");
            else return 0;
            
        } catch (StringIndexOutOfBoundsException | NumberFormatException e) {
            return 0;
        }
        return 1;
    }

    public static int verificarHcl(String sOriginal) {
        char[] c = {'a', 'b', 'c', 'd', 'e', 'f', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        char[] s = sOriginal.toCharArray();
        int flag = 0;
        for(int i = 0; i < s.length; i++) {
            for (int j = 0; j < c.length; j++) {
                if (s[i] == c[j]) flag++;
            }
        }
        if(flag == s.length) return 1;
        return 0;
    }

    public static int verificarPid(String s) {
            try {
                Integer.parseInt(s);
                
            }catch (Exception NumberFormatException) {
                return 0;
            }
        return 1;
    }
}
