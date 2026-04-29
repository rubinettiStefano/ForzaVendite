package entities;


import entities.enums.TipoContratto;
import jakarta.persistence.*;
import org.hibernate.annotations.Check;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
//@Table opzionale se vogliamo che tabella abbia stesso nome
@Check(
        name = "controllo_scadenza_contratto",
        constraints = "(tipoContratto = 'INDETERMINATO' AND scadenza IS NULL) OR (tipoContratto != 'INDETERMINATO' AND scadenza IS NOT NULL)"
)
public class Dipendente
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;//può essere NULL

    @Column(nullable = false,length = 50)
    private String nominativo;
    @Column(nullable = false)
    private double stipendio;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)//lui nel db
    private TipoContratto tipoContratto;
    private LocalDate scadenza;

    //se tipoContratto è indeterminato, la scadenza DEVE essere null
    //se non lo è, NON deve essere null
    //cascade = CascadeType.ALL -> se salvo un DIPENDENTE, SALVA ANCHE LE SUE TASKS
    //orphanRemoval = ture -> ON DELETE CASCADE di SQL
    @OneToMany(mappedBy = "operatore",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Task>  tasks = new ArrayList<>();




    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNominativo() {
        return nominativo;
    }

    public void setNominativo(String nominativo) {
        this.nominativo = nominativo;
    }

    public double getStipendio() {
        return stipendio;
    }

    public void setStipendio(double stipendio) {
        this.stipendio = stipendio;
    }

    public TipoContratto getTipoContratto() {
        return tipoContratto;
    }

    public void setTipoContratto(TipoContratto tipoContratto) {
        this.tipoContratto = tipoContratto;
    }

    public LocalDate getScadenza() {
        return scadenza;
    }

    public void setScadenza(LocalDate scadenza) {
        this.scadenza = scadenza;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
}
