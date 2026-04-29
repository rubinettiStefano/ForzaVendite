import com.generation.database.HibernateUtil;
import entities.Azienda;
import entities.Dipendente;
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

        Azienda az1 = new Azienda();
        az1.setRagioneSociale("Quantum Leap Technologies S.r.l.");
        az1.setSede("Milano, Via della Moscova 45");
        az1.setFondazione(LocalDate.of(2012, 5, 10));
        az1.setPiva("01234567890");
        az1.setSdi("SUBM70N");
        az1.setFatturato(2500000.0);
        az1.setCapitaleSociale(100000.0);

        Azienda az2 = new Azienda();
        az2.setRagioneSociale("BioGreen Solutions S.p.A.");
        az2.setSede("Roma, Via Appia Nuova 120");
        az2.setFondazione(LocalDate.of(2005, 11, 22));
        az2.setPiva("09876543211");
        az2.setSdi("KRRH6B9");
        az2.setFatturato(5800000.0);
        az2.setCapitaleSociale(500000.0);


        Transaction t = con.beginTransaction();
        con.persist(az1);
        con.persist(az2);
        t.commit();

    }
}
