import com.generation.database.HibernateUtil;
import entities.Azienda;
import entities.Dipendente;
import entities.enums.Seniority;
import entities.enums.TipoContratto;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.time.LocalDate;

public class Main
{
    static void main() {
        SessionFactory factory = HibernateUtil.getSessionFactory("forza_vendite");
        Session con = factory.openSession();

        // Dipendente 1
        Dipendente d1 = new Dipendente();
        d1.setNominativo("Alessandro Riva");
        d1.setStipendio(2400.0);
        d1.setTipoContratto(TipoContratto.INDETERMINATO);
        d1.setSeniority(Seniority.SENIOR);
        d1.setScadenza(null);

// Dipendente 2
        Dipendente d2 = new Dipendente();
        d2.setNominativo("Beatrice Conti");
        d2.setStipendio(1650.0);
        d2.setTipoContratto(TipoContratto.APPRENDISTATO);
        d2.setSeniority(Seniority.JUNIOR);
        d2.setScadenza(LocalDate.of(2027, 3, 15));

// Dipendente 3
        Dipendente d3 = new Dipendente();
        d3.setNominativo("Claudio De Luca");
        d3.setStipendio(3200.0);
        d3.setTipoContratto(TipoContratto.INDETERMINATO);
        d3.setSeniority(Seniority.SUPERSENIOR);
        d3.setScadenza(null);

// Dipendente 4
        Dipendente d4 = new Dipendente();
        d4.setNominativo("Daniela Moretti");
        d4.setStipendio(2100.0);
        d4.setTipoContratto(TipoContratto.DETERMINATO);
        d4.setSeniority(Seniority.MID);
        d4.setScadenza(LocalDate.of(2025, 12, 31));

// Dipendente 5
        Dipendente d5 = new Dipendente();
        d5.setNominativo("Enrico Ferro");
        d5.setStipendio(2800.0);
        d5.setTipoContratto(TipoContratto.INDETERMINATO);
        d5.setSeniority(Seniority.SENIOR);
        d5.setScadenza(null);

        Transaction t = con.beginTransaction();
        t.commit();

    }
}
