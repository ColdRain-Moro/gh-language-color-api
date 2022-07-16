package kim.bifrost.model.database

import kim.bifrost.utils.formJson
import kim.bifrost.utils.gson
import kim.bifrost.utils.secret
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.StdOutSqlLogger
import org.jetbrains.exposed.sql.addLogger
import org.jetbrains.exposed.sql.transactions.transaction

/**
 * com.example.model.database.DatabaseInit
 * gh-language-color-api
 *
 * @author 寒雨
 * @since 2022/7/16 19:41
 */
object DatabaseInit {
    fun init() {
        Database.connect(
            secret().dbUrl,
            "com.mysql.cj.jdbc.Driver",
            secret().user,
            secret().password
        )
        transaction {
            addLogger(StdOutSqlLogger)
            SchemaUtils.create(
                TableColor
            )
        }
    }
}

data class ColorBean(
    val color: String,
    val url: String
)

fun main() {
    // 读取并上传数据
    val data = (DatabaseInit.javaClass.classLoader.getResource("colors.json")?.readText() ?: error("")).formJson<HashMap<String, ColorBean>>()
    DatabaseInit.init()
    transaction {
        data.forEach { (k, v) ->
            Color.new {
                language = k
                color = v.color
                url = v.url
            }
        }
    }
}