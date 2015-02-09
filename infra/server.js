// ----------------------------------------------------------------------
// load the reagent app

require('./goog/bootstrap/nodejs');
require('./app');
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
var st = require('st');
var app = express();
var render_page = site.tools.render_page;

app.get('/', function (req, res) {
  res.send(render_page(req.path));
});

app.get('/page-one', function (req, res) {
  res.send(render_page(req.path));
});

var docroot = process.env.DOCROOT || '.';
console.log('DOCROOT set to ' + docroot);
var mount = st({path: docroot, url: '/'});
app.use(mount);

// ----------------------------------------------------------------------
// start the server

port = process.env.PORT || "3000";
app.listen(parseInt(port));
