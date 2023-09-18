(ns clojure-lab-1.core)

(defn combine_letters [x y]
  (if (empty? (rest y))
    (if (= (str (last x)) (str (first (first y))))
      nil
      (cons (str x (first y)) nil))
    (if (= (str (last x)) (str (first (first y))))
      (combine_letters x (rest y))
      (cons (str x (first y)) (combine_letters x (rest y))))))

(defn concat_lists_of_combinations [x y]
  (concat (combine_letters (first x) y) (if (empty? (rest x))
                                          nil
                                          (concat_lists_of_combinations (rest x) y))))
(defn iterate_n_combinations [x y n]
  (concat (if (= n 1)
            x
            (concat (iterate_n_combinations (concat_lists_of_combinations x y) y (dec n)))) nil))

(defn alphabet_combinations [x n]
  (iterate_n_combinations x x n))

(println (alphabet_combinations (list "a" "b" "c") 10))
