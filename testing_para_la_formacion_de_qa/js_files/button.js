function doubleClick() {
    document.getElementById("clickDoble").innerHTML = "¡Has hecho un doble click!";
}

function botonDinamico() {
    var contenedor = document.getElementById("contenedor");
    var id = Math.floor(Math.random() * 1000);
    var button = document.createElement("button");

    button.id = id;
    button.innerHTML = "Botón con id dinámico";

    contenedor.appendChild(button);
    button.addEventListener("click", function() {
        var p = document.getElementById("clickDinamico");
        p.innerHTML = "El id del botón es " + id;
    });
}

function botonRetardo() {
    document.getElementById("delayedButton").disabled = true;
    setTimeout(function() {
        var delayButton = document.getElementById("delayedButton");
        delayButton.disabled = false;
        delayButton.innerHTML = "&#x2714;&#xfe0f; Botón con retardo";
    }, 5000);
}

function botonInvisible() {
    document.getElementById("rightButton").hidden = false;
}

function rightClick() {
        event.preventDefault();
        document.getElementById("clickDerecho").innerHTML = "Has hecho click derecho en el botón";
}

