package pl.zmzp.biblioteka.dto;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by Alebazi on 2017-10-30.
 */
@Entity
@Table(name="ksiazki")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_KSIAZKI")
    private Integer id_ksiazki;

    @Column(name = "NAZWA_KSIAZKI")
    private String nazwa_ksiazki;

    @Column(name = "IMIONA_AUTO")
    private String imiona_autora;

    @Column(name = "NAZWISKO_AUTO")
    private String nazwisko_autora;

    @Column(name = "DATA_WYDANIA")
    private Date data_wydania;

    @Column(name = "KATEGORIA")
    private String kategoria;
    
    public Book(Integer id, String name) {
        this.id_ksiazki = id;
        this.nazwa_ksiazki = name;
    }

    public String getNazwa_ksiazki() {
        return nazwa_ksiazki;
    }

    public void setNazwa_ksiazki(String nazwa_ksiazki) {
        this.nazwa_ksiazki = nazwa_ksiazki;
    }

    public Integer getId_ksiazki() {
        return id_ksiazki;
    }

    public void setId_ksiazki(Integer id_ksiazki) {
        this.id_ksiazki = id_ksiazki;
    }

    public String getImiona_autora() {
        return imiona_autora;
    }

    public void setImiona_autora(String imiona_autora) {
        this.imiona_autora = imiona_autora;
    }

    public String getNazwisko_autora() {
        return nazwisko_autora;
    }

    public void setNazwisko_autora(String nazwisko_autora) {
        this.nazwisko_autora = nazwisko_autora;
    }

    public Date getData_wydania() {
        return data_wydania;
    }

    public void setData_wydania(Date data_wydania) {
        this.data_wydania = data_wydania;
    }

    public String getKategoria() {
        return kategoria;
    }

    public void setKategoria(String kategoria) {
        this.kategoria = kategoria;
    }
}
