package be.sander.thuis.domain;

import com.sun.istack.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "kattenbak")
public class Kattenbak {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull
    private String naam;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @NotNull
    private LocalDate datum;

    protected Kattenbak(){}

    public Kattenbak(@NotNull String naam, @NotNull LocalDate datum){
        this.naam = naam;
        this.datum = datum;
    }

    public long getId() {
        return id;
    }

    public String getNaam() {
        return naam;
    }

    public LocalDate getDatum() {
        return datum;
    }
}
