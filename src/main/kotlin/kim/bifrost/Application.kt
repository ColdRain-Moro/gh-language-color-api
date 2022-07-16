package kim.bifrost

import io.ktor.server.engine.*
import io.ktor.server.netty.*
import kim.bifrost.model.database.DatabaseInit
import kim.bifrost.plugins.configureRouting
import kim.bifrost.plugins.configureSerialization

fun main() {
    DatabaseInit.init()
    embeddedServer(Netty, port = 8080, host = "0.0.0.0") {
        configureRouting()
        configureSerialization()
    }.start(wait = true)
}
