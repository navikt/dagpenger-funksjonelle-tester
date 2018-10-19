#language: no
Egenskap: Bruker sender NAV skjema som ikke er søknad eller ettersending

  Scenario: Det kommer noe som ikke er søknad eller ettersending
    Gitt at bruker har sendt noe som kan knyttes til sak
    Når vi behandler journalføringen
    Så opprettes det en generell GSAK sak
    Så opprettes det en manuell journalføringsoppgave i Gosys på 4450

