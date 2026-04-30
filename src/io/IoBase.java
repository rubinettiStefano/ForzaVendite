package io;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public abstract class IoBase
{
    protected Scanner sc;

    public IoBase(Scanner sc) {
        this.sc = sc;
    }

    protected int inInt()
    {
        while(true)
            try {
                int res = Integer.parseInt(sc.nextLine());
                return res;
            }catch (Exception e)            {
                System.out.println("NON un numero");
            }
    }

    protected double inDouble()
    {
        while(true)
            try {
                double res = Double.parseDouble(sc.nextLine());
                return res;
            }catch (Exception e)            {
                System.out.println("NON un double");
            }
    }

    protected LocalDate inDate()
    {
        while(true)
            try {
                LocalDate res = LocalDate.parse(sc.nextLine());
                return res;
            }catch (Exception e)            {
                System.out.println("NON una data (yyyy-MM-dd)");
            }
    }

    protected LocalTime inTime()
    {
        while(true)
            try {
                LocalTime res = LocalTime.parse(sc.nextLine());
                return res;
            }catch (Exception e)            {
                System.out.println("NON un tempo (hh:mm)");
            }
    }
}
