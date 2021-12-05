//Etes codigo esta errado porque o resultado deveria ser 156 mas devolve 157, de alguma forma eu advinhei que estava a dar 1 certo a mais e respondi 156 por isso vou so continuar a fazer os dias

import java.util.ArrayList;
import java.util.Scanner;

import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors

public class adventofcode03 {
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
                System.out.println("");
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
        if (verificarDados(s) == 0) return 0;
        System.out.println("Campos Necessarios Preenchidos!");

        s = s.trim();
        s = s.concat("#");

        ArrayList<String> ordem = getOrdem(s);
        String endString;
        //Verificar unidades de medida
        String unidadesDeMedida = "";
        if (s.contains("cm")) unidadesDeMedida = "cm";
        else if(s.contains("in")) unidadesDeMedida = "in";
        else return 0;
        //Verificar a altura (hgt)
        int hgtValue;
        try{
            hgtValue = Integer.parseInt(s.substring(s.indexOf("hgt:") + 4, s.indexOf(unidadesDeMedida, s.indexOf("hgt:"))));
            System.out.println(hgtValue);
            if(unidadesDeMedida == "cm" && (hgtValue >= 150 && hgtValue <= 193));
            else if(unidadesDeMedida == "in" && (hgtValue >= 59 && hgtValue <= 76));
            else return 0;
            System.out.println("Sucesso a verificar a HGT!");
        }catch(StringIndexOutOfBoundsException | NumberFormatException e){
            System.out.println(e);
            return 0;
        }
        
        //Verificar hcl
        String hclValue;
        endString = getNext("hcl:", ordem);
        System.out.println("WAZA: " + endString);

        hclValue = s.substring(s.indexOf("hcl:") + 4, s.indexOf(endString, s.indexOf("hcl:") + 5));
        System.out.println("HclValue: " + hclValue);
        if(verificarHcl(hclValue) == 0) return 0;
        System.out.println("Sucesso a validar HCL");
        
        //Verificar ecl
        String eclValue;
        endString = getNext("ecl:", ordem);
        eclValue = s.substring(s.indexOf("ecl:") + 4, s.indexOf(endString, s.indexOf("ecl:") + 4)).trim();
        System.out.println("ECL: " + eclValue + "!");
        if(verificarEcl(eclValue) == 0) return 0;
        
        //Verificar pid
        String pidValue;
        endString = getNext("pid:", ordem);
        try{
            pidValue = s.substring(s.indexOf("pid:") + 4, s.indexOf(endString, s.indexOf("pid:") + 4)).trim();    
        }catch(NumberFormatException e) {
            return 0;
        }
        System.out.println("Pid: " + pidValue);

        if (pidValue.length() != 9) return 0;

        //Verificar byr

        String byrValue;
        endString = getNext("byr:", ordem);
        byrValue = s.substring(s.indexOf("byr:") + 4, s.indexOf(endString, s.indexOf("byr:") + 4)).trim();
        System.out.println("Byr: " + byrValue);

        if(byrValue.trim().length() != 4) return 0;

        if(!(Integer.parseInt(byrValue) >= 1920 && Integer.parseInt(byrValue) <= 2002));

        //verificar iyr

        String iyrValue;
        endString = getNext("iyr:", ordem);
        iyrValue = s.substring(s.indexOf("iyr:") + 4, s.indexOf(endString, s.indexOf("iyr:") + 4)).trim();
        System.out.println("Iyr: " + iyrValue);

        if(iyrValue.trim().length() != 4) return 0;

        if(!(Integer.parseInt(iyrValue) >= 2010 && Integer.parseInt(iyrValue) <= 2020)) return 0;

        //Verificar eyr

        String eyrValue;
        endString = getNext("eyr:", ordem);
        eyrValue = s.substring(s.indexOf("eyr:") + 4, s.indexOf(endString, s.indexOf("eyr:") + 4)).trim();
        System.out.println("Eyr: " + eyrValue);

        if(eyrValue.trim().length() != 4) return 0;

        if(!(Integer.parseInt(eyrValue) >= 2020 && Integer.parseInt(eyrValue) <= 2030)) return 0;
        
        // #TODO Verificar byr iyr eyr

        System.out.println("WAZA Certo!");
        return 1;
    }

    public static int verificarDados(String s) {
        int byr, iyr, eyr, hgt, hcl, ecl, pid;//, cid; indexes do  primeiro algarismo da ocorrencia se nao houver = -1
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
        return 1;
    }

    public static ArrayList<String> getOrdem(String s) {
        ArrayList<String> ordem = new ArrayList<String>();
        String buffer; // nao faco a minima se isto faz sentido mas e a unica palavra que consigo pensar
        int lastIndex = s.indexOf(':');
        int tamanhoReal;
        if(s.indexOf("cid:") != -1) tamanhoReal = 8;
        else tamanhoReal = 7;

        for (int i = 0; i < tamanhoReal; i++) {
            buffer = s.substring(s.indexOf(':', lastIndex) - 3, s.indexOf(':', lastIndex) + 1);
            lastIndex = s.indexOf(':', lastIndex + 1);
            ordem.add(buffer);
        }

        for (int i = 0; i < ordem.size(); i++) {
            System.out.println(ordem.get(i));
        }

        return ordem;
    }

    public static String getNext(String s, ArrayList<String> ordem) {
        System.out.println("A processar");
        int posicao = ordem.indexOf(s);
        if (ordem.get(posicao) == ordem.get(ordem.size() - 1)) return "#";
        return ordem.get(posicao + 1);
    }

    public static int verificarEcl(String s) {
        //possibilidades.addAll(0, "amb", "blu", "brn", "gry", "grn", "hzl", "oth");
        System.out.println("A processar ECL");
        if(s.equals("amb") || s.equals("blu") || s.equals("brn") || s.equals("gry") || s.equals("grn") || s.equals("hzl") || s.equals("oth")) return 1;
        else return 0;
    }
    
    public static int verificarHcl(String s) {
        char[] possibilidades = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        char[] vetor = s.toCharArray();
        int cntd = 0;
        if (!s.startsWith("#")) return 0;

        for (int i = 1; i < vetor.length; i++) {
            for (int j = 0; j < possibilidades.length; j++ ) {
                if (vetor[i] == possibilidades[j]) cntd++;
            }
        }
        if (cntd != 6) return 0;

        return 1;
    }
}
