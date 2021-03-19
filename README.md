# Cross-Language-Clone-Detection-Threat-to-Validity
Address the threat of cross language clone detection model


As mentioned by the authors of the paper, the data used for training and testing the clone-detection model is from a competitive source
(https://atcoder.jp). Moreover, the data is taken are from the beginner level contests of this site.
There are two possible ways to address this threat to validity: one proposed by authors and one by our team.
As suggested by the authors, training/fine-tuning the model with the real-world data.
This is far beyond the infrastructure of the team and it does not seem feasible.
So we as a team has decided to collect small dataset from various coding websites, manually annotate them and validate against
the trained model. Furthermore, we will observe how this model differs in detecting the clones for the different dataset.\\


Below are the steps that we followed to address the mentioned threat.
1. We collected a small dataset of 100 java-python code clones from various coding websites such as Codechef (https://www.codechef.com/),
Hackerrank (https://www.hackerrank.com/) and geeks for geeks (https://www.geeksforgeeks.org/)
2. We generated the ASTs for this dataset. However, there were some errors in generating ASTs for some projects so we excluded those projects.
3. We generated the vocabulary for these ASTs for both java and python
4. Now, to generate the embeddings for these AST nodes, we generated Skipgram data for both 
5. Trained the skipgram model with the generated skipgram data and get the embeddings for the ASTs
6. Created a database with the ASTs of all projects
7. Finally, we eveluated the previusly trained code clone detection weights with our small dataset 

We noticed that the accuracy and precision for our new small dataset seems to be slighty varying compared to the evaluation metrics
original dataset. This might be case as we also collected the dataset from a competetive website as done by the authoes  but not the real one. Evlauting for the 
enterprise level code clones may give us a different results as the structure of the code may vary.
