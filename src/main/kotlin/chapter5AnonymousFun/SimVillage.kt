package chapter5AnonymousFun

fun main() {
//    runSimulation("김선달", ::printConstructionCost) { playerName, numBuildings ->
//        val currentYear = 2019
//        println("$numBuildings 채의 건물이 추가됨")
//        "SimVillage 방문을 환영합니다, $playerName 님! (copyright $currentYear)"
//    }
    runSimulation()
}

// inline fun runSimulation(
//    playerName: String,
//    costPrinter: (Int) -> Unit,
//    greetingFunction: (String, Int) -> String,
// ) {
//    val numBuildings = (1..3).shuffled().last() // 1, 2, 3 중 하나를 무작위로 선택한다
//    costPrinter(numBuildings)
//    println(greetingFunction(playerName, numBuildings))
// }

fun printConstrictionCost(numBuildings: Int) {
    val cost = 500
    println("건축 비용: ${cost * numBuildings}")
}

fun runSimulation() {
    val greetingFunction = configureGreetingFunction()
    println(greetingFunction("김선달"))
    println(greetingFunction("김선달"))
}

fun configureGreetingFunction(): (String) -> String {
    val structureType = "병원"
    var numBuildings = 5
    return { playerName: String ->
        val currentYear = 2019
        numBuildings += 1
        println("$numBuildings 채의 $structureType 이 추가됨")
        "SimVillage 방문을 환영합니다, $playerName! (copyright $currentYear)"
    }
}

// 코틀린의 람다는 클로저(closure)이다. 다른 함수에 포함된 함수에서 자신을 포함하는 함수의 매개변수와 변수를 사용할 수 있다.
