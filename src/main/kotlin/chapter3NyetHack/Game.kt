package chapter3NyetHack

fun main(args: Array<String>) {
    val name = "마드리갈"
//    val healthPoints = 100
    val healthPoints = 89
    val isBlessed = true
    val isImmortal = false

    // 아우라
//    if (isBlessed && healthPoints > 50 || isImmortal) {
//    val auraVisible = isBlessed && healthPoints > 50 || isImmortal
//    if (auraVisible) {
//        println("GREEN")
//    } else {
//        println("NONE")
//    }

    // auraVisible 코드를 조건 표현식으로 변경하기
    // 아우라
    val auraVisible = isBlessed && healthPoints > 50 || isImmortal
    val auraColor = if (auraVisible) "GREEN" else "NONE"
//    println(auraColor)

//    if (healthPoints == 100) {
//        println(name + " 최상의 상태임!")
//    } else if (healthPoints >= 90) {
//        println(name + " 약간의 찰과상만 있음.")
//    } else if (healthPoints >= 75) {
//        if (isBlessed) {
//            println(name + " 경미한 상처가 있지만 빨리 치유됨!")
//        } else {
//            println(name + " 경미한 상처만 있음.")
//        }
//    } else if (healthPoints >= 15) {
//        println(name + " 많이 다친 것 같음.")
//    } else { // 0부터 14까지의 값일 때만 실행된다.
//        println(name + " 최악의 상태임!")
//    }

    // 위의 코드를 조건 표현식으로 리팩토링하기
    // 범위를 사용해서 healthStatus 값을 검사하기
//    val healthStatus = if (healthPoints == 100) {
//        "최상의 상태임!"
// //    } else if (healthPoints >= 90) {
//    } else if (healthPoints in 90..99) {
//        "약간의 찰과상만 있음."
// //    } else if (healthPoints >= 75) {
//    } else if (healthPoints in 75..89) {
//        if (isBlessed) {
//            "경미한 상처가 있지만 빨리 치유되고 있음!"
//        } else {
//            "경미한 상처만 있음."
//        }
// //    } else if (healthPoints >= 15) {
//    } else if (healthPoints in 15..74) {
//        "많이 다친 것 같음,"
//    } else {
//        "최악의 상태임!"
//    }

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
    println(
        "(Aura: $auraColor) " +
            "(Blessed: ${if (isBlessed) "YES" else "NO"})",
    )
    println("$name $healthStatus")
}
// 표현식을 실행하여 그 결과를 해당 문자열에 삽입할 수 있다.
