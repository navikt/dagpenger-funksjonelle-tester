# language: no
Egenskap: Norg2

  Bakgrunn:
    Gitt at bruker har søkt om dagpenger
    Og bruker ikke har diskresjonskode 6

  Scenario: Ordinære dagpenger og forskuttering skal havne på 4450
    Gitt at bruker har søkt om dagpenger uten permittering
    Og bruker bor i Norge
    Og bruker har jobbet i Norge
    Når vi oppretter oppgave "Start vedtaksbehandling"
    Så skal oppgaven opprettes på 4450

  Scenario: Permittering havner på 4455
    Gitt at bruker har søkt om dagpenger ved permittering
    Og bruker bor i Norge
    Og bruker har jobbet i Norge
    Når vi oppretter oppgave "Start vedtaksbehandling"
    Så skal oppgaven opprettes på 4455

  Scenario: Permitterte grensearbeidere skal på 4465
    Gitt at bruker har søkt om dagpenger ved permittering
    Og bruker bor i Polen
    Og bruker har jobbet i Norge
    Når vi oppretter oppgave "Start vedtaksbehandling"
    Så skal oppgaven opprettes på 4465

  Scenario: EØS grensearbeidere skal på 4470
    Gitt at bruker har søkt om dagpenger
    Og bruker bor i Polen
    Og bruker har jobbet i Norge
    Når vi oppretter oppgave "Start vedtaksbehandling"
    Så skal oppgaven opprettes på 4470

  Scenario: Diskresjonskode 6 skal til viken
    Gitt at bruker har søkt om dagpenger
    Og bruker har diskresjonskode 6
    Når vi oppretter oppgave "Start vedtaksbehandling"
    Så skal oppgaven opprettes på 2103
