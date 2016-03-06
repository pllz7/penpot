;; This Source Code Form is subject to the terms of the Mozilla Public
;; License, v. 2.0. If a copy of the MPL was not distributed with this
;; file, You can obtain one at http://mozilla.org/MPL/2.0/.
;;
;; Copyright (c) 2015-2016 Andrey Antukh <niwi@niwi.nz>
;; Copyright (c) 2015-2016 Juan de la Cruz <delacruzgarciajuan@gmail.com>

(ns uxbox.ui.settings
  (:require [sablono.core :as html :refer-macros [html]]
            [rum.core :as rum]
            [cuerdas.core :as str]
            [uxbox.router :as r]
            [uxbox.rstore :as rs]
            [uxbox.ui.icons :as i]
            [uxbox.ui.mixins :as mx]
            [uxbox.util.dom :as dom]
            [uxbox.data.dashboard :as dd]
            [uxbox.ui.dashboard.header :refer (header)]))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Page: Profile
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defn profile-page-render
  [own]
  (html
   [:main.dashboard-main
    (header)
    [:section.dashboard-content.user-settings
     [:div.user-settings-nav
      [:ul.user-settings-nav-inside
       [:li.current {:on-click #(r/go :settings/profile)} "Profile"]
       [:li {:on-click #(r/go :settings/password)} "Password"]
       [:li {:on-click #(r/go :settings/notifications)} "Notifications"]]]

     [:section.user-settings-content
      [:span.user-settings-label "Your avatar"]
      [:form.avatar-form
       [:img {:src "images/favicon.png" :border "0"}]
       [:input {:type "file"}]]
      [:span.user-settings-label "Name"]
      [:input.input-text {:type "text" :placeholder "Your name"}]
      [:span.user-settings-label "Username"]
      [:input.input-text {:type "text" :placeholder "Your username"}]
      [:span.user-settings-label "Email"]
      [:input.input-text {:type "email" :placeholder "Your email"}]
      [:span.user-settings-label "Choose a color theme"]
      [:span "TODO RADIO BUTTONS"]
      [:input.btn-primary {:type "submit" :value "Update settings"}]
     ]]]))

(def ^:static profile-page
  (mx/component
   {:render profile-page-render
    :name "profile-page"
    :mixins [mx/static]}))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Page: password
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defn password-page-render
  [own]
  (html
   [:main.dashboard-main
    (header)
    [:section.dashboard-content.user-settings
     [:div.user-settings-nav
      [:ul.user-settings-nav-inside
       [:li {:on-click #(r/go :settings/profile)} "Profile"]
       [:li.current {:on-click #(r/go :settings/password)} "Password"]
       [:li {:on-click #(r/go :settings/notifications)} "Notifications"]]]

     [:section.user-settings-content
      [:span.user-settings-label "Change password"]
      [:input.input-text {:type "password" :placeholder "Old password"}]
      [:input.input-text {:type "password" :placeholder "New password"}]
      [:input.input-text {:type "password" :placeholder "Confirm password"}]
      [:input.btn-primary {:type "submit" :value "Update settings"}]
     ]]]))

(def ^:static password-page
  (mx/component
   {:render password-page-render
    :name "password-page"
    :mixins [mx/static]}))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Page: notifications
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defn notifications-page-render
  [own]
  (html
   [:main.dashboard-main
    (header)
    [:section.dashboard-content
     [:ul
      [:li {:on-click #(r/go :settings/profile)} "Profile"]
      [:li {:on-click #(r/go :settings/password)} "Password"]
      [:li {:on-click #(r/go :settings/notifications)} "Notifications"]]
     [:section.dashboard-grid.library
      [:span "TODO 3"]]]]))

(def ^:static notifications-page
  (mx/component
   {:render notifications-page-render
    :name "notifications-page"
    :mixins [mx/static]}))
