window.onload = async function() {
    console.log("DOM Loaded, calling getAllCourse()");
    await getAllCourse();
}

// fetch('http://localhost:8080/api/userinfo')

//     .then(response => response.json())
//     .then(data => {
//         console.log(data);
//         const list = document.getElementById('userlist');
//         data.forEach(user => {
//             const li = document.createElement('li');
//             li.textContent = `ID: ${user.id} | Name: ${user.name} | Email: ${user.email} | Password: ${user.passwd} | UserType: ${user.type}`
//             list.appendChild(li);
//         });
//     });

async function getAllCourse(){
    try {
        const response = await fetch("http://localhost:8080/api/course");

        if (!response.ok) {
            throw new Error(`HTTP error! status: ${response.status}`);
        }

        const data = await response.json(); // แปลง response เป็น JSON
        console.log(data); // แสดงข้อมูลที่ดึงมาใน console

        // สมมุติว่าเราแสดง users ใน <ul id="userlist">
        const courseList = document.getElementById("card-content");
        courseList.innerHTML = ""; // ล้างก่อนเพิ่มใหม่
        data.forEach(course => {
            const cardDiv = document.createElement("div");
            cardDiv.classList.add("card");

            const cardImg = document.createElement("img");
            cardImg.classList.add("card-img-top");
            console.log(course.pictureURL);
            cardImg.src = course.pictureURL;
            cardImg.alt = "courseimg";

            // สร้าง card-body
            const cardBody = document.createElement("div");
            cardBody.classList.add("card-body");

            // สร้าง title
            const cardTitle = document.createElement("h4");
            cardTitle.classList.add("card-title");
            cardTitle.textContent = course.title;

            // สร้าง description
            const cardDescription = document.createElement("p");
            cardDescription.classList.add("card-text");
            cardDescription.textContent = course.description;

            const cardInstructor = document.createElement("p");
            cardInstructor.classList.add("card-text");
            const instructorName = course.instructor.name
            cardInstructor.textContent = `Instructor: ${instructorName}`;

            const cardPrice = document.createElement("h5");
            cardPrice.classList.add("card-text");
            cardPrice.textContent = `฿ ${course.price} Baht`
            cardPrice.style = "color: #f26a17;";

            cardBody.appendChild(cardTitle);
            cardBody.appendChild(cardDescription);
            cardBody.appendChild(cardInstructor);
            cardBody.appendChild(cardPrice);
            
            cardDiv.appendChild(cardImg);
            cardDiv.appendChild(cardBody);

            courseList.appendChild(cardDiv)
            
        });

    } catch (error) {
        console.error("เกิดข้อผิดพลาดในการดึงข้อมูล:", error);
    }
}


