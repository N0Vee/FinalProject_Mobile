package com.example.finalproject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class LessonModule {
    private static final LinkedHashMap<String, Lesson> lessons = new LinkedHashMap<>();

    static {
        Lesson lesson1 = new Lesson("1. ชนิดข้อมูล (Data Types)", "ชนิดของข้อมูลและวิธีการใช้งานใน JavaScript", true, false);
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





        Lesson lesson2 = new Lesson("2. ตัวแปร (Variables)", "ตัวแปร คือ ชื่อที่ใช้เก็บข้อมูลในหน่วยความจำของโปรแกรม ซึ่งสามารถเรียกใช้และเปลี่ยนค่าได้", true, false);

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

        Lesson lesson3 = new Lesson("3. ตัวดำเนินการ (Operators)", "ตัวดำเนินการ คือคำสั่งที่ใช้สำหรับการดำเนินการทางคณิตศาสตร์ การเปรียบเทียบ และการควบคุมตรรกะต่าง ๆ", true, false);

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

        Lesson lesson4 = new Lesson("4. คำสั่งควบคุม (Control Statements)", "คำสั่งควบคุม คือ คำสั่งที่ใช้สำหรับกำหนดลำดับการทำงานของโปรแกรม", true, false);

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

        Lesson lesson5 = new Lesson("5. ฟังก์ชัน (Function)", "ฟังก์ชัน คือ กลุ่มของคำสั่งที่ใช้ทำงานเฉพาะเจาะจง โดยสามารถเรียกใช้ซ้ำได้ ช่วยให้โค้ดอ่านง่ายและลดความซ้ำซ้อน", true, false);

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
        // Return the number of quiz questions for a specific lesson
        switch (lessonTitle) {
            case "1. ชนิดข้อมูล (Data Types)":
                return 3; // Example number of questions
            case "2. ตัวแปร (Variables)":
                return 2;
            // Add more lessons as needed
            default:
                return 0;
        }
    }

    public static String getQuizQuestionText(String lessonTitle, int questionNumber) {
        // Return the text of a specific quiz question
        switch (lessonTitle) {
            case "1. ชนิดข้อมูล (Data Types)":
                switch (questionNumber) {
                    case 1: return "What is the correct way to declare a variable in Java?";
                    case 2: return "Which of these is a primitive data type in Java?";
                    case 3: return "What does the 'public static void main(String[] args)' method do?";
                    default: return "Question not found";
                }
            case "2. ตัวแปร (Variables)":
                switch (questionNumber) {
                    case 1: return "What is the main layout file for an Android activity?";
                    case 2: return "What is the purpose of the AndroidManifest.xml file?";
                    default: return "Question not found";
                }
            default:
                return "Question not found";
        }
    }

    public static String[] getQuizQuestionOptions(String lessonTitle, int questionNumber) {
        // Return the answer options for a specific quiz question
        switch (lessonTitle) {
            case "1. ชนิดข้อมูล (Data Types)":
                switch (questionNumber) {
                    case 1: return new String[]{"int x = 5;", "variable x = 5;", "x = 5;", "declare x = 5;"};
                    case 2: return new String[]{"String", "Integer", "int", "List"};
                    case 3: return new String[]{"Defines the entry point of a Java program", "Creates a new window", "Handles exceptions", "Defines a class method"};
                    default: return new String[]{};
                }
            case "2. ตัวแปร (Variables)":
                switch (questionNumber) {
                    case 1: return new String[]{"main.xml", "activity_main.xml", "layout.xml", "android_layout.xml"};
                    case 2: return new String[]{"Defines app permissions", "Creates UI layouts", "Manages network connections", "Handles database operations"};
                    default: return new String[]{};
                }
            default:
                return new String[]{};
        }
    }

    public static int getQuizQuestionCorrectIndex(String lessonTitle, int questionNumber) {
        // Return the index of the correct answer for a specific quiz question
        switch (lessonTitle) {
            case "1. ชนิดข้อมูล (Data Types)":
                switch (questionNumber) {
                    case 1: return 0; // "int x = 5;" is correct
                    case 2: return 2; // "int" is correct
                    case 3: return 0; // "Defines the entry point of a Java program" is correct
                    default: return -1;
                }
            case "2. ตัวแปร (Variables)":
                switch (questionNumber) {
                    case 1: return 1; // "activity_main.xml" is correct
                    case 2: return 0; // "Defines app permissions" is correct
                    default: return -1;
                }
            default:
                return -1;
        }
    }

    public static void markLessonCompleted(String lessonTitle) {
        // Method to mark a lesson as completed
        // This would typically update a database or shared preferences
        // For now, we'll just print a log message
        System.out.println("Lesson " + lessonTitle + " marked as completed!");
    }
}