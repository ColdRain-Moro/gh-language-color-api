package kim.bifrost.routing

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kim.bifrost.model.ApiWrapper
import kim.bifrost.model.ColorResp
import kim.bifrost.model.database.Color
import kim.bifrost.model.database.TableColor
import org.jetbrains.exposed.sql.transactions.experimental.newSuspendedTransaction

/**
 * com.example.routing.ColorRouting
 * gh-language-color-api
 *
 * @author 寒雨
 * @since 2022/7/16 19:23
 */
fun Routing.configureColorRouting() {
    route("lang") {
        get("/color") {
            val lang = call.request.queryParameters["lang"] ?: return@get let {
                call.respond(HttpStatusCode.BadRequest, "lang is required")
            }
            newSuspendedTransaction {
                val color = Color.find { TableColor.language eq lang }.firstOrNull()
                if (color != null) {
                    call.respond(ApiWrapper(200, "OK", ColorResp(color.language, color.color)))
                } else {
                    call.respond(ApiWrapper(200, "Not Found", null))
                }
            }
        }
    }
}