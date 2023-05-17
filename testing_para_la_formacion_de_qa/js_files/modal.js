var modalWindow = document.getElementById("modalWindow");
var modalButton = document.getElementById("modalButton");
var modalClose = document.getElementById("modalClose");

modalButton.onclick = function() {
  modalWindow.style.display = "block";
}
modalClose.onclick = function() {
  modalWindow.style.display = "none";
}

window.onclick = function(event) {
  if (event.target == modalWindow) {
    modalWindow.style.display = "none";
  }
}

var secondModalWindow = document.getElementById("secondModalWindow");
var secondModalButton = document.getElementById("secondModalButton");
var secondModalClose = document.getElementById("secondModalClose");

secondModalButton.onclick = function() {
  secondModalWindow.style.display = "block";
}
secondModalClose.onclick = function() {
  secondModalWindow.style.display = "none";
}
window.onclick = function(event) {
  if (event.target == secondModalWindow) {
    secondModalWindow.style.display = "none";
  }
}

function newWindow() {
  window.open("./redirection.html", "_blank", "top=50, left=50, width=600, height=450");
}

function newTab() {
    window.open("./redirection.html");
}

function windowMessage() {
    window.open("Titulo de la ventana", "MsgWindow", "top=80, left=80, width=500,height=200")
    .document.write("Este mensaje aparece en una ventana nueva, sin título ni url.")
}