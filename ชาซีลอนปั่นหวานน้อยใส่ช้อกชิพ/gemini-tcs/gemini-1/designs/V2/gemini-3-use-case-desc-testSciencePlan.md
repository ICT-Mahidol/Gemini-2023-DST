# Use Case Name: Test Science Plan

| Use Case Name           | Test Science Plan                                   |
|-------------------------|---------------------------------------------------------------|
| ID                      | 02                                                             |
| Importance Level        | High                                                          |
| Primary Actor           | Astronomers                                              |
| Use Case Type           | Detail, Essential                                             |
| Stakeholders and Interests | Astronomers – ต้องการสร้าง test Science Plan |
| Brief Description       | อธิบายกระบวนการทดสอบ Science Plan หลังจากที่มีการสร้าง Science Plan |
| Trigger                 | เมื่อ Astronomers ส่งคำร้องขอการทดสอบของ Science Plan ที่ได้ทำการสร้างเพื่อนำ Science Plan นั้นเข้าสู่กระบวนการทดสอบ          |
| Type                    | External                                                      |
| Relationships           | Association: Astronomers <br>   Include: Operate the interactive observing (virtual telescope)                                |
| Normal Flow of Events   | 1. เมื่อ Astronomer ได้ทำการสร้าง Science Plan เรียบร้อยแล้วนั้น ในขั้นตอนก่อนที่จะสามารถทดสอบ Science Plan ได้ Astronomer จะต้องมีการร้องขอ Science Plan ก่อนโดยกดปุ่ม “Test” <br> 2. เมื่อกดปุ่ม “Test” ระบบจะแสดง Pop up ข้อมูลรายละเอียดต่างๆ ของ Science Plan ขึ้นมา <br> 3. เมื่อผู้ใช้งานกดปุ่ม “Test” ใน Pop up ระบบจะนำ Science Plan ชุดนั้นเข้าสู่กระบวนการทดสอบ Science Plan ในระบบ OCS <br> 4. ถ้าหาก Science Plan นั้นผ่านการ test Science Plan แล้วผลลัพธ์ของการทดสอบ Science Plan นั้นจะถูกส่งกลับไปให้ Astronomer โดยจะถูกแสดงในรูปแบบของ alert|
| Subflows                | -                                                             |
| Alternate/Exceptional Flow | ถ้าหากการ test Science Plan นั้นไม่ผ่านการทดสอบ Astronomers จะได้รับการแจ้งเตือนข้อผิดพลาดของ Science Plan ส่งกลับไปให้ Astronomer โดยจะถูกแสดงในรูปแบบของ alert                                                           |
