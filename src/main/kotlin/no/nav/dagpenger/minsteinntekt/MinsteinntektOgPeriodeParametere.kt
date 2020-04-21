package no.nav.dagpenger.minsteinntekt

import java.time.LocalDate
import no.nav.dagpenger.grunnlag.InntektsPeriode

data class MinsteinntektOgPeriodeParametere(
    val aktorId: String,
    val vedtakId: Int,
    val beregningsdato: LocalDate,
    val harAvtjentVerneplikt: Boolean? = false,
    val oppfyllerKravTilFangstOgFisk: Boolean? = false,
    val bruktInntektsPeriode: InntektsPeriode? = null
)
