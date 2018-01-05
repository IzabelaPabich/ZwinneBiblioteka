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
    
    @OneToOne
    @JoinColumn(name = "FK_KSIAZKA")
    public Book ksiazka;
    
    @ManyToOne
    @JoinColumn(name = "FK_UZYTKOWNIK")
    public User uzytkownik;

    @Column(name = "DATA_WYPOZYCZENIA")
    public Date data_wypozyczenia;
    
    public BookBorrow()
    {
        this.uzytkownik = null;
        this.ksiazka = null;
    }

    public BookBorrow(Integer user_id, Integer book_id) {
        this.uzytkownik.setId_uzytkownika(user_id);
        this.ksiazka.setId_ksiazki(book_id);
    }
            
    public Integer getId_wypozyczenia() {
        return id_wypozyczenia;
    }

    public void setId_wypozyczenia(Integer id_wypozyczenia) {
        this.id_wypozyczenia = id_wypozyczenia;
    }
    
    public Book getKsiazka () {
        return ksiazka;
    }
    
    public void setKsiazka ( Book ksiazka ) {
        this.ksiazka = ksiazka;
    }
    
    public User getUzytkownik () {
        return uzytkownik;
    }
    
    public void setUzytkownik ( User uzytkownik ) {
        this.uzytkownik = uzytkownik;
    }
    
    public Date getData_wypozyczenia() {
        return data_wypozyczenia;
    }

    public void setData_wypozyczenia(Date data_wypozyczenia) {
        this.data_wypozyczenia = data_wypozyczenia;
    }
}
