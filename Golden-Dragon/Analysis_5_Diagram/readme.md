<h1>Analysis of Selected 5 Use Case </h1>
<br>

![SWD_Group_Assignment4](https://github.com/ICT-Mahidol/Gemini-2023-DST/assets/113642317/2c66e8ee-b553-4625-bb40-616dd2851f4a)


<br>

![SWD_Group_Assignment4 (1)](https://github.com/ICT-Mahidol/Gemini-2023-DST/assets/113642317/ac35361c-3d49-4678-8be0-ed4913da8557)

<H1> Golden Dragon</H1>
<h3> Use Case Description </h3>
<br>
<table>

<th >  Use Case ID:   </th>
<th>  1  </th>
 
</tr>

 <tr>

<th>  Use Case Name: </th>
<th> execute an approved science plan   </th>

</tr>

<tr>
  
<th>Process Owner:</th>      
<th> Talabporn Wutticharoenkit

</th>
  
</tr>

<tr>
  
<th>Business Actor: </th>
<th>Science Observer </th>
  
<tr/>
  
 <tr> 
   
<th>Description:</th>
<th align="left">
    Science Observer หลังจากตรวจสอบ science plan แล้วแปลงเป็น observing program เพื่อ submit ลงในระบบให้ operation staff ตรวจสอบความถูกต้อง และ execute เพื่อให้สามารถบันทึก Astronomical data (รูปถ่ายดวงดาวที่ได้มาจากกล้อง) ตรวจสอบความครบถ้วนของข้อมูล หรือ ข้อมูลการสังเกตต่าง ๆ เพื่อให้สามารถนำไปวิเคราะห์ภายหลังได้
</th>
 </tr>
 
<tr>
  <th> Preconditions actor:</th>
<th align="left">
  1.Science observer ต้องมี science plan ที่ถูกสร้าง ทดสอบ และ submit โดย Astronomer science plan ที่ถูกตรวจสอบแล้วโดย science observer  และ observing program ที่ถูกตรวจสอบความถูกต้องจาก operation staff<br>

 
</th>
</tr>

 <tr> 
  <th>Postconditions:</th>
<th align="left">
  Science observer สามารถ execute science plan ที่ตรวจสอบความถูกต้องแล้วเพื่อให้สามารถบริหารจัดการ Astronomical data ได้ 
</th>
 </tr>

 
  <tr> 
 <th>Performance Goal:</th>
 <th align="left">
   approved science plan สามารถบันทึก ตรวจสอบความถูกต้อง จัดการ Astronomical data (รูปถ่ายดวงดาวที่ได้มาจากกล้อง) ได้
 </th>
  </tr>

  
<tr> 
<th>Basic Workflow:</th>
<th align="left">
  
1. plan ที่ Astronomer ต้องการให้ทดสอบ<br>
1.1. ถ้าระบบ "ไม่พบข้อมูลใน list" จะส่ง error message กลับมาที่ Science observer ว่าไม่มีให้ทดสอบ<br>
1.2. แต่ถ้าระบบ "พบข้อมูลใน list" จะทำการส่งยืนยันการทดสอบไปให้ Science observer<br>

2. เมื่อ Astronomer กดยืนยันการทดสอบ Science observer จะตรวจสอบข้อมูลใน science plan<br>
2.1. ถ้า Science observer ตรวจ science plan แล้วพบว่า "ข้อมูลใน science plan ไม่สมบูรณ์" ระบบจะส่ง error message กลับมาที่ Science observer ว่าไม่สามารถทดสอบได้<br>
2.2. ถ้า Science observer ตรวจ science plan แล้วพบว่า "ข้อมูลใน science plan สมบูรณ์" ระบบจะส่งข้อความแจ้งเตือนกลับมาที่ Science observer ว่าพร้อมทดสอบ<br>

3. Science observer execute an approved science plan
</th>

 </tr> 
 

 <th>Notes and Issues: </th>
  <th>- </th>

 
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
2.มีข้อมูลสำหรับกำหนดค่า function ที่จะใส่ในกล้องโทรทรรศน์ เพื่อใส่ข้อมูลไปขณะการสร้าง observing program
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
1.2 ถ้าระบบพบ science plan ที่ใช้สร้าง observing program ให้ส่งยืนยันการพบ science plan ไปที่ science observer<br>

2. Science observer ตรวจสอบข้อมูลใน science plan<br>
2.1. ถ้า Science observer ตรวจ science plan แล้ว "ข้อมูลใน science plan ไม่สมบูรณ์" ระบบจะส่งข้อความ error message กลับมาที่ระบบว่าไม่สามารถสร้าง observing program ได้<br>
2.2. ถ้า Science observer ตรวจ science plan แล้ว "ข้อมูลใน science plan สมบูรณ์" ระบบจะส่งข้อความเเจ้งเตือนกลับมาที่ Science observer ว่าพร้อมสร้าง observing program<br>

3. Science observer ระบุรายละเอียด function กำหนดค่า Movement, Lens, Filters, Focus, Light detector และ Special equipment ของกล้องโทรทรรศน์ตามที่ science observer ต้องการลงใน observing program ที่จะทำการสร้าง<br>
3.1 ถ้ามีการกำหนดรายละเอียด function ครบตามที่กำหนดไว้ ระบบจะส่งว่า พร้อมสำหรับการสร้าง ไปที่ science observer<br>
3.2 หากไม่มีการกำหนดรายละเอียด function ครบตามที่กำหนดไว้ ระบบจะส่ง error message ไปที่ science observer<br>

4. Science observer creates observing program
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
<th>  3  </th>
 
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
2.จะต้องมีข้อมูลที่เกี่ยวข้องเกี่ยวกับเป้าหมาย พารามิเตอร์ และเงื่อนไขสำหรับการสังเกต
  
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
  
1. Astronomer ค้นหาข้อมูลใน list (รายการรวม) ของ science plan<br>
1.1 ถ้า “มี science plan” อยู่ใน list ระบบจะส่งข้อความแจ้งเตือนกลับมาที่ Astronomer ว่ามี science plan ที่พร้อมใช้งานอยู่<br>
1.2 ถ้า “ไม่มี science plan” อยู่ใน list ระบบจะส่ง error message กลับมาที่ Astronomer ว่าไม่มี science plan<br>

2. ระบบเพิ่ม science plan<br>

3. Astronomer กรอกข้อมูลรายละเอียดที่จำเป็น ดังนี้ Creator, Submitter, Funding, Object, Stars System, Schedule (date, time), Telescope location, Data processing requirements - File type, File quality, Image processing - B&W, color, contrast, brightness, Saturation<br>
3.1 หากไม่มีการกำหนดรายละเอียด function ครบตามที่กำหนดไว้ ระบบจะส่ง error message ไปที่ Astronomer<br>
3.2 หากมีการกำหนดรายละเอียด function ครบตามที่กำหนดไว้ ระบบจะส่ง พร้อมสำหรับการสร้าง science plan<br>

4. Astronomer create a science plan
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
<th>  4  </th>
 
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
1.2 หากระบบ "พบข้อมูลใน list" จะทำการส่งยืนยันการทดสอบไปให้ Astronomer<br>

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



<table>

  
<th >  Use Case ID:   </th>
<th>  5  </th>

<tr>

<th>  Use Case Name: </th>
<th> 
Validate on observing program

</th>

</tr>

<tr>
  
<th>Process Owner:</th>      
<th> Kotchaporn Suwannarat </th>
  
</tr>
<tr>
  
<th>Business Actor: </th>
<th>
 Telescope Operator
</th>

<tr/>
  
 <tr> 
   
<th>Description:</th>
<th align="left">
 ทำการตรวจสอบ observing program ที่มีฟังก์ชันในการควบคุมในด้านต่างๆของกล้องโทรทรรศน์  โดยจะต้องตรวจสอบว่าโปรแกรมสามารถควบคุมการเคลื่อนไหว, การตั้งเลนส์, ฟิลเตอร์, การโฟกัส, การตรวจวัดแสง และอุปกรณ์พิเศษ ทำงานตามฟังก์ชันที่ระบุไว้
</th>
 </tr>
 
<tr>
  <th> Preconditions actor:</th>
<th align="left">
1. Telescope Operator จะต้องมี username และ password ที่ได้ทำการลงทะเบียนไว้ในระบบก่อน  และต้องการเข้าสู่ระบบเพื่อใช้งาน
<br>
2.Telescope Operator จะต้องมีสิทธิ์เข้าถึงเครื่องมือและทรัพยากรที่จำเป็นสำหรับการตรวจสอบ และมีข้อมูลสำหรับการใส่ค่าในการตรวจสอบ function ใน observing program 

</th>
</tr>

 <tr> 
  <th>Postconditions:</th>
<th align="left">
  Telescope Operator สามารถตรวจสอบความถูกต้องของ observing program ในการควบคุมกล้องโทรทรรศน์ได้
</th>
 </tr>

 
  <tr> 
 <th>Performance Goal:</th>
 <th align="left">
 ตรวจสอบ observing program แล้วกระบวนการทำงานใน observing program สามารถทำงานตามเงื่อนไขที่กำหนดไว้ได้อย่างถูกต้อง และมีประสิทธิภาพ
 </th>
  </tr>

  
<tr> 
<th>Basic Workflow:</th>
<th align="left">
  
1. Telescope Operator เลือก list ของ observing program ที่ต้องการตรวจสอบ<br>
1.1 ถ้าระบบ "พบข้อมูลใน list" จะทำการส่งยืนยันการทดสอบไปให้ Telescope Operator และให้ทำตามขั้นตอนต่อไป<br>
1.2 ถ้าระบบ "ไม่พบข้อมูลใน list" จะส่ง error message เเจ้งเตือนกลับมาที่ Telescope Operator ว่าระบบไม่พบข้อมูลใน list<br>

2. Telescope Operator ควบคุมการเคลื่อนไหวของกล้องโทรทรรศน์ ปรับการตั้งค่าเลนส์ นำฟิลเตอร์มาใช้ โฟกัสเลนส์ กระตุ้นกลไกการตรวจวัดแสง และเปิดใช้งานอุปกรณ์พิเศษที่กำหนดไว้โดยโปรแกรม observing program<br>
2.1 ถ้า "ผลลัพธ์สามารถเป็นไปตามที่กำหนด" ให้ทำตามขั้นตอนต่อไป<br>
2.2 ถ้า "ผลลัพธ์ไม่สามารถเป็นไปตามที่กำหนด" ระบบจะส่ง error message เเจ้งเตือนกลับไปที่ Telescope Operator ว่าผลลัพธ์ไม่สามารถเป็นไปตามที่กำหนด<br>

3. Telescope Operator ตรวจสอบการตอบสนองจากกล้องโทรทรรศน์ต่อทุก ๆ คำสั่งใน observing program<br>
3.1 ถ้า "ตอบสนองถูกต้อง" จะส่ง correct response message เเจ้งเตือนกลับไปที่ Telescope Operator ว่าระบบตอบสนองถูกต้อง<br>
3.2 ถ้า "ตอบสนองไม่ถูกต้อง" จะส่ง error message เเจ้งเตือนกลับไปที่ Telescope Operator ว่าระบบตอบสนองไม่ถูกต้อง<br>

4. Telescope Operator validate on observing program
</th>
</tr> 
<tr> 
 <th>Notes and Issues: </th>
  <th> 
    ความไม่สอดคล้องหรือปัญหาที่พบระหว่างกระบวนการตรวจสอบจะถูกบันทึกและรายงานเพื่อการสอบสวนหรือปรับปรุงเพิ่มเติม
  </th>
</tr> 
 
</table>



<br>

