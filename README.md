<p align="center"><img src="docs/media/logo.png"/></p>

# lang4j
A string resource tool making it straight forward to add foreign language translations to your java app

## Setup
Download the .jar file (and the sources .jar file if desired) from the releases page of the repo [here](https://github.com/Kalekdan/lang4j/releases).  
Include the .jar in your java project.  
Create a ```resources/lang``` directory in your project. This is the directory under which you will store your language files.

## Using lang4j
If a language is not specified, the default language is used instead (eng by default).
~~~ java
// Gets the mc.name resource in resources/lang/characterNames_eng.properties
L4j.getResource("characterNames", "mc.name");
// Gets the mc.name resource in resources/lang/characterNames_fr.properties
L4j.getResource("characterNames", "mc.name", "fr");
~~~

You can also store resources in sub-directories as follows:
~~~ java
// Gets the alert.question resource in resources/lang/dialog/npc_eng.properties
L4j.getResourceInDir("dialog", "npc", "alert.question");
// Gets the alert.question resource in resources/lang/dialog/npc_fr.properties
L4j.getResourceInDir("dialog", "npc", "alert.question", "fr");
~~~

If you do not wish to specify the file the resource is in, lang4j can use a default file (```resources_lang.properties``` by default):
~~~ java
// Gets the alert.theif resource in resources/lang/dialog/resources_eng.properties
L4j.getDefResource("alert.theif");
// Gets the alert.theif resource in resources/lang/dialog/resources_fr.properties
L4j.getDefResource("alert.theif", "fr");
~~~

## Configuring
You can change the default language (the language used if none other is specified) using:
~~~ java
L4j.setCurrentLang("fr");
~~~

You can also change the location where the resouces are stored (by default ```resources/lang```) using:
~~~ java
L4j.setResLoc("res/languagepacks");
~~~

If you are not specifying the resource file and are getting the resources using ```getDefResource(...)```, you can change the default file that will be used by using:
~~~ java
// The default resource location will now be /defFilename_lang.properties
L4j.setDefaultResFileName("defFilename");
~~~
