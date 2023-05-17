window.onload=function(){

  const target = document.getElementById("carga");
  const tooltip = document.getElementById("tooltip-text");
  
  target.addEventListener('mouseover', () => {
    tooltip.style.display = 'block';
    if (target.textContent == "100%") {
      tooltip.innerText = "Carga completa";
    } else {
        tooltip.innerText = "Porcentaje de carga: " + target.textContent;
    }
  }, false);
  
  target.addEventListener('mouseleave', () => {
    tooltip.style.display = 'none';
  }, false);

  const output_target = document.getElementById("output");
  const tooltip_value = document.getElementById("tooltip-value");
  
  output_target.addEventListener('mouseover', () => {
    tooltip_value.style.display = 'block';
    if (output_target.textContent == "100") {
      tooltip_value.innerText = "Valor máximo";
    }
    else if (output_target.textContent == "0") {
      tooltip_value.innerText = "Valor mínimo";
    }else {
      tooltip_value.innerText = "Valor actual: " + output_target.textContent;
    }
  }, false);
  
  output_target.addEventListener('mouseleave', () => {
    tooltip_value.style.display = 'none';
  }, false);
}

var i = 0;
function move() {
    var elem = document.getElementById("myBar");
    var width = 1;
    var speed = setInterval(frame, 30);
    function frame() {
      if (width == 100) {
        clearInterval(speed);
      } else {
        width++;
        elem.style.width = width + "%";
        document.getElementById("carga").innerHTML = width + "%";
        if (width >= 30 && width < 60) {
          clearInterval(speed);
          speed = setInterval(frame, 90);
        }else if (width >= 60 && width < 90) {
          clearInterval(speed);
          speed = setInterval(frame, 180);
        }
        else if (width >= 90) {
          clearInterval(speed);
          speed = setInterval(frame, 540);
        }
      }
    }
  }

var output = document.getElementById("output");
var slider = document.getElementById("slider").oninput = function() {
  var value = (this.value-this.min);
  this.style.background = "linear-gradient(to right, #6b8dff 0%, #ff2a5f " + value + "%, #111111 " + value + "%, #fff 100%)"
  output.innerHTML = this.value;
}

