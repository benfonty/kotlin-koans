import java.util.HashMap

fun <A,B> buildMutableMap(build: HashMap<A,B>.() -> Unit):HashMap<A,B> {
    val map = HashMap<A,B>()
    map.build()
    return map;
}

fun usage(): Map<Int, String> {
    return buildMutableMap {
        put(0, "0")
        for (i in 1..10) {
            put(i, "$i")
        }
    }
}
