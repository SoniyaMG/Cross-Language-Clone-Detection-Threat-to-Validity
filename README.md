# Research Experiment to Address the Threat to Validity
This research experiment is a part of Mining Software Repository course where this project follows the reproduction project of cross language clone detection model and tries to address the threat of cross language clone detection model.


# Baseline


## Metadata: <br />

This is a part of the MSR course at MSR course 2020/21 at UniKo, CS department, SoftLang Team. <br />

**Title:** Cross-language clone detection by learning over abstract syntax trees (https://static.perez.sh/research/2019/cross-language-clone-detection/clone-detection-msr19.pdf)<br />

**DBLP link:** https://dblp.org/rec/conf/msr/PerezC19.html?view=bibtex <br />

## Requirements: <br />
**Hardware:** <br />
* Storage space required: 1-2 GB <br />
* Memory reuired: Minimum 4GB (or more to process faster) <br />

**Software:** <br />
* OS: Windows/linux <br />
* python 3.6.2 <br />
* [Anaconda][11] application <br />
* [Docker][5] application <br />

## Process: <br />
**Steps:**

Here are the steps to reproduce the paper on [linux][1](macOS) and on [Windows][8] system. <br />


**Validation:** <br/>

* To directly evaluate the model, generate the training/validation/test dataset in step 1 and test the model in step 3 under the [Training and evaluating code clone detection model][2]. <br/>
* The performance of the model is measured in terms of accuracy, recall and precision. After evaluating the model, a [result.json][9] file will be created that describes the performance metrics. Also the training log can be found [here][10].

## Data: <br />
**Input data:** <br /> 
1. Token leven vector generation [dataset][4]: <br/>
Two different datasets are used which contains the source code of projects in Java and python language. This dataset is used to generate token leven vectors for java and python.(Since the dataset is huge around 1 GB, we are not storing in repository. We ask you to download it in the reproduction steps.)<br/> 
* Java dataset: Contains all java projects(count- 1027) available on Github in the Apache organization(463 MB) <br/> 
* Python data: Contains popular python projects(count- 879) available on Github (204 MB)  <br/>

2. Code clones [dataset][4]: <br/>
This dataset contains the code fragments available in java and python along with the label whether the two code fragments are similar or not. This information is 
not readily available and thus we used the java and python code clone dataset created by the developers. <br/>


**Temporary data:** <br />
1. With the available input data, training data (target,context pairs) for both Java and Python is prepared in order to generate token-level vectors. <br/>
2. Generating the embeddings for the tokens in python and java code using skipgram model.  <br/>
    * Token level embeddings of java code
    * Token level embeddings of python code
3. Java-python code fragment pairs to train LSTM model that detects clones accross java and python code. <br/>

You can find the [architecture][6] of token-level vector generation.

**Output data:**<br />

Weights of the LSTM model to detect clones is produced. This file can be used to evaluate the model. <br/>
The architecture/overview of the clone detection model can be found [here][7]. <br/>


## Delta:<br />
**Process delta:** <br />
1. In this paper, authors tried with different hyperparameters for generating training data for token vector generation model with respect to window size of ancestors and descendants to learn representation for the tokens of ASTs. <br/>
As mentioned in papaer, authors tried with<br/> 
* Ancestors window size: 0 to 5 <br/>
* Descendants window size: 0 to 4  <br/>
* Siblings included: yes and no <br/>
* Output vector dimension: 10, 20, 50, 100 and 200 <br/>

Finally they chose the parameters that works best for generating the embeddings. <br/>
* Ancestors window size: 2 <br/>
* Descendants window size: 1 <br/>
* Siblings included: no <br/>
* Output vector dimension: 50 <br/>

We have followed all the steps from generating dataset to training cross language clone detection model using only the best parameters. <br/>

2. The paper also presents few baseline models (such as Randomly initialized token vectors, pre-trained token vectors without values) in order to evaluate 
the importance of the structure of ASTs in training the model. We have reproduced the actual model but not baseline models. Below are the hyperparameters of the 
code clone detection model used by the authors: <br/>

* Token vector dimension: 100 <br/>
* Encoder layer: bidirectional LSTM, stacked with 2 layers <br/>
* layer dimensions: 100 and 50 <br/>
* Classifier single hidden layer: 64 units <br/>
* Optimizer: RMSprop <br/>
* Epochs: 50  <br/>

We trained the model with 5 epochs as it took considerably large amount of time (36 hours) keeping other hyperparameters same. <br/>


**Data delta:** <br />

1. As mentioned in the paper, we generated the sample of java and python repositories and also
the ASTs and vocabulary files for both. But this vocabulary file was not good enough to train the skipgram model. <br/>
So we tried to generate the vocabulary from the larger python and java repositories given [here][4]. Since the dataset was huge, we faced java.lang.OutOfMemoryError. So we used the the ASTs and the vocabulary files alone
provided by the developer. Using these files, we continued with generating skipgram data and so on. <br/>
So in a nutshell, we mimicked the complete process from generating the input dataset to training the code clone detection model. Instead of using the ASTs and vocabulary files we generated, we used the files provided by the developer and continued with the remaining steps. 

2. To train the code clone fragments with java-python pairs, we used the clone dataset provided by the authors/developers. 


# Experiment

## Threat

 The main threat in this paper is the dataset used to test the model (External Data Validity Threat).
 
 
## Traces: (From the research paper itself)

"The main threat of validity is that the data we used to test our model is vastly different from the data we could
expect in a real-world system. As detailed in IV-A, we used data from competitive programming problems to train and test
our model. Although the number of lines per code fragment in our dataset is relatively close to the one of a typical
function, competitive programming has some particularities. For example, variable names are often less meaningful that
in production code. Furthermore, the tasks solved by the program being extremely well-defined, it is easier for two
programs solving the same problem to look very similar than two functions in a typical code base."


## Theory

As mentioned by the authors of the paper, the data used for training and testing the clone-detection model is from a competitive source
(https://atcoder.jp). Moreover, the data is taken are from the beginner level contests of this site.

There are two possible ways to address this threat to validity: one proposed by authors and one by our team.
As suggested by the authors, training/fine-tuning the model with the real-world data.
This is far beyond the infrastructure of the team and it does not seem feasible.
So we as a team has decided to collect small dataset from various coding websites, manually annotate them and validate against
the trained model. Furthermore, we will observe how this model differs in detecting the clones for the different dataset.

## Feasibility

Collecting the code clones from the enterprise level projects may not be feasible as it is hard to identify the code clones. Thus we evaluate the model with a different dataset to see how well the model works for a different dataset.


## Implementation

Below are the steps that we followed to address the mentioned threat.

1. We collected a small dataset of 100 java-python code clones from various coding websites such as Codechef (https://www.codechef.com/),
Hackerrank (https://www.hackerrank.com/) and geeks for geeks (https://www.geeksforgeeks.org/). 
In order to avoid the out of vocabulary(AST nodes) error  and also to have the embedding of the AST nodes when evaluating the model with a new dataset, we generate embedding of AST nodes by training the skipgram model.
2. We generated the ASTs for this dataset. However, there were some errors in generating ASTs for some projects so we excluded those projects (Ended up with almost 90 projects).
3. We generated the vocabulary for these ASTs for both java and python
4. Now, to generate the embeddings for these AST nodes, Initially we generated Skipgram data for both 
5. Trained the skipgram model with the generated skipgram data and get the embeddings for the ASTs
6. Created a database with the ASTs of all projects
7. Finally, we evaluated the previusly trained code clone detection weights with our small dataset 


Below are the step by step commands in linux (macOS) to evalute the model for the new dataset.


### 0. Environment setup

To run the project we need `python=3.6.2` So we recommend to setup a virtual environment.
We used conda to create the virtual environment(takes considerable amount of time).
But feel free to use any.

setup and activate the environment
```
conda create -n msr_venv python=3.6.2 anaconda
conda activate msr_venv
```
Once the environment is setup, download the repository and `cd` to the `process` folder inside project root folder and run below
commands
```
pip install -r requirements.txt
python setup.py develop
```


There are two major steps of this research experiment to address the threat

1. Small dataset preparation 
2. Evaluate the Code Clone Detection model for the new small dataset

The dataset is already placed in data/docker-generated-dataset

Now, to preprocess the data we will use [Docker][2].
The Docker image is available as [`tuvistavie/bigcode-tools`][3]

To install it, you can run

```
docker run tuvistavie/bigcode-tools ls
```
Note that download might take a while.

### 1. Setting up workspace for pre-processed data
 
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

### 2. Preprocessing the data

We will now generate the ASTs for all the data.

```
docker-bigcode bigcode-astgen-java --batch -o workspace/java-asts 'workspace/code_clones/*.java'
```

This will create three files:

1. `$DOCKER_GENERATED_DATA/java-asts.json`: list of ASTs as documented in [bigcode-astgen](../bigcode-astgen/README.md)
2. `$DOCKER_GENERATED_DATA/java-asts.txt`: the name of the file from which each AST was extracted
3. `$DOCKER_GENERATED_DATA/java-asts_failed.txt`: the list of files for which parse failed 

Similarly generate the ASTs for python 
```
docker-bigcode bigcode-astgen-py --batch -o workspace/python-asts 'workspace/code_clones/*.py'
```
This will create three files:

1. `$DOCKER_GENERATED_DATA/python-asts.json`: list of ASTs as documented in [bigcode-astgen](../bigcode-astgen/README.md)
2. `$DOCKER_GENERATED_DATA/python-asts.txt`: the name of the file from which each AST was extracted
3. `$DOCKER_GENERATED_DATA/python-asts_failed.txt`: the list of files for which parse failed 

### 3. Generating embeddings

First, we will generate a vocabulary.

```
docker-bigcode bigcode-ast-tools generate-vocabulary --strip-identifiers -o workspace/java-vocab.tsv workspace/java-asts.json
```

This should generate `$DOCKER_GENERATED_DATA/java-vocab.tsv`.

Similarly, we generate the vocabulary for python projects.

```
docker-bigcode bigcode-ast-tools generate-vocabulary --strip-identifiers -o workspace/python-vocab.tsv workspace/python-asts.json
```

Now, we will generate [skipgram][6] like data for Java and Python to train our model. <br/>
Run the below commands to generate the training data for Java 

```
mkdir $DOCKER_GENERATED_DATA/java-skipgram-data
docker-bigcode bigcode-ast-tools generate-skipgram-data -v workspace/java-vocab.tsv --ancestors-window-size 2 --children-window-size 1 --without-siblings -o workspace/java-skipgram-data/skipgram-data workspace/java-asts.json
```
This will create `$DOCKER_GENERATED_DATA/java-skipgram-data/skipgram-data-001.txt.gz`
(the number of files created depends on the number of cores)

we will follow the similar process for generating training data for Python

```
mkdir $DOCKER_GENERATED_DATA/python-skipgram-data
docker-bigcode bigcode-ast-tools generate-skipgram-data -v workspace/python-vocab.tsv --ancestors-window-size 2 --children-window-size 1 --without-siblings -o workspace/python-skipgram-data/skipgram-data workspace/python-asts.json
```

We will now learn 50 dimensions embeddings on this data. <br/>
For Java run below commands<br/>

```
docker-bigcode sh -c "bigcode-embeddings train -o workspace/java-embeddings --vocab-size=10000 --emb-size=50 --optimizer=gradient-descent --batch-size=64 workspace/java-skipgram-data/skipgram-data*"
JAVA_MODEL_NAME=$(basename $(ls $DOCKER_GENERATED_DATA/java-embeddings/embeddings.bin-* | tail -n1) ".meta")
docker-bigcode bigcode-embeddings export workspace/java-embeddings/$JAVA_MODEL_NAME  -o workspace/java-embeddings.npy
```

For Python run below commands<br/>

```

docker-bigcode sh -c "bigcode-embeddings train -o workspace/python-embeddings --vocab-size=10000 --emb-size=50 --optimizer=gradient-descent --batch-size=64 workspace/python-skipgram-data/skipgram-data*"
PYTHON_MODEL_NAME=$(basename $(ls $DOCKER_GENERATED_DATA/python-embeddings/embeddings.bin-* | tail -n1) ".meta")
docker-bigcode bigcode-embeddings export workspace/python-embeddings/$PYTHON_MODEL_NAME  -o workspace/python-embeddings.npy
```
With this, we now have the  embeddings for Java and Python tokens which are saved as java-embeddings.npy and python-embeddings.npy respectively in the folder `$DOCKER_GENERATED_DATA`. This will prevent from 'Out of Vocabulary' error when evaluting the model with a new dataset.

Now we create a database file to place the ASTs and other meta data information of all the projects.
Run the below code to create DB from Submissions ASTs file.

```
python create_submission_asts_files.py
python scripts/create_submissions.py
```
### 4. Evaluate the model with a new dataset

Run the below commands to evaluate the model using the previously trained weights with the new dataset.
```
./bin/suplearn-clone generate-dataset -c config.yml
./bin/suplearn-clone evaluate -c config.yml -m trained-model.h5 --data-type=test -o final_results.json
```
## Results
The evaluation metrics such as accuracy and average precision will be saved in Json file in `process/final_results.json`.

We noticed that the accuracy and precision for our new small dataset is 0.513 and 0.506 respectively. This result seems to be almost same compared to the evaluation metrics of the original dataset. Though we use different dataset collected from various websites for testing, the model is able to identify the clones.  
Evaluting for the enterprise level code clones may give us a different results as the structure of the code may vary.


## Process

We followed a similar method to generate the embeddings of AST nodes (Vocubulary) for a different dataset. Later, evaluated with the trained weights from Assignment 2 for the new dataset.

## Data

A small dataset of 100 java-python code clones are collected from different websites and placed under `$DOCKER_GENERATED_DATA`. ASTs are generated for these clones and further used to evaluate the model.

[1]: https://github.com/nagaraj-bahubali/Cross-Language-Clone-Detection/blob/master/doc/README.md
[2]: https://github.com/nagaraj-bahubali/Cross-Language-Clone-Detection/blob/master/doc/README.md#2-training-and-evaluating-the-code-clone-detection-model
[3]: https://cloud.uni-koblenz-landau.de/s/8iwYX7MfnkifxRM
[4]: https://daniel.perez.sh/research/2019/cross-language-clones/
[5]: https://docs.docker.com/desktop/
[6]: https://github.com/nagaraj-bahubali/Cross-Language-Clone-Detection/blob/master/doc/token-embeddings-generation.png
[7]: https://github.com/nagaraj-bahubali/Cross-Language-Clone-Detection/blob/master/doc/clone-detection.png
[8]: https://github.com/nagaraj-bahubali/Cross-Language-Clone-Detection/blob/master/doc/Windows/README.md
[9]: https://github.com/nagaraj-bahubali/Cross-Language-Clone-Detection/blob/master/data/results.json
[10]: https://github.com/nagaraj-bahubali/Cross-Language-Clone-Detection/blob/master/data/Training%20output.txt
[11]: https://www.anaconda.com/products/individual#Downloads
