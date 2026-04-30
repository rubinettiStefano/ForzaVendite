package entities.enums;

import java.util.Scanner;

public enum Priorita
{
    ESTREMA,
    ALTA,
    MEDIA,
    BASSA;

    public static Priorita ottieni(Scanner sc)
    {
        Priorita[] tutti = Priorita.values();
        for(int i=0;i<tutti.length;i++)
            System.out.println(i+"-"+tutti[i]);
        System.out.println("Dammi il numero per la priorita");
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
