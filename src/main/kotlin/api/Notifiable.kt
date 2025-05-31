package funny.catlean.api

interface Notifiable<T> {
    suspend fun notify(event: T)

    suspend fun notifyGuarded(event: T, onError: suspend (e: Exception) -> Unit)
}