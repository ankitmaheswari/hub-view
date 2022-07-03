# Hub View
This is an Android application which displays closed pull requests for a Github Repository([square/okhttp](https://github.com/square/okhttp/pulls?q=is%3Aclosed)).

<h2>Architecture & Components</h2>
<ul>
<li>Based on the Model View View Model(MVVM) architecture. </li>
<li>Written completely in Kotlin.</li>
<li>Dagger2 as the dependency injection framework.</li>
<li>Retrofit alongwith OkHttp and Gson for network calls.</li>
<li>Glide as the image loading library.</li>
<li>DataBinding to bind data to the views.</li>
<li>RecyclerView to display the list of closed Pull Requests.</li>
</ul>

<h2>How to build the app?</h2>
<ul>
<li>Open the app in Android Studio(preferably Android Studio 2021.2.1 or later).</li>
<li>Setup Java 11 as the JDK either in the Build Tools->Gradle in Android Studio settings or by setting the <code>org.gradle.java.home</code> to the path to jdk11 or later on your local system in [gradle.properties](https://github.com/ankitmaheswari/hub-view/blob/master/gradle.properties) file </li>
<li>Sync Project with Gradle files and Run the <b>app</b> module.</li>
</ul>
