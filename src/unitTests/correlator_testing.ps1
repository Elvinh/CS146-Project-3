# /--------- PowerShell script to track performance ------------/

# This powershell script analyzes the errorSums of various texts

# In order the texts are: 
# Shakespeare: hamlet, othello, the-tempest
# Sir Francis Bacon: essays, novum, the-new-atlantis
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



# /------- Shakespeare ------------

java Correlator.java -h .\hamlet.txt \.othello.txt
java Correlator.java -h .\hamlet.txt \.the-tempest.txt
java Correlator.java -h .\othello.txt \.the-tempest.txt

# Note median errorSum, note which txt file contributed to smallest errorSums


# /------- Sir Francis Bacon ------------

java Correlator.java -h .\essays.txt \.novum.txt
java Correlator.java -h .\essays.txt \.the-new-atlantis.txt
java Correlator.java -h .\novum.txt \.the-new-atlantis.txt

# Note median errorSum, note which txt file contributed to smallest errorSums

# /------- The Rest here --------------