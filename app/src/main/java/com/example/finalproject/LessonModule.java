package com.example.finalproject;

import android.content.Context;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class LessonModule {
    private static LinkedHashMap<String, Lesson> lessons = new LinkedHashMap<>();

    static {

        Lesson lesson1 = new Lesson("1. ชนิดข้อมูล (Data Types)", "ชนิดของข้อมูลและวิธีการใช้งานใน JavaScript");
        lesson1.addPageContent(1, "title", "String");
        lesson1.addPageContent(1, "content",
                "String คือข้อความที่ใช้แทนตัวอักษร ตัวเลข และสัญลักษณ์ต่างๆ โดยต้องใส่ในเครื่องหมาย:\n" +
                        " - เครื่องหมายเดี่ยว (' ')\n" +
                        " - เครื่องหมายคู่ (\" \")\n" +
                        " - เครื่องหมายแบ็คติ๊ก (` `) (ใช้ Template Literal)\n\n" +

                        "### ตัวอย่างการใช้ String\n\n" +

                        "1. การประกาศ String:\n" +
                        "   let str1 = 'Hello';\n" +
                        "   let str2 = \"World\";\n" +
                        "   let str3 = `Hello, ${1 + 2}!`;  // ผลลัพธ์: Hello, 3!\n\n" +

                        "2. การต่อข้อความ (Concatenation):\n" +
                        "   let firstName = 'John';\n" +
                        "   let lastName = 'Doe';\n" +
                        "   let fullName = firstName + ' ' + lastName;\n" +
                        "   console.log(fullName);  // John Doe\n\n" +

                        "3. การใช้ Template Literals:\n" +
                        "   let name = 'Alice';\n" +
                        "   let age = 25;\n" +
                        "   console.log(`ชื่อ: ${name}, อายุ: ${age}`);\n" +
                        "   // ชื่อ: Alice, อายุ: 25\n\n" +

                        "4. การจัดการ String:\n" +
                        "   let text = '  JavaScript  ';\n" +
                        "   console.log(text.trim());  // 'JavaScript' (ตัดช่องว่างหน้า-หลัง)\n" +
                        "   console.log(text.toUpperCase());  // 'JAVASCRIPT'\n" +
                        "   console.log(text.toLowerCase());  // 'javascript'\n" +
                        "   console.log(text.replace('Java', 'ECMA'));  // 'ECMAScript  '\n"
        );

        lesson1.addPageContent(2, "title", "Number");
        lesson1.addPageContent(2, "content",
                "Number คือตัวเลขที่ใช้ใน JavaScript สามารถเป็นได้ทั้ง:\n" +
                        " - จำนวนเต็ม (Integer)\n" +
                        " - จำนวนทศนิยม (Floating-point)\n" +
                        " - ค่า Infinity (ค่าที่มากหรือน้อยกว่าขีดจำกัดของตัวเลข)\n" +
                        " - ค่า NaN (Not-a-Number, เกิดขึ้นเมื่อคำนวณค่าที่ไม่ใช่ตัวเลข)\n\n" +

                        "### ตัวอย่างการใช้ Number\n\n" +

                        "1. การประกาศตัวเลข:\n" +
                        "   let a = 10;      // จำนวนเต็ม\n" +
                        "   let b = 3.14;    // จำนวนทศนิยม\n" +
                        "   let c = Infinity;  // ค่าที่ไม่มีที่สิ้นสุด\n" +
                        "   let d = NaN;      // ค่าที่ไม่ใช่ตัวเลข\n\n" +

                        "2. การคำนวณค่าตัวเลข:\n" +
                        "   let x = 5 + 3;     // ผลลัพธ์: 8\n" +
                        "   let y = 10 / 2;    // ผลลัพธ์: 5\n" +
                        "   let z = '5' * 2;   // ผลลัพธ์: 10 (JavaScript แปลง '5' เป็นตัวเลข)\n" +
                        "   let invalid = 'Hello' * 2;  // ผลลัพธ์: NaN\n\n" +

                        "3. ตรวจสอบว่าเป็น NaN หรือไม่:\n" +
                        "   console.log(isNaN(10));  // false\n" +
                        "   console.log(isNaN('Hello' * 2));  // true\n"
        );

        lesson1.addPageContent(3, "title", "Boolean");
        lesson1.addPageContent(3, "content",
                "Boolean คือค่าความจริงใน JavaScript ซึ่งมีได้เพียง 2 ค่าเท่านั้น:\n" +
                        " - `true` (จริง)\n" +
                        " - `false` (เท็จ)\n\n" +

                        "### ตัวอย่างการใช้ Boolean\n\n" +

                        "1. การประกาศค่าความจริง:\n" +
                        "   let bool1 = true;\n" +
                        "   let bool2 = false;\n\n" +

                        "2. การใช้ Boolean ในเงื่อนไข:\n" +
                        "   let age = 20;\n" +
                        "   let isAdult = age >= 18;\n" +
                        "   console.log(isAdult);  // ผลลัพธ์: true\n\n" +

                        "3. ค่าที่แปลงเป็น Boolean อัตโนมัติ (Truthy & Falsy Values):\n" +
                        "   console.log(Boolean(0));        // false\n" +
                        "   console.log(Boolean(''));       // false\n" +
                        "   console.log(Boolean(null));     // false\n" +
                        "   console.log(Boolean(undefined));// false\n" +
                        "   console.log(Boolean(NaN));      // false\n" +
                        "   console.log(Boolean(1));        // true\n" +
                        "   console.log(Boolean('Hello'));  // true\n\n" +

                        "4. ใช้ Boolean กับเงื่อนไข if:\n" +
                        "   let isLoggedIn = true;\n" +
                        "   if (isLoggedIn) {\n" +
                        "       console.log('Welcome!');\n" +
                        "   } else {\n" +
                        "       console.log('Please log in.');\n" +
                        "   }\n" +
                        "   // ถ้า isLoggedIn เป็น true จะแสดง 'Welcome!'\n"
        );

        lesson1.addPageContent(4, "title", "Undefined");
        lesson1.addPageContent(4, "content",
                "Undefined คือค่าที่เกิดขึ้นเมื่อมีตัวแปรที่ถูกประกาศไว้ แต่ยังไม่ได้กำหนดค่าให้\n\n" +

                        "### ตัวอย่างการใช้ Undefined\n\n" +

                        "1. ตัวแปรที่ยังไม่ได้กำหนดค่า:\n" +
                        "   let x;\n" +
                        "   console.log(x);  // ผลลัพธ์: undefined\n\n" +

                        "2. การคืนค่าเป็น Undefined:\n" +
                        "   function myFunction() {\n" +
                        "       // ไม่มีคำสั่ง return\n" +
                        "   }\n" +
                        "   let result = myFunction();\n" +
                        "   console.log(result);  // ผลลัพธ์: undefined\n\n" +

                        "3. ค่าที่ไม่พบใน Object:\n" +
                        "   let person = { name: 'Alice' };\n" +
                        "   console.log(person.age);  // ผลลัพธ์: undefined (ไม่มี key 'age')\n\n" +

                        "4. การตรวจสอบ Undefined:\n" +
                        "   let y;\n" +
                        "   if (y === undefined) {\n" +
                        "       console.log('y ยังไม่ได้กำหนดค่า');\n" +
                        "   }\n"
        );

        lesson1.addPageContent(5, "title", "Null");
        lesson1.addPageContent(5, "content",
                "Null คือค่าพิเศษที่ใช้แทน 'ไม่มีค่า' หรือ 'ค่าว่าง' โดยเป็นค่าที่ถูกกำหนดขึ้นมาโดยเจตนา\n\n" +

                        "### ตัวอย่างการใช้ Null\n\n" +

                        "1. การกำหนดค่าเป็น Null:\n" +
                        "   let y = null;\n" +
                        "   console.log(y);  // ผลลัพธ์: null\n\n" +

                        "2. ความแตกต่างระหว่าง Undefined และ Null:\n" +
                        "   let a;           // ยังไม่ได้กำหนดค่า\n" +
                        "   let b = null;    // กำหนดค่าเป็นค่าว่าง\n" +
                        "   console.log(a);  // ผลลัพธ์: undefined\n" +
                        "   console.log(b);  // ผลลัพธ์: null\n\n" +

                        "3. ใช้ Null เพื่อล้างค่าตัวแปร:\n" +
                        "   let data = 'ข้อมูลสำคัญ';\n" +
                        "   console.log(data);  // 'ข้อมูลสำคัญ'\n" +
                        "   data = null;        // ล้างค่า\n" +
                        "   console.log(data);  // ผลลัพธ์: null\n\n" +

                        "4. การตรวจสอบค่าที่เป็น Null:\n" +
                        "   let value = null;\n" +
                        "   if (value === null) {\n" +
                        "       console.log('ค่าคือ null');\n" +
                        "   }\n"
        );





        Lesson lesson2 = new Lesson("2. ตัวแปร (Variables)", "ตัวแปร คือ ชื่อที่ใช้เก็บข้อมูลในหน่วยความจำของโปรแกรม ซึ่งสามารถเรียกใช้และเปลี่ยนค่าได้");

        lesson2.addPageContent(1, "title", "var ไม่แนะนำให้ใช้");
        lesson2.addPageContent(1, "content",
                "ตัวแปรที่ประกาศด้วย `var` สามารถเข้าถึงได้ทุกที่ภายในฟังก์ชันที่ประกาศ ซึ่งอาจทำให้เกิดปัญหาการใช้ตัวแปรโดยไม่ตั้งใจ\n\n" +

                        "### ตัวอย่างปัญหาของ var\n\n" +

                        "1. **Hoisting ทำให้เข้าถึงตัวแปรก่อนประกาศได้**\n" +
                        "   console.log(x);  // ผลลัพธ์: undefined (ไม่มี Error แต่ค่าเป็น undefined)\n" +
                        "   var x = 10;\n" +
                        "   console.log(x);  // ผลลัพธ์: 10\n\n" +

                        "2. **var ไม่มี Block Scope**\n" +
                        "   if (true) {\n" +
                        "       var y = 20;\n" +
                        "   }\n" +
                        "   console.log(y);  // ผลลัพธ์: 20 (แม้จะประกาศใน if ก็ยังถูกเข้าถึงได้)\n\n" +

                        "3. **การใช้ var ซ้ำโดยไม่ได้ตั้งใจ**\n" +
                        "   var a = 5;\n" +
                        "   var a = 10;  // ไม่มี Error (แต่ let หรือ const จะ Error)\n" +
                        "   console.log(a);  // ผลลัพธ์: 10\n\n" +

                        "### คำแนะนำ: ใช้ `let` หรือ `const` แทน `var`\n" +
                        "   let b = 30;\n" +
                        "   const c = 50;\n" +
                        "   console.log(b, c);\n"
        );


        lesson2.addPageContent(2, "title", "let แนะนำให้ใช้");
        lesson2.addPageContent(2, "content",
                "ตัวแปรที่ประกาศด้วย `let` สามารถใช้งานได้เฉพาะภายในบล็อกโค้ดที่ประกาศ (Block Scope)\n" +
                        "สามารถเปลี่ยนค่าได้ แต่ **ห้ามประกาศซ้ำใน Scope เดียวกัน**\n\n" +

                        "### ตัวอย่างการใช้ let\n\n" +

                        "1. **เปลี่ยนค่าได้**\n" +
                        "   let name = \"Alice\";\n" +
                        "   name = \"Bob\";  // เปลี่ยนค่าได้\n" +
                        "   console.log(name);  // ผลลัพธ์: \"Bob\"\n\n" +

                        "2. **let มี Block Scope**\n" +
                        "   if (true) {\n" +
                        "       let age = 25;\n" +
                        "   }\n" +
                        "   console.log(age);  // Error: age is not defined\n\n" +

                        "3. **ห้ามประกาศซ้ำใน Scope เดียวกัน**\n" +
                        "   let a = 10;\n" +
                        "   let a = 20;  // Error: Identifier 'a' has already been declared\n"
        );


        lesson2.addPageContent(3, "title", "const ใช้เมื่อค่าคงที่");
        lesson2.addPageContent(3, "content",
                "ตัวแปรที่ประกาศด้วย `const` มีขอบเขตเช่นเดียวกับ `let` (Block Scope)\n" +
                        "แต่ค่าของ `const` **ต้องกำหนดค่าเริ่มต้นเสมอ และห้ามเปลี่ยนค่า**\n\n" +

                        "### ตัวอย่างการใช้ const\n\n" +

                        "1. **ต้องกำหนดค่าเริ่มต้นเสมอ**\n" +
                        "   const X = 3.14159;\n" +
                        "   console.log(X);  // ผลลัพธ์: 3.14159\n\n" +

                        "2. **เปลี่ยนค่าไม่ได้ (จะเกิด Error)**\n" +
                        "   const Y = 100;\n" +
                        "   Y = 200;  // Error: Assignment to constant variable.\n\n" +

                        "3. **const มี Block Scope เช่นเดียวกับ let**\n" +
                        "   if (true) {\n" +
                        "       const PI = 3.14;\n" +
                        "   }\n" +
                        "   console.log(PI);  // Error: PI is not defined\n"
        );

        Lesson lesson3 = new Lesson("3. ตัวดำเนินการ (Operators)", "ตัวดำเนินการ คือคำสั่งที่ใช้สำหรับการดำเนินการทางคณิตศาสตร์ การเปรียบเทียบ และการควบคุมตรรกะต่าง ๆ");

        lesson3.addPageContent(1, "title", "ตัวดำเนินการทางคณิตศาสตร์");
        lesson3.addPageContent(1, "content",
                "ตัวดำเนินการทางคณิตศาสตร์ใช้สำหรับคำนวณตัวเลขต่างๆ\n\n" +

                        "### ตัวอย่างของตัวดำเนินการทางคณิตศาสตร์\n\n" +
                        "1. `+` คือ บวก\n" +
                        "   let sum = 5 + 3;  // ผลลัพธ์: 8\n\n" +

                        "2. `-` คือ ลบ\n" +
                        "   let diff = 5 - 3;  // ผลลัพธ์: 2\n\n" +

                        "3. `*` คือ คูณ\n" +
                        "   let product = 5 * 3;  // ผลลัพธ์: 15\n\n" +

                        "4. `/` คือ หาร\n" +
                        "   let quotient = 6 / 2;  // ผลลัพธ์: 3\n\n" +

                        "5. `%` คือ หารเอาเศษ\n" +
                        "   let remainder = 5 % 2;  // ผลลัพธ์: 1\n\n" +

                        "6. `**` คือ ยกกำลัง\n" +
                        "   let power = 2 ** 3;  // ผลลัพธ์: 8\n"
        );

        lesson3.addPageContent(2, "title", "ตัวดำเนินการเปรียบเทียบ");
        lesson3.addPageContent(2, "content",
                "ตัวดำเนินการเปรียบเทียบใช้ในการเปรียบเทียบค่าและประเภทของตัวแปร\n\n" +

                        "### ตัวอย่างของตัวดำเนินการเปรียบเทียบ\n\n" +
                        "1. `==` คือ เท่ากับ (เช็คค่า)\n" +
                        "   let isEqual = 5 == '5';  // ผลลัพธ์: true\n\n" +

                        "2. `===` คือ เท่ากับแบบเช็คทั้งค่าและประเภท\n" +
                        "   let isStrictEqual = 5 === '5';  // ผลลัพธ์: false\n\n" +

                        "3. `!=` คือ ไม่เท่ากับ\n" +
                        "   let isNotEqual = 5 != 3;  // ผลลัพธ์: true\n\n" +

                        "4. `!==` คือ ไม่เท่ากับแบบเช็คทั้งค่าและประเภท\n" +
                        "   let isStrictNotEqual = 5 !== '5';  // ผลลัพธ์: true\n\n" +

                        "5. `>` คือ มากกว่า\n" +
                        "   let greater = 5 > 3;  // ผลลัพธ์: true\n\n" +

                        "6. `<` คือ น้อยกว่า\n" +
                        "   let less = 3 < 5;  // ผลลัพธ์: true\n\n" +

                        "7. `>=` คือ มากกว่าหรือเท่ากับ\n" +
                        "   let greaterOrEqual = 5 >= 5;  // ผลลัพธ์: true\n\n" +

                        "8. `<=` คือ น้อยกว่าหรือเท่ากับ\n" +
                        "   let lessOrEqual = 3 <= 5;  // ผลลัพธ์: true\n"
        );

        lesson3.addPageContent(3, "title", "ตัวดำเนินการทางตรรกะ");
        lesson3.addPageContent(3, "content",
                "ตัวดำเนินการทางตรรกะใช้สำหรับเงื่อนไขต่างๆ เพื่อกำหนดค่าความจริง\n\n" +

                        "### ตัวอย่างของตัวดำเนินการทางตรรกะ\n\n" +
                        "1. `&&` คือ เป็นจริงเมื่อ ทั้งสองเงื่อนไขเป็นจริง\n" +
                        "   let result = (5 > 3) && (3 < 5);  // ผลลัพธ์: true\n\n" +

                        "2. `||` คือ เป็นจริงเมื่อ มีเงื่อนไขใดเงื่อนไขหนึ่งเป็นจริง\n" +
                        "   let result = (5 > 3) || (3 > 5);  // ผลลัพธ์: true\n\n" +

                        "3. `!` คือ กลับค่าความจริง (True → False, False → True)\n" +
                        "   let notTrue = !(5 > 3);  // ผลลัพธ์: false\n"
        );

        lesson3.addPageContent(4, "title", "ตัวดำเนินการกำหนดค่า");
        lesson3.addPageContent(4, "content",
                "ตัวดำเนินการกำหนดค่าใช้ในการกำหนดหรือเปลี่ยนค่าของตัวแปร\n\n" +

                        "### ตัวอย่างของตัวดำเนินการกำหนดค่า\n\n" +
                        "1. `=` คือ กำหนดค่า\n" +
                        "   let a = 5;  // กำหนดค่า 5 ให้กับ a\n\n" +

                        "2. `+=` คือ บวกแล้วกำหนดค่า\n" +
                        "   let b = 5;\n" +
                        "   b += 3;  // ผลลัพธ์: 8\n\n" +

                        "3. `-=` คือ ลบแล้วกำหนดค่า\n" +
                        "   let c = 5;\n" +
                        "   c -= 2;  // ผลลัพธ์: 3\n\n" +

                        "4. `*=` คือ คูณแล้วกำหนดค่า\n" +
                        "   let d = 5;\n" +
                        "   d *= 2;  // ผลลัพธ์: 10\n\n" +

                        "5. `/=` คือ หารแล้วกำหนดค่า\n" +
                        "   let e = 10;\n" +
                        "   e /= 2;  // ผลลัพธ์: 5\n\n" +

                        "6. `%=` คือ หารเอาเศษแล้วกำหนดค่า\n" +
                        "   let f = 10;\n" +
                        "   f %= 3;  // ผลลัพธ์: 1\n\n" +

                        "7. `**=` คือ ยกกำลังแล้วกำหนดค่า\n" +
                        "   let g = 2;\n" +
                        "   g **= 3;  // ผลลัพธ์: 8\n"
        );

        lesson3.addPageContent(5, "title", "ตัวดำเนินการเพิ่มค่า/ลดค่า");
        lesson3.addPageContent(5, "content",
                "ตัวดำเนินการเพิ่มค่าและลดค่าค่าของตัวแปรทีละ 1\n\n" +

                        "### ตัวอย่างของตัวดำเนินการเพิ่มค่า/ลดค่า\n\n" +
                        "1. `++` คือ เพิ่มค่าขึ้น 1\n" +
                        "   let h = 5;\n" +
                        "   h++;  // ผลลัพธ์: 6\n\n" +

                        "2. `--` คือ ลดค่าลง 1\n" +
                        "   let i = 5;\n" +
                        "   i--;  // ผลลัพธ์: 4\n"
        );

        Lesson lesson4 = new Lesson("4. คำสั่งควบคุม (Control Statements)", "คำสั่งควบคุม คือ คำสั่งที่ใช้สำหรับกำหนดลำดับการทำงานของโปรแกรม");

        lesson4.addPageContent(1, "title", "if else");
        lesson4.addPageContent(1, "content",
                "ใช้สำหรับตรวจสอบเงื่อนไข\n\n" +

                        "### ตัวอย่างของ if else\n\n" +
                        "let age = 18;\n" +
                        "if (age >= 18) {\n" +
                        "    console.log(\"ลงทะเบียนได้\");\n" +
                        "} else {\n" +
                        "    console.log(\"ลงทะเบียนไม่ได้\");\n" +
                        "}\n\n" +

                        "### if else if else\n\n" +
                        "ใช้เมื่อมีหลายเงื่อนไข\n\n" +
                        "let score = 85;\n" +
                        "if (score >= 90) {\n" +
                        "    console.log(\"Grade A\");\n" +
                        "} else if (score >= 80) {\n" +
                        "    console.log(\"Grade B\");\n" +
                        "} else if (score >= 70) {\n" +
                        "    console.log(\"Grade C\");\n" +
                        "} else {\n" +
                        "    console.log(\"Grade F\");\n" +
                        "}\n"
        );

        lesson4.addPageContent(2, "title", "switch case");
        lesson4.addPageContent(2, "content",
                "ใช้ในกรณีหลายเงื่อนไข\n\n" +

                        "### ตัวอย่างของ switch case\n\n" +
                        "let day = \"Monday\";\n" +
                        "switch (day) {\n" +
                        "    case \"Monday\":\n" +
                        "        console.log(\"เริ่มต้นสัปดาห์ใหม่\");\n" +
                        "        break;\n" +
                        "    case \"Friday\":\n" +
                        "        console.log(\"วันศุกร์แล้ว\");\n" +
                        "        break;\n" +
                        "    default:\n" +
                        "        console.log(\"เป็นวันธรรมดา\");\n" +
                        "}\n"
        );

        lesson4.addPageContent(3, "title", "for");
        lesson4.addPageContent(3, "content",
                "ใช้สำหรับวนซ้ำตามจำนวนรอบที่กำหนด\n\n" +

                        "### ตัวอย่างของ for\n\n" +
                        "for (let i = 1; i <= 5; i++) {\n" +
                        "    console.log(\"รอบที่\", i);\n" +
                        "}\n\n" +
                        "จะได้ Output:\n" +
                        "รอบที่ 1\n" +
                        "รอบที่ 2\n" +
                        "รอบที่ 3\n" +
                        "รอบที่ 4\n" +
                        "รอบที่ 5\n"
        );

        lesson4.addPageContent(4, "title", "while");
        lesson4.addPageContent(4, "content",
                "ใช้วนซ้ำจนกว่าเงื่อนไขจะเป็น false\n\n" +

                        "### ตัวอย่างของ while\n\n" +
                        "let count = 1;\n" +
                        "while (count <= 3) {\n" +
                        "    console.log(\"รอบที่\", count);\n" +
                        "    count++;\n" +
                        "}\n\n" +
                        "จะได้ Output:\n" +
                        "รอบที่ 1\n" +
                        "รอบที่ 2\n" +
                        "รอบที่ 3\n"
        );

        lesson4.addPageContent(5, "title", "do while");
        lesson4.addPageContent(5, "content",
                "ใช้ทำงานก่อนแล้วค่อยตรวจสอบเงื่อนไข\n\n" +

                        "### ตัวอย่างของ do while\n\n" +
                        "let num = 1;\n" +
                        "do {\n" +
                        "    console.log(\"รอบที่\", num);\n" +
                        "    num++;\n" +
                        "} while (num <= 3);\n\n" +
                        "จะได้ Output:\n" +
                        "รอบที่ 1\n" +
                        "รอบที่ 2\n" +
                        "รอบที่ 3\n"
        );

        lesson4.addPageContent(6, "title", "for of");
        lesson4.addPageContent(6, "content",
                "ใช้วนซ้ำกับอาร์เรย์\n\n" +

                        "### ตัวอย่างของ for of\n\n" +
                        "let fruits = [\"Apple\", \"Banana\", \"Cherry\"];\n" +
                        "for (let fruit of fruits) {\n" +
                        "    console.log(fruit);\n" +
                        "}\n\n" +
                        "จะได้ Output:\n" +
                        "Apple\n" +
                        "Banana\n" +
                        "Cherry\n"
        );

        lesson4.addPageContent(7, "title", "for in");
        lesson4.addPageContent(7, "content",
                "ใช้วนซ้ำกับอ็อบเจ็กต์\n\n" +

                        "### ตัวอย่างของ for in\n\n" +
                        "let person = { name: \"John\", age: 30 };\n" +
                        "for (let key in person) {\n" +
                        "    console.log(key, \":\", person[key]);\n" +
                        "}\n\n" +
                        "จะได้ Output:\n" +
                        "name: John\n" +
                        "age: 30\n"
        );

        lesson4.addPageContent(8, "title", "break");
        lesson4.addPageContent(8, "content",
                "ใช้หยุดการทำงานของลูปทันที\n\n" +

                        "### ตัวอย่างของ break\n\n" +
                        "for (let i = 1; i <= 10; i++) {\n" +
                        "    if (i === 5) {\n" +
                        "        break; // หยุดเมื่อ i เท่ากับ 5\n" +
                        "    }\n" +
                        "    console.log(i);\n" +
                        "}\n\n" +
                        "จะได้ Output:\n" +
                        "1\n" +
                        "2\n" +
                        "3\n" +
                        "4\n"
        );

        lesson4.addPageContent(9, "title", "continue");
        lesson4.addPageContent(9, "content",
                "ใช้ข้ามรอบที่ตรงเงื่อนไข แล้วทำรอบถัดไป\n\n" +

                        "### ตัวอย่างของ continue\n\n" +
                        "for (let i = 1; i <= 5; i++) {\n" +
                        "    if (i === 3) {\n" +
                        "        continue; // ข้ามรอบที่ i เท่ากับ 3\n" +
                        "    }\n" +
                        "    console.log(i);\n" +
                        "}\n\n" +
                        "จะได้ Output:\n" +
                        "1\n" +
                        "2\n" +
                        "4\n" +
                        "5\n"
        );

        lesson4.addPageContent(10, "title", "return");
        lesson4.addPageContent(10, "content",
                "ใช้ในฟังก์ชันเพื่อหยุดการทำงานและส่งค่ากลับ\n\n" +

                        "### ตัวอย่างของ return\n\n" +
                        "function add(a, b) {\n" +
                        "    return a + b;\n" +
                        "}\n\n" +
                        "console.log(add(5, 3));\n\n" +
                        "จะได้ Output:\n" +
                        "8\n"
        );

        Lesson lesson5 = new Lesson("5. ฟังก์ชัน (Function)", "ฟังก์ชัน คือ กลุ่มของคำสั่งที่ใช้ทำงานเฉพาะเจาะจง โดยสามารถเรียกใช้ซ้ำได้ ช่วยให้โค้ดอ่านง่ายและลดความซ้ำซ้อน");

        lesson5.addPageContent(1, "title", "ฟังก์ชันแบบปกติ (Function Declaration)");
        lesson5.addPageContent(1, "content",
                "ฟังก์ชันนี้ไม่มีพารามิเตอร์ และต้องเรียกใช้งานโดยใช้ sayHello();\n\n" +

                        "function sayHello() {\n" +
                        "    console.log(\"Hello, JavaScript\");\n" +
                        "}\n\n" +
                        "sayHello();\n\n" +
                        "จะได้ Output\n" +
                        "Hello, JavaScript\n"
        );

        lesson5.addPageContent(2, "title", "ฟังก์ชันแบบมีพารามิเตอร์ (Function with Parameters)");
        lesson5.addPageContent(2, "content",
                "ฟังก์ชันนี้รับพารามิเตอร์ name และนำไปใช้ภายในฟังก์ชัน\n\n" +

                        "function greet(name) {\n" +
                        "    console.log(\"Hello, \" + name + \"!\");\n" +
                        "}\n\n" +
                        "greet(\"Alice\");\n" +
                        "greet(\"Bob\");\n\n" +
                        "จะได้ Output\n" +
                        "Hello, Alice!\n" +
                        "Hello, Bob!\n"
        );

        lesson5.addPageContent(3, "title", "ฟังก์ชันที่มีการคืนค่า (Function with Return)");
        lesson5.addPageContent(3, "content",
                "return ใช้ส่งค่ากลับจากฟังก์ชัน และสามารถเก็บค่าไว้ในตัวแปรได้\n\n" +

                        "function add(a, b) {\n" +
                        "    return a + b;\n" +
                        "}\n\n" +
                        "let result = add(5, 3);\n" +
                        "console.log(result);\n\n" +
                        "จะได้ Output\n" +
                        "8\n"
        );

        lesson5.addPageContent(4, "title", "ฟังก์ชันแบบ Expression (Function Expression)");
        lesson5.addPageContent(4, "content",
                "ฟังก์ชันแบบนี้ไม่มีชื่อ และต้องกำหนดให้ตัวแปร multiply\n\n" +

                        "const multiply = function(x, y) {\n" +
                        "    return x * y;\n" +
                        "};\n\n" +
                        "console.log(multiply(4, 5));\n\n" +
                        "จะได้ Output\n" +
                        "20\n"
        );

        lesson5.addPageContent(5, "title", "ฟังก์ชันลูกศร (Arrow Function)");
        lesson5.addPageContent(5, "content",
                "รูปแบบย่อของฟังก์ชันแบบ Expression\n\n" +

                        "const subtract = (a, b) => a - b;\n" +
                        "console.log(subtract(10, 3));\n\n" +
                        "จะได้ Output\n" +
                        "7\n"
        );

        lesson5.addPageContent(6, "title", "ฟังก์ชันที่รับพารามิเตอร์ไม่จำกัด (Rest Parameter)");
        lesson5.addPageContent(6, "content",
                "...numbers เป็น Rest Parameter ทำให้รับค่าหลายตัวได้\n\n" +

                        "function sum(...numbers) {\n" +
                        "    return numbers.reduce((total, num) => total + num, 0);\n" +
                        "}\n\n" +
                        "console.log(sum(1, 2, 3, 4, 5));\n\n" +
                        "จะได้ Output\n" +
                        "15\n"
        );

        lesson5.addPageContent(7, "title", "ฟังก์ชันแบบ Default Parameter");
        lesson5.addPageContent(7, "content",
                "ถ้าไม่ส่งค่าเข้าไป จะใช้ค่า \"Guest\" ตามค่าเริ่มต้น\n\n" +

                        "function greet(name = \"Guest\") {\n" +
                        "    console.log(\"Hello, \" + name);\n" +
                        "}\n\n" +
                        "greet(); // ไม่ส่งค่า\n" +
                        "greet(\"Charlie\");\n\n" +
                        "จะได้ Output\n" +
                        "Hello, Guest\n" +
                        "Hello, Charlie\n"
        );

        lesson5.addPageContent(8, "title", "ฟังก์ชันภายในฟังก์ชัน (Nested Function)");
        lesson5.addPageContent(8, "content",
                "ฟังก์ชันภายในจะถูกเรียกใช้ได้ก็ต่อเมื่อฟังก์ชันหลักถูกเรียก\n\n" +

                        "function outerFunction() {\n" +
                        "    console.log(\"This is outer function\");\n\n" +
                        "    function innerFunction() {\n" +
                        "        console.log(\"This is inner function\");\n" +
                        "    }\n" +
                        "    innerFunction();\n" +
                        "}\n\n" +
                        "outerFunction();\n\n" +
                        "จะได้ Output\n" +
                        "This is outer function\n" +
                        "This is inner function\n"
        );

        // Use the full lesson title as the key
        lessons.put("1. ชนิดข้อมูล (Data Types)", lesson1);
        lessons.put("2. ตัวแปร (Variables)", lesson2);
        lessons.put("3. ตัวดำเนินการ (Operators)", lesson3);
        lessons.put("4. คำสั่งควบคุม (Control Statements)", lesson4);
        lessons.put("5. ฟังก์ชัน (Function)", lesson5);

    }

    // Existing methods remain the same
    public static List<Lesson> getAllLessons() {
        return new ArrayList<>(lessons.values());
    }

    public static String getLessonContent(String lessonTitle, int page, String parameter) {
        Lesson lesson = lessons.get(lessonTitle);
        return (lesson != null) ? lesson.getPageContent(page, parameter) : "Lesson not found";
    }

    public static int getMaxPage(String lessonTitle) {
        Lesson lesson = lessons.get(lessonTitle);
        return (lesson != null) ? lesson.getMaxPage() : -1;
    }

    public static int getQuizQuestionCount(String lessonTitle) {
        // คืนค่าจำนวนคำถามสำหรับบทเรียนที่ระบุ
        switch (lessonTitle) {
            case "1. ชนิดข้อมูล (Data Types)":
            case "2. ตัวแปร (Variables)":
            case "3. ตัวดำเนินการ (Operators)":
            case "4. คำสั่งควบคุม (Control Statements)":
            case "5. ฟังก์ชัน (Function)":
                return 10;
            default:
                return 0;
        }
    }

    public static String getQuizQuestionText(String lessonTitle, int questionNumber) {
        // คืนค่าข้อความคำถามสำหรับแต่ละหัวข้อ โดยอ้างอิงจากเนื้อหาบทเรียน
        switch (lessonTitle) {
            case "1. ชนิดข้อมูล (Data Types)":
                switch (questionNumber) {
                    case 1: return "ข้อใดไม่ใช่ชนิดข้อมูลพื้นฐานที่กล่าวถึงในบทเรียนนี้?";
                    case 2: return "ในการประกาศ String สามารถใช้เครื่องหมายใดได้บ้าง?";
                    case 3: return "เครื่องหมายสำหรับ Template Literal คือเครื่องหมายอะไร?";
                    case 4: return "ผลลัพธ์ของ typeof null คืออะไร?";
                    case 5: return "ผลลัพธ์ของการคำนวณ 'Hello' * 2 ใน JavaScript คืออะไร?";
                    case 6: return "ข้อใดเป็นค่าที่แปลงเป็น false เมื่อใช้ Boolean()?";
                    case 7: return "ในบทเรียน ค่าที่ถูกกำหนดโดยเจตนาเพื่อแทน 'ค่าว่าง' คืออะไร?";
                    case 8: return "การต่อข้อความ (Concatenation) ใน JavaScript ใช้เครื่องหมายใด?";
                    case 9: return "ผลลัพธ์ของ typeof NaN คืออะไร?";
                    case 10: return "ข้อใดคือคำอธิบายที่ถูกต้องเกี่ยวกับ String ในบทเรียนนี้?";
                    default: return "ไม่พบคำถาม";
                }
            case "2. ตัวแปร (Variables)":
                switch (questionNumber) {
                    case 1: return "คำสั่งใดไม่แนะนำให้ใช้ประกาศตัวแปรใน JavaScript?";
                    case 2: return "ตัวแปรที่ประกาศด้วย let มีขอบเขตแบบใด?";
                    case 3: return "ตัวแปรที่ประกาศด้วย const มีคุณสมบัติใด?";
                    case 4: return "ถ้าประกาศตัวแปรด้วย var ภายใน if แล้วเข้าถึงนอก if จะเกิดอะไรขึ้น?";
                    case 5: return "การประกาศตัวแปรซ้ำใน Scope เดียวกันด้วย let จะเกิดผลลัพธ์อย่างไร?";
                    case 6: return "ในการประกาศ const ต้องกำหนดค่าเริ่มต้นหรือไม่?";
                    case 7: return "ข้อใดถูกต้องเกี่ยวกับความแตกต่างระหว่าง var กับ let?";
                    case 8: return "ปัญหาของ var ที่เกิดจาก hoisting คืออะไร?";
                    case 9: return "ข้อใดไม่อนุญาตให้เปลี่ยนแปลงค่าได้หลังประกาศ?";
                    case 10: return "คำแนะนำในการประกาศตัวแปรที่ดีคืออะไร?";
                    default: return "ไม่พบคำถาม";
                }
            case "3. ตัวดำเนินการ (Operators)":
                switch (questionNumber) {
                    case 1: return "เครื่องหมาย '+' เมื่อใช้กับตัวเลขใน JavaScript หมายถึงอะไร?";
                    case 2: return "เครื่องหมาย '%' ใน JavaScript ใช้สำหรับการทำงานใด?";
                    case 3: return "เครื่องหมาย '**' ใช้สำหรับทำอะไร?";
                    case 4: return "ตัวดำเนินการ '==' ใช้ตรวจสอบอะไร?";
                    case 5: return "ตัวดำเนินการ '===' ตรวจสอบอะไรเพิ่มเติมจาก '=='?";
                    case 6: return "ผลลัพธ์ของ 5 == '5' คืออะไร?";
                    case 7: return "ผลลัพธ์ของ 5 === '5' คืออะไร?";
                    case 8: return "เครื่องหมาย '&&' ใช้สำหรับตรวจสอบเงื่อนไขอย่างไร?";
                    case 9: return "เครื่องหมาย '||' ใช้สำหรับตรวจสอบเงื่อนไขอย่างไร?";
                    case 10: return "เครื่องหมาย '!' ใน JavaScript มีหน้าที่ทำอะไร?";
                    default: return "ไม่พบคำถาม";
                }
            case "4. คำสั่งควบคุม (Control Statements)":
                switch (questionNumber) {
                    case 1: return "คำสั่ง if ใช้สำหรับอะไรใน JavaScript?";
                    case 2: return "คำสั่ง switch ใช้สำหรับกรณีใด?";
                    case 3: return "คำสั่ง for ใช้สำหรับทำอะไร?";
                    case 4: return "คำสั่ง while ใช้สำหรับอะไร?";
                    case 5: return "ความแตกต่างระหว่าง while กับ do while คืออะไร?";
                    case 6: return "คำสั่ง for of ใช้สำหรับทำอะไร?";
                    case 7: return "คำสั่ง for in ใช้สำหรับทำอะไร?";
                    case 8: return "คำสั่ง break ใช้เพื่อวัตถุประสงค์ใด?";
                    case 9: return "คำสั่ง continue ใช้เพื่อวัตถุประสงค์ใด?";
                    case 10: return "คำสั่ง return ในฟังก์ชันมีหน้าที่อะไร?";
                    default: return "ไม่พบคำถาม";
                }
            case "5. ฟังก์ชัน (Function)":
                switch (questionNumber) {
                    case 1: return "ฟังก์ชัน Declaration คืออะไร?";
                    case 2: return "ฟังก์ชันที่มีพารามิเตอร์ (Function with Parameters) มีลักษณะอย่างไร?";
                    case 3: return "ฟังก์ชันที่มีการคืนค่าควรใช้คำสั่งใด?";
                    case 4: return "ฟังก์ชัน Expression คืออะไร?";
                    case 5: return "ฟังก์ชัน Arrow (Arrow Function) มีลักษณะพิเศษอย่างไร?";
                    case 6: return "Rest Parameter ในฟังก์ชันใช้เพื่ออะไร?";
                    case 7: return "Default Parameter คืออะไร?";
                    case 8: return "ฟังก์ชัน Nested หมายถึงอะไร?";
                    case 9: return "ในการเรียกใช้ฟังก์ชันแบบ Declaration ทำได้อย่างไร?";
                    case 10: return "ข้อใดถูกต้องเกี่ยวกับฟังก์ชันใน JavaScript ตามบทเรียนนี้?";
                    default: return "ไม่พบคำถาม";
                }
            default:
                return "ไม่พบคำถาม";
        }
    }

    public static String[] getQuizQuestionOptions(String lessonTitle, int questionNumber) {
        switch (lessonTitle) {
            case "1. ชนิดข้อมูล (Data Types)":
                switch (questionNumber) {
                    case 1: return new String[]{
                            "String, Number, Boolean",
                            "String, Number, Boolean, Array",
                            "Number, Boolean, Object",
                            "Boolean, Array, Function"
                    };
                    case 2: return new String[]{
                            "ใช้ได้เฉพาะเครื่องหมายเดี่ยว",
                            "ใช้ได้เฉพาะเครื่องหมายคู่",
                            "ใช้ได้ทั้ง ' ', \" \", และ ` `",
                            "ใช้ได้เฉพาะ ` `"
                    };
                    case 3: return new String[]{
                            "' '",
                            "\" \"",
                            "` `",
                            "ไม่มีข้อถูก"
                    };
                    case 4: return new String[]{
                            "null",
                            "undefined",
                            "object",
                            "number"
                    };
                    case 5: return new String[]{
                            "0",
                            "undefined",
                            "NaN",
                            "Error"
                    };
                    case 6: return new String[]{
                            "0",
                            "1",
                            "\"\"",
                            "true"
                    };
                    case 7: return new String[]{
                            "undefined",
                            "null",
                            "NaN",
                            "false"
                    };
                    case 8: return new String[]{"+", "&", "*", "-"};
                    case 9: return new String[]{
                            "number",
                            "object",
                            "NaN",
                            "undefined"
                    };
                    case 10: return new String[]{
                            "String ต้องอยู่ในเครื่องหมายเดียวเท่านั้น",
                            "สามารถใช้เครื่องหมายเดี่ยว คู่ หรือแบ็คติ๊กได้",
                            "Template Literal ต้องใช้เครื่องหมายคู่เท่านั้น",
                            "ไม่สามารถประกาศ String ด้วยเครื่องหมายแบ็คติ๊กได้"
                    };
                    default: return new String[]{};
                }
            case "2. ตัวแปร (Variables)":
                switch (questionNumber) {
                    case 1: return new String[]{"var", "let", "const", "ทั้ง let และ const"};
                    case 2: return new String[]{"Global", "Function", "Block", "Module"};
                    case 3: return new String[]{"ไม่สามารถเปลี่ยนค่าได้", "มี Block Scope", "ต้องกำหนดค่าเริ่มต้น", "ทั้งหมดถูก"};
                    case 4: return new String[]{"เกิด Error", "ค่าที่ประกาศใน if สามารถเข้าถึงได้", "undefined", "null"};
                    case 5: return new String[]{"ทำงานตามปกติ", "Overwrites ค่าเดิม", "เกิด Error", "ค่าที่ประกาศล่าสุดจะได้ผล"};
                    case 6: return new String[]{"ต้องกำหนดค่าเริ่มต้น", "ไม่จำเป็นต้องกำหนด", "สามารถเปลี่ยนแปลงได้", "ขึ้นอยู่กับบริบท"};
                    case 7: return new String[]{"var ไม่มี hoisting", "let มี Block Scope", "ทั้ง 2 ข้อถูก", "ไม่มีข้อถูก"};
                    case 8: return new String[]{"เข้าถึงได้ก่อนประกาศ", "ให้ค่าเป็น undefined", "เกิด Error", "ไม่ส่งผลใด ๆ"};
                    case 9: return new String[]{"var", "let", "const", "function"};
                    case 10: return new String[]{"ใช้ var", "ใช้ let หรือ const", "ใช้ทุกแบบได้", "ไม่มีข้อถูก"};
                    default: return new String[]{};
                }
            case "3. ตัวดำเนินการ (Operators)":
                // ปรับลำดับตัวเลือกให้คำตอบถูกไม่ใช่ตัวเลือกแรกเสมอ
                switch (questionNumber) {
                    case 1: return new String[]{
                            "คูณ", "ลบ", "บวก", "หาร"
                    }; // "บวก" อยู่ที่ index 2
                    case 2: return new String[]{
                            "บวก", "หารเอาเศษ", "หาร", "ลบ"
                    }; // "หารเอาเศษ" อยู่ที่ index 1
                    case 3: return new String[]{
                            "บวก", "ลบ", "คูณ", "ยกกำลัง"
                    }; // "ยกกำลัง" อยู่ที่ index 3
                    case 4: return new String[]{
                            "ตรวจสอบชนิดเท่านั้น", "ตรวจสอบทั้งค่าและชนิด", "ตรวจสอบค่าเท่ากัน", "ไม่ตรวจสอบอะไรเลย"
                    }; // "ตรวจสอบค่าเท่ากัน" อยู่ที่ index 2
                    case 5: return new String[]{
                            "ตรวจสอบค่าเท่ากัน", "ตรวจสอบทั้งค่าและชนิด", "ตรวจสอบชนิดเท่านั้น", "ไม่ตรวจสอบ"
                    }; // "ตรวจสอบทั้งค่าและชนิด" อยู่ที่ index 1
                    case 6: return new String[]{
                            "false", "NaN", "true", "undefined"
                    }; // "true" อยู่ที่ index 2
                    case 7: return new String[]{
                            "NaN", "false", "undefined", "true"
                    }; // "false" อยู่ที่ index 1
                    case 8: return new String[]{
                            "อย่างน้อยหนึ่งเงื่อนไขเป็นจริง", "ทั้งคู่เป็นเท็จ", "ทั้งสองเงื่อนไขต้องเป็นจริง", "ไม่มีข้อถูก"
                    }; // "ทั้งสองเงื่อนไขต้องเป็นจริง" อยู่ที่ index 2
                    case 9: return new String[]{
                            "ทั้งสองเงื่อนไขเป็นจริง", "ไม่สามารถใช้งานได้", "อย่างน้อยหนึ่งเงื่อนไขเป็นจริง", "ทั้งคู่เป็นเท็จ"
                    }; // "อย่างน้อยหนึ่งเงื่อนไขเป็นจริง" อยู่ที่ index 2
                    case 10: return new String[]{
                            "ตรวจสอบค่า", "เพิ่มค่าขึ้น", "ลดค่าลง", "กลับค่าความจริงตรงกันข้าม"
                    }; // "กลับค่าความจริงตรงกันข้าม" อยู่ที่ index 3
                    default: return new String[]{};
                }
            case "4. คำสั่งควบคุม (Control Statements)":
                // ปรับลำดับตัวเลือกใหม่เพื่อให้กระจายคำตอบที่ถูกต้อง
                switch (questionNumber) {
                    case 1: return new String[]{
                            "วนลูป", "ประกาศตัวแปร", "ตรวจสอบเงื่อนไข", "สร้างฟังก์ชัน"
                    }; // Correct: "ตรวจสอบเงื่อนไข" index 2
                    case 2: return new String[]{
                            "วนลูป", "ตรวจสอบหลายเงื่อนไข", "ประกาศตัวแปร", "เรียกฟังก์ชัน"
                    }; // Correct: index 1
                    case 3: return new String[]{
                            "ประกาศตัวแปร", "ตรวจสอบเงื่อนไข", "วนลูปตามจำนวนรอบ", "เรียกฟังก์ชัน"
                    }; // Correct: index 2
                    case 4: return new String[]{
                            "ประกาศตัวแปร", "เรียกฟังก์ชัน", "วนลูปจนกว่าเงื่อนไขจะเป็น false", "วนลูปตามจำนวนรอบ"
                    }; // Correct: index 2
                    case 5: return new String[]{
                            "while ทำงานก่อนตรวจสอบเงื่อนไข", "ไม่มีความแตกต่าง", "ทั้งคู่ทำงานแบบเดียวกัน", "do while ทำงานก่อนตรวจสอบเงื่อนไข"
                    }; // Correct: index 3
                    case 6: return new String[]{
                            "ตรวจสอบเงื่อนไข", "วนลูปในอาร์เรย์", "ประกาศตัวแปร", "วนลูปในอ็อบเจ็กต์"
                    }; // Correct: index 1 ("วนลูปในอาร์เรย์")
                    case 7: return new String[]{
                            "ตรวจสอบเงื่อนไข", "วนลูปในอาร์เรย์", "ประกาศตัวแปร", "วนลูปในอ็อบเจ็กต์"
                    }; // Correct: index 3 ("วนลูปในอ็อบเจ็กต์")
                    case 8: return new String[]{
                            "ส่งค่ากลับ", "เริ่มใหม่", "ข้ามรอบปัจจุบัน", "หยุดลูปทันที"
                    }; // Correct: index 3
                    case 9: return new String[]{
                            "ส่งค่ากลับ", "เริ่มใหม่", "ข้ามรอบปัจจุบัน", "หยุดลูป"
                    }; // Correct: index 2
                    case 10: return new String[]{
                            "วนลูป", "ประกาศตัวแปร", "ตรวจสอบเงื่อนไข", "ส่งค่ากลับและหยุดการทำงาน"
                    }; // Correct: index 3
                    default: return new String[]{};
                }
            case "5. ฟังก์ชัน (Function)":
                // ปรับลำดับตัวเลือกใหม่
                switch (questionNumber) {
                    case 1: return new String[]{
                            "ฟังก์ชันที่ไม่มีชื่อ",
                            "ฟังก์ชันที่ใช้ arrow syntax",
                            "ฟังก์ชันภายในฟังก์ชัน",
                            "ฟังก์ชันที่ประกาศด้วย function ตามด้วยชื่อฟังก์ชัน"
                    }; // Correct: index 3
                    case 2: return new String[]{
                            "ฟังก์ชันที่ไม่มีการส่งค่ากลับ",
                            "ฟังก์ชันที่รับพารามิเตอร์จากภายนอก",
                            "ฟังก์ชันที่คืนค่าเท่านั้น",
                            "ฟังก์ชันที่ไม่มีชื่อ"
                    }; // Correct: index 1
                    case 3: return new String[]{
                            "yield", "return", "exit", "break"
                    }; // Correct: index 1
                    case 4: return new String[]{
                            "ฟังก์ชันที่ไม่มีชื่อ",
                            "ฟังก์ชัน Arrow",
                            "ฟังก์ชันที่ประกาศด้วยการกำหนดให้ตัวแปร",
                            "ทั้ง A และ B"
                    }; // Correct: index 3
                    case 5: return new String[]{
                            "ฟังก์ชันที่ส่งค่ากลับอัตโนมัติ",
                            "ทั้ง A และ B",
                            "ฟังก์ชันที่ไม่มีชื่อ",
                            "รูปแบบย่อของฟังก์ชัน"
                    }; // Correct: index 3
                    case 6: return new String[]{
                            "ใช้สำหรับส่งค่ากลับ",
                            "ใช้สำหรับประกาศฟังก์ชันภายใน",
                            "ใช้สำหรับรับพารามิเตอร์จำนวนไม่จำกัด",
                            "ใช้สำหรับกำหนดค่าเริ่มต้นให้พารามิเตอร์"
                    }; // Correct: index 2
                    case 7: return new String[]{
                            "พารามิเตอร์ที่ถูกส่งเข้ามาในรูปแบบอาร์เรย์",
                            "พารามิเตอร์ที่มีค่าเริ่มต้น",
                            "ทั้ง A และ C",
                            "พารามิเตอร์ที่ไม่สามารถเปลี่ยนแปลงได้"
                    }; // Correct: index 2
                    case 8: return new String[]{
                            "ฟังก์ชัน Arrow",
                            "ฟังก์ชันที่ถูกประกาศในระดับ Global",
                            "ฟังก์ชันที่ไม่มีพารามิเตอร์",
                            "ฟังก์ชันที่ประกาศภายในฟังก์ชันอื่น"
                    }; // Correct: index 3
                    case 9: return new String[]{
                            "เรียกใช้ผ่านตัวแปรที่เก็บฟังก์ชัน",
                            "เรียกใช้โดยใช้ชื่อฟังก์ชัน",
                            "ทั้ง A และ B",
                            "เรียกใช้ผ่าน return statement"
                    }; // Correct: index 2
                    case 10: return new String[]{
                            "ฟังก์ชันสามารถรับพารามิเตอร์ได้",
                            "ฟังก์ชันสามารถส่งกลับเป็นค่าได้",
                            "ฟังก์ชันสามารถเก็บเป็นตัวแปรได้",
                            "ทั้งหมดถูก"
                    }; // Correct: index 3
                    default: return new String[]{};
                }
            default:
                return new String[]{};
        }
    }

    public static int getQuizQuestionCorrectIndex(String lessonTitle, int questionNumber) {
        switch (lessonTitle) {
            case "1. ชนิดข้อมูล (Data Types)":
                switch (questionNumber) {
                    case 1: return 1;  // "String, Number, Boolean, Array"
                    case 2: return 2;  // "ใช้ได้ทั้ง ' ', \" \", และ ` `"
                    case 3: return 2;  // "` `"
                    case 4: return 2;  // "object"
                    case 5: return 2;  // "NaN"
                    case 6: return 0;  // "0"
                    case 7: return 1;  // "null"
                    case 8: return 0;  // "+"
                    case 9: return 0;  // "number"
                    case 10: return 1; // "สามารถใช้เครื่องหมายเดี่ยว คู่ หรือแบ็คติ๊กได้"
                    default: return -1;
                }
            case "2. ตัวแปร (Variables)":
                switch (questionNumber) {
                    case 1: return 0;  // "var"
                    case 2: return 2;  // "Block"
                    case 3: return 3;  // "ทั้งหมดถูก"
                    case 4: return 1;  // "ค่าที่ประกาศใน if สามารถเข้าถึงได้"
                    case 5: return 2;  // "เกิด Error"
                    case 6: return 0;  // "ต้องกำหนดค่าเริ่มต้น"
                    case 7: return 1;  // "let มี Block Scope"
                    case 8: return 1;  // "ให้ค่าเป็น undefined"
                    case 9: return 2;  // "const"
                    case 10: return 1; // "ใช้ let หรือ const"
                    default: return -1;
                }
            case "3. ตัวดำเนินการ (Operators)":
                switch (questionNumber) {
                    case 1: return 2;  // "บวก" อยู่ที่ index 2
                    case 2: return 1;  // "หารเอาเศษ" อยู่ที่ index 1
                    case 3: return 3;  // "ยกกำลัง" อยู่ที่ index 3
                    case 4: return 2;  // "ตรวจสอบค่าเท่ากัน" อยู่ที่ index 2
                    case 5: return 1;  // "ตรวจสอบทั้งค่าและชนิด" อยู่ที่ index 1
                    case 6: return 2;  // "true" อยู่ที่ index 2
                    case 7: return 1;  // "false" อยู่ที่ index 1
                    case 8: return 2;  // "ทั้งสองเงื่อนไขต้องเป็นจริง" อยู่ที่ index 2
                    case 9: return 2;  // "อย่างน้อยหนึ่งเงื่อนไขเป็นจริง" อยู่ที่ index 2
                    case 10: return 3; // "กลับค่าความจริงตรงกันข้าม" อยู่ที่ index 3
                    default: return -1;
                }
            case "4. คำสั่งควบคุม (Control Statements)":
                switch (questionNumber) {
                    case 1: return 2;  // "ตรวจสอบเงื่อนไข" อยู่ที่ index 2
                    case 2: return 1;  // "ตรวจสอบหลายเงื่อนไข" อยู่ที่ index 1
                    case 3: return 2;  // "วนลูปตามจำนวนรอบ" อยู่ที่ index 2
                    case 4: return 2;  // "วนลูปจนกว่าเงื่อนไขจะเป็น false" อยู่ที่ index 2
                    case 5: return 3;  // "do while ทำงานก่อนตรวจสอบเงื่อนไข" อยู่ที่ index 3
                    case 6: return 1;  // "วนลูปในอาร์เรย์" อยู่ที่ index 1
                    case 7: return 3;  // "วนลูปในอ็อบเจ็กต์" อยู่ที่ index 3
                    case 8: return 3;  // "หยุดลูปทันที" อยู่ที่ index 3
                    case 9: return 2;  // "ข้ามรอบปัจจุบัน" อยู่ที่ index 2
                    case 10: return 3; // "ส่งค่ากลับและหยุดการทำงาน" อยู่ที่ index 3
                    default: return -1;
                }
            case "5. ฟังก์ชัน (Function)":
                switch (questionNumber) {
                    case 1: return 3;  // "ฟังก์ชันที่ประกาศด้วย function ตามด้วยชื่อ" อยู่ที่ index 3
                    case 2: return 1;  // "ฟังก์ชันที่รับพารามิเตอร์จากภายนอก" อยู่ที่ index 1
                    case 3: return 1;  // "return" อยู่ที่ index 1
                    case 4: return 3;  // "ทั้ง A และ B" อยู่ที่ index 3
                    case 5: return 3;  // "รูปแบบย่อของฟังก์ชัน" อยู่ที่ index 3
                    case 6: return 2;  // "ใช้สำหรับรับพารามิเตอร์จำนวนไม่จำกัด" อยู่ที่ index 2
                    case 7: return 2;  // "ทั้ง A และ C" อยู่ที่ index 2
                    case 8: return 3;  // "ฟังก์ชันที่ประกาศภายในฟังก์ชันอื่น" อยู่ที่ index 3
                    case 9: return 2;  // "ทั้ง A และ B" อยู่ที่ index 2
                    case 10: return 3; // "ทั้งหมดถูก" อยู่ที่ index 3
                    default: return -1;
                }
            default:
                return -1;
        }
    }
}