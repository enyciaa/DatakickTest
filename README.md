# AndroidStarterTemplate

A starter project with a basic wireframe and architecture in place. This makes it quicker to build android projects.

### Ui
Limited to android specific views and resources. Contains all activities, fragments, and custom views.

### Common
Contains entities, usecases, services, and the VVM part of the ui
Eventually this module should be pure kotlin

### App
Contains dependency injection, and platform specific implementations such as ThreadProvider, Database, SharedPreferences, etc.
