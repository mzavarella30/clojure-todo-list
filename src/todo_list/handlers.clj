(ns todo-list.handlers
  (:use
   [hiccup.core]
   [hiccup.page])
  (:require [todo-list.model :as m]))

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

(defn todo-row
  "Creates the html for each todo"
  [[id name]]
  (html
   [:div {:id id}
    [:p (str "[] - " name)]]))

(defn todo
  "Handler to respond with the todo list"
  [request]
  (html5 {:lang "en"}
         (header)
         [:body
          (map todo-row (m/get-all-as-todo))]))
