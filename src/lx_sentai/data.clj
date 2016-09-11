(ns lx-sentai.data)

(def sentai
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
     :colors ["red" "blue" "yellow" "pink" "green"]
     :image "https://s3-us-west-1.amazonaws.com/sentai/04-denshi_sentai_denizman.jpg"}
   5
    {:name "Taiyo Sentai Sun Vulcan"
     :colors ["red" "blue" "yellow" "pink" "green"]
     :image "https://s3-us-west-1.amazonaws.com/sentai/05-sun_vulcan.jpg"}
   6
    {:name "Dai Sentai Goggle V"
     :colors ["red" "blue" "yellow" "pink" "green"]
     :image "https://s3-us-west-1.amazonaws.com/sentai/06-goggle.jpg"}
   7
    {:name "Kagaku Sentai Dynaman"
     :colors ["red" "blue" "yellow" "pink" "green"]
     :image "https://s3-us-west-1.amazonaws.com/sentai/07-Dynaman.jpg"}
   8
    {:name "Choudenshi Bioman"
     :colors ["red" "blue" "yellow" "pink" "green"]
     :image "https://s3-us-west-1.amazonaws.com/sentai/08-Bioman.gif"}
   9
    {:name "Dengeki Sentai Changeman"
     :colors ["red" "blue" "yellow" "pink" "green"]
     :image "https://s3-us-west-1.amazonaws.com/sentai/09-changemang.gif"}
   10
    {:name "Choushinsei Flashman"
     :colors ["red" "blue" "yellow" "pink" "green"]
     :image "https://s3-us-west-1.amazonaws.com/sentai/10-Flashman.jpg"}
   11
    {:name "Hikari Sentai Maskman"
     :colors ["red" "blue" "yellow" "pink" "green"]
     :image "https://s3-us-west-1.amazonaws.com/sentai/11-Maskmen.png"}
   12
    {:name "Choujuu Sentai Liveman"
     :colors ["red" "blue" "yellow" "pink" "green"]
     :image "https://s3-us-west-1.amazonaws.com/sentai/12-Liveman.jpg"}
   13
    {:name "Kousoku Sentai Turboranger"
     :colors ["red" "blue" "yellow" "pink" "green"]
     :image "https://s3-us-west-1.amazonaws.com/sentai/13-turbo_ranger.jpg"}
   14
    {:name "Chikyuu Sentai Fiveman"
     :colors ["red" "blue" "yellow" "pink" "green"]
     :image "https://s3-us-west-1.amazonaws.com/sentai/14-Fiveman.gif"}
   15
    {:name "Choujin Sentai Jetman"
     :colors ["red" "blue" "yellow" "pink" "green"]
     :image "https://s3-us-west-1.amazonaws.com/sentai/15-BirdmanTaskforceJetman.jpg"}
   16
    {:name "Kyōryū Sentai Zyuranger"
     :colors ["red" "blue" "yellow" "pink" "green"]
     :image "https://s3-us-west-1.amazonaws.com/sentai/16-Sentai_Zyuranger.jpg"}
   17
    {:name "Gosei Sentai Dairanger"
     :colors ["red" "blue" "yellow" "pink" "green"]
     :image "https://s3-us-west-1.amazonaws.com/sentai/17-Gosei_Sentai_Dairanger.jpg"}
   18
    {:name "Ninja Sentai Kakuranger"
     :colors ["red" "blue" "yellow" "pink" "green"]
     :image "https://s3-us-west-1.amazonaws.com/sentai/18-Sentai_Kakurangers.jpg"}
   19
    {:name "Chouriki Sentai Ohranger"
     :colors ["red" "blue" "yellow" "pink" "green"]
     :image "https://s3-us-west-1.amazonaws.com/sentai/19-Ohranger_With_Kingranger.jpg"}
   20
    {:name "Gekisou Sentai Carranger"
     :colors ["red" "blue" "yellow" "pink" "green"]
     :image "https://s3-us-west-1.amazonaws.com/sentai/20-Carrangers-white_racer.jpg"}
   21
    {:name "Denji Sentai Megaranger"
     :colors ["red" "blue" "yellow" "pink" "green"]
     :image "https://s3-us-west-1.amazonaws.com/sentai/21-IS_Rangers.jpg"}
   22
    {:name "Seijuu Sentai Gingaman"
     :colors ["red" "blue" "yellow" "pink" "green"]
     :image "https://s3-us-west-1.amazonaws.com/sentai/22-StarBeast_Squadron_Star_Men!.jpg"}
   23
    {:name "Kyukyu Sentai GoGo-V"
     :colors ["red" "blue" "yellow" "pink" "green"]
     :image "https://s3-us-west-1.amazonaws.com/sentai/23-GoGo-V_with_Sieg.jpg"}
   24
    {:name "Mirai Sentai Timeranger"
     :colors ["red" "blue" "yellow" "pink" "green"]
     :image "https://s3-us-west-1.amazonaws.com/sentai/24-Time.jpg"}
   25
    {:name "Hyakujuu Sentai Gaoranger"
     :colors ["red" "blue" "yellow" "pink" "green"]
     :image "https://s3-us-west-1.amazonaws.com/sentai/25-Gaorangers.jpg"}
   26
    {:name "Ninpu Sentai Hurricaneger"
     :colors ["red" "blue" "yellow" "pink" "green"]
     :image "https://s3-us-west-1.amazonaws.com/sentai/26-Hurricaneger.jpg"}
   27
    {:name "Bakuryuu Sentai Abaranger"
     :colors ["red" "blue" "yellow" "pink" "green"]
     :image "https://s3-us-west-1.amazonaws.com/sentai/27-Abaranger.jpg"}
   28
    {:name "Tokusou Sentai Dekaranger"
     :colors ["red" "blue" "yellow" "pink" "green"]
     :image "https://s3-us-west-1.amazonaws.com/sentai/28-Dekarangers.jpg"}
   29
    {:name "Mahou Sentai Magiranger"
     :colors ["red" "blue" "yellow" "pink" "green"]
     :image "https://s3-us-west-1.amazonaws.com/sentai/29-Magirangers.jpg"}
   30
    {:name "GoGo Sentai Boukenger"
     :colors ["red" "blue" "yellow" "pink" "green"]
     :image "https://s3-us-west-1.amazonaws.com/sentai/30-Boukengers-Zubaan.jpg"}
   31
    {:name "Juken Sentai Gekiranger"
     :colors ["red" "blue" "yellow" "pink" "green"]
     :image "https://s3-us-west-1.amazonaws.com/sentai/31-Gekiranger.jpg"}
   32
    {:name "Engine Sentai Go-Onger"
     :colors ["red" "blue" "yellow" "pink" "green"]
     :image "https://s3-us-west-1.amazonaws.com/sentai/32-Go-onger.jpg"}
   33
    {:name "Samurai Sentai Shinkenger"
     :colors ["red" "blue" "yellow" "pink" "green"]
     :image "https://s3-us-west-1.amazonaws.com/sentai/33-Shinkeger.jpg"}
   34
    {:name "Tensou Sentai Goseiger"
     :colors ["red" "blue" "yellow" "pink" "green"]
     :image "https://s3-us-west-1.amazonaws.com/sentai/34-Goseiger.jpg"}
   35
    {:name "Kaizoku Sentai Gokaiger"
     :colors ["red" "blue" "yellow" "pink" "green"]
     :image "https://s3-us-west-1.amazonaws.com/sentai/35-Gokaiger.jpg"}
   36
    {:name "Tokumei Sentai Go-Busters"
     :colors ["red" "blue" "yellow" "pink" "green"]
     :image "https://s3-us-west-1.amazonaws.com/sentai/36-Gobusters.png"}
   37
    {:name "Zyuden Sentai Kyoryuger"
     :colors ["red" "blue" "yellow" "pink" "green"]
     :image "https://s3-us-west-1.amazonaws.com/sentai/37-Kyorangers.png"}
   38
    {:name "Ressha Sentai ToQger"
     :colors ["red" "blue" "yellow" "pink" "green"]
     :image "https://s3-us-west-1.amazonaws.com/sentai/38-toqger.jpg"}
   39
    {:name "Shuriken Sentai Ninninger"
     :colors ["red" "blue" "yellow" "pink" "green"]
     :image "https://s3-us-west-1.amazonaws.com/sentai/39-Ninneger.jpg"}
   40
    {:name "Doubutsu Sentai Zyuohger"
     :colors ["red" "blue" "yellow" "pink" "green"]
     :image "https://s3-us-west-1.amazonaws.com/sentai/40-Zyuohger.jpg"}
   })
