(ns lx-sentai.data
  (:require [clojure.core.match :refer [match]]
            [clojure.string :refer [split]]))

(def ^:private sentai
  {1
    {:name "Himitsu Sentai Gorenger"
     :colors ["Red" "Blue" "Yellow" "Pink" "Green"]
     :image "https://s3-us-west-1.amazonaws.com/sentai/01-gorenger.jpg"}
   2
    {:name "J.A.K.Q. Dengekitai"
     :colors ["White" "Red" "Blue" "Pink" "Green"]
     :image "https://s3-us-west-1.amazonaws.com/sentai/02-JAKQ.jpg"}
   3
    {:name "Battle Fever J"
     :colors ["Red" "Blue" "Black" "Orange" "Whack White"]
     :image "https://s3-us-west-1.amazonaws.com/sentai/03-Battle_Fever_J.jpg"}
   4
    {:name "Denshi Sentai Denziman"
     :colors ["Red" "Blue" "Yellow" "Pink" "Green"]
     :image "https://s3-us-west-1.amazonaws.com/sentai/04-denshi_sentai_denizman.jpg"}
   5
    {:name "Taiyo Sentai Sun Vulcan"
     :colors ["Red" "Blue" "Yellow" "Pink" "Green"]
     :image "https://s3-us-west-1.amazonaws.com/sentai/05-sun_vulcan.jpg"}
   6
    {:name "Dai Sentai Goggle V"
     :colors ["Red" "Blue" "Yellow" "Pink" "Black"]
     :image "https://s3-us-west-1.amazonaws.com/sentai/06-goggle.jpg"}
   7
    {:name "Kagaku Sentai Dynaman"
     :colors ["Red" "Blue" "Yellow" "Pink" "Black"]
     :image "https://s3-us-west-1.amazonaws.com/sentai/07-Dynaman.jpg"}
   8
    {:name "Choudenshi Bioman"
     :colors ["Red" "Blue" "Yellow" "Pink" "Green"]
     :image "https://s3-us-west-1.amazonaws.com/sentai/08-Bioman.gif"}
   9
    {:name "Dengeki Sentai Changeman"
     :colors ["Red" "Blue" "Yellow" "Pink" "Black"]
     :image "https://s3-us-west-1.amazonaws.com/sentai/09-changemang.gif"}
   10
    {:name "Choushinsei Flashman"
     :colors ["Red" "Blue" "Yellow" "Pink" "Green"]
     :image "https://s3-us-west-1.amazonaws.com/sentai/10-Flashman.jpg"}
   11
    {:name "Hikari Sentai Maskman"
     :colors ["Red" "Blue" "Yellow" "Pink" "Black" "Green"]
     :image "https://s3-us-west-1.amazonaws.com/sentai/11-Maskmen.png"}
   12
    {:name "Choujuu Sentai Liveman"
     :colors ["Red" "Blue" "Yellow" "Green" "Black"]
     :image "https://s3-us-west-1.amazonaws.com/sentai/12-Liveman.jpg"}
   13
    {:name "Kousoku Sentai Turboranger"
     :colors ["Red" "Blue" "Yellow" "Pink" "Black"]
     :image "https://s3-us-west-1.amazonaws.com/sentai/13-turbo_ranger.jpg"}
   14
    {:name "Chikyuu Sentai Fiveman"
     :colors ["Red" "Blue" "Yellow" "Pink" "Black"]
     :image "https://s3-us-west-1.amazonaws.com/sentai/14-Fiveman.gif"}
   15
    {:name "Choujin Sentai Jetman"
     :colors ["Red" "Blue" "Yellow" "Pink" "Black"]
     :image "https://s3-us-west-1.amazonaws.com/sentai/15-BirdmanTaskforceJetman.jpg"}
   16
    {:name "Kyōryū Sentai Zyuranger"
     :colors ["Red" "Blue" "Yellow" "Pink" "Black" "Green"]
     :image "https://s3-us-west-1.amazonaws.com/sentai/16-Sentai_Zyuranger.jpg"}
   17
    {:name "Gosei Sentai Dairanger"
     :colors ["Red" "Blue" "Yellow" "Pink" "Green" "White"]
     :image "https://s3-us-west-1.amazonaws.com/sentai/17-Gosei_Sentai_Dairanger.jpg"}
   18
    {:name "Ninja Sentai Kakuranger"
     :colors ["Red" "Blue" "Yellow" "White" "Black"]
     :image "https://s3-us-west-1.amazonaws.com/sentai/18-Sentai_Kakurangers.jpg"}
   19
    {:name "Chouriki Sentai Ohranger"
     :colors ["Red" "Blue" "Yellow" "Pink" "Green" "Black"]
     :image "https://s3-us-west-1.amazonaws.com/sentai/19-Ohranger_With_Kingranger.jpg"}
   20
    {:name "Gekisou Sentai Carranger"
     :colors ["Red" "Blue" "Yellow" "Pink" "Green" "White?"]
     :image "https://s3-us-west-1.amazonaws.com/sentai/20-Carrangers-white_racer.jpg"}
   21
    {:name "Denji Sentai Megaranger"
     :colors ["Red" "Blue" "Yellow" "Pink" "Black" "White"]
     :image "https://s3-us-west-1.amazonaws.com/sentai/21-IS_Rangers.jpg"}
   22
    {:name "Seijuu Sentai Gingaman"
     :colors ["Red" "Blue" "Yellow" "Pink" "Green" "Caped Black"]
     :image "https://s3-us-west-1.amazonaws.com/sentai/22-StarBeast_Squadron_Star_Men!.jpg"}
   23
    {:name "Kyukyu Sentai GoGo-V"
     :colors ["Red" "Blue" "Yellow" "Pink" "Green" "Black Gold"]
     :image "https://s3-us-west-1.amazonaws.com/sentai/23-GoGo-V_with_Sieg.jpg"}
   24
    {:name "Mirai Sentai Timeranger"
     :colors ["Red" "Blue" "Yellow" "Pink" "Black" "The Other Red"]
     :image "https://s3-us-west-1.amazonaws.com/sentai/24-Time.jpg"}
   25
    {:name "Hyakujuu Sentai Gaoranger"
     :colors ["Red" "Blue" "Yellow" "Pink" "Black" "Platinum"]
     :image "https://s3-us-west-1.amazonaws.com/sentai/25-Gaorangers.jpg"}
   26
    {:name "Ninpu Sentai Hurricaneger"
     :colors ["Red" "Green" "Yellow" "Blue" "Navy Blue" "Crimson"]
     :image "https://s3-us-west-1.amazonaws.com/sentai/26-Hurricaneger.jpg"}
   27
    {:name "Bakuryuu Sentai Abaranger"
     :colors ["Red" "Blue" "Yellow"]
     :image "https://s3-us-west-1.amazonaws.com/sentai/27-Abaranger.jpg"}
   28
    {:name "Tokusou Sentai Dekaranger"
     :colors ["Red" "Blue" "Yellow" "Pink" "Green" "White"]
     :image "https://s3-us-west-1.amazonaws.com/sentai/28-Dekarangers.jpg"}
   29
    {:name "Mahou Sentai Magiranger"
     :colors ["Red" "Blue" "Yellow" "Pink" "Green" "Black Gold" "Metallic Red" "White"]
     :image "https://s3-us-west-1.amazonaws.com/sentai/29-Magirangers.jpg"}
   30
    {:name "GoGo Sentai Boukenger"
     :colors ["Red" "Blue" "Yellow" "Pink" "Black" "Gold" "White"]
     :image "https://s3-us-west-1.amazonaws.com/sentai/30-Boukengers-Zubaan.jpg"}
   31
    {:name "Juken Sentai Gekiranger"
     :colors ["Red" "Blue" "Yellow" "White" "Purple"]
     :image "https://s3-us-west-1.amazonaws.com/sentai/31-Gekiranger.jpg"}
   32
    {:name "Engine Sentai Go-Onger"
     :colors ["Red" "Blue" "Yellow" "Green" "Black"]
     :image "https://s3-us-west-1.amazonaws.com/sentai/32-Go-onger.jpg"}
   33
    {:name "Samurai Sentai Shinkenger"
     :colors ["Red" "Blue" "Yellow" "Pink" "Green"]
     :image "https://s3-us-west-1.amazonaws.com/sentai/33-Shinkeger.jpg"}
   34
    {:name "Tensou Sentai Goseiger"
     :colors ["Red" "Blue" "Yellow" "Pink" "Black"]
     :image "https://s3-us-west-1.amazonaws.com/sentai/34-Goseiger.jpg"}
   35
    {:name "Kaizoku Sentai Gokaiger"
     :colors ["Red" "Blue" "Yellow" "Pink" "Green"]
     :image "https://s3-us-west-1.amazonaws.com/sentai/35-Gokaiger.jpg"}
   36
    {:name "Tokumei Sentai Go-Busters"
     :colors ["Red" "Blue" "Yellow" "Cyan" "Gold" "Creeper Red"]
     :image "https://s3-us-west-1.amazonaws.com/sentai/36-Gobusters.png"}
   37
    {:name "Zyuden Sentai Kyoryuger"
     :colors ["Navy Blue" "Purple" "Cyan" "Blue" "Grey" "Silver"]
     :image "https://s3-us-west-1.amazonaws.com/sentai/37-Kyorangers.png"}
   38
    {:name "Ressha Sentai ToQger"
     :colors ["Red" "Blue" "Yellow" "Pink" "Green" "Purple" "Orange"]
     :image "https://s3-us-west-1.amazonaws.com/sentai/38-toqger.jpg"}
   39
    {:name "Shuriken Sentai Ninninger"
     :colors ["Red" "Blue" "Yellow" "Pink" "White" "Gold"]
     :image "https://s3-us-west-1.amazonaws.com/sentai/39-Ninneger.jpg"}
   40
    {:name "Doubutsu Sentai Zyuohger"
     :colors ["Red" "Blue" "Yellow" "White" "Black"]
     :image "https://s3-us-west-1.amazonaws.com/sentai/40-Zyuohger.jpg"}
   })

(defn get-random-sentai
  []
  (sentai (+ (rand-int (count sentai)) 1)))

(defn get-squad
  [text]
  (match text
    ""              ["Tony" "Tyrone" "Denise" "Kyla"]
    "@views"        ["Tony" "Tyrone" "Denise" "Kyla"]
    "@integrations" ["Alice" "KStar" "Oron"]
    "@security"     ["Damir" "Karen" "Josh"]
    "@inbox"        ["Mike" "Taylor" "Elliot"]
    "@war"          ["Sahil" "Stephen" "James" "Andrew" "Xie"]
    "@mobile"       ["Matt" "Brian"]
    "@scripting"    ["Björn" "Wyatt"]
    "@design"       ["Kay" "Abi" "Alex"]
    :else  (split text #" ")))
