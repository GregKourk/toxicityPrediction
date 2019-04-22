# toxicityPrediction
Small program to predict toxicity of certain metal oxides.

Input in this program is 18 certain metal oxides with 17 indexes each.
Aim is to predict toxicity of last meal oxide. 
In order to do this at first we normalize values of indexes. After this we calculate Pearson coeeficient correlator for all metal oxides.
Last step is to create training set and test set, which are used in Weka to predict toxicity of last metal oxide.
