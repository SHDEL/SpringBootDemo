
fetch('http://localhost:8080/api/userinfo')

    .then(response => response.json())
    .then(data => {
        console.log(data);
        const list = document.getElementById('userlist');
        data.forEach(user => {
            const li = document.createElement('li');
            li.textContent = `ID: ${user.id} | Name: ${user.name} | Email: ${user.email} | Password: ${user.passwd} | UserType: ${user.type}`
            list.appendChild(li);
        });
    });
