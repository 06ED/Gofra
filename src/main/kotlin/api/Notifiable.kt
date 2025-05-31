package funny.catlean.api

interface Notifiable<T> {
    suspend fun notify(event: T): Boolean

    suspend fun notify(event: T, onError: suspend (e: Exception) -> Unit): Boolean
}