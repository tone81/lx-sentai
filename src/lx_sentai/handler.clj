(ns lx-sentai.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
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
  (wrap-json-response (wrap-defaults app-routes site-defaults)))
