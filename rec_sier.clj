;;;; my solution to sierpinski triangle.
;;;; This may not be in the clojure way because I'm a new clojurer

(require '[clojure.string :as str])

(defstruct point :x :y)

(defn change-from-to "Changes vector value from start to end" [start end thevector withchar]
  (if (> start end)
    thevector
    (change-from-to (+ 1 start) end (assoc thevector start withchar) withchar)))

(def initTriangle "Inits a triangle"
  (fn [my2dvector]
    (loop [vect my2dvector column 31 nb 1]
      (if (< column 0)
        vect
        (recur (assoc vect (/ (- nb 1) 2) (change-from-to column (+ column (- nb 1)) (nth vect (/ (- nb 1) 2)) "1")) (- column 1) (+ 2 nb))))))

(def empty-area "Emptys a equileteral triangle"
  (fn [thevector left right down]
    (loop [vect thevector leftcolumn (get left :x) rightcolumn (get right :x) row (get left :y)]
      (if (> row (get down :y))
        vect
        (recur (assoc vect row (change-from-to leftcolumn rightcolumn (nth vect row) "_")) (inc leftcolumn) (dec rightcolumn) (inc row))))))

(def merge "merges three fractals?"
  (fn [v1 v2 v2]))

(defn sierpinski [myvect upper right left n]
  (if (= n 0)
    myvect
    (do
      (map println (map (fn [x] (str/join "" x)) myvect))
      (def emptyedVector (empty-area myvect (/ (+ (get upper :y) (get left :y)) 2)))
      (sierpinski emptyedVector upper (struct point (- 31 (get right :x)) (Math/floor (/ (get right :y) 2)))
                  (struct point (- 62 (- 31 (get right :x))) (Math/floor (/ (get right :y) 2))) (dec n)))))

(def myMatrix (into [] (repeat 32 (into [] (repeat 63 "_")))))

(map println (map (fn [x] (str/join "" x)) (sierpinski (initTriangle myMatrix) (struct point 30 0) (struct point 62 31) (struct point 0 31) 2)))
