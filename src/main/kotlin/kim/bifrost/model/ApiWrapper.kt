package kim.bifrost.model

/**
 * com.example.model.ApiWrapper
 * gh-language-color-api
 *
 * @author 寒雨
 * @since 2022/7/16 19:39
 */
data class ApiWrapper<T>(
    val status: Int,
    val message: String,
    val data: T
)