
(fn ar [num lst]
    (if (not(= (count lst) 0))
      (do
        ((fn anony [elem n]
             (if  (>= n 1)
            (do (println elem)
            (anony elem (dec n))))) (first lst) num)
        (ar num (drop 1 lst)))))
