//here is where to put the json file about the residents record
const residentsList = [
  {
  lastName:"Sing",
  firstName:"Javi",
  address:"Ginatilan",
  id:112312,
  age:16,
},
{
  lastName:"ding",
  firstName:"risl",
  address:"argao",
  id:"2",
  age:17,
},
{
  lastName:"pimentl",
  firstName:"jaym",
  address:"mal",
  id:"3",


},
  ];

function renderResidents (residentsData) {
  const boxInfo = document.querySelector('.residentsList');
  boxInfo.innerHTML='';

  residentsData.forEach(resident => {

    const info = document.createElement('div');
    info.classList.add('residentsInfo');

    //Here we put where to see more about the residents info
    info.addEventListener("click", () => {
      window.location.href = `residentsInfo.html?id = ${resident.id}`;
    });

    const name = document.createElement('div');
    name.classList.add('residentsName');
    name.textContent = ` ${resident.firstName} ${resident.lastName} `;

    const address= document.createElement('div');
    address.classList.add('residentsAddress');
    address.textContent = `address: ${resident.address} - age: ${resident.age}`;

    const id = document.createElement('div');
    id.classList.add('residentsId');
    id.textContent =`${resident.id}`;

    const infoLeft = document.createElement('div');
    infoLeft.append(name, address);

    info.append(infoLeft, id);

    boxInfo.append(info);

  });
}

//displaying the residents info
renderResidents(residentsList);



//searching for a specific residents record
const searchInput = document.querySelector('.search');
const searchButton = document.querySelector('.serbot');

searchInput.addEventListener('input', search);
searchButton.addEventListener('click', search);

async function search () {
  const showResidents = searchInput.value.trim().toLowerCase();

  if(showResidents === "") {
    renderResidents(residentsList);
    return;
  }

  try {
    const url = showResidents ? `/find?showResidents = ${encodeURIComponent(showResidents)}` : '/find';
    const response = await fetch(url);
    const data = await response.json();
    renderResidents(data);
  } catch (error) {
    console.error("ERROR : ", error);
  }


}
                        
