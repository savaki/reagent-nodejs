(defproject CHANGE-ME-ME "0.1.0-SNAPSHOT"
            :description "CHANGE-ME"
            :url "https://CHANGE-ME"
            :dependencies [[org.clojure/clojure "1.7.0-beta3"]
                           [org.clojure/clojurescript "0.0-3269"]
                           [secretary "1.2.3"]
                           [kibu/pushy "0.3.1"]
                           [reagent "0.5.0"]
                           [cljs-ajax "0.3.11"]]

            :plugins [[lein-environ "1.0.0"]
                      [lein-cljsbuild "1.0.4"]]

            :cljsbuild {:builds [{:id           "dev"
                                  :source-paths ["src" "src-client"]
                                  :compiler     {:optimizations :none
                                                 :output-to     "target/dev/scripts/app.js"
                                                 :output-dir    "target/dev/scripts"
                                                 :pretty-print  true
                                                 :source-map    true}}
                                 {:id           "prod"
                                  :source-paths ["src" "src-client"]
                                  :compiler     {:optimizations :advanced
                                                 :output-to     "target/prod/scripts/app.js"
                                                 :output-dir    "target/prod/scripts"
                                                 :pretty-print  true}}
                                 {:id           "node"
                                  :source-paths ["src" "src-server"]
                                  :compiler     {:optimizations :none
                                                 :output-to     "target/node/scripts/app.js"
                                                 :output-dir    "target/node/scripts"
                                                 :pretty-print  true
                                                 :source-map    true}}
                                 ]}

            :min-lein-version "2.0.0")
