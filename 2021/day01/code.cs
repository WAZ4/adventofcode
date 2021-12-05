

static void part1()
{
    int counter = 0; // counter used  to register the amount of measurements larger thean the previous
    string line;

    int previous = -1; //previous measurament
    int current; //current measurament

    // Read the file and display it line by line.  
    System.IO.StreamReader file =
        new System.IO.StreamReader(@"/Users/goncaloantunes/Projects/adventofcode2021/adventofcode2021/input.txt");
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