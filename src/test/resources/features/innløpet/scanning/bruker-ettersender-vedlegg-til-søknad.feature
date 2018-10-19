#language: no
Egenskap: Bruker ettersender til søknad

  Scenariomal: Bruker har sak å knytte ettersending til
    Gitt at bruker har ettersendt skjema som kunne vært knyttet til sak
    Og bruker har en sak <rettighetstype> fra før
    Når vi behandler journalføringen
    Så knyttes journalpost til tilhørende gsak
    Og journalpost ferdigstilles
    Og oppgave "Behandle Henvendelse" opprettes på <benk>

    Eksempler:
      | rettighetstype    | benk |
      | uten permittering | 4450 |
      | ved permittering  | 4455 |

  Scenariomal: Bruker har ikke sak å knytte ettersending til
    Gitt at bruker har ettersendt skjema som kan knyttes til sak
    Og bruker ikke har en sak <rettighetstype> fra før
    Når vi behandler journalføringen
    Så opprettes det en generell GSAK sak
    Så opprettes det en manuell journalføringsoppgave i Gosys <benk>

    Eksempler:
      | rettighetstype    | benk |
      | uten permittering | 4450 |
      | ved permittering  | 4455 |

  # Etter møte med produksjonsstyring bør vi se på hvilke andre dokumenter vi også kan automatisk knytte til siste sak
  #Scenario: Knytte dokumenter til siste sak