package entities;

import entities.enums.Priorita;
import entities.enums.Seniority;
import jakarta.persistence.*;
import org.hibernate.annotations.Check;

import java.time.LocalDate;

@Entity
@Check(name="controllo_date",
        constraints = "assegnato_il<=scade_il")
public class Task
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Priorita priorita;
    @Column(nullable = false)
    private LocalDate scade_il;
    @Column(nullable = false)
    private LocalDate assegnato_il;
    @Column(nullable = false)
    private boolean concluso;
    @Column(nullable = false)
    private String descrizione;


    @ManyToOne
    //@JoinColumn Ã¨ opzionale, se non la mettette
    //lui crea in automatico una foreign key
    //con nomePadre_id
    private Dipendente operatore;



    public boolean inRitardo()
    {
        return scade_il.isAfter(LocalDate.now()) && !concluso;
    }

    public boolean troppoComplessa()
    {
        return  priorita==Priorita.ESTREMA &&
                !(operatore.getSeniority()== Seniority.SENIOR || operatore.getSeniority()== Seniority.SUPERSENIOR);
    }


    public Priorita getPriorita() {
        return priorita;
    }

    public void setPriorita(Priorita priorita) {
        this.priorita = priorita;
    }

    public LocalDate getScade_il() {
        return scade_il;
    }

    public void setScade_il(LocalDate scade_il) {
        this.scade_il = scade_il;
    }

    public LocalDate getAssegnato_il() {
        return assegnato_il;
    }

    public void setAssegnato_il(LocalDate assegnato_il) {
        this.assegnato_il = assegnato_il;
    }

    public boolean isConcluso() {
        return concluso;
    }

    public void setConcluso(boolean concluso) {
        this.concluso = concluso;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

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