package chapter18Extension

fun <T> Iterable<T>.random(): T = this.shuffled().first()