(defproject pollex "0.1.0-SNAPSHOT"
  :description "Clojure Wrapper for Backbone"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :plugins [[lein-cljsbuild "1.0.3"]
            [com.cemerick/clojurescript.test "0.3.0"]]
  :dependencies [[org.clojure/clojurescript "0.0-2197"]]
  :cljsbuild {:builds [{:source-paths ["src" "test"]
                        :compiler {:output-to "target/cljs/testable.js"
                                   :externs ["resource/externs/"]
                                   :libs [""]
                                   :optimizations :whitespace
                                   :pretty-print true}}]
              :test-commands {"unit-tests" ["phantomjs" :runner
                                            "resources/underscore.js"
                                            "resources/backbone.js"
                                            "target/cljs/testable.js"]}})
