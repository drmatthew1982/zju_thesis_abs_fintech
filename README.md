# zju_thesis_abs_fintech

## 声明 Statement：

这个项目的源码仅适用于申请浙江大学同等学历硕士论文    
论文名称：基于国内市场资产证券化风险事件分析与区块链应用的金融科技设计      
导师：浙江大学罗德明教授，作者：朱逸清  
由于代码主要为了解决论文中提及的问题，本项目的源码没有100%的严格的遵照软件工程的规则，比如命名、重用、和硬编码避规等  
目前仅仅可以在localhost域名下工作  
警告：为了模拟论文中的场景，当相关的应用重启时，数据会丢失。所以重启后无法恢复数据     
区块链部分，参考了 https://github.com/Mignet/blockchain 的代码并做了对应修改以符合论文需要。  
隐名期间，如评阅老师们有任何问题，请通过学校联系我，谢谢。

This source code just to implement the design of the Essay:   
"Fintech Design based on China Market’s ABS Risk Cases Analysis and Blockchain’s Application".     
For the propose solving the problems which mentioned in essay. So it not follow the software engining rule in fully strict way, such as naming space,reusage pattern or avoid hard code.  
And now it's only work for the localhost.   
Warning: the data will lost after the applications restart because it's need simulated some senario in the essay. So do not expacted the data will be restore after restart.   
The blockchain base part is refer to https://github.com/Mignet/blockchain and I do some changing on the code.  
Dear reviewers, You can contact me via school if need some discussion.    

## 代码的使用 Usage:

此处仅作技术方面一个说明，包括下载和启动，对于业务方面未作详细说明的部分，请参阅论文

### 0. 准备 Perparing
为了了解业务，需要准备一些关于ABS, CDO, CDOs以及相关金融知识   
如需要运行代码，需要一些开发知识，比如Java, Git, Mavan等，以及会使用图形开发界面（IDE） (比如Eclipse、IDEA等)  

When you are here, I belive you have some knowledge of finicial such as ABS, CDO, CDOs  
You also need have knowledge of Java, Git, Mavan, IDE usage (such as Eclipse、IDEA or other you like)  

### 1.下载 Download
通过Git工具或者IDE工具的插件(Eclispe的EGit)下载代码至本地环境
将代码导入到本地IDE，比如Eclipse/IDEA
确定项目被设置为Maven/Java项目

Download the code in your local via git tools, or via IDE plugin (such as EGit in Eclispe). 
Importing the project into your IDE such as Eclipse or IDEA
Make sure the projects are configurated as Maven and Java projects

### 2. 启动 Starting:
#### 2.1) 启动区块链应用（目前的场景，不需要启动abs_a_masterChain）：Start the block chain applications (abs_a_masterChain is not used yet)
abs_a_bankrecordChain (Starter class:com.v5ent.A_Bankrecord_SparkWeb)   
abs_a_rankChain (Starter class:com.v5ent.A_Rank_SparkWeb)   
abs_a_cdoChain (Starter class:com.v5ent.A_CDO_SparkWeb)   
abs_a_cdosChain (Starter class:com.v5ent.A_CDOs_SparkWeb)   
abs_a_capitalChain (Starter class:com.v5ent.A_Capital_SparkWeb)  
abs_a_reputationChain (Starter class:com.v5ent.A_Master_SparkWeb)  
abs_a_valueChain (Starter class:com.v5ent.A_Ruputation_SparkWeb)  

#### 2.2) 启动服务器应用 Start the server application
SimulatedServer (Starter class: net.matthew.app.ServerApplication)    
SimulatedBank (Starter class: net.matthew.app.SimulatedBankApplication)    
SimulatedAI (Starter class: net.matthew.app.SimulatedAIApplication)  

#### 2.3) 启动客户端应用 Start the client applications
SimulatedAdmin (Starter class: net.matthew.app.SimulatedAdminApplication)    
SimulatedClient (Starter class: net.matthew.app.ClientApplication)  

### 3. 访问 Visiting:
#### 3.1) 以原始数据的形式访问区块链 Visit the block chain application as raw data
abs_a_bankrecordChain: http://localhost:4571  
abs_a_rankChain: http://localhost:4574  
abs_a_cdoChain: http://localhost:4572  
abs_a_cdosChain: http://localhost:4573   
capitalChain: http://localhost:4568    
reputationChain: http://localhost:4569    
valueChain: http://localhost:4570  

#### 4.2) 访问管理界面和客户端界面 Visit the Admin and Client
SimulatedBank: http://localhost:8083    
SimulatedAI: http://localhost:8084   
Admin: http://localhost:8081    
Client: http://localhost:8082    
