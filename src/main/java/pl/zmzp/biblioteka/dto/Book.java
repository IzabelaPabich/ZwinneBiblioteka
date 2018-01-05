package pl.zmzp.biblioteka.dto;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

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
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date data_wydania;

    @Column(name = "KATEGORIA")
    private String kategoria;
    
    @Transient
    public Boolean dostepna = true;
    
//    @OneToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name="FK_KSIAZKA", nullable=true)
//    private BookBorrow wypozyczenie;
    
    public Book(Integer id, String name) {
        this.id_ksiazki = id;
        this.nazwa_ksiazki = name;
    }
    
    public Book(Integer id, String name, String author_names, String author_lastname, String category_name, Date issue_date, Integer holder_id) {
        this.id_ksiazki = id;
        this.nazwa_ksiazki = name;
        this.imiona_autora = author_names;
        this.nazwisko_autora = author_lastname;
        this.kategoria = category_name;
        this.data_wydania = issue_date;
        this.dostepna = true;
        if(holder_id != null && holder_id > 0)
        {
            this.dostepna = false;
        }
    }

    public Book() {

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
    
    public Boolean getDostepna() {
        return dostepna;
    }
}
