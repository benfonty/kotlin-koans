import java.lang.IllegalArgumentException
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class D {
    var date: MyDate by EffectiveDate()
}

class EffectiveDate<R> : ReadWriteProperty<R, MyDate> {

    var timeInMillis: Long? = null

    override fun getValue(thisRef: R, property: KProperty<*>): MyDate {
        val tmp = timeInMillis
        if (tmp != null) {
            return tmp.toDate()
        }
        else {
            throw IllegalArgumentException()
        }
    }

    override fun setValue(thisRef: R, property: KProperty<*>, value: MyDate) {
       timeInMillis = value.toMillis()
    }
}

