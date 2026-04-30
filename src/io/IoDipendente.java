package io;

import entities.Dipendente;
import entities.enums.Seniority;
import entities.enums.TipoContratto;

import java.util.Scanner;

public class IoDipendente extends IoBase
{
    public IoDipendente(Scanner sc) {
        super(sc);
    }

    public Dipendente chiediDipendente()
    {
        System.out.println("Inserisci dati dipendente");
        Dipendente res = new Dipendente();
        System.out.println("nominativo");
        res.setNominativo(sc.nextLine());
        System.out.println("stipendio");
        res.setStipendio(inDouble());
        res.setTipoContratto(TipoContratto.ottieni(sc));
        if(res.getTipoContratto()!=TipoContratto.INDETERMINATO)
        {
            System.out.println("scadenza");
            res.setScadenza(inDate());
        }
        res.setSeniority(Seniority.ottieni(sc));
        return res;
    }
}
