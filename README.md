# WeatherMVVM
=====================

This app uses the MVVM pattern

These are the APIs that this project includes
* [Room](https://developer.android.com/topic/libraries/architecture/room.html)
* [LiveData](https://developer.android.com/reference/android/arch/lifecycle/LiveData.html)
* [ViewModels](https://developer.android.com/reference/android/arch/lifecycle/ViewModel.html)
* [Hilt](https://developer.android.com/training/dependency-injection/hilt-android)
* [Retrofit](https://square.github.io/retrofit/)
* [Kotlin Coroutines](https://developer.android.com/kotlin/coroutines)
* [Kotlin Flow](https://developer.android.com/kotlin/flow)
* [Weather Bit](https://rapidapi.com/weatherbit/api/weather/)
  
### Screenshots
![image](https://user-images.githubusercontent.com/4177453/138528178-846ece6a-30e6-47f1-8032-335cbfc26967.png)

![image](https://user-images.githubusercontent.com/4177453/138528275-b5840465-36a4-4841-a758-2931f5d3e49d.png)

### Implementation

#### Data layer

The database is created using Room and has two entities: `City` and `Forecast`. Room generates the corresponding SQLite table at
runtime.

#### Presentation layer

The app has a Main Activity and two compose views. 

* The fist view displays the a list of cities where the user can add them on the searchBar using the Google API.  
* The second view displays a city and the forecast for the next five days.

The Activity works with a ViewModel to do the following:
* subscribe to the emissions of the user name and update the UI every time there is a new City emitted
* notify the ViewModel when the "Update" button is pressed and pass a City with update values.


#### API KEYS

The app won't run unless you add the Google Key And RapidKey
* [Weather Bit API Key](https://rapidapi.com/weatherbit/api/weather/)
* [Google Map API KEY](https://console.cloud.google.com/google/maps-apis)

![image](https://user-images.githubusercontent.com/4177453/139963318-47d0300f-e81d-4717-a8f1-eb6d83d0c39b.png)

![image](https://user-images.githubusercontent.com/4177453/139963382-ab2083b3-ec6c-4539-bf91-5e6cee1a5cee.png)

![image](https://user-images.githubusercontent.com/4177453/139963416-d8b88895-2510-4c3e-958a-54371bf871d8.png)
