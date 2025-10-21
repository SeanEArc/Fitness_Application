



export async function fetchGetUsers(url) {
      const response = await fetch("http://localhost:8080/api/users", {
            method:'GET',
            headers: {
                  'Content-Type': 'application/json',
            },
      })
}

export async function fetchUserByUsername(username) {
      const response = await fetch(`http://localhost:8080/api/users/username/${username}`, {
            method: 'GET',
            headers: {
                  'Content-Type' : 'application/json',
            },
      })

      if (!response.ok){
            throw new Error(`Fetch failed: ${response.status}`)
      }

      const data = await response.json();
      return data;

}