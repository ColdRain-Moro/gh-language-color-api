package kim.bifrost.utils

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken

/**
 * com.example.utils.Gson
 * gh-language-color-api
 *
 * @author 寒雨
 * @since 2022/7/16 19:37
 */
val gson: Gson = GsonBuilder().create()

inline fun <reified T> String.formJson(): T {
    return gson.fromJson(this, object : TypeToken<T>() {}.type)
}

fun Any.toJson(): String {
    return gson.toJson(this)
}