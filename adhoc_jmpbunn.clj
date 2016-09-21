
(defn gcd [a b]
  (if (= (* a b) 0)
    (+ a b)
    (recur b (mod a b))))

(defn lcm [a b]
  (/ (* a b) (gcd a b)))

(read-line)
(println (format "%5d" (biginteger (reduce lcm (map #(BigInteger. %) (clojure.string/split (read-line) #" "))))))

