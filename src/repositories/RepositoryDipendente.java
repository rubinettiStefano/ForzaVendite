package repositories;

import entities.Dipendente;
import entities.enums.Seniority;
import exceptions.DbException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class RepositoryDipendente extends RepositoryBase{
    public RepositoryDipendente(Session sessione) {
        super(sessione);
    }

    public List<Dipendente> findAll()
    {
        return con.createQuery("FROM Dipendente", Dipendente.class).getResultList();
    }

    public Dipendente findById(Integer id)
    {
        return con.find(Dipendente.class,id);
    }

    public void insert(Dipendente a)
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

    public void update(Dipendente a)
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

    public void delete(Dipendente a)
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

    public List<Dipendente> filtraPerSeniority(Seniority s)
    {
        return con.createQuery("FROM Dipendente WHERE seniority= :val", Dipendente.class)
                .setParameter("val",s)
                .getResultList();
    }
}
