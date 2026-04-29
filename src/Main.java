import com.generation.database.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Main
{
    static void main() {
        SessionFactory factory = HibernateUtil.getSessionFactory("forza_vendite");
        Session con = factory.openSession();
    }
}
