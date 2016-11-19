(ns todo-list.model
  (:require [clojure.java.jdbc :as sql]))

(def conn (str "postgres://mcrfprqonsvwcb:uBYCX5m6TcKsLA2CFwOr6FCt2c"
                "@ec2-54-243-249-144.compute-1.amazonaws.com:5432"
                "/d47lsf0l2n36h2?ssl=true"
                "&sslfactory=org.postgresql.ssl.NonValidatingFactory"))

(defn incomplete-tasks
  "Filters all off the tasks in the db to get
  only the tasks that haven't been completed yet. "
  [tasks]
  (map #(% :id)
       (filter #(= false (% :completed)) tasks)))

(defn all-tasks
  "select all tasks from db"
  [conn & opts]
  (sql/query conn ["select * from tasks"]))
