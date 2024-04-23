# 2023-ITDS361-1

Table of contents
=================

* [Design Pattern](#design-pattern)
* [วิธีการรันแอปพลิเคชัน](#วิธีการรันแอปพลิเคชัน)
* [วิธีใช้งาน Observation Control System](#วิธีใช้งาน-observation-control-system)
* [Contributors](#contributors)

## Design Pattern

Facade Pattern : เนื่องจากเป็นการนำ library OCS ที่ให้บริการหลายฟังก์ชันสำหรับอุปกรณ์สังเกตการณ์ ที่มีความซับซ้อนในการใช้งาน มาสร้างเป็น interface ในการเชื่อมต่อข้อมูลในการเข้าถึงข้อมูลเพื่อลดความซับซ้อนของระบบ

## วิธีการรันแอปพลิเคชัน

### ใช้ IntelliJ IDEA เพื่อรัน BACK-END
1. เปิดโปรเจคในโฟลเดอร์ `\Gemini-2023-DST\2023-ITDS361-1`
2. ไปที่ไฟล์ `gemini-tcs\gemini-1\implementations\BACK-END-SpringBootOCS\build.gradle` (โปรแกรม IntelliJ IDE จะเปิดโปรเจคท์ขึ้นมาเป็นแบบ Gradle project โดยอัตโนมัติ)

3. รอจน Gradle ดาวน์โหลด dependencies ที่ต้องใช้ลงมาทั้งหมด (สังเกตที่ status bar ด้านล่างขวา)

4. รันฟังก์ชั่น main (DemoApplication.java)

    **หมายเหตุ:** ควรใช้ Java version 17 ในการรัน

### ใช้ VS Code หรือ IDE อื่น เพื่อรัน FRONT-END
1. เปิดโฟลเดอร์ `\Gemini-2023-DST\2023-ITDS361-1`
2. เปิด Terminal และ cd ไปที่ `\gemini-tcs\gemini-1\implementations\react-app`
3. ใช้คำสั่ง `npm install` เพื่อติดตั้ง dependencies
4. ใช้คำสั่ง `npm start` เพื่อเริ่มต้นแอปพลิเคชัน 
5. เข้าถึงแอปพลิเคชันผ่านเว็บบราวเซอร์ (http://localhost:3000/)

## วิธีใช้งาน Observation Control System
สามารถ login เข้าใช้งานด้วย email และ passward ที่มีิอยู่ในระบบ ตาม role ต่างๆของผู้ใช้งาน ดังนี้

### 1. Create Observing Program
- เข้าสู่ระบบโดยใช้ข้อมูลเข้าสู่ระบบด้านล่าง ใน role ของ ScienceObserver
  - email: user3@gmail.com
  - passward: user3

- เมื่อเข้าสู่ระบบสำเร็จ ระบบจะพาไปที่หน้า Home และเพื่อให้ ScienceObserver สามารถ Create Observing Program โดยกดปุ่ม "CREATE"

- กรอกข้อมูล Observing Program ที่ต้องการ แล้วกด "SUBMIT" เพื่อทำการบันทึกข้อมูล

### 2. Submit SciPlan
- เข้าสู่ระบบโดยใช้ข้อมูลเข้าสู่ระบบด้านล่าง ใน role ของ Astronomer
  - email: user2@gmail.com
  - passward: user2

- เมื่อเข้าสู่ระบบแล้ว ไปที่หน้า Home  ระบบจะอนุญาตให้ Astronomer สามารถ "Submit SciPlan" ด้วยปุ่ม "SUBMIT" 

- กด "SUBMIT" SciPlan ที่ต้องการส่ง

### 3. Validate Observing Program
- เข้าสู่ระบบโดยใช้ข้อมูลเข้าสู่ระบบด้านล่าง ใน role ของ TelescopeOperator
  - email: user1@gmail.com
  - password: user1

- เมื่อเข้าสู่ระบบแล้ว ไปที่หน้า Home และเลื่อนลงไปจนเจอปุ่ม "show observing program" และกดปุ่ม "show observing program" เพื่อแสดงข้อมูลของ Observing Program

- ตรวจสอบข้อมูลใน Observing Program และกดปุ่ม "validate" ข้อมูล ระบบจะทำการ alert ว่าได้มี การ "Validate Observing success" สำเร็จแล้ว

## Contributors
<pre>
Yuttapichai  Promnok
Ravisara  Wilaipong
Thanakrit Siripanjanon
Patthaweekan  Panplab
Papavarin  Khamim
Sirada  Namboot 
</pre>
