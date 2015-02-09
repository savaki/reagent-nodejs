(ns main.client
  (:require [reagent.core :as reagent :refer [atom]]
            [secretary.core :as secretary :refer-macros [defroute]]
            [pushy.core :as pushy :refer [push-state!]]

            [main.core :as core])
  (:import goog.History))

(enable-console-print!)

(reagent/render-component [core/app-view] (.getElementById js/document "app"))

(push-state! secretary/dispatch!
  (fn [x] (when (secretary/locate-route x) x)))