# RxAndroid coLLoquium homework

This sample app was created by Dustin Graham for talk at MokiMobility.

Slides: https://docs.google.com/presentation/d/1k4Ta6SNv6DngCfOyUXJ1g1BvWpnXHAypuNpj-4OdwGY/edit?usp=sharing

We at LL made a series of changes from his original:

- fix locate bug (UI vs IO thread issue)
- add a quit button, so we can re-do locates easily
- the Settings button did nothing; now it forces a zip code that has representative
  from both parties  (maybe rename/replace this as part of your homework...)
- replaced 'isFunny' icons/check with democrat vs republican icons/check.
  (not sure his oriinal point with this, it isn't clear from the slides or code; we'll discuss)
- remove Timber, simply log as "Rx" for adb filter cleanliness and simplicity:

  $ adb logcat -v threadtime \*:S Rx:V

- added an assignment.  It is as follows:


in MainActivity, you'll see the following:

        //
        // TODO: replace the below with your own fully-reactive version.  call it as
        // _subscriptions.add(bindActivity(this, RxReverseGeocodeLocationService.getCurrentZip(this)
        //

your task is to create a new class RxReverseGeocodeLocationService, and have it implement
the method 

    public static Observable<String> getCurrentZip(Context context) { }

using the RxAndroid combining pattern -- a series of maps.  Study ReverseGeocodeLocationService, which
under the hood is really a series of steps -- first get a location, then, reverse geocode that 
location to a list of addresses, then choose an address (e.g., the first one is fine), then, get 
the postal code of the address.  Make your method do it as these four explicit steps.

We've already setup the app/build.gradle to reference a very helpful library for this:

https://github.com/mcharmas/Android-ReactiveLocation

or, feel free to go it alone.



