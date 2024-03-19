let register = document.querySelector("#register");
let loginContainer = document.querySelector("#login-register");
function showSuccessAlert(message) {
    Swal.fire({
        icon: 'success',
        title: 'Success!',
        text: message,
        confirmButtonColor: '#green',
        confirmButtonText: 'OK'
    }).then((result) => {
        if (result.isConfirmed) {
            window.location.href = 'login.html'; // Redirigir a la página de inicio de sesión
        }
    });
}

    // Change to register

register.addEventListener("click", async (e) => {
    e.preventDefault();
    loginContainer.innerHTML = "";
    loginContainer.insertAdjacentHTML("beforeend", `
        <div class="login-content">
            <div class="login-content_header" id="registerForm">
                <span class="logo">
                    <box-icon type='solid' name='landscape' color="#87A922"></box-icon> Land Scape
                </span>
                <h2>Register</h2>
            </div>
            <div>
                <form class="login-form" id="registerForm">
                    <input type="email" placeholder="email">
                    <input type="password" placeholder="password">
                    <input type="submit">
                </form>
                <div class="login-netoworks">
                    <p>Have an account? <a href="" id="loginAgain">Login</a></p>
                    <div class="login-or"><hr /></div>
                </div>
            </div>
        </div>
        <div class="login-footer">
            <p>Terms of use | Privacy policy</p>
        </div>
    `);
});

document.addEventListener("DOMContentLoaded", async () => {


    //register a user and login
    let loginRegister = document.querySelector(".login-form");
    loginRegister.addEventListener("submit", async (e) => {
        e.preventDefault();
        const form = e.target;
        if (form.id === "registerForm") {
            try {
                console.log("Register form submitted");
                const email = form.querySelector("input[type='email']").value;
                const password = form.querySelector("input[type='password']").value;
                const data = {
                    "email":email,
                    "password":password
                }
                
                const response = await fetch("http://localhost:8080/admin/save", {
                    method: "POST",
                    headers: {
                        "Content-Type": "application/json"
                    },
                    body: JSON.stringify(data)
                });
                const result = await response.json();
                console.log(result);
                showSuccessAlert('User registered successfully');
                
            } catch (error) {
                console.error(error);
                showSuccessAlert('Error while registering user:' + error.message);
            }
        }

        // login a user

        if (form.id === "loginForm") {
            const email = form.querySelector("input[type='email']").value;
            const password = form.querySelector("input[type='password']").value;
            const url = `http://localhost:8080/login?email=${encodeURIComponent(email)}&password=${encodeURIComponent(password)}`;
        
            try {
                const response = await fetch(url, {
                    method: "POST",
                    headers: {
                        "Content-Type": "application/json"
                    }
                });
        
                if (!response.ok) {
                    throw new Error("Error fetching data");
                }
        
                const result = await response.json();
                console.log(result);
                showSuccessAlert('User logged in successfully');
            } catch (error) {
                console.error(error);
                showSuccessAlert('Error logging in user');
            }
        }
        

    });


});
