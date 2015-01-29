(ns main.core
  (:require [reagent.core :as reagent :refer [atom]]
            [ajax.core :as ajax]))

(defn ^:export greetings [name]
  (str "hello " name))

(defn handle-click []
  (js/alert "hello world")
  false)

(defn app-view []
  [:div "hello world"
   [:a {:href "#" :on-click handle-click} "click me"]])

(try
  (reagent/render-component [app-view] (.getElementById js/document "app"))
  (catch :default e e))

