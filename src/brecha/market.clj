(ns brecha.market
  (:require [clj-time.core :as time]
            [clj-time.coerce :as tc])
  (:use [brecha.tools]))



(let [base-url "https://bittrex.com/api/v1.1/market/"]

  (defn buy-limit [api-key secret market quantity rate]
    (let [params (query-string [:apikey api-key
                                :nonce (tc/to-long (time/now))
                                :quantity quantity
                                :rate rate])
          url (str base-url "buylimit" params)]
      (query url secret)))

  (defn buy-market[api-key secret market quantity]
    (let [params (query-string [:apikey api-key
                                :nonce (tc/to-long (time/now))
                                :market market
                                :quantity quantity])
          url (str base-url "buymarket" params)]
      (query url secret)))

  (defn sell-limit[api-key secret market quantity rate]
    (let [params (query-string [:apikey api-key
                                :nonce (tc/to-long (time/now))
                                :market market
                                :quantity quantity
                                :rate rate])
          url (str base-url "selllimit" params)]
      (query url secret)))

  (defn sell-market[api-key secret market quantity]
    (let [params (query-string [:apikey api-key
                                :nonce (tc/to-long (time/now))
                                :market market
                                :quantity quantity])
          url (str base-url "sellmarket" params)]
      (query url secret)))

  (defn cancel[api-key secret order-id]
    (let [params (query-string [:apikey api-key
                                               :nonce (tc/to-long (time/now))
                                               :uuid order-id
                                               ])
          url (str base-url "cancel" params)]
      (query url secret)))

  (defn get-open-orders[api-key secret & [market]]
    (let [params (query-string
                  (concat [:apikey api-key
                           :nonce (tc/to-long (time/now))]
                          (when market [:market market])))
          url (str base-url "getopenorders" params)
          ]
      (query url secret))))
