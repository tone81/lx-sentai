(ns lx-sentai.handler
  (:require [clojure.string :refer [join, split]]
            [compojure.core :refer :all]
            [compojure.handler :refer [site]]
            [compojure.route :as route]
            [environ.core :refer [env]]
            [lx-sentai.data :refer [sentai]]
            [ring.adapter.jetty :as jetty]
            [ring.middleware.json :refer [wrap-json-response]]
            [ring.util.response :refer [response]]))

(defn getSentai
  []
  (sentai (+ (rand-int 40) 1)))

(defn getResponse
  []
  (let [{name :name image :image colors :colors} (getSentai)]
    {:response_type "in_channel"
     :attachments
       [{:title name
         :title_link image
         :image_url image
         :fallback (join "\n" [name (join " | " colors)])
         :mrkdwn_in ["fields"]}]}))

(defroutes app-routes
  (GET "/" {query-string :query-string}
    (if (== (compare ((split query-string #"=") 1) "9miNJtx9j5aJ7K88eEgb5CLB") 0)
      (response (getResponse))
      (str "Sowwy!")
    )
  )
  (route/not-found "Not Found"))

(def app
  (wrap-json-response app-routes))

(defn -main [& [port]]
  (let [port (Integer. (or port (env :port) 3000))]
    (jetty/run-jetty (site #'app) {:port port :join? false})))
