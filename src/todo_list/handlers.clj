(ns todo-list.handlers
  (:use
   [hiccup.core]
   [hiccup.page]))

(defn welcome
  "Handler to respond with a simple welcome page"
  [request]
  (html5 {:lang "en"}
         [:head (include-css "/resources/css/style.css")]
   [:h1 {:class "info"} "Hello, Clojure World!"]
   [:p "Welcome to my first real Clojure thing."]))
