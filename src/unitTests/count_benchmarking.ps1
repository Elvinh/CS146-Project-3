# /--------- PowerShell script to track performance ------------/

# This powershell script tracks the run times of the count.sh,
# count.pl, WordCount.java -f <Abstract Data Type> scripts on various texts

# In order the texts are: 
# Shakespeare: hamlet, othello, the-tempest
# Sir Francis Bacon: essays, novum, the-new-atlantis
# King James Bible
# alice (Alice in Wonderland)

# Tests in order are (s, p, b, a, h):
# Shell
# Perl
# Java - BST
# Java - AVL
# Java - HashTable

# Written by Thien Van, Elton Vinh
# for CS 146 Section 01-Shaverdian Fall 2015
# Project 3 Benchmarking

# ********* need to implement the Java tests



# /------- Shell ------------

# 1 Get Start Time
$startDTMs1=(Get-Date)

# Run script
sh count.sh .\hamlet.txt

# Get End Time
$endDTMs1=(Get-Date)

# 2 Get Start Time
$startDTMs2=(Get-Date)

# Run script
sh count.sh .\othello.txt

# Get End Time
$endDTMs2=(Get-Date)

# 3 Get Start Time
$startDTMs3=(Get-Date)

# Run script
sh count.sh .\the-tempest.txt

# Get End Time
$endDTMs3=(Get-Date)

# 4 Get Start Time
$startDTMs4=(Get-Date)

# Run script
sh count.sh .\essays.txt

# Get End Time
$endDTMs4=(Get-Date)

# 5 Get Start Time
$startDTMs5=(Get-Date)

# Run script
sh count.sh .\novum.txt

# Get End Time
$endDTMs5=(Get-Date)

# 6 Get Start Time
$startDTMs6=(Get-Date)

# Run script
sh count.sh .\the-new-atlantis.txt

# Get End Time
$endDTMs6=(Get-Date)

# 7 Get Start Time
$startDTMs7=(Get-Date)

# Run script
sh count.sh .\king-james-bible.txt

# Get End Time
$endDTMs7=(Get-Date)

# 8 Get Start Time
$startDTMs8=(Get-Date)

# Run script
sh count.sh .\alice.txt

# Get End Time
$endDTMs8=(Get-Date)



# /------- Perl ------------

# 1 Get Start Time
$startDTMp1=(Get-Date)

# Run script
sh count.sh .\hamlet.txt

# Get End Time
$endDTMp1=(Get-Date)

# 2 Get Start Time
$startDTMp2=(Get-Date)

# Run script
sh count.sh .\othello.txt

# Get End Time
$endDTMp2=(Get-Date)

# 3 Get Start Time
$startDTMp3=(Get-Date)

# Run script
sh count.sh .\the-tempest.txt

# Get End Time
$endDTMp3=(Get-Date)

# 4 Get Start Time
$startDTMp4=(Get-Date)

# Run script
sh count.sh .\essays.txt

# Get End Time
$endDTMp4=(Get-Date)

# 5 Get Start Time
$startDTMp5=(Get-Date)

# Run script
sh count.sh .\novum.txt

# Get End Time
$endDTMp5=(Get-Date)

# 6 Get Start Time
$startDTMp6=(Get-Date)

# Run script
sh count.sh .\the-new-atlantis.txt

# Get End Time
$endDTMp6=(Get-Date)

# 7 Get Start Time
$startDTMp7=(Get-Date)

# Run script
sh count.sh .\king-james-bible.txt

# Get End Time
$endDTMp7=(Get-Date)

# 8 Get Start Time
$startDTMp8=(Get-Date)

# Run script
sh count.sh .\alice.txt

# Get End Time
$endDTMp8=(Get-Date)




# Echo Time elapsed - Shell
"Elapsed Time Hamlet Shell: $(($endDTMs1-$startDTMs1).totalseconds) seconds"
"Elapsed Time Othello Shell: $(($endDTMs2-$startDTMs2).totalseconds) seconds"
"Elapsed Time The-Tempest Shell: $(($endDTMs3-$startDTMs3).totalseconds) seconds"
"Elapsed Time Essays Shell: $(($endDTMs4-$startDTMs4).totalseconds) seconds"
"Elapsed Time Novum Shell: $(($endDTMs5-$startDTMs5).totalseconds) seconds"
"Elapsed Time The-New-Atlantis Shell: $(($endDTMs6-$startDTMs6).totalseconds) seconds"
"Elapsed Time King-James-Bible Shell: $(($endDTMs7-$startDTMs7).totalseconds) seconds"
"Elapsed Time Alice Shell: $(($endDTMs8-$startDTMs8).totalseconds) seconds"

""

# Echo Time elapsed - Perl
"Elapsed Time Hamlet Perl: $(($endDTMp1-$startDTMp1).totalseconds) seconds"
"Elapsed Time Othello Perl: $(($endDTMp2-$startDTMp2).totalseconds) seconds"
"Elapsed Time The-Tempest Perl: $(($endDTMp3-$startDTMp3).totalseconds) seconds"
"Elapsed Time Essays Perl: $(($endDTMp4-$startDTMp4).totalseconds) seconds"
"Elapsed Time Novum Perl: $(($endDTMp5-$startDTMp5).totalseconds) seconds"
"Elapsed Time The-New-Atlantis Perl: $(($endDTMp6-$startDTMp6).totalseconds) seconds"
"Elapsed Time King-James-Bible Perl: $(($endDTMp7-$startDTMp7).totalseconds) seconds"
"Elapsed Time Alice Perl: $(($endDTMp8-$startDTMp8).totalseconds) seconds"