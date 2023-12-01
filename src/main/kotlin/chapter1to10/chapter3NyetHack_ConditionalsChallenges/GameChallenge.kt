package chapter3NyetHack

fun main(args: Array<String>) {
    val name = "마드리갈"
//    val healthPoints = 100
    val healthPoints = 89
    val isBlessed = true
    val isImmortal = false

    // auraVisible 코드를 조건 표현식으로 변경하기
    // 아우라

    // 챌린지 : 카르마
    val karma = (Math.pow(Math.random(), (110 - healthPoints) / 100.0) * 20).toInt()

    val auraVisible = isBlessed && healthPoints > 50 || isImmortal
    val auraColor = if (auraVisible) {
        when (karma) {
            in 0..5 -> "red"
            in 6..10 -> "orange"
            in 11..15 -> "purple"
            else -> "green"
        }
    } else {
        "None" // 아우라가 보이지 않을 때
    }

    // healthStatus 관련 코드를 when 표현식으로 변경하기
    val healthStatus = when (healthPoints) {
        100 -> "최상의 상태임!"
        in 90..99 -> "약간의 찰과상만 있음."
        in 75..89 -> if (isBlessed) {
            "경미한 상처가 있지만 빨리 치유되고 있음!"
        } else {
            "경미한 상처만 있음."
        }
        in 15..74 -> "많이 다친 것 같음."
        else -> "최악의 상태임!"
    }

    // 플레이어의 상태 출력
//    println(name + " " + healthStatus)
//    println(
//        "(Aura: $auraColor) " +
//            "(Blessed: ${if (isBlessed) "YES" else "NO"})",
//    )
//    println("$name $healthStatus")
    val statusFormatString = "(HP)(A) -> H"

    println("(HP: $healthPoints)(Aura: $auraColor) -> $healthStatus")
}
