document.addEventListener("DOMContentLoaded", async () => {
    const params = new URLSearchParams(window.location.search);
    const id = params.get("id");
    if (!id) return;

    const form = document.querySelector("form");

    try {
        const response = await fetch(`/api/residents/${id}`);
        if (!response.ok) throw new Error("Resident not found");
        const resident = await response.json();

        // Fill form fields
        document.querySelector("#input_lastname").value = resident.lastName || "";
        document.querySelector("#input_firstname").value = resident.firstName || "";
        document.querySelector("#input_middlename").value = resident.middleName || "";
        document.querySelector("#input_suffix").value = resident.suffix || "";
        document.querySelector("#select_sex").value = resident.sex || "";
        document.querySelector("#input_birthdate").value = resident.birthdate || "";
        document.querySelector("#input_status").value = resident.civilstatus || "";
        document.querySelector("#input_Sitio").value = resident.sitio || "";
        document.querySelector("#input_occupation").value = resident.occupation || "";
        document.querySelector("#input_contactnumber").value = resident.contactnumber || "";
        document.querySelector("#select_voterstatus").value = resident.voterstatus || "";
        document.querySelector("#input_email").value = resident.email || "";
        document.querySelector("#input_numberofhousehold").value = resident.household || "";
        document.querySelector("#input_religion").value = resident.religion || "";
        document.querySelector("#select_bloodtype").value = resident.bloodtype || "";
        document.querySelector("#input_education").value = resident.education || "";
        document.querySelector("#select_condition").value = resident.condition || "";
        document.querySelector("#seniorStatus").value = resident.senior || false;
        document.querySelector("#input-age").value = resident.age || "";
        document.querySelector("input[type=checkbox]").checked = resident.pwd || false;

        // Photo preview
        const photoPreview = document.getElementById("photoPreview");
        const img = document.createElement("img");
        img.src = `/api/residents/${id}/photo`;
        img.style = "width:100px;height:100px;object-fit:cover;border-radius:5px;";
        img.onerror = () => { img.src = "/Img/default-profile.jpg"; };
        photoPreview.innerHTML = "";
        photoPreview.appendChild(img);

    } catch (err) {
        console.error("Error loading resident:", err);
    }

    // Age calculation
    const birthInput = document.getElementById("input_birthdate");
    const ageInput = document.getElementById("input-age");
    const seniorInput = document.getElementById("seniorStatus");

    function calculateAge() {
        if (!birthInput.value) return;
        const birthdate = new Date(birthInput.value);
        const today = new Date();
        let age = today.getFullYear() - birthdate.getFullYear();
        const monthDiff = today.getMonth() - birthdate.getMonth();
        if (monthDiff < 0 || (monthDiff === 0 && today.getDate() < birthdate.getDate())) age--;
        ageInput.value = age;
        seniorInput.value = age >= 60 ? "true" : "false";
    }
    calculateAge();
    birthInput.addEventListener("change", calculateAge);

    // File preview
    const fileInput = document.getElementById('fileUpload');
    fileInput.addEventListener('change', function() {
        const file = this.files[0];
        if (file) {
            const reader = new FileReader();
            reader.onload = function(e) {
                photoPreview.innerHTML = '';
                const img = document.createElement('img');
                img.src = e.target.result;
                img.alt = 'Profile Preview';
                img.style.width = '100px';
                img.style.height = '100px';
                img.style.objectFit = 'cover';
                img.style.borderRadius = '5px';
                photoPreview.appendChild(img);
            };
            reader.readAsDataURL(file);
        } else {
            photoPreview.innerHTML = '<span>No Image</span>';
        }
    });

    // Submit edited data
    form.addEventListener("submit", async (e) => {
        e.preventDefault();
        const updatedResident = {
            lastName: document.querySelector("#input_lastname").value,
            firstName: document.querySelector("#input_firstname").value,
            middleName: document.querySelector("#input_middlename").value,
            suffix: document.querySelector("#input_suffix").value,
            sex: document.querySelector("#select_sex").value,
            birthdate: document.querySelector("#input_birthdate").value,
            civilstatus: document.querySelector("#input_status").value,
            sitio: document.querySelector("#input_Sitio").value,
            occupation: document.querySelector("#input_occupation").value,
            contactnumber: document.querySelector("#input_contactnumber").value,
            voterstatus: document.querySelector("#select_voterstatus").value,
            email: document.querySelector("#input_email").value,
            household: document.querySelector("#input_numberofhousehold").value,
            religion: document.querySelector("#input_religion").value,
            bloodtype: document.querySelector("#select_bloodtype").value,
            education: document.querySelector("#input_education").value,
            condition: document.querySelector("#select_condition").value,
            senior: document.querySelector("#seniorStatus").value === "true",
            pwd: document.querySelector("input[type=checkbox]").checked,
            age: parseInt(document.querySelector("#input-age").value)
        };

        try {
            const response = await fetch(`/api/residents/${id}`, {
                method: "PUT",
                headers: { "Content-Type": "application/json" },
                body: JSON.stringify(updatedResident)
            });

            if (response.ok) {
                alert("Resident updated successfully!");
                window.location.href = `/residentsinfo?id=${id}`;
            } else {
                alert("Failed to update resident.");
            }
        } catch (err) {
            console.error("Error updating resident:", err);
            alert("Error updating resident.");
        }
    });
});
