# IPWA02-01

## User Stories

- **US1 (MUST):** Als meldende Person möchte ich Geisternetze (anonym) erfassen können.
- **US2 (MUST):** Als bergende Person will ich mich für die Bergung eines Geisternetzes eintragen können.
- **US3 (MUST):** Als bergende Person möchte ich sehen, welche Geisternetze noch zu bergen sind.
- **US4 (MUST):** Als bergende Person möchte ich Geisternetze als geborgen melden können.
- **US7 (COULD):** Als beliebige Person möchte ich Geisternetze als verschollen melden können.

## Klonen

`git clone git@github.com:DatL4g/IU-Projects.git`

## In den Ordner navigieren

`cd IU-Projects/IPWA02-01/`

## Anwendung starten

`./gradlew bootRun`

Nach dem start ist die Anwendung unter `http://localhost:8080` erreichbar

### H2-Datenbank

Die Datenbank kann, während die Anwendung läuft, aufgerufen werden:

- URL: `http://localhost:8080/h2-console`
- JDBC URL: `jdbc:h2:file:<Pfad zum Klon>/IPWA02-01/data/ghostnetdb`
- Benutzer: shea
- Passwort: sepherd