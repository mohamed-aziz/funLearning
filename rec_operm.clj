(require '[clojure.string :as str])

(def solver
  (fn [x]
    (loop [x x c ""]
      (if (empty? x)
        c
        (recur (.substring x 2) (str c (str/reverse (.substring x 0 2))))))))

(loop [n (Integer/parseInt (read-line))]
  (when (> n 0)
    (println (solver (read-line)))
    (recur (dec n))))
