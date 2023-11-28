import java.util.Arrays;
import java.util.Scanner;

public class Cinemas_class {
    // Класс информации о кинотеатре
    class cinemas
    {
        public void CinemasInfo()
        {
            System.out.println("-");
            System.out.print("Does it have parking? ");
            if (hasParking)
                System.out.println("Yes");
            else
                System.out.println("No");
            System.out.println("");

            System.out.println("This cinema has " + halls.length + " halls:");
            for(int i = 0; i < halls.length;i++)
            {
                int n = i+1;
                System.out.println("Information about the" + n +" hall: ");
                halls[i].HallInfo();
            }
            System.out.println("---");
        }
        Cinemas_class.halls[] halls;
        boolean hasParking;
        int price;
    }

    static class halls
    {
        // класс информации о залах
        public void HallInfo()
        {
            System.out.println("There are " + places.length + " rows in this hall with " + places[0].length + " seats each.");
            System.out.println("This hall has the following sessions: ");

            for(int i = 0; i< session.length; i++)
            {
                int n = i+1;
                int beginHour = session[i][0];
                int duration = session[i][1];
                System.out.println("Session № " + n +". Starts at " + beginHour + " o'clock. Lasts  " + duration + " hours.");
            }

            System.out.println("");
        }

        public void MarkPlaces()
        {
            for (int i = 0; i < places.length; i++)
                Arrays.fill(places[i],false);
        }

        int[][] session;
        boolean [][] places;
    }
    public static void Info(cinemas[] cinemas)
    {
        for (int i  = 0; i<cinemas.length;i++)
        {
            int n = i+1;
            System.out.println("Information about cinema " + n );
            cinemas[i].CinemasInfo();
        }
    }
    // Заполнение информации об имеющихся кинотеатрах
    public void filling_out_information()
    {
        halls hall1 = new halls();
        hall1.session = new int[][] {{10,2}, {13,3}, {17,1}};
        hall1.places = new boolean[10][10];
        hall1.MarkPlaces();
        halls hall2 = new halls();
        hall2.session = new int[][]{{11,2}};
        hall2.places = new boolean[7][40];
        hall2.MarkPlaces();
        halls hall3 = new halls();
        hall3.session = new int[][]{{14,4}, {13,2}};
        hall3.places = new boolean[5][5];
        hall3.MarkPlaces();

        cinemas cinema1 = new cinemas();
        cinema1.halls = new halls[]{hall1, hall2, hall3};
        cinema1.hasParking = false;
        cinema1.price = 250;

        halls hall4 = new halls();
        hall4.session = new int[][]{{19,2}};
        hall4.places = new boolean[8][10];
        hall4.MarkPlaces();
        halls hall5 = new halls();
        hall5.session = new int[][]{{8,5}, {14,2}, {16,1}};
        hall5.places = new boolean[9][9];
        hall5.MarkPlaces();

        cinemas cinema2 = new cinemas();
        cinema2.halls = new halls[]{hall4, hall5};
        cinema2.hasParking = true;
        cinema2.price = 350;

        cinemas[] cinemas = {cinema1, cinema2};
        Scanner in = new Scanner(System.in);

        System.out.println("We have 2 cinemas, information about them ");
        Info(cinemas);

        while(true)
        {
            System.out.println("Select a cinema (press 0 to exit) ");
            int c = in.nextInt();

            if(c == 0)
                break;
            else if (c!=1 && c!=2) {
                System.out.println("Error, cinema " + c + " does not exist");
                continue;
            }

            Cinemas_class.cinemas currCinema = cinemas[c-1];

            System.out.println("Select one hall from " + currCinema.halls.length);
            int h = in.nextInt();

            if(h==0)
                break;

            while(h!=0)
            {
                if(h <= currCinema.halls.length && h>0)
                    break;
                else {
                    System.out.println("Error, hall " + c + "does not exist");
                    h = in.nextInt();
                }
            }

            halls currHall = currCinema.halls[h-1];

            System.out.println("How many tickets do you want to buy at the price " + currCinema.price);
            int count = in.nextInt();

            while(count!=0)
            {
                System.out.println("Select a location by entering the row first and then the location:");
                int column = in.nextInt()-1;
                int row = in.nextInt()-1;

                if(currHall.places[column][row])
                {
                    System.out.println("Is this seat taken. List of all purchased items:");

                    for(int i =0 ; i <currHall.places.length;i++)
                        for(int j = 0; j<currHall.places[i].length;j++)
                            if(currHall.places[i][j])
                                System.out.println("Row: " + i + ", Place: " + j);
                }
                else
                {
                    currHall.places[column][row] = true;
                    count--;
                }
            }
            System.out.println("\n" + "You have successfully purchased your ticket");
            in.nextInt();
        }
    }
}
