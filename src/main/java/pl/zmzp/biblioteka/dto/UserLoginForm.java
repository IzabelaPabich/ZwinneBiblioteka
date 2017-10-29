package pl.zmzp.biblioteka.dto;

import org.hibernate.validator.constraints.NotEmpty;

public class UserLoginForm {

    @NotEmpty
    private String nazwauzy;

    @NotEmpty
    private String haslo;

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
}
