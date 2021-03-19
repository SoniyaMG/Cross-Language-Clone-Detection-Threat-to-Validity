# Cross-Language-Clone-Detection-Threat-to-Validity
Address the threat of cross language clone detection model


As mentioned by the authors of the paper, the data used for training and testing the clone-detection model is from a competitive source
(https://atcoder.jp). Moreover, the data is taken are from the beginner level contests of this site.
There are two possible ways to address this threat to validity: one proposed by authors and one by our team.
As suggested by the authors, training/fine-tuning the model with the real-world data.
This is far beyond the infrastructure of the team and it does not seem feasible.
So we as a team has decided to collect small dataset from various coding websites, manually annotate them and validate against
the trained model. Furthermore, we will observe how this model differs in detecting the clones for the different dataset.\


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


## Requirements: <br />
**Hardware:** <br />
* Storage space required: 1-2 GB <br />
* Memory reuired: Minimum 4GB (or more to process faster) <br />

**Software:** <br />
* OS: Windows/linux <br />
* python 3.6.2 <br />
* [Anaconda][11] application <br />
* [Docker][5] application <br />


Below are the steps to evalute the model for the new dataset.

## 0. Environment setup

To run the project we need `python=3.6.2` So we recommend to setup a virtual environment.
We used conda to create the virtual environment(takes considerable amount of time).
But feel free to use any.

setup and activate the environment
```
conda create -n msr_venv python=3.6.2 anaconda
conda activate msr_venv
```
Once the environment is setup, download the repository and `cd` to the [`process`][16] folder inside project root folder and run below
commands
```
pip install -r requirements.txt
python setup.py develop
```


There are two major steps of this research experiment to address the threat

1. Small dataset preparation 
2. Evaluate the Code Clone Detection model for the new small dataset

The dataset is already placed in data/docker-generated-dataset
Now, to preprocess the data we will use [Docker][1].
The Docker image is available as [`tuvistavie/bigcode-tools`][2]

To install it, you can run

```
docker run tuvistavie/bigcode-tools ls
```
Note that download might take a while.

#### 1. Setting up workspace for pre-processed data
 
 We will use `docker-generated-data` folder within `data` folder to store all the data genarated from running the docker commands. 
 Make sure you are still under `process` folder.
```
export DOCKER_GENERATED_DATA=${PWD%/*}/data/docker-generated-data
```

To reduce Docker command boilerplate, we will alias the `run` command as follows

```
alias docker-bigcode='docker run -p 6006:6006 -v $DOCKER_GENERATED_DATA:/bigcode-tools/workspace tuvistavie/bigcode-tools'
```

This will map the container `/bigcode-tools/workspace` directory to the host `$DOCKER_GENERATED_DATA`
directory, and expose the container port `6006` to the same port on the host.

#### 2. Preprocessing the data

We will now generate the ASTs for all the data.

```
docker-bigcode bigcode-astgen-java --batch -o workspace/java-asts 'workspace/repositories/**/*.java'
```

This will create three files:

1. `$DOCKER_GENERATED_DATA/java-asts.json`: list of ASTs as documented in [bigcode-astgen](../bigcode-astgen/README.md)
2. `$DOCKER_GENERATED_DATA/java-asts.txt`: the name of the file from which each AST was extracted
3. `$DOCKER_GENERATED_DATA/java-asts_failed.txt`: the list of files for which parse failed 

Similarly generate the ASTs for python 
```
bigcode-astgen-py --batch -o ../data/docker-generated-data/python-asts "../data/docker-generated-data/code_clones/*.py"
```
This will create three files:

1. `$DOCKER_GENERATED_DATA/python-asts.json`: list of ASTs as documented in [bigcode-astgen](../bigcode-astgen/README.md)
2. `$DOCKER_GENERATED_DATA/python-asts.txt`: the name of the file from which each AST was extracted
3. `$DOCKER_GENERATED_DATA/python-asts_failed.txt`: the list of files for which parse failed 

#### 3. Generating embeddings

First, we will generate a vocabulary.

```
docker-bigcode bigcode-ast-tools generate-vocabulary --strip-identifiers -o workspace/java-vocabulary.tsv workspace/java-asts.json
```

This should generate `$DOCKER_GENERATED_DATA/java-vocabulary.tsv`.



