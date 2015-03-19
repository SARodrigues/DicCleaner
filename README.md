Dic Cleaner
=============

Dic Cleaner is a quick & dirty java script to clean up OpenOffice dictionaries to use in personal projects. It takes a ````.dic```` file (extracted from an OpenOffice dictionary extension) and spits out a cleaned up file with one word per line.

How to use
-------------
Compile: ````javac DicCleaner.java````

Run: ````java DicCleaner source.dic output.txt````

What it does
-------------

* Extracts the dictionary word from each line (without any of the other stuff, only adding ````\r\n```` to the end of the line)
* Removes duplicates
* Preserves diacritical marks in Latin alphabets (hopefully)
* Preserves numbers

See example ````source.dic```` and ````output.txt```` files to get a better idea of what it does exactly. 

Where to get input dictionaries
-------------
Dictionary extensions can be found at the [OpenOffice's Extensions website](http://extensions.openoffice.org).

Simply download the dictionary extension and rename it to ````.zip```` in order to access its contents and get the respective ````.dic```` file. 

Notes
-------------
I've only tested the script with the US English Spell Checking Dictionary (v1.0) and the European Portuguese Dictionary (v15.1.2.1). I'm not sure how it'll behave with other languages. Either way, word capture is done with Regex, so it can be easily tweaked. 

This is a simple quick and dirty script that I use for personal projects. As such, it is provided as is. 
