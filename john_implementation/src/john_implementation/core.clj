(ns john-implementation.core
  (:require [org.httpkit.client :as http-kit]
            [cheshire.core :refer :all])
  (:gen-class))


(defn get-submissions
  [user_id]
  (def response  (http-kit/get (str "https://hacker-news.firebaseio.com/v0/user/" user_id ".json")))
    (get (parse-string (:body @response)) "submitted")
)


; This takes a userid, finds all submissions, and returns a list of post id's
(defn sub-to-list
  [user_id]
  (def list (get-submissions user_id)))


(defn -main
  (sub-to-list "elamje")
  (println list)
  ;call function to iterate over list look for responses with a url, then check that url
)
