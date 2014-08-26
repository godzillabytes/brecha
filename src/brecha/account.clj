(ns brecha.account
  (:require [clj-time.core :as time]
            [clj-time.coerce :as tc])
  (:use [brecha.tools]))


(let [base-url "https://bittrex.com/api/v1.1/account/"]

  (defn get-balances [api-key secret]
    (let [params (query-string [:apikey api-key
                                :nonce (tc/to-long (time/now))])
          url (str base-url "getbalances" params)]
      (query url secret)))

  (defn get-balance [api-key secret currency]
    (let [params (query-string [:apikey api-key
                                :nonce (tc/to-long (time/now))
                                :currency currency])
          url (str base-url "getbalance" params)]
      (query url secret)))

  (defn get-deposit-address [api-key secret currency]
    (let [params (query-string [:apikey api-key
                                :nonce (tc/to-long (time/now))
                                :currency currency])
          url (str base-url "getdepositaddress" params)]
      (query url secret)))

  (defn withdraw [api-key secret currency quantity address]
    (let [params (query-string [:apikey api-key
                                :nonce (tc/to-long (time/now))
                                :currency currency
                                :quantity quantity
                                :address address])
          url (str base-url "withdraw" params)]
      (query url secret)))

  (defn get-order [api-key secret order-id]
    (let [params (query-string [:apikey api-key
                                :nonce (tc/to-long (time/now))
                                :orderid order-id])
          url (str base-url "getorder" params)]
      (query url secret)))

  (defn get-order-history [api-key secret & {:keys [market count]}]
    (let [params (query-string (concat
                                [:apikey api-key
                                 :nonce (tc/to-long (time/now))]
                                (when market [:market market])
                                (when count [:count count])))
          url (str base-url "getorderhistory" params)]
      (query url secret)))

  (defn get-withdrawal-history [api-key secret & {:keys [currency count]}]
    (let [params (query-string (concat
                                [:apikey api-key
                                 :nonce (tc/to-long (time/now))]
                                (when currency [:currency currency])
                                (when count [:count count])))
          url (str base-url "getwithdrawalhistory" params)]
      (query url secret)))

  (defn get-deposit-history [api-key secret & {:keys [currency count]}]
    (let [params (query-string (concat
                                [:apikey api-key
                                 :nonce (tc/to-long (time/now))]
                                (when currency [:currency currency])
                                (when count [:count count])))
          url (str base-url "getdeposithistory" params)]
      (query url secret))))

