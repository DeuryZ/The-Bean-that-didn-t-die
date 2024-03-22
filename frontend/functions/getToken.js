export function getToken() {
    try{
      const token = sessionStorage.getItem("jwtToken");
      if (token) {
        return token;
    } else {
        return null;
    }
    }catch(err)
    {console.log(err);}

}

export function createRequestOptions(token) {
    return {
      method: "GET",
      headers: {
        "Content-Type": "application/json",
        Authorization: `Bearer ${token}`,
      },
    }
}