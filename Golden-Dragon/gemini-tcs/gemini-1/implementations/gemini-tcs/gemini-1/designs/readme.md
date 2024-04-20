<h1>Analysis of Selected 3 Use Case </h1>
<br>

![image](https://github.com/punyanuch463/Readme-only/assets/113642317/bf3dd023-693e-49f9-83c9-dd90a7c730c4)
<br>
<br>
![image](https://github.com/punyanuch463/Readme-only/assets/113642317/85153f9c-4a83-48a9-9479-51a472169f8f)


<H1> Golden Dragon</H1>
<h3> Use Case Description </h3>
<br>

<table>

<th >  Use Case ID:   </th>
<th>  1  </th>
 
</tr>

 <tr>

<th>  Use Case Name: </th>
<th> 
  create observing program
</th>

</tr>

<tr>
  
<th>Process Owner:</th>      
<th>  Pimpisa Apaipim</th>
</tr>

<tr>
  
<th>Business Actor: </th>
<th>
 Science Observer
</th>

<tr/>
  
 <tr> 
   
<th>Description:</th>
<th align="left">
 Science Observer ทำการสร้าง observing program ที่มีฟังก์ชันควบคุมกล้องโทรทรรศน์ โดยการเพิ่มข้อมูลเชิงเทคนิคเข้าไป เช่น จะต้องใช้เลนส์ระยะไหน รูรับแสงประมาณไหน องศาของกล้องโทรทรรศน์อยู่ตรงไหน และเงื่อนไขเพิ่มเติมต่าง ๆ
</th>

 </tr>
 
<tr>
  <th> Preconditions actor:</th>
<th align="left">
1.Science Observer จะต้องมี username และ password ที่ได้ทำการลงทะเบียนไว้ในระบบก่อนแล้ว และต้องการเข้าสู่ระบบเพื่อใช้งาน<br>
2.มีข้อมูลสำหรับกำหนดค่า function ที่จะใส่ในกล้องโทรทรรศน์ เพื่อใส่ข้อมูลไปขณะการสร้าง observing program<br>
3.มี List ข้อมูลของ Science plan เพื่อใช้ในการกำหนดค่า Function
 
</th>
</tr>

 <tr> 
  <th>Postconditions:</th>
<th align="left">
 Science Observer สามารถสร้าง observing program ที่มี function ตามที่ตนเองต้องการในการควบคุมกล้องโทรทรรศน์ได้

</th>
 </tr>

 
  <tr> 
 <th>Performance Goal:</th>
 <th align="left">
 มี observing program ถูกสร้างขึ้นมาตามเงื่อนไขที่กำหนดไว้ได้ถูกต้อง
 </th>
</tr>

  
<tr> 
<th>Basic Workflow:</th>
<th align="left">
  
1. Science observer ค้นหา science plan ที่ใช้สำหรับการสร้าง observing program<br>
1.1 ถ้าระบบไม่พบ science plan ที่ใช้สร้าง observing program ให้ส่ง error message ไปที่ science observer<br>
1.2 ถ้าระบบพบ science plan ที่ใช้สร้าง observing program ให้ใส่ id ของ science plan ไปที่ระบบ<br>

2. ระบบตรวจสอบข้อมูลใน science plan <br>
2.1. ถ้าระบบตรวจ science plan แล้ว "ข้อมูลใน science plan ไม่สมบูรณ์" ระบบจะส่งข้อความ error message กลับมาที่ระบบว่าไม่สามารถสร้าง observing program ได้<br>
2.2. ถ้าระบบตรวจ science plan แล้ว "ข้อมูลใน science plan สมบูรณ์" ระบบจะส่งข้อความแจ้งเตือนกลับมาที่ Science observer ว่าพร้อมสร้าง observing program<br>

3. Science observer ระบุรายละเอียด function กำหนดค่า planno, optionPrimary, fStop, opticsSecondaryRMS, scienceFoldMirrorDegree, scienceFoldMirrorType, moduleContent, calibrationUnit, lightType และ telePositionPair ของกล้องโทรทรรศน์ตามที่ science observer ต้องการลงใน observing program ที่จะทำการสร้าง<br>
3.1 ถ้ามีการกำหนดรายละเอียด function ครบตามที่กำหนดไว้ ระบบจะบันทึกข้อมูลไปยัง observing program<br>
3.2 หากไม่มีการกำหนดรายละเอียด function ครบตามที่กำหนดไว้ ระบบจะส่ง error message ไปที่ science observer<br>

Science observer creates observing program
</th>
</tr>

 
 <th>Notes and Issues: </th>
  <th> สามารถสร้าง และกำหนดคำสั่งของ function ที่มีความเกี่ยวข้องกับกล้องโทรทรรศน์ได้เท่านั้น
  </th>

 
</table>


<br>
<br>
<br>



<table>
  
<th >  Use Case ID:   </th>
<th>  2  </th>
 
</tr>
 <tr>

<th>  Use Case Name: </th>
<th> 
 create a science plan

</th>

</tr>

<tr>
  
<th>Process Owner:</th>      
<th> Nopparuj Pipattanapongwong</th>
  
</tr>
<tr>
  
<th>Business Actor: </th>
<th>
Astronomer
</th>

<tr/>
  
 <tr> 
   
<th>Description:</th>
<th align="left">
 Astronomer สร้าง science plan โดยสรุปการสังเกตหรือการทดลองเฉพาะที่จะดำเนินการโดยใช้กล้องโทรทรรศน์
</th>
 </tr>
 
<tr>
  <th> Preconditions actor:</th>
<th align="left">
1.Astronomer จะต้องได้รับการรับรองความถูกต้องและเข้าสู่ระบบ <br>
2.จะต้องมีข้อมูลที่เกี่ยวข้องเกี่ยวกับเป้าหมาย พารามิเตอร์ และเงื่อนไขสำหรับการสังเกต<br>
  
</th>
</tr>

 <tr> 
  <th>Postconditions:</th>
<th align="left">
 Astronomer สร้าง science plan ที่มีรายละเอียดการสังเกตหรือการทดลองที่จะดำเนินการได้สำเร็จ


</th>
 </tr>

  <tr> 
 <th>Performance Goal:</th>
 <th align="left">
   
 การสร้าง science plan ควรจะมีประสิทธิภาพ ช่วยให้ Astronomer สามารถสรุปข้อสังเกตที่ต้องการได้อย่างรวดเร็ว

 </th>
</tr>

  
<tr> 
<th>Basic Workflow:</th>
<th align="left">
  
1. Astronomer ค้นหาข้อมูลใน list (รายการรวม) ของ science plan <br>
1.1 ถ้า “ไม่มี science plan” อยู่ใน list ระบบจะส่งข้อความแจ้งเตือนกลับมาที่ Astronomer ว่าไม่มี science plan อยู่ในระบบ<br>
1.2 ถ้า “มี science plan” อยู่ใน list ระบบจะส่ง error massage กลับมาที่ Astronomer ว่ามี science plan อยู่แล้วในระบบ<br>

2. ระบบเพิ่ม science plan<br>
Astronomer กรอกข้อมูลรายละเอียดที่จำเป็น ดังนี้ ระบุ Creator, Submitter, fundingInUSD, objectives, startDate endDate, SciencePlan.STATUS, SciencePlan.TELESCOPELOC, fileType, fileQuality, colorType, contrast, brightness, saturation, highlights, exposure, shadows, whites, blacks, luminance, hue<br>
3.1 หากไม่มีการกำหนดรายละเอียด function ครบตามที่กำหนดไว้ ระบบจะส่ง error message ไปที่ Astronomer <br>
3.2 หากมีการกำหนดรายละเอียด function ครบตามที่กำหนดไว้ ระบบจะส่ง พร้อมสำหรับการสร้าง science plan<br>
Astronomer create a science plan
</th>
</tr>

       
 <th>Notes and Issues: </th>
  <th> 
     คุณสมบัติเพิ่มเติม เช่น การสังเกตกำหนดการหรือการแก้ไขร่วมกัน อาจได้รับการพิจารณาเพื่อการปรับปรุงในอนาคต
  </th>

</table>


<br>
<br>
<br>


<table>
 
<th >  Use Case ID:   </th>
<th>  3
</th>
 
<tr>

<th>  Use Case Name: </th>
<th> 
submit a science plan
</th>

</tr>
<tr>
  
<th>Process Owner:</th>      
<th>   Busakorn Saeheng

</th> 
</tr>

<tr>
  
<th>Business Actor: </th>
<th>
Astronomer 
</th>

<tr/>  
<tr> 
   
<th>Description:</th>
<th align="left">
 Astronomer สร้าง science plan หลังจากสร้าง science plan แล้ว ทำการทดสอบ science plan จากนั้นส่ง science plan เข้าสู่ระบบ

</th>
</tr>
 
<tr>
<th> Preconditions actor:</th>
<th align="left">
1.ระบบต้องรองรับการส่งข้อมูล API (Astronomical Programming Language) เพื่อทำให้กล้องโทรทรรศน์ทำงานตามที่กำหนด โดยให้ run และ submit ได้
<br>
2.ต้องสามารถเก็บข้อมูล และผลลัพธ์ได้
<br>
3.ต้องสามารถ Access Live View เพื่อติดตามกระบวนการการทำงานได้

</th>
</tr>

 <tr> 
  <th>Postconditions:</th>
<th align="left">
 Astronomer จะทำการส่ง science plan เข้าสู่ระบบ โดย Astronomer จะสามารถรันไฟล์ภาพ และ submit โดยเมื่อกล้องทำงานเสร็จจะเป็นข้อมูลภาพ และสามารถ Access Live View

</th>
</tr>

 
<tr> 
 <th>Performance Goal:</th>
 <th align="left">
 การส่งข้อมูล และรับผลลัพธ์จากกล้อง จะต้องมีการเข้ารหัสเพื่อปกป้องความปลอดภัย จะช่วยให้ระบบมีความปลอดภัยมากขึ้น
 </th>
</tr>

  
<tr> 
<th>Basic Workflow:</th>
<th align="left">
  
1. Astronomer เลือก list ของ science plan ที่ต้องการ submit<br>
1.1 ถ้าระบบ "ไม่พบข้อมูลใน list" จะส่ง error message กลับมาที่ Astronomer ว่าไม่มี science plan<br>
1.2 ถ้าระบบพบ science plan ที่ต้องการให้ใส่ id ของ science plan ไปที่ระบบ<br>

2. ระบบตรวจสอบ science plan ที่เลือกมาว่าข้อมูลถูกต้องไหม<br>
2.1 หากข้อมูลถูกต้อง จะสามารถ submit ได้<br>
2.2 หากข้อมูลไม่ถูกต้อง จะไม่สามารถ submit ได้ และระบบจะส่ง error message กลับมาที่ Astronomer<br>

3. Astronomer submit a science plan
</th>
</tr>
    
<th>Notes and Issues: </th>
<th> -</th>

 
</table>


<br>
<br>
<br>

