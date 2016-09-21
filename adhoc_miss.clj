(read-line)

(defn funfun [x]
  (vec (clojure.string/split x #" ")))

(def a (read-line))
(read-line)
(def b (read-line))

(defn diff [s1 s2]
  (mapcat
    (fn [[x n]] (repeat n x))
    (apply merge-with - (map frequencies [s1 s2]))))

(println (clojure.string/join " " (distinct (sort (diff (sort (funfun a)) (sort (funfun b)))))))
