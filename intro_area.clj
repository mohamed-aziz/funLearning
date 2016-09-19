(require '[clojure.string :as str])

(def as (map #(Integer/parseInt %) (str/split (read-line) #" ")))
(def ab (map #(Integer/parseInt %) (str/split (read-line) #" ")))
(def lr (map #(Integer/parseInt %) (str/split (read-line) #" ")))
(def l (first lr))
(def r (second lr))
(def dx 0.0001)

(defn exponsiate [x n]
  (reduce * (repeat n x)))

(defn f [x v]
  (reduce + (map (fn [sv]
                      (* (first sv) (exponsiate x (second sv)))) v)))

(def computeArea (fn [v left right]
       (loop [left left area 0]
         (if (> left right)
           (* area dx)
           (recur (+ left dx) (+ area (f left v)))))))

(def computeVolume (fn [v left right]
                     (loop [left left area 0]
                       (if (> left right)
                         (* area dx)
                         (recur (+ left dx) (+ area (* (exponsiate (f left v) 2) Math/PI) ))))))

(println (computeArea (map vector as ab) l r))
(println (computeVolume (map vector as ab) l r))
