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

