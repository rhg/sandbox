(ns sandbox.main
  (:use [neko.activity :only [defactivity set-content-view!]]
        [neko.threading :only [on-ui]]
        [neko.application :only [init-application]]
        [neko.ui.menu :only [make-menu]]
        [neko.ui :only [make-ui]])
  (:import android.net.Uri
           android.content.Intent))

(defn get-uri [^android.content.Context a] (Uri/parse "file:///android_asset/GoneCrazy.mp3"))

(defactivity com.rhg.sandbox
  :def a
  :on-create-options-menu
  (fn [^android.app.Activity this menu]
    (on-ui
      (make-menu menu [[:item {:title "Play" :on-click
                               (fn [_]
                                 (let [intent (Intent. Intent/ACTION_VIEW)]
                                   (.setDataAndType intent (get-uri this) "audio/mp3")
                                   (.startService this intent)))
                                     :show-as-action :always :icon android.R$drawable/ic_media_play}]
                       [:item {:title "Stop" :show-as-action :always :icon android.R$drawable/ic_menu_close_clear_cancel}]])))
  :on-create
  (fn [this bundle]
    (on-ui
      (set-content-view! a
                         (make-ui [:linear-layout {}
                                   [:text-view {:text "Hello from the future Club Sandbox."}]])))))
