import TimeInterval.*

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int)
data class SeveralTimeIntervals(val timeInterval: TimeInterval, val times: Int)

// Supported intervals that might be added to dates:
enum class TimeInterval { DAY, WEEK, YEAR }

operator fun MyDate.plus(timeInterval: TimeInterval): MyDate = addTimeIntervals(timeInterval, 1)

operator fun MyDate.plus(timeIntervals: SeveralTimeIntervals): MyDate = addTimeIntervals(timeIntervals.timeInterval, timeIntervals.times)

operator fun TimeInterval.times(i: Int): SeveralTimeIntervals = SeveralTimeIntervals(this, i)

operator fun Int.times(timeInterval: TimeInterval): SeveralTimeIntervals = timeInterval * this
fun task1(today: MyDate): MyDate {
    return today + YEAR + WEEK
}

fun task2(today: MyDate): MyDate {
    return today + 2 * YEAR + WEEK * 3 + DAY * 5
}
