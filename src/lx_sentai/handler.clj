(ns lx-sentai.handler
  (:require [compojure.core :refer :all]
            [compojure.handler :refer [site]]
            [compojure.route :as route]
            [environ.core :refer [env]]
            [ring.adapter.jetty :as jetty]
            [ring.middleware.json :refer [wrap-json-response]]
            [ring.util.response :refer [response]]))

(defroutes app-routes
  (GET "/" [] (response {:response_type "in_channel"
                :attachments
                  {:title "Sentai"
                   :title_link "https://s3-us-west-1.amazonaws.com/sentai/01-gorenger.jpg"
                   :image_url "https://s3-us-west-1.amazonaws.com/sentai/01-gorenger.jpg"
                   :fallback ""
                   :mrkdwn_in ["fields"]}}))
  (route/not-found "Not Found"))

(def app
  (wrap-json-response app-routes))

(defn -main [& [port]]
  (let [port (Integer. (or port (env :port) 3000))]
    (jetty/run-jetty (site #'app) {:port port :join? false})))
