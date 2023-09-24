(ns clojure-lab-1.lab1-4)

(defn combs [lst n]
  (map (fn [x]
         (conj (first lst) x)) lst))


(combs '(1 2 3 4) 3)
