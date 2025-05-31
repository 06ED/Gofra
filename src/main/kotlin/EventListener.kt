package funny.catlean

typealias EventCallback<T> = suspend (T) -> Boolean

class EventListener<T>(val priority: Int = 0, val callback: EventCallback<T>) : Comparable<EventListener<T>> {
    override fun compareTo(other: EventListener<T>) = priority.compareTo(other.priority)
}