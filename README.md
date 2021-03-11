# ProjectFabioHong

Si sviluppi una web application, tramite servlet Java, JSP (Java Sever Pages) e filters Java, chiamata Project# (inserire il vostro nome e cognome al posto di #). L’applicazione è dotata di un database MySQL di appoggio e ha una struttura simile all’applicazione WebLoginSecure (fatta a lezione), e rispetta la suddivisione in 3 layer (presentazione, business logic o applicazione, dati). L’applicazione deve inoltre avere le seguenti caratteristiche:

- Abbia una pagina index.jsp come punto di ingresso predefinito dell’applicazione. In tale pagina si effettua login tramite un form che comprenda un nome utente e una password.       Sia un servlet a occuparsi delle procedure di login:
          -- Se l’utente effettua il login per la prima volta (nome utente non ancora presente nel database di appoggio) si accetta sempre il login come valido a meno che l’utente o la relativa password non siano vuoti. Quindi si registra l’utente e la relativa password nel database di appoggio.
          -- Se l’utente effettua il login essendo già registrato (nome utente già presente nel database di appoggio) si accetta il login come valido solo se la password                    corrisponde a quella immessa al momento della registrazione e se sia nome utente che password non sono vuoti.
          -- Se il login è accettato come valido si procede a una pagina web login.jsp che mostri il nome utente (come attributo di sessione) e la password (come attributo di              richiesta), accanto ad un link che conduca a WebConverter (simile a quello fatto a lezione).
          -- Se il login non è accettato come valido si reindirizza a index.jsp, mostrando un testo di errore.
- Si aggiunga all’applicazione del punto 1. un filtro che effettui il log dell’URI di ogni risorsa richiesta, mappato su ogni URL.
- Si aggiunga all’applicazione del punto 1. un filtro che effettui il log dei parametri (nome e valore) di ogni richiesta HTTP, mappato su ogni URL.
- Si aggiunga all’applicazione del punto 1. un filtro che reindirizzi ogni richiesta a index.jsp e al servlet associato alla procedura di login su login.jsp se la sessione è valida (utente già loggato)
- Si aggiunga all’applicazione del punto 1. un filtro che reindirizzi ogni richiesta a login.jsp, converter.jsp e relativi servlet a index.jsp se la sessione non è valida (utente non loggato).
- Si aggiunga all’applicazione del punto 1. un sistema che salvi un cookie sul browser del client (con durata di 2 giorni, cioè 60 * 60 * 24 * 2 secondi), avente come valore il nome dell’ultimo utente loggato da quel browser. Si realizzi tale sistema nel servlet associato al login.

  a. 
          i. 
          ii. 
          iii. 
          iv. 
b. Il WebConverter deve consistere di una pagina converter.jsp dove vengono immessi i dati, con le seguenti caratteristiche:
          i. Consenta di scegliere, tramite radio-button, il tipo di conversione (da metri/secondo a kilometri/orari e viceversa, da miglia a metri e viceversa) da effettuare.
          ii. Consenta di impostare il valore numerico da convertire tramite un form. Tale form comprende anche i radio-button.
          iii. Mostri sulla stessa pagina converter.jsp il risultato della conversione (assicurarsi che il calcolo sia però effettuato tramite un servlet, cioè usando la business            logic e reindirizzando opportunamente).
c. Abbia sulle pagine login.jsp e converter.jsp un pulsante di logout che invalidi la sessione (per invalidare, si seguano le modalità usate a lezione impostando opportunamente un attributo di sessione) tramite un servlet che, a logout avvenuto, reindirizzi a index.jsp.
2. 
3. 
4. 
5. 
6. 
