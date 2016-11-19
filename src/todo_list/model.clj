(ns todo-list.model)

(def postgres {:subprotocol "postgresql"
               :subname //ec2-54-243-249-144.compute-1.amazonaws.com:5432/d47lsf012n36h2
               :user "mcrfprqonsvwcb"
               :password "uBYCX5m6TcKsLA2CFwOr6FCt2c"
               :ssl true
               :sslmode true
               :sslfactory "org.postgresql.ssl.NonValidatingFactory"})

(defn remote-heroku-db-spec [host port database username password]
  {:connection-uri (str "jdbc:postgresql://" host ":" port "/"
                        database "?user=" username "&password=" password
                        "&ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory")})
