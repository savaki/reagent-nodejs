(ns leiningen.nodejs
  (:require [clojure.java.io :as io]
            [clojure.java.shell :as shell]))

(defn nodejs [project & args]
  (let [basedir "target/node/scripts"]
    (println (shell/sh "/bin/bash" "-c" (str "(cd " basedir "; node server.js)")))))
