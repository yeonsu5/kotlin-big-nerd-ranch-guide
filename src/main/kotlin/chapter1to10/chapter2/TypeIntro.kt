// 컴파일 시점 상수 선언하기
const val MAX_EXPERIENCE: Int = 5000

fun main() {
//    val playerName: String = "에스트라곤"
//    playerName = "마드리갈"  // Val cannot be reassigned
//    val playerName: String = "에스트라곤" // 여기서 String은 redundant(불필요) => 타입 추론
    val playerName = "에스트라곤"
    var experiencePoints = 5
//    var experiencePoints: Int = "thirty-two" // Type mismatch
    experiencePoints += 5
    println(experiencePoints)
    println(playerName)

    // 챌린지: hasSteed
    var hasSteed: String = "none"

    // 챌린지: 유니콘의 뿔
    val bar = "Unicorn's Horn"
    val barMaster = "David"
    var golds = 50
    listOf("벌꿀주", "포도주", "라크루아")

    // 챌린지: 마법의 거울
    println(playerName.reversed())
}
