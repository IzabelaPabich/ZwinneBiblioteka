package pl.zmzp.biblioteka.dto;

import org.hibernate.validator.constraints.NotEmpty;

import java.sql.Date;

/**
 * Created by Alebazi on 2017-12-15.
 */
public class NewBookForm {

    @NotEmpty
    private String nazwisko_autora;

    @NotEmpty
    private String imiona_autora;

    @NotEmpty
    private String tytul;

    @NotEmpty
    private Date data_wydania;


    public String getNazwiskoAutora() {
        return nazwisko_autora;
    }

    public void setNazwiskoAutora(String nazwisko_autora) {
        this.nazwisko_autora = nazwisko_autora;
    }

    public String getImionaAutora() {
        return imiona_autora;
    }

    public void setImionaAutora(String imiona_autora) {
        this.imiona_autora = imiona_autora;
    }

    public String getTytul() {
        return tytul;
    }

    public void setTytul(String tytul) {
        this.tytul = tytul;
    }

    public Date getDataWydania() {
        return data_wydania;
    }

    public void setDataWydania(Date data_wydania) {
        this.data_wydania = data_wydania;
    }
}
