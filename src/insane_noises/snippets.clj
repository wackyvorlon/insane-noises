;; Snippets of useful overtone code

;; A reverb I found here:
;; https://groups.google.com/forum/#!msg/overtone/P5_ZLT10h-A/-DN8Ub5H5h4J

(defsynth fx-my-reverb
  [bus 0
   roomsize 30.0
   revtime 4.50
   damping 0.40
   inputbw 0.39
   spread 14.93
   drylevel 0.25
   earlyreflevel 0.20
   taillevel 0.10
   lpf-freq 1000.0
   maxroomsize 300.0
   gate 1.0]
  (let [source (in bus)
        my-reverb (* gate
                     (g-verb (* gate source)
                             roomsize revtime damping inputbw spread
                             drylevel earlyreflevel taillevel maxroomsize))
        lpf-reverb (lpf my-reverb lpf-freq)]
    (replace-out bus (+ lpf-reverb source))))

