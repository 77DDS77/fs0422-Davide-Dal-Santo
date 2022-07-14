

// let rightArrow = document.querySelector('.control-right');

// rightArrow.addEventListener('click', moveLeft)

// let leftArrow = document.querySelector('.control-left');

// leftArrow.addEventListener('click', moveRight)

// // ArrowRight e Left il nome lo abbiamo torvato facendo 
// //console log di event
// document.addEventListener('keyup',function(event){
//     if(event.key == 'ArrowRight'){
//         moveLeft();
//     }
//     if(event.key == 'ArrowLeft'){
//         moveRight();
//     }

// })


let sliders = document.querySelectorAll('.slider');

sliders.forEach(function(slider){
    let leftArrow = slider.querySelector('.control-left');
    let rightArrow = slider.querySelector('.control-right'); 

    leftArrow.addEventListener('click', function(){
        moveRight(slider);
    });

    rightArrow.addEventListener('click', function(){
        moveLeft(slider);
    });
    
})










function moveLeft(slider){
    let left = 0;
    let allSlides = slider.querySelectorAll('.wrapper img')
    let firstSlideWidth = allSlides[0].clientWidth;
    let sliderWidth = slider.clientWidth;
    let space = Math.trunc(sliderWidth / firstSlideWidth) * firstSlideWidth;

    let wrapper = slider.querySelector('.wrapper');
    console.log(space);

    if(left < allSlides.length * firstSlideWidth - space){
        left += space;
    }else{
        left = 0;
    };
    

    wrapper.style.marginLeft = - left + 'px';

}
function moveRight(slider){
    let left = 0;
    let allSlides = slider.querySelectorAll('.wrapper img')
    let firstSlideWidth = allSlides[0].clientWidth;
    let sliderWidth = slider.clientWidth;
    let space = Math.trunc(sliderWidth / firstSlideWidth) * firstSlideWidth;

    let wrapper = slider.querySelector('.wrapper');
    console.log(space);

    if(left > 0 ){
        left -= space;
    }else{
        left = allSlides.length * firstSlideWidth - space;
    };
    

    wrapper.style.marginLeft = - left + 'px';

}