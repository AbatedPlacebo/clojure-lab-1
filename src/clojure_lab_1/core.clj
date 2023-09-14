(ns clojure-lab-1.core)

(defn main [x y n]
  (cons (str (first x) (first y)) (if (empty? (rest x))
                                    nil
                                    (do (main (rest x) y n)))))

; '(1 2 3) '(3 4 5) -> '(1 2 3 3 4 5))
(defn combine [x n]
  (main x x n))

(println (combine (list "a" "b" "c" "d") 2))
