	Appium Configuration 

	Prérequis : 

	1- Java
	2- Android Studio (android sdk + emulateur)
	3- Node
	4- Java / Android SDK / Node Home Paths

	Installer Appium :
		npm install -g appium
				Tester l'installation avec la commande : appium
		
		ou pour avoir la version 1.20 qui inclue le serveur + l'inspecteur en une seule app : https://github.com/appium/appium-desktop/releases/tag/v1.20.2
			
		Verifier l'installation de android SDK :
			- Ouvrir android studio
			- Tools -> SDK Manager - onglet SDK Tools
			- Uncheck Hide obsolete packages
			- Dans la liste, cocher Android SDk Tools si ce n'est pas déjà fait -> Apply m'installation va commencer si pas déjà fait

	System Path à configurer : 
		NODE_HOME -> C:\Program Files\nodejs
		ANDROID_HOME -> C:\Users\DevCBA\AppData\Local\Android\Sdk
		JAVA_HOME -> C:\Program Files\Java\jdk1.8.0_201
		
		Dans la variable systeme Path, ajouter : 
			- C:\Users\DevCBA\AppData\Local\Android\Sdk\tools
			- C:\Users\DevCBA\AppData\Local\Android\Sdk\tools\bin
			- C:\Users\DevCBA\AppData\Local\Android\Sdk\platform-tools
			- C:\Program Files\nodejs\node_modules\npm\bin
			
		Configurer un emulateur android dans android studio :
			- AVD Manager
			- Create Virtual Device
			- Choisir la dernière version android
			- Lui donner un nom et sauvegarder
			- Ajouter de la RAM si nécéssaire
			
		Créer un Projet Appium sur eclipse IDE : 
			- créer un nouveau java project
			- une fois créer, clic gauche sur le dossier -> configure -> convert to Maven Project, cela crée le pom.xml
			- Se rendre sur https://mvnrepository.com/artifact/io.appium/java-client, cliquer sur la derniere version ou la version désirée
			- Deux manière de faire pour download les dependencies dont on a besoin :
				1- Ouvrir le pom.xml : clic gauche -> open with -> generic text editor 
				2- Sous le </build>, ajouter <dependencies></dependencies>
				3- Ajouter le tag <dependency> référencé sur la page de maven Repo dans le tag <dependencies> précedemment crée
					Ex : 
							<!-- https://mvnrepository.com/artifact/io.appium/java-client -->
								<dependency>
								    <groupId>io.appium</groupId>
								    <artifactId>java-client</artifactId>
								    <version>8.1.1</version>
								</dependency>
								
				4- Sauvegarder le fichier
				5- Un package Maven Dependencies devrait apparaitre dans le projet
				
				OU 
				
				1- Télécharger le fichier .jar sur la page de la version java client : https://mvnrepository.com/artifact/io.appium/java-client
				2- clic gauche sur le projet -> properties -> Java Build Path -> Add external JARs
				3- Selectionner le fichier .jar téléchargé
				
				
			DONE ! 
			
			
			Appium-doctor : https://www.npmjs.com/package/appium-doctor
			
 OOOO
 OOOOOOOOO
OOOOOOOOOOOO
OOOOOOOOOOOOO
OOOOOOOOOOOOOO
OOOOOOOOOOOOOO
 OOOOOOOOOOOOOO
 OOOOOOOOOOOOOO
 OOOOOOOOOOOOOO
  OOOOOOOOOOOOOO
  OOOOOOOOOOOOOO
  OOOOOOOOOOOOOO
  OOOOOOOOOOOOOO
   OOOOOOOOOOOOOO
   OOOOOOOOOOOOOO
   OOOOO \_| \_|O
   OOOO \/  \/  \
   OOOO (o   )o  )
   O/c   \__/ --.
   O\_   ,     -'
    O|  '\_______)
     |       _)
     |      |
     oooooooo
    /        \
    
    
    
    Live debugger with adb and appium : 
    
    C:\Users\DevCBA\AppData\Local\Android\Sdk\tools\bin/uiautomatorviewer.bat
    
    OU
    
    Avec appium 1.20 : File -> New Session Window
    Il faut set le device dans l'onglet Desired Capabilities : 
    	Champs nécéssaires : 
    		- deviceName -> Text -> adresse (exemple: RF8N11S8H3A)
    		- app -> Text -> path de l'app .apk (exemple: C:/dev/workspace-eclipse/testAppium/src/ApiDemos-debug.apk)
    		- platformName -> text -> nom de la plateforme utilisée (exemple: android)
    Puis Start Session
    
	{
  	"app": "C:/dev/workspace-eclipse/testAppium/src/ApiDemos-debug.apk",
  	"platformName": "android",
  	"deviceName": "RF8N11S8H3A"
	}
    
    
    
    Error Cases : 
    
    On try to take a screenshot with to debugg :
    	Error obtaining UI hierarchy Reason: Error while obtaining UI hierarchy XML file: com.android.ddmlib.SyncException: Remote object doesn't exist!
    		- adb kill-server -> adb start-server
    		ou
    		- restart manually