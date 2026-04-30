package repositories;

import entities.Azienda;
import exceptions.DbException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class RepositoryAzienda extends RepositoryBase
{
    public RepositoryAzienda(Session sessione) {
        super(sessione);
    }

    //5 metodi di battaglia delle repository
    //lettura di tutto
    //lettura di singolo per id
    //creazione
    //modifica
    //cancellazione

    /**
     * Restituisce come lista tutte le aziende sul db
     * Non potrà mai fallire, anche se non ci sono aziende restituisce una lista
     * vuota
     */
    public List<Azienda> findAll()
    {
        //in hql se fate una lettura completa potete non scrive select
        //FROM Azienda -> SELECT a FROM Azienda a
        return con.createQuery("FROM Azienda", Azienda.class).getResultList();
    }

    /**
     * Se esiste azienda con id uguale a quello passato come parametro
     * la restituisce, altrimenti restituisce null
     */
    public Azienda findById(Integer id)
    {
        return con.find(Azienda.class,id);
    }

    public void insert(Azienda a)
    {
        Transaction t = con.beginTransaction();
        try {
            con.persist(a);
            t.commit();
        } catch (Exception e)
        {
            t.rollback();
            throw new DbException("Inserimento fallito");
        }
    }

    public void update(Azienda a)
    {
        Transaction t = con.beginTransaction();
        try {
            con.merge(a);
            t.commit();
        } catch (Exception e)
        {
            t.rollback();
            throw new DbException("Update fallito");
        }
    }

    public void delete(Azienda a)
    {
        Transaction t = con.beginTransaction();
        try {
            con.remove(a);
            t.commit();
        } catch (Exception e)
        {
            t.rollback();
            throw new DbException("Delete fallito");
        }
    }

    public void delete(Integer id)
    {
        Transaction t = con.beginTransaction();
        try {
            con.remove(findById(id));
            t.commit();
        } catch (Exception e)
        {
            t.rollback();
            throw new DbException("Delete fallito");
        }
    }

}
