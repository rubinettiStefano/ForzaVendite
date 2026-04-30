package entities;

import jakarta.persistence.*;
import org.hibernate.annotations.Check;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Azienda
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String ragioneSociale;
    private String sede;
    private LocalDate fondazione;
    private String piva;
    private String sdi;
    private double fatturato;
    private double capitaleSociale;

    @OneToMany(mappedBy = "datore", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Dipendente>dipendenti = new ArrayList<>();


    public List<Task> tasksMieiDipendenti()
    {
        List<Task> res = new ArrayList<>();
        for(Dipendente d : dipendenti)
            res.addAll(d.getTasks());

        return res;
    }

    public int contaTasksInRitardo()
    {
        int res = 0;
        for(Task t:tasksMieiDipendenti())
            if(t.inRitardo())
                res++;

        return res;
    }

    public int numeroDipendenti()
    {
        return dipendenti.size();
    }

    public double totaleStipendi()
    {
        double res = 0;
        for(Dipendente d: dipendenti)
            res+=d.getStipendio();

        return res;
    }

    public double mediaTaskConclusePerDipendente()
    {
        double somma = 0;
        for(Dipendente d : dipendenti)
            somma+=d.totaleTaskConcluse();

        return somma/dipendenti.size();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRagioneSociale() {
        return ragioneSociale;
    }

    public void setRagioneSociale(String ragioneSociale) {
        this.ragioneSociale = ragioneSociale;
    }

    public String getSede() {
        return sede;
    }

    public void setSede(String sede) {
        this.sede = sede;
    }

    public LocalDate getFondazione() {
        return fondazione;
    }

    public void setFondazione(LocalDate fondazione) {
        this.fondazione = fondazione;
    }

    public String getPiva() {
        return piva;
    }

    public void setPiva(String piva) {
        this.piva = piva;
    }

    public String getSdi() {
        return sdi;
    }

    public void setSdi(String sdi) {
        this.sdi = sdi;
    }

    public double getFatturato() {
        return fatturato;
    }

    public void setFatturato(double fatturato) {
        this.fatturato = fatturato;
    }

    public double getCapitaleSociale() {
        return capitaleSociale;
    }

    public void setCapitaleSociale(double capitaleSociale) {
        this.capitaleSociale = capitaleSociale;
    }

    public List<Dipendente> getDipendenti() {
        return dipendenti;
    }

    public void setDipendenti(List<Dipendente> dipendenti) {
        this.dipendenti = dipendenti;
    }
}
