(ns hn-dead-links.api
  (:require [clj-http.client :as client]
            [clojure.data.json :as json]))

(def base-uri "https://hacker-news.firebaseio.com/v0")
(def max-timeout 4000)

(defn get-request
  [url]
  (client/get url))

(defn get-body
  [req]
  (json/read-str (get req :body)))

(defn hn-get
  [route]
  (get-request (str base-uri route)))

(defn hn-get-json
  [route]
  (get-body (hn-get (str route ".json"))))

(defn hn-get-item
  [item]
  (hn-get-json (str "/item/" item)))

(defn hn-get-user
  [user]
  (hn-get-json (str "/user/" user)))

(defn hn-get-user-items
  [user]
  (get (hn-get-user user) "submitted"))

(defn hn-get-user-stories
  [user]
  (->> user
       (hn-get-user-items)
       (map hn-get-item)
       (filter (fn [req] (= (get req "type") "story")))))

(defn hn-get-user-stories-links
  [user]
  (->> user
       (hn-get-user-stories)
       (map (fn [req] (get req "url")))))

(def test-user "")
(println (hn-get-user-stories test-user))
