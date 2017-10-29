package pl.zmzp.biblioteka.dto;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

public class UserRegistrationForm {


    private String nazwauzy;


    private String haslo;


    private String imiona_uzy;


    private String nazwisko_uzy;


    private String pesel;


    private String email;


    private String telefon;

    public String getNazwauzy() {
        return nazwauzy;
    }

    public void setNazwauzy(String nazwauzy) {
        this.nazwauzy = nazwauzy;
    }

    public String getHaslo() {
        return haslo;
    }

    public void setHaslo(String haslo) {
        this.haslo = haslo;
    }

    public String getImiona_uzy() {
        return imiona_uzy;
    }

    public void setImiona_uzy(String imiona_uzy) {
        this.imiona_uzy = imiona_uzy;
    }

    public String getNazwisko_uzy() {
        return nazwisko_uzy;
    }

    public void setNazwisko_uzy(String nazwisko_uzy) {
        this.nazwisko_uzy = nazwisko_uzy;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }
}
