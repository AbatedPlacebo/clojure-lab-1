(ns clojure-lab-1.core)

(defn testfn [x y]
  (if (empty? (rest y))
    (if (= x (first y))
      nil
      (cons (str x (first y)) nil))
    (if (= x (first y))
      (testfn x (rest y))
      (cons (str x (first y)) (testfn x (rest y))))))

(defn main [x y n]
  (cons (do (if (empty? (rest x))
              nil
              (main (rest x) y n))
            (if (= (first x) (first y))
              nil
              (str (first x) (first y))))
        (if (empty? (rest y))
          nil
          (do (main x (rest y) n)))))

; '(1 2 3) '(3 4 5) -> '(1 2 3 3 4 5))
(defn combine [x n]
  (main x x n))

(defn func1 [x y]
  (concat (testfn (first x) y) (if (empty? (rest x))
                                 nil
                                 (func1 (rest x) y))))

(defn func [x]
  (func1 x x))
;;(println (combine (list "a" "b" "c" "d")))
(println (func (list "a" "b" "c" "d")))
