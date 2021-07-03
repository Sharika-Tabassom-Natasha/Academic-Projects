![](RackMultipart20210703-4-6lj9ha_html_6c9f7d05b8f45e33.png)

# **Neural Network Based Color Detection System**


## **Introduction**

### **1.1 Definition**
Color detection is the process by which the names of the colors can be identified. Though this seems to be a very easy task, it is very difficult for computers. 
Color detection has many applications. But one of the best applications of color detection is for color blind people. Color blindness happens in the retinal of 
eyes by which the patient cannot recognize or differentiate certain colors. The disability of the patient causes problems in daily life. Color blind cannot be cured. 
Therefore, the only method to help color blind is the color detection method. This will help them to detect the color easily. In our experiment, we have used Neural 
Network model.

### **1.2 Motivation**
Color detection is mainly used in many applications which are based on color information. For example, in road sign detection, the color is the main part. 
Moreover, for face detection or skin color detection, the primary stage is to detect the color. And the color detection methods are mainly beneficial for color 
blind people. In this world, where everything has become technology dependent, but it still lags for blind people in many cases. Color blind people cannot 
distinguish between colors. And because of this, they are neglected from many professional jobs even though they are much capable from others. So this has motivated 
us a lot to do this work.

### **1.3 Challenges**
In ourexperiment, we have faced a couple of challenges which we had to overcome. The challenges are mentioned below:
- **Accuracy Improvement:** In our experiment, we had to do almost 45 experiments just to improve the accuracy. During these experiments, 
- we have used 45 types of hyperparameters for tuning.
- **Dataset:** Our dataset of CSV file is string format on label content. So, we had to do label encoding to convert it numerical. Moreover, 
- the value of the features were on a large scale. So we had to normalize it to keep it in a range.



## **Related Works**

### **2.1 List of related works**
List some important related works are mentioned below
- Basic Geometric Shape and primary colour detection using image processing on Matlab: Shambhavi Vijay Chhaya, Sachin Khera , Pradeep Kumar S [4]
- An Efficient Color Detection in RGB Space Using Hierarchical Neural Network Structure: Halis Altun, Recai Sinekli, Ugur Tekbas, Fuat Karakaya, Murat Peker[2]
- An Image Processing Technique for Color Detection and Distinguish Patterns with Similar Color: An aid for Color Blind People: Bhagya R Navada, Santhosh K V , Prajwal S, Harikishan B Shetty[3]
- Color Recognition System with Augmented Reality Concept and Finger Interaction: Alfa Sheffildi Manaf, Riri Fitri Sari[1]

### **2.2 Summary of previous works**
- Altun et al[3] have proposed an Efficient Color Detection in RGB Space where Hierarchical Neural Network Structure has been used. In this structure, a set of experts is assigned to evaluate R, G, B components of a pixel and then constructs a degree of membership to the set of predefined class of colors for the given pixel. Then a master neural network constructs its final decision based on the membership probabilities provided by the set of experts.
- An attempt is made for designing a prototype in aid for color blind people in detecting color and edges of a given image which are of similar colors. Image processing technique is used in proposed work to develop a setup for identifying the colors in an image and indicating the edges in case of different images with similar colors. Image processing involve two parts, first is color detection and the second is edge detection which is carried out on a LabVIEW platform.
- Manaf et al[1] have created a color blind aid system for embedded platform based on Windows embedded standard 2009, .Net Framework, OpenCV library and EmguCV wrapper. Moreover, a sound augmented reality concept and finger interaction between user and colored object have been developed.

### **2.3 Our Work**
Our project is for color blind people which gives a better accuracy than the existing work.In our project, we have a data file as dataset which contains the 
color names and its values. It calculates the distance from each color and finds the shortest one. We have used Neural Network to do our experiment. Here we all 
know that a neural network is a series of algorithms that recognizes underlying relationships in a set of data through a process that mimics the way the human 
brain operates. Our dataset is a CSV file where there are 865 color names along with their RGB and Hex values. Our Neural Network model is of four hidden layers, 
two input layers and one output layer.


## **Project Objectives**

In this section, a color detection model is proposed owing to the drawbacks of the existing models. The proposed method is designed by comprising four 
steps, namely, data extraction, data normalization, training model, and testing model. The simplified diagram of the proposed method along with a brief 
discussion is shown in Fig.1.

<p align="center"><img src="https://user-images.githubusercontent.com/63575456/124364588-4f49a980-dc64-11eb-899c-d486c9d43f66.png" alt="alt text" width="500px" height="350px"></p>
<p align="center"> Fig.1: Graphical representation of the proposed method </p>

### **3.1 Data Extraction**
To implement the color detection system first RGB and label values are extracted from the dataset. In the dataset, the RGB values are in numerical format 
but the labels are in string format. As it is known that at the gist of any machine learning model, there are several numerical equations including calculus, 
linear algebra, probability, and so on. So, the labels needed to be converted to the numerical format. To do so label encoding was used that assigned unique 
integer values to the classes. The python command for label encoding is shown in Fig.2 and the encoded dataset is given in Table.1.


<p ><img src="https://user-images.githubusercontent.com/63575456/124364850-efec9900-dc65-11eb-9d26-556968de52f2.png" alt="alt text" width="600px" height="50px">
<p > Fig.2: Python command for label encoding </p></p>


**Table.1:** Label Encoded Dataset
| **Index** | **Red** | **Green** | **Blue** | **Label** |
| --- | --- | --- | --- | --- |
| 0 | 20 | 139 | 240 | 0 |
| 1 | 174 | 83 | 72 | 1 |
| 2 | 144 | 249 | 131 | 2 |
| 3 | 168 | 25 | 156 | 3 |
| 4 | 30 | 182 | 136 | 2 |
| ... | ... | ... | ... | ... |
| 5051 | 30 | 30 | 30 | 10 |

### **3.2 Data Normalization**
After getting the label encoded dataset the values of the features were normalized. Because features that are in different scales do not participate 
fairly in the model fitting which can create a biased model. To solve this problem the value of the features was brought down to a particular range. 
The python command for normalization is shown in Fig.3 and the normalized dataset is given in Table.2.

<p ><img src="https://user-images.githubusercontent.com/63575456/124364910-70ab9500-dc66-11eb-8b92-e2378ac09978.png" alt="alt text" width="300px" height="150px">
<p > Fig.3: Python command for normalization </p></p>


**Table.2:** Normalized Dataset
| **Index** | **Red** | **Green** | **Blue** | **Label** |
| --- | --- | --- | --- | --- |
| 0 | -1.4525 | -1.4525 | -1.4525 | 0 |
| 1 | 0.6299 | 0.6299 | 0.6299 | 1 |
| 2 | 0.2243 | 0.2243 | 0.2243 | 2 |
| 3 | 0.5488 | 0.5488 | 0.5488 | 3 |
| 4 | -1.3173 | -1.3173 | -1.3173 | 2 |
| ... | ... | ... | ... | ... |
| 5051 | -1.3173 | -1.3173 | -1.3173 | 10 |


### **3.3 Training Model**
In this step, a four-layered neural network was implemented and the dataset was divided into train and test sets. Then the neural network was trained using 
the normalized train set.

### **3.4 Model Prediction**
Finally, the trained neural network was tested using the normalized test set.

### **3.5 Sample Input and Output**
Some sample input and output are given in Table.3 and Table.4. From both the tables, we can see that the model predicted two out of three sample data correctly.

**Table.3:** Sample Input with Actual Output
| **Input** | **Actual Output** |
| --- | --- |
| **Index** | **Red** | **Green** | **Blue** |
| 0 | -0.2085 | -1.5659 | 1.0342 | 6 (Purple) |
| 1 | 0.5082 | 0.6098 | -0.2063 | 2 (Green) |
| 2 | -1.6689 | -1.6326 | -1.6759 | 10 (Black) |


**Table.4:** Sample Input with Predicted Output
| **Input** | **Predicted Output** |
| --- | --- |
| **Index** | **Red** | **Green** | **Blue** |
| 0 | -0.2085 | -1.5659 | 1.0342 | 6 (Purple) |
| 1 | 0.5082 | 0.6098 | -0.2063 | 0 (Blue) |
| 2 | -1.6689 | -1.6326 | -1.6759 | 10 (Black) |



## **Methodology**

Nowadays deep learning algorithms are well known for implementing software with higher accuracies. So to build the color detection system a four-layered neural 
network is introduced. The diagram of the proposed neural network along with a brief discussion is shown in Fig.5.

### **4.1 How we are solving the problem**
In order to implement the color detection system, a four-layered neural network was proposed. The neural network was designed by follows some important steps that are given below:
- The neural network took three neurons in the input layer as the dataset as three features (RGB value of a color).
- Four dedicated layers were used for the hidden layers. For each hidden layer, there was n number of neurons where n is from 24 to 16. As for activation function Relu, Gelu, Softplus, Softsign, etc were applied.
- For the final layer/output layer there were eleven neurons as the dataset has eleven categories of classes.

<p align="center" ><img src="https://user-images.githubusercontent.com/63575456/124365003-1232e680-dc67-11eb-9134-67d3e074fbe1.png" alt="alt text" width="600px" height="350px">
</p > 
<p align="Center" >Fig.4: Python implementation of proposed neural network </p></p>


### **4.2 Neural Network Diagram**
<p align="center" ><img src="https://user-images.githubusercontent.com/63575456/124365079-8b323e00-dc67-11eb-82f8-0c97592a0a98.png" alt="alt text" width="600px" height="550px">
</p > 
<p align="Center" > Fig.5: Four Layered Neural Network </p></p>



## **Experiments**

This section contains the experiments performed on the proposed color detection model to evaluate its performance. First, the dataset setup is analyzed. Second, 
the evaluation metrics are mentioned that are used for validating the proposed model&#39;s performance. Lastly, the best experiments are given that were executed 
by varying the hyperparameters in order to improve the model&#39;s performance.

### **5.1 Dataset Setup**

The RGB dataset[5] was downloaded from a git repository. The dataset contains 5052 RGB values and eleven categories of color/label. 
An overview of the RGB dataset and the eleven categories of color/label are given below in table.5 and table.6.

**Table.5:** Overview of RGB Dataset
| **Index** | **Red** | **Green** | **Blue** | **Label** |
| --- | --- | --- | --- | --- |
| 0 | 20 | 139 | 240 | Blue |
| 1 | 174 | 83 | 72 | Brown |
| 2 | 144 | 249 | 131 | Green |
| 3 | 168 | 25 | 156 | Pink |
| 4 | 30 | 182 | 136 | Green |
| ... | ... | ... | ... | ... |
| 5048 | 27 | 27 | 27 | Black |
| 5049 | 28 | 28 | 28 | Black |
| 5050 | 29 | 29 | 29 | Black |
| 5051 | 30 | 30 | 30 | Black |

**Table.6:** Eleven categories of color/label
| **Index** | **Label** |
| --- | --- |
| 0 | Blue |
| 1 | Brown |
| 2 | Green |
| 3 | Pink |
| 4 | Yellow |
| 5 | Orange |
| 6 | Purple |
| 7 | Red |
| 8 | Grey |
| 9 | White |
| 10 | Black |

Each color/label has a different number of RGB values. In table.7 the number of data in each color/label is provided. And a pie chart as fig.6 is also given for 
better visualization of the dataset.

After collecting the dataset and applying label encoding and data normalization the dataset was split into a train set and test set. Two types of split ratios 
were considered. They were 70:30 ratio and 80:20 ratio. Both the ratio gave satisfactory performances.

**Table.7:** Number of data in each color/label
| **Label** | **Number of data** |
| --- | --- |
| Blue | 1107 |
| Brown | 376 |
| Green | 1457 |
| Pink | 579 |
| Yellow | 285 |
| Orange | 205 |
| Purple | 553 |
| Red | 236 |
| Grey | 174 |
| White | 29 |
| Black | 51 |


<p ><img src="https://user-images.githubusercontent.com/63575456/124365136-dd735f00-dc67-11eb-8904-64d45605a7e2.png" alt="alt text" width="550px" height="400px">
</p > 
<p > Fig.6: Graphical representation of the number of data per color/label </p></p>


### **5.2 Evaluation Metric**
Evaluation metrics are those which are used to measure the quality of statistical or deep learning models. A combination of individual evaluation metrics 
is used to judge any model. The evaluation metrics that are being used in this project to evaluate the color detection system are described below.
- **Accuracy:** Accuracy is one of the evaluation metrics which is actually the ratio of the correct classified data and all classified data. In other words, accuracy is the number of true positives and true negatives divided by the number of true positives, true negatives, false positives, and false negatives.
- **Loss:** In our experiment, we have used cross entropy loss. Cross entropy loss measures the performance of a classification model whose output is a probability value between 0 and 1.


### **5.3 Results**
To improve the performance of the proposed model a total of 45 experiments were conducted by varying the hyperparameter.
The hyperparameters that were used in this experiments are given below:
- Batch Size
- Number of Iteration
- Number of Hidden Layers
- Number of neurons
- Learning Rate
- Activation Function
- Optimizer

From this 45 experiments best three experiment are given below:
**Experiment 1:** In this experiment, hyperparameters that are used to implement the neural network are given in table.8.

**Table.8:** Hyperperemeter for experiment:1
| **Hyperperemeter** | **Value** |
| --- | --- |
| Batch Size | 64 |
| Number of Iteration | 50,000 |
| Number of Hidden Layers | 4 |
| Number of neurons | 24 to 16 |
| Learning Rate | 3e-1 |
| Activation Function | Relu (For all hidden layer) |
| Optimizer | Adam |

Using these hyperparameters the neural network gives an accuracy of 89.5% which is by far the highest accuracy. The graph for loss function and accuracy is given below as fig.7 for better understanding.

<p align="center"><img src="https://user-images.githubusercontent.com/63575456/124365377-72c32300-dc69-11eb-8c93-22cfccf42fda.png" alt="alt text" width="300px" height="250px">
  <img src="https://user-images.githubusercontent.com/63575456/124365400-91291e80-dc69-11eb-9fe2-87df74204927.png" alt="alt text" width="300px" height="250px">
</p > 
<p align="center"> Fig.7: Graphical representation of (a) Cross Entropy Loss, (b) Accuracy </p>



**Experiment 2:** In this experiment, hyperparameters that are used to implement the neural network are given in table.9.

**Table.9:** Hyperperemeter for experiment:2
| **Hyperperemeter** | **Values for Tuning** |
| --- | --- |
| Batch Size | 64 |
| Number of Iteration | 30,000 |
| Number of Hidden Layers | 4 |
| Number of neurons | 32 (For all hidden layer) |
| Learning Rate | 3e-1 |
| Activation Function | Tanh (For all hidden layer) |
| Optimizer | Adam |

Using these hyperparameters the neural network gives an accuracy of 88.11% which is also a satisfactory performance. The graph for loss function and accuracy is given below as fig.7 for better understanding.

<p align="center"><img src="https://user-images.githubusercontent.com/63575456/124365535-8f138f80-dc6a-11eb-871d-21aa0ee71a8f.png" alt="alt text" width="300px" height="250px">
  <img src="https://user-images.githubusercontent.com/63575456/124365538-920e8000-dc6a-11eb-8edd-f712c5e487ca.png" alt="alt text" width="300px" height="250px">
</p >
<p align="center"> Fig.8: Graphical representation of (a) Cross Entropy Loss, (b) Accuracy</p>

**Experiment 3:** In this experiment, hyperparameters that are used to implement the neural network are given in table.10.

**Table.10:** Hyperparameter for experiment:3
| **Hyperperemeter** | **Values for Tuning** |
| --- | --- |
| Batch Size | 64 |
| Number of Iteration | 30,000 |
| Number of Hidden Layers | 4 |
| Number of neurons | 32 to 16 |
| Learning Rate | 3e-1 |
| Activation Function | Relu (For two hidden layer)Gelu(For two hidden layer) |
| Optimizer | Adam |

Using these hyperparameters the neural network gives an accuracy of 88.55%. The graph for loss function and accuracy is given below as fig.7 for better understanding.

<p align="center"><img src="https://user-images.githubusercontent.com/63575456/124365520-773c0b80-dc6a-11eb-93f6-92077790b6c8.png" alt="alt text" width="300px" height="250px">
  <img src="https://user-images.githubusercontent.com/63575456/124365523-7c00bf80-dc6a-11eb-8235-df9cec10d4b9.png" alt="alt text" width="300px" height="250px">
</p >
<p align="center">Fig.9: Graphical representation of (a) Cross Entropy Loss, (b) Accuracy </p>

**Other Experiments:** Some other satisfactory experiments are given in table.11.

**Table.11:** Hyperparameter for experiment:3
| **Index** | **Batch Size** | **Iter. - Num.** | **Neuron Num** | **Learning Rate** | **Num of Hidden Layers** | **Activation Function** | **Optimizer** | **Accuracy** |
| --- | --- | --- | --- | --- | --- | --- | --- | --- |
| 1 | 64 | 30k | 32 | 3E-01 | 4 | Softsign | Adam | 89.24% |
| 2 | 64 | 30k | 32 | 3E-01 | 4 | Gelu | Adam | 89.17% |
| 3 | 64 | 30k | 32 | 3E-01 | 4 | Relu | Adam | 88.71% |
| 4 | 64 | 30k | 32 | 3E-01 | 4 | Silu | Adam | 88.64% |
| 5 | 64 | 30k | 32 | 3E-01 | 4 | Relu6 | Adam | 88.64% |
| 6 | 64 | 30k | 24 | 3E-04 | 3 | Relu | RmsProp | 88.51% |
| 7 | 64 | 30k | 32 - 16 | 3E-01 | 4 | GELU, RELU, Tanh, RELU6 | Adam | 88.32% |
| 8 | 64 | 30k | 24 | 2E-01 | 3 | Relu | Rms | 86.93% |
| 9 | 64 | 30k | 32 | 3E-01 | 4 | ELU | Adam | 86.86% |
| 10 | 64 | 30k | 32 | 3E-01 | 4 | Tanh, Softsign, Softplus, Softsign | Adam | 86.86% |


## **Conclusion**

Color detection is widely used in many applications and it is also an intermediate stage of color image processing. We have implemented the color 
detection using Neural Network model where we have done almost 45 experiments and could get the accuracy of 89% where the activation function is softsign. 
The main aim of this project is that it can help the color blind people a lot. As it will detect the color very easily and it will help the color blind people in 
their professional life and also daily life. In future, we have a plan to build an application or a website to do this color detection.


## **Reference**

1. Manaf, A., and R. Sari. &quot;Color Recognition System with Augmented Reality Concept and Finger Interaction.&quot; _International Conference on ICT and Knowledge Engineering-978-1-4577-2161-8 2011_. 2012.
2. Navada, Bhagya R., et al. &quot;An image processing technique for color detection and distinguish patterns with similar color: An aid for color blind people.&quot; _International Conference on Circuits, Communication, Control and Computing_. IEEE, 2014.
3. Altun, Halis, et al. &quot;An efficient color detection in RGB space using hierarchical neural network structure.&quot; _2011 International Symposium on Innovations in Intelligent Systems and Applications_. IEEE, 2011.
4. Chhaya, Shambhavi Vijay, Sachin Khera, and Pradeep Kumar. &quot;Basic geometric shape and primary color detection using image processing on Matlab.&quot; International Journal of Research in Engineering and Technology 4.5 (2015): 505-509.
5. [RGB Dataset Link](https://drive.google.com/file/d/1xcl8WCoCYGJiWiVr4b1kdR72-PecDCxR/view?usp=sharing)
6. [All 45 experiments based on hyperparameters](https://docs.google.com/document/d/1Ywkha6WQj_SnAJoHCEScVzFm7ITlRyn_AZFVrmWIWi0/edit?usp=sharing)
