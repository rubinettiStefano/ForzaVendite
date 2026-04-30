import com.generation.database.HibernateUtil;
import entities.Cartellino;
import entities.Dipendente;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import repositories.RepositoryAzienda;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class OldInserimenti
{
    static void main() {
        SessionFactory factory = HibernateUtil.getSessionFactory("forza_vendite");
        Session con = factory.openSession();

        RepositoryAzienda ra = new RepositoryAzienda(con);

        List<Dipendente> tutti = con
                            .createQuery("SELECT d FROM Dipendente d", Dipendente.class)
                            .getResultList();


//
//
//
//
//        Task t1 = new Task();
//        t1.setDescrizione("Analisi fattibilità modulo AI");
//        t1.setPriorita(Priorita.ALTA);
//        t1.setAssegnato_il(LocalDate.of(2024, 1, 10));
//        t1.setScade_il(LocalDate.of(2024, 1, 20));
//        t1.setConcluso(true);
//
//        Task t2 = new Task();
//        t2.setDescrizione("Correzione bug critico login");
//        t2.setPriorita(Priorita.ESTREMA);
//        t2.setAssegnato_il(LocalDate.of(2024, 1, 12));
//        t2.setScade_il(LocalDate.of(2024, 1, 13));
//        t2.setConcluso(true);
//
//        Task t3 = new Task();
//        t3.setDescrizione("Aggiornamento manuale utente");
//        t3.setPriorita(Priorita.BASSA);
//        t3.setAssegnato_il(LocalDate.of(2024, 1, 15));
//        t3.setScade_il(LocalDate.of(2024, 2, 15));
//        t3.setConcluso(false);
//
//        Task t4 = new Task();
//        t4.setDescrizione("Refactoring database legacy");
//        t4.setPriorita(Priorita.MEDIA);
//        t4.setAssegnato_il(LocalDate.of(2024, 2, 1));
//        t4.setScade_il(LocalDate.of(2024, 2, 10));
//        t4.setConcluso(false);
//
//        Task t5 = new Task();
//        t5.setDescrizione("Meeting pianificazione sprint 4");
//        t5.setPriorita(Priorita.MEDIA);
//        t5.setAssegnato_il(LocalDate.of(2024, 2, 5));
//        t5.setScade_il(LocalDate.of(2024, 2, 5));
//        t5.setConcluso(true);
//
//        Task t6 = new Task();
//        t6.setDescrizione("Integrazione API gateway");
//        t6.setPriorita(Priorita.ALTA);
//        t6.setAssegnato_il(LocalDate.of(2024, 2, 6));
//        t6.setScade_il(LocalDate.of(2024, 2, 15));
//        t6.setConcluso(false);
//
//        Task t7 = new Task();
//        t7.setDescrizione("Ottimizzazione query dashboard");
//        t7.setPriorita(Priorita.MEDIA);
//        t7.setAssegnato_il(LocalDate.of(2024, 2, 8));
//        t7.setScade_il(LocalDate.of(2024, 2, 12));
//        t7.setConcluso(true);
//
//        Task t8 = new Task();
//        t8.setDescrizione("Test sicurezza penetrazione");
//        t8.setPriorita(Priorita.ESTREMA);
//        t8.setAssegnato_il(LocalDate.of(2024, 2, 10));
//        t8.setScade_il(LocalDate.of(2024, 2, 11));
//        t8.setConcluso(false);
//
//        Task t9 = new Task();
//        t9.setDescrizione("Setup ambiente di produzione");
//        t9.setPriorita(Priorita.ALTA);
//        t9.setAssegnato_il(LocalDate.of(2024, 2, 12));
//        t9.setScade_il(LocalDate.of(2024, 2, 14));
//        t9.setConcluso(true);
//
//        Task t10 = new Task();
//        t10.setDescrizione("Scrittura unit test modulo pagamenti");
//        t10.setPriorita(Priorita.MEDIA);
//        t10.setAssegnato_il(LocalDate.of(2024, 2, 14));
//        t10.setScade_il(LocalDate.of(2024, 2, 20));
//        t10.setConcluso(false);
//
//        Task t11 = new Task();
//        t11.setDescrizione("Review architetturale sistema cloud");
//        t11.setPriorita(Priorita.ALTA);
//        t11.setAssegnato_il(LocalDate.of(2024, 2, 15));
//        t11.setScade_il(LocalDate.of(2024, 2, 18));
//        t11.setConcluso(false);
//
//        Task t12 = new Task();
//        t12.setDescrizione("Pulizia file temporanei server");
//        t12.setPriorita(Priorita.BASSA);
//        t12.setAssegnato_il(LocalDate.of(2024, 2, 16));
//        t12.setScade_il(LocalDate.of(2024, 2, 16));
//        t12.setConcluso(true);
//
//        Task t13 = new Task();
//        t13.setDescrizione("Ricerca nuovi componenti frontend");
//        t13.setPriorita(Priorita.MEDIA);
//        t13.setAssegnato_il(LocalDate.of(2024, 2, 17));
//        t13.setScade_il(LocalDate.of(2024, 2, 25));
//        t13.setConcluso(false);



        /*
        i     indiceDipendente (i%5)
        0       0
        1       1
        2       2
        3       3
        4       4
        5       0
        6       1
        7       2
        8       3
        9       4
        10      0
        11      1
        12      2
       */



        Cartellino c1 = new Cartellino();
        c1.setGiorno(LocalDate.of(2024, 2, 1));
        c1.setInizio(LocalTime.of(8, 30));
        c1.setFine(LocalTime.of(17, 30));

        Cartellino c2 = new Cartellino();
        c2.setGiorno(LocalDate.of(2024, 2, 2));
        c2.setInizio(LocalTime.of(9, 0));
        c2.setFine(LocalTime.of(18, 0));

        Cartellino c3 = new Cartellino();
        c3.setGiorno(LocalDate.of(2024, 2, 3));
        c3.setInizio(LocalTime.of(9, 15));
        c3.setFine(LocalTime.of(18, 15));

        Cartellino c4 = new Cartellino();
        c4.setGiorno(LocalDate.of(2024, 2, 4));
        c4.setInizio(LocalTime.of(8, 0));
        c4.setFine(LocalTime.of(17, 0));

        Cartellino c5 = new Cartellino();
        c5.setGiorno(LocalDate.of(2024, 2, 5));
        c5.setInizio(LocalTime.of(9, 30));
        c5.setFine(LocalTime.of(19, 0));

        Cartellino c6 = new Cartellino();
        c6.setGiorno(LocalDate.of(2024, 2, 6));
        c6.setInizio(LocalTime.of(8, 45));
        c6.setFine(LocalTime.of(17, 45));

        Cartellino c7 = new Cartellino();
        c7.setGiorno(LocalDate.of(2024, 2, 7));
        c7.setInizio(LocalTime.of(9, 0));
        c7.setFine(LocalTime.of(13, 0)); // Mezza giornata

        Cartellino c8 = new Cartellino();
        c8.setGiorno(LocalDate.of(2024, 2, 8));
        c8.setInizio(LocalTime.of(14, 0));
        c8.setFine(LocalTime.of(20, 0));

        Cartellino c9 = new Cartellino();
        c9.setGiorno(LocalDate.of(2024, 2, 9));
        c9.setInizio(LocalTime.of(9, 0));
        c9.setFine(LocalTime.of(18, 0));

        Cartellino c10 = new Cartellino();
        c10.setGiorno(LocalDate.of(2024, 2, 10));
        c10.setInizio(LocalTime.of(8, 30));
        c10.setFine(LocalTime.of(17, 30));

        Cartellino c11 = new Cartellino();
        c11.setGiorno(LocalDate.of(2024, 2, 11));
        c11.setInizio(LocalTime.of(9, 0));
        c11.setFine(LocalTime.of(18, 0));

        Cartellino c12 = new Cartellino();
        c12.setGiorno(LocalDate.of(2024, 2, 12));
        c12.setInizio(LocalTime.of(9, 0));
        c12.setFine(LocalTime.of(18, 0));

        Cartellino c13 = new Cartellino();
        c13.setGiorno(LocalDate.of(2024, 2, 13));
        c13.setInizio(LocalTime.of(10, 0));
        c13.setFine(LocalTime.of(19, 0));


        List<Cartellino> cartellini = List.of(c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13);

        int numeroDipendenti = tutti.size();//0 a 4
        for(int i=0;i<cartellini.size();i++)
        {
            int indiceDipendente = i%numeroDipendenti;
            cartellini.get(i).setTimbratore(tutti.get(indiceDipendente));
        }

        Transaction t = con.beginTransaction();
        for(Cartellino ta:cartellini)
            con.persist(ta);
        t.commit();


    }
}
