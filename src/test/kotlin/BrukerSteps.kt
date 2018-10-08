import cucumber.api.java8.No

class BrukerSteps : No {
    init {
        Gitt("at bruker har diskresjonskode {string}") { diskresjonskode: String ->
            // TODO: User has a diskresjonskode
            throw cucumber.api.PendingException()
        }
        Gitt("bruker mangler kontortilhørighet") {
            // TODO: Mock
            throw cucumber.api.PendingException()
        }
    }
}
