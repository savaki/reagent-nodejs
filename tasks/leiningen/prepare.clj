(ns leiningen.prepare
  (:require [clojure.java.io :as io]
            [clojure.java.shell :as shell]))

(defn copy [uri file]
  (with-open [in  (io/input-stream uri)
              out (io/output-stream file)]
    (io/copy in out)))

(defn copy-file [source-path dest-path]
  (io/copy (io/file source-path) (io/file dest-path)))

(defn mkdirs [absolute-path]
  (loop [levels  (clojure.string/split absolute-path #"/")
         current ""]
    (when (not (empty? levels))
      (let [next-level (str current (first levels) "/")]
        (.mkdir (java.io.File. next-level))
        (recur (rest levels) next-level)))))

(defn prepare [project & args]
  (let [basedir       "target/node/scripts"
        react-version "0.13.3"
        bootstrap-dir (str basedir "/goog/bootstrap")]
    (println "creating node app directory," bootstrap-dir)
    (mkdirs bootstrap-dir)

    (println "downloading react," react-version)
    (copy (str "https://fbcdn-dragon-a.akamaihd.net/hphotos-ak-xfa1/t39.3284-6/11057104_994066363946450_2043645399_n.js")
          (str basedir "/react.js"))

    (println "downloading closure nodejs bootstrap")
    (copy "https://raw.githubusercontent.com/google/closure-library/master/closure/goog/bootstrap/nodejs.js"
          (str bootstrap-dir "/nodejs.js"))

    (println "installing express & st")
    (println (shell/sh "/bin/bash" "-c" (str "(cd " basedir "; npm install express st)")))

    (println "copying server.js bootstrap file")
    (copy-file "infra/server.js" (str basedir "/server.js"))

    (println "done")))

