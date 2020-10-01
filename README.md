#### Songr
#### Description
This project uses Java Spring to quickly ramp up and deploy a web server. This is simply for learning purposes.

#### Installation
 $ git clone git@github.com:Satkeev/songr.git
or

 $ git clone https://github.com/Satkeev/songr.git
Usage
STEP 1: To start the server:

 $ ./gradlew bootRun
STEP 2: Then do one of the following in your favorite browser URL bar:

Hello:
localhost:8080/hello

example input:

localhost:8080/hello
example output:

Hello, World!
Capitalize:
localhost:8080/capitalize/{string}

example input:

localhost:8080/capitalize/My work
example output:

MY WORK
Reverse:
locahost:8080/reverse/sentence={string}

#### example input:

localhost:8080/reverse/sentence=I love Java
example output:

My work
Songr App:
Launch server with:

####  $ ./gradlew bootRun
How to use Songr App
In your browser URL bar, go to: localhost:8080/allAlbums

From here, you can add a new album.

After adding a new album, you can add new songs.

