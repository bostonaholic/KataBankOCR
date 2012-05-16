(ns com.columbusclojure.bankocr.test.check-sum-validator
  (:use clojure.test)
  (:require [com.columbusclojure.bankocr.check-sum-validator :as CheckSumValidator]))

(deftest check-sum-is-valid
  (is (CheckSumValidator/isValid "345882865"))
  (is (CheckSumValidator/isValid "000000051"))
  (is (CheckSumValidator/isValid "123456789"))
  (is (CheckSumValidator/isValid "000000000")))

(deftest check-sum-is-not-valid
  (is (not (CheckSumValidator/isValid "123456389")))
  (is (not (CheckSumValidator/isValid "722466035"))))