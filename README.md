# Research Experiment to Address the Threat to Validity
This research experiment is a part of Mining Software Repository course where this project follows the reproduction project of [cross language clone detection model][1] and tries to address the threat of cross language clone detection model.


As mentioned by the authors of the paper, the data used for training and testing the clone-detection model is from a competitive source
(https://atcoder.jp). Moreover, the data is taken are from the beginner level contests of this site.
There are two possible ways to address this threat to validity: one proposed by authors and one by our team.
As suggested by the authors, training/fine-tuning the model with the real-world data.
This is far beyond the infrastructure of the team and it does not seem feasible.
So we as a team has decided to collect small dataset from various coding websites, manually annotate them and validate against
the trained model. Furthermore, we will observe how this model differs in detecting the clones for the different dataset.\


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

We noticed that the accuracy and precision for our new small dataset is 0.513 and 0.506 respectively. This result seems to be almost same compared to the evaluation metrics original dataset. This might be case as we also collected the dataset from a competetive website as done by the authors rather than a real time projects. Evlauting for the enterprise level code clones may give us a different results as the structure of the code may vary.


## Requirements: <br />
**Hardware:** <br />
* Storage space required: 1-2 GB <br />
* Memory reuired: Minimum 4GB (or more to process faster) <br />

**Software:** <br />
* OS: Windows/linux <br />
* python 3.6.2 <br />
* [Anaconda][11] application <br />
* [Docker][5] application <br />

Below are the steps to evalute the model for the new dataset in linux[macOS].

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

Now, to preprocess the data we will use [Docker][2].
The Docker image is available as [`tuvistavie/bigcode-tools`][3]

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

#### 3. Generating embeddings

First, we will generate a vocabulary.

```
docker-bigcode bigcode-ast-tools generate-vocabulary --strip-identifiers -o workspace/java-vocab.tsv workspace/java-asts.json
```

This should generate `$DOCKER_GENERATED_DATA/java-vocabulary.tsv`.

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
#### 4. Evaluate the model with a new dataset

Run the below commands to evaluate the model using the previously trained weights with the new dataset.
```
./bin/suplearn-clone generate-dataset -c config.yml
./bin/suplearn-clone evaluate -c config.yml -m trained-model.h5 --data-type=test -o final_results.json
```

The evaluation metrics such as accuracy and average precision will be saved in Json file in `process/final_results.json`

[1]: https://github.com/nagaraj-bahubali/Cross-Language-Clone-Detection
[2]: https://docs.docker.com/engine/installation/
[3]: https://hub.docker.com/r/tuvistavie/bigcode-tools/
[5]: https://docs.docker.com/desktop/
[6]: https://www.tensorflow.org/tutorials/word2vec
[11]: https://www.anaconda.com/products/individual#Downloads
[16]: https://github.com/SoniyaMG/Cross-Language-Clone-Detection-Threat-to-Validity
