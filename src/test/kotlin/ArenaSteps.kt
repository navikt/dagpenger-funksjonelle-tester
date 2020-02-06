import io.cucumber.java8.No

import cucumber.api.PendingException

class ArenaSteps : No {
    init {
        setupGittForGjenopptak()

        Gitt("bruker har en sak det kan knyttes til") {
            // TODO: Mock call to "hentSakListe" to return inaktiv sak
            throw cucumber.api.PendingException()
        }
        Gitt("bruker ikke har en sak det kan knyttes til") {
            // TODO: Mock call to "hentSakListe"
            throw cucumber.api.PendingException()
        }

        Gitt("bruker har en aktiv sak") {
            // TODO: Mock call to "hentSakListe" to return aktiv sak
            throw cucumber.api.PendingException()
        }

        Gitt("bruker ikke finnes i Arena") {
            // TODO: Mock call to "hentSakListe" to throw exception
            throw cucumber.api.PendingException()
        }

        Så("oppgave {string} opprettes på {int}") { oppgaveNavn: String, benkId: Int ->
            // TODO: Assert call to oppgaveTjeneste is made
            throw cucumber.api.PendingException()
        }

        Så("opprettes fagsak") {
            // TODO: Assert call to oppgaveTjeneste is made with Start vedtaksbehandling
            throw cucumber.api.PendingException()
        }
    }

    fun setupGittForGjenopptak() {
        Gitt("at bruker har en sak å gjenoppta") {
            // TODO: Mock call to "hentSakListe"
            throw cucumber.api.PendingException()
        }

        Gitt("bruker ikke har en sak å gjenoppta") {
            // TODO: Mock call to "hentSakListe"
            throw cucumber.api.PendingException()
        }

        Gitt("at bruker ikke har en sak å gjenoppta") {
            // TODO: Mock call to "hentSakListe"
            throw cucumber.api.PendingException()
        }

        Gitt("bruker har en tidligere sak som kan gjenopptas") {
            // TODO: Mock call to "hentSakListe"
            throw cucumber.api.PendingException()
        }
    }
}
