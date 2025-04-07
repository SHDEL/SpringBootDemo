window.onload = async function () {
    const params = new URLSearchParams(window.location.search);
    const courseID = params.get("courseID");
    console.log(courseID);
    await getCourse(courseID);
}
async function getCourse(courseID){
    try {
        const response = await fetch(`http://localhost:8080/api/course/${courseID}`);

        if (!response.ok) {
            throw new Error(`HTTP error! status: ${response.status}`);
        }

        const data = await response.json(); // แปลง response เป็น JSON
        console.log(data); // แสดงข้อมูลที่ดึงมาใน console

        // สมมุติว่าเราแสดง users ใน <ul id="userlist">
        const courseDetails = document.getElementById("course-details");
        

        // courseDetails.innerHTML = ""; // ล้างก่อนเพิ่มใหม่
        document.getElementById("course-title").textContent = data.title;
        document.getElementById("img-course").src = data.pictureURL;
        document.getElementById("course-price").textContent = `฿ ${data.price}`;
        document.getElementById("course-instructor").textContent = `Instructor: ${data.instructor.name}`;
        document.getElementById("course-description").textContent = data.description;
        

    } catch (error) {
        console.error("เกิดข้อผิดพลาดในการดึงข้อมูล:", error);
    }



}
  