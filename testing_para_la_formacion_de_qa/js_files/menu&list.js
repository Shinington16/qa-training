const colorSelect = document.getElementById("colorSelect");
const bgColor = document.getElementById("bgColor");

colorSelect.addEventListener("change", function() {
    const selectedColor = colorSelect.value;
    bgColor.style.backgroundColor = selectedColor;
});

const textColorSelect = document.getElementById("textColorSelect");
const textColor = document.getElementById("textColor");

textColorSelect.addEventListener("change", function() {
    const selectedColor = textColorSelect.value;
    textColor.style.color = selectedColor;
});
