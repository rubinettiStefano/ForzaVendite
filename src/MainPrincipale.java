import com.generation.database.HibernateUtil;
import entities.Azienda;
import entities.Dipendente;
import io.IoAzienda;
import io.IoDipendente;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import repositories.RepositoryAzienda;
import repositories.RepositoryDipendente;

import java.util.List;
import java.util.Scanner;

public class MainPrincipale
{
    //una parte di strumentazione, repositories e ios
    //ci dovrà essere un inzializzatore
    private static RepositoryAzienda ra;
    private static RepositoryDipendente rd;
    private static IoAzienda ia;
    private static IoDipendente id;

    private static Scanner sc = new Scanner(System.in);
    private static void init()
    {
        SessionFactory factory = HibernateUtil.getSessionFactory("forza_vendite");
        Session con = factory.openSession();
        ia = new IoAzienda(sc);
        ra = new RepositoryAzienda(con);
        id = new IoDipendente(sc);
        rd = new RepositoryDipendente(con);
    }

    //stampare aziende con loro distribuzione seniority
    //metodo main

    //obiettivo: creare nuovo dipendente
    static void main() {
        init();
        int cmd = 0;
        do
        {
            System.out.println("Inserisci comando");
            cmd = Integer.parseInt(sc.nextLine());

            switch (cmd)
            {
                case 1 -> createNewAzienda();
                case 2 -> distribuzioneSeniorities();
                case 3 -> cambiaFatturato();
                case 4 -> nuovoDipendente();
                case -1 -> System.out.println("BYE BYE");
                default -> System.out.println("Comando non valido");
            }

        }while (cmd!=-1);
    }

    private static void nuovoDipendente()
    {
        //1-Creare oggetto dipendente con i suoi dati inseriti da utente
        //IO
        Dipendente d = id.chiediDipendente();

        //trovare azienda a cui assegnarlo
        //leggere tutte aziende -> repo
        //mostrare a utente possibilita -> io
        //sceglierne 1 -> io
        Azienda scelta = dammiAziendaPerId();

        //salvarlo
        //repo
        //stabilire las relazione
        d.setDatore(scelta);
        rd.insert(d);
        System.out.println("Dipendente inserito");
    }

    private static Azienda dammiAziendaPerId()
    {
        List<Azienda> tutte = ra.findAll();
        for(Azienda a : tutte)
            System.out.println(a.getId() +" "+a.getRagioneSociale());
        return ia.selezionaAziendaPerId(tutte);
    }

    //MODIFICA FATTURATO DI SINGOLA AZIENDA
    private static void cambiaFatturato()
    {
        try
        {
            Azienda scelta = dammiAziendaPerId();
            System.out.println("Dammi nuovo fatturato");
            scelta.setFatturato(Double.parseDouble(sc.nextLine()));
            ra.update(scelta);
            System.out.println("Fatturato modificato");
        } catch (RuntimeException e)
        {
            System.out.println(e.getMessage());
            System.out.println("SE TI VA RIPROVA COMANDO");
        }
        //quale azienda
        //nuovo fatturato
    }

    private static void distribuzioneSeniorities()
    {
        List<Azienda> tutte = ra.findAll();
        ia.stampaSeniorities(tutte);
    }

    //metodi di supporto
    private static void createNewAzienda()
    {
        System.out.println("Benvenuto, stai per creare una nuova azienda");
        Azienda a = ia.chiediAzienda();
        ra.insert(a);
        System.out.println("Ben fatto, azienda creata");
    }



}


