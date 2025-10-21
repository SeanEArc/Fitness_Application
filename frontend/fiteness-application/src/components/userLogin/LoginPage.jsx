import { fetchUserByUsername } from "../api/fetch";
import { useState } from "react";

const LoginPage = () => {

      const [username, setUsername] = useState('');
      const [password, setPassword] = useState('');
      const [error, setError] = useState(false);

      const handleLogin = async event => {
            event.preventDefault();

            const getUser = await fetchUserByUsername(username);

            console.log(getUser)

      }

      return (
            <div>

                  <h1> This is the login page </h1>

                  <form onSubmit={handleLogin} className="border"> 
                        <label>
                              <input
                              type="text"
                              value={username}
                              onChange={event => setUsername(event.target.value)}
                              placeholder="Enter Username"

                              className="border m-5"
                              ></input>
                        </label>

                        <label>
                              <input
                              type="text"
                              value={password}
                              onChange={event => setPassword(event.target.value)}
                              placeholder="****"
                              className="border m-5"
                              ></input>
                        </label>

                        <button
                        type="submit"
                        className=""> Login </button>

                  </form>
            </div>

      )

}

export default LoginPage;