
****How to run and execute project****

- Use case Login
 
        1. เปิด command prompt 
        2. พิมพ์ git clone ตามด้วย HTTPS link 
        3. เปิดโปรแกรม IntelliJ 
        4. เปิด Project และ build 
        5. เปิด website ที่ http://localhost:8080/
        6. ในหน้า login เข้าสู่ระบบโดยแบ่งตาม role ดังนี้
        
            - Astronomer 
                username : Astronomer 
                password : 123 

            - Science Observer 
                username : ScienceObserve 
                password : 123 

- Use case Create Science Plan

        1. Login ด้วย username และ password สำหรับ role Astronomer
        2. เมื่อ login เสร็จ เราจะเห็น List ของ science plan ที่สร้างไว้ 
        3. ถ้าจะสร้าง Science Plan ใหม่ ให้คลิกลิงค์ที่เชียนว่า "Create Science Plan" 
        4. กดปุ่ม Save ถ้ากรอกข้อมูลครบทุกช่องแล้ว แต่ถ้าไม่ จะมีกล่องแจ้งเตือนว่าต้องการจะเซฟ daft นี้ไหมแทน

- Use case Create Observing Program

        1. Login ด้วย username และ password สำหรับ role Science Observer 
        2. เลือก science plan ที่ต้องการจะแปลงเป็น Observing Program โดยคลิกไปที่ Plan No 
        3. กรอกข้อมูลเพื่อทำการสร้าง Observing Program 
        4. กดปุ่ม Save เพื่อเอาเข้าระบบ 
- Use case Collect Astronomical Data

        1. Login ด้วย username และ password สำหรับ role Science Observer
        2. เมื่อ login สำเร็จ ให้เลือก Science Plan ที่ต้องการจะดูข้อมูล Astronomical 
        3. นำ Plan no ของ Plan ที่ต้องการเลือกเลือก ไป Search ใน Parameter 
        4. เปลี่ยน URL เป็น http://localhost:8080/getAstronomicaldata?id=[x] โดยแทน x ด้วย Plan no 

## Design Pattern
Decorator Pattern 
    - เนื่องจากมีการสร้าง class โดย extend มาจาก library OCS เพื่อทำฟังก์ชันต่างๆ เช่น createobservingprogram
    




