<h1>Implementation Group Golden Dragon </h1>
<br>

<h3>
    ในข้อมูล Readme อยู่ใน file : Readme_implementations.pdf
    โดยกลุ่ม Golden Dragon มีการทำ Docker
</h3>

<h4>
  - มีรายละเอียดของ design pattern
  - มีรายละเอียดของการใช้งาน interface
</h4>


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

    |       ├── Readme_implementations.pdf
    
    |       ├── gemini
    
    |           ├──ocs.mv
    
    |           ├──build
    
    |           ├──....

    |           ├──db

    |               ├──Gemini-update-17-4-2567.sql
    
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

    

