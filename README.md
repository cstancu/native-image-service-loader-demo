Simple demo project for using `ServiceLoader` with [GraalVM](https://github.com/oracle/graal) native-image.

Build the jar with:

```
$ mvn package
```

Run on JVM with:
```
$ java -jar target/ServiceLoaderTest-1.0-SNAPSHOT.jar 
```

The output should be:
```
services.iterator().hasNext() = true
service implementation = class service.ServiceImplementation0
service implementation = class service.ServiceImplementation1
```

Assuming that you build [`SubstrateVM from latest sources`](https://github.com/oracle/graal/tree/master/substratevm#quick-start) and that you cloned this repo in `$HOME/native-image-service-loader-demo/` you can build a native image with:

```
$ mx native-image -H:ReflectionConfigurationFiles=$HOME/native-image-service-loader-demo/reflection_config.json -H:IncludeResources=META-INF/services/*.* -jar $HOME/native-image-service-loader-demo/target/ServiceLoaderTest-1.0-SNAPSHOT.jar
   classlist:  16,962.11 ms
       (cap):     835.16 ms
       setup:   3,460.00 ms
  (typeflow):   4,428.94 ms
   (objects):   2,567.04 ms
  (features):      58.58 ms
    analysis:   7,169.75 ms
    universe:     231.97 ms
     (parse):   1,073.35 ms
    (inline):     762.52 ms
   (compile):   5,714.33 ms
     compile:   7,948.27 ms
       image:   1,230.51 ms
       write:     175.24 ms
     [total]:  37,239.78 ms
```

Then you can run the native image:

```
$ ./ServiceLoaderTest-1.0-SNAPSHOT
```

The output should be the same:
```
services.iterator().hasNext() = true
service implementation = class service.ServiceImplementation0
service implementation = class service.ServiceImplementation1
```
