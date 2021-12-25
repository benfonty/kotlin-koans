data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int) : Comparable<MyDate> {
    override fun compareTo(other: MyDate): Int {
        val yearc = year.compareTo(other.year)
        if (yearc != 0) return yearc
        val monthc = month.compareTo(other.month)
        if (monthc != 0) return monthc
        return dayOfMonth.compareTo(other.dayOfMonth)
    }
}

fun test(date1: MyDate, date2: MyDate) {
    // this code should compile:
    println(date1 < date2)
}
