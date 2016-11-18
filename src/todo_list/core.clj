(ns todo-list.core
  (:require [ring.adapter.jetty :as jetty]))


(defn welcome
  [request]
  (if (= "/" (:uri request))
    {:status 200
     :body "<p>Hello mothafucka</p>"
     :headers {}}
    {:status 404
     :body "<p>OOOOOOOOOOOOOOOOOOps</p>"
     :headers {}}))

(defn -main
  "Simple web server using Ring & Jetty"
  [port-number]
  (jetty/run-jetty welcome
   {:port (Integer. port-number)}))

