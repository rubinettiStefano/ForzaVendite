package io;

import entities.Azienda;
import entities.enums.Seniority;

import java.util.List;
import java.util.Map;
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

    public void stampaSeniorities(List<Azienda> tutte)
    {
        for(Azienda a : tutte)
        {
            Map<Seniority,Integer> mappa = a.senioritiesToNumero();
            System.out.println("-------------------------");
            System.out.println("Nome azienda: "+a.getRagioneSociale());
            for(Seniority s: Seniority.values()) {
                int numero = mappa.get(s);
                if(numero!=0)
                    System.out.println(s + " " +numero);
            }
        }
        System.out.println("-------------------------");
    }

    public Azienda selezionaAziendaPerId(List<Azienda> tutte)
    {
        System.out.println("Dammi id dell'azienda");
        int id = inInt();
        Azienda res=null;
        for(Azienda a:tutte)
            if(a.getId()==id)
                res=a;
        if(res==null)
            throw new RuntimeException("Azienda non esistente");

        return res;
    }
}
