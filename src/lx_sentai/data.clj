(ns lx-sentai.data
  (:require [clojure.string :refer [split]]))

(def ^:private sentai
  {1
    {:name "Himitsu Sentai Gorenger (Secret Squadron FiveRangers)"
     :colors ["Red" "Blue" "Yellow" "Pink" "Green"]
     :image "https://s3-us-west-1.amazonaws.com/sentai/01-gorenger.jpg"}
   2
    {:name "J.A.K.Q. Dengekitai (J.A.K.Q. Blitzkrieg Squad)"
     :colors ["White" "Red" "Blue" "Pink" "Green"]
     :image "https://s3-us-west-1.amazonaws.com/sentai/02-JAKQ.jpg"}
   3
    {:name "Battle Fever J"
     :colors ["Red" "Blue" "Green Black" "Orange" "Whack White aka No Pants"]
     :image "https://s3-us-west-1.amazonaws.com/sentai/03-Battle_Fever_J.jpg"}
   4
    {:name "Denshi Sentai Denziman (Electronic Squadron Denziman)"
     :colors ["Red" "Blue" "Yellow" "Pink" "Green"]
     :image "https://s3-us-west-1.amazonaws.com/sentai/04-denshi_sentai_denizman.jpg"}
   5
    {:name "Taiyo Sentai Sun Vulcan (Solar Squadron Sun Vulcan)"
     :colors ["Red" "Blue" "Yellow"]
     :image "https://s3-us-west-1.amazonaws.com/sentai/05-sun_vulcan.jpg"}
   6
    {:name "Dai Sentai Goggle V (Great Squadron Goggle Five)"
     :colors ["Red" "Blue" "Yellow" "Pink" "Black"]
     :image "https://s3-us-west-1.amazonaws.com/sentai/06-goggle.jpg"}
   7
    {:name "Kagaku Sentai Dynaman (Scientific Squadron Dynaman)"
     :colors ["Red" "Blue" "Yellow" "Pink" "Black"]
     :image "https://s3-us-west-1.amazonaws.com/sentai/07-Dynaman.jpg"}
   8
    {:name "Choudenshi Bioman (Super Electronic Bioman)"
     :colors ["Red" "Blue" "Yellow" "Pink" "Green"]
     :image "https://s3-us-west-1.amazonaws.com/sentai/08-Bioman.jpg"}
   9
    {:name "Dengeki Sentai Changeman (Blitzkrieg Squadron Changeman)"
     :colors ["Red" "Blue" "White" "Pink" "Black"]
     :image "https://s3-us-west-1.amazonaws.com/sentai/09-changemang.gif"}
   10
    {:name "Choushinsei Flashman (Supernova Flashman)"
     :colors ["Red" "Blue" "Yellow" "Pink" "Green"]
     :image "https://s3-us-west-1.amazonaws.com/sentai/10-Flashman.jpg"}
   11
    {:name "Hikari Sentai Maskman (Light Squadron Maskman)"
     :colors ["Red" "Blue" "Yellow" "Pink" "Black" "Green"]
     :image "https://s3-us-west-1.amazonaws.com/sentai/11-Maskmen.jpg"}
   12
    {:name "Choujuu Sentai Liveman (Super Beast Squadron Liveman)"
     :colors ["Red" "Blue" "Yellow" "Green" "Black"]
     :image "https://s3-us-west-1.amazonaws.com/sentai/12-Liveman.jpg"}
   13
    {:name "Kousoku Sentai Turboranger (High Speed Squadron Turboranger)"
     :colors ["Red" "Blue" "Yellow" "Pink" "Black"]
     :image "https://s3-us-west-1.amazonaws.com/sentai/13-turbo_ranger.jpg"}
   14
    {:name "Chikyuu Sentai Fiveman (Earth Squadron Fiveman)"
     :colors ["Red" "Blue" "Yellow" "Pink" "Black"]
     :image "https://s3-us-west-1.amazonaws.com/sentai/14-Fiveman.jpg"}
   15
    {:name "Choujin Sentai Jetman (Birdman Squadron Jetman)"
     :colors ["Red" "Blue" "Yellow" "Pink" "Black"]
     :image "https://s3-us-west-1.amazonaws.com/sentai/15-BirdmanTaskforceJetman.jpg"}
   16
    {:name "Kyōryū Sentai Zyuranger (Dinosaur Squadron Zyuranger)"
     :colors ["Red" "Blue" "Yellow" "Pink" "Black" "Green"]
     :image "https://s3-us-west-1.amazonaws.com/sentai/16-Sentai_Zyuranger.jpg"}
   17
    {:name "Gosei Sentai Dairanger (Five-Star Squadron Dairanger)"
     :colors ["Red" "Blue" "Yellow" "Pink" "Green"]
     :image "https://s3-us-west-1.amazonaws.com/sentai/17-Gosei_Sentai_Dairanger.jpg"}
   18
    {:name "Ninja Sentai Kakuranger"
     :colors ["Red" "Blue" "Yellow" "White" "Black"]
     :image "https://s3-us-west-1.amazonaws.com/sentai/18-Sentai_Kakurangers.jpg"}
   19
    {:name "Chouriki Sentai Ohranger (Super-Powered Squadron Ohranger)"
     :colors ["Red" "Blue" "Yellow" "Pink" "Green" "Black"]
     :image "https://s3-us-west-1.amazonaws.com/sentai/19-Ohranger_With_Kingranger.jpg"}
   20
    {:name "Gekisou Sentai Carranger (Racing Squadron Carranger)"
     :colors ["Red" "Blue" "Yellow" "Pink" "Green" "White?"]
     :image "https://s3-us-west-1.amazonaws.com/sentai/20-Carrangers-white_racer.jpg"}
   21
    {:name "Denji Sentai Megaranger (Electromagnetic Squadron Megaranger)"
     :colors ["Red" "Blue" "Yellow" "Pink" "Black" "White"]
     :image "https://s3-us-west-1.amazonaws.com/sentai/21-IS_Rangers.jpg"}
   22
    {:name "Seijuu Sentai Gingaman (Starbeast Squadron Gingaman)"
     :colors ["Red" "Blue" "Yellow" "Pink" "Green" "Caped Black"]
     :image "https://s3-us-west-1.amazonaws.com/sentai/22-StarBeast_Squadron_Star_Men!.jpg"}
   23
    {:name "Kyukyu Sentai GoGo-V (Rescue Squadron GoGoFive)"
     :colors ["Red" "Blue" "Yellow" "Pink" "Green" "Black Gold"]
     :image "https://s3-us-west-1.amazonaws.com/sentai/23-GoGo-V_with_Sieg.jpg"}
   24
    {:name "Mirai Sentai Timeranger (Future Squadron Timeranger)"
     :colors ["Red" "Blue" "Yellow" "Pink" "Black" "The Other Red"]
     :image "https://s3-us-west-1.amazonaws.com/sentai/24-Time.jpg"}
   25
    {:name "Hyakujuu Sentai Gaoranger (Hundred-beasts Squadron Gaoranger)"
     :colors ["Red" "Blue" "Yellow" "Pink" "Black" "Platinum"]
     :image "https://s3-us-west-1.amazonaws.com/sentai/25-Gaorangers.jpg"}
   26
    {:name "Ninpu Sentai Hurricaneger"
     :colors ["Red" "Green" "Yellow" "Cerulean" "Navy Blue" "Crimson Black"]
     :image "https://s3-us-west-1.amazonaws.com/sentai/26-Hurricaneger.jpg"}
   27
    {:name "Bakuryuu Sentai Abaranger (Blastasaur Squadron Rampage Ranger)"
     :colors ["Red" "Blue" "Yellow"]
     :image "https://s3-us-west-1.amazonaws.com/sentai/27-Abaranger.jpg"}
   28
    {:name "Tokusou Sentai Dekaranger (Special Investigation Squadron Dekaranger)"
     :colors ["Red" "Blue" "Yellow" "Pink" "Green" "White"]
     :image "https://s3-us-west-1.amazonaws.com/sentai/28-Dekarangers.jpg"}
   29
    {:name "Mahou Sentai Magiranger (Magical Squadron Magiranger)"
     :colors ["Red" "Blue" "Yellow" "Pink" "Green" "Black Gold"]
     :image "https://s3-us-west-1.amazonaws.com/sentai/29-Magirangers.jpg"}
   30
    {:name "GoGo Sentai Boukenger (Rumbling Squadron Boukenger)"
     :colors ["Red" "Blue" "Yellow" "Pink" "Black" "Gold" "White"]
     :image "https://s3-us-west-1.amazonaws.com/sentai/30-Boukengers-Zubaan.jpg"}
   31
    {:name "Juken Sentai Gekiranger (Beast-Fist Squadron Fierce Spirit Ranger)"
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
    {:name "Tensou Sentai Goseiger (Heavenly Armament Squadron Goseiger)"
     :colors ["Red" "Blue" "Yellow" "Pink" "Black non-Cyborg" "Black Cyborg"]
     :image "https://s3-us-west-1.amazonaws.com/sentai/34-Goseiger.jpg"}
   35
    {:name "Kaizoku Sentai Gokaiger (Pirate Squadron Gokaiger)"
     :colors ["Red" "Blue" "Yellow" "Pink" "Green"]
     :image "https://s3-us-west-1.amazonaws.com/sentai/35-Gokaiger.jpg"}
   36
    {:name "Tokumei Sentai Go-Busters (Special Operations Squadron Go-Busters)"
     :colors ["Red" "Blue" "Yellow" "Cyan" "Gold"]
     :image "https://s3-us-west-1.amazonaws.com/sentai/36-Gobusters.jpg"}
   37
    {:name "Zyuden Sentai Kyoryuger (Beast Power Squadron Dinosaur Ranger)"
     :colors ["Navy Blue" "Purple" "Cyan" "Blue" "Grey" "Silver"]
     :image "https://s3-us-west-1.amazonaws.com/sentai/37-Kyorangers.png"}
   38
    {:name "Ressha Sentai ToQger (Train Squadron Limited Express Ranger)"
     :colors ["Red" "Blue" "Yellow" "Pink" "Green" "Purple" "Orange"]
     :image "https://s3-us-west-1.amazonaws.com/sentai/38-toqger.jpg"}
   39
    {:name "Shuriken Sentai Ninninger (Shuriken Squadron Ninninger)"
     :colors ["Red" "Blue" "Yellow" "Pink" "White"]
     :image "https://s3-us-west-1.amazonaws.com/sentai/39-Ninneger.jpg"}
   40
    {:name "Doubutsu Sentai Zyuohger (Animal Squadron Beast King Ranger)"
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
    {:name "Uchu Sentai Kyuranger (Space Squadron Nine Ranger)"
     :colors ["Red" "Orange" "Blue" "Gold" "Black" "Silver" "Green" "Pink" "Yellow"]
     :image "https://s3-us-west-1.amazonaws.com/sentai/46-kyuranger.jpg"}
   47
    {:name "Soldiers of the Outer Solar System"
     :colors ["Saturn" "Uranus" "Neptune" "Pluto (dwarf planet now)"]
     :image "https://s3-us-west-1.amazonaws.com/sentai/47-outer-senshi.jpg"}
   48
    {:name "Persona 5 Z Moves"
     :colors ["Joker" "Panther" "Mona" "Skull" "Fox" "Oracle" "Queen" "Noir" "Crow"]
     :image "https://s3-us-west-1.amazonaws.com/sentai/48-persona5.jpg"}
   })

(defn get-random-sentai
  []
  (sentai (+ (rand-int (count sentai)) 1)))

(defn get-squad
  [text]
  (case text
    ""                  ["Taylor" "Jon" "Elliot" "Tony"]
    "@platform"         ["Kyla" "Sara" "Alice" "Andrew" "Stephen (sort-of)"]
    "@security"         ["Damir" "KStar"]
    "@conversations"    ["Taylor" "Jon" "Elliot" "Tony"]
    "@records"          ["Sahil" "Bryan" "James"]
    "@automation"       ["Xie" "Matt" "Karen"]
    "@rest-api"         ["Björn" "Wyatt" "Lougenia"]
    "@design"           ["Kay" "Abi" "Sharon"]
    "@customer_success" ["Merijn" "Katy" "Therese" "Martijn" "Kellie" "Justin" "Tiffany" "Matt"]
    (split text #" ")))
