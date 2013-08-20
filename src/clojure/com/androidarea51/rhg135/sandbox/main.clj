(ns com.androidarea51.rhg135.sandbox.main
  (:use [neko.activity :only [defactivity set-content-view!]]
        [neko.threading :only [on-ui]]
        [neko.application :only [init-application]]
        [neko.ui :only [make-ui]])
  (:gen-class
    :name com.androidarea51.rhg135.sandbox.Application
    :extends android.app.Application
    :exposes-methods {onCreate superOnCreate}))

(defn -onCreate [this]
  (.superOnCreate this)
  (init-application this))

(defactivity com.androidarea51.rhg135.sandbox.RadioControllerActivity
  :def a
  :on-create
  (fn [this bundle]
    (on-ui
      (set-content-view! a
                         (make-ui [:linear-layout {}
                                   [:text-view {:text "Hello from Clojure!"}]])))))
