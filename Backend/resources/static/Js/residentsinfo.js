

const residentDataInfo = [
  {
    firstName: "sing",
    lastName: "vi",
    age:"15",
    sitio:"bohol",
    occupation:"rider",
    voterStatus:"Registered",
    householdMembers:"19",
    birthDate:"08/23/2004",
    civilStatus:"single",
    contact:"secret",
    bloodType:"O",
    email:"howow@gmail.com",
    educationalAttainment:"NOtDone",
    religion:"catholic",
    PWD:"Idunno",
    suffix:"N\A",
    picture: "https://cdn-icons-png.flaticon.com/128/346/346167.png",
  },
];


const pageQueryString = window.location.search;
const parsedQuery = new URLSearchParams(pageQueryString);
const urlQuery = parsedQuery.get('id');

const residentId = parseInt(urlQuery, 10);


async function getResidentInfo(residentId) {
  try {
    const response = await fetch(`local:host/hereputthelocalhost/resident/${residentId}`);
    if(!response.ok) throw new Error("Resident Not Found");
    const residentInfo = await response.json();
    displayResidentHeaderInfo(residentInfo);
    displayResidentLowerInfo(residentInfo);
  } catch(error) {

    console.error(error);
    alert(Resident Not Found!); // ge tangtang nakong double quotation kay sigig alert, samok

    if(document.referrer) {
      history.back();
    } else {
       window.location.href = "index.html";
    }
  }
}

getResidentInfo(residentId);




function displayResidentHeaderInfo (resident) {

  const photo = document.getElementById('residentPhoto');
  photo.src = resident.picture;
  photo.alt = `${resident.firstName} ${resident.lastName}`;

  const residentsHeader = document.querySelector('.residentHeaderInfo');
  residentsHeader.innerHTML = '';

  const name = document.createElement('div');
  name.classList.add('residentName');
  name.textContent = `${resident.firstName} ${resident.lastName}`;


  const address_age = document.createElement('div');
  address_age.classList.add('residentAddressAge');
  address_age.textContent = `${resident.sitio} ${resident.age}`;


  const occupation = document.createElement('div');
  occupation.classList.add('residentOccupation');
  occupation.textContent = `${resident.occupation}`;


 residentsHeader.append(name, address_age, occupation)
}

displayResidentHeaderInfo(residentDataInfo[0]);


function displayResidentLowerInfo(resident) {

  const residentSitio = document.getElementById('residentSitio')
  residentSitio.innerHTML = '';

  const sitio = document.createElement('div');
  sitio.textContent =`${resident.sitio}`;

  residentSitio.appendChild(sitio);


  const residentVoterStatus = document.getElementById('residentVoterStatus');
  residentVoterStatus.innerHTML ='';

  const voterStatus = document.createElement('div');
  voterStatus.textContent = `${resident.voterStatus}`;

  residentVoterStatus.appendChild(voterStatus);


  const residentBirthDate = document.getElementById('residentBirthDate');
  residentBirthDate.innerHTML ='';

  const birthDate = document.createElement('div');
  birthDate.textContent = `${resident.birthDate}`;

  residentBirthDate.appendChild(birthDate);


  const residentCivilStatus = document.getElementById('residentCivilStatus');
  residentCivilStatus.innerHTML ='';

  const civilStatus = document.createElement('div');
  civilStatus.textContent = `${resident.civilStatus}`;

  residentCivilStatus.appendChild(civilStatus);


  const residentHouseholdMembers = document.getElementById('residentHouseholdMembers');
  residentHouseholdMembers.innerHTML='';

  const householdMembers = document.createElement('div');
  householdMembers.textContent = `${resident.householdMembers}`;

  residentHouseholdMembers.appendChild(householdMembers);


  const residentContact = document.getElementById('residentContact');
  residentContact.innerHTML ='';

  const contact = document.createElement('div');
  contact.textContent = `${resident.contact}`;

  residentContact.appendChild(contact);


  const residentBloodType = document.getElementById('residentBloodType');
  residentBloodType.innerHTML ='';

  const bloodType = document.createElement('div');
  bloodType.textContent = `${resident.bloodType}`;

  residentBloodType.appendChild(bloodType);


  const residentEmail = document.getElementById('residentEmail');
  residentEmail.innerHTML ='';

  const email = document.createElement('div');
  email.textContent = `${resident.email}`;

  residentEmail.appendChild(email);


  const residentEducationalAttainment = document.getElementById('residentEducationalAttainment');
  residentEducationalAttainment.innerHTML ='';

  const educationalAttainment = document.createElement('div');
  educationalAttainment.textContent = `${resident.educationalAttainment}`;

  residentEducationalAttainment.appendChild(educationalAttainment);


  const residentReligion = document.getElementById('residentReligion');
  residentReligion.innerHTML ='';

  const religion = document.createElement('div');
  religion.textContent = `${resident.religion}`;

  residentReligion.appendChild(religion);


  const residentPWD = document.getElementById('residentPWD');
  residentPWD.innerHTML ='';

  const PWD = document.createElement('div');
  PWD.textContent = `${resident.PWD}`;

  residentPWD.appendChild(PWD);


  const residentSuffix = document.getElementById('residentSuffix');
  residentSuffix.innerHTML ='';

  const suffix = document.createElement('div');
  suffix.textContent = `${resident.suffix}`;

  residentSuffix.appendChild(suffix);


}

displayResidentLowerInfo(residentDataInfo[0]);
