package com.example.extensions.commons

@JvmName("mapToList")
fun <FROM, TO> Mapper<FROM, TO>.mapTo(items: List<FROM>): List<TO> {
    val result = ArrayList<TO>()
    items.forEach { result.add(mapTo(it)) }
    return result
}

interface Mapper<FROM, TO> {
    fun mapTo(from: FROM): TO
}