(require '[clojure.string :as str])

(def theLine (map #(Integer/parseInt %) (str/split (read-line) #" ")))
(def a (first theLine))
(def b (second theLine))

(defn gcd [a b]
  (if (= (* a b) 0)
    (+ a b)
    (recur b (mod a b))))

(println (gcd a b))


