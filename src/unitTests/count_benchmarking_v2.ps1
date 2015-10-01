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


# /------- Java BST ------------

# 1 Get Start Time
$startDTMb1=(Get-Date)

# Run script
java WordCount.java -b .\hamlet.txt

# Get End Time
$endDTMb1=(Get-Date)

# 2 Get Start Time
$startDTMb2=(Get-Date)

# Run script
java WordCount.java -b .\othello.txt

# Get End Time
$endDTMb2=(Get-Date)

# 3 Get Start Time
$startDTMb3=(Get-Date)

# Run script
java WordCount.java -b .\the-tempest.txt

# Get End Time
$endDTMb3=(Get-Date)

# 4 Get Start Time
$startDTMb4=(Get-Date)

# Run script
java WordCount.java -b .\essays.txt

# Get End Time
$endDTMb4=(Get-Date)

# 5 Get Start Time
$startDTMb5=(Get-Date)

# Run script
java WordCount.java -b .\novum.txt

# Get End Time
$endDTMb5=(Get-Date)

# 6 Get Start Time
$startDTMb6=(Get-Date)

# Run script
java WordCount.java -b .\the-new-atlantis.txt

# Get End Time
$endDTMb6=(Get-Date)

# 7 Get Start Time
$startDTMb7=(Get-Date)

# Run script
java WordCount.java -b .\king-james-bible.txt

# Get End Time
$endDTMb7=(Get-Date)

# 8 Get Start Time
$startDTMb8=(Get-Date)

# Run script
java WordCount.java -b .\alice.txt

# Get End Time
$endDTMb8=(Get-Date)


# /------- Java AVL ------------

# 1 Get Start Time
$startDTMa1=(Get-Date)

# Run script
java WordCount.java -a .\hamlet.txt

# Get End Time
$endDTMa1=(Get-Date)

# 2 Get Start Time
$startDTMa2=(Get-Date)

# Run script
java WordCount.java -a .\othello.txt

# Get End Time
$endDTMa2=(Get-Date)

# 3 Get Start Time
$startDTMa3=(Get-Date)

# Run script
java WordCount.java -a .\the-tempest.txt

# Get End Time
$endDTMa3=(Get-Date)

# 4 Get Start Time
$startDTMa4=(Get-Date)

# Run script
java WordCount.java -a .\essays.txt

# Get End Time
$endDTMa4=(Get-Date)

# 5 Get Start Time
$startDTMa5=(Get-Date)

# Run script
java WordCount.java -a .\novum.txt

# Get End Time
$endDTMa5=(Get-Date)

# 6 Get Start Time
$startDTMa6=(Get-Date)

# Run script
java WordCount.java -a .\the-new-atlantis.txt

# Get End Time
$endDTMa6=(Get-Date)

# 7 Get Start Time
$startDTMa7=(Get-Date)

# Run script
java WordCount.java -a .\king-james-bible.txt

# Get End Time
$endDTMa7=(Get-Date)

# 8 Get Start Time
$startDTMa8=(Get-Date)

# Run script
java WordCount.java -a .\alice.txt

# Get End Time
$endDTMa8=(Get-Date)

# /------- Java HashTable ------------

# 1 Get Start Time
$startDTMh1=(Get-Date)

# Run script
java WordCount.java -h .\hamlet.txt

# Get End Time
$endDTMh1=(Get-Date)

# 2 Get Start Time
$startDTMh2=(Get-Date)

# Run script
java WordCount.java -h .\othello.txt

# Get End Time
$endDTMh2=(Get-Date)

# 3 Get Start Time
$startDTMh3=(Get-Date)

# Run script
java WordCount.java -h .\the-tempest.txt

# Get End Time
$endDTMh3=(Get-Date)

# 4 Get Start Time
$startDTMh4=(Get-Date)

# Run script
java WordCount.java -h .\essays.txt

# Get End Time
$endDTMh4=(Get-Date)

# 5 Get Start Time
$startDTMh5=(Get-Date)

# Run script
java WordCount.java -h .\novum.txt

# Get End Time
$endDTMh5=(Get-Date)

# 6 Get Start Time
$startDTMh6=(Get-Date)

# Run script
java WordCount.java -h .\the-new-atlantis.txt

# Get End Time
$endDTMh6=(Get-Date)

# 7 Get Start Time
$startDTMh7=(Get-Date)

# Run script
java WordCount.java -h .\king-james-bible.txt

# Get End Time
$endDTMh7=(Get-Date)

# 8 Get Start Time
$startDTMh8=(Get-Date)

# Run script
java WordCount.java -h .\alice.txt

# Get End Time
$endDTMh8=(Get-Date)


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

""

# Echo Time elapsed - Java-BST
"Elapsed Time Hamlet Java-BST: $(($endDTMp1-$startDTMp1).totalseconds) seconds"
"Elapsed Time Othello Java-BST: $(($endDTMp2-$startDTMp2).totalseconds) seconds"
"Elapsed Time The-Tempest Java-BST: $(($endDTMp3-$startDTMp3).totalseconds) seconds"
"Elapsed Time Essays Java-BST: $(($endDTMp4-$startDTMp4).totalseconds) seconds"
"Elapsed Time Novum Java-BST: $(($endDTMp5-$startDTMp5).totalseconds) seconds"
"Elapsed Time The-New-Atlantis Java-BST: $(($endDTMp6-$startDTMp6).totalseconds) seconds"
"Elapsed Time King-James-Bible Java-BST: $(($endDTMp7-$startDTMp7).totalseconds) seconds"
"Elapsed Time Alice Java-BST: $(($endDTMp8-$startDTMp8).totalseconds) seconds"

""

# Echo Time elapsed - Java-AVL
"Elapsed Time Hamlet Java-AVL: $(($endDTMp1-$startDTMp1).totalseconds) seconds"
"Elapsed Time Othello Java-AVL: $(($endDTMp2-$startDTMp2).totalseconds) seconds"
"Elapsed Time The-Tempest Java-AVL: $(($endDTMp3-$startDTMp3).totalseconds) seconds"
"Elapsed Time Essays Java-AVL: $(($endDTMp4-$startDTMp4).totalseconds) seconds"
"Elapsed Time Novum Java-AVL: $(($endDTMp5-$startDTMp5).totalseconds) seconds"
"Elapsed Time The-New-Atlantis Java-AVL: $(($endDTMp6-$startDTMp6).totalseconds) seconds"
"Elapsed Time King-James-Bible Java-AVL: $(($endDTMp7-$startDTMp7).totalseconds) seconds"
"Elapsed Time Alice Java-AVL: $(($endDTMp8-$startDTMp8).totalseconds) seconds"

""

# Echo Time elapsed - Java HashTable
"Elapsed Time Hamlet Java-HashTable: $(($endDTMp1-$startDTMp1).totalseconds) seconds"
"Elapsed Time Othello Java-HashTable: $(($endDTMp2-$startDTMp2).totalseconds) seconds"
"Elapsed Time The-Tempest Java-HashTable: $(($endDTMp3-$startDTMp3).totalseconds) seconds"
"Elapsed Time Essays Java-HashTable: $(($endDTMp4-$startDTMp4).totalseconds) seconds"
"Elapsed Time Novum Java-HashTable: $(($endDTMp5-$startDTMp5).totalseconds) seconds"
"Elapsed Time The-New-Atlantis Java-HashTable: $(($endDTMp6-$startDTMp6).totalseconds) seconds"
"Elapsed Time King-James-Bible Java-HashTable: $(($endDTMp7-$startDTMp7).totalseconds) seconds"
"Elapsed Time Alice Java-HashTable: $(($endDTMp8-$startDTMp8).totalseconds) seconds"