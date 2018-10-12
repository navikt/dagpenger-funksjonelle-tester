# language: no
Egenskap: Bruker søker om gjenopptak av tidligere dagpengeperiode

  Scenariomal: Bruker har tidligere sak å gjenoppta
    Gitt at bruker har søkt om gjenopptak av dagpenger <rettighetstype>
    Og bruker har en sak fra før
    Og at bruker ikke har diskresjonskode 6
    Når vi behandler journalføringen
    Så knyttes journalpost til tilhørende gsak
    Og journalpost ferdigstilles
    Og oppgave "Behandle Henvendelse - Automatisk journalført" opprettes på <benk>

    Eksempler:
      | rettighetstype    | benk |
      | uten permittering | 4450 |
      | ved permittering  | 4455 |

  Scenariomal: Bruker har har søkt, men har ikke tidligere sak å gjenoppta
    Gitt at bruker har søkt om gjenopptak av dagpenger
    Og bruker ikke har en sak fra før
    Når vi behandler journalføringen
    Så opprettes det en generell GSAK sak
    Så opprettes det en manuell journalføringsoppgave i Gosys

    Eksempler:
      | rettighetstype    | benk |
      | uten permittering | 4450 |
      | ved permittering  | 4455 |

  Scenario: Bruker har diskresjonskode 6
    Gitt at bruker har søkt om gjenopptak av dagpenger
    Og at bruker har diskresjonskode 6
    Når vi behandler journalføringen
    Så opprettes det en manuell journalføringsoppgave i Gosys
    #viken 2103

