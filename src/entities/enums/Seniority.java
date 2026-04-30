package entities.enums;

import java.util.Scanner;

public enum Seniority
{
    ENTRY,
    JUNIOR,
    MID,
    SENIOR,
    SUPERSENIOR;

    public static Seniority ottieni(Scanner sc)
    {
        Seniority[] tutti = Seniority.values();
        for(int i=0;i<tutti.length;i++)
            System.out.println(i+"-"+tutti[i]);
        System.out.println("Dammi il numero per la seniority");
        int numero=-1;
        while(true)
            try
            {
                numero= Integer.parseInt(sc.nextLine());
                if(numero>=0 && numero<tutti.length)
                    break;
                else
                    System.out.println("NON DISPONIBILE");
            }catch (Exception e)            {
                System.out.println("NON un numero");
            }

        return tutti[numero];
    }
}
