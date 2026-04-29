package entities;

import jakarta.persistence.*;

@Entity
//@Table opzionale se vogliamo che tabella abbia stesso nome
public class Dipendente
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;//può essere NULL

    @Column(nullable = false,length = 50)
    private String nominativo;
    @Column(nullable = false,precision = 2)//2 cifre dopo la virgola
    private double stipendio;
    @Column(nullable = false)
    private String tipoContratto;

}
