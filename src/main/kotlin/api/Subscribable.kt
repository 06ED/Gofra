package funny.catlean.api

import funny.catlean.EventListener

interface Subscribable<T> {
    fun subscribe(listener: EventListener<T>)

    fun unsubscribe(listener: EventListener<T>)
}