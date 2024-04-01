<h1>Use case</h1>

<h2>1.Science Plan:</h2>

เป็นการทำงานเมื่อ Astronomer ส่ง Science Plan เข้าสู่ระบบแล้วทาง Science Observer จะตรวจสอบและทดสอบ Science Plan จากนั้นก็จะนำไปสู่ขั้นตอนถัดไป

โดยมี Actor และ การทำงานของ Actor ดังนี้

Actor: Astronomer 

•	สร้าง Science Plan 

•	แก้ไข Science Plan  

•	เก็บข้อมูล และ ผลลัพธ์ จาก science plan 

•	ส่งข้อมูล หรือ submit Science Plan ให้กับ Science observer

Actor: Science Observer

•	ทดสอบ Science Plan 

•	ตรวจสอบ Science Plan 

Actor : Admin

•	ตรวจสอบ Science Plan 



<h2>2.Observing Program:</h2>

เป็นการทำงานเมื่อ ทางทีม Science Observer ตรวจสอบว่า Science Plan เรียบร้อยและ Science Plan จะถูกสร้างเป็น Observing Program เพื่อที่จะนำโปรแกรมไปควบคุมกล้องโทรทรรศน์ได้

โดยมี Actor และ การทำงานของ Actor ดังนี้



Actor: Science Observer

•	สร้าง Observer Program 

•	ส่งข้อมูล หรือ submit Observer Program ให้กับ Telescope Operator 

•	ตรวจสอบ Observer Program

•	แก้ไข Observer Program 

Actor: Telescope Operator

•	ตรวจสอบ Observer Program 

•	แก้ไข Observer Program 

Actor: Admin

•	ตรวจสอบ Observer Program 

•	กำหนดตาราง Observation 

Actor: Support

•	ตรวจสอบ Observer Program 



<h2>3. Installing special equipment:</h2>

เป็นการทำงานเมื่อ visitor มีการส่ง propose เพื่อขอการติดตั้งอุปกรณ์และsoftware ใหม่ๆ

โดยมี Actor และ การทำงานของ Actor ดังนี้



Actor: Telescope Operator

•	ติดตั้ง device ของ special equipment 

•	ควบคุม  special equipment 

•	ทดสอบ special equipment 

Actor: Admin

•	ตรวจสอบ special equipment 

Actor: Support

•	ตรวจสอบ special equipment 

•	ติดตั้ง software ของ special equipment 

Actor : Visitor 

•	ส่ง device และ software ของ special equipment 



<h2>4.  Astronomical data :</h2>

เป็นการทำงานเมื่อ ระบบได้ทำการถ่ายภาพจากกล้องโทรทรรศน์ ซึ่งภาพที่ได้มาในระยะแรกจะต้องถูกตรวจสอบก่อน

โดยมี Actor และ การทำงานของ Actor ดังนี้



Actor: Science observer 

•	บันทึก Astronomical data 

•	วิเคราะห์ Astronomical data 

•	ตรวจสอบ Astronomical data 

•	บริหารจัดการ Astronomical data ลบ เพิ่ม และแชร์ 



<h2>5.ควบคุมกล้องโทรทรรศน์:</h2>

เป็นการทำงานเมื่อได้ Science Plane และ Observing Program เพื่อควบคุมกล้องโทรทรรศน์ให้สามารถใช้งานได้ตามเงื่อนไขที่ต้องการ

โดยมี Actor และ การทำงานของ Actor ดังนี้



Actor: Admin

•	แสดงสถานะกล้องโทรทรรศน์ 

Actor: Telescope Operator

•	ตรวจสอบการทำงานกล้องโทรทรรศน์ 

•	ป้อนคำสั่งควบคุมกล้องโทรทรรศน์ จากระยะทางไกล 

Actor : Science observer

•	ควบคุมกล้องโทรทรรศน์ ผ่านOCS 

•	ตรวจสอบการทำงานกล้องโทรทรรศน์ 

Actor : Support

•	จำกัดระยะในการควบคุม กล้องโทรทรรศน์ 



 

