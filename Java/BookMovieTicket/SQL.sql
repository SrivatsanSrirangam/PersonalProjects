{\rtf1\ansi\ansicpg1252\cocoartf2638
\cocoatextscaling0\cocoaplatform0{\fonttbl\f0\fswiss\fcharset0 Helvetica;}
{\colortbl;\red255\green255\blue255;}
{\*\expandedcolortbl;;}
\margl1440\margr1440\vieww11520\viewh8400\viewkind0
\pard\tx720\tx1440\tx2160\tx2880\tx3600\tx4320\tx5040\tx5760\tx6480\tx7200\tx7920\tx8640\pardirnatural\partightenfactor0

\f0\fs24 \cf0 -- DROP TABLE ZipCode;\
-- DROP TABLE Theater;\
-- DROP TABLE Movie;\
-- DROP TABLE ShownAt;\
-- DROP TABLE ShownAtTimes;\
\
CREATE TABLE ZipCode( \
    zipCodeValue int NOT NULL,\
    primary key(zipCodeValue)\
);\
CREATE TABLE Theater(\
    theaterId integer NOT NULL,\
    theaterName varchar(255) NOT NULL,\
    zipCodeValue int,\
    foreign key(zipCodeValue) REFERENCES ZipCode,\
    primary key(theaterId)\
);\
CREATE TABLE Movie( \
    movieId integer NOT NULL,\
    movieName varchar(255) NOT NULL,\
    Description varchar(1000),\
    duration char(7),\
    primary key(movieId)\
);\
\
CREATE TABLE ShownAt(\
    shownAtID integer NOT NULL,\
    theaterId integer NOT NULL,\
    movieId int NOT NULL,\
    foreign key(theaterId) REFERENCES Theater,\
    foreign key(movieId) REFERENCES Movie,\
    primary key (shownAtId)\
);\
CREATE TABLE ShownAtTimes(\
    shownAtID integer NOT NULL,\
    foreign key(shownAtId) references ShownAt,\
    showTime char(8),\
    primary key(shownAtID,showTime)\
    \
);\
INSERT INTO ZipCode (zipCodeValue)\
VALUES (78660),(75075),(78728);\
INSERT INTO Theater (theaterId,theaterName,zipCodeValue)\
VALUES (1,'Cinemark Plano', 78660),\
	(2,'Studio Grill', 78660),\
	(3,'Cinemak Legacy and XD', 78660),\
	(4,'Alamo Draft House', 75075),\
	(5,'Cinemak 20 and XD', 75075),\
	(6,'AMC DINE-IN Tech Ridge 10', 75075),\
	(7,'Southwest Theaters ',78728),\
	(8,'Flix Brewhouse RoundRock',78728),\
	(9,'Cinemark StoneHill',78728);\
INSERT INTO Movie (movieId, movieName,Description,duration)\
VALUES (1,'DC League of Super-Pets','Krypto the Super-Dog and Superman are inseparable best friends, sharing the same superpowers and fighting crime side by side in Metropolis. However, when the Man of Steel and the rest of the Justice League are kidnapped, Krypto must convince a ragtag group of animals to master their own newfound powers for a rescue mission.','1:45:00'),\
	(2,'Nope','Two siblings who run a California horse ranch discover something wonderful and sinister in the skies above, while the owner of an adjacent theme park tries to profit from the mysterious, otherworldly phenomenon.','2:10:00'),\
	(3,'Minions: The Rise of Gru','In the 1970s, young Gru tries to join a group of supervillains called the Vicious 6 after they oust their leader -- the legendary fighter Wild Knuckles. When the interview turns disastrous, Gru and his Minions go on the run with the Vicious 6 hot on their tails','1:27:00'),\
	(4,'Bullet Train','Five assassins find themselves on a fast moving bullet train from Tokyo to Morioka with only a few stops in between. They discover their missions are not unrelated to each other.','2:06:00'),\
	(5,'Thor: Love and Thunder','Thor embarks on a journey unlike anything he''s ever faced -- a quest for inner peace. However, his retirement gets interrupted by Gorr the God Butcher, a galactic killer who seeks the extinction of the gods.','1:59:00'),\
	(6,'Where the Crawdads Sing','Abandoned as a girl, Kya raised herself in the dangerous marshlands of North Carolina. For years, rumors of the marsh girl haunted Barkley Cove, isolating the sharp and resilient Kya from her community.','2:05:00'),\
	(7,'Top Gun: Maverick','After more than 30 years of service as one of the Navy''s top aviators, Pete "Maverick" Mitchell is where he belongs, pushing the envelope as a courageous test pilot and dodging the advancement in rank that would ground him.','2:15:00'),\
	(8,'Easter Sunday','A man returns home to celebrate Easter with his riotous, bickering, eating, drinking, laughing, loving family.','1:55:00'),\
	(9,'Elvis','From his rise to fame to his unprecedented superstardom, rock ''n'' roll icon Elvis Presley maintains a complicated relationship with his enigmatic manager, Colonel Tom Parker, over the course of 20 years.','2:39:00'),\
	(10,'Paws of Fury: The Legend of Hank','A down-on-his-luck hound finds himself in a town full of cats who need a hero to defend them from a ruthless villain''s evil plot to wipe their village off the map. With help from a reluctant trainer, the underdog must assume the role of fearsome samurai and team up with the felines to save the day. The only problem is -- they all hate dogs.','1:43:00'),\
	(11,'The Black Phone','Finney Shaw is a shy but clever 13-year-old boy who''s being held in a soundproof basement by a sadistic, masked killer. When a disconnected phone on the wall starts to ring, he soon discovers that he can hear the voices of the murderer''s previous victims -- and they are dead set on making sure that what happened to them doesn''t happen to Finney.','1:42:00'),\
	(12,'Vengeance','A journalist and podcaster travels from New York City to Texas to investigate the death of a woman whom he hooked up with.','1:40:00'),\
	(13,'Jurassic World: Dominion','Four years after the destruction of Isla Nublar, dinosaurs now live and hunt alongside humans all over the world. This fragile balance will reshape the future and determine, once and for all, whether human beings are to remain the apex predators on a planet they now share with history''s most fearsome creatures.','2:26:00'),\
	(14,'Everything Everywhere All at Once','When an interdimensional rupture unravels reality, an unlikely hero must channel her newfound powers to fight bizarre and bewildering dangers from the multiverse as the fate of the world hangs in the balance.','2:19:00'),\
	(15,'Marcel the Shell with Shoes On','Marcel, a 1-inch-tall shell, lives with his grandmother, Connie, the only residents of their town after their neighbors'' sudden, mysterious disappearance. When discovered by a guest amongst the clutter of his Airbnb, the short film he posts online brings Marcel millions of passionate fans and a new hope of reuniting with his long-lost family.','1:29:00'),\
        (16,'Mrs. Harris Goes to Paris','In 1950s London, a widowed cleaning lady falls madly in love with a couture Dior dress, deciding she must have one of her own. After working to raise the funds to pursue her dream, she embarks on an adventure to Paris that will change not only her own outlook -- but the very future of the House of Dior.','1:55:00'),\
	(17,'Lightyear','Legendary space ranger Buzz Lightyear embarks on an intergalactic adventure alongside ambitious recruits Izzy, Mo, Darby, and his robot companion, Sox. As this motley crew tackles their toughest mission yet, they must learn to work together as a team to escape the evil Zurg and his dutiful robot army that are never far behind.','1:45:00'),\
	(18,'Ramarao on Duty','Ramarao on Duty is an Indian Telugu-language action thriller film written and directed by Sarath Mandava. Produced by SLV Cinemas and RT Team Works, it stars Ravi Teja in titular role alongside Divyansha Kaushik, Rajisha Vijayan, and Venu Thottempudi.','2:01:00'),\
	(19,'Fire of Love','Intrepid scientists and lovers Katia and Maurice Krafft die in a volcanic explosion doing the very thing that brought them together, unravelling the mysteries of volcanoes by capturing some of nature''s most explosive imagery.','1:33:00'),\
	(20,'Ek Villain Returns','Ek Villain Returns is a 2022 Indian Hindi-language action thriller film written and directed by Mohit Suri, and a spiritual successor to his 2014 film Ek Villain. The film is produced by Shobha Kapoor, Ekta Kapoor, Bhushan Kumar and Krishan Kumar under the banners Balaji Motion Pictures and T-Series.','2:10:00'),\
	(21,'Kiki''s Delivery Service','Celebrate this beloved coming-of-age story from the legendary Studio Ghibli, creators of Spirited Away, and Academy Award\'ae-winning director Hayao Miyazaki, about a resourceful young witch who uses her broom to create a delivery service, only to lose her gift of flight in a moment of self-doubt. It is a tradition for all young witches to leave their families on the night of a full moon and fly off into the wide world to learn their craft. When that night comes for Kiki, she embarks on her new journey with her sarcastic black cat, Jiji, landing the next morning in a seaside village, where her unique skills make her an instant sensation.','1:57:00'),\
	(22,'Vikrant Rona','Vikrant Rona is a 2022 Indian Kannada-language action-adventure thriller film written and directed by Anup Bhandari. It stars Sudeep as the titular character alongside Nirup Bhandari, Neetha Ashok, and Jacqueline Fernandez.','2:15:00'),\
	(23,'The Croods: A New Age','Searching for a safer habitat, the prehistoric Crood family discovers an idyllic, walled-in paradise that meets all of its needs. Unfortunately, they must also learn to live with the Bettermans -- a family that''s a couple of steps above the Croods on the evolutionary ladder.','1:35:00'),\
	(24,'Detective Vs. Sleuths','When Hong Kong is rocked by multiple gruesome murders, the police forms a task force to investigate. Jun (Sean Lau), once a brilliant detective who suffered a mental breakdown, begins his own investigation. Eventually, the police learn that the murder victims are all suspects of cold cases being rubbed out by a figure known as "The Sleuth". Now, Jun and a detective from the task force are on a race against time to beat the brutal killer at its own game.','1:41:00'),\
	(25,'Bullet Train Early Access Screening','In Bullet Train, Brad Pitt stars as Ladybug, an unlucky assassin determined to do his job peacefully after one too many gigs gone off the rails. Fate, however, may have other plans, as Ladybug''s latest mission puts him on a collision course with lethal adversaries from around the globe\'97all with connected, yet conflicting, objectives\'97on the world''s fastest train. The end of the line is just the beginning in this non-stop thrill-ride through modern-day Japan from David Leitch, the director of Deadpool 2.','2:06:00'),\
	(26,'The Boss Baby: Family Business','Now adults, Tim Templeton is a stay-at-home dad for two adorable daughters, while his estranged brother, Ted, is a big-shot CEO. They come together in an unexpected way when they take a magical formula that transforms them into babies for 48 hours.','1:47:00'),\
	(27,'Hallelujah: Leonard Cohen, A Journey, A Song','A definitive exploration of singer-songwriter Leonard Cohen as seen through the prism of his internationally renowned hymn, Hallelujah.','1:55:00');\
\
INSERT INTO ShownAt(shownAtID,theaterId,movieId)\
VALUES \
(1,1,1),\
(2,1,2),\
(3,1,3),\
(4,2,4),\
(5,2,5),\
(6,2,6),\
(7,3,7),\
(8,3,8),\
(9,3,9),\
(10,4,10),\
(11,4,11),\
(12,4,12),\
(13,5,13),\
(14,5,14),\
(15,5,15),\
(16,6,16),\
(17,6,17),\
(18,6,18),\
(19,7,19),\
(20,7,20),\
(21,7,21),\
(22,8,22),\
(23,8,23),\
(24,8,24),\
(25,9,25),\
(26,9,26),\
(27,9,27);\
\
INSERT INTO ShownAtTimes(shownAtID,showTime)\
VALUES\
(1,'00:41:00'),\
(1,'21:49:00'),\
(1,'03:10:00'),\
(2,'13:18:00'),\
(2,'14:45:00'),\
(2,'20:19:00'),\
(3,'19:49:00'),\
(3,'20:14:00'),\
(3,'16:16:00'),\
(4,'01:15:00'),\
(4,'21:22:00'),\
(4,'14:09:00'),\
(5,'21:54:00'),\
(5,'15:51:00'),\
(5,'15:26:00'),\
(6,'22:17:00'),\
(6,'08:09:00'),\
(6,'08:25:00'),\
(7,'04:42:00'),\
(7,'19:46:00'),\
(7,'16:10:00'),\
(8,'13:22:00'),\
(8,'18:19:00'),\
(8,'18:41:00'),\
(9,'15:15:00'),\
(9,'08:58:00'),\
(9,'08:08:00'),\
(10,'13:19:00'),\
(10,'16:01:00'),\
(10,'16:51:00'),\
(11,'03:50:00'),\
(11,'05:44:00'),\
(11,'06:20:00'),\
(12,'06:28:00'),\
(12,'22:02:00'),\
(12,'00:40:00'),\
(13,'12:22:00'),\
(13,'00:20:00'),\
(13,'18:39:00'),\
(14,'12:23:00'),\
(14,'03:08:00'),\
(14,'17:38:00'),\
(15,'14:35:00'),\
(15,'11:29:00'),\
(15,'07:18:00'),\
(16,'20:17:00'),\
(16,'13:38:00'),\
(16,'10:18:00'),\
(17,'09:20:00'),\
(17,'02:10:00'),\
(17,'06:10:00'),\
(18,'18:42:00'),\
(18,'04:57:00'),\
(18,'19:24:00'),\
(19,'08:14:00'),\
(19,'20:42:00'),\
(19,'00:14:00'),\
(20,'22:43:00'),\
(20,'16:23:00'),\
(20,'03:36:00'),\
(21,'09:42:00'),\
(21,'15:04:00'),\
(21,'19:05:00'),\
(22,'13:28:00'),\
(22,'07:17:00'),\
(22,'08:52:00'),\
(23,'06:38:00'),\
(23,'03:06:00'),\
(23,'22:51:00'),\
(24,'03:24:00'),\
(24,'20:18:00'),\
(24,'12:36:00'),\
(25,'08:32:00'),\
(25,'17:27:00'),\
(25,'09:42:00'),\
(26,'06:46:00'),\
(26,'15:07:00'),\
(26,'06:00:00'),\
(27,'19:22:00'),\
(27,'11:41:00'),\
(27,'00:13:00');\
     }