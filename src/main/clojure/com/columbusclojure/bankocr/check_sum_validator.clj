(ns com.columbusclojure.bankocr.check-sum-validator)

(defn isValid
  "account number:   3  4  5  8  8  2  8  6  5
   position names:  d9 d8 d7 d6 d5 d4 d3 d2 d1

  checksum calculation:
  (d1+2*d2+3*d3+..+9*d9) mod 11 = 0"
  [^String account]
  (let [ints (map #(Character/digit % 10) (seq account))
        sum (reduce + (map-indexed * (cons 0 (reverse ints))))]
    (= (mod sum 11) 0)))