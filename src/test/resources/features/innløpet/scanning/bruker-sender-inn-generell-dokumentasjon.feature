#language: no
Egenskap: Bruker sender dokumentasjon uten NAV skjema ID

  Scenario: Bruker har sendt noe uten NAV skjema ID
    Gitt at bruker har sendt noe som uten NAV skjema ID
    Når vi behandler journalføringen
    Så opprettes det en generell GSAK sak
    Så opprettes det en manuell journalføringsoppgave i Gosys på 4450

  Scenario: Bruker har sendt noe uten fødselsnummer/dnr
    Gitt at bruker har ettersendt noe uten fødselsnummer/dnr
    Når vi behandler journalføringen
    #Så opprettes det en generell GSAK sak
    #Så opprettes det en manuell journalføringsoppgave i Gosys på 4450
    Så opprettes det en fordelingsoppgave i Gosys
    # på 4450

  Scenario: SED
    Gitt at bruker har
    Når vi behandler journalføringen
    Så opprettes det en generell GSAK sak
    Så opprettes det en fordelingsoppgave i Gosys
    # på 4470
    # Snakke med ESSII
    # Tom Ove Andersen
