# essay_abs_fintech

This project is the design implementation part of the essay which for apply Master degree of ZJU 
Essay name 基于国内市场资产证券化风险事件分析与区块链应用的金融科技设计

## Statement：

This source code just to implement the design of the Essay:   
"Fintech Design based on China Market’s ABS Risk Cases Analysis and Blockchain’s Application".     
So it not follow the software engining rule in strict way, such as naming space,reusage pattern or avoid hard code. Do not use it in software engining lesson (or you want to teach some nagetive example).   
And now it's only work for the localhost.   
Warning: the data will lost after the applications restart because it's need simulated some senario in the essay. So do not expacted the data will be restore after restart.   
The blockchain base part is refer to https://github.com/Mignet/blockchain and I do some changing on the code.  
You can contact drmatthew1982@163.com if need some discussion.   

## Usage:

### 0. Perparing
When you are here, I belive you have some knowledge of finicial such as ABS, CDO, CDOs  
You also need have knowledge of Java, Git, Mavan, IDE usage (such as Eclipse or other you like)  

### 1. Download
Download the code in your local via git tools, or via IDE plugin (such as EGit in Eclispe). 
Importing the project into your IDE such as Eclipse or IDEA
Make sure the projects are configurated as Maven and Java projects

### 2. Starting:
#### 2.1) Start the block chain applications (abs_a_masterChain is not used yet)
abs_a_bankrecordChain (Starter class:com.v5ent.A_Bankrecord_SparkWeb)   
abs_a_rankChain (Starter class:com.v5ent.A_Rank_SparkWeb)   
abs_a_cdoChain (Starter class:com.v5ent.A_CDO_SparkWeb)   
abs_a_cdosChain (Starter class:com.v5ent.A_CDOs_SparkWeb)   
abs_a_capitalChain (Starter class:com.v5ent.A_Capital_SparkWeb)  
abs_a_reputationChain (Starter class:com.v5ent.A_Master_SparkWeb)  
abs_a_valueChain (Starter class:com.v5ent.A_Ruputation_SparkWeb)  

#### 2.2) Start the server application
SimulatedServer (Starter class: net.matthew.app.ServerApplication)    
SimulatedBank (Starter class: net.matthew.app.SimulatedBankApplication)    
SimulatedAI (Starter class: net.matthew.app.SimulatedAIApplication)  

#### 2.3) Start the client applications (SimulatedAI is not used yet)
SimulatedAdmin (Starter class: net.matthew.app.SimulatedAdminApplication)    
SimulatedClient (Starter class: net.matthew.app.ClientApplication)  

### 3. Visiting:
#### 3.1) Visit the block chain application as raw data
abs_a_bankrecordChain: http://localhost:4571  
abs_a_rankChain: http://localhost:4574  
abs_a_cdoChain: http://localhost:4572  
abs_a_cdosChain: http://localhost:4573   
capitalChain: http://localhost:4568    
reputationChain: http://localhost:4569    
valueChain: http://localhost:4570  

#### 4.2) Visit the Admin and Client
SimulatedBank: http://localhost:8083    
SimulatedAI: http://localhost:8084   
Admin: http://localhost:8081    
Client: http://localhost:8082    
