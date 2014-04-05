(ns pollex.core-test
  (:require-macros [cemerick.cljs.test :refer (is deftest testing)])
  (:require [cemerick.cljs.test :as t]
            [pollex.core]))

(deftest first-test
  (testing "when the collection is empty"
    (is (= (first (Backbone.Collection.))
           js/undefined)))
  (testing "when the collection isn't empty"
    (let [object (Backbone.Model.)]
      (is (= (.-cid (first (Backbone.Collection. #js [object])))
             (.-cid object))))))

(deftest map-test
  (let [objects (take 4 (map #(Backbone.Model.) (range)))]
    (is (= (map #(.-cid %) (Backbone.Collection. (apply array objects)))
           (map #(.-cid %) objects)))))

(deftest filter-test
  (let [objects (take 4 (map #(Backbone.Model.) (range)))]
    (is (= (filter #(= "c2" (.-cid %)) (Backbone.Collection. (apply array objects)))
           (filter #(= "c2" (.-cid %)) objects)))))
