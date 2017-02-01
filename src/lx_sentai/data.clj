(ns lx-sentai.data
  (:require [clojure.string :refer [split]]))

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
     :colors ["Red" "Blue" "Yellow"]
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
     :image "https://s3-us-west-1.amazonaws.com/sentai/08-Bioman.jpg"}
   9
    {:name "Dengeki Sentai Changeman"
     :colors ["Red" "Blue" "White" "Pink" "Black"]
     :image "https://s3-us-west-1.amazonaws.com/sentai/09-changemang.gif"}
   10
    {:name "Choushinsei Flashman"
     :colors ["Red" "Blue" "Yellow" "Pink" "Green"]
     :image "https://s3-us-west-1.amazonaws.com/sentai/10-Flashman.jpg"}
   11
    {:name "Hikari Sentai Maskman"
     :colors ["Red" "Blue" "Yellow" "Pink" "Black" "Green"]
     :image "https://s3-us-west-1.amazonaws.com/sentai/11-Maskmen.jpg"}
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
     :image "https://s3-us-west-1.amazonaws.com/sentai/14-Fiveman.jpg"}
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
     :colors ["Red" "Blue" "Yellow" "Pink" "Green"]
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
     :colors ["Red" "Blue" "Yellow" "Pink" "Green" "Black Gold"]
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
     :colors ["Red" "Blue" "Yellow" "Pink" "Black" "Cyborg"]
     :image "https://s3-us-west-1.amazonaws.com/sentai/34-Goseiger.jpg"}
   35
    {:name "Kaizoku Sentai Gokaiger"
     :colors ["Red" "Blue" "Yellow" "Pink" "Green"]
     :image "https://s3-us-west-1.amazonaws.com/sentai/35-Gokaiger.jpg"}
   36
    {:name "Tokumei Sentai Go-Busters"
     :colors ["Red" "Blue" "Yellow" "Cyan" "Gold"]
     :image "https://s3-us-west-1.amazonaws.com/sentai/36-Gobusters.jpg"}
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
     :colors ["Red" "Blue" "Yellow" "Pink" "White"]
     :image "https://s3-us-west-1.amazonaws.com/sentai/39-Ninneger.jpg"}
   40
    {:name "Doubutsu Sentai Zyuohger"
     :colors ["Red" "Blue" "Yellow" "White" "Black"]
     :image "https://s3-us-west-1.amazonaws.com/sentai/40-Zyuohger.jpg"}
   41
    {:name "Sailor Senshi"
     :colors ["Moon" "Mercury" "Mars" "Jupiter" "Venus"]
     :image "https://s3-us-west-1.amazonaws.com/sentai/41-sailor-senshi.png"}
   42
    {:name "Ginyu Toku Sentai"
     :colors ["Captain Ginyu" "Jeice" "Recoome" "Burter" "Guido"]
     :image "https://s3-us-west-1.amazonaws.com/sentai/42-ginyu-toku-sentai.png"}
   43
    {:name "Saint Seiya Omega"
     :colors ["Souma" "Haruto" "Eden" "Ryuhou" "Yuna" "Koga"]
     :image "https://s3-us-west-1.amazonaws.com/sentai/43-saint-seiya-omega.jpg"}
   44
    {:name "Robots"
     :colors ["Pink" "Black" "Regal White" "Red" "Yellow" "Blue"]
     :image "https://s3-us-west-1.amazonaws.com/sentai/44-robots.jpg"}
   45
    {:name "Squishies"
     :colors ["Tinky Winky" "Dipsy" "Laa Laa" "Po"]
     :image "https://s3-us-west-1.amazonaws.com/sentai/45-squishies.jpeg"}
   46
    {:name "Red Power"
     :colors ["Go ONNNN!" "I Look Like a Monster Truck" "Hey Ya!" "Stoic Ranger" "Water Gun Ranger" "Monster Hand POW!" "Waldo"]
     :image "https://s3-us-west-1.amazonaws.com/sentai/46-red-power.jpeg"}
   47
    {:name "Best Friends Yearbook Shot"
     :colors ["Red" "Blue" "Pink" "Yellow" "Black" "Grey Plaid"]
     :image "https://s3-us-west-1.amazonaws.com/sentai/47-best-friends.jpg"}
   48
    {:name "Hanging Out Friends"
     :colors ["In-Love-with-Pink Blue" "Bored Black" "Creepy Yellow" "Smirky Pink" "Constipated Red"]
     :image "https://s3-us-west-1.amazonaws.com/sentai/48-best-friends-2.jpeg"}
   49
    {:name "Hanging Out at the Gym"
     :colors ["Blue" "Pink" "Black" "Yellow" "Chilled-Out Red"]
     :image "https://s3-us-west-1.amazonaws.com/sentai/49-best-friends-3.jpg"}
   50
    {:name "Party Time"
     :colors ["Red" "Yellow" "Blue" "Green" "Orange-Yellow"]
     :image "https://s3-us-west-1.amazonaws.com/sentai/50-party-colors.jpeg"}   
   })

(defn get-random-sentai
  []
  (sentai (+ (rand-int (count sentai)) 1)))

(defn get-squad
  [text]
  (case text
    ""                  ["Tony" "Tyrone" "Denise" "Alice"]
    "@insights"         ["Tony" "Tyrone" "Denise" "Alice" "Frank"]
    "@security"         ["Damir" "Karen" "Josh" "KStar"]
    "@spaces"           ["Mike" "Taylor" "Elliot" "Kyla"]
    "@records"          ["Sahil" "Andrew" "Bryan"]
    "@workflows"        ["Stephen" "James" "Xie" "Matt" "Sara"]
    "@scripting"        ["Björn" "Wyatt"]
    "@design"           ["Kay" "Abi" "Sharon"]
    "@customer_success" ["Natasha" "Caroline" "Chris" "Shane" "Merijn" "Maniza" "Alex" "Katy"]
    (split text #" ")))
