package entities;

import jakarta.persistence.*;
import org.hibernate.annotations.Check;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

@Entity
@Check(name = "check_orario",constraints = "fine>inizio")
public class Cartellino
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private LocalDate giorno;
    @Column(nullable = false)
    private LocalTime inizio;
    @Column(nullable = false)
    private LocalTime fine;

    @ManyToOne
    private Dipendente timbratore;

    public int oreLavorate()
    {
        return (int)inizio.until(fine, ChronoUnit.HOURS);
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getGiorno() {
        return giorno;
    }

    public void setGiorno(LocalDate giorno) {
        this.giorno = giorno;
    }

    public LocalTime getInizio() {
        return inizio;
    }

    public void setInizio(LocalTime inizio) {
        this.inizio = inizio;
    }

    public LocalTime getFine() {
        return fine;
    }

    public void setFine(LocalTime fine) {
        this.fine = fine;
    }

    public Dipendente getTimbratore() {
        return timbratore;
    }

    public void setTimbratore(Dipendente timbratore) {
        this.timbratore = timbratore;
    }
}