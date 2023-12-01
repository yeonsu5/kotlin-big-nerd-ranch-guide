package chapter1to10.chapter5AnonymousFun

fun main() {
    println(
        {
            val currentYear = 2023
            "SimVillage 방문을 환영합니다, 촌장님! (copyright $currentYear)"
        }(), // 빈 괄호를 빼면 인사 메시지 문자열이 출력되지 않는다.
        // 이름 있는 함수처럼 익명 함수도 인자를 지정하는 괄호를 사용해서 호출될 때만 동작하기 때문이다.
    )

    val greetingFunction: () -> String = {
        val currentYear = 2023
        "SimVillage 방문을 환영합니다, 촌장님! (copyright $currentYear)"
    }
    // 리턴 타입이 없다. 익명 함수는 암시적으로 또는 자동으로 함수 정의의 마지막 코드 결과를 반환.
    println(greetingFunction())

    // playerName 매개변수를 익명 함수에 추가하기
    val greetingNameFunction: (String) -> String = { playerName ->
        val currentYear = 2023
        "SimVillage 방문을 환영합니다, $playerName 님! (copyright $currentYear)"
    }
    println(greetingNameFunction("김선달"))

    // it 키워드 사용하기
    // 익명 함수의 인자가 하나일 때는 매개변수 이름을 지정하는 대신 it 키워드를 사용할 수 있다.
    val greetingFunctionString2: (String) -> String = {
        val currentYear = 2023
        "SimVillage 방문을 환영합니다, $it 님! (copyright $currentYear) "
    }
    println(greetingFunctionString2("김선달(it)"))

    // 두 번째 인자 받기
    val greetingFunction2: (String, Int) -> String = { playerName, numBuildings ->
        val currentYear = 2023
        println("$numBuildings 채의 건물이 추가됨")
        "SimVillage 방문을 환영합니다, $playerName ! (copyright $currentYear)"
    }
    println(greetingFunction2("김선달", 2))

    // 타입 추론 사용하기
    val greetingFunction3 = { playerName: String, numBuildings: Int ->
        val currentYear = 2023
        println("$numBuildings 채의 건물이 추가됨")
        "SimVillage 방문을 환영합니다, $playerName ! (copyright $currentYear)"
    }
    println(greetingFunction2("김선달", 2))

    // runSimulation 함수 추가하기
    fun runSimulation(playerName: String, greetingFunction: (String, Int) -> String) {
        val numBuildings = (1..3).shuffled().last() // 1, 2, 3 중 하나를 무작위로 선택한다
        println(greetingFunction(playerName, numBuildings))
    }

    runSimulation("김선달", greetingFunction2)

    // 단축 문법으로 람다 전달하기
    // 단축 문법 : 함수에서 마지막 매개변수로 함수 타입을 받을 때 람다 인자를 둘러싼 괄호를 생략할 수 있다.
    runSimulation("김선달") { playerName, numBuildings ->
        val currentYear = 2023
        println("$numBuildings 채의 건물이 추가됨")
        "SimBillage 방문을 환영합니다, $playerName! (copyright $currentYear)"
    }

    runSimulationInline("김선달", ::printConstructionCost) { playerName, numBuildings ->
        val currentYear = 2023
        println("$numBuildings 채의 건물이 추가됨")
        "SimVillage 방문을 환영합니다, $playerName! ($currentYear)"
    }
}

// inline 키워드 사용하기
// inline 키워드를 추가하면 runSimulationInline 함수가 호출될 때 람다가 객체로 전달되지 않는다.
// 코틀린 컴파일러가 바이트코드를 생성할 때 람다 코드가 포함된 runSimulation 함수 몸체의 전체 코드를 복사한 후
// 이 함수를 호출하는 코드에 붙여넣기 하여 교체하기 때문이다.
// 메모리 사용에 부담을 없앨 수 있는 방법이다.
inline fun runSimulationInline(
    playerName: String,
    costPrinter: (Int) -> Unit,
    greetingFunction: (String, Int) -> String,
) {
    val numBuildings = (1..3).shuffled().last() // 1, 2, 3 중 하나를 무작위로 선택한다
    costPrinter(numBuildings)
    println(greetingFunction(playerName, numBuildings))
}

// 함수 참조 (function reference) : 이름이 있는 함수가 인자로 전달될 수 있게 해준다.

fun printConstructionCost(numBuildings: Int) {
    val cost = 500
    println("건축 비용: ${cost * numBuildings}")
}
