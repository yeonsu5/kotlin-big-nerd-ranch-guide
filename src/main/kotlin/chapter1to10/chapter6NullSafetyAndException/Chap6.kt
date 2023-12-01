package chapter1to10.chapter6NullSafetyAndException

fun main() {
//    var signatureDrink = "맥주"
//    signatureDrink = null
//    var beverage = readLine()
//    beverage = null

//    var beverage = readLine().capitalize()
    // 컴파일 에러 발생 - readLine의 반환타입이 String?이므로 null 값을 반환할 수 있기 때문에
    // capitalze 함수를 호출하지 못하게 컴파일러가 막은 것이다.
    // readLine에서 null 값을 반환하면 프로그램이 크래시되므로 에러 발생 가능성을 코틀린 컴파일러가 인지하고
    // 컴파일 시점에 미리 막은 것이다.
//    var beverage = readLine()?.capitalize() // 이렇게 수정 시 컴파일 에러가 나지 않음

//    var beverage = readLine()?.let {
//        if (it.isNotBlank()) {
//            it.capitalize()
//        } else {
//            "맥주"
//        }
//    }

//    var beverage = readLine()!!.capitalize()

    var beverage = readLine()

//    if (beverage != null) {
//        beverage = beverage.capitalize()
//    } else {
//        println("beverage가 null입니다!")
//    }

    beverage?.let {
        beverage = it.capitalize()
    } ?: println("beverate가 null입니다!")

//    beverage?.capitalize()?.plus(", large")
//
//    println(beverage)

    val beverageServed: String = beverage ?: "맥주"
    println(beverageServed)
}

/* 코틀린은 컴파일 언어 - 실행에 앞서 컴파일러라는 특별한 프로그램에 의해 기계어로 변환될 때
컴파일러는 우리 코드가 특정 요구사항을 만족하는지 확인한다.
예를 들어, null 가능 타입에 null 값이 지정되는지 검사한다.
null 불가능 타입에 null 값을 지정하려고 하면 컴파일 에러로 처리한다.
 */
