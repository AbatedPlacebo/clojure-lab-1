(ns clojure-lab-1.lab1-4)

(def similiar?
  (fn [x]
    (loop [lst x
           acc (rest x)
           res true]
      (if (or (= res false) (empty? lst))
        res
        (recur (rest lst) (rest acc) (if (= (first lst) (first acc))
                                       false
                                       true))))))

(defn alphabet_combinations [lst n]
  (filter similiar? (loop [lst1 lst
                           lst2 lst
                           cnt n
                           acc nil]
                      (if (zero? cnt)
                        acc
                        (recur
                         (reduce concat '() (reduce concat '() (map (fn [x]
                                                                      (map (fn [y]
                                                                             (conj nil (str x y))) lst2)) lst1)))
                         lst2 (dec cnt) lst1)))))

(alphabet_combinations '("a" "b" "c" ) 3)
