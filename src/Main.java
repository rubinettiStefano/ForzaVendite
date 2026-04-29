import com.generation.database.HibernateUtil;
import entities.Dipendente;
import entities.enums.TipoContratto;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Main
{
    static void main() {
        SessionFactory factory = HibernateUtil.getSessionFactory("forza_vendite");
        Session con = factory.openSession();

        Dipendente d = new Dipendente();

        //valore enum
        d.tipoContratto = TipoContratto.INDETERMINATO;
    }
}
