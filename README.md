# Books API

Project to provide changed api for googleapis book

## Configuration

The configuration file is placed in : 

```
src/main/resources/application.yml
```

and following parameter is have to be defined


```
spring:
  profiles:

booksPath: "path to book.js file"
```

##Build

Project is configured for build with gradle tool, 
so following command is used for build project

```
gradle build
```

##Running
For run program execute command

```
java -jar build/libs/books-0.0.1-SNAPSHOT.jar
```

##License
This project is licensed under the MIT License
