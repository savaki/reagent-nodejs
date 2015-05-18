// ----------------------------------------------------------------------
// fake required browser elements

global.XMLHttpRequest = {
    prototype: {
        ajax$core$AjaxImpl$: false,
    }
};
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
// load the reagent app

require('./goog/bootstrap/nodejs');
require('./app');
goog.require('site.tools');
goog.require('main.server');

main.server.start();
