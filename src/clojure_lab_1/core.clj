(ns clojure-lab-1.core)

(defn testfn [x y]
  (if (empty? (rest y))
    (if (= x (first y))
      nil
      (cons (str x (first y)) nil))
    (if (= x (first y))
      (testfn x (rest y))
      (cons (str x (first y)) (testfn x (rest y))))))


; '(1 2 3) '(3 4 5) -> '(1 2 3 3 4 5))

(defn func1 [x y]
  (concat (testfn (first x) y) (if (empty? (rest x))
                                 nil
                                 (func1 (rest x) y))))
(defn func [x]
  (func1 x x))

(println (func (list "a" "b" "c" "d")))
