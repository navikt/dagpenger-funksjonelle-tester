package no.nav.dagpenger.grunnlag

import io.cucumber.java8.No
import java.time.LocalDate
import no.nav.dagpenger.cucumber.parseJsonFrom
import no.nav.dagpenger.cucumber.testApiClient
import no.nav.dagpenger.derser.moshiInstance
import org.junit.jupiter.api.Assertions.assertEquals

class DagpengergrunnlagApiV1Steps : No {

    private val dagpengegrunnlagInnParametereAdapter = moshiInstance.adapter<GrunnlagOgSatsParametere>(
        GrunnlagOgSatsParametere::class.java
    )
    private val dagpengegrunnlagBeregningAdapter = moshiInstance.adapter<GrunnlagOgSatsSubsumsjon>(
        GrunnlagOgSatsSubsumsjon::class.java
    )

    init {

        lateinit var dagpengegrunnlagInnParametere: GrunnlagOgSatsParametere
        lateinit var dagpengegrunnlagBeregning: GrunnlagOgSatsSubsumsjon
        Gitt("at søker med aktør id {string} med vedtak id {int} med beregningsdato {string} i beregning av grunnlag") { aktørId: String, vedtaktId: Int, beregningsDato: String ->
            dagpengegrunnlagInnParametere =
                GrunnlagOgSatsParametere(
                    aktorId = aktørId,
                    vedtakId = vedtaktId,
                    beregningsdato = LocalDate.parse(beregningsDato)
                )
        }

        Når("digidag skal beregne grunnlag") {

            val response =
                testApiClient.grunnlagOgSats(dagpengegrunnlagInnParametereAdapter.toJson(dagpengegrunnlagInnParametere))
            dagpengegrunnlagBeregning = response.parseJsonFrom(dagpengegrunnlagBeregningAdapter)
        }

        Og("det er beregnet med et manuelt grunnlag på {int}") { manueltGrunnlag: Int ->
            dagpengegrunnlagInnParametere = dagpengegrunnlagInnParametere.copy(grunnlag = manueltGrunnlag)
        }

        Og("søker har {int} barn") { antallBarn: Int ->
            dagpengegrunnlagInnParametere = dagpengegrunnlagInnParametere.copy(antallBarn = antallBarn)
        }

        Så("er grunnlag satt til avkortet satt til {int} og uavkortet til {int}") { avkortet: Int, uavkortet: Int ->
            assertEquals(avkortet, dagpengegrunnlagBeregning.resultat.grunnlag?.avkortet)
            assertEquals(uavkortet, dagpengegrunnlagBeregning.resultat.grunnlag?.uavkortet)
        }

        Og("er ukessats satt til {int}") { ukessats: Int ->
            assertEquals(ukessats, dagpengegrunnlagBeregning.resultat.sats.ukesats)
        }

        Så("dagsats satt til {int}") { dagsats: Int ->
            assertEquals(dagsats, dagpengegrunnlagBeregning.resultat.sats.dagsats)
        }

        Så("da er parameteret barn {int}") { antallBarn: Int ->
            assertEquals(antallBarn, dagpengegrunnlagBeregning.parametere.antallBarn)
        }
    }
}
