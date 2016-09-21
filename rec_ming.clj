(require '[clojure.string :as str])
(def P (read-line))
(def Q (read-line))

(println (str/join "" (map str P Q)))
