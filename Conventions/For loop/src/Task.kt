class DateRange(val start: MyDate, val end: MyDate): Iterable<MyDate> {
    override fun iterator(): Iterator<MyDate> {
        return object: Iterator<MyDate> {
            var currentDate: MyDate? = null
            override fun hasNext(): Boolean {
                return when (val tmp = currentDate) {
                    null -> start <= end
                    else -> start <= end && tmp.followingDate() <= end
                }
            }

            override fun next(): MyDate {
                currentDate = when (val tmp = currentDate) {
                    null -> start
                    else -> tmp.followingDate()
                }
                return currentDate as MyDate
            }

        }
    }

}

fun iterateOverDateRange(firstDate: MyDate, secondDate: MyDate, handler: (MyDate) -> Unit) {
    for (date in firstDate..secondDate) {
        handler(date)
    }
}

fun main() {
    iterateOverDateRange(MyDate(2021, 1, 3), MyDate(2021, 1, 1)) {
        println(it)
    }
}