document.getElementById("signup-form").addEventListener("submit", async function(e) {
    e.preventDefault();
    const username = document.getElementById("username").value;
    const name = document.getElementById("name").value;
    const email = document.getElementById("email").value;
    const password = document.getElementById("password").value;

    try {
      const response = await fetch("http://localhost:8080/api/users/signup", {
        method: "POST",
        headers: {
          "Content-Type": "application/json"
        },
        body: JSON.stringify({
          username: username,
          name: name,
          email: email,
          password: password
        })
      });

      if (!response.ok) throw new Error("สมัครไม่สำเร็จ");

      const data = await response.json();
      alert("สมัครสำเร็จ! กรุณา login");
      window.location.href = "login.html";
    } catch (err) {
      alert("เกิดข้อผิดพลาด: " + err.message);
    }
  });