
import { createRequestOptions } from "../functions/getToken.js";
export function getAllClients(token) {
    const requestOptions = createRequestOptions(token);
    console.log(requestOptions);
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

export function getClientById(token, clientId) {
  const requestOptions = createRequestOptions(token);
  return fetch(`http://localhost:8080/clients/findClientById/${clientId}`, requestOptions)
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

export function findClientsByCountry(token, country) {
  const requestOptions = createRequestOptions(token);
  return fetch(`http://localhost:8080/clients/findClientsByCountry/${country}`, requestOptions)
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

export function findClientsWithPaymentInAYear(token, year) {
  const requestOptions = createRequestOptions(token);
  return fetch(`http://localhost:8080/clients/findClientsWithPaymentInAYear/${year}`, requestOptions)
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

export function findClientsByCityAndSalesRep(token, city, salesRep1, salesRep2) {
  const requestOptions = createRequestOptions(token);
  return fetch(`http://localhost:8080/clients/findClientsByCityAndSalesRep/${city}/${salesRep1}/${salesRep2}`, requestOptions)
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

export function findAllClientsWithSalesReps(token) {
  const requestOptions = createRequestOptions(token);
  return fetch(`http://localhost:8080/clients/findAllClientsWithSalesRep`, requestOptions)
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

export function findAllClientsWithSalesRepIfPayment(token) {
  const requestOptions = createRequestOptions(token);
  return fetch(`http://localhost:8080/clients/findAllClientsWithSalesRepIfPayment`, requestOptions)
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

export function findAllClientsWithSalesRepWithoutPayment(token) {
  const requestOptions = createRequestOptions(token);
  return fetch(`http://localhost:8080/clients/findAllClientsWithSalesRepWithoutPayment`, requestOptions)
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

export function findAllClientsWithSalesRepAndOfficeIfPayment(token) {
  const requestOptions = createRequestOptions(token);
  return fetch(`http://localhost:8080/clients/findAllClientsWithSalesRepAndOfficeIfPayment`, requestOptions)
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

export function findAllClientsWithSalesRepAndOfficeWithoutPayment(token) {
  const requestOptions = createRequestOptions(token);
  return fetch(`http://localhost:8080/clients/findAllClientsWithSalesRepAndOfficeWithoutPayment`, requestOptions)
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

export function findAllClientsWithSalesRepAndOffice(token) {
  const requestOptions = createRequestOptions(token);
  return fetch(`http://localhost:8080/clients/findAllClientsWithSalesRepAndOffice`, requestOptions)
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

export function findClientsWithPendingOrdersLaterThanExpected(token) {
  const requestOptions = createRequestOptions(token);
  return fetch(`http://localhost:8080/clients/findClientsWithPendingOrdersLaterThanExpected`, requestOptions)
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

export function findClientsWithoutPayment(token) {
  const requestOptions = createRequestOptions(token);
  return fetch(`http://localhost:8080/clients/findClientsWithoutPayment`, requestOptions)
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

export function findClientsWithoutOrder(token) {
  const requestOptions = createRequestOptions(token);
  return fetch(`http://localhost:8080/clients/findClientsWithoutOrder`, requestOptions)
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

export function findClientsWithoutOrderOrWithoutPayment(token) {
  const requestOptions = createRequestOptions(token);
  return fetch(`http://localhost:8080/clients/findClientsWithoutOrderOrWithoutPayment`, requestOptions)
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

export function countByCountry(token) {
  const requestOptions = createRequestOptions(token);
  return fetch(`http://localhost:8080/clients/count-by-country`, requestOptions)
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

export function count(token) {
  const requestOptions = createRequestOptions(token);
  return fetch(`http://localhost:8080/clients/count`, requestOptions)
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

export function countInMadrid(token) {
  const requestOptions = createRequestOptions(token);
  return fetch(`http://localhost:8080/clients/count-in-madrid`, requestOptions)
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

export function countCitiesStartingWithM(token) {
  const requestOptions = createRequestOptions(token);
  return fetch(`http://localhost:8080/clients/count-cities-starting-with-m`, requestOptions)
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

export function withoutSalesRepresentative(token) {
  const requestOptions = createRequestOptions(token);
  return fetch(`http://localhost:8080/clients/without-sales-representative`, requestOptions)
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