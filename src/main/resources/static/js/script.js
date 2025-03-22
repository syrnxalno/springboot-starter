async function fetchData() {
    updateResponse("Fetching data..");
    try {
        const response = await fetch('/api/data'); 
        const data = await response.json(); 
        updateResponse(data);
    } catch (error) {
        updateResponse("Error fetching data: " + error);
    }
}

async function postData() {
    const userInput = document.getElementById("postInput").value; 
    if (!userInput.trim()) {
        updateResponse("Please enter a message before posting.");
        return;
    }

    updateResponse("Posting data...");
    
    try {
        const response = await fetch('/api/post', {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({ param: userInput }) //used param to match springboot's request
        });
        const data = await response.json();
        updateResponse(data);
    } catch (error) {
        updateResponse("Error posting data: " + error);
    }
}



async function systemInfo() {
    updateResponse("Fetching system info..");
    try {
        const response = await fetch('/api/system-info'); 
        const data = await response.json(); 
        updateResponse(data);
    } catch (error) {
        updateResponse("Error fetching system info: " + error);
    }
}

function updateResponse(data) {
    const responseElement = document.getElementById('apiResponse');
    
    if (typeof data === "string") {
        responseElement.textContent = data;
    } else {
        responseElement.textContent = JSON.stringify(data, null, 2); 
    }
}
