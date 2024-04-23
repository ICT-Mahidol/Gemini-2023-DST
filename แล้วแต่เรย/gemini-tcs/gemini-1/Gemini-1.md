## Use Case Create SciencePlan 

ไฟล์ที่เกี่ยวข้อง 
- SciencePlanController.java
- science_plan_form.html
- create_success.html
- all_science_plans.html

โดยสามารถเข้าถึง หน้า CreateSciencePlan ผ่าน login user คือ  Astronomer 
เมื่อเข้ามาแล้วจะเห็นหน้า Homepage ของ CreateScience Plan 
   สามารถกดเลือกปุ่ม CreateSciencePlan และ ปุ่ม View AllSciPlans
       1 ปุ่ม CreateSciencePlan เพื่อ สร้างSciencePlan
       -  พบกับหน้า CreateSciencePlan (ใช้ science_plan_form.html) ซึ่งเชื่อมไปยัง               
          localhost:8080/createSciencePlan 
       - เมื่อกรอกข้อมูลใน CreteSciencePlan เสร็จจะเชื่อมไปยังหน้า localhost:8080/saveSciencePlan  
          และเชื่อมไปยังหน้า localhost:8080/createSuccess  ตามลำดับ 
              2. ปุ่ม View AllSciPlans เพื่อดู SciencePlan ที่ถูกสร้างขึ้นมาทั้งหมดซึ่งเชื่อมไปยัง  
                     localhost:8080/allSciencePlans

Design pattern

MVC (Model View Controller) 
ซึ่งเป็นรูปแบบที่แยกส่วนการทำงานของแอปพลิเคชันออกเป็นสามส่วนหลัก: โมเดล (Model) ซึ่งจัดการกับข้อมูลและโลจิก, วิว (View) ซึ่งแสดงผลการติดต่อกับผู้ใช้, และคอนโทรลเลอร์ (Controller) ซึ่งเป็นตัวกลางระหว่างโมเดลและวิวในการจัดการข้อมูลและการเชื่อมต่อกับผู้ใช้ซึ่งทำให้โค้ดมีความเป็นระเบียบ, ง่ายต่อการบำรุงรักษา, และสามารถขยายได้ตามความต้องการ, รวมถึงช่วยให้การพัฒนาสามารถทำได้พร้อมกันในหลายส่วน


## Use Case Create Observing Program
ไฟล์ที่เกี่ยวข้อง 
- ObservingProgramController = โปรแกรมควบคุมการทำงานของ ObservingProgram ทั้งหมด
- observing_page.html หน้าแรกของ ObservingProgram
- observing_program_form.html = หน้ากรอก ObservingProgram เข้าผ่าน /createObservingProgram 
- createobssuccess.html เมื่อทำการ save เสร็จแล้วจะทำการบันทึกลง database ผ่าน /saveObservingProgram และ เข้าสู่ createobssuccess.html เพื่อบอกว่าเสร็จแล้วนะ




## Control the telescope via the command line
ไฟล์ที่เกี่ยวข้อง: TeleOpController.java, commandline.html, teleop.html
เมื่อ login เข้ามาในฐานะ telescope operator ได้สำเร็จจะมาอยู่ที่หน้า /teleop ซึ่งมี teleop.html รองรับ
สามารถเข้าถึงหน้า command line ซึ่งมี commandline.html รองรับได้จาก navbar จากหน้า teleop
ในหน้า commandline จะมีช่องสำหรับป้อน command ซึ่งมี command ที่ใช้งานได้ทั้งหมดดังนี้:
- "GetVersion",
- "GetStatus",
- "RunTest",
- "START",
- "STOP",
- "UP",
- "DOWN",
- "LEFT",
- "RIGHT",
- "FOCUS",
- "TAKE_PHOTO"

***สำหรับ command ที่ 6-11 จำเป็นต้องทำการ START ก่อนถึงจะสามารถใช้งานได้

## Usecase Login
ในหน้าการทำ Login จะประกอบไปด้วยไฟล์ดังนี้
1. LoginController
2. login.html
3. User
4. UserRepository
5. navigation.html

ซึ่ง จะทำการสร้างไฟล์ HTML สำหรับหน้าล็อกอิน โดยเก็บข้อมูล
ซึ่ง จะทำการสร้างไฟล์ HTML สำหรับหน้าล็อกอิน โดยเก็บข้อมูล username and password ผ่านทาง /create-users 
โดยต้องทำการกรอกข้อมูลดังนี้
- Username
- Password
- Roles
จากนั้นเมื่อกด submit จะทำการบันทึกข้อมูลไว้ในฐานข้อมูล ซึ่งกลุ่มเราเลือกใช้คือ H2 Database 

ผู้ใช้กลับไปที่หน้าล็อกอินและกรอกข้อมูล ระบบจะทำการจำว่า username and password ที่ผู้ใช้กรอกมี roles คืออะไร จากนั้นจะพาไปสู่หน้า Welcome Users! 
และจะมีปุ่มสำหรับ roles นั้นๆ เพื่อเชื่อมไปยังหน้าที่ roles นั้นมีสิทธิ์ในการเข้าดู

Singleton 
ใช้จำกัดการสร้าง object จาก OCS class เพื่อไม่ให้ถูกสร้างซ้ำซ้อนจนเกินไป
โดยจะทำการสร้าง ocs class ขึ้นมา จากนั้นสร้าง OCS object ภายใน ocs class
สุดท้ายสร้าง getInstance method เพื่อให้เวลาที่ต้องการ OCS object
จะได้เรียกใช้ได้จาก method ดังกล่าว
