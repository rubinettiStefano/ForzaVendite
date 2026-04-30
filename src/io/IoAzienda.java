package io;

import entities.Azienda;

import java.util.Scanner;

public class IoAzienda extends IoBase
{
    public IoAzienda(Scanner sc) {
        super(sc);
    }

    /**
     * Creerà un nuovo oggetto azienda chiedendo dati
     * a utente
     */
    public Azienda chiediAzienda()
    {
        System.out.println("Ora inserisci tutti dati azienda");
        Azienda a = new Azienda();
        System.out.println("Ragione Sociale");
        a.setRagioneSociale(sc.nextLine());
        System.out.println("Sede");
        a.setSede(sc.nextLine());
        System.out.println("Fondazione");
        a.setFondazione(inDate());
        System.out.println("Partita iva");
        a.setPiva(sc.nextLine());
        System.out.println("SDI");
        a.setSdi(sc.nextLine());
        System.out.println("Fatturato");
        a.setFatturato(inDouble());
        System.out.println("Capitale sociale");
        a.setCapitaleSociale(inDouble());

        return a;
    }
}
