# essay_abs_fintech

This project is the design implementation part of the essay which for apply Master degree of ZJU by Matthew Yiqing Zhu(朱逸清)

## Statement：

This source code just to implement the design of the Essay:  
Research of asset-backed securitization ecology based on fintech. 
So it not follow the software engining rule in strict way, such as naming space,reusage pattern or avoid hard code. Do not use it in software engining lesson (or you want to teach some nagetive example). 
And now it's only work for the localhost. 
Warning: the data will lost after the applications restart because it's need simulated some senario in the essay. So do not expacted the data will be restore after restart. 
You can contact drmatthew1982@163.com if need some discussion. 

## Usage:

### 1. Starting:
#### 1.1) Start the block chain applications (abs_a_masterChain is not used yet)
abs_a_capitalChain (Stater class:com.v5ent.A_Capital_SparkWeb)  
abs_a_reputationChain(Stater class:com.v5ent.A_Master_SparkWeb)  
abs_a_valueChain(Stater class:com.v5ent.A_Ruputation_SparkWeb)  

#### 1.2) Start the server application
SimulatedServer (Stater class: net.matthew.app.ServerApplication)  

#### 1.3) Start the client applications (SimulatedAI is not used yet)
SimulatedAdmin (Stater class: net.matthew.app.SimulatedAdminApplication)  
SimulatedClient (Stater class: net.matthew.app.ClientApplication)  

### 2. Visiting:
#### 2.1) Visit the block chain application as raw data
capitalChain: http://localhost:4568  
reputationChain: http://localhost:4569  
valueChain: http://localhost:4570  

#### 2.2) Visit the Admin and Client
Admin: http://localhost:8081  
Client: http://localhost:8082  
