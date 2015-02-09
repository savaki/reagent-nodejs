(ns site.tools
  (:require [reagent.core :as reagent :refer [atom]]
            [secretary.core :as secretary :refer-macros [defroute]]
            [main.core :as core]
            [ajax.core :as ajax]))

(enable-console-print!)

(defn template [{:keys [title body]}]
  [:html [:head [:meta {:charset "utf-8"}]
          [:meta {:name "viewport"
                  :content "width=device-width, initial-scale=1.0"}]]
   [:body [:div#app [body]]
    [:script {:type "text/javascript" :src "//fb.me/react-0.12.2.min.js"}]
    [:script {:type "text/javascript" :src "scripts/goog/base.js"}]
    [:script {:type "text/javascript" :src "scripts/app.js"}]
    [:script {:type "text/javascript"
              :dangerouslySetInnerHTML {:__html "goog.require('main.client');"}}]
    ]])

(defn ^:export render-page [path]
  (reagent/render-to-static-markup (do
                                     (secretary/dispatch! path)
                                     (template {:title "title" :body core/app-view}))))
