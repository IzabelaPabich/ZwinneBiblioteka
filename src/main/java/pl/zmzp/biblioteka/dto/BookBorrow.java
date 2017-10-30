package pl.zmzp.biblioteka.dto;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Alebazi on 2017-10-30.
 */
@Entity
@Table(name="wypozyczenia")
public class BookBorrow {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_WYPOZYCZENIA")
    private Integer id_wypozyczenia;

    @Column(name = "FK_KSIAZKA")
    private Integer id_ksiazki;

    @Column(name = "FK_UZYTKOWNIK")
    private Integer id_uzytkownika;

    @Column(name = "DATA_WYPOZYCZENIA")
    private Date data_wypozyczenia;

    public Integer getId_wypozyczenia() {
        return id_wypozyczenia;
    }

    public void setId_wypozyczenia(Integer id_wypozyczenia) {
        this.id_wypozyczenia = id_wypozyczenia;
    }

    public Integer getId_ksiazki() {
        return id_ksiazki;
    }

    public void setId_ksiazki(Integer id_ksiazki) {
        this.id_ksiazki = id_ksiazki;
    }

    public Integer getId_uzytkownika() {
        return id_uzytkownika;
    }

    public void setId_uzytkownika(Integer id_uzytkownika) {
        this.id_uzytkownika = id_uzytkownika;
    }

    public Date getData_wypozyczenia() {
        return data_wypozyczenia;
    }

    public void setData_wypozyczenia(Date data_wypozyczenia) {
        this.data_wypozyczenia = data_wypozyczenia;
    }
}
