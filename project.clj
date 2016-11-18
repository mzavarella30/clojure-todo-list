(defproject todo-list "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "MIT License"
            :url "https://opensource.org/license/MIT"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [ring "1.5.0"]]
  :main todo-list.core
  :profiles {:dev {:main todo-list.core/-dev-main}})
