# Ecommerce application cart Mockup

## Goal

Simulate ecomerce cart items and product listing

* Project structure sample
    - project structure
    - (default) libraries
    - testing
    - setup

## Project structure

The project is a single module application that uses the MVVM architecture,
wired with dagger for dependency management.

The project has different packages outlined.

* /data - This represents the data store used within the application. It uses Room database,
          broken into

          ~~~~
          model -> The POJO's used to represent data structures used
          repository -> Abstraction that provides interactivity with database tables
          source -> database connection setup and table structures
          ~~~~

* /di - Rep the dependency structure map

          ~~~~
          component -> Setup for items we need injected in the project
          modules -> What will be provided by dagger, setup of how dependencies are created.
          ~~~~

* /ui - The application views

          ~~~~
          activity -> Various screens used within application
          adapter -> Binding for data set to views.
          view_model -> Store and Manage data used within app ui.
          ~~~~




## Libraries used
~~~~
Androidx (ViewModels, LiveData, DataBinding, Room)
Dagger2
RxJava
Ktlint
~~~~


## Testing

* /tests - To be done.


## Setup

Clone the project and import into Android Studio
    `git clone git@github.com:3barney/javad_android_application.git`

To run the application ensure mobile device is connected.
    *1. Use android studio and run the application.
    *2. Using gradle
    ~~~~
        *Navigate to root of project.
        *If using linux or mac execute
        *    ```./gradlew installDebug```
        *on windows
        *    ```gradlew installDebug```
    ~~~~


Project can be run in two ways:

