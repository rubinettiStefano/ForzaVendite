import com.generation.database.HibernateUtil;
import entities.Azienda;
import entities.Cartellino;
import entities.Dipendente;
import entities.Task;
import entities.enums.Priorita;
import entities.enums.Seniority;
import entities.enums.TipoContratto;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

// Assicurati di avere l'import corretto per il tuo HibernateUtil
// import utils.HibernateUtil;

import java.time.LocalDate;
import java.time.LocalTime;

//drop database forza_vendite;
//create database forza_vendite;
//avviare qui

public class InizializzaDb {
    public static void main(String[] args) {

        SessionFactory factory = HibernateUtil.getSessionFactory("forza_vendite");
        Session con = factory.openSession();
        Transaction t = con.beginTransaction();

        try {
            // ==========================================
            // 1. CREAZIONE E SALVATAGGIO AZIENDE
            // ==========================================
            Azienda az1 = new Azienda();
            az1.setRagioneSociale("Quantum Leap Technologies S.r.l.");
            az1.setSede("Milano, Via della Moscova 45");
            az1.setFondazione(LocalDate.of(2012, 5, 10));
            az1.setPiva("01234567890");
            az1.setSdi("SUBM70N");
            az1.setFatturato(2500000.0);
            az1.setCapitaleSociale(100000.0);
            con.persist(az1);

            Azienda az2 = new Azienda();
            az2.setRagioneSociale("BioGreen Solutions S.p.A.");
            az2.setSede("Roma, Via Appia Nuova 120");
            az2.setFondazione(LocalDate.of(2005, 11, 22));
            az2.setPiva("09876543211");
            az2.setSdi("KRRH6B9");
            az2.setFatturato(5800000.0);
            az2.setCapitaleSociale(500000.0);
            con.persist(az2);

            // ==========================================
            // 2. CREAZIONE E SALVATAGGIO DIPENDENTI
            // ==========================================
            Dipendente d1 = new Dipendente();
            d1.setNominativo("Alessandro Riva");
            d1.setStipendio(2400.0);
            d1.setTipoContratto(TipoContratto.INDETERMINATO);
            d1.setSeniority(Seniority.SENIOR);
            d1.setScadenza(null);
            d1.setDatore(az1);
            con.persist(d1);

            Dipendente d2 = new Dipendente();
            d2.setNominativo("Beatrice Conti");
            d2.setStipendio(1650.0);
            d2.setTipoContratto(TipoContratto.APPRENDISTATO);
            d2.setSeniority(Seniority.JUNIOR);
            d2.setScadenza(LocalDate.of(2027, 3, 15));
            d2.setDatore(az1);
            con.persist(d2);

            Dipendente d3 = new Dipendente();
            d3.setNominativo("Claudio De Luca");
            d3.setStipendio(3200.0);
            d3.setTipoContratto(TipoContratto.INDETERMINATO);
            d3.setSeniority(Seniority.SUPERSENIOR);
            d3.setScadenza(null);
            d3.setDatore(az1);
            con.persist(d3);

            Dipendente d4 = new Dipendente();
            d4.setNominativo("Daniela Moretti");
            d4.setStipendio(2100.0);
            d4.setTipoContratto(TipoContratto.DETERMINATO);
            d4.setSeniority(Seniority.MID);
            d4.setScadenza(LocalDate.of(2025, 12, 31));
            d4.setDatore(az2);
            con.persist(d4);

            Dipendente d5 = new Dipendente();
            d5.setNominativo("Enrico Ferro");
            d5.setStipendio(2800.0);
            d5.setTipoContratto(TipoContratto.INDETERMINATO);
            d5.setSeniority(Seniority.SENIOR);
            d5.setScadenza(null);
            d5.setDatore(az2);
            con.persist(d5);

            // ==========================================
            // 3. CREAZIONE E SALVATAGGIO TASK
            // ==========================================
            Task t1 = new Task();
            t1.setDescrizione("Analisi fattibilitÃ  modulo AI");
            t1.setPriorita(Priorita.ALTA);
            t1.setAssegnato_il(LocalDate.of(2024, 2, 1));
            t1.setScade_il(LocalDate.of(2024, 2, 10));
            t1.setConcluso(true);
            t1.setOperatore(d1);
            con.persist(t1);

            Task t2 = new Task();
            t2.setDescrizione("Correzione bug critico login");
            t2.setPriorita(Priorita.ESTREMA);
            t2.setAssegnato_il(LocalDate.of(2024, 2, 2));
            t2.setScade_il(LocalDate.of(2024, 2, 3));
            t2.setConcluso(true);
            t2.setOperatore(d1);
            con.persist(t2);

            Task t3 = new Task();
            t3.setDescrizione("Aggiornamento manuale utente");
            t3.setPriorita(Priorita.BASSA);
            t3.setAssegnato_il(LocalDate.of(2024, 2, 1));
            t3.setScade_il(LocalDate.of(2024, 3, 1));
            t3.setConcluso(false);
            t3.setOperatore(d1);
            con.persist(t3);

            Task t4 = new Task();
            t4.setDescrizione("Refactoring database legacy");
            t4.setPriorita(Priorita.MEDIA);
            t4.setAssegnato_il(LocalDate.of(2024, 2, 5));
            t4.setScade_il(LocalDate.of(2024, 2, 15));
            t4.setConcluso(false);
            t4.setOperatore(d2);
            con.persist(t4);

            Task t5 = new Task();
            t5.setDescrizione("Meeting pianificazione sprint");
            t5.setPriorita(Priorita.MEDIA);
            t5.setAssegnato_il(LocalDate.of(2024, 2, 6));
            t5.setScade_il(LocalDate.of(2024, 2, 6));
            t5.setConcluso(true);
            t5.setOperatore(d2);
            con.persist(t5);

            Task t6 = new Task();
            t6.setDescrizione("Integrazione API gateway");
            t6.setPriorita(Priorita.ALTA);
            t6.setAssegnato_il(LocalDate.of(2024, 2, 10));
            t6.setScade_il(LocalDate.of(2024, 2, 20));
            t6.setConcluso(false);
            t6.setOperatore(d3);
            con.persist(t6);

            Task t7 = new Task();
            t7.setDescrizione("Ottimizzazione query dashboard");
            t7.setPriorita(Priorita.MEDIA);
            t7.setAssegnato_il(LocalDate.of(2024, 2, 11));
            t7.setScade_il(LocalDate.of(2024, 2, 14));
            t7.setConcluso(true);
            t7.setOperatore(d3);
            con.persist(t7);

            Task t8 = new Task();
            t8.setDescrizione("Test sicurezza penetrazione");
            t8.setPriorita(Priorita.ESTREMA);
            t8.setAssegnato_il(LocalDate.of(2024, 2, 12));
            t8.setScade_il(LocalDate.of(2024, 2, 13));
            t8.setConcluso(false);
            t8.setOperatore(d3);
            con.persist(t8);

            Task t9 = new Task();
            t9.setDescrizione("Setup ambiente di produzione");
            t9.setPriorita(Priorita.ALTA);
            t9.setAssegnato_il(LocalDate.of(2024, 2, 15));
            t9.setScade_il(LocalDate.of(2024, 2, 16));
            t9.setConcluso(true);
            t9.setOperatore(d4);
            con.persist(t9);

            Task t10 = new Task();
            t10.setDescrizione("Scrittura unit test pagamenti");
            t10.setPriorita(Priorita.MEDIA);
            t10.setAssegnato_il(LocalDate.of(2024, 2, 16));
            t10.setScade_il(LocalDate.of(2024, 2, 20));
            t10.setConcluso(false);
            t10.setOperatore(d4);
            con.persist(t10);

            Task t11 = new Task();
            t11.setDescrizione("Review architettura cloud");
            t11.setPriorita(Priorita.ALTA);
            t11.setAssegnato_il(LocalDate.of(2024, 2, 18));
            t11.setScade_il(LocalDate.of(2024, 2, 21));
            t11.setConcluso(false);
            t11.setOperatore(d5);
            con.persist(t11);

            Task t12 = new Task();
            t12.setDescrizione("Pulizia file temporanei");
            t12.setPriorita(Priorita.BASSA);
            t12.setAssegnato_il(LocalDate.of(2024, 2, 19));
            t12.setScade_il(LocalDate.of(2024, 2, 19));
            t12.setConcluso(true);
            t12.setOperatore(d5);
            con.persist(t12);

            Task t13 = new Task();
            t13.setDescrizione("Ricerca componenti frontend");
            t13.setPriorita(Priorita.MEDIA);
            t13.setAssegnato_il(LocalDate.of(2024, 2, 20));
            t13.setScade_il(LocalDate.of(2024, 2, 28));
            t13.setConcluso(false);
            t13.setOperatore(d5);
            con.persist(t13);

            // ==========================================
            // 4. CREAZIONE E SALVATAGGIO CARTELLINI
            // ==========================================
            Cartellino c1 = new Cartellino();
            c1.setGiorno(LocalDate.of(2024, 2, 1));
            c1.setInizio(LocalTime.of(8, 30));
            c1.setFine(LocalTime.of(17, 30));
            c1.setTimbratore(d1);
            con.persist(c1);

            Cartellino c2 = new Cartellino();
            c2.setGiorno(LocalDate.of(2024, 2, 2));
            c2.setInizio(LocalTime.of(9, 0));
            c2.setFine(LocalTime.of(18, 0));
            c2.setTimbratore(d1);
            con.persist(c2);

            Cartellino c3 = new Cartellino();
            c3.setGiorno(LocalDate.of(2024, 2, 1));
            c3.setInizio(LocalTime.of(9, 15));
            c3.setFine(LocalTime.of(18, 15));
            c3.setTimbratore(d2);
            con.persist(c3);

            Cartellino c4 = new Cartellino();
            c4.setGiorno(LocalDate.of(2024, 2, 2));
            c4.setInizio(LocalTime.of(8, 0));
            c4.setFine(LocalTime.of(17, 0));
            c4.setTimbratore(d2);
            con.persist(c4);

            Cartellino c5 = new Cartellino();
            c5.setGiorno(LocalDate.of(2024, 2, 1));
            c5.setInizio(LocalTime.of(9, 30));
            c5.setFine(LocalTime.of(19, 0));
            c5.setTimbratore(d3);
            con.persist(c5);

            Cartellino c6 = new Cartellino();
            c6.setGiorno(LocalDate.of(2024, 2, 2));
            c6.setInizio(LocalTime.of(8, 45));
            c6.setFine(LocalTime.of(17, 45));
            c6.setTimbratore(d3);
            con.persist(c6);

            Cartellino c7 = new Cartellino();
            c7.setGiorno(LocalDate.of(2024, 2, 3));
            c7.setInizio(LocalTime.of(9, 0));
            c7.setFine(LocalTime.of(13, 0));
            c7.setTimbratore(d3);
            con.persist(c7);

            Cartellino c8 = new Cartellino();
            c8.setGiorno(LocalDate.of(2024, 2, 1));
            c8.setInizio(LocalTime.of(14, 0));
            c8.setFine(LocalTime.of(20, 0));
            c8.setTimbratore(d4);
            con.persist(c8);

            Cartellino c9 = new Cartellino();
            c9.setGiorno(LocalDate.of(2024, 2, 2));
            c9.setInizio(LocalTime.of(9, 0));
            c9.setFine(LocalTime.of(18, 0));
            c9.setTimbratore(d4);
            con.persist(c9);

            Cartellino c10 = new Cartellino();
            c10.setGiorno(LocalDate.of(2024, 2, 1));
            c10.setInizio(LocalTime.of(8, 30));
            c10.setFine(LocalTime.of(17, 30));
            c10.setTimbratore(d5);
            con.persist(c10);

            Cartellino c11 = new Cartellino();
            c11.setGiorno(LocalDate.of(2024, 2, 2));
            c11.setInizio(LocalTime.of(9, 0));
            c11.setFine(LocalTime.of(18, 0));
            c11.setTimbratore(d5);
            con.persist(c11);

            Cartellino c12 = new Cartellino();
            c12.setGiorno(LocalDate.of(2024, 2, 3));
            c12.setInizio(LocalTime.of(9, 0));
            c12.setFine(LocalTime.of(18, 0));
            c12.setTimbratore(d5);
            con.persist(c12);

            Cartellino c13 = new Cartellino();
            c13.setGiorno(LocalDate.of(2024, 2, 4));
            c13.setInizio(LocalTime.of(10, 0));
            c13.setFine(LocalTime.of(19, 0));
            c13.setTimbratore(d5);
            con.persist(c13);

            // Conferma e salva le modifiche nel database
            t.commit();
            System.out.println("Salvataggio completato con successo nel database!");

        } catch (Exception e) {
            // In caso di errore (es. violazione dei vincoli @Check o errori di connessione), annulla tutto
            if (t != null) {
                t.rollback();
                System.out.println("Si Ã¨ verificato un errore, transazione annullata.");
            }
            e.printStackTrace();
        } finally {
            // Chiudi sessione e factory
            if (con != null) {
                con.close();
            }
            if (factory != null) {
                factory.close();
            }
        }
    }
}