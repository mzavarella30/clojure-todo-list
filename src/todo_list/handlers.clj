(ns todo-list.handlers
  (:use
   [hiccup.core]
   [hiccup.page]))

(defn header
  "builds the universal header"
  [& opts]
  (html5
   [:head (include-css "style.css")]))

(defn welcome
  "Handler to respond with a simple welcome page"
  [request]
  (html5 {:lang "en"}
         (header)
         [:body
          [:h1 {:class "info"} "Hello, Clojure World!"]
          [:p "I made you a todo list!"]
          [:a {:href "/todo" :class "button"} "Check out your todo list"]]))

(defn todo
  "Handler to respond with the todo list"
  [request]
  (html5 {:lang "en"}
         [:head]
         [:body]))
