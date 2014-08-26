(ns brecha.public
  (:use [brecha.tools]))


(let [public-api "https://bittrex.com/api/v1.1/public/"]

  (defn get-markets []
    (query (str public-api "getmarkets")))

  (defn get-currencies []
    (query (str public-api "getcurrencies")))

  (defn get-ticker [market]
    (query (str public-api "getticker" (query-string [:market market]))))

  (defn get-market-summaries []
    (query (str public-api "getmarketsummaries")))

  (defn get-market-summary [market]
    (query (str public-api "getmarketsummary"
                (query-string [:market market]))))

  (defn get-orderbook [market type & [depth]]
    (let [url (str public-api "getorderbook"
                   (query-string
                    (concat [:market market :type type]
                            (when depth [:depth depth]))))]
      (query url)))

  (defn get-market-history [market & [count]]
    (let [url (str public-api "getmarkethistory"
                   (query-string
                    (concat [:market market]
                            (when count [:count count]))))]
      (query url))))




