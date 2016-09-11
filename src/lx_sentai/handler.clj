(ns lx-sentai.handler
  (:require [clojure.string :refer [join, split]]
            [compojure.api.sweet :refer :all]
            [compojure.handler :refer [site]]
            [environ.core :refer [env]]
            [lx-sentai.data :refer [sentai]]
            [ring.adapter.jetty :as jetty]
            [ring.util.http-response :refer :all]))

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

(defapi app
  (context "/" []
    :tags ["main"]

    (GET "/" []
      :query-params [token :- String]
      :summary "Get the Pose"
      (if (== (compare token "9miNJtx9j5aJ7K88eEgb5CLB") 0)
        (ok (getResponse))
        (ok "Sowwy!")
      )
    )
  ))

(defn -main [& [port]]
  (let [port (Integer. (or port (env :port) 3000))]
    (jetty/run-jetty (site #'app) {:port port :join? false})))
