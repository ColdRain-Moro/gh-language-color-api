# gh-language-color-api

> 提供了获取Github语言颜色的api

## Usage

### GET /lang/color

> query lang `string` - 语言

~~~json
{
    "status": 200,
    "message": "OK",
    "data": {
        "lang": "Kotlin",
        "hex": "#A97BFF"
    }
}
~~~