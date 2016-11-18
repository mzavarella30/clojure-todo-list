(ns todo-list.core
  (:require [ring.adapter.jetty :as jetty]))


(defn welcome
  [request]
  {:status 200
   :body "<p>Hello mothafucka</p>"
   :headers {}})

(defn -main
  "Simple web server using Ring & Jetty"
  [port-number]
  (jetty/run-jetty
   (fn [request] {:status 200
                  :body "<p>Hello World!!!</p>"
                  :headers {}})
   {:port (Integer. port-number)}))

