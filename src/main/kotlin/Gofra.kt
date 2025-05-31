package funny.catlean

import funny.catlean.api.Notifiable
import funny.catlean.api.Subscribable
import java.util.concurrent.ConcurrentSkipListSet

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

    override suspend fun notifyGuarded(event: T, onError: suspend (e: Exception) -> Unit) = events.forEach {
        try {
            it.callback(event)
        } catch (e: Exception) {
            onError(e)
        }
    }
}