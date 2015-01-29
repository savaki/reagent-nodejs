# reagent-nodejs
running reagent on the server side with nodejs

## Prerequisites

* Java 7 or better
* Rake - any version will do
* NodeJS - assumes the binary is named ```node```

## Quick Start

Starts a web server on port 3000 with reagent rendering on the server side.

```
rake lein:dev node:dev
```

## Using nodemon

In development mode, it's useful to automatically restart the node server if anything changes.  To do this, we can do the following:

#### Shell #1 - autocompile cljs -> js

```
rake lein:watch
```

### Shell #2 - start up nodemon in 

```
export NODE=nodemon
rake node:dev
```

## Todo

* switch from rake to lein


