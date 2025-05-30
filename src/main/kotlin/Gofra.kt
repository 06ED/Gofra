package funny.catlean

import funny.catlean.api.Notifiable
import funny.catlean.api.Subscribable
import java.util.concurrent.ConcurrentSkipListSet

typealias EventCallback<T> = suspend (T) -> Unit

class EventListener<T>(val priority: Int = 0, val callback: EventCallback<T>) : Comparable<EventListener<T>> {
    override fun compareTo(other: EventListener<T>) = priority.compareTo(other.priority)
}

@Suppress("UNUSED")
abstract class Gofra<T> : Notifiable<T>, Subscribable<T> {
    private val events = ConcurrentSkipListSet<EventListener<T>>()

    override fun subscribe(listener: EventListener<T>) {
        events.add(listener)
    }

    override fun unsubscribe(listener: EventListener<T>) {
        events.remove(listener)
    }

    override suspend fun notify(event: T) = events.forEach { it.callback(event) }

    override suspend fun notifyGuarded(event: T, onError: (e: Exception) -> Unit) = events.forEach {
        try {
            it.callback(event)
        } catch (e: Exception) {
            onError(e)
        }
    }
}