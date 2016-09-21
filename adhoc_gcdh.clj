(read-line)
(def a (read-line))
(read-line)
(def b (read-line))

(defn funfun [x]
  (reduce * (map #(BigInteger. %) (clojure.string/split x #" "))))


(defn gcd [a b]
  (if (= (* a b) 0)
    (+ a b)
    (recur b (mod a b))))

(println (format "%d" (biginteger (mod (gcd (funfun a) (funfun b)) 1000000007))))
