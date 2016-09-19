
(defn fibo [n]
  (if (< n 3)
    (- n 1)
    (+ (fibo (- n 1)) (fibo (- n 2)))))

(println (fibo (Integer/parseInt (read-line))))
