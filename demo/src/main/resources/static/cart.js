window.onload = async function () {
    const params = new URLSearchParams(window.location.search);
    const itemID = params.get("orderitemID");
    console.log(itemID);
    await createOrder(itemID)
}

async function createOrder(itemID){
    try {
        const response = await fetch(`http://localhost:8080/api/order/${itemID}`, {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            
            body: JSON.stringify({
                orderitem: { id: itemID }
            })
        })
        if (!response.ok) {
            throw new Error(`HTTP error! status: ${response.status}`);
        }
        const data = await response.json();
        console.log(data);
        getOrder(data)
        
    } catch (error) {
        console.error("เกิดข้อผิดพลาดในการดึงข้อมูล:", error);
    }

}


async function getOrder(order){
    console.log(order.orderID);
    try {
        const items = order.itemsList;
        let cnt = 0;
        for (const item of items) {
            const courseID = item.course.courseID; // หรืออาจจะเป็น item.courseID ขึ้นอยู่กับโครงสร้างของ OrderItem
            console.log(`courseID: ${courseID}`)
            const response = await fetch(`http://localhost:8080/api/course/${courseID}`);

            if (!response.ok) {
                throw new Error(`HTTP error! status: ${response.status}`);
            }

            const coursedata = await response.json(); // แปลง response เป็น JSON
            cnt++;
            console.log(coursedata); // แสดงข้อมูลที่ดึงมาใน console

            // สมมุติว่าเราแสดง users ใน <ul id="userlist">
            // courseDetails.innerHTML = ""; // ล้างก่อนเพิ่มใหม่
            document.getElementById("course-total").textContent = `${cnt} Course in your cart`;
            const orderCard = document.getElementById("order-card");

            const card = document.createElement("div");
            card.classList.add("cart-item", "d-flex", "align-items-start");

            const img = document.createElement("img");
            img.classList.add("me-3","rounded", "order-img");
            img.src = coursedata.pictureURL;
            img.alt = "courseimg";

            const course = document.createElement("div");
            course.classList.add("flex-grow-1")

            const courseTitle = document.createElement("h5");
            courseTitle.classList.add("mb-1")
            courseTitle.textContent = `${coursedata.title}`;

            const courseInstruc = document.createElement("p");
            courseInstruc.classList.add("mb-1");
            courseInstruc.textContent = `Instructor: ${coursedata.instructor.name}`;

            const coursePrice = document.createElement("p");
            coursePrice.classList.add("course-price", "mb-1");
            coursePrice.textContent = `฿${coursedata.price}`

            const btnRemove = document.createElement("button");
            btnRemove.classList.add("btn", "btn-link","text-danger");
            btnRemove.textContent = "Remove";

            const orderPrice = document.getElementById("order-price");
            orderPrice.textContent = `${order.totalAmount}`;

            const totalPrice = document.getElementById("total-price");
            totalPrice.textContent = `${order.totalAmount}`;

            const btncheckout = document.getElementById("checkout-btn");
            btncheckout.addEventListener("click", () => {
                createPayment(order)
            })

            course.appendChild(courseTitle);
            course.appendChild(courseInstruc);
            course.appendChild(coursePrice);
            card.appendChild(img);
            card.appendChild(course);
            card.appendChild(btnRemove);
            orderCard.appendChild(card);
            
        }; 
    } catch (error) {
        console.error("เกิดข้อผิดพลาดในการดึงข้อมูล:", error);
    }   
}

async function createPayment(order){
    const user = JSON.parse(localStorage.getItem("user"));
    console.log(`userid: ${user.userid}`);
    try {
        const response = await fetch(`http://localhost:8080/api/payment/${order.orderID}/${user.userid}`, {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            
            body: JSON.stringify({
                order: { id: order.orderID },
                user : { id: user.userid},
                amount : order.price
            })
        });

        if (!response.ok) {
            throw new Error(`HTTP error! status: ${response.status}`);
        }

        const paymentdata = await response.json(); // แปลง response เป็น JSON
        window.location.href = `payment.html?paymentID=${paymentdata.paymentID}`;
    } catch (error) {
        console.error("เกิดข้อผิดพลาดในการดึงข้อมูล:", error);
    }   

}