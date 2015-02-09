(defproject CHANGE-ME-ME "0.1.0-SNAPSHOT"
  :description "CHANGE-ME"
  :url "https://CHANGE-ME"
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [org.clojure/clojurescript "0.0-2740"]
                 [figwheel "0.2.1-SNAPSHOT"]
                 [secretary "1.2.1"]
                 [kibu/pushy "0.2.2"]
                 [reagent "0.5.0-alpha"]
                 [cljs-ajax "0.3.4"]]

  :preamble ["reagent/react.js"]

  :plugins [[lein-environ "1.0.0"]
            [lein-cljsbuild "1.0.4"]]

  :cljsbuild {:builds [{:id "dev"
                        :source-paths ["src" "src-client"]
                        :compiler {:optimizations :none
                                   :output-to "target/dev/scripts/app.js"
                                   :output-dir "target/dev/scripts"
                                   :pretty-print true
                                   :source-map true}}
                       {:id "prod"
                        :source-paths ["src" "src-client"]
                        :compiler {:optimizations :advanced
                                   :output-to "target/prod/scripts/app.js"
                                   :output-dir "target/prod/scripts"
                                   :pretty-print true}}
                       {:id "node"
                        :source-paths ["src"]
                        :compiler {:optimizations :none
                                   :output-to "target/node/scripts/app.js"
                                   :output-dir "target/node/scripts"
                                   :pretty-print true
                                   :source-map true}}
                       ]}

  :min-lein-version "2.0.0")
