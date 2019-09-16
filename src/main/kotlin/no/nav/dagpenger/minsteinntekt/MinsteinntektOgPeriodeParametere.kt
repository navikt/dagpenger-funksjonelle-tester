package no.nav.dagpenger.minsteinntekt

import no.nav.dagpenger.grunnlag.InntektsPeriode
import java.time.LocalDate

data class MinsteinntektOgPeriodeParametere(
    val aktorId: String,
    val vedtakId: Int,
    val beregningsdato: LocalDate,
    val harAvtjentVerneplikt: Boolean? = false,
    val oppfyllerKravTilFangstOgFisk: Boolean? = false,
    val bruktInntektsPeriode: InntektsPeriode? = null
)
