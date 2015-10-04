# /--------- PowerShell script to track performance ------------/

# This powershell script analyzes the errorSums of various texts

# In order the texts are: 
# Shakespeare: hamlet, othello, the-tempest
# Sir Francis Bacon: essays, novum (scientific), the-new-atlantis
# King James Bible
# alice (Alice in Wonderland)

# Test design:
# 0) Use HashTable backend for all tests (assuming it's the most efficient)
# 1) Compare all permutations of Shakespeare's works to find errorSums.
# Note the median errorSum for these 3 Shakespeare works (expected errorSum
# when comparing works within single author). 
# (3 choose 2)
# Use the text that produces the median errorSum to compare against others.
# 2) Do the same for Sir Francis Bacon
# 3) Run the different permutations (4 choose 2)
# s b, s k, s a, b k, b a, k a


# Written by Thien Van, Elton Vinh
# for CS 146 Section 01-Shaverdian Fall 2015
# Project 3 Benchmarking

# 1 Get Start Time
$startDTMs1=(Get-Date)

# /------- Shakespeare ------------

java -cp . wordcounter.Correlator -b .\txtFiles\hamlet.txt .\txtFiles\othello.txt
java -cp . wordcounter.Correlator -b .\txtFiles\hamlet.txt .\txtFiles\the-tempest.txt
java -cp . wordcounter.Correlator -b .\txtFiles\othello.txt .\txtFiles\the-tempest.txt

# Note median errorSum, note which txt file contributed to smallest errorSums


# /------- Sir Francis Bacon ------------

java -cp . wordcounter.Correlator -b .\txtFiles\essays.txt .\txtFiles\novum.txt
java -cp . wordcounter.Correlator -b .\txtFiles\essays.txt .\txtFiles\the-new-atlantis.txt
java -cp . wordcounter.Correlator -b .\txtFiles\novum.txt .\txtFiles\the-new-atlantis.txt

# Note median errorSum, note which txt files (hamlet, novum) contributed to smallest errorSums
""

java -cp . wordcounter.Correlator -b .\txtFiles\hamlet.txt .\txtFiles\novum.txt
java -cp . wordcounter.Correlator -b .\txtFiles\hamlet.txt .\txtFiles\king-james-bible.txt
java -cp . wordcounter.Correlator -b .\txtFiles\hamlet.txt .\txtFiles\alice.txt
java -cp . wordcounter.Correlator -b .\txtFiles\novum.txt .\txtFiles\king-james-bible.txt
java -cp . wordcounter.Correlator -b .\txtFiles\novum.txt .\txtFiles\alice.txt
java -cp . wordcounter.Correlator -b .\txtFiles\king-james-bible.txt .\txtFiles\alice.txt

# /------- The Rest here --------------

# Get End Time
$endDTMs1=(Get-Date)

"Elapsed Time Correlator BST: $(($endDTMs1-$startDTMs1).totalseconds) seconds"