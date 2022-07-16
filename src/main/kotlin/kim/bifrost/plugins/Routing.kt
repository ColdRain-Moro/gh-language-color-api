package kim.bifrost.plugins

import io.ktor.server.routing.*
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.request.*
import kim.bifrost.routing.configureColorRouting

fun Application.configureRouting() {
    routing {
        configureColorRouting()
    }
}
