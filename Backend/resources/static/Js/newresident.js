document.addEventListener("DOMContentLoaded", () => {
  const form = document.querySelector("form");

  form.addEventListener("submit", (event) => {
    const firstName = form.querySelector("input[name='firstname']").value.trim();
    const lastName = form.querySelector("input[name='lastname']").value.trim();
    const age = form.querySelector("input[name='age']").value.trim();

    if (firstName === "" || lastName === "" || age === "") {
      event.preventDefault();
      alert("Please fill out all required fields!");
      return;
    }

    if (isNaN(age) || age <= 0) {
      event.preventDefault();
      alert("Age must be a positive number");
      return;
    }

    alert("Saved");
  });
});

const cancelButton = document.querySelector(".cancel");
if (cancelButton) {
  cancelButton.addEventListener("click", (e) => {
    if (!confirm("Are you sure you want to clear?")) {
      e.preventDefault();
    }
  });
}

document.addEventListener("DOMContentLoaded", () => {
  const birthInput = document.getElementById("input_birthdate");
  const ageInput = document.getElementById("input-age");
  const seniorInput = document.getElementById("seniorStatus");

  birthInput.addEventListener("change", () => {
    const birthdate = new Date(birthInput.value);
    const today = new Date();
    let age = today.getFullYear() - birthdate.getFullYear();
    const monthDiff = today.getMonth() - birthdate.getMonth();

    if (monthDiff < 0 || (monthDiff === 0 && today.getDate() < birthdate.getDate())) {
      age--;
    }

    ageInput.value = age;
    seniorInput.value = age >= 60 ? "true" : "false";
  });
});

const fileInput = document.getElementById('fileUpload');
const photoPreview = document.getElementById('photoPreview');

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

document.addEventListener('DOMContentLoaded', function() {
  const select = document.getElementById("select_suffix");
  select.addEventListener('change', function() {
    if (select.value === "Other") {
      const input = document.createElement("input");
      input.type = "text";
      input.name = "suffix";
      input.id = "select_suffix";
      input.placeholder = "Specify suffix";
      input.required = true;
      const style = window.getComputedStyle(select);
      input.style.width = style.width;
      input.style.height = style.height;
      input.style.padding = style.padding;
      input.style.fontSize = style.fontSize;
      input.style.fontFamily = style.fontFamily;
      input.style.border = style.border;
      input.style.boxSizing = "border-box";
      select.parentNode.replaceChild(input, select);
      input.focus();
      input.addEventListener('blur', () => {
        if (input.value.trim() === "") {
          select.value = "Select";
          input.parentNode.replaceChild(select, input);
        }
      });
    }
  });
});

document.addEventListener('DOMContentLoaded', function() {
  const select = document.getElementById("select_religion");
  select.addEventListener('change', function() {
    if (select.value === "Other") {
      const input = document.createElement("input");
      input.type = "text";
      input.name = "religion";
      input.id = "select_religion";
      input.placeholder = "Specify religion";
      input.required = true;
      const style = window.getComputedStyle(select);
      input.style.width = style.width;
      input.style.height = style.height;
      input.style.padding = style.padding;
      input.style.fontSize = style.fontSize;
      input.style.fontFamily = style.fontFamily;
      input.style.border = style.border;
      input.style.boxSizing = "border-box";
      select.parentNode.replaceChild(input, select);
      input.focus();
      input.addEventListener('blur', () => {
        if (input.value.trim() === "") {
          select.value = "Select";
          input.parentNode.replaceChild(select, input);
        }
      });
    }
  });
});

document.addEventListener('DOMContentLoaded', function() {
  const select = document.getElementById("select_educationalattainment");
  select.addEventListener('change', function() {
    if (select.value === "Other") {
      const input = document.createElement("input");
      input.type = "text";
      input.name = "education";
      input.placeholder = "Specify Educational Attainment";
      input.required = true;
      const style = window.getComputedStyle(select);
      input.style.width = style.width;
      input.style.height = style.height;
      input.style.padding = style.padding;
      input.style.fontSize = style.fontSize;
      input.style.fontFamily = style.fontFamily;
      input.style.border = style.border;
      input.style.boxSizing = style.boxSizing;
      input.style.margin = style.margin;
      input.style.display = style.display;
      input.style.verticalAlign = style.verticalAlign;
      select.parentNode.replaceChild(input, select);
      input.focus();
      input.addEventListener('blur', () => {
        if (input.value.trim() === "") {
          select.value = "Select";
          input.parentNode.replaceChild(select, input);
        }
      });
    }
  });
});

document.addEventListener("DOMContentLoaded", () => {
  const ageInput = document.getElementById("input-age");
  const conditionSelect = document.getElementById("select_condition");
  if (!conditionSelect.value) {
    conditionSelect.value = "Alive";
  }
  ageInput.addEventListener("input", () => {
    const age = parseInt(ageInput.value);
    if (!isNaN(age)) {
      if (age >= 120) {
        conditionSelect.value = "Deceased";
      } else {
        conditionSelect.value = "Alive";
      }
    }
  });
});
