import cucumber.api.PendingException
import io.cucumber.java8.No

class EttersendingSteps : No {
    init {
        Gitt("at bruker har ettersendt skjema som kan knyttes til sak") {
            // TODO: Set type to be Ettersending
            throw cucumber.api.PendingException()
        }

        Gitt("at bruker har ettersendt noe som ikke kan knyttes til sak") {
            // TODO: Set type to be Ettersending
            throw cucumber.api.PendingException()
        }
    }
}
