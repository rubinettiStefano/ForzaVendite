package repositories;

import org.hibernate.Session;

public abstract class RepositoryBase
{
    protected Session con;

    public RepositoryBase(Session sessione)
    {
        con = sessione;
    }

}
