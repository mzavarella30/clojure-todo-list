(ns todo-list.core
  (:require [ring.adapter.jetty :as jetty]
            [ring.middleware.reload :refer [wrap-reload]]
            [compojure.core :refer [defroutes GET]]
            [compojure.route :refer [not-found]]
            [ring.handler.dump :refer [handle-dump]]
            [todo-list.handlers :refer :all]))

(defroutes app
  (GET "/" [] welcome)
  ;(GET "/goodbye" [] goodbye)
  ;(GET "/about" [] about)
  ;(GET "/request-info" [] handle-dump)
  ;(GET "/hello/:nombre" [] hello)
  ;(GET "/calc/:op/:a/:b" [] calc)
  (not-found "Oops..."))

(defn -dev-main
  "Simple web server using Ring & Jetty. Utilizes the wrap-reload middleware
  to allow for easier development."
  [port-number]
  (jetty/run-jetty (wrap-reload #'app)
                   {:port (Integer. port-number)}))

(defn -main
  "Simple web server using Ring & Jetty"
  [port-number]
  (jetty/run-jetty app
   {:port (Integer. port-number)}))

