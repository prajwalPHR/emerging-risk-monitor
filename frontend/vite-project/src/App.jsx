import { useState } from "react";
import api from "./services/api";

function App() {

    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");

    const login = async () => {

        try {

            const response = await api.post(
                "/api/auth/login",
                {
                    username,
                    password
                }
            );

            console.log(response.data);

localStorage.setItem(
    "token",
    response.data.token || response.data
);

            alert("Login Successful");

            console.log(response.data);

        } catch (error) {

            alert("Login Failed");
        }
    };

    return (

        <div>

            <h1>Emerging Risk Monitor</h1>

            <input
                placeholder="Username"
                onChange={(e) =>
                    setUsername(e.target.value)
                }
            />

            <br /><br />

            <input
                type="password"
                placeholder="Password"
                onChange={(e) =>
                    setPassword(e.target.value)
                }
            />

            <br /><br />

            <button onClick={login}>
                Login
            </button>

        </div>
    );
}

export default App;