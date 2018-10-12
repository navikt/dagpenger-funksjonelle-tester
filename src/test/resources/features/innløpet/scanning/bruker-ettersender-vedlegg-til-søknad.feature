#language: no
Egenskap: Bruker ettersender til søknad

  Scenario: Bruker har sak å knytte ettersending til
    Gitt at bruker har ettersendt skjema som kunne vært knyttet til sak
    Og bruker har en sak fra før
    Når vi behandler journalføringen
    Så knyttes journalpost til tilhørende gsak
    Og journalpost ferdigstilles
    Og oppgave "Behandle Henvendelse" opprettes

  Scenariomal: Bruker har ikke sak å knytte ettersending til
    Gitt at bruker har ettersendt skjema som kan knyttes til sak
    Og bruker ikke har en sak fra før
    Når vi behandler journalføringen
    Så opprettes det en generell GSAK sak
    Så opprettes det en manuell journalføringsoppgave i Gosys

    Eksempler:
      | rettighetstype    | benk |
      | uten permittering | 4450 |
      | ved permittering  | 4455 |

