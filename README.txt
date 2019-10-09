PRIMA DI TUTTO ESTRARRE L'ARCHIVIO


COME INSTALLARE IL DATABASE:
Requisiti: PostgreSQL 10 o maggiore.
Procedimento: 
1) Aprire la SQL shell(psql)

2) Digitare i comandi: 
CREATE DATABASE ospedale; 
\c ospedale;

3) Utilizzare il comando \cd '<percorso>' per spostarsi nella cartella Progetto_GRUPPO29_Ospedale/fileInstallazione. 
--------Esempio(utilizzare i forward slash)--------
\cd 'C:/Users/Utente/Desktop/Progetto_GRUPPO29_Ospedale/fileInstallazione';

4) Digitare il comando:
\i 'scriptSql.txt';
  
--------------------------------------------------------------------------------------------------------------

COME ESEGUIRE L'APPLICAZIONE JAVA:
Da linea di comando spostarsi nella cartella Progetto_GRUPPO29_Ospedale/appOspedale/bin e digitare il comando:
SU WINDOWS: 
java -cp "postgresql-42.2.2.jar";"." appOspedale.MainClass
SU LINUX: 
java -cp "postgresql-42.2.2.jar":"." appOspedale.MainClass


N.B.: L'applicazione non richiede credenziali di accesso in quanto già collegata
      ad un istanza del database accedibile tramite "ELEPHANTSQL"