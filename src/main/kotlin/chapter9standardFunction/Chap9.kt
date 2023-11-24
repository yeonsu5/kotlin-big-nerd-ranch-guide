package chapter9standardFunction

import java.io.File

//val menuFile = File("menu-file.txt")
//    menuFile.setReadable(true)
//    menuFile.setWritable(true)
//    menuFile.setExecutable(false)

val menuFile = File("menu-file.txt").apply {
    setReadable(true) // 암시적으로 menuFile.setReadable(true)가 된다
    setWritable(true) // 암시적으로 menuFile.setWritable(true)가 된다
    setExecutable(false) // 암시적으로 menuFile.setExecutable(false)가 된다
}

val firstItemSquared = listOf(1,2,3).first().let {
    it * it
}

val firstElement = listOf(1,2,3).first()
val firstItemSquared2 = firstElement * firstElement

fun formatGreeting(vipGuest: String?): String {
    return vipGuest?.let {
        "오랜만입니다, $it. 테이블이 준비되어 있으니 들어오시죠."
    } ?: "저희 술집에 오신 것을 환영합니다. 곧 자리를 마련해 드리겠습니다."
}

//val menuFile = File("menu-file.txt")
//val servesDragonsBreath = menuFile.run {
//    readText().contains("Dragon's Breath")
//}

fun nameIsLong(name: String) = name.length >= 20
fun playerCreateMessage(nameTooLong: Boolean): String {
    return if (nameTooLong) {
        "Name is too long. Please choose another name."
    } else {
        "Welcome, adventurer"
    }
}

fun main() {
    "Polarcubis, supreme Master of NyetHack"
        .run(::nameIsLong)
        .run(::playerCreateMessage)
        .run(::println)
}

//val status = run {
//    if (healthPoints == 100) "perfect health" else "has injuries"
//}

val nameTooLong2 = with("Polarcubis, Supreme Master of NyeHack") {
    length >= 20
}

//var fileContents: List<String>
//File("file.txt")
//        .also {
//            print(it.name)
//        }.also {
//            fileContents = it.readLines()
//        }

val fileContents = File("myfile.txt")
    .takeIf{ it.canRead() && it.canWrite() }
    ?.readText()

//val file = File("myfile.txt")
//val fileContents = if(file.canRead() && file.canWrite()) {
//    file.readText()
//} else {
//    null
//}

val fileContents3 = File("myfile.txt").takeUnless { it.isHidden }?.readText()