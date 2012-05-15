(ns com.columbusclojure.bankocr.test.check-sum-validator
  (:use clojure.test)
  (:import [com.columbusclojure.bankocr CheckSumValidator]))

(deftest check-sum-is-valid
  (is (CheckSumValidator/isValid "345882865"))
  (is (CheckSumValidator/isValid "000000051"))
  (is (CheckSumValidator/isValid "123456789"))
  (is (CheckSumValidator/isValid "000000000")))

(deftest check-sum-is-not-valid
  (is (not (CheckSumValidator/isValid "123456389")))
  (is (not (CheckSumValidator/isValid "722466035"))))