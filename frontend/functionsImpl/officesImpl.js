let getCodeAndCityFromOfficesBtn = document.querySelector('#getCodeAndCityFromOffices');

getCodeAndCityFromOfficesBtn.addEventListener('click', async (e) => {
    e.preventDefault();
    if(getToken()) {
        let codeAndCity = await getCodeAndCityFromOffices(getToken());
        contentData.innerHTML = "";
        codeAndCity.forEach((element) => {
            console.log(element);
            contentData.insertAdjacentHTML("beforeend", `
            <div class="card">
                <div class="head">
                    <div>
                        <i class="bx bx-desktop"></i>
                        <h2>${element[0]}</h2>
                        <p>${element[1]}</p>
                    </div>
                </div>
            </div>
            `)
        })
    }else {
        console.log("No hay token");
    }
})

let getCityAndNumberByCountryBtn = document.querySelector('#getCityAndNumberByCountry');

getCityAndNumberByCountryBtn.addEventListener('click', async (e) => {
    e.preventDefault();
    
    if(getToken()) {

        let cityAndNumber = await getCityAndNumberByCountry(getToken(), country);
    }
})