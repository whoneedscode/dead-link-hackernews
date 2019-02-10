(defproject john_implementation "0.1.0"
  :description "John's first implementation of the link parser"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [ [org.clojure/clojure "1.9.0"]
                  [http-kit "2.3.0"]
                  [cheshire "5.8.1"]
                ]
  :main ^:skip-aot john-implementation.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
