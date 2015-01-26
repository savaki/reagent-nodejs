// ----------------------------------------------------------------------
// load the reagent app

require('./goog/bootstrap/nodejs');
require('./app');
goog.require('main.core');
goog.require('site.tools');


// ----------------------------------------------------------------------
// fake required browser elements

global.React = require("./react.js");
global.window = {
    attachEvent: function (eventName, callback) {
        return {
            pathname: "/"
        };
    },
    location: {
        pathname: "/"
    }
};
global.document = {
    attachEvent: function (eventName, callback) {
        return {
            pathname: "/"
        };
    },
    location: {
        pathname: "/"
    }
};

// ----------------------------------------------------------------------
// load the express framework

var express = require('express');
var app = express();

app.get('/', function (req, res) {
    res.send(site.tools.render_page(req.path));
});

// ----------------------------------------------------------------------
// start the server

port = process.env.PORT || "3000";
app.listen(parseInt(port));
