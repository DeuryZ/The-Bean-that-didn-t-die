export function getToken() {
    const token = sessionStorage.getItem("jwtToken");
    if (token) {
        return token;
    } else {
        return null;
    }
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