(defproject todo-list "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "MIT License"
            :url "https://opensource.org/license/MIT"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [ring "1.5.0"]
                 [compojure "1.5.1"]
                 [hiccup "1.0.5"]
                 [org.clojure/java.jdbc "0.7.0-alpha1"]
                 [postgresql/postgresql "9.1-901-1.jdbc4"]]
  :repl-options {:init-ns todo-list.core
                 :init (println "We are in " *ns*)}
  :main todo-list.core
  :auto-clean false
  :profiles {:dev {:main todo-list.core/-dev-main}
             :uberjar {:aot :all}}
  :min-lein-version "2.0.0"
  :uberjar-name "todo-list.jar")

