package chapter1to10.chapter5AnonymousFun

fun main() {
    val numLetters = "Mississippi".count()
    println(numLetters)
    // 11을 출력한다

    val numLettersS = "Mississippi".count({ letter ->
        letter == 's'
    })
    println(numLettersS)
    // 4를 출력한다
}
