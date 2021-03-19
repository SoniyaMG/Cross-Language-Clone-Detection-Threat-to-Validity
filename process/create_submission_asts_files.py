#!/usr/bin/env python
# coding: utf-8

# In[1]:


import json
l= []
for i in range(1,101):
    l.append({"id": str(i),"contest_type": "r","contest_id": 1,"problem_id": i,"language": "java_1.7.0","created_time":"2017/07/26 06:59:53 +0000","problem_title":"B - \u30ea\u30e2\u30b3\u30f3","score": 100,"status":"AC","file":"code_clones/j"+str(i)+".java","source_length":752,"source_length_unit":"Byte","exec_time": 89,"exec_time_unit":"ms","submission_url": "http://arc001.contest.atcoder.jp/submissions/1454244"})
    l.append({"id":"1000"+str(i),"contest_type":"r","contest_id":1,"problem_id":i,"language":"python3_3.4.3","created_time":"2017/05/04 18:30:07 +0000","problem_title":"B - \u30ea\u30e2\u30b3\u30f3","score":100,"status":"AC","file":"code_clones/p"+str(i)+".py","source_length":231,"source_length_unit":"Byte","exec_time":17,"exec_time_unit":"ms","submission_url":"http://arc001.contest.atcoder.jp/submissions/1260853"})


# In[2]:


json.dumps(l)


# In[3]:


with open('submissions.json', 'w') as f:
    f.write(json.dumps(l))


# In[4]:


text_file = open(r"../data/docker-generated-data/java-asts.txt", "r")
lines = text_file.read().split("\n")[:-1]
lines = [x.split('/')[-1] for x in lines]
java_asts_name = [x.split('.')[0][1:] for x in lines]
#print(java_asts_name)
#print(len(java_asts_name))
text_file.close()


# In[6]:


text_file = open(r"../data/docker-generated-data/python-asts.txt", "r")
lines = text_file.read().split("\n")[:-1]
lines = [x.split('/')[-1] for x in lines]
python_asts_name = [x.split('.')[0][1:] for x in lines]
#print(python_asts_name)
#print(len(python_asts_name))
text_file.close()


# In[7]:


common_name = set(java_asts_name).intersection(set(python_asts_name))
#print(common_name)
#len(common_name)


# In[8]:


java_common_index = [java_asts_name.index(x) for x in common_name]
java_common_index = sorted(java_common_index)
#java_common_index


# In[9]:


import json
text_file = open(r"../data/docker-generated-data/java-asts.json", "r")
java_asts = text_file.read().split("\n")[:-1]
java_asts = [x for x in java_asts]
#print(java_asts)
#print(len(java_asts))
text_file.close()
#java_asts[1]


# In[10]:


java_common_asts = [java_asts[x] for x in java_common_index]
#len(java_common_asts)


# In[11]:


asts = "\n".join(java_common_asts)


# In[12]:


python_common_index = [python_asts_name.index(x) for x in common_name]
python_common_index = sorted(python_common_index)
#print(python_common_index)


# In[14]:


text_file = open(r"../data/docker-generated-data/python-asts.json", "r")
python_asts = text_file.read().split("\n")[:-1]
python_asts = [x for x in python_asts]
#print(python_asts)
#print(len(python_asts))
text_file.close()


# In[15]:


python_common_asts = [python_asts[x] for x in python_common_index]
#len(python_common_asts)


# In[16]:


asts += "\n"+"\n".join(python_common_asts)


# In[17]:


with open('asts.json', 'w') as f:
    f.write(asts)


# In[18]:


java_final_names = [java_asts_name[x] for x in java_common_index]
#print(java_final_names)


# In[19]:


python_final_names = [python_asts_name[x] for x in python_common_index]
#print(python_final_names)


# In[20]:


asts_txt = ""
java_final_txt = ""
java_final_txt = [("code_clones/j"+x+".java") for x in java_final_names]
asts_txt = "\n".join(java_final_txt)


# In[21]:


python_final_txt = ""
python_final_txt = [("code_clones/p"+x+".py") for x in python_final_names]
asts_txt += "\n" + "\n".join(python_final_txt)


# In[22]:


with open('asts.txt', 'w') as f:
    f.write(asts_txt)


# In[ ]:




