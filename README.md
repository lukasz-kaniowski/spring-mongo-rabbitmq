spring-mongo-rabbitmq
=====================
[![Build Status](https://secure.travis-ci.org/lukasz-kaniowski/spring-mongo-rabbitmq.png)](http://secure.travis-ci.org/lukasz-kaniowski/spring-mongo-rabbitmq)


Sample spring application with mongo and rabbitmq. 

This app is live on cloudfoundry [link to app][2]

## MongoDb - Spring Data

* Model mapping
* Map Reduce example
* Spring data repository (with custom repository methods)
* Use of mongo template

Check junit tests [PersonRepositoryTest][1]

## Redis - Spring Data

* RedisTemplate usage
* Redis: Value, List, Counters
* Publish Subscribe Events

Check junit tests [RedisRepositoryTest][5] and [RedisPublisherTest][6]

## Frontend 

* Spring mvc
* i18n 
* Layouts with [sitemesh][3]
* Styling using [Twitter Bootstrap][4]* 


[1]: ./blob/master/src/test/java/com/lkan/sample/mongo/repository/PersonRepositoryTest.java
[2]: http://ukasz-spring.cloudfoundry.com/
[3]: http://wiki.sitemesh.org/display/sitemesh/Home
[4]: http://twitter.github.com/bootstrap/
[5]: blob/master/src/test/java/com/lkan/sample/redis/RedisRepositoryTest.java
[6]: blob/master/src/test/java/com/lkan/sample/redis/RedisPublisherTest.java

	

