
(def n (read-line))

(defn myFactorialFunction [x]
  (reduce * (range 1 (+ x 1))))

(defn exponsiate [x n]
  (reduce * (repeat n x)))

(def doMath (fn [x]
              (loop [iterator 9 x x result 1]
                (if (zero? iterator)
                  result 
                  (recur (dec iterator) x (+ result (float (/ (exponsiate x iterator) (myFactorialFunction iterator)))))))))

(loop [iterator (Integer/parseInt n)]
  (def x (Float/parseFloat (read-line)))
  (println (format "%.4f" (doMath x)))
  (if (not (zero? (- iterator 1)))
    (recur (dec iterator))))
