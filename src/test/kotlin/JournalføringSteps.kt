import cucumber.api.java8.No

import cucumber.api.PendingException

class JournalføringSteps : No {
    init {
        Når("vi behandler journalføringen") {
            // TODO: Publish event on Kafka
            throw cucumber.api.PendingException()
        }

        Så("knyttes journalpost til eksisterende gsak") {
            // TODO: Assert call to Joark contains correct GSAK ID
            throw cucumber.api.PendingException()
        }

        Så("journalpost knyttes til gsak") {
            // TODO: Assert call to Joark contains any GSAK ID
            throw cucumber.api.PendingException()
        }

        Så("journalpost ferdigstilles") {
            // TODO: Assert call to Joark for finishing is performed
            throw cucumber.api.PendingException()
        }
    }
}
