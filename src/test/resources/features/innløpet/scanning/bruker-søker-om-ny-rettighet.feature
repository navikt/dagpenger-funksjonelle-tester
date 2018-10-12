# language: no
Egenskap: Bruker søker om ny dagpengeperiode

  Scenariomal: Bruker har ingen sak å gjenoppta
    Gitt at bruker har søkt om dagpenger <rettighetstype>
    Og at bruker ikke har en aktiv sak
    Og at bruker ikke har diskresjonskode 6
    Når vi behandler journalføringen
    Så opprettes fagsak
    Og ny gsak knyttes til fagsak
    Og journalpost knyttes til gsak
    Og journalpost ferdigstilles
    Og oppgave "Start Vedtaksbehandling - Automatisk journalført" opprettes på <benk>

    Eksempler:
      | rettighetstype    | benk |
      | uten permittering | 4450 |
      | ved permittering  | 4455 |

  Scenario: Bruker har søkt om ny, men allerede en aktiv sak
    Gitt at bruker har søkt
    Og bruker har en aktiv sak
    Når vi behandler journalføringen
    Så opprettes det en manuell journalføringsoppgave i Gosys

    Eksempler:
      | rettighetstype    | benk |
      | uten permittering | 4450 |
      | ved permittering  | 4455 |

  Scenario: Bruker har diskresjonskode 6
    Gitt at bruker har søkt om dagpenger
    Og at bruker har diskresjonskode 6
    Når vi behandler journalføringen
    Så opprettes det en manuell journalføringsoppgave i Gosys
    viken 2103

  Scenario: Bruker finnes ikke i Arena
    Gitt at bruker har søkt
    Og bruker ikke finnes i Arena
    Når vi behandler journalføringen
    Så opprettes det en manuell journalføringsoppgave i Gosys

    Eksempler:
      | rettighetstype    | benk |
      | uten permittering | 4450 |
      | ved permittering  | 4455 |

  Scenario: Bruker mangler kontortilhørighet i TPS
    Gitt at bruker har søkt
    Og bruker mangler kontortilhørighet
    Når vi behandler journalføringen
    Så opprettes det en manuell journalføringsoppgave i Gosys

    # Dobbeltsjekke benk
    #4465
