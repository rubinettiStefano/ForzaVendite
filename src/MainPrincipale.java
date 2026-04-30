import com.generation.database.HibernateUtil;
import entities.Azienda;
import io.IoAzienda;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import repositories.RepositoryAzienda;

import java.util.List;
import java.util.Scanner;

public class MainPrincipale
{
    //una parte di strumentazione, repositories e ios
    //ci dovrà essere un inzializzatore
    private static RepositoryAzienda ra;
    private static IoAzienda ia;
    private static Scanner sc = new Scanner(System.in);
    private static void init()
    {
        SessionFactory factory = HibernateUtil.getSessionFactory("forza_vendite");
        Session con = factory.openSession();
        ia = new IoAzienda(sc);
        ra = new RepositoryAzienda(con);
    }

    //stampare aziende con loro distribuzione seniority
    //metodo main
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
                case -1 -> System.out.println("BYE BYE");
                default -> System.out.println("Comando non valido");
            }

        }while (cmd!=-1);
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
