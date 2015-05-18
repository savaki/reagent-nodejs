(ns main.server
  (:require [cljs.nodejs :as node]
            [site.tools :as tools]))

(enable-console-print!)

(defn handle-request [req res]
  (.send res (tools/render-page (.-path req))))

(defn ^:export start []
  (let [env-docroot (-> node/process .-env .-DOCROOT)       ; read docroot from env
        docroot     (if (nil? env-docroot) "." env-docroot)
        env-port    (-> node/process .-env .-PORT)
        port        (if (nil? env-port) "3000" env-port)

        express     (node/require "express")                ; load express
        app         (express)

        st          (node/require "st")                     ; and st module
        mount       (st (clj->js {:path docroot
                                  :url  "/"}))]
    (println " DOCROOT set to " docroot)
    (doto app
      (.get "/" handle-request)
      (.get "/page-one" handle-request)
      (.use mount)
      (.listen port))
    (println (str " Express server started on port: " port))))

