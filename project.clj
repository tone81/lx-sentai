(defproject lx-sentai "0.1.0-SNAPSHOT"
  :description "Lets you get a Sentai Pose"
  :url "http://example.com/FIXME"
  :min-lein-version "2.0.0"
  :license {:name "MIT License"
            :url "https://opensource.org/licenses/MIT"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [compojure "1.5.1"]
                 [environ "1.0.0"]
                 [ring/ring-jetty-adapter "1.4.0"]
                 [ring/ring-json "0.4.0"]]
  :plugins [[lein-ring "0.9.7"]
            [environ/environ.lein "0.3.1"]]
  :ring {:handler lx-sentai.handler/app}
  :hooks [environ.leiningen.hooks]
  :uberjar-name "lx-sentai.jar"
  :profiles
    {:production {:env {:production true}}
     :dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                        [ring/ring-mock "0.3.0"]]}})
