; -------------------------------------------------------

(ns forclojure-solutions.core
  (:gen-class))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))

; -------------------------------------------------------
; The 4Clojure Problems
; -------------------------------------------------------

; http://www.4clojure.com/problem/3
(defn upper
  "#3. Clojure strings are Java strings. This means that you can use any of the Java string methods on Clojure strings."
  []
  (println "HELLO WORLD"))

; -------------------------------------------------------

; http://www.4clojure.com/problem/19
(defn get-last
  "#19. Write a function which returns the last element in a sequence."
  ([array]
   (get-last (first array) (rest array)))
  ([head remaining]
   (if (= [] remaining)
     head
     (get-last (first remaining) (rest remaining)))))

; -------------------------------------------------------

; http://www.4clojure.com/problem/20
(defn get-penultimate
  "#20. Write a function which returns the second to last element from a sequence."
  [xs]
  (loop [ret (first xs) xs xs]
    (if (next xs)
      (recur (first xs) (next xs))
      ret)))

; -------------------------------------------------------

; http://www.4clojure.com/problem/21
(defn nth-element
  "#21. Write a function which returns the Nth element from a sequence."
  [xs pos]
  (if (= 0 pos)
    (first xs)
    (nth-element (next xs) (dec pos))))

; -------------------------------------------------------

; http://www.4clojure.com/problem/22
(defn my-count
  "#22. Write a function which returns the total number of elements in a sequence."
  [xs]
  (reduce (fn [c _] (inc c)) 0 xs))

; -------------------------------------------------------

; http://www.4clojure.com/problem/23
(defn my-reverse
  "#23. Write a function which reverses a sequence."
  [xs]
  (reduce (fn [res item] (conj res item)) '() xs))

; -------------------------------------------------------

; http://www.4clojure.com/problem/24
(defn add-all
  "#24. Write a function which returns the sum of a sequence of numbers."
  [xs]
  (reduce + xs))

; -------------------------------------------------------

; http://www.4clojure.com/problem/25
(defn only-odds
  "#25. Write a function which returns only the odd numbers from a sequence."
  [xs]
    (reduce (fn [res item]
               (if (= (mod item 2) 1)
                 (concat res [item])
                 res))
            []
            xs))

(defn better-only-odds
  "#25. Write a function which returns only the odd numbers from a sequence."
  [xs]
    (filter odd? xs))

; -------------------------------------------------------

; http://www.4clojure.com/problem/26
(defn fib
  "#26. Write a function which returns the first X fibonacci numbers."
  [loops]
  (take loops (map last(iterate (fn [[x y]] [y (+ x y)]) [ 0 1]))))

; -------------------------------------------------------

; http://www.4clojure.com/problem/27
(defn palindrome
  "#27. Write a function which returns true if the given sequence is a palindrome."
  [xs]
  (= (vec (reverse xs)) (seq xs)))

; -------------------------------------------------------

; http://www.4clojure.com/problem/28
(defn my-flatten
  "#28. Write a function which flattens a sequence."
  [xs]
  (filter (complement sequential?) (rest (tree-seq sequential? seq xs))))

; -------------------------------------------------------

; http://www.4clojure.com/problem/29
(defn caps
  "#29. Write a function which takes a string and returns a new string containing only the capital letters."
  [xs]
  (apply str (filter #(Character/isUpperCase %) xs)))

; -------------------------------------------------------
