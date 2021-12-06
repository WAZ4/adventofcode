using System;

void part1()
{
    int counter = 0; // counter used  to register the amount of measurements larger thean the previous
    string line;

    int previous = -1; //previous measurament
    int current; //current measurament

    System.Console.WriteLine("waza");
    // Read the file and display it line by line.  
    IO.StreamReader file =
        new System.IO.StreamReader(@"/Users/goncaloantunes/Documents/adventofcode/2021/day01/input.txt");
    System.Console.WriteLine("waza");
    while ((line = file.ReadLine()) != null)
    {
        System.Console.WriteLine(line);

        current = int.Parse(line);

        if (current > previous && previous != -1)
        {
            counter++;
        }

        previous = current;
    }

    file.Close();
    System.Console.WriteLine("There are {0} measurements that are larger than the previous measurement.", counter);
    // Suspend the screen.  
    System.Console.ReadLine();
}

void part2()
{
    //using System;
    //using System.IO;
    //using System.Linq;

    int sucessCounter = 0; // counter used  to register the amount of measurements larger thean the previous
    int counter = 0;
    string line;
    var lineCount = File.ReadLines(@"/Users/goncaloantunes/Projects/adventofcode2021/adventofcode2021/input.txt").Count();

    int[] data = new int[lineCount];

    Console.WriteLine(lineCount);
    // Read the file and display it line by line.  
    StreamReader file =
        new StreamReader(@"/Users/goncaloantunes/Projects/adventofcode2021/adventofcode2021/input.txt");
    while ((line = file.ReadLine()) != null)
    {
        data[counter] = int.Parse(line);
        counter++;
    }

    file.Close();

    int soma = -1;
    for (int i = 0; i < data.Length; i++)
    {
        if (data.Length - i < 3)
        {
            break;
        }
        int N1 = data[i];
        int N2 = data[i + 1];
        int N3 = data[i + 2];

        int novaSoma = N1 + N2 + N3;
        if (novaSoma > soma && soma != -1)
        {
            sucessCounter++;
            Console.WriteLine("Sucesso");
        }
        else Console.WriteLine("Desceu ou Igual");
        soma = novaSoma;
    }

    Console.WriteLine("There are {0} measurements that are larger than the previous measurement.", sucessCounter);
    // Suspend the screen.  
    Console.ReadLine();
}

System.Console.WriteLine("waza");
part1();