package no.nav.dagpenger.cucumber

import com.natpryce.konfig.ConfigurationMap
import com.natpryce.konfig.ConfigurationProperties
import com.natpryce.konfig.EnvironmentVariables
import com.natpryce.konfig.Key
import com.natpryce.konfig.booleanType
import com.natpryce.konfig.overriding
import com.natpryce.konfig.stringType
import java.io.File


private val localProperties = ConfigurationMap(
    mapOf(
        "application.profile" to "LOCAL",
        "dp.regel.api.arena.adapter.url" to "http://127.0.0.1:8093",
        "oidc.sts.issuerurl" to "https://vtpmock.local:8063/stsrest/rest/v1/sts/token",
        "cucumber.test.username" to "igroup",
        "cucumber.test.password" to "itest",
        "disable.ssl" to "true"

    )
)
private val devProperties = ConfigurationMap(
    mapOf(
        "application.profile" to "DEV",
        "dp.regel.api.arena.adapter.url" to "https://dp-regel-api-arena-adapter.nais.preprod.local",
        "oidc.sts.issuerurl" to "https://security-token-service.nais.preprod.local/rest/v1/sts/token",
        "disable.ssl" to "false"
    )
)

private val optionalFile = ConfigurationProperties.fromOptionalFile(File("/var/run/secrets/nais.io/vault/application.env"))

private val config = when (System.getenv("CUCUMBER_ENV") ?: System.getProperty("CUCUMBER_ENV")) {
    "dev" -> ConfigurationProperties.systemProperties() overriding EnvironmentVariables overriding devProperties overriding optionalFile
    else -> {
        ConfigurationProperties.systemProperties() overriding EnvironmentVariables overriding localProperties
    }
}


data class CucumberConfiguration(
    val dpApiArenaAdapterUrl: String = config[Key("dp.regel.api.arena.adapter.url", stringType)],
    val stsIssuerUrl: String = config[Key("oidc.sts.issuerurl", stringType)],
    val profile: Profile = config[Key(
        "application.profile",
        stringType
    )].let { Profile.valueOf(it) },
    val username: String = config.getOrElse(Key("cucumber.test.username", stringType)) {
        config[Key("srvdp.regel.api.arena.adapter.username", stringType)]
    },
    val password: String = config.getOrElse(Key("cucumber.test.password", stringType)) {
        config[Key("srvdp.regel.api.arena.adapter.password", stringType)]
    },
    val disableSSL: Boolean = config[Key("disable.ssl", booleanType)]
)

enum class Profile {
    LOCAL, DEV
}

