(ns pollex.core)

(extend-type Backbone.Collection
  ISeq
  (-first [this] (.first this))
  (-next [this] (rest (.-models this)))
  ISeqable
  (-seq [this] (.-models this)))
