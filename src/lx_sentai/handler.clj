(ns lx-sentai.handler
  (:require [clojure.string :refer [join]]
            [compojure.api.sweet :refer :all]
            [compojure.handler :refer [site]]
            [environ.core :refer [env]]
            [lx-sentai.data :refer [get-random-sentai, get-squad]]
            [ring.adapter.jetty :as jetty]
            [ring.util.http-response :refer :all]
            [schema.core :as s]))

(def ^:private TOKEN "9miNJtx9j5aJ7K88eEgb5CLB")

(defn get-color-index
  ([color-count indices] (get-color-index color-count indices (rand-int color-count)))
  ([color-count indices index]
    (if (>= (count indices) color-count)
      index
      (if (< (count indices) (count (set (conj indices index))))
        index
        (recur color-count indices (rand-int color-count))))))

(defn get-values
  [squad colors]
  ((defn get-value
    ([] (get-value squad))
    ([squad] (get-value squad []))
    ([[x & xs] color-indices]
      (if (nil? x)
        nil
        (let [col-idx (get-color-index (count colors) color-indices)]
          (conj (get-value xs, (conj color-indices col-idx)) (str x " --> " (nth colors col-idx)))))))))

(defn get-repsonse
  [text]
  (let [{name :name image :image colors :colors} (get-random-sentai)]
    {:response_type "in_channel"
     :attachments
       [{:fields [{:title "Pairings"
                   :value (join " | " (get-values (get-squad text) colors))
                   :short true}]
         :title name
         :title_link image
         :image_url image
         :fallback (join "\n" [name (join " | " colors)])
         :mrkdwn_in ["fields"]}]}))

(defapi app
  (context "/" []
    :tags ["main"]

    (GET "/" []
      :return       s/Any
      :query-params [token :- String {text :- String ""}]
      :summary      "Get the Pose with token and text. text defaults to empty string."
      (if (== (compare token TOKEN) 0)
        (ok (get-repsonse text))
        (ok "Sowwy!"))
    )
  ))

(defn -main [& [port]]
  (let [port (Integer. (or port (env :port) 3000))]
    (jetty/run-jetty (site #'app) {:port port :join? false})))
