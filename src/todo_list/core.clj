(ns todo-list.core
  (:require [ring.adapter.jetty :as jetty]
            [ring.middleware.reload :refer [wrap-reload]]))


(defn welcome
  [request]
  (if (= "/" (:uri request))
    {:status 200
     :body "<p>Hello mothafucka</p>"
     :headers {}}
    {:status 404
     :body "<p>OOOOOOOOOOOOOOOOOOps</p>"
     :headers {}}))

(defn -dev-main
  "Simple web server using Ring & Jetty. Utilizes the wrap-reload middleware
  to allow for easier development."
  [port-number]
  (jetty/run-jetty (wrap-reload #'welcome)
                   {:port (Integer. port-number)}))

(defn -main
  "Simple web server using Ring & Jetty"
  [port-number]
  (jetty/run-jetty welcome
   {:port (Integer. port-number)}))

