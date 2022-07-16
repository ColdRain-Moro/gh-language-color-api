package kim.bifrost.utils

/**
 * com.example.utils.Secret
 * gh-language-color-api
 *
 * @author 寒雨
 * @since 2022/7/16 19:36
 */
data class Secret(
    val dbUrl: String,
    val user: String,
    val password: String
) {
    companion object {
        val instance: Secret by lazy { gson.fromJson(Secret::class.java.classLoader.getResource("secret.json")?.readText()!!, Secret::class.java) }
    }
}

fun secret() = Secret.instance