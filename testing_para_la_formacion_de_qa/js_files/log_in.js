function generarContrasena() {
    let userArray = ["form&radio", "button", "dinamicElements", "modalWindow", "alertWindow", "menu&list", "otherInput", "movingElements"];
    let passArray = ["form1234", "button1234", "dinamic1234", "modal1234", "alert1234", "menu1234", "input1234", "moving1234"];

    const userSelect = document.getElementById("userSelect");
    const passGenerated = document.getElementById("passGenerated");

    passGenerated.innerHTML = passArray[userArray.indexOf(userSelect.value)];
}