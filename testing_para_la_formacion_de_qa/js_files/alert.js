function alertDelayed() {
    document.getElementById("waitingMessage").innerHTML = "Espera 3 segundos...";
    setTimeout(function() {
        document.getElementById("waitingMessage").innerHTML = "Alert con retardo abierto. Esperando confirmación...";
    }, 2700);
    setTimeout(function() {
        if(!alert("Alert abierto tras 3 segundos de espera")) {
            document.getElementById("waitingMessage").innerHTML = "Alert con retardo cerrado.";
        }
    }, 3000);
}

function alertConfirm() {
    if (confirm("Alert de tipo confirm. Pulse 'Aceptar' o 'Cancelar'.") == true) {
    mensaje = "Has pulsado Aceptar.";
    } else {
    mensaje = "Has pulsado Cancelar.";
    }
    document.getElementById("confirmMessage").innerHTML = mensaje;
}

function alertPrompt() {
    var promptMessage = prompt("Comparta el mensaje que quiere transmitir:", "Quiero decir que...");
    /*switch (promptMessage) {
        case null:
            document.getElementById("promptBefore").innerHTML = "Qué lástima, no ha compartido ningún mensaje.";
            break;
        case "":
            document.getElementById("promptBefore").innerHTML = "Qué lástima, no ha compartido ningún mensaje.";
        default:
            document.getElementById("promptBefore").innerHTML = "Este es su mensaje:"
            document.getElementById("promptMessage").innerHTML = promptMessage
            document.getElementById("promptAfter").innerHTML = "¡Gracias por compartirlo!";
    }*/
    if (promptMessage) {
        document.getElementById("promptBefore").innerHTML = "Este es su mensaje:"
        document.getElementById("promptMessage").innerHTML = promptMessage
        document.getElementById("promptAfter").innerHTML = "¡Gracias por compartirlo!";
    } else {
        document.getElementById("promptBefore").innerHTML = "Qué lástima, no ha compartido ningún mensaje.";
        document.getElementById("promptMessage").innerHTML = "";
        document.getElementById("promptAfter").innerHTML = "";
    }

}