document.getElementById('loginForm').addEventListener('submit', async function(event) {
    event.preventDefault(); // Prevent form from submitting normally

    const email = document.getElementById('email').value;
    const password = document.getElementById('password').value;

    // const formData = new FormData();
    // formData.append('email', email);
    // formData.append('password', password);

    const loginData = {
        email: email,
        password: password
    };
    try {
        const response = await fetch('http://localhost:8080/api/users', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(loginData),
        });

        if (!response.ok) {
            throw new Error('Login failed');
        }

        const data = await response.json();
        console.log('Login successful:', data);
        localStorage.setItem("user", JSON.stringify(data));
        // Redirect to another page (e.g., home or dashboard)
        window.location.href = 'index.html';  // or any page you want to navigate to after login

    } catch (error) {
        console.error('Error:', error);
        document.getElementById('error-message').style.display = 'block'; // Show error message
    }
});