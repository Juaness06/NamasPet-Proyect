document.addEventListener("DOMContentLoaded", () => {
  const flechaI = document.querySelector(".btn-left");
  const flechaR = document.querySelector(".btn-right");
  const slider = document.querySelector("#slider");
  const sliderSection = document.querySelectorAll(".slider-section");
  const nombrePerrito = document.getElementById("nombrePerrito");
  const testimonioPerrito = document.getElementById("testimonioPerrito");

  const testimonios = [
    {
      nombre: "MANOLO",
      texto:
        "''Hola soy Manolo! Un día me sentí super enfermo mis dueños me llevaron a NamasPet y me cuidaron muy bien''",
    },
    {
      nombre: "OSQUITAR",
      texto:
        "''Antes le tenía miedo al veterinario en NamasPet no puedo estar más contento'' ",
    },
    {
      nombre: "PEPE",
      texto: "''Me llamo Pepe, y quiero mucho a mi doctora, me cuidó muy bien''",
    },
    {
      nombre: "COCCO",
      texto: "''Me llamo Cocco, y me encanta ir a NamasPet, me siento muy bien''",
    },
  ];

  let currentSlide = 0;

  flechaI.addEventListener("click", (e) => moveToLeft());
  flechaR.addEventListener("click", (e) => moveToRight());

  let operacion = 0,
    counter = 0,
    widthImg = 100 / sliderSection.length;

  function updateTestimonio(index) {
    nombrePerrito.innerHTML = testimonios[index].nombre;
    testimonioPerrito.innerHTML = testimonios[index].texto;
  }

  function moveToRight() {
    if (counter >= sliderSection.length - 1) {
      counter = 0; // Reinicia el contador
      operacion = 0;
    } else {
      counter++;
      operacion = operacion + widthImg;
    }
    slider.style.transform = `translate(-${operacion}%)`;
    slider.style.transition = "all ease .6s";
    updateTestimonio(counter); // Asegúrate de que esta línea esté fuera del if para que se ejecute siempre
  }
  
  function moveToLeft() {
    if (counter <= 0) {
      counter = sliderSection.length - 1; // Establece el contador al último elemento
      operacion = widthImg * counter;
    } else {
      counter--;
      operacion = operacion - widthImg;
    }
    slider.style.transform = `translate(-${operacion}%)`;
    slider.style.transition = "all ease .6s";
    updateTestimonio(counter); // Asegúrate de que esta línea esté fuera del if para que se ejecute siempre
  }

  function changeSlide(direction) {
    currentSlide += direction;
    if (currentSlide >= sliderSection.length) {
      currentSlide = 0;
    } else if (currentSlide < 0) {
      currentSlide = sliderSection.length - 1;
    }
    const offset = currentSlide * -100;
    slider.style.transform = `translateX(${offset}%)`;
    updateTestimonio(currentSlide);
  }

  updateTestimonio(0);
});
