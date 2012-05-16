(ns com.columbusclojure.bankocr.check-sum-validator)

(defn isValid [^String account]
  (let [ints (map #(Character/digit % 10) (seq account))
        sum (reduce + (map-indexed * (cons 0 (reverse ints))))]
    (= (mod sum 11) 0)))