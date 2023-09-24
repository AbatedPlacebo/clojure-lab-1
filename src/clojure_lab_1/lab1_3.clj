(ns clojure-lab-1.lab1-3)

(def my-filter
  (fn [func lst]
    (loop [fun func
           x lst
           acc nil]
      (if (empty? x)
        (reverse acc)
        (recur fun (rest x) (if (func (first x))
                              (conj acc (first x))
                              acc))))))
(def my-map
  (fn [func lst]
    (loop [fun func
           x lst
           acc nil]
      (if (empty? x)
        (reverse acc)
        (recur fun (rest x) (conj acc (func (first x))))))))

(defn my-map-reduce [func lst]
  (reverse (reduce (fn [new-lst elem]
                     (conj new-lst (func elem))) '() lst)))

(defn my-filter-reduce [func lst]
  (reverse (reduce (fn [new-lst elem]
                     (if (func elem)
                       (conj new-lst elem)
                       new-lst)) '() lst)))

(my-map dec '(1 2 3 4))
(my-map-reduce inc '(1 2 3 4))
(my-filter odd? '(1 2 3 4))
(my-filter-reduce even? '(1 2 3 4))
