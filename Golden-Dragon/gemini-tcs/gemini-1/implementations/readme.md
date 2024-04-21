<h1>Implementation Group Golden Dragon </h1>
<br>

<h3>
    ในข้อมูล Readme อยู่ใน file : Readme_implementations.pdf
    โดยกลุ่ม Golden Dragon มีการทำ Docker
</h3>

<p>
1. ในข้อมูล Readme อยู่ใน file : Readme_implementations.pdf
    
  - มีรายละเอียดของ design pattern
    
- มีรายละเอียดของการใช้งาน interface

2.ในข้อมูล Readme อยู่ใน file : gemini with docker Golden Dragon.pdf

 -  มีรายละเอียดการลง Docker file
</p>


<h3>รุปเเบบ path</h3>


    |   gemini-tcs

    ├── gemini-1
    
    │   ├── readme.md
    
    │   ├── designs 

    |       ├── readme.md

    |       ├── Use_Case_Description_Golden_Dragon.pdf

    |       ├── Sequence_Diagram_Golden_Dragon.pdf

    |       ├── Activity_Diagram_Golden_Dragon.pdf

    |       ├── Class_Diagram_Golden_Dragon.pdf

    |       ├── Use_Case_Diagram_Golden_Dragon.pdf

    │   ├── implementations 

    |       ├── readme.md

    |       ├──  gemini with docker Golden Dragon.pdf

    |       ├── Gemini_with_Docker/gemini

    |           ├──ocs.mv
    
    |           ├──build

    |           ├──docker-compose.yml
    
    |           ├──Dockerfile

    |           ├──....

    |           ├──db-init-scripts

    |               ├──testGemini.sql    

    |           ├──src
    
    |              ├──main

    |                  ├──java

    |                  ├──.... 

    
    |       ├── Readme_implementations.pdf    
    
    |       ├── gemini
    
    |           ├──ocs.mv
    
    |           ├──build
    
    |           ├──....

    |           ├──db

    |               ├──Gemini
    
    |           ├──src
    
    |              ├──main
    
    |                  ├──java
    
    |                    ├──com.example.gemini  
    
    |                      ├──Controller 
    
    |                        ├──ObservingProgramController.java   
    
    |                        ├──SciecncePlanController.java      
    
    |                        ├──LoginController.java            
    
    |                      ├──Model 

    |                        ├──Astronomer

    |                        ├──AstronomerRepository

    |                        ├──DataProcessReqModel

    |                        ├──DataProcReqMentRepository

    |                        ├──ObservingProgramModelGDDG

    |                        ├──ObservingProGramRepository

    |                        ├──ScienceObserver

    |                        ├──ScienceObserverRepository

    |                        ├──SciencePlanModelGDDG

    |                        ├──SciencePlanRepository

    |                        ├──User

    |                        ├──UserRepository
    
    |                      ├──GeminiApplication //ไม่ต้องเเก้ในนี้

    |                  ├──mysql

    |                      ├──JDBCDriverLoader
    
    |                  ├──resources
    
    |                    ├──application.properties
    
    |                    ├──templates
    
    |                      ├──astronomerCreateSP.html

    |                      ├──astronomerHomePage.html

    |                      ├──astronomerSubmitSP.html
    
    |                      ├──login.html 
    
    |                      ├──notfound.html

    |                      ├──scienceobserverCreateOP.html 

    |                      ├──scienceobserverHomePage.html 

    |                      ├──signup.html 

    

