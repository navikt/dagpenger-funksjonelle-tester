import cucumber.api.PendingException
import io.cucumber.java8.No

class SøknadSteps : No {
    init {
        Gitt("at bruker har søkt") {
            // TODO: Which form of søknadstype is not important, because it will fail. Default to ny
            throw cucumber.api.PendingException()
        }

        Gitt("at bruker har søkt om dagpenger uten permittering") {
            // TODO: Set type to be Ny
            throw cucumber.api.PendingException()
        }

        Gitt("at bruker har søkt om dagpenger ved permittering") {
            // TODO: Set type to be Ny
            throw cucumber.api.PendingException()
        }

        Gitt("at bruker har søkt om gjenopptak av dagpenger") {
            // TODO: Set type to be Gjenopptak
            throw cucumber.api.PendingException()
        }

        Gitt("at bruker har søkt om gjenopptak av dagpenger ved permittering") {
            // TODO: Set type to be Gjenopptak
            throw cucumber.api.PendingException()
        }

        Gitt("at bruker har søkt om gjenopptak av dagpenger uten permittering") {
            // TODO: Set type to be Gjenopptak
            throw cucumber.api.PendingException()
        }
    }
}
