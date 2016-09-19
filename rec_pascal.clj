(require '[clojure.string :as str])

(def n (Integer/parseInt (read-line)))

(defn f [x]
  (reduce * (range 1 (+ x 1))))

(defn Ce [[n, k]]
  (/(f n) (* (f k) (f (- n k)))))

(def drawPascalLine
  (fn [i]
    (map Ce (map vector (repeat i (- i 1)) (range i)))))

(loop [i 1]
  (if (<= i n)
    (do 
      (println (str/join " " (drawPascalLine i)))
      (recur (inc i)))))
