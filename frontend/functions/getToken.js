export function getToken() {
    const token = sessionStorage.getItem("jwtToken");
    if (token) {
        return token;
    } else {
        return null;
    }
}