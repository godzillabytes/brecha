(ns brecha.examples
  (:require [brecha.public :as p-api]
        [brecha.account :as a-api]
        [brecha.market :as m-api]))

(p-api/get-markets)

(p-api/get-currencies)

(p-api/get-ticker "BTC-LTC")

(p-api/get-market-summaries)

(p-api/get-market-summary "BTC-LTC")

(p-api/get-orderbook "BTC-LTC" "sell")

(p-api/get-orderbook "BTC-LTC" "sell" 5)

(p-api/get-market-history "BTC-LTC")

(p-api/get-market-history "BTC-LTC" 8)


(def key "<your key>")
(def secret "<your secret>")

(a-api/get-balances key secret)

(a-api/get-balance key secret "BTC")

(a-api/get-deposit-address key secret "BTC")

(a-api/withdraw key secret "BTC" 10 "<address-of-your-choice>")

(a-api/get-order key secret "<your-order-id>")

(a-api/get-order-history key secret)

(a-api/get-order-history key secret :market "BTC-LTC")

(a-api/get-order-history key secret :count 5)

(a-api/get-order-history key secret :market "BTC-LTC" :count 5)

(a-api/get-withdrawal-history key secret)

(a-api/get-withdrawal-history key secret :currency "BTC")

(a-api/get-withdrawal-history key secret :count 10)

(a-api/get-withdrawal-history key secret :currency "BTC" :count 10)

(a-api/get-deposit-history  key secret)

(a-api/get-deposit-history  key secret :currency "BTC")

(a-api/get-deposit-history  key secret :count 10)

(a-api/get-deposit-history  key secret :currency "BTC" :count 10)


(m-api/buy-limit key secret "BTC-LTC" 10 0.0000001)

(m-api/buy-market key secret "BTC-LTC" 10 0.0000001)

(m-api/sell-limit key secret "BTC-LTC" 10 100000)

(m-api/sell-market key secret "BTC-LTC" 10)

(m-api/cancel key secret "<your-order-id>")

(m-api/get-open-orders key secret)

(m-api/get-open-orders key secret "BTC-LTC")

(m-api/get-order-book key secret "BTC-LTC" "buy")

(m-api/get-order-book key secret "BTC-LTC" "both" 10)
