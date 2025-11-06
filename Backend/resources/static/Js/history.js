document.addEventListener("DOMContentLoaded", loadHistory);
async function loadHistory() {
    try {
        const response = await fetch("/api/history");
        const historyList = await response.json();
        const boxInfo = document.querySelector('.historyList');
        boxInfo.innerHTML = '';

        if (historyList.length === 0) {
            const noData = document.createElement('p');
            noData.textContent = "No History";
            noData.classList.add("noHistory");
            boxInfo.append(noData);
            return;
        }

        historyList.forEach(entry => {
            const info = document.createElement('div');
            info.classList.add('historyInfo');
            info.textContent = entry.historyTable;
            boxInfo.append(info);
        });

    }catch (error) {
        console.error("Error", error);
    }

}
