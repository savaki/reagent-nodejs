# reagent-nodejs

Isomorphic reagent app with both server and client side rendering.  

Note: This code is very alpha, use at your own risk.

Initial rendering happens with reagent on the server side in node, subsequent action 
render through reagent in the browser.

## Prerequisites

* Java 7 or better
* Rake - any version will do
* NodeJS - assumes the binary is named ```node```

## Quick Start

Starts a web server on port 3000 with reagent rendering on the server side.

```
rake lein:dev node:run
```

For now, I'm using rake as the task launcher as I'm still wrapping my head around 
leiningen.

## Using nodemon

In development mode, it's useful to automatically restart the node server if anything 
changes.  To do this, we can do the following:

#### Shell #1 - autocompile cljs -> js

```
rake lein:watch
```

#### Shell #2 - start up nodemon in 

```
export NODE=nodemon
rake node:run
```

## Todo

* switch from rake to lein (or even gulp)


