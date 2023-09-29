(ns clojure-lab-1.lab1-2)

(def my-concat 
  (fn [lst1 lst2] 
    (loop [x (reverse lst1)
           acc lst2]
      (if (empty? x)
        acc
        (recur (rest x) (cons (first x) acc)))
      )
    )
  )

(def combinations_for_x
  (fn [lst1 lst2]
    (loop [x lst1
           y lst2
           acc nil]
      (if (empty? (first y))
        (reverse acc)
        (recur x (rest y) (if (= (str (last (first x))) (str (first (first y))))
                            acc
                            (conj acc (str (first x) (first y)))))))))

(def concat_all_x_combs
  (fn [lst1 lst2]
    (loop [x lst1
           y lst2
           acc nil]
      (if (empty? (first x))
        acc
        (recur (rest x) y (my-concat acc (combinations_for_x x y)))))))

(def alphabet_combinations
  (fn [lst n]
    (loop [x lst
           y lst
           cnt n
           acc x]
      (if (= 1 cnt)
        acc
        (recur acc y (dec cnt) (concat_all_x_combs acc y))))))


(alphabet_combinations (list "a" "b" "c" "d") 3)
(alphabet_combinations (list "a" "b" "c" ) 5)
(alphabet_combinations (list "a" "b" "c" "d") 6)
(alphabet_combinations (list "a" "b" "c") 15)
