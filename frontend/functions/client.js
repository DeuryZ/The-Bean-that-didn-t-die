export function getAllClients(token) {
    const requestOptions = {
        method: "GET",
        headers: {
          "Content-Type": "application/json",
          Authorization: `Bearer ${token}`,
        },
    }
        return fetch("http://localhost:8080/clients/all", requestOptions)
          .then((response) => {
            if (!response.ok) {
              throw new Error("Error al ejecutar la solicitud");
            }
            return response.json();
          })
          .catch((error) => {
            console.error("Error:", error);
            throw error;
          });    
}