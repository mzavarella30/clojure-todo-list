(ns todo-list.core
  (:require [ring.adapter.jetty :as jetty]
            [ring.middleware.reload :refer [wrap-reload]]
            [compojure.core :refer [defroutes GET]]
            [compojure.route :refer [not-found]]
            [ring.handler.dump :refer [handle-dump]]))

(defroutes app
  (GET "/" [] welcome)
  (GET "/goodbye" [] goodbye)
  (GET "/about" [] about)
  (GET "/request-info" [] handle-dump)
  (GET "/hello/:nombre" [] hello)
  (not-found "Oops..."))

(defn hello
  [request]
  (let [name (get-in request [:route-params :nombre])]
    {:status 200
     :body (str "Hello, " name "!")
     :headers {}}))

(defn about
  [request]
  {:status 200
   :body "About me!"
   :headers {}})

(defn goodbye
  [request]
  {:status 200
   :body "Goodbye"
   :headers {}})

(defn welcome
  [request]
  {:status 200
   :body "<p>Hello world</p>"
   :headers {}})

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

