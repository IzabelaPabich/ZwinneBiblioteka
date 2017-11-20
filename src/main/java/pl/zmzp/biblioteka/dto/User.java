package pl.zmzp.biblioteka.dto;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="uzytkownicy")
public class User implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_UZYTKOWNIKA")
    private Integer id_uzytkownika;

    @Column(name = "NAZWA_UZY")
    private String nazwaUzy;

    @Column(name = "HASLO")
    private String haslo;

    @Column(name = "IMIONA_UZY")
    private String imiona_uzy;

    @Column(name = "NAZWISKO_UZY")
    private String nazwisko_uzy;

    @Column(name = "PESEL")
    private String pesel;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "TELEFON")
    private String telefon;

    @Column(name = "DATA_UTWORZENIA")
    private String data_tworzenia;
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "uzytkownicy_role",
            inverseJoinColumns = {@JoinColumn(name = "FK_ROLE", referencedColumnName = "ID")},
            joinColumns = {@JoinColumn(name = "FK_UZYTKOWNICY", referencedColumnName = "ID_UZYTKOWNIKA")})
    private List<Roles> roles;
    
    @OneToMany(mappedBy = "uzytkownik")
    private List<BookBorrow> bookBorrows;

    public Integer getId_uzytkownika() {
        return id_uzytkownika;
    }

    public void setId_uzytkownika(Integer id_uzytkownika) {
        this.id_uzytkownika = id_uzytkownika;
    }

    public String getNazwaUzy() {
        return nazwaUzy;
    }

    public void setNazwaUzy(String nazwaUzy) {
        this.nazwaUzy = nazwaUzy;
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

    public String getData_tworzenia() {
        return data_tworzenia;
    }

    public void setData_tworzenia(String data_tworzenia) {
        this.data_tworzenia = data_tworzenia;
    }
    
    public List< Roles > getRoles () {
        return roles;
    }
    
    public void setRoles ( List< Roles > roles ) {
        this.roles = roles;
    }
    
    public List< BookBorrow > getBookBorrows () {
        return bookBorrows;
    }
    
    public void setBookBorrows ( List< BookBorrow > bookBorrows ) {
        this.bookBorrows = bookBorrows;
    }
}
