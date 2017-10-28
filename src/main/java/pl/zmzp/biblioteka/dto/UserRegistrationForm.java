package pl.zmzp.biblioteka.dto;

import org.hibernate.validator.constraints.NotEmpty;

public class UserRegistrationForm {

    @NotEmpty
    private String nazwa_uzy;

    @NotEmpty
    private String haslo;

    @NotEmpty
    private String imiona_uzy;

    @NotEmpty
    private String nazwisko_uzy;

    @NotEmpty
    private String pesel;

    @NotEmpty
    private String email;

    @NotEmpty
    private String telefon;

    public String getNazwa_uzy() {
        return nazwa_uzy;
    }

    public void setNazwa_uzy(String nazwa_uzy) {
        this.nazwa_uzy = nazwa_uzy;
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
