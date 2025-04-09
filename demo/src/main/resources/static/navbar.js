// ดึงข้อมูลผู้ใช้จาก localStorage
const user = JSON.parse(localStorage.getItem("user"));

if (user) {
    // แสดงชื่อผู้ใช้บน navbar
    document.getElementById("profile-img").src = 'https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460_960_720.png'; // หรือ user.pictureURL
    document.getElementById("navbar-user-profile").style.display = "block"; // แสดงรูปโปรไฟล์
    document.getElementById("navbar-login").style.display = "none";  // ซ่อนปุ่ม login
    document.getElementById("navbar-signup").style.display = "none"

} else {
    document.getElementById("navbar-user-profile").style.display = "none"; // ซ่อนรูปโปรไฟล์
    document.getElementById("navbar-login").style.display = "";  // แสดงปุ่ม login
}
