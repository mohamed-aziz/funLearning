
(def solver
  (fn [x]
    (loop [x x c "" i 0]
      (if (= (count x) i)
        c
        (do
          (def perm (str (.substring x 1) (.substring x 0 1)))
          (recur perm (str c " " perm) (inc i)))))))

(loop [n (Integer/parseInt (read-line))]
  (when (> n 0)
    (println (solver (read-line)))
    (recur (dec n))))
