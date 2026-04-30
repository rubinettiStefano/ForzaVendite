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


    /*
        1 - come si chiama -> findById
        2 - che tipo di valore produce ->
            un OGGETTO AZIENDA
        3 - che valori richiede in entrata, parametri, (tipo e nome) ->
            un Integer chiamato id
        4 - cosa usa del this (quali proprietà e metodi usa del suo oggetto) ->
            con, la session
        5  - per cosa usa la proprietà ->
         ci richiama il metodo find
        6 - per cosa usa il parametro ->
            viene passato come secondo parametro del metodo find

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
