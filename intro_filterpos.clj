(fn [lst]
     (map second (filter #(even? (first %)) (map vector (iterate inc 1) lst))))
