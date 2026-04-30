import com.generation.database.HibernateUtil;
import entities.Azienda;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import repositories.RepositoryAzienda;

import java.util.List;

public class Prova
{
    static void main() {
        SessionFactory factory = HibernateUtil.getSessionFactory("forza_vendite");
        Session con = factory.openSession();
        RepositoryAzienda ra = new RepositoryAzienda(con);


    }
}
