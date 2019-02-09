(defproject hn-dead-links "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "MIT License"
            :url "none"
            :year 2019
            :key "mit"}
  :dependencies [[org.clojure/clojure "1.9.0"]
                 [clj-http "3.9.1"]
                 [org.clojure/data.json "0.2.6"]]
  :main ^:skip-aot hn-dead-links.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
