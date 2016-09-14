(ns lx-sentai.handler
  (:require [clojure.core.match :refer [match]]
            [clojure.string :refer [join, split]]
            [compojure.api.sweet :refer :all]
            [compojure.handler :refer [site]]
            [environ.core :refer [env]]
            [lx-sentai.data :refer [getRandomSentai]]
            [ring.adapter.jetty :as jetty]
            [ring.util.http-response :refer :all]
            [schema.core :as s]))

(def ^:private TOKEN "9miNJtx9j5aJ7K88eEgb5CLB")

(defn getSquad
  [text]
  (match text
    ""              ["Tony" "Tyrone" "Denise" "Kyla"]
    "@views"        ["Tony" "Tyrone" "Denise" "Kyla"]
    "@integrations" ["Alice" "KStar" "Oron"]
    "@security"     ["Damir" "Karen" "Josh"]
    "@inbox"        ["Mike" "Taylor" "Elliot"]
    "@war"          ["Sahil" "Stephen" "James" "Andrew" "Xie"]
    "@mobile"       ["Matt" "Brian"]
    "@scripting"    ["Björn" "Wyatt"]
    "@design"       ["Kay" "Abi" "Alex"]
    :else  (split text #" ")))

(defn getColorIndex
  [colorCount, indices, index]
  (if (>= (count indices) colorCount)
    index
    (if (< (count indices) (count (set (conj indices index))))
      index
      (getColorIndex colorCount indices (rand-int colorCount)))))

(defn getValues
  [squad, colors]
  ((defn getValue
    [squad, colorIndices]
    (match squad
      [] nil
      [x & xs]
      (let [colIdx (getColorIndex (count colors) colorIndices (rand-int (count colors)))]
        (conj (getValue xs, (conj colorIndices colIdx)) (str x " --> " (nth colors colIdx))))))
        squad []))

(defn getResponse
  [text]
  (let [{name :name image :image colors :colors} (getRandomSentai)]
    {:response_type "in_channel"
     :attachments
       [{:fields [{:title "Pairings"
                   :value (join " | " (getValues (getSquad text) colors))
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
      (match (compare token TOKEN)
        0     (ok (getResponse text))
        :else (ok "Sowwy!"))
    )
  ))

(defn -main [& [port]]
  (let [port (Integer. (or port (env :port) 3000))]
    (jetty/run-jetty (site #'app) {:port port :join? false})))
