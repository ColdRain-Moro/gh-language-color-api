package kim.bifrost.model.database

import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable

/**
 * kim.bifrost.model.database.TableColor
 * gh-language-color-api
 *
 * @author 寒雨
 * @since 2022/7/16 20:12
 */
object TableColor : IntIdTable("language_colors") {
    val language = varchar("language", 256)
    val color = varchar("color", 16).nullable()
    val url = text("url")
}

class Color(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<Color>(TableColor)

    var language by TableColor.language
    var color by TableColor.color
    var url by TableColor.url
}