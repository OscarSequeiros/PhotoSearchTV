# PhotoSearchTV
Small Android TV application

## Building the app
The app is using [Gradle](https://gradle.org). An executable wrapper for Gradle is provided within the codebase (gradlew and gradlew.bat), so you don't need to install Gradle locally to build the app.
 - Task for building App: `./gradlew assembleRelease`
 
## Project Structure
The project is organized using Clean Architecture.


## Stack & Third Party Libraries
| Name | Version |Purpose |
|-------|-------|-------|
| [Android KTX](https://developer.android.com/kotlin/ktx) | 1.6.0 | Kotlin extensions that are included with Android Jetpack |
| [Android AppCompat](https://developer.android.com/jetpack/androidx/releases/appcompat) | 1.3.1 | Allows access to new APIs an older API version of the platform |
| [Navigation Component](https://developer.android.com/guide/navigation) | 2.3.5 | Allows users to navigate across different pieces of content |
| [Android Fragment KTX](https://developer.android.com/kotlin/ktx?gclid=Cj0KCQjwwLKFBhDPARIsAPzPi-IXxYMh9GtbWVjXAhX9BcM1a3TBZ9O7ltNgX79E-sZjq_J6_piybMwaAssyEALw_wcB&gclsrc=aw.ds#fragment) | 1.3.6 | Provides a number of extensions to simplify the fragment API |
| [Kotlin](https://developer.android.com/kotlin) | 1.5.31 | Primary development language |
| [Kotlin Coroutines Core](https://kotlinlang.org/docs/coroutines-overview.html) | 1.5.2 | Asynchronous or non-blocking programming |
| [Hilt](https://developer.android.com/training/dependency-injection/hilt-android) | 2.38.1 | Dependency Injection |
| [Retrofit](https://square.github.io/retrofit/) with [OkHttp3](http://square.github.io/okhttp/) | 2.9.0 | API calls |
| [Moshi](https://github.com/square/moshi) | 1.12.0 | For JSON conversion |
| [Glide](https:github.com/bumptech/glide) | 4.12.0 | Image loading framework on for Android |