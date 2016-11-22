(ns todo-list.model
  (:require [clojure.java.jdbc :as j]))

(def db (str "postgres://mcrfprqonsvwcb:uBYCX5m6TcKsLA2CFwOr6FCt2c"
                "@ec2-54-243-249-144.compute-1.amazonaws.com:5432"
                "/d47lsf0l2n36h2?ssl=true"
                "&sslfactory=org.postgresql.ssl.NonValidatingFactory"))

(def test-todos [
                 {:id 10, :name "tesst 10"},
                 {:id 11, :name "tesst 11"},
                 {:id 12, :name "tesst 12"},
                 {:id 13, :name "tesst 13"},
                 {:id 14, :name "tesst 14"}
                 ])

(defn row
  [id todo completed]
  {:id id, :name todo, :completed completed})

(defn get-todo
  "Selects a specific todo from the db"
  [id]
  (first (j/query db ["select * from tasks where id = ?" id])))

(defn create-todo
  "Inserts a todo into the DB and set's the completion to false"
  [todo]
  (first (j/insert! db :tasks (merge todo {:completed false}))))

(defn get-all
  "Selects all of the todos from the db." []
  (j/query db ["select * from tasks"]))

(defn patch-todo
  "Updates a todo in the db"
  [id body completed]
  (j/update! db :tasks (row id body completed) ["id = ?" id])
  (get-todo id))

(defn delete-all []
  (j/delete! db :tasks [true]))

(defn delete-todo [id]
  (j/delete! db :tasks ["id = ?" id]))

(defn all-tasks
  "select all tasks from db"
  [conn & opts]
  (j/query conn ["select * from tasks"]))
