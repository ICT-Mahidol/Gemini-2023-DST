# Project Gemini-1 Phase2 By Group ฟอมเฟี้ยว 

### member

* 6487001
* 6487029
* 6487053
* 6487062
* 6487084

# วิธีการ Run ใน Software Gemini 
1. สร้าง Database ตามใน Controller
2. Run Project

## Use Case Create A science plan 
   1.  Login: เข้าสู่ระบบที่ localhost:8080/login โดยต้องมีบทบาทเป็น Astronomer
2. Create Science Plan:
  - เข้าไปที่ localhost:8080/science-plans เพื่อไปยังหน้า Astronomer HomePage
  -  จากนั้นกดเมนู "Create sciplan" ที่มุมบนขวา
  - กรอกข้อมูลในฟอร์มที่ localhost:8080/create_plan
  -  กด Submit เพื่อบันทึก Science Plan

## Use Case Test A science plan
1. Login: เข้าสู่ระบบที่ localhost:8080/login โดยต้องมีบทบาทเป็น Science Observer
2.  Validate Science Plan:
 -  เข้าไปที่ localhost:8080/science-plans-observer
 - จากนั้นกดเมนู "Validate sciplan" ที่มุมบนขวา
 - ระบบจะนำไปยังหน้า localhost:8080/validSciPlan ที่สามารถอัปเดตสถานะ Science Plan (Validated/Invalidated)

## Use Case Validate A science plan
1. Login: เข้าสู่ระบบที่ localhost:8080/login โดยต้องมีบทบาทเป็น Astronomer
2.  Test Science Plan:
 -  เข้าไปที่ localhost:8080/science-plans
 - กดเมนู "Test sciplan" ที่มุมบนขวา
- ระบบจะนำไปยังหน้า localhost:8080/testSciPlan ที่สามารถอัปเดตสถานะ Science Plan (Tested)



# Design Pattern

เป็น Design Pattern แบบ Factory Method Pattern ในการสร้างวัตถุ OCS ในเมทอด getAllSciencePlansOCS() นั้นสามารถเรียกว่าเป็นตัวอย่างของ Factory Method เนื่องจากมีการสร้างวัตถุ OCS โดยใช้เมทอด getAllSciencePlans() ของ OCS เพื่อรับข้อมูล.

