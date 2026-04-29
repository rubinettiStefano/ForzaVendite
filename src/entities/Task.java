package entities;

import jakarta.persistence.*;

@Entity
public class Task
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    //@JoinColumn è opzionale, se non la mettette
    //lui crea in automatico una foreign key
    //con nomePadre_id
    private Dipendente operatore;




    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Dipendente getOperatore() {
        return operatore;
    }

    public void setOperatore(Dipendente operatore) {
        this.operatore = operatore;
    }
}
