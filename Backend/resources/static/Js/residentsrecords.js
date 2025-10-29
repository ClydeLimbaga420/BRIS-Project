function searchName() {
      const input = document.getElementById('search').value.toLowerCase();
      const names = document.querySelectorAll('#nameList li');
      let found = false;

      names.forEach(name => {
        const text = name.textContent.toLowerCase();
        if (text.includes(input)) {
          name.style.display = '';
          found = true;
        } else {
          name.style.display = 'none';
        }
      });

      document.getElementById('noResult').style.display = found ? 'none' : 'block';
    }

    // Optional: allow searching while typing
    document.getElementById('search').addEventListener('input', searchName);