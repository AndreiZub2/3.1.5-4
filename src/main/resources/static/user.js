const userUrl = 'http://localhost:8091/page';


function getPage() {
    fetch(userUrl).then(response => response.json()).then(user =>
        getInformation(user))
}

function getInformation(user) {

    document.getElementById('basicTable').innerHTML = `<tr>
            <td>${user.id}</td>
            <td>${user.name}</td>
            <td>${user.lastname}</td>
            <td>${user.age}</td>
            <td>${user.roles.map(r => r.roles)}</td>
         
        </tr>`;

}

getPage();