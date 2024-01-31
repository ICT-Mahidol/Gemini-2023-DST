# Project Assignment #2

## Members
   * Tunyarat Nitihirunpattana 6487002
   * Chanyanuch Nuangjumnong 6487023
   * Pongsatorn Arunrat 6487048
   * Neadnapa Thawontaweekul 6487079
   * Pimnara Panyalerdsattha 6487085 

# Use Case Description

## Manage User
Description: Admin จะเป็นคนจัดการ user management ของผู้ใช้ในแต่ละ role ว่าจะเข้าถึงส่วนไหนได้บ้าง

## Define Operation Level
Description: Admin  กําหนด Operation Level ว่าส่วนไหนทํางานอย่างไรบ้างทั้ง Observing level, Maintenance level, Test level

## Control System
Description: Admin  มีการควบคุมการทํางานของระบบ โดยจะควบคุมทั้ง open/close time, shutdown time, input/output

## Scheduling
Description: Admin จัดตารางเวลาของทั้งการบํารุงรักษาและการสังเกตการณ์โปรเจค

## Maintain Device Status
Description: Admin จัดการกับสถานะของอุปกรณ์ที่เชื่อมต่อกับระบบ

## Create Science Plan
Description: Proposing Astronomer สามารถสร้าง science plan และกรอกข้อมูลรายละเอียดของ science plan ผ่านระบบ

## Test Science Plan
Description: Proposing Astronomer นำ science plan ที่สร้าง ไปทดสอบในระบบ ที่ เป็น virtual telescope capability of Gemini system

## Submit Science
Description: เมื่อ test science plan ผ่าน Proposing Astronomer ถึงจะสามารถ submit ส่ง science plan เข้าไปในระบบได้

## Validate Science Plan
Description:เมื่อ astronomer submit science plan ทาง science observer จะทำการตรวจสอบและยืนยันวัตถุประสงค์ทางการ วิจัย ที่ระบุในแผนวิทยาศาสตร์ที่เสนอว่าสอดคล้องกับความสามารถของทางกล้องทางดวงจันทร์และทรัพยากรที่มีอยู่

## Create Observing Program
Description: เมื่อ science plan ได้รับการตรวจสอบแล้ว science observer จะสร้าง observing program ขึ้นโดย observing program จะถูกพัฒนาขึ้นขึ้นจากแผนวิทยาศาสตร์ที่ได้รับการตรวจสอบแล้ว

## Submit Observing Program
Description: หลังจากสร้างโปรแกรมการสังเกตแล้วจะต้องส่งเพื่อให้ได้รับการทบทวนและการอนุมัติโดย operation staff ที่จะประเมินด้านทางเทคนิคและด้านวิทยาศาสตร์

## Validate Observing Program
Description: เมื่อ Observing Program ถูกสร้างเรียบร้อยเเล้วนั้น Science Observer จะส่งมาให้ Operation Staff เพื่อทำการตรวจสอบความถูกต้อง

## Execute Approval plan
Description: หลังจากได้รับการอนุมัติแล้วแผนการที่วางไว้จะถูกใช้ให้เกิดผล

## Monitor Project Progress
Description: เป็นส่วนของการติดตามเพื่อตรวจสอบความคืบหน้าของโครงการอย่างต่อเนื่อง

## Manage Astronomical Data
Description: เป็นส่วนของการบริหารจัดการของระบบเก็บข้อมูล astronomical มีการเพิ่มข้อมูลที่ได้มาล่าสุด, การลบข้อมูลที่ไม่จำเป็นหรือผิดพลาด, และการให้สิทธิ์ในการเข้าถึงแก่นักวิจัยหรือคนร่วมงาน

## Control Telescope via OCS Program
Description: จะเป็นส่วนการควบคุม telescope ได้ทำให้การควบคุม telescope เป็นไปอย่างมีประสิทธิภาพและแม่นยำ

## Collect Astronomical Data
Description: จะเป็นการเก็บข้อมูล astronomical ตามที่ระบุในโปรแกรม observing ที่ได้รับการอนุมัติ จะบันทึกภาพถ่ายหรือข้อมูลที่เกี่ยวข้องตามโปรแกรมที่วางไว้

## Validate Astronomical Data
Description: เป็นการตรวจสอบเพื่อให้แน่ใจว่าคุณภาพและความถูกต้องของข้อมูลดาราวัตถุที่ได้รับและเป็นการยืนยันว่าข้อมูลที่เก็บเป็นไปตามมาตรฐานทางวิทยาศาสตร์ที่ระบุในแผน

## Access live view
Description: Observing Astronomer สามารถดูได้ว่าตอนนี้ระบบกำลัง run โครงการของตนอยู่หรือไม่

## Collect Result Data
Description: Observing Astronomer สามารถเก็บผลลัพธ์ข้อมูลที่ได้จากกล้องโทรทัศน์

## Submit a proposal 
Description: การที่ Visitor ยื่น proposal ที่เป็นข้อมูล install plugin device

## Validate proposal
Description: คือการที่ Supporters validate proposal ของ Visitor

## Install New Device
Description: หลังจากที่ Supporter ได้ทำการตรวจสอบความถูกต้องของอุปกรณ์เรียบร้อยเเล้ว Operation Staff จะทำการติดตั้งอุปกรณ์

## Install New Extension and Configurations 
Description: คือการที่ Supporters สามารรถติดตั้ง Extension เพิ่มเติมให้กับ System

## Control Gemini 8m Telescope
Description: Operation Staff สามารถควบคุมการทำงานของ Telescope ผ่าน Command ได้

## Maintenance hardware & software 
Description: supporter มีหน้าที่รับผิดชอบในการบำรุงรักษา system, hardware และ software

## Configure Gemini Telescope system
Description: supporter มีหน้าที่รับผิดชอบในการ ติดตั้งระบบย่อย(subsystem) และ configuration changes

