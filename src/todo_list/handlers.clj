(ns todo-list.handlers
  (:use
   [hiccup.core]
   [hiccup.page]))

(defn welcome
  "Handler to respond with a simple welcome page"
  [request]
  (html5 {:lang "en"}
         [:head (include-css "style.css")]
   [:h1 {:class "info"} "Hello, Clojure World!"]
   [:p "I made you a todo list!"]
   [:a {:href "/todo" :class "button"} "Check out your todo list"]))
