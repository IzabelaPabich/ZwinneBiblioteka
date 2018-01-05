package pl.zmzp.biblioteka.dto;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Created by Alebazi on 2017-12-15.
 */
public class NewBookForm {

    @NotEmpty
    private String nazwisko_autora;

    @NotEmpty
    private String imiona_autora;

    @NotEmpty
    private String nazwa_ksiazki;

    @NotEmpty
    private Date data_wydania;

    @NotEmpty
    private String kategoria;

    public String getNazwisko_autora() {
        return nazwisko_autora;
    }

    public void setNazwisko_autora(String nazwisko_autora) {
        this.nazwisko_autora = nazwisko_autora;
    }

    public String getImiona_autora() {
        return imiona_autora;
    }

    public void setImiona_autora(String imiona_autora) {
        this.imiona_autora = imiona_autora;
    }

    public String getNazwa_ksiazki() {
        return nazwa_ksiazki;
    }

    public void setNazwa_ksiazki(String nazwa_ksiazki) {
        this.nazwa_ksiazki = nazwa_ksiazki;
    }

    @DateTimeFormat(pattern = "yyyy-mm-dd")
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
