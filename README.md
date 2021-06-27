# Java plugin architecture with gradle

Re-implementation of a plugin architecture in Java 8, **with Gradle**.  

## Use case
- I want to be able to plug different storage systems: `storage-alpha` or `storage-gamma`
- I want to be able to plug different authentication systems: `storage-epsilon` or any new one in the future.
- I don't want to have dependencies conflict
- I don't want to load everything in production systems.  

## Usage

    ci/install.sh   # ./gradlew build
    ci/run.sh

## Gotchas
In this implem:

- the plugins to chose for the run are hardcoded in the app-core `App` class. 
- write the meta-inf/services correctly when adding a new plugin
- in `app-core`, the name used to load a plugin corresponds to the name method of the factory implementation.
- 
 

## References:  
https://medium.com/geekculture/designing-a-lightweight-plugin-architecture-in-java-5eedfeaa92a9
https://www.baeldung.com/java-spi
https://github.com/prestodb/presto
https://docs.gradle.org/current/samples/sample_building_java_applications_multi_project.html