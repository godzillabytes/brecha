(ns brecha.tools
  (:require [pandect.core :as pd]
            [org.httpkit.client :as http]
            [clojure.data.json :as json]))

(defn calculate-signature [url secret]
  (pd/sha512-hmac url secret))

(defn sign-it [url secret]
  {:headers {"apisign" (calculate-signature  url secret)}})

(defn query-string [params]
    (str "?"
       (clojure.string/join
        "&"
        (map #(format "%s=%s" (name (first %)) (second %))
             (partition 2 params)))))

(defn query [url & [secret]]
  (json/read-json (:body @(http/get url (when secret (sign-it url secret))))))
