Member 022 , 063 , 076 , 081 , 085

**วัตถุประสงค์ของโครงการ**

เพื่อพัฒนาระบบซอฟต์แวร์ใหม่เพื่อทดแทนระบบเดิมที่ล้าสมัย และ เน้นการปรับปรุงการใช้งานและเพิ่มความพึงพอใจของผู้ใช้ โดยระบบใหม่นี้จะสามารถโต้ตอบกับผู้ใช้และสื่อสารกับกล้องโทรทรรศน์ Gemini ผ่านทางระบบ OCS ที่มีอยู่แล้ว


**อธิบาย 3 use case ที่ได้รับการปรับปรุง**

**Use case: create sciplan**

1. **มีการเพิ่มเติมและปรับแก้ usecase description** 
- เพิ่มให้มีการ ตรวจสอบข้อมูล Objective Science Plan เพื่อตรวจสอบ Science Plan ว่า Objective ไม่ซ้ำกับในระบบ
  - หากไม่ซ้ำแสดงว่าจุดประสงค์ในการสร้างscience planไม่ซ้ำ ระบบจะอนุญาติให้กรอกรายละเอียด detail ได้
- เพิ่มให้มีการตรวจสอบว่า Astronomer Idเพื่อจะได้เพิ่มAstronomer
- เพิ่มController เพื่อตรวจสอบ ข้อมูล sciplan หลังจากกด save 
  - ถ้าข้อมูลถูกต้องSciplanจะถูกsave และเพิ่มใน database ถ้าผิดจะ DisplayError

1. **มีการแก้ไข Activity Diagram ให้มีflow processที่ตรงกับusecase descriptionที่แก้**
1. **มีการแก้ไข Sequence Diagram ให้มีflow processที่ตรงกับusecase descriptionที่แก้**
- แก้ไข จากเดิมมีการใช้ Object ocs ได้ปรับแก้เป็น Object HengHengOcsController 
- เพิ่มgetAllastronomer() และreturn Astronomer ID() กลับมา เพื่อตรวจสอบว่า Astronomer Idอะไรที่ต้องการทำ Sciplan นี้ เพื่อจะเพิ่ม Astronomer ใน Sciplan นั้นๆ โดยการ setAstronomerID()
- เพิ่ม SciencePlan.STATUS SAVED เพื่อให้เมื่อ  Astronomer  กด save Controller จะตรวจสอบ ข้อมูล sciplan

**Usecase : Test Science Plan**

1. **มีการปรับแก้ usecase description** 
- จากเดิมได้assign ให้ supportor ทำในส่วนtest sciplan จากนั้นได้ปรับเปลี่ยนให้ Astronomer ทำ testsciplan แทน

2. **มีการแก้ไข Activity Diagram ให้มีflow processที่ตรงกับusecase descriptionที่แก้**
3. **มีการแก้ไข Sequence Diagram ให้มีflow processที่ตรงกับusecase descriptionที่แก้**
- เพิ่มการเรียกดู Scienceplan ทั้งหมด 

**Usecase :  Validate Science Plan**

1. **มีการปรับแก้ usecase description** 
2. **มีการแก้ไข Activity Diagram ให้มีflow processที่ตรงกับusecase descriptionที่แก้**
3. **มีการแก้ไข Sequence Diagram ให้มีflow processที่ตรงกับusecase descriptionที่แก้**
- เปลี่ยนfunction การเรียกดูข้อมูลเป็น getAllSciencePlan()  
- เพิ่ม function  getSciencePlanByNo เพื่อดูข้อมูลของ sciplan ที่ต้องการจะ
- เพิ่ม functiopn UpdateSciencePlanStatus โดย เปลี่ยน Status ของ sciplan ที่ได้ทำการทดสอบผ่านทาง planno

 **อธิบาย Class diagram ที่ได้ปรับปรุง**



- ลบ class Person ออก เเล้วเปลี่ยนเป็น class User
- เพิ่ม class Userinterface / Userinterfacelmpl ที่เเสดงถึงกาาร implement กันระหว่างclass
- เเก้ไขข้อมูล ผ่านใน class Astronomer / Sciobserver โดยตัดข้อมูลส่วนที่เหมือนกับ user class ออกเนื่องจาก มีความสัมพันธ์กันเเบบ inheritance
- เปลี่ยน class ocs ออกเเละทำการเปลี่ยนเป็น class HengHengController
- เเก้ไข class sciplan ให้ข้อมูลตรงกับ function เเละตัวเเปรของ ระบบที่สร้างขึ้นมาใหม่

**อธิบายการใช้งาน Gemini software ที่เกี่ยวข้องกับทั้ง 3 use case**

**HenghengOCS**

- เริ่มต้น RunApp ใน HenghengOCSApplication.java เมื่อรันแอพระบบจะทำการเพิ่ม user ในระบบเมื่อรันครัั้งแรกเสร็จให้ทำการ comment code ในบรรทัดที่ 31-63 หากต้องการรันแอพซ้ำสามารถรันแอพลิเคชั่นได้เลย โดยไม่ต้อง uncomment code

 **UseCase: Create Sciplan**
- localhost:8080/ : Homepage 
- localhost:8080/login : เข้าสู่ระบบ โดยต้องมีบทบาท เป็น Astronomer
- localhost:8080/science-plans: Astronomer HomePage
- กด Menu ข้างบนขวา ไปยัง Create sciplan
- ระบบพาไปสู่ localhost:8080/create\_plan : Science Plan Form
- กด Submit ระบบจะบันทึก Science Plan ที่สร้าง
 **UseCase: Validate Sciplan**
- localhost:8080/ : Homepage 
- localhost:8080/login : เข้าสู่ระบบ โดยต้องมีบทบาท เป็น ScienceObserver
- localhost:8080/science-plans-obserever: Science Observer HomePage
- กด Menu ข้างบนขวา ไปยัง validate sciplan
- ระบบพาไปสู่ localhost:8080/validSciPlan : Science Plan ValidatePage
- กดปุ่มระบบจะอัปเดตสถานะ Science Plan (Validated/Invalidated)
 **UseCase: Test Sciplan**
- localhost:8080/ : Homepage 
- localhost:8080/login : เข้าสู่ระบบ โดยต้องมีบทบาท เป็น Astronomer
- localhost:8080/science-plans: Astronomer HomePage
- กด Menu ข้างบนขวา ไปยัง test sciplan
- ระบบพาไปสู่ localhost:8080/testSciPlan : Science Plan TestPage
- กดปุ่มระบบจะอัปเดตสถานะ Science Plan (Tested)






 **การเลือกใช้ design pattern ใน project:**

กลุ่มเราใช้**รูปแบบ Factory Method** ในการปรับปรุงโค้ด โดยสร้าง instances ของ subclass (Astronomer, SciObserver) ของคลาส User ซึ่งช่วยในการ loose coupling และส่วนขยายง่ายๆ โดยไม่ต้องแก้ไข code ใน client ที่มีอยู่

 **ปัญหา:**

โค้ดเก่าตอนที่สร้าง Object ไม่ได้ถูก centralize และ encapsulate กลุ่มเราสร้าง subclass (Astronomer, SciObserver) แต่ละอัน โดยใช้ constructor ของแต่ละคลาสเอง ซึ่งไม่ถูกต้อง ตามหลักของ encapsulation และถ้าในอนาคตหากมีปรับเปลี่ยนหรือเพิ่มเติมprocess ก็จะต้องเปลี่ยนแก้ไขโค้ดในหลายจุด codebase ทำให้maintain ยากแล้วก็อาจจะเกิด errorได้ง่าย

 **วิธีการแก้ไข:**

นำเข้า Factory Method pattern เพื่อแก้ปัญหา โดยใช้ factory method ที่ centralize ในคลาส User เพื่อสร้าง instances ของ subclass ตัวเอง แต่ละ subclass จะสร้าง factory method และ encapsulating การสร้างobjectภายใน subclass ทำให้maintain ได้ง่ายโดยไม่มีผลต่อ code ที่มีอยู่ใน client ซึ่งใน code เราเป็น mehod createUser() ที่สร้างขึ้นมาเป็น instance

 **ประโยชน์ในการใช้ Factory Pattern ได้แก่:**
1. **Encapsulation:** กระบวนการสร้างถูก encapsulate ภายใน factory methods ซึ่งซ่อนรายละเอียดจาก client code
2. **Loose Coupling:** client code ทำงานกับ factory methods ไม่ใช่การสร้าง subclass โดยตรง ช่วยให้ loose coupling และการบำรุงรักษาที่ง่ายขึ้น
3. **Extensibility:** มันช่วยในการส่วนขยายได้อย่างง่ายๆ โดยการเพิ่ม subclass ใหม่ หรือการปรับปรุงกระบวนการสร้างโดยไม่มีผลต่อ code ที่มีอยู่
4. **Centralized Control:** กระบวนการสร้างวัตถุถูก centralize ซึ่งทำให้ง่ายต่อการจัดการและการบำรุงรักษา
1. **Consistent Interface:** factory methods ให้ interface ที่มีความสัมพันธ์กัน ทำให้ใช้งานง่ายและลดข้อผิดพลาด
