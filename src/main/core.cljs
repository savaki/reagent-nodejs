(ns main.core
  (:require [reagent.core :as reagent :refer [atom]]
            [ajax.core :as ajax]))

(defn ^:export greetings [name]
  (str "hello " name))

(defn app-view []
  [:div "hello world"])
