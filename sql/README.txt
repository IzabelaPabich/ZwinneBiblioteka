instace: BAZA1
schemat: biblioteka

login: root
haslo: mysql123

Utworzylem konto dla adminia na tym koncie powinna byc podpieta apka do baza danych
login: administrator
hasło: administrator123

Uprawnienia: select, show view, update, delete, insert

Utorzyłem 3 tabele: /* Wszystkie PK maja inkrementacje automatyczna */
- ksiazki
				Columns:
				ID_KSIAZKI int(11) AI PK 
				NAZWA_KSIAZKI varchar(100) 
				IMIONA_AUTO varchar(45) 
				NAZWISKO_AUTO varchar(45) 
				DATA_WYDANIA date 
				KATEGORIA varchar(45)	
- uzytkownicy
				Columns:
				ID_UZYTKOWNIKA int(11) AI PK 
				NAZWA_UZY varchar(20) 
				HASLO varchar(20) 
				IMIONA_UZY varchar(45) 
				NAZWISKO_UZY varchar(45) 
				PESEL varchar(45) 
				EMAIL varchar(255) 
				TELEFON int(11) 
				DATA_UTWORZENIA timestamp
- wypozyczenia /* tabela lączaca dwie górne */
				Columns:
				ID_WYPOZYCZENIA int(11) AI PK 
				FK_KSIAZKA int(11) 
				FK_UZYTKOWNIK int(11) 
				DATA_WYPOZYCZENIA timestamp
				
Utorzyłem 2 vidoki:
- v_nie_wypozyczone_ksiazki
				Columns:
				Nazwa książki varchar(100) 
				Imie Autora varchar(45) 
				Nazwisko Autora varchar(45) 
				Data wydania date 
				Kategoria varchar(45)
				
- v_wypozyczone_ksiazki
				Columns:
				Nazwa użytkownika varchar(20) 
				Nazwa książki varchar(100) 
				Imiona Autora varchar(45) 
				Nazwisko Autora varchar(45)

- v_uzytkownicy;
				Id użytkownika int(11) 
				Nazwa użytkownika varchar(20) 
				Imiona użytkownika varchar(45) 
				Nazwisko użytkownika varchar(45)


