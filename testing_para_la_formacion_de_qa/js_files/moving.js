dragElement(document.getElementById("containerDiv"));

function dragElement(elmnt) {
  var pos1 = 0, pos2 = 0, pos3 = 0, pos4 = 0;
  if (document.getElementById("movingDiv")) {
    document.getElementById("movingDiv").onmousedown = dragMouseDown;
  } else {
    elmnt.onmousedown = dragMouseDown;
  }

  function dragMouseDown(e) {
    e = e || window.event;
    e.preventDefault();

    pos3 = e.clientX;
    pos4 = e.clientY;
    document.onmouseup = closeDragElement;
    document.onmousemove = elementDrag;
  }

  function elementDrag(e) {
    e = e || window.event;
    e.preventDefault();

    pos1 = pos3 - e.clientX;
    pos2 = pos4 - e.clientY;
    pos3 = e.clientX;
    pos4 = e.clientY;

    elmnt.style.top = (elmnt.offsetTop - pos2) + "px";
    elmnt.style.left = (elmnt.offsetLeft - pos1) + "px";
  }

  function closeDragElement() {
    document.onmouseup = null;
    document.onmousemove = null;
  }
}









const list = document.querySelector('.list')

// let dragIndex, dragSource

const getMouseOffset = (evt) => {
  const targetRect = evt.target.getBoundingClientRect()
  const offset = {
    x: evt.pageX - targetRect.left,
    y: evt.pageY - targetRect.top
  }
  return offset
}

const getElementVerticalCenter = (el) => {
  const rect = el.getBoundingClientRect()
  return (rect.bottom - rect.top) / 2
}

const appendPlaceholder = (evt, idx) => {
  evt.preventDefault()
  if (idx === dragIndex) {
    return
  }
  
  const offset = getMouseOffset(evt)
  const middleY = getElementVerticalCenter(evt.target)
  const placeholder = list.children[dragIndex]
  
  // console.log(`hover on ${idx} ${offset.y > middleY ? 'bottom half' : 'top half'}`)
  if (offset.y > middleY) {
    list.insertBefore(evt.target, placeholder)
  } else if (list.children[idx + 1]) {
    list.insertBefore(evt.target.nextSibling || evt.target, placeholder)
  }
  return
}


function sortable(rootEl, onUpdate) {
   var dragEl;
   
   // Making all siblings movable
   [].slice.call(rootEl.children).forEach(function (itemEl) {
       itemEl.draggable = true;
   });
   
   // Function responsible for sorting
   function _onDragOver(evt) {
       evt.preventDefault();
       evt.dataTransfer.dropEffect = 'move';
      
       var target = evt.target;
       if (target && target !== dragEl && target.nodeName == 'DIV') {
           // Sorting
       const offset = getMouseOffset(evt)
       const middleY = getElementVerticalCenter(evt.target)

      if (offset.y > middleY) {
        rootEl.insertBefore(dragEl, target.nextSibling)
      } else {
        rootEl.insertBefore(dragEl, target)
      }
     }
   }
   
   // End of sorting
   function _onDragEnd(evt){
       evt.preventDefault();
      
       rootEl.removeEventListener('dragover', _onDragOver, false);
       rootEl.removeEventListener('dragend', _onDragEnd, false);


       // Notification about the end of sorting
       onUpdate(dragEl);
   }
   
   // Sorting starts
   rootEl.addEventListener('dragstart', function (evt){
       dragEl = evt.target; // Remembering an element that will be moved
       
       // Limiting the movement type
       evt.dataTransfer.effectAllowed = 'move';
       evt.dataTransfer.setData('Text', dragEl.textContent);


       // Subscribing to the events at dnd
       rootEl.addEventListener('dragover', _onDragOver, false);
       rootEl.addEventListener('dragend', _onDragEnd, false);


   }, false);
}
                       
// Using                    
sortable(list, function (item) {
   console.log(item);
});