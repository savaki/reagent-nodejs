# reagent-nodejs

Isomorphic reagent app with both server and client side rendering.  

Note: This code is very alpha, use at your own risk.

Initial rendering happens with reagent on the server side in node, subsequent action 
render through reagent in the browser.

## Prerequisites

* Java 7 or better
* NodeJS - assumes the binary is named ```node```

## Quick Start

Starts a web server on port 3000 with reagent rendering on the server side.

```
infra/lein cljsbuild once dev node
infra/lein nodejs
```

## How It Works

On the server side, reagent-nodejs uses node along with express to server content.  There were a couple of shims required to make it work:

* closure requires downloading the nodejs.js bootstrap code from the closure-library
* a copy of react.js needs to be present in the server's root directory
* javascript stubs - window.attachEvent, document.attachEvent, and XMLHttpRequest 
* React var needs to be defined with the contents of react library

## To Do

* Update to work with advanced mode compilation
* Figure out how Clojure shell out can write to stdout.  Currently, ```infra/lein nodejs``` doesn't print anything
