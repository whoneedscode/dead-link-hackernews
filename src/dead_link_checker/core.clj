(ns dead-link-checker.core
  (:require [clojure.string :as str]
            [clojure.xml    :as xml]
            [clojure.zip    :as zip]))

(def test-comment "This is a test comment containing a <a href=\"https://www.google.com\"/> link!")

(defn zip-str [s]
  (zip/xml-zip 
   (xml/parse (java.io.ByteArrayInputStream. (.getBytes s)))))

(defn wrap-comment [s] (str "<p>" s "</p>"))

(defn is-html-link [t] (and (map? t) (contains? t :tag) (= (:tag t) :a)))

(defn url-from-html-link [l] (:href (:attrs l)))

(defn links-from-item-content [s] 
  (map url-from-html-link
       (filter is-html-link 
               (:content (first (zip-str (wrap-comment s)))))))

(defn get-item-text [id]
  false) ;; TODO: Query HN api

(defn links-from-item [id]
  (let [item (get-item-text id)]
    links-from-item-content item))

(defn item-ids-of-user [user]
  false) ;; TODO: Query HN api

(defn posted-links [user]
  (let [ids (item-ids-of-user user)
        links (concat (map links-from-item ids))] links))
